class Stack {
    private int stck[] = new int[10];
    private int tos;

    Stack(){
        tos = -1;
    }

    void push(int item) {
        if (tos == stck.length-1)
            System.out.println("Stack is full.");
        else
            stck[++tos] = item;
    }

    int pop() {
        if (tos < 0) {
            System.out.println("Stack underflow");
            return 0;
        }
        else {
            return stck[tos--];
        }
    }
}

class TestStack {
    public static void main(String args[]) {
        Stack myStack1 = new Stack();
        Stack myStack2 = new Stack();

        // push some numbers onto the stack
        for (int i=0; i<10; i++) myStack1.push(i);
        for (int i=10; i<20; i++) myStack2.push(i);

        System.out.println("Stack in mystack1: ");
        for (int i=0; i<10; i++)
            System.out.println(myStack1.pop());
        
        System.out.println("Stack in mystack2: ");
        for (int i=0; i<10; i++)
            System.out.println(myStack2.pop());
    }
}