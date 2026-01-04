import java.util.Random;
// Throwable -> (Exceptin, Error). Exceptin -> (RuntimeException)
class Exc {
    public static void main(String args[]) {
        int d = 0;
        int a = 42 / d;
    }
}

class Exc1 {
    static void subroutine() {
        int d = 0;
        int a = 10 / d;
    }

    public static void main(String args[]) {
        Exc1.subroutine();
    }
}

class Exc2 {
    public static void main(String args[]) {
        int d, a;

        try {
            d = 0;
            a = 42 / d;
            System.out.println("This will not be printed");
        } catch (ArithmeticException e) {
            System.out.println("Division by zero.");
        }
    }
}

class HandleError {
    public static void main(String args[]) {
        int a = 0, b = 0, c = 0;
        Random r = new Random();

        for (int i = 0; i < 3200; i++) {
            try {
                b = r.nextInt();
                c = r.nextInt();
                a = 12345 / (b / c);
            } catch (Exception e) {
                System.out.println("Division by zero." + i);
                a = 0;
                // TODO: handle exception
            }
            System.out.println("a: " + a);
        }
    }
}

class MultipleCatches {
    public static void main(String args[]) {
        try {
            int a = args.length;
            System.out.println("a = " + a);
            int b = 42 / a;
            int c[] = { 1 };
            c[42] = 99;
        } catch (ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index oob: " + e);
        }
        System.out.println("After try/catch blocks.");
    }
}

class SuperSubCatch {
    public static void main(String args[]) {
        try {
            int a = args.length;
            System.out.println("a = " + a);
            int b = 42 / a;
            int c[] = { 1 };
            c[42] = 99;
        } catch (Exception e) {
            System.out.println("Generic Exception " + e);
        }
        // catch(ArithmeticException e) {
        // System.out.println("This is never reached");
        // }

    }
}

class NestTry {
    public static void main(String args[]) {
        try {
            int a = args.length;
            int b = 42 / a;
            System.out.println("a = " + a);

            try { // if one command line arg is used
                if (a == 1)
                    a = a / (a - a);
                if (a == 2) {
                    int c[] = { 1 };
                    c[42] = 99; // generate an out-of-bound exception
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array index out-of-bounds" + e);
            }
        } catch (ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        }
    }
}

class MethNestTry {

    static void nesttry(int a) {
        try {
            if (a == 1)
                a = a / (a - a);

            if (a == 2) {
                int c[] = { 1 };
                c[42] = 99; // generate an out-of-bound exception
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out-of-bounds: " + e);
        }
    }

    public static void main(String args[]) {
        try {
            int a = args.length;
            int b = 42 / a;
            System.out.println("a = " + a);

            nesttry(a);
        } catch (ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        }
    }
}
