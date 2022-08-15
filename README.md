# Assignment

[Click here to read the assignment](./docs/assignment.md)

## vanilla

This is a base starter kit framework that you can use to build your tests for the above assignment.
However, if you are more comfortable with your own tool kit, feel free to use that as well!

## External dependencies

For this project to run, you would need to install below 3 dependencies on your machine:

- **[Java 11](https://openjdk.java.net/projects/jdk/11/)** (as the core programming language)
- **[Maven 3.8.5](https://maven.apache.org/download.cgi)** (for dependency management)
- **[Google Chrome latest version](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQjwr-SSBhC9ARIsANhzu15P0PA-n9Zp4NpxKaOHVGtBD1TZQH0HlQQE6hUfsOFAU1nf-Rzdlf4aAoTJEALw_wcB&gclsrc=aw.ds)** (browser to run your tests)

> If your JAVA_HOME is set to anything other than JDK 11, you would need to update the path. Else your project
> will not run. Also, do remember to set the correct JDK settings in your IDE.

## Getting Started

For easiest way to getting started, extract this project and open it from IntelliJ.
> Then Do a dry run on test in : test -> java -> TestSandbox class and see if your setup is correct.  

Tip: Do remember to update this readme file for anything else that you think needs updating here!

## Success
******************************************************************************
## Comments - ADDED BY CHANCHAL SONI - QA CANDIDATE

1- First of all I really liked your framework, and I choose the same for this assignment 
2- I wanted to have some actions done post execution for failed test cases and for that I had to use listeners and I had not used JUNIT5 listeners before, so I though of going with the Test NG, this i ended up using TestNG
3- And I have used POM factory pattern, you can find the page class inside "src/main/java/amazon.pages"
4- I created some utility classes 
   4.1 - BaseClass - for Setup and tearDown functions
   4.2 - Jira Plugin - to create an issue in JIRA if any test cases gets failed - defect gets logged witn an                            attachment 
   4.3 Log - Its log4j Manager for storing logs
   4.4 Screenshot - To capture a screenshot inside screenshot folder 
   
5- I have replaced log4j.propeties file content, i added the appender as file and also created one log folder to store the log files 

6- I have used log4j to add logs 

7- I have also used Extent report to generate test result and to log each step into the report 

8- I have created one TestListener located inside - src/main/java/amazon.listerners/TestListener.java
9- In the listener, I have overridden the onTestFailure method - has two actions written 
   9.1 - it calls the screenshot capture method to capture a screenshot 
   9.2 - it logs a bug ticker in JIRA - also attached the screenshot (have shared my credentials since I use them only for test purpose)
   
10- I have also used explicit wait and JavascriptExecutor wherever required 

11- In POM file i added some dependencies, for testNG, for ExtentReport and for JIRA 


11- you can run my test cases in two ways
    11.1 Go to src/test/java folder and run AmazonTest.java with testNG
    11.2 And execute Testng.xml file with testNG
    
12- I will anyway going to publish my code, but in case there's issue, please find google drive link to downlaod the project 
https://drive.google.com/file/d/14LgKoufOGBM-xlP5Xkdm4JR8hFHF1ahM/view?usp=sharing

Note: I used to add all test resources like config files, logs, screenshots, reports, feature files and data etc. to src/test/resources folder. But since this framework had all configs stored inside the src/main/resources folder, I also added all test resources inside the src/java/resources folder - I hope its fine. 
    
      





