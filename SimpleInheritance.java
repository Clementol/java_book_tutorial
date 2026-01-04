class A {
    int i;
    private int j;

    void setij(int x, int y) {
        i = x;
        j = y;
    }

    void showij() {
        System.out.println("i and j: " + i + " " + j);
    }
}

class B extends A {
    int k;
    A a = new A();
    
    void showk() {
        System.out.println("K: " + k);
    }

    void sum() {
        System.out.println("i+j+k: " + (i+j+k));
    }
    
}

class SimpleInheritance {
    public static void main(String args[]) {
        A superOb = new A();
        B subOb = new B();
        
        superOb.setij(10, 12);
        System.out.println("Content of superOb: ");
        superOb.showij();
        System.out.println();

        subOb.setij(7, 8);
        subOb.k = 9;
        System.out.println("Content of subOb: ");
        subOb.showij();
        subOb.showk();
        System.out.println();

        System.out.println("Sum of i, j and k in subOb:");
        subOb.sum();
    }
}
