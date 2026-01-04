class Example {
    public static void main(String args[]) {
        int x, y;
        x = 10;
        y = 20;
        if (x < y) System.out.println("x is less than y");
        x *= 2;
        if (x == y) System.out.println("x now equal to y");
        x *= 2; 
        if (x > y) System.out.println("x now greater than y ");
        if (x == y) System.out.println("You won't see this");

    }
}