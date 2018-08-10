package com.bbc.notification.imran.Rest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.bbc.notification.imran.PushBulletNotificationSystem.PushBulletNotificationSystemApplication;
import com.bbc.notification.imran.dto.UserDTO;
import com.bbc.notification.imran.repository.UserJpaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PushBulletNotificationSystemApplication.class)
public class PushBulletNotificationRestControllerTest {

	@Spy
	private PushBulletNotificationRestController pushBulletNotificationRestController;
	
	@Mock
	private UserJpaRepository userJpaRepository;
	
	@Before
	public void setup()
	{		
		pushBulletNotificationRestController = new PushBulletNotificationRestController();
		ReflectionTestUtils.setField(pushBulletNotificationRestController, "userJpaRepository", userJpaRepository);

	}
	
	@Test
	public void testListAllUsersShouldReturnListWithAllRegisteredUser()
	{
		List<UserDTO> userList = new ArrayList<UserDTO>();
		userList.add(new UserDTO());
		when(this.userJpaRepository.findAll()).thenReturn(userList);
		ResponseEntity<List<UserDTO>> responseEntity = pushBulletNotificationRestController.listAllUsers();	
		Assertions.assertThat(responseEntity.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
	}
	
	@Test
	public void testCreateUserWithMockUserShouldSaveUserData()
	{
		UserDTO userDTO =  new UserDTO();
		userDTO.setAccessToken("MockAccessToken123");
		userDTO.setUserName("MockUserName");
		userDTO.setNumOfNotificationsPushed(1);
		
		Date beginDate = Calendar.getInstance().getTime();
		ResponseEntity<UserDTO> responseEntityCreateUser = pushBulletNotificationRestController.createUser(userDTO);
		Assertions.assertThat(responseEntityCreateUser.getStatusCode()).isEqualByComparingTo(HttpStatus.CREATED);
		Assertions.assertThat(responseEntityCreateUser.getBody().getUserName()).isEqualTo("MockUserName");
		Assertions.assertThat(responseEntityCreateUser.getBody().getCreationTime()).isBetween(beginDate,Calendar.getInstance().getTime());
		Assertions.assertThat(responseEntityCreateUser.getBody().getNumOfNotificationsPushed()).isEqualTo(1);		
	}
	
	@Test
	public void testSendNotificationShouldSendNotificationForUsername()
	{
		Notificaton notify = new Notificaton();
		UserDTO user =  new UserDTO();
		user.setAccessToken("o.2BiskjGTCXp3yoW3ugcuzz1AeINPDz6K");
		user.setUserName("MockUserName");
		user.setNumOfNotificationsPushed(0);
		when(userJpaRepository.findById("MockUserName")).thenReturn(Optional.of(user));

		notify.setBody("MockTesting Body");
		notify.setTitle("Mock testing title");
		notify.setType("note");
		notify.setUserName("MockUserName");
		ResponseEntity<?> responseEntity = pushBulletNotificationRestController.sendNotification(new RestTemplate(), notify);
		
		Assertions.assertThat(responseEntity.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
	}	
	
	@After
	public void tearDown()
	{
		pushBulletNotificationRestController = null;
	}

}
