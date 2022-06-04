Jupiter Toys
Requirements:
IntelliJ community, latest version
JDK, latest version (can be installed via IntelliJ)
Maven, latest version

Set JAVA environment variables - refer to https://docs.oracle.com/javase/tutorial/essential/environment/env.html#:~:text=Like%20properties%20in%20the%20Java,also%20between%20command%20line%20interpreters.

Set Maven environment variables - refer to https://mkyong.com/maven/how-to-install-maven-in-windows/

IntelliJ does contain default maven project(Be sure to select maven project) Maven dependencies: Cucumber Java| Cucumber Junit | Junit| Selenium Java

Add the following IntelliJ plugins

Framework Overview
selenium java
junit
testng
maven compiler
maven surefire

How to run tests
Option 1:
Right click on TestRunner Class and click "Run 'TestRunner'"
This will run all feature files in Features folder

Option 2:
Go to IntelliJ Terminal and enter following command
mvn clean install
Same as Option 1, this will run all feature files in Features folder

Other useful run commands

Run feature files with specific tags
mvn clean install "-Dcucumber.options=--tags @Accounts"

To run a specific feature file you are currently working on, give it a @WIP tag and run
mvn clean install "-Dcucumber.options=--tags @WIP"

Note: Don't forget to replace @WIP before creating a PR

After running via mvn, allure report can be accessed using command allure serve allure-results


Create PageObject class
Create new JAVA class in Pages package
Create an instance of BasePage class
Initiate driver to BasePage driver. Refer below for an example
WebDriver driver = basePage.driver;
Adding Object/WebElements to PageObject class
Create new method in the PageObject class with return type WebElement
Return a WebElement. Refer below for an example
  By tab_home = By.linkText("Home");
Create Steps class
Create new JAVA class in Steps package
Create an instance of the Step's corresponding PageObject class. Like this
  public class HomeSteps {
      HomePage homePage = new HomePage();
