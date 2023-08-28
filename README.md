# Random Quote Display Application

This is a simple Java application that displays a random quote from a JSON file. The application uses the Gson library to parse the JSON file and retrieve random quotes.

## Installation

1. Clone the repository to your local machine using the following command:

    ```
    git clone https://github.com/yourusername/your-repo-name.git
    ```

2. Open the project in your preferred Java development environment (e.g., IntelliJ IDEA, Eclipse, etc.).

3. Make sure you have the required dependencies installed. This application relies on the Gson library for JSON parsing. The dependencies are managed through Gradle.

4. Build the project using Gradle. Run the following command in the terminal:

    ```
    ./gradlew build
    ```

## Usage

1. Ensure that you have built the project using the previous step.

2. Locate the `recentquotes.json` file in the `app/src/main/resources/` directory. This file contains the quotes that will be displayed.

3. Run the `QuoteApp` class to display a random quote. You can do this in your IDE by right-clicking on the `QuoteApp` class and selecting "Run".

4. Each time you run the `QuoteApp`, a random quote along with its author will be displayed in the console.

## Methods Used

This application uses the following methods:

- `getRandomNumber(int min, int max)`: Generates a random number between the specified range.
- `getDisplayedQuote()`: Retrieves a random quote from the JSON file and returns it as a formatted string.

## Contributing

Contributions are welcome! If you have any suggestions or improvements, feel free to submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
