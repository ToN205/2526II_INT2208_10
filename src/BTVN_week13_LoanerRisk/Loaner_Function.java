package BTVN_week13_LoanerRisk;

public class Loaner_Function {
    public static String getLoanEligibility(int age, double income, int creditScore, char employmentType) {
        Loaner loaner = new Loaner(age, income, creditScore, employmentType);
        return loaner.getStatus();
    }

    public static void main(String[] args) {
        // Example usage
        int age = 30;
        double income = 50;
        int creditScore = 650;
        char employmentType = 'C';

        String eligibility = getLoanEligibility(age, income, creditScore, employmentType);
        System.out.println("Loan Eligibility: " + eligibility);
    }
}
