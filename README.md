<p align="center">
  <img src="https://img.shields.io/github/license/Nandini-Bhimineni/Bank_Account_Management_System?style=flat-square" />
</p>

<p align="center">
  A clean, scalable, and object-oriented Java console application for managing bank accounts.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=flat-square" />
  <img src="https://img.shields.io/github/stars/Nandini-Bhimineni/Bank_Account_Management_System?style=flat-square" />
  <img src="https://img.shields.io/github/forks/Nandini-Bhimineni/Bank_Account_Management_System?style=flat-square" />
  <img src="https://img.shields.io/github/license/Nandini-Bhimineni/Bank_Account_Management_System?style=flat-square" />
</p>

---
# Bank Account Management System  
A clean, object-oriented **Java console application** that implements core banking operations such as account creation,deposit, withdrawal, balance inquiry, and account listing.  

This project demonstrates **strong knowledge of OOP principles**, collections, modular code design, exception handling, and clean architectural separation between data models and business logic — following standards admired in FAANG-level codebases.

---

## Overview

The **Bank Account Management System** is built to provide a scalable structure for banking operations using Java.  
The project is designed with:

- **Encapsulated domain model** (`Account`)
- **Service-layer abstraction** (`Bank`)
- **CLI-based interface** (`AccountManagementSystem`)
- **Modular, maintainable folder structure**

This structure mirrors how enterprise banking or fintech systems separate concerns internally.

---

## Key Features

- Create a new customer bank account  
- Unique account number generation  
- Deposit and withdraw money with validation  
- Prevent negative balance or invalid transactions  
- List and view all accounts  
- Search account by account number  
- Clear, user-friendly CLI menu  
- Robust input validation and exception handling  

> The operations are designed to be extensible, enabling future integration with databases, REST APIs, or UI frameworks.

---

## Technical Highlights (FAANG-level Quality)

### Object-Oriented Principles
- Encapsulation of account data  
- Clear separation of concerns (UI vs business logic)  
- Reusable service methods in `Bank` class  
- Clean constructor and getter/setter usage  

### Collections
- Uses **ArrayList** for dynamic account storage  
  - Optimized for fast iteration  
  - Suitable for CLI applications  
  - Easy to migrate to DB later  

### Error & Edge Case Handling
- Invalid input handling (non-numeric choices)  
- Withdraw validation (no overdraft)  
- Prevent duplicate account numbers  
- Message-driven error feedback  

---
## Project Structure

```
Bank_Account_Management_System/
└── src/
    └── bank/
        ├── Account.java                 # Domain model
        ├── Bank.java                    # Service layer
        └── AccountManagementSystem.java # Application entry point (main)
```




This structure follows **enterprise-ready modular packaging**.

---------

## How to Run

###  Using IntelliJ IDEA 

1. Clone the repository:
   ```bash
   git clone https://github.com/Nandini-Bhimineni/Bank_Account_Management_System.git
2.Open the project in IntelliJ.

3.Open AccountManagementSystem.java.

4.Click Run ▶.

### Option 2: Using Command Line

```bash
cd Bank_Account_Management_System/src
javac bank/*.java
java bank.AccountManagementSystem
