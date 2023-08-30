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
- `getQuotesJson(gson, apiQuote)`:
 This private method reads the list of quotes from a local JSON file, adds the new API quote to the list, and writes the updated list back to the file.
- `getQuote(url)`:
  This method fetches a random quote from the provided URL using the QuotableClient class
- `getDisplayedQuote(file)`:
  This method reads a random quote from a local file to be displayed when there's an error connecting to the internet.

## Contributing

Contributions are welcome! If you have any suggestions or improvements, feel free to submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Testing 
Testing
The Quotable Client includes a suite of tests to verify its functionality:

testGetRandomQuote()
This test ensures that you can successfully fetch a random quote from the API. It checks whether the returned RandomQuoteAPI object is not null, indicating a successful API call.

testGet_Quote_When_Api_Connection_Failed()
This test simulates an API connection failure by providing an invalid URL. It then uses the addRandomQuote() method to attempt to fetch a quote. Since the connection is expected to fail, this test checks whether the returned quote string is not null, indicating that the local fallback mechanism is working.

testApiQuoteSavedLocally()
This test verifies that a quote fetched from the API using the addRandomQuote() method is saved locally and displayed correctly. It checks whether the API quote response and the local quote response are both not null, and whether the local quote response contains the API quote.