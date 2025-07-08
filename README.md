# 📚 Quantum Bookstore

Quantum Bookstore is a simple, extensible Java-based system that simulates an online bookstore with support for multiple types of books, including:

- 📦 **PaperBook** (physical, limited quantity, shipped to an address)
- 📧 **EBook** (digital, delivered via email)
- 🆓 **DemoBook** (free, not for sale, sent as a demo copy)

All console output is prefixed with `Quantum Bookstore:` to clearly identify system messages.

---

## 🚀 Features

- ✅ Add books to the inventory (`PaperBook`, `EBook`, `DemoBook`)
- ✅ Automatically remove outdated books based on publication year
- ✅ Sell books using ISBN with quantity, email, and shipping address
- ✅ Automatically sends orders to:
  - `ShippingService` for physical books
  - `MailService` for digital or demo books
- ✅ Print details for all available books
- ✅ Easily extensible to support more book types

---

## 🧱 Class Structure

| Class             | Responsibility                                                                 |
|------------------|----------------------------------------------------------------------------------|
| `Book`           | Abstract base class for all types of books                                      |
| `PaperBook`      | Represents physical books with stock and shipping                               |
| `Ebook`          | Represents digital books with a file type and email delivery                    |
| `DemoBook`       | Represents free books not for sale, sent as demos                               |
| `Library`        | Manages book inventory, cleaning outdated books, and processing sales           |
| `QuantumPrint`   | Wrapper for printing all messages with a prefix `Quantum Bookstore:`            |
| `MailService`    | Stub for sending emails                                                         |
| `ShippingService`| Stub for handling shipping                                                       |
| `QuantumBookstoreFullTest` | Main class used to demonstrate and test the system                     |

---

## 🧪 Sample Output

Quantum Bookstore: Books in the library:
Quantum Bookstore: Title: Quantum Physics, Author: Basel Ebaid, ISBN: 1234567890, Year: 2023, Price: $29.99
Quantum Bookstore: Title: Quantum Mechanics, Author: Mohammed Saad, ISBN: 0987654321, Year: 2022, Price: $19.99
Quantum Bookstore: Title: Quantum Computing, Author: Karim Adel, ISBN: 1122334455, Year: 2023
...
Quantum Bookstore: Total paid: $2999.0
Quantum Bookstore: Shipped to: 123 Main St
...


---

## 🛠️ How to Run

Make sure you have **Java 8+** installed.

1. Clone the repository or copy the source code into a folder
2. Compile the project:

```bash
javac *.java

java QuantumBookstoreFullTest
