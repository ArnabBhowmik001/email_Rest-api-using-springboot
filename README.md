# a web app ( backend only) using the spring boot application

Features:
1.create users.
2.create email in db.
3.all users.
4.users by id.
5.total email count by user.
6.unit and integration test
CODE EXECUTION:(prerequisites:postman,any IDE)
1.simple run spring aplliclication and do mentioned  below steps in postman   
2.here,we will use(/user) to create new user in h2-database.
json format for user is:
 {
        "users_id": 2,
        "firstname": "Arnab",
        "lastname": "bhowmik",
        "phoneno": "9733082076",
        "emailaddress": "a@gmail.com"
        
    }
3.we will use (/email) to create new email in db
json format for email is:
{
        "email_id": 112,
        "email_from": "a@gmail.com",
        "email_to": "c@gmail.com",
        "body": "done",
        "users": {
            "users_id": 2,
            "firstname": "Arnab",
            "lastname": "bhowmik",
            "phoneno": "9733",
            "emailaddress": "a@gmail.com"
        },
        "subject": "assignment"
    }
4.use(/users)to fetch all users and use (/user/{id}) to fetch specified user.
5.(/email-count/{user_id}) this fetch email count from specified user.




