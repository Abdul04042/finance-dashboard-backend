# Finance Dashboard Backend

A Spring Boot based backend system for a Finance Dashboard application that manages financial records and provides summary analytics with role-based access control.

This project demonstrates backend architecture design including REST APIs, data persistence, role management, and aggregated dashboard data.

---

## Features

### 1. User and Role Management
The system supports different user roles:

- **Viewer**
  - Can only view dashboard data

- **Analyst**
  - Can view financial records
  - Can access dashboard insights

- **Admin**
  - Can create records
  - Can update records
  - Can delete records
  - Can manage users

Each user has an **active or inactive status** and a **role assigned**.

---

### 2. Financial Records Management

The backend supports management of financial records including:

- Create financial records
- View financial records
- Update financial records
- Delete financial records
- Filter records by:
  - Type (Income / Expense)
  - Category

Each record contains:

- Amount
- Type (Income or Expense)
- Category
- Date
- Notes / Description

---

### 3. Dashboard Summary APIs

The backend provides aggregated financial data for dashboard visualization.

Example analytics:

- Total Income
- Total Expenses
- Net Balance
- Category-wise totals
- Recent financial activity

---

### 4. Access Control

Role-based access is implemented to restrict operations:

| Role | Permissions |
|-----|-------------|
| Viewer | View dashboard data only |
| Analyst | View financial records and analytics |
| Admin | Full access to records and user management |

---

## Technology Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST API

---

## Project Structure
finance-dashboard
│
├── controller
│     ├── FinancialRecordController.java
│     └── UserController.java
│
├── service
│     ├── FinancialRecordService.java
│     ├── FinancialRecordServiceImpl.java
│     ├── UserService.java
│     └── UserServiceImpl.java
│
├── repository
│     ├── FinancialRecordRepository.java
│     └── UserRepository.java
│
├── model
│     ├── FinancialRecord.java
│     ├── User.java
│     └── Role.java
│
└── FinanceDashboardApplication.java
