# restful-sql-calls-controller
This is a java based springboot app and it will handle restful sql calls to add,delete,modify database tables

This application starts a server at http://localhost:8080 as its a spring boot application which comes
with embedded Tomcat server and hence when application is run it starts a server.

###How to  start the application
Run the following commands


```mvn clean install;

   mvn packagreport_nme;
   
   mvn spring-boot:run
```

###How to  make a post API call to add a record in report_master table.

1)Open postman.

2)Select the method as post and add url as http://localhost:8080/api/report/master/add .Please note that data type should be
raw of type application/json.

3)In the body type the following example:
{"reportName":"warehouse9_report",
"execution":"executable",
"server":"IBM",
"intervalTime":"08",
"interactive":"false",
"startTime":"08:00:00",
"endTime":"09:00:00"
}

4)Once you press the post you should see a status ok and should see this record being
returned as response.

###Integration/BDD testing using cucumber.

This application is integrated with cucumber.As of now it has  one feature file
which supports add report scenario.To do integration testing using cucumber do the following:

1)Compile and run the application on a terminal as explained in the first 
section of this README.

2)Then open one more terminal and from your IDE run the cucumber runner class.You can
do it from the terminal window too.Once the cucumber runs, you should see the
feature file getting executed and test case being passed successfully.




