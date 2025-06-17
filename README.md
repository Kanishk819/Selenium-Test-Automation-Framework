Selenium Test Automation Framework
This is a Java-based UI Test Automation Framework built for efficient, scalable, and data-driven browser testing.

The framework supports execution on local browsers as well as cloud-based environments using LambdaTest.

It includes headless browser support, detailed HTML reporting via ExtentReports, and comprehensive logging using Log4j.

🚀 About Me
Hi, My name is Kanishk Shukla and I am a graduate from B.Tech in Information Technology.I was a Intern in EPAM Systems and I have experience in Automation Testing using technologies like Selenium WebDriver Rest Assured and BDD Cucumber

Author
@Kanishk819
Email Address : shuklakanishk819@gmail.com
🔗 Links
portfolio

linkedin

Hi, I'm Kanishk! 👋
Prerequisites
Before running this framework, ensure the following software is installed on your system

Java 11- Make sure Java is installed and JAVA_HOME environment variable is set
Maven - Ensure maven is installed and installed to system path
📌 Tech Stack
Language: Java 11
Testing Framework: TestNG
Build Tool: Maven
Data Handling: OpenCSV, Apache POI, Gson
Fake Data Generator: Java Faker
Reporting: ExtentReports
Logging: Log4j
Cloud Execution: LambdaTest
Headless Execution: Supported via browser options
Command Line Execution: Maven Surefire Plugin
🚀 Features
✅ Data-Driven Testing using TestNG with CSV and Excel and JSON
☁️ Cloud Test Execution on LambdaTest
🕶️ Headless browser execution for faster test runs
📄 HTML Reports via ExtentReports
📜 Log generation via Log4j in /logs directory
🛠️ Fully configurable via command line parameters
Setup Instructions
Clone the repository

  git clone https://github.com/Kanishk819/Selenium-Test-Automation-Framework.git
  
  cd Selenium-Test-Automation-Framework
Run the test on LambdaTest

  mvn test -Dbrowser=edge -DisLambdaTest=true -DisHeadless=true -X
 
Run the test on Local Machine

  mvn test -Dbrowser=edge -DisLambdaTest=false -DisHeadless=true -X
 
You can change the true/false conditions based on your preference

Reporting and Logs
HTML Report: Automatically generated at the root directory as reports.html after test execution.

Logs: Generated under the /logs directory with timestamps and log levels.

Integrated Project with Github Actions
This Automation Framework is integrated with Github Actions.

The reports will be archived in gh-pages branch.

You can view the HTML reports at : https://kanishk819.github.io/Selenium-Test-Automation-Framework/report.html
