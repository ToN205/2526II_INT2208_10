package BTVN_week13_LoanerRisk;

import java.util.*;

public class Loaner {
    private int age;
    private double income;
    private int creditScore;
    private char employmentType;
    private boolean validInput = true;
    private String status = "Processing";
    private final ArrayList<String> actions =
            new ArrayList<>(Arrays.asList("Reject", "Manual Review","Approve"));

    public Loaner() {
        // Default constructor
    }

    public Loaner(int age, double income, int creditScore, char employmentType) {
        setAge(age);
        setIncome(income);
        setCreditScore(creditScore);
        setEmploymentType(employmentType);
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 65) {
            this.age = age;
        }
        else {
            validInput = false;
            System.out.println("Invalid input for age.");
        }
    }

    public void setIncome(double income) {
        if (income >= 5 && income <= 500) {
            this.income = income;
        }
        else {
            validInput = false;
            System.out.println("Invalid input for income.");
        }
    }

    public void setCreditScore(int creditScore) {
        if (creditScore >= 300 && creditScore <= 850) {
            this.creditScore = creditScore;
        }
        else {
            validInput = false;
            System.out.println("Invalid input for credit score.");
        }
    }

    public void setEmploymentType(char employmentType) {
        if (employmentType == 'C' || employmentType == 'F') {
            this.employmentType = employmentType;
        }
        else {
            validInput = false;
            System.out.println("Invalid input for employment type.");
        }
    }

    public String getStatus() {
        if (!validInput) {
            return "Invalid Input";
        }
        setLoanEligibility();
        return status;
    }

    public void setLoanEligibility() {
        int index;

        if (creditScore <= 500) {
            index = 0; // Reject
        }
        else if (creditScore <= 700) {
            if (income < 15) {
                index = 0; // Reject
            }
            else {
                index = 2; // Approve
            }
        }
        else {
            if (income < 15) {
                index = 1; // Manual Review
            }
            else {
                index = 2; // Approve
            }
        }

        if (employmentType == 'F') {
            index--; // Decrease index for freelancers
            if (index < 0) {
                index = 0;
            }
        }
        status = actions.get(index);
    }
}
