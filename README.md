# CSV Parser for Employee Data

This is an educational Java project that demonstrates how to read employee data from a CSV file, parse it, and convert it into a `List` of `Person` objects. Each `Person` object holds information about an employee, including a reference to a `Division` object.

The project is built using Maven and follows modern development practices, including object-oriented modeling, code documentation with Javadoc, and unit testing with JUnit.

## Features

- Reads data from `foreign_names.csv` using a semicolon (`;`) as the separator.
- Skips the header row automatically during the parsing process.
- Maps each CSV row into a strongly-typed `Person` object.
- Automatically creates and caches `Division` objects to ensure that each department is represented by a single object, avoiding duplicates.
- Correctly parses various data types, including integers, strings, and dates (`dd.MM.yyyy` format).

## Technologies Used

- Java 11+
- Maven
- OpenCSV
- JUnit 5

## Build and Run

1.  **Clone the repository:**

    ```bash
    git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY.git
    cd YOUR-REPOSITORY
    ```

2.  **Build the project using Maven:**
    This command will compile the source code, run the unit tests, and package the application into an executable `.jar` file.

    ```bash
    mvn clean package
    ```

3.  **Run the application:**
    Execute the `.jar` file created in the `target/` directory.
    ```bash
    java -jar target/csv-parser-app-1.0-SNAPSHOT.jar
    ```
    After running, the application will print the total number of records successfully read and display the first ten `Person` objects as a sample.

## Documentation

The project includes comprehensive Javadoc comments for all major classes and public methods, making the codebase easy to understand.

To generate the complete HTML documentation, run the following Maven command in the project's root directory:

```bash
mvn javadoc:javadoc
```

The generated documentation will then be available at `target/site/apidocs/index.html`. Simply open this file in your web browser to view it.
