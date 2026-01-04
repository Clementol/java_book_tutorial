public class InvokedCons {
    int a;
    int b;

    InvokedCons(int i, int j) {
        a = j;
        b = j;
    }

    InvokedCons(int i) {
        a = i;
        b = i;
    }

    InvokedCons() {
        a = 0;
        b = 0;
    }
}

class InvokedCons2 {
    int a;
    int b;

    InvokedCons2(int i, int j) {
        a = i;
        b = j;
    }

    InvokedCons2(int i) {
        this(i, i);
    }

    InvokedCons2() {
        this(0);
    }
}