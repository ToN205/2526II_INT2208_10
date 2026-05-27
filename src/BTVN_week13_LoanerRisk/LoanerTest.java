package BTVN_week13_LoanerRisk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LoanerTest {

    @ParameterizedTest(name = "{0}: age={1}, icm={2}, c={3}, category=''{4}'' => Expected: {5}")
    @CsvSource({
            // TC ID, age, icm, c, category, Expected Output

            // --- TEST INVALID INPUT (TC 01 - TC 09) ---
            "TC 01, 17, 252.5, 575, C, Invalid Input",
            "TC 02, 66, 252.5, 575, C, Invalid Input",
            "TC 03, 40,   4.9, 575, C, Invalid Input",
            "TC 04, 40, 500.1, 575, C, Invalid Input",
            "TC 05, 40, 252.5, 299, C, Invalid Input",
            "TC 06, 40, 252.5, 851, C, Invalid Input",
            "TC 07, 40, 252.5, 575, c, Invalid Input",
            "TC 08, 40, 252.5, 575, fs, Invalid Input",
            "TC 09a, 40, 252.5, 575, A, Invalid Input",
            "TC 09b, 40, 252.5, 575, ' ', Invalid Input",

            // --- TEST CÁC RULE TỪ 1 ĐẾN 8 (TC 10 - TC 31) ---
            "TC 10, 40, 252.5, 500, C, Reject",
            "TC 11, 40, 252.5, 300, C, Reject",
            "TC 12, 40,  10.0, 575, C, Reject",
            "TC 13, 40,  14.9, 501, C, Reject",

            "TC 14, 40,  15.0, 501, C, Approve",
            "TC 15, 40, 252.5, 575, C, Approve",
            "TC 16, 40, 252.5, 700, C, Approve",

            "TC 17, 40,  15.0, 501, F, Manual Review",
            "TC 18, 40, 252.5, 575, F, Manual Review",
            "TC 19, 40, 252.5, 700, F, Manual Review",

            "TC 20, 40,  10.0, 800, C, Manual Review",
            "TC 21, 40,  14.9, 701, C, Manual Review",
            "TC 22, 40,  14.9, 850, C, Manual Review",

            "TC 23, 40,  10.0, 800, F, Reject",
            "TC 24, 40,  14.9, 701, F, Reject",
            "TC 25, 40,  14.9, 850, F, Reject",

            "TC 26, 40,  15.0, 701, C, Approve",
            "TC 27, 40, 252.5, 850, C, Approve",
            "TC 28, 40, 252.5, 850, C, Approve",

            "TC 29, 40,  15.0, 701, F, Manual Review",
            "TC 30, 40, 252.5, 850, F, Manual Review",
            "TC 31, 40, 252.5, 850, F, Manual Review"
    })

    void testEvaluateRiskRules(String tcId, int age, double icm, int c, char e, String expectedOutput) {

        String actualOutput = Loaner_Function.getLoanEligibility(age, icm, c, e);

        assertEquals(expectedOutput, actualOutput,
                "Fail at " + tcId);
    }
}