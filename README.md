# Trendyol E-Commerce BDD Test Framework

## Overview

This project is a User Interface (UI) test automation framework for the Trendyol e-commerce website, developed using **Selenium WebDriver** and **Cucumber** for Behavior-Driven Development (BDD). The primary goal of this project was to implement a basic test scenario ("Add Product to Favorite") while building a foundational understanding of BDD principles in a real-world context.

While this project successfully demonstrates a basic end-to-end scenario, it is also a living document that is currently undergoing a significant refactoring process to align with modern test automation best practices.

## Table of Contents
- [Project Goal](#project-goal)
- [Technologies Used](#technologies-used)
- [Roadmap for Refactoring and Improvement](#roadmap-for-refactoring-and-improvement)
- [Setup and Execution](#setup-and-execution)

## Project Goal
The initial goal was to create a readable and business-focused test using Cucumber's Gherkin syntax and automate the browser interactions with Selenium. The project currently uses a basic Page Object Model (POM) structure.

## Technologies Used
- **Java**: Core programming language
- **Selenium WebDriver**: Browser automation
- **Cucumber**: BDD framework for Gherkin syntax
- **TestNG**: Test runner
- **Maven**: Dependency management

## Roadmap for Refactoring and Improvement
This framework is being actively refactored to be more robust, stable, and maintainable. The following enhancements represent the future direction of this project:

1.  **Framework Core & Stability:**
    *   **Automated Driver Management:** Migrating from manual `chromedriver` management to **WebDriverManager** for automated and cross-platform browser driver setup.
    *   **Robust Driver Lifecycle:** Implementing a **ThreadLocal** driver factory to ensure thread safety and enable reliable parallel test execution.
    *   **Dependency Injection:** Integrating a DI container like **PicoContainer** to allow Cucumber to manage the state and lifecycle of Page Objects and the WebDriver instance, eliminating manual instantiation in step definitions.

2.  **Test Reliability and Efficiency:**
    *   **Dynamic Waits:** Completely removing all `Thread.sleep()` calls and replacing them with a centralized **`WaitUtils`** class that leverages `WebDriverWait` and `ExpectedConditions`. This will eliminate flakiness and reduce execution time.
    *   **Atomic Scenarios:** Enforcing scenario independence using Cucumber **Hooks (`@Before` & `@After`)**. Each scenario will manage its own state (e.g., login, cleanup) to ensure it can run independently without relying on the state of a previous test.

3.  **Code Quality and Maintainability:**
    *   **Advanced Page Object Model:** Enhancing the POM with fluent interfaces, more specific locators, and moving all business logic from step definitions into page classes.
    *   **Externalized Test Data:** Migrating all hardcoded data (URLs, credentials, search terms) from the code into external configuration files (e.g., `.properties`) to improve flexibility and security.

4.  **Observability and Debugging:**
    *   **Structured Logging:** Integrating **SLF4J** for comprehensive logging. Implementing `log.info`, `log.debug`, and `log.error` within methods will provide clear insights into the test flow and drastically simplify debugging.
    *   **Advanced Reporting:** Integrating a visually rich reporting tool like **Allure Report** to provide step-by-step execution details, including screenshots on failure.

## Setup and Execution

1.  **Clone the repository.**
2.  **Ensure you have Maven and JDK installed.**
3.  **Run the tests from the terminal:**
   
```bash
mvn clean test
```
