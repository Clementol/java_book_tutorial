

class ChainExcDemo {
    static void demoproc() {
        // create an exception
        NullPointerException e = new NullPointerException("top layer");
        // add a cause
        e.initCause(new ArithmeticException("cause"));
        throw e;
    }

    public static void main(String args[]) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            // display top level exception
            System.out.println("Caught: " + e);

            // display cause exception
            System.out.println("Original cause: " + e.getCause());
        }
    }

}

class MultiCatch {
    public static void main(String args[]) {
        int a = 10, b = 0;
        int vals[] = { 1, 2, 3 };
        try {
            int result = a / b;
            vals[10] = 19;
        } catch (ArithmeticException  | ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: "+ e);
        }
    }
}
