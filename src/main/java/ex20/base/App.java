package ex20.base;
/*
 *  UCF COP3330 Summer 2021 Exercise 20 Solution
 *  Copyright 2021 Justin Cepeda
 */

/*
Exercise 20 - Multistate Sales Tax Calculator
More complex programs may have decisions nested in other decisions, so that when one decision is made, additional
decisions must be made.

Create a tax calculator that handles multiple states and multiple counties within each state. The program prompts the
user for the order amount and the state where the order will be shipped.

Wisconsin residents must be changed 5% sales tax with an additional county-level charge. For Wisconsin residents, prompt
for the county of residence.
For Eau Claire county residents, add an additional 0.005 tax.
For Dunn county residents, add an additional 0.004 tax.
Illinois residents must be charged 8% sales tax with no additional county-level charge.
All other states are not charged tax.
The program then displays the tax and the total for Wisconsin and Illinois residents but just the total for everyone
else.

Example Output
What is the order amount? 10
What state do you live in? Wisconsin
What county do you live in? Dane
The tax is $0.50.
The total is $10.50.
Constraints
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.
Challenges
Add support for your state and county.
Allow the user to enter a state abbreviation and county name in upper, lower, or mixed case.
Allow the user to also enter the state’s full name in upper, lower, or mixed case.
Implement the program using data structures to avoid nested if statements.
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("What is the order amount?");
        double amount = in.nextDouble();

        System.out.println("What state do you live in?");
        String state = in.next();

        double taxWi = 0.05;
        double taxEau = 0.005;
        double taxDunn = 0.004;
        double taxIl = 0.08;
        double tax;
        double total;

        if (state.equals("Wisconsin")) {

            System.out.println("What county do you live in?");
            String county = in.next();

            if (county.equals("Eau Claire")) {
                tax = (taxWi + taxEau ) * amount;
                total = tax + amount;
            }

            else if (county.equals("Dunn")) {
                tax = (taxWi + taxDunn ) * amount;
                total = tax + amount;
            }

            else{
                tax = taxWi * amount;
                total = tax + amount;
            }

            System.out.printf("The tax is $%.2f.\nThe total is $%.2f.", tax, total);
        }

        else if (state.equals("Illinois")) {
            tax = taxIl * amount;
            total = tax + amount;

            System.out.printf("The tax is $%.2f.\nThe total is $%.2f.", tax, total);
        }

        else {
            total = amount;
            System.out.printf("The total is $%.2f.", total);
        }
    }
}
