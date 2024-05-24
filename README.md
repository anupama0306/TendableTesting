**TDD TestNG Project**

**SELENIUM-TestNG-JAVA-MAVEN**

This repository contains a sample project that demonstrate how to use a selenium-testNG-java with TestNG and JAVA.
This Project showcase automation script development and utilize various reports such as default testng reports and allure reports.
It use POM based framework which separates all page related elements from business logic.
All test data is stored in Config.properties file.


**INSTALLATION & PRE-REQUISITES**
1.JDK(17)

2.Maven

3.IntelliJ IDEA

4.Required Plugins

  Maven

  TestNG

**WHAT ARE ALL IMPLEMENTED IN FRAMEWORK**

1. Page Object Design Pattern.
2. TestNG TDD feature for executing test cases
3. Utility functions to handle Driver methods.
4. Utility functions to handle WebElements
5. Allure reports for test execution details.
6. Maven is used to build the project


**GETTING STARTED**

To setup the framework you can either clone the repository or download the zip file and set it up in your local workspace.

Import the project using eclipse or Intellij

**RUNNING THE TESTS**

Go to your project directory from commandprompt and hit following commands:

mvn clean install

mvn clean install -Dbrowser="chrome"(to use any other browser)

# TendableTesting