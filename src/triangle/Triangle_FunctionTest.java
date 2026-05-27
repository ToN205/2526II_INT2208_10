package triangle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Triangle_FunctionTest {

    @ParameterizedTest(name = "{index} => a={0}, b={1}, c={2} | Expected: {3}")
    @CsvSource({
            // a,  b,   c,   Expected Output       // TC ID
            " 10,  20,  50,  Not a triangle.Triangle",      // TC_05
            "  1,   2,   3,  Not a triangle.Triangle",      // TC_06
            " 50,  50,  50,  Equilateral",         // TC_07
            "100, 100, 100,  Equilateral",         // TC_08
            " 50,  50,  40,  Isosceles",           // TC_09
            " 40,  50,  50,  Isosceles",           // TC_10
            " 50,  40,  50,  Isosceles",           // TC_11
            "  3,   4,   5,  Scalene",             // TC_12
            " 98,  99, 100,  Scalene"              // TC_13
    })
    void testClassifyTriangle(int a, int b, int c, String expectedOutput) {
        String actualOutput = Triangle_Function.getTriangleType(a, b, c);

        assertEquals(expectedOutput, actualOutput,
                "Catch errors with edges: " + a + ", " + b + ", " + c);
    }
}