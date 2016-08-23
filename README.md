# restSampleJersey
Demo rest Web service with jersey

This is a Demo for creating and consuming Rest web services.
It demonstrates basic spring mvc also.
I also use HttpClient from  https://hc.apache.org/httpcomponents-client-ga/ to consume  Rest service. 
TODO Aop for logging.
TODO IOC for testing.

I have use 
Spring Tool Suite 
Version: 3.7.2.RELEASE

Tomcat 7.068 

Hi there this is a demo version of jersey WebServices.

    I have implement 2 functions for retriving a user and a list of users.
    you can retrieve all users by adding on the url as Json

    http://localhost:8080/projectClient/webservice/user/Json in Json format.
    you can retrieve all users by adding on the url as Xml
    http://localhost:8080/projectClient/webservice/user/Xml in XML format.
    and you can retrieve one user with user id where {userid}= the number of the user 1.2.3...
    http://localhost:8080/projectClient/webservice/user/Json/{userid} in json format
    http://localhost:8080/projectClient/webservice/user/Json/{userid} in Xml format 

The users listed are

  1  Alladin, The Thief, Persia 3, 12345, Persia 123456789

  2  Lucky, Luke, Texas, 74185, El paso, 000000000

  3  Marty, Martian, Mars 8, 00000, Mars, 7777777777

  4  Zeus, The Olympian, Mount Olympos, 56789, Olympos, 99999999



