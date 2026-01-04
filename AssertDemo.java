
class AssertDemo {
    static int val = 3;
    
    // Return an intger
    static int getnum() {
        return val--;
    }

    public static void main(String args[]) {
        int n;
        for (int i=0; i<10; i++) {
            n = getnum();

            assert n > 0 : "n is nagetive!";
            System.out.println("n is "+n);
        }
    }
}
