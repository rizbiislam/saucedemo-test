# Welcome to SuccessDemo Test Framework

This framework is based on Java and includes Selenium, JUnit, TestNG, Allure reporting, error screenshot capture, and more.

## User Manual:

1. **Create a Maven Project**  
   Set up a Maven project as you would with any standard Maven setup.

2. **Configure `pom.xml`**  
   Add the required dependencies and plugins to your `pom.xml` file, which is provided in the project.

3. **Set Up Folder Structure**  
   Navigate to `src/test/java` and create the following folders:
   - `pages`
   - `utilities`
   - `tests`

4. **Import Files**  
   - Option 1: Import the provided files into the appropriate folders.
   - Option 2: Download the `src/test/java` folder and replace your `src/test/java` with it.

5. **Drivers Folder**  
   - The project includes a `drivers` folder with Chrome, Edge, and Firefox drivers.
   - Specify the driver path in `BaseTest.java`, for example:  
     ```java
     System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
     ```
   - Alternatively, if using Selenium 4+, you can use:  
     ```java
     WebDriverManager.chromedriver().setup();
     ```

6. **Add `testing.xml`**  
   Download the `testing.xml` file and place it in your project directory.

7. **Run the Project**  
   Save your project and execute the tests. The `allure-report` and `screenshot` folders will be created automatically upon execution.

8. **Generate Allure HTML Report**  
   - Run the following command to serve the Allure report:  
     ```bash
     allure serve <path_to_allure_results>
     ```
   - Alternatively, navigate to the `allure-report` folder in your file explorer, open a command prompt from that location, and then use:  
     ```bash
     allure serve
     ```

Enjoy using the SuccessDemo Test Framework!
