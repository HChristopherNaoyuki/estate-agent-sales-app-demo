# Property Sales App

This Java application provides a graphical interface for estate agents to calculate their commission based on property sales. It allows users to enter details such as agent name, property price, commission percentage, and agent location. The app computes the commission and displays it in a report area.

## Features

- **User Input**: Enter agent details, property price, and commission rate.
- **Commission Calculation**: Calculates commission based on the entered property price and commission percentage.
- **Report Display**: Displays calculated commissions in a text area.
- **Reset Functionality**: Clear all fields and reports with a button click.

## Components

- **Swing Framework**: Utilizes Java's Swing library for the GUI components.
- **GridBagLayout**: Layout manager for arranging components in a flexible grid.
- **Number Formatting**: Formats commission values in a European style.

## Classes

- **PropertySalesApp**: Main class that sets up the GUI and handles user input and actions.
- **EstateAgent**: Contains methods for calculating total sales, commission, and determining the top agent based on sales data.
- **EstateAgentTest**: JUnit test class for testing the functionality of the `EstateAgent` class.

## How to Run

1. **Compile** the Java files.
2. **Run** the `PropertySalesApp` class to launch the application.
3. **Input** data into the fields and click on "Calculate Commission" to see the results.

## Testing

The application includes unit tests for the `EstateAgent` class, ensuring accurate calculations for total sales and commissions, as well as determining the top agent.
