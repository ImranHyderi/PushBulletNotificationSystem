package com.bbc.notification.imran.Rest;

/**
 * A class representation of the data required to send a request to the Pushbullet 
 * API for a notification.
 * 
 * @author Imran Hyderi
 *
 */
public class Notificaton 
{
	
	private String userName;
	private String title;
	private String body;
	private String type;
	private String url;
	private String file_name;
	private String file_type;
	private String file_url;
	
		
	public String getUrl()
	{
		return url;
	}
	
	public void setUrl(String url) 
	{
		this.url = url;
	}
	
	public String getFile_name() 
	{
		return file_name;
	}
	
	public void setFile_name(String file_name)
	{
		this.file_name = file_name;
	}
	
	public String getFile_type() 
	{
		return file_type;
	}
	
	public void setFile_type(String file_type)
	{
		this.file_type = file_type;
	}
	
	public String getFile_url() 
	{
		return file_url;
	}
	public void setFile_url(String file_url)
	{
		this.file_url = file_url;
	}
	
	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public String getBody() 
	{
		return body;
	}
	
	public void setBody(String body) 
	{
		this.body = body;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
}
