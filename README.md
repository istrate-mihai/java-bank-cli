# 🏦 Java Bank CLI

A command-line banking application built in Java demonstrating core Object-Oriented Programming principles — encapsulation, constructors, static members, and multi-class design.

> **Portfolio Project** — Part of a structured Java mastery curriculum (Tier 2: OOP Fundamentals)

---

## 📸 Demo

```
===== BANK MENU =====
Enter a number from the options below:
1.Create account
2.Deposit
3.Withdraw
4.Check balance
5.Print transaction history
6.Show total accounts
0. Exit

> 1
Enter Account Number: ACC001
Enter Account Owner: Mihai
Enter Initial Account Deposit: 1000
Account created successfully.

> 2
Choose account, enter account number: ACC001
Enter amount to deposit: 500
Deposited amount: 500.0. New balance: 1500.0

> 5
Transaction history:
Transaction{type = DEPOSIT, amount = 1000.0, balanceAfter = 1000.0}
Transaction{type = DEPOSIT, amount = 500.0, balanceAfter = 1500.0}
```

---

## ✨ Features

- **Create up to 5 bank accounts**, each with a unique account number and owner
- **Deposit & withdraw** funds with full input validation (rejects negative and zero amounts, insufficient funds)
- **Transaction history** — every deposit and withdrawal is recorded, including the opening balance
- **Account lookup** by account number
- **Live account overview** showing all created accounts and their balances
- **Static account counter** tracking total accounts created across the application

---

## 🏗️ Project Structure

```
src/
├── Main.java               # CLI entry point and menu loop
└── Classes/
    ├── BankAccount.java    # Core banking logic with encapsulated state
    └── Transaction.java    # Immutable transaction record
```

### Class Responsibilities

| Class | Responsibility |
|---|---|
| `BankAccount` | Holds account state, validates operations, stores transaction history |
| `Transaction` | Immutable record of a single deposit or withdrawal |
| `Main` | User-facing CLI loop, account array management |

---

## 🧠 OOP Concepts Demonstrated

| Concept | Where |
|---|---|
| **Encapsulation** | All fields in `BankAccount` and `Transaction` are `private` with controlled access via getters |
| **Constructors** | Both classes use constructors with validation, throwing `IllegalArgumentException` on bad input |
| **Static members** | `totalAccounts` counter and `getTotalAccounts()` belong to the class, not instances |
| **Method design** | `addTransaction()` is `private` — internal helper not exposed as public API |
| **`toString()` override** | Both classes produce readable output for display and debugging |
| **Input validation** | Negative balances, invalid transaction types, insufficient funds all handled gracefully |

---

## 🚀 Getting Started

### Prerequisites

- Java 21 (JDK) — [Download from Adoptium](https://adoptium.net)
- Any IDE (IntelliJ IDEA recommended) or terminal

### Run from IntelliJ

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Run `Main.java`

### Run from terminal

```bash
# Compile
javac -d out src/Main.java src/Classes/BankAccount.java src/Classes/Transaction.java

# Run
java -cp out Main
```

---

## 🔍 Key Implementation Details

**Opening balance is recorded as a transaction** — when an account is created with an initial deposit, it's immediately stored as a `DEPOSIT` transaction so the history is complete from day one.

**Transaction history is capped at 100 entries** — the `Transaction[]` array has a fixed size with a guard that warns the user if the limit is reached, preventing array index overflow.

**Scanner newline flushing** — `nextInt()` and `nextDouble()` leave a newline in the buffer; the code handles this explicitly with `scanner.nextLine()` calls before reading String input.

---

## 📌 Limitations & Future Improvements

- [ ] Replace fixed-size arrays with `ArrayList` (covered in Tier 5)
- [ ] Persist accounts to a file so data survives between sessions (covered in Tier 6)
- [ ] Add proper exception handling with `try/catch` (covered in Tier 4)
- [ ] Add unit tests with JUnit 5 (covered in Tier 12)
- [ ] Replace CLI with a JavaFX desktop UI (covered in Tier 17)

---

## 👤 Author

**Mihai Istrate**  
Java development portfolio — built as part of a 20-tier Java mastery curriculum.

---

## 📄 License

MIT License — free to use and adapt.
