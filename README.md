
# Tendable Testing Challenge Solution

### SELENIUM-TestNG-JAVA-MAVEN

This repository contains solution for the Tendable Testing challenge using selenium-testNG-java framework based on POM design.
This project showcase automation script development and utilize various reports such as default testng reports and extent reports.
It use POM based framework which separates all page related elements from business logic.
All test data is stored in config.properties file.


### INSTALLATION & PRE-REQUISITES

1.JDK(17)

2.Maven

3.IntelliJ IDEA

4.Required Plugins

  Maven
   
  TestNG

### IMPLEMENTIONS COVERED IN FRAMEWORK AS PER THE SCOPE OF THE ASSIGNMENT.

1. Page Object Design Pattern.
2. TestNG features for executing test cases.
3. Utility functions to handle Driver methods.
4. Utility functions to handle WebElements.
5. Extent reports for test execution result details.
6. Maven is used to build the project and handling dependencies.


### GETTING STARTED

To setup the framework you can either clone the repository or download the zip file and set it up in your local workspace.

Import the project using eclipse or Intellij

### RUNNING THE TESTS

Go to your project directory from command prompt and hit following commands:

`mvn clean install`

`mvn clean install -Dbrowser="chrome"` (to use any other browser)

### POSSIBLE ENHANCEMENT FOR THE SOLUTION

1. Emailing the execution report to the stakeholders.
2. Enhance the reporting for different log levels.
3. Handle execution to run for one or more retry attempts.
   

Alternatively, you can run using testng.xml file present under testrunners package in IDE
