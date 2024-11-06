# 🎉 Welcome to the SuccessDemo Test Framework! 🎉

This framework is designed for robust automation testing using **Java**. It includes:
- **Selenium** for browser automation
- **JUnit** and **TestNG** for structured test management
- **Allure Reporting** for insightful test reports
- **Error Screenshots** and more to streamline testing!

---

## 🚀 Getting Started

### 1. Set Up a Maven Project
   - Create a Maven project as usual or set it up from scratch.

### 2. Configure `pom.xml`
   - Add the provided dependencies and plugins in your `pom.xml` file.

### 3. Create Folder Structure
   - Go to `src/test/java` and create these folders:
     - `pages`
     - `utilities`
     - `tests`

### 4. Import Files
   - Option 1: Import each file manually into the corresponding folders.
   - Option 2: Download the complete `src/test/java` folder and replace it in your project.

### 5. Configure the Driver Path
   - A `drivers` folder is included with Chrome, Edge, and Firefox drivers.
   - Set the driver path in `BaseTest.java` as shown below:
     ```java
     System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
     ```
   - Or, if using Selenium 4+, use:
     ```java
     WebDriverManager.chromedriver().setup();
     ```

### 6. Add `testing.xml`
   - Download `testing.xml` and place it in your project directory to manage test execution.

### 7. Run Your Tests 🚦
   - Save your project and run it. The `allure-report` and `screenshot` folders will be generated automatically during test execution.

---

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
