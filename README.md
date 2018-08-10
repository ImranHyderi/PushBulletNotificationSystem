# PushBulletNotificationSystem
A RESTful API developed using Spring Booot to send notifications using Pushbullet

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
