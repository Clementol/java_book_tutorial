class Test {
    int a;
    public int b;
    private int c;

    void setc(int i) {
        c = i;
    }

    int getc() {
        return c;
    }
    
}
class AccessTest {
    public static void main(String args[]) {
        Test ob = new Test();
        ob.a = 20;
        ob.b = 20;
        
        ob.setc(100);
       System.out.println("a, b, and c: " + ob.a + " " + ob.a + " " + ob.getc());
    }
}
