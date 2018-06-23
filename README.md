 - This test was made on Java8 having as dependency:
selenium-java - core
testng - to run.
spring-context (to load selenium.properties in the Webdriver context).
extentreports - to generate a better test log.

- About the project
Basically, the idea here is provide resources for the Tester be able to work on automation in the src/test side.
 All packages were placed in /src/main/java and the only thing that a Test Engineer needs to do is configure the file selenium.properties.


Package webdriver:
    This package provides a class called WebDriverManager, this is the point to get the WebDriver Instance, all other classes
    are package private.

    Also, we have an interface called WebDriverCreator that should be implemented by each driver creator. I've created 3
    classes by far to provide support for Chrome, FireFox and IE. DriverManager class also implement this.

    Another important class in this package is WebDriverProperties, its field are populated after call loadContext() using
    the properties placed in selenium.property file.

    Selenium property file is the only setup point for the WebDriver creation. The user should declare his driver executable
    path, webdriver system property and browser.name, nothing else.

Package page:
    This package contains all Page Objects that represents the pages from the Website.
    Each Page class extends BasePage receiving a WebDriver instance by constructor.
    All pages are using Css locator, it is faster and easy to use.
    Elements are initiated in the BasePage constructor, all Page classes must extend BasePage to get elements initiated and
   pass the webdriver instance to the BasePage.
    All methods in the Page classes return another page, or the same page, always! Thanks to this approach, the @Test method
   is more readable, any tester can easily open the Test method and understand without opening any other class.
    Assertions were placed in the Page classes in methods starting with 'verify'. Personally I don't like to create dozens
   of boolean methods in the page class to provide for the Test class. I believe this approach avoids code repetition,
   following DRY concept. there are some people that disapproves Assertion in Page classes, honestly I prefer having this
   encapsulated too.

Package log:
    This package contains ExtentReportLog class with static methods to log information during the test execution.
    A static logger is used by the whole project, extentReport is started by @BeforeSuite and finished by @AfterSuite.

Package data:
    This package provides data to be used during the test.

Package base:
    Contains the BasePage class that should be extended by all Page classes.



 - Steps to Run:
 First you should set selenium.properties file including your executable driver file, system.property and browser name.
 I pushed my geckodriver for linux to git, if you are using linux 64 and firefox, there is nothing to change.
 I did not create a maven profile to run the tests, please just run **mvn clean install** and the test will run.

After test, the file ExtentReport.html will be created for the last test execution. This file will be in the root folder.

