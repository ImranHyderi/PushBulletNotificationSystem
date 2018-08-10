# PushBulletNotificationSystem
A RESTful API developed using Spring Booot to send notifications using Pushbullet

## Technologies used
Java, Spring Boot, H2 database.

## Potential Issues
If a user A sends a notification at the same time as User B and both users are using the same username from different terminals then this can result in the lost update problem. This would occur on the numOfNotificationsPushed attribute. User A would update it and whilst user A is updating the value, user B would read the old value. Once user A's update is complete then user B's update would occur and overwrite user A's commit with an incorrect count on the numOfNotificationsPushed attribute. 



## Instructions for API calls
### Register New User
To register a new user, use the api call shown below.
#### URL
```
http://localhost:8080/bbc/api/notification/register
```

#### Body
```
{
	"userName":"TesterName",
	"accessToken":"iewjoaewr.102"
}
```
### Retreive a List of All Registered Users
To retreive a list of all users, use the api call shown below.
#### URL
```
http://localhost:8080/bbc/api/notification/all
```

### Send A Pushbullet Notification
To send a notification, use the api call shown below.
#### URL
```
http://localhost:8080/bbc/api/notification/notify
```

#### Body
```
{
	"userName":"Tester",
	"title":"test title",
	"body":"test body",
	"type":"note"
}
```
