# REST API
Base URL: `http://localhost:8080/api`

| Method | Endpoint | Description |
|---|---|---|
| GET | `/transactions` | List all transactions, newest first |
| GET | `/transactions?type=EXPENSE` | Filter by `INCOME` or `EXPENSE` |
| GET | `/transactions/summary` | Current-month totals |
| GET | `/transactions/summary?month=11&year=2026` | Totals for a selected month |
| POST | `/transactions` | Create a transaction |
| PUT | `/transactions/{id}` | Update a transaction |
| DELETE | `/transactions/{id}` | Delete a transaction |

POST/PUT JSON example:
```json
{
  "title": "Groceries",
  "amount": 850.50,
  "type": "EXPENSE",
  "category": "Food",
  "transactionDate": "2026-11-12",
  "notes": "Weekly groceries"
}
```
Summary response fields: `month`, `year`, `income`, `expenses`, `balance`. Amounts are JSON numbers.
