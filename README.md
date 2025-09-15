
# E-commerce Website Test Automation Framework

This project is a test automation framework built to validate the functionality of a sample e-commerce website. It uses Selenium WebDriver with Java to simulate user actions and TestNG to structure and run the tests.

## 🚀 Features

This framework covers the following key features of the e-commerce website:

-   **Login Functionality**: Verifies that users can log in with both valid and invalid credentials.
-   **Product Filtering**: Tests the ability to sort products by price.
-   **Add to Cart**: Ensures that products can be successfully added to the shopping cart.
-   **Checkout Process**: Validates the entire checkout flow, from adding items to successful order placement.
-   **Logout Functionality**: Confirms that users can successfully log out of their accounts.

## 🛠️ Technologies Used

-   **Java**: The core programming language used for writing the test scripts.
-   **Selenium WebDriver**: For browser automation and simulating user interactions.
-   **TestNG**: As the testing framework for managing and running tests, and for assertions.
-   **Apache Maven**: For project build management and handling dependencies.
-   **WebDriverManager**: To automatically manage the browser drivers (e.g., ChromeDriver).

## 📋 Prerequisites

Before you begin, ensure you have the following installed on your system:

-   **Java Development Kit (JDK)**: Version 11 or higher.
-   **Apache Maven**: To build the project and manage dependencies.
-   **A modern web browser**: Such as Google Chrome.

## ⚙️ Setup and Installation

1.  **Clone the repository:**
    ```sh
    git clone <your-repository-url>
    ```

2.  **Navigate to the project directory:**
    ```sh
    cd Ecommerce-Automation
    ```

3.  **Install the dependencies:**
    Maven will automatically download all the necessary dependencies defined in the `pom.xml` file.
    ```sh
    mvn install
    ```

## ▶️ How to Run Tests

To execute the automated tests, follow these steps:

1.  **Start the local web server:**
    The tests are designed to run against the `index.html` file. You need to serve this file using a local server. If you are using Visual Studio Code, you can use the **Live Server** extension.
    -   Right-click on `index.html`.
    -   Select "Open with Live Server".
    -   This will typically start the server at `http://127.0.0.1:5500`.

2.  **Run the tests using Maven:**
    Open your terminal, navigate to the project's root directory, and run the following command:
    ```sh
    mvn clean test
    ```
    This command will clean the project, compile the code, and execute the test suite defined in `testng.xml`.

## 📂 Project Structure

The project follows a standard Page Object Model (POM) design pattern to enhance test maintenance and reduce code duplication.

```
.
├── pom.xml                 # Maven Project Object Model file
├── index.html              # The local e-commerce website
└── src
    └── test
        ├── java
        │   └── com
        │       └── ecommerce
        │           ├── base        # BaseTest class for setup and teardown
        │           ├── pages       # Page Object classes (e.g., LoginPage, ProductsPage)
        │           └── tests       # TestNG test classes (e.g., LoginTest, CartTest)
        └── resources
            └── testng.xml          # TestNG suite configuration file
```

-   `pom.xml`: Defines all project dependencies (Selenium, TestNG, etc.) and build configurations.
-   `src/test/java/com/ecommerce/base`: Contains the `BaseTest` class, which handles WebDriver setup (`@BeforeMethod`) and teardown (`@AfterMethod`) for all tests.
-   `src/test/java/com/ecommerce/pages`: Contains Page Object classes, where each class represents a page on the website and holds the locators and methods to interact with that page's elements.
-   `src/test/java/com/ecommerce/tests`: Contains the actual test classes that use the page objects to perform actions and make assertions.
-   `src/test/resources/testng.xml`: The TestNG configuration file used to define the test suite and control which tests are executed.
