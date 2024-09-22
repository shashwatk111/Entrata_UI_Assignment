**Introduction:**

This project covers Entrata UI Automation of following use case

1. Validate user can schedule a demo
2. Validate particular guide is present on Entrata website
3. Validate there are no broken links are present on the website

**Tools and framework used ::**

1. Testing Framework - TestNG
2. Java - JDK (20.0.1)
3. Build automation tool - Maven (3.9.3)
4. Design Pattern - Page Object Model
5. Programming Language - Java
6. Testing tool	- Selenium
7. Reporting - Extent Report
8. IDE - IntelliJ
9. Logging - Log4j
10. Screenshot - Attached Screenshots if test cases failed
11. Assertion

**Prerequisites ::**

List of prerequisite that need to be install before using this project ::
1. JDK 1.8 or higher (Latest would be recommended)
2. Maven
3. Git

Add it's bin directory to system's PATH environment variable to run commands.

**Getting started test execution::**

Step by step instruction to run the automation script ::
1. Make one folder
2. Open cmd in the same folder
3. Run below git command to clone the project
    - git clone http_git_repository
4. Use cd command to navigate to the directory containing project's pom.xml file
    - cd path_of_project_directory
5. Run "entrata_test_case_run" windows batch file or
   Run below commands where "pom.xml" file exists
    - mvn clean install 
