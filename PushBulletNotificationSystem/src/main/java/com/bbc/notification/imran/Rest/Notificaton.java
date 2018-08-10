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
	
		
	/**
	 * Gets the URL
	 *
	 * @return url the get's String url
	 */
	public String getUrl()
	{
		return url;
	}
	
	/**
	 * Sets the url
	 * 
	 * @param url url to set to
	 */	
	public void setUrl(String url) 
	{
		this.url = url;
	}
	
	/**
	 * Gets the file_name
	 *
	 * @return file_name gets String file_name
	 */
	public String getFile_name() 
	{
		return file_name;
	}
	
	/**
	 * Sets the file_name
	 * 
	 * @param file_name file_name to set to
	 */
	public void setFile_name(String file_name)
	{
		this.file_name = file_name;
	}
	
	/**
	 * Gets the file_type
	 *
	 * @return file_type gets String file_type
	 */
	public String getFile_type() 
	{
		return file_type;
	}
	
	/**
	 * Sets the file_type
	 * 
	 * @param file_type file_type to set to
	 */
	public void setFile_type(String file_type)
	{
		this.file_type = file_type;
	}
	
	/**
	 * Gets the getFile_url
	 *
	 * @return file_type gets String getFile_url
	 */
	public String getFile_url() 
	{
		return file_url;
	}
	
	/**
	 * Sets the file_url
	 * 
	 * @param file_url file_url to set to
	 */
	public void setFile_url(String file_url)
	{
		this.file_url = file_url;
	}
	
	/**
	 * Gets the userName
	 *
	 * @return userName gets String userName
	 */
	public String getUserName() 
	{
		return userName;
	}
	
	/**
	 * Sets the userName
	 * 
	 * @param userName userName to set to
	 */
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	/**
	 * Gets the body
	 *
	 * @return body gets String body
	 */
	public String getBody() 
	{
		return body;
	}
	
	/**
	 * Sets the body
	 * 
	 * @param body body to set to
	 */
	public void setBody(String body) 
	{
		this.body = body;
	}
	
	/**
	 * Gets the title
	 *
	 * @return title gets String title
	 */
	public String getTitle() 
	{
		return title;
	}
	
	/**
	 * Sets the title
	 * 
	 * @param title title to set to
	 */
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	/**
	 * Gets the type
	 *
	 * @return type gets String type
	 */
	public String getType()
	{
		return type;
	}	
	
	
	/**
	 * Sets the type
	 * 
	 * @param type type to set to
	 */
	public void setType(String type) 
	{
		this.type = type;
	}
}
