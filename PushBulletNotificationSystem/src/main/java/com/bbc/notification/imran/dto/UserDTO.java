package com.bbc.notification.imran.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

/**
 * Data Transfer Class for user data
 * 
 * @author Imran Hyderi
 *
 */
@Entity
@Table(name="Users")
public class UserDTO 
{
	
	@Id
	@NotEmpty
	@Column(name = "USER_NAME")
	private String userName;
	
	@NotEmpty
	@Length(max = 80)
	@Column(name = "ACCESS_TOKEN")
	private String accessToken;
	
	@Column(name = "CREATION")
	private Date creationTime;

	@Column(name = "NUMBER_NOTIFICATIONS")
	private Integer numOfNotificationsPushed = 0;
	
	/**
	 * @return creationTime Date type object contain the date of creation for the record.
	 */
	public Date getCreationTime() 
	{
		return creationTime;
	}
	
	/**
	 * @param creationTime The creation time for the record.
	 */
	public void setCreationTime(Date creationTime) 
	{
		this.creationTime = creationTime;
	}
	
	/**
	 * Returns user's username
	 * @return userName String object containing the username.
	 */
	public String getUserName() 
	{
		return userName;
	}

	/**
	 * Sets the username.
	 * @param userName The username to register a new user.
	 */
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	/**
	 * Returns the users access token.
	 * @return accessToken String object containing the Pushbullet access token.
	 */
	public String getAccessToken() 
	{
		return accessToken;
	}

	/**
	 * Sets the Pushbullet access token 
	 * @param accessToken sets the Pushbullet access token.
	 */
	public void setAccessToken(String accessToken) 
	{
		this.accessToken = accessToken;
	}

	/**
	 * @return numOfNotificationsPushed Integer object containing the number
	 *         of notifications pushed by the user.
	 */
	public Integer getNumOfNotificationsPushed() 
	{
		return numOfNotificationsPushed;
	}

	/**
	 * Sets the number of notifications pushed.
	 * @param numOfNotificationsPushed The Integer value to set for push notifications.
	 */
	public void setNumOfNotificationsPushed(Integer numOfNotificationsPushed) 
	{
		this.numOfNotificationsPushed = numOfNotificationsPushed;
	}
}
