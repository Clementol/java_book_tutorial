
class ThrowDemo {
    static void demoproc() {
        try {
            throw new NullPointerException("demo");
        } catch (Exception e) {
            System.out.println("Caught inside demoproc.");
            throw e; // rethrow the exception
        }
    }

    static void throwOne() throws IllegalAccessException {
        System.out.println("Inside throwOne.");
        throw new IllegalAccessException("demo");
    }

    public static void main(String args[]) {
        try {
            throwOne();
            demoproc();
        } catch (Exception e) {
            System.out.println("Recaught: "+e.getMessage());
        }
    }
}

class FinallyDemo {
    static void procA() {
        try {
            System.out.println("inside procA");
            throw new RuntimeException("demo");
        } finally{
            System.out.println("procA's finally");
        }
    }

    static void procB() {
        try {
            System.out.println("inside procB");
            return;
        } finally{
            System.out.println("procB's finally");
        }
    }

    static void procC() {
        try {
            System.out.println("inside procC");
        } finally {
            System.out.println("procC's finally");
        }
    }

    public static void main(String args[]) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
        procB();
        procC();
    }
}

class MyException extends Exception {
    private int detail;

    MyException(int a) {
        detail = a;
    }

    public String toString() {
        return "MyException["+ detail + "]";
    }
}

class ExceptionDemo {
    static void compute(int a) throws MyException {
        if (a > 10)
            throw new MyException(a);
        System.out.println("Normal exit");
    }
    public static void main(String args[]) {
        try{
            compute(1);
            compute(20);
        } catch (MyException e) {
            System.out.println("Caught "+e);
        }
    }
}