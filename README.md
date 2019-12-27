# restful-sql-calls-controller
This is a java based Spring boot application and it will handle restful sql calls to add, delete, update and view records in the  MYSQL tables.

This application starts a server at http://localhost:8080 as its a spring boot application which comes with embedded Tomcat server.

### How to  start the application

Run the following commands
```
# To build the application
*mvn clean install;*

# To run the application you also need to provide the password for your database in MYSQL.
*mvn spring-boot:run -Dspring-boot.run.arguments="--spring.datasource.password=your_password_for_db"*
```

### How to  make a post API call to add a record in report_master table.

Assumptions: Before running this application make sure that you have  MYSQL running locally.There should be a database named wyncore created and it should have a table named report_master.To do this automaticall you can use the db migration application and can contact Ruchira(rbiyani@wyncore.com) for help.

1) Run the application locally as described in the previous section.
2) Open postman.
3)Select the method as post and add url as http://localhost:8080/api/report/master/add. Please note that data type should be raw of type application/json.
4)In the body type the following example:
{"reportName":"warehouse9_report",
"execution":"executable",
"server":"IBM",
"intervalTime":"08",
"interactive":"false",
"startTime":"08:00:00",
"endTime":"09:00:00"
}
5)Once you press the post you should see a status OK(status code 200) and should see this record being returned as response.

Also you can go the the MYSQL console and write the query to see the records from the report_master table and you should see the newly added record.

### How to  perform update,delete and get API calls

In the similar fashion as described above one can perform the PUT, DELETE and GET API call.

1) The API URL for get all record is:- 
http://localhost:8080/api/report/master/get/all

2) The API URL for the deletion of record based on report name is 
http://localhost:8080/api/report/master/delete/{id}  where id is the name of the report to be deleted.

3) The API URL for the updating of record based on report name is 
http://localhost:8080/api/report/master/update/{id}  where id is the name of the report to be updated. The body of this call contains the record to be updated in JSON format as described in the POST section and it returns back thee updated response.

### Integration/BDD testing using cucumber.

This application is integrated with cucumber.As of now it has  one feature file
which supports add report scenario.To do integration testing using cucumber do the following:

1)Compile and run the application on a terminal as explained in the first 
section of this README.

2)Then open one more terminal and from your IDE(IntelliJ preferably) run the cucumber runner class.You can do it from the terminal window too.Once the cucumber runs, you should see the
feature file getting executed and test case being passed successfully.

### Log file
This application uses logback and the app log is generated under target/logs folder with the name app.log .

### CheckStyle 

This application is integrated with checkstyle plugin to enforce coding guidelines.Currently it follows SUN's specification.
The build will fail if the checkstyle specifications are not met.