# Log Service

Java REST service (POST and GET).  
It logs events to a database in blues.library.yale.edu 
(database name = log_service and table name = logging_event)  
and uses Hibernate for the data persistence (transient object class = LoggingEvent.java).  

![alt text](log_service.png?raw=true)

### Build
```
mvn clean install
```
You may need to add this repository in the file pom.xml:
```
  <repositories>
    <repository>
      <id>clojars</id>
      <name>Clojars</name>
      <url>http://clojars.org/repo/</url>
    </repository>
  </repositories>
```
### Test
```
curl http://localhost:8080/logservice/rest/log/test
t curl -X POST --data "param=yale" http://localhost:8080/logservice/rest/log/test
```

### Where is this service deployed?
In smldr01.library.yale.edu, here is the URL to call the log service: 
```
http://smldr01.library.yale.edu:8080/logservice/rest/log/test
```
You can find the current war in:
```
/usr/local/apache-tomcat-8.0.11/webapps
```
The DB connection is configured in default.hibernate.cfg.xml.   
The DB server is currently set to java:comp/env/jdbc/log_service_sqlserver.

### Who's calling this REST service?
Ladybird_Crons, in the method logException   
https://git.yale.edu/Library-IT/Ladybird_Crons/blob/e71d80d008d53ea0161945e8ca75408d7891acd0/LadyBirdCronsSolution/MetadataExport/MetadataExport/cConfig.cs


### How to migrate the database for this service?
1 - Check that the database log_service exists for the new server   
  
2 - Modify the database server configuration in /usr/local/apache-tomcat-8.0.11/conf/context.xml   
```
<Resource name="jdbc/log_service_sqlserver" auth="Container" type="javax.sql.DataSource"
       maxActive="15" maxIdle="30" maxWait="10000"
       username="logger" password="log$#123*"
       driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver"
       url="jdbc:sqlserver://blues.library.yale.edu:1433;Databasename=log_service"
/>
```
3 - Redeploy the webapp  


