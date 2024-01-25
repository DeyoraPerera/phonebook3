# MyPhoneBook - Arrays Assignment

## Project Description

The MyPhoneBook project is a Java application that simulates a phone book using object-oriented programming principles. It allows users to perform various operations on the phone book, such as adding, editing, viewing, and removing entries. The data is stored in a 2D array, and the program provides methods to interact with this data, including searching, editing, and file I/O.

## Class Structure

### MyPhoneBook Class

- **Global Variables:**
  - `numEntries`: Tracks the number of entries in the phone book.
  - `contactFound`: A 2D array to store contacts found during a search operation.
  - `data`: A 2D array to store contact information (first name, last name, phone number, email, and address).

- **Constructor:**
  - Initializes `numEntries` to 0.

- **Methods:**
  - `add`: Adds a new entry to the phone book.
  - `edit`: Edits an existing entry based on first and last names.
  - `viewAll`: Returns a pointer to the entire phone book data.
  - `entry`: Returns the number of entries in the phone book.
  - `lookUp`: Searches for entries based on first or last names and returns a copy of the found entries.
  - `remove`: Removes an entry based on first and last names.
  - `write`: Writes the phone book data to a file named "data.txt".
  - `read`: Reads data from the "data.txt" file and populates the phone book.

## Getting Started

To run the MyPhoneBook application:

1. Compile the Java file: `javac MyPhoneBook.java`
2. Run the compiled file: `java MyPhoneBook`


