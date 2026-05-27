package triangle;

public class Triangle {
    private int a, b, c;
    private boolean validInput = true;

    public Triangle(int a, int b, int c) {
        setA(a);
        setB(b);
        setC(c);
    }

    public void setA(int a) {
        if (a > 0 && a <= 100) {
            this.a = a;
        } else {
            this.a = -1;
            validInput = false;
            System.out.println("Invalid input.");
        }
    }

    public void setB(int b) {
        if (b > 0 && b <= 100) {
            this.b = b;
        } else {
            this.b = -1;
            validInput = false;
            System.out.println("Invalid Input.");
        }
    }

    public void setC(int c) {
        if (c > 0 && c <= 100) {
            this.c = c;
        } else {
            this.c = -1;
            validInput = false;
            System.out.println("Invalid input.");
        }
    }

    public boolean isValidInput() {
        return validInput;
    }

    public boolean isTriangle() {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public boolean isEquilateral() {
        return (a == b) && (b == c);
    }

    public boolean isIsosceles() {
        return (a == b) || (b == c) || (a == c);
    }
}
