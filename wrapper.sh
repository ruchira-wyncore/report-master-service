#!/usr/bin/env bash
exec java -jar -Dspring.datasource.password=<your_password> -Dspring.profiles.active=dev app.jar