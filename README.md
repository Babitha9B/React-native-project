# Expense Tracker – React Native + Spring Boot + MySQL

A beginner-friendly full-stack mobile app to record income and expenses, categorize transactions, edit/delete entries, filter history, and view monthly totals.

## Tech stack
- Mobile: React Native, Expo, JavaScript
- Backend: Java 17, Spring Boot 3, Spring Web, Spring Data JPA, Bean Validation
- Database: MySQL 8
- API: REST/JSON

## Features
- Create, read, update and delete income/expense transactions
- Categorize transactions
- Filter history by transaction type
- Monthly income, expense and balance summary
- Form validation and API error messages

## Folder structure
```text
expense-tracker/
├── backend/
│   ├── src/main/java/com/example/expensetracker/
│   │   ├── config/          # CORS configuration
│   │   ├── controller/      # REST endpoints and exception handler
│   │   ├── dto/             # Validated request model
│   │   ├── model/           # JPA entity and enum
│   │   ├── repository/      # Spring Data repository
│   │   └── service/         # Business logic
│   ├── src/main/resources/application.properties
│   └── pom.xml
├── frontend/
│   ├── src/services/api.js  # API calls
│   ├── App.js               # Mobile screens and UI
│   ├── app.json
│   └── package.json
└── docs/                    # SQL schema and API reference
```

