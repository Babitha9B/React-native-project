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

## Prerequisites
1. Java 17 or newer
2. Maven 3.8+
3. MySQL 8 and a MySQL user/password
4. Node.js LTS and npm
5. Expo Go on a physical phone, or Android Studio/iOS simulator

## 1. Set up MySQL
Start MySQL, then run `docs/database.sql` in MySQL Workbench or the MySQL CLI. The backend also creates the database if the configured user has permission.

Default local credentials are configured as `root` / `root` for a simple local setup. Change these before use on any shared or deployed machine. Override them with environment variables:
- `DB_URL` (optional; defaults to local `expense_tracker` database)
- `DB_USERNAME`
- `DB_PASSWORD`

Example (macOS/Linux):
```bash
export DB_USERNAME=root
export DB_PASSWORD=your_mysql_password
```

## 2. Run the Spring Boot backend
```bash
cd backend
mvn spring-boot:run
```
API should be available at `http://localhost:8080/api`. Test `GET http://localhost:8080/api/transactions`.

## 3. Configure and run Expo
Edit `frontend/src/services/api.js` and set `API_BASE_URL` for your environment:
- Android emulator: `http://10.0.2.2:8080/api`
- iOS simulator: `http://localhost:8080/api`
- Physical phone: `http://YOUR_COMPUTER_LAN_IP:8080/api` (phone and computer must share Wi-Fi; allow port 8080 through firewall)

Then run:
```bash
cd frontend
npm install
npx expo start
```
Scan the QR code with Expo Go, or press `a` for Android / `i` for iOS simulator.

## 4. Test the API
Use Postman or curl. Example create request:
```bash
curl -X POST http://localhost:8080/api/transactions \
  -H 'Content-Type: application/json' \
  -d '{"title":"Salary","amount":25000,"type":"INCOME","category":"Salary","transactionDate":"2026-11-12","notes":"Monthly salary"}'
```
See [`docs/API.md`](docs/API.md) for all endpoints and request shape.

## Database design
### `transactions`
| Column | Type | Rules |
|---|---|---|
| id | BIGINT | Primary key, auto increment |
| title | VARCHAR(100) | Required |
| amount | DECIMAL(12,2) | Required, greater than 0 |
| type | VARCHAR(10) | `INCOME` or `EXPENSE` |
| category | VARCHAR(50) | Required |
| transaction_date | DATE | Required |
| notes | VARCHAR(500) | Optional |

## Important beginner notes
- The monthly summary currently uses the device/server current month; the endpoint accepts `month` and `year` for other months.
- This starter intentionally has no user authentication. All data is shared in the local database. Add Spring Security and user ownership before deploying a multi-user version.
- CORS is open for local development. Restrict allowed origins before production.
- Do not commit real passwords, API keys, or personal data.

## Screenshots to add to GitHub
Create a `screenshots/` folder and add: `dashboard.png`, `add-transaction.png`, `transaction-history.png`. Add them to this README once you run the app.

## Future improvements
- JWT authentication and separate user accounts
- Monthly category charts and budget limits
- CSV export and recurring transactions
- Unit/integration tests and CI workflow
- Pagination and configurable date filters

## Resume-ready project description
**Personal Expense Tracker | React Native, Expo, Java, Spring Boot, MySQL**
- Developed a cross-platform expense tracking mobile application using React Native and Expo with a Java Spring Boot REST API.
- Implemented transaction CRUD operations, category-based filtering, and monthly income/expense summaries using Spring Data JPA and MySQL.
- Integrated REST endpoints with the mobile frontend and added input validation and API error handling.

Only list features you have run, tested, and can explain in an interview.

## License
MIT – add a LICENSE file if you want to publish this project under the MIT License.
