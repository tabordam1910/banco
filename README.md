# Bank Management System - Core Domain Implementation

## Project Overview
This repository contains the core domain logic for a Bank Information Management System. The architecture is strictly based on **Clean Architecture** and **Domain-Driven Design (DDD)** principles to ensure high maintainability, scalability, and separation of concerns.

The current implementation focuses on the **Domain Layer**, which serves as the central core of the application, independent of external frameworks or databases.

## Technical Structure
The source code is organized following the standard Java package convention:

* **com.bank.domain.entities**: Contains the domain models (User, Account, Loan, and Transfer) which represent the fundamental data structures of the banking system.
* **com.bank.domain.services**: Implements the domain services responsible for orchestrating complex business logic and enforcing transactional rules.
* **com.bank.domain.exceptions**: Defines custom runtime exceptions used to handle business rule violations.

## Core Business Rules
The following business requirements have been implemented within the domain services:

1. **Loan Processing**: Manages the lifecycle of a loan, restricted to authorized internal analysts. It ensures transitions from 'Under Review' to 'Approved' and handles the final disbursement logic.
2. **Transfer Management**: Implements security thresholds for corporate accounts. Transfers exceeding the defined limit are automatically flagged for manual approval.
3. **Account Integrity**: Includes mandatory validation checks to prevent any financial operation on accounts that are currently blocked or inactive.

## Technology Stack
* **Language:** Java
* **Design Pattern:** Clean Architecture / Domain-Driven Design (DDD)
* **Development Environment:** Visual Studio Code
* **Version Control:** Git

## Installation and Setup
1. Clone the repository to your local machine.
2. Open the root folder using **Visual Studio Code**.
3. Ensure the **Extension Pack for Java** is installed for proper syntax highlighting and project management.
4. The project structure follows the standard Maven/Gradle layout: `src/main/java`.