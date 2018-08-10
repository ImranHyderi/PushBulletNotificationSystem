package com.bbc.notification.imran.Rest;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bbc.notification.imran.Exception.CustomErrorType;
import com.bbc.notification.imran.dto.UserDTO;
import com.bbc.notification.imran.repository.UserJpaRepository;

/**
 * A resource controller handling requests for users and notifications.
 * 
 * @author Imran Hyderi
 *
 */
@RestController
@RequestMapping("/bbc/api/notification")
public class PushBulletNotificationRestController 
{
	
	public static final Logger logger = LoggerFactory.getLogger(PushBulletNotificationRestController.class);
	
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	public void setUserJpaRepository(UserJpaRepository userJpaRepository) 
	{
		this.userJpaRepository = userJpaRepository;
	}
	
	/**
	 * @return ResponseEntity of List UserDTO type. Contains a list of all the users 
	 * 		   that are registered.
	 */
	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> listAllUsers()
	{
		logger.info("Getting all registered users.");
		List<UserDTO> users = userJpaRepository.findAll();
		if(users.isEmpty())
		{
			logger.info("Unable to get users. No users registered.");
			return new ResponseEntity<List<UserDTO>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);		
	}
	
	/**
	 * @param user a Request Body of type UserDTO object containing
	 * 	      information about the user to register.
	 * @return ResponseEntity of UserDTO type. Contains data related to the transaction.
	 */
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody final UserDTO user)
	{
		logger.info("Creating new user.");
		if(userJpaRepository.findById(user.getUserName()).orElse(null)!= null)
		{
			logger.info("Unable to create new user as user already exists.");
			return new ResponseEntity<UserDTO>(
					new CustomErrorType("Could not create user. "
							+ "User with id " + user.getUserName() + " already exists."),HttpStatus.CONFLICT);
					
		}
		
		user.setCreationTime(Calendar.getInstance().getTime());
		userJpaRepository.save(user);
		return new ResponseEntity<UserDTO>(user,HttpStatus.CREATED);
	}
	
	/**
	 * @param restTemplate Used to send the request to the Pushbullet API
	 * @param notify A request body object containing notification data for the Pushbullet API call
	 * @return ResponseEntity<?> This will contain information about the notification transaction
	 */
	@PostMapping(value = "/notify", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> sendNotification(final RestTemplate restTemplate, @Valid @RequestBody final Notificaton notify) 
	{
		logger.info("Sending notification.");
		final HttpHeaders headers = new HttpHeaders();
		UserDTO user = userJpaRepository.findById(notify.getUserName()).orElse(null);
		if(user == null)
		{
			logger.info("Unable to send notification. User does not exist.");
			return new ResponseEntity<UserDTO>(
					new CustomErrorType("Could not send notification. "
							+ "Username with " + notify.getUserName() + " was not found"), HttpStatus.NOT_FOUND);
		}
		
		headers.set("Access-Token", user.getAccessToken());
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("body", notify.getBody());
		body.add("title",notify.getTitle());
		body.add("type", notify.getType());
		body.add("url", notify.getUrl());
		body.add("file_name", notify.getFile_name());
		body.add("file_type", notify.getFile_type());
		body.add("file_url", notify.getFile_url());
		
		HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);

		ResponseEntity<String> response = restTemplate.exchange("https://api.pushbullet.com/v2/pushes",
				HttpMethod.POST, httpEntity, String.class);
		
		user.setNumOfNotificationsPushed(user.getNumOfNotificationsPushed() + 1);
		userJpaRepository.save(user);
	
		return response;
	}
}
