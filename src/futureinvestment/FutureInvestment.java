package futureinvestment;

/*
 * CSC-225 - Advanced JAVA Programming
 * Project 2A - InvestmentCalculator Lab Assignment
 * Class Description : This is the driver class for the investment calculator program
 * Author            : Unknown - Code supplied in class
 * Date              : October 5, 2017
 * Filename          : InvestmentCalculator.java
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * <h1>
 * CSC-225 - Advanced JAVA Programming - InvestmentCalculator Lab Assignment
 * </h1>
 * <p>
 * This is the driver class for the investment calculator program
 * </p>
 *
 * @version 1.0
 * @since October 5, 2017
 */
public class FutureInvestment extends Application {

    /**
     * Main method for driver class
     *
     * @param args legacy component for access to system resources
     */
    
    public static void main(String[] args) {
        launch(args);                                                   // Launch the program (primary Stage)
    }

    private TextField tfAnnualInterestRate  = new TextField();          // Define text fields
    private TextField tfNumberOfYears       = new TextField();
    private TextField tfInvestmentAmount    = new TextField();
    private TextField tfFutureValue        = new TextField();
    private Button btCalculate              = new Button("Calculate");  // Define button

    @Override                                                           // Override the start method in the Appliation class
    public void start(Stage primaryStage) {
        // Create UI
        GridPane gridPane = new GridPane();                             // Create a gridpane pane
        gridPane.setHgap(5);                                            // Set the horizontal gap between the elements
        gridPane.setVgap(5);                                            // Set the vertical gap between the elements
        gridPane.add(new Label("Investment Amount:"), 0, 0);            // Add the Investment Amount label to the gridpane
        gridPane.add(tfInvestmentAmount, 1, 0);                         // Add the Investment Amount textbox to the gridpane
        gridPane.add(new Label("Number of Years:"), 0, 1);              // Add the Number of Years label to the gridpane
        gridPane.add(tfNumberOfYears, 1, 1);                            // Add the Number of Years textbox to the gridpane
        gridPane.add(new Label("Annual Interest Rate:"), 0, 2);         // Add the Annual Interest Rate label to the gridpane
        gridPane.add(tfAnnualInterestRate, 1, 2);                       // Add the Annual Interest Rate textbox to the gridpane
        gridPane.add(new Label("Future Value:"), 0, 3);                 // Add the Future Value label to the gridpane
        gridPane.add(tfFutureValue, 1, 3);                              // Add the Future Value textbox to the gridpane
        gridPane.add(btCalculate, 1, 5);                                // Add the Calculate button to the gridpane

        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);                              // Set gridpane alignment to center
        tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);		// Set alignment of Annual Interest Rate textbox to bottom right
        tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);			// Set alignment of Number of Years textbox to bottom right
        tfInvestmentAmount.setAlignment(Pos.BOTTOM_RIGHT);		// Set alignment of Investment Amount textbox to bottom right
        tfFutureValue.setAlignment(Pos.BOTTOM_RIGHT);			// Set alignment of Future Value textbox to bottom right
        tfFutureValue.setEditable(false);				// Set the editable property of the Future Value textbox to false (not allowed to edit)
        GridPane.setHalignment(btCalculate, HPos.RIGHT);		// Set the horizontal alignment of the calculate button to right

        // Process events
        btCalculate.setOnAction(e -> calculateInvestmentValue());     // Add an action listener to the calculate button

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 400, 250);			// Define and create the new scene with defined parameters (size)
        primaryStage.setTitle("InvestmentCalculator"); 			// Set title
        primaryStage.setScene(scene); 					// Place the scene in the stage
        primaryStage.show(); 						// Display the stage
    }
    
    /**
     * Calculate and display the investment amount information
     */

    private void calculateInvestmentValue() {
        // Get values from text fields
        double interest = Double.parseDouble(tfAnnualInterestRate.getText());   // Get the interest rate from textbox, convert to double and store in variable
        int year = Integer.parseInt(tfNumberOfYears.getText());                 // Get the period from the textbox convert to integer and store in variable
        double investmentAmount = Double.parseDouble(tfInvestmentAmount.getText());	// Get the investment amount from the textbox, convert to double and store in variable

        // Create a investment object.  Investment defined in listing 10.2
        Investment investment = new Investment(interest, year, investmentAmount);       //  Create new object using information read from GUI

        //Display monthly payment and total payment
        tfFutureValue.setText(String.format("$%.2f", investment.getFutureValue())); 	// Get the total value of the investment, format it to look good and display it in the textbox
    }

}
