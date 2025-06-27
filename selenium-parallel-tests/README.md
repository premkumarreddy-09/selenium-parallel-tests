LambdaTest Selenium 101 Certification – Assignment Submission

Tech Stack

This project uses the following tools and technologies:
-->Java (Latest version)
-->Selenium WebDriver
-->TestNG for test execution
-->Maven for build management 
-->Gitpod as the cloud development environment
-->LambdaTest Selenium Grid for cross-browser cloud execution

Test Scenarios Automated
The following test cases have been implemented as part of this assignment:

1. **SimpleFormTest**
   -->Navigates to “Simple Form Demo”
   --> Verifies the message displayed matches user input

2. **SliderTest**
   -->Opens “Drag & Drop Sliders” page
   -->Moves the slider (default 15) to value 95
   -->Validates the slider value update

3. **InputFormTest**
   -->Opens “Input Form Submit” page
   -->Fills out all fields using different locator strategies
   -->Submits the form and checks for a success message

 How to Run This Project on Gitpod
To run this test suite on Gitpod (cloud IDE):

1. Click the button below to open the project in Gitpod  
   [![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/YOUR-GITHUB-USERNAME/YOUR-REPOSITORY-NAME)

2. Wait for the Gitpod environment to set up automatically. It will:
   -->Install all Maven dependencies
   -->Run the test cases via `testng.xml`

 Make sure your LambdaTest credentials are set as environment variables (`LT_USERNAME` and `LT_ACCESS_KEY`) in Gitpod or directly in the test files.

 LambdaTest Execution Capabilities
All tests are executed on the LambdaTest Selenium Grid using the following capabilities:

 OS: Windows 10
 Browser: Chrome (version 138)
 Cloud Execution: LambdaTest

Enabled features:
 Console Logs
 Network Logs
 Video Recording
 Screenshots

 Test Session IDs
These are the test run IDs from LambdaTest:
SimpleFormTest: `DA-WIN-2654215-1750968936900307911APP`
SliderTest: `DA-WIN-2654215-1750968936960734367VDM`
 InputFormTest: `DA-WIN-2654215-1750968936385880291IAD`

(Replace the above IDs with actual ones after test execution)

 Repository Access
This is a **private GitHub repository** shared with:
- ✅ `LambdaTest-Certifications`
- ✅ `admin@lambdatestcertifications.com`

 Notes
- All locators include a mix of strategies (`By.id`, `By.name`, `By.xpath`, and `By.linkText`) to meet the assignment requirement.
- The `.gitpod.yml` file is included for automated setup.
- Project is kept lightweight and readable as per certification guidelines.

---

