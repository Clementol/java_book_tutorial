class VarArgs {
    static void vaTest(int ...v) {
        System.out.print("Number of args: " + v.length + " Contents: ");

        for (int x: v)
            System.out.print(x + " ");
        System.out.println();
    }

    static public void main(String args[]) {
        vaTest(10);
        vaTest(1, 2, 3);
        vaTest();
    }
}

class VarArgs2 {
    static void vaTest(String msg, int ...v) {
        System.out.print(msg + v.length + " Contents: ");

        for (int x: v)
            System.out.print(x + " ");
        System.out.println();
    }
    
    static public void main(String args[]) {
        vaTest("One vararg: ", 10);
        vaTest("Three varargs",1, 2, 3);
        vaTest("No varargs: ");
    }
}



class VarArgs3 { // Overloading methods
    static public void vaTest(int ... v) {
        System.out.print("VaTest(int ...): " + "Number of args: " + v.length + " Contents: ");

        for (int x: v)
            System.out.print(x + " ");
        System.out.println();
    }

    static void vaTest(String msg, int ... v) {
        System.out.print("VaTest(int ...): " + msg + v.length + " Contents: ");

        for (int x: v)
            System.out.print(x + " ");
        System.out.println();
    }

    static void vaTest(boolean ... v) {
        System.out.print("VaTest(int ...): " + "Number of args: " + v.length + " Contents: ");

        for (boolean x: v)
            System.out.print(x + " ");
        System.out.println();
    }
    
    static public void main(String args[]) {
        vaTest(1,2,3);
        vaTest("Three varargs",1, 2, 3);
        vaTest(true, false, true);
    }
}