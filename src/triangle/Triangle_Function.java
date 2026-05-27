package triangle;

import java.util.Scanner;

public class Triangle_Function {
    public static String getTriangleType(int a, int b, int c) {
        Triangle trg = new Triangle(a, b, c);

        if (!trg.isValidInput()) {
            return "Invalid input";
        }

        if (!trg.isTriangle()) {
            return "Not a triangle.Triangle";
        }
        if (trg.isEquilateral()) {
            return "Equilateral";
        }
        if (trg.isIsosceles()) {
            return "Isosceles";
        }
        return "Scalene";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b, c;
        System.out.println("Enter the sides of the triangle:");

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        System.out.println(getTriangleType(a, b, c));
    }
}