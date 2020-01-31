#!/usr/bin/env python3
import os

print("Please enter MySQL Database Password.")
password = raw_input("Password: ")
command = 'mvn spring-boot:run -Dspring-boot.run.arguments=--spring.datasource.password='+password
os.system(command)

