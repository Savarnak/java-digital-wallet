# Java Console Application

A console-based Java application developed using Java 21 and structured with a simple layered architecture.
The project demonstrates core Object-Oriented Programming (OOP) concepts, modular code organization, and service-based design using only the Java Standard Library.

## What the Project Does

This project is a simple digital wallet system that allows users to:

- Create a wallet using their name and mobile number
- Add money to a wallet
- Send money from one wallet to another
- View wallet balance
- View transaction history
- Block wallets when needed
- Access admin-only options to view all wallets and the total money in the system

## Features

- Console-based user interaction using `Scanner`
- Layered project structure
- Model and Service class separation
- In-memory data handling using:
  - `HashMap`
  - `ArrayList`
  - `HashSet`
- Modular and beginner-friendly codebase
- Built without external frameworks or libraries

## Tech Stack

| Technology | Usage |
| --- | --- |
| Java 21 | Core programming language |
| IntelliJ IDEA | Development environment |
| Java Collections Framework | Data storage and management |
| Scanner | Console input handling |

## Project Structure

```text
src/
│
├── model/
│   └── Contains model/entity classes
│
├── service/
│   └── Business logic and operations
│
└── main/
    └── WalletApplication.java - Application entry point
```

## Concepts Used

- Object-Oriented Programming (OOP)
- Encapsulation
- Modular programming
- Collections Framework
- Service-layer architecture
- User input handling

## How to Run

1. Clone the repository:

   ```bash
   git clone <your-repository-link>
   ```

2. Open the project in IntelliJ IDEA.
3. Make sure Java 21 is installed.
4. Run the `WalletApplication.java` file.

## Future Improvements

- Add database integration
- Implement file storage
- Create GUI version
- Add authentication system
- Convert into a Maven/Gradle project
