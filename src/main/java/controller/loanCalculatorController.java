package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.text.NumberFormat;

public class loanCalculatorController {
    @FXML
    TextField interestRateTextField;
    @FXML
    TextField numberOfYearsTextField;
    @FXML
    TextField loanAmountTextField;
    @FXML
    TextField monthlyPaymentTextField;
    @FXML
    TextField totalPaymentTextField;
    private float interestRate;
    private int numberOfYears;
    private double loanAmount;
    private double monthlyPayment;
    private double totalPayment;
    private int numberOfMonths;
    private float monthlyInterestRate;

    public void calculateBtnOnAction(ActionEvent actionEvent) {
        try {
            //clear fields for clean look if multiple calculations are made.
            clearCalculatedFields();

            //retrieve all fields
            loanAmount = Double.parseDouble(loanAmountTextField.getText());
            float interestPercentage = Float.parseFloat(interestRateTextField.getText());
            numberOfYears = Integer.parseInt(numberOfYearsTextField.getText());

            //conversions
            interestRate = interestPercentage / 100; // convert interest percentage to decimal
            monthlyInterestRate = (interestRate / 12);// convert interest percentage to a monthly amount
            numberOfMonths = numberOfYears * 12;// convert term of years into months

            //monthly payment formula
            monthlyPayment = loanAmount * ((monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfMonths))) / ((Math.pow(1 + monthlyInterestRate, numberOfMonths)) - 1));
            totalPayment = monthlyPayment * numberOfMonths;

            //display totals with currency format
            monthlyPaymentTextField.appendText(NumberFormat.getCurrencyInstance().format(monthlyPayment));
            totalPaymentTextField.appendText(NumberFormat.getCurrencyInstance().format(totalPayment));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearCalculatedFields() {
        monthlyPaymentTextField.clear();
        totalPaymentTextField.clear();
    }

}
