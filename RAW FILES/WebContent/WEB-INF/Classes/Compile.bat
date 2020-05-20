@echo off
javac -classpath "C:\Apache\lib\servlet-api.jar" -d "C:\Apache\webapps\ROOT\WEB-INF\classes" -sourcepath ..\..\..\src *.java
pause