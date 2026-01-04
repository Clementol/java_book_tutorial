import java.util.Random;

enum Apple {
Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

enum Apple2 {
    Jonathan(10), GoldenDel(9), RedDel, Winesap(15), Cortland(8);

    private int price;
    Apple2(int p) { price = p; }
    Apple2() { price = -1; }
    int getPrice() { return price; }
}

class EnumDemo {
    public static void main(String args[]) {
        Apple ap;
        ap = Apple.RedDel;

        // output an enum value
        System.out.println("Value of ap: "+ap);
        System.out.println();

        ap = Apple.GoldenDel;

        // Compare two enum values
        if (ap == Apple.GoldenDel)
            System.out.println("ap contains GoldenDel. \n");

        // use an enum to control a switch statement
        switch (ap) {
            case Jonathan:
                System.out.println("Jonathan is red");
                break;
            case GoldenDel:
                System.out.println("Golden Delicious is yellow");
                break;
            case RedDel:
                System.out.println("Red Delicious is red.");
                break;
            case Winesap:
                System.out.println("Winesap is red");
                break;
            case Cortland:
                System.out.println("Cortland is red.");
                break;
            default:
                break;
        }

    }
}

class EnumDemo2 {
    public static void main(String args[]) {
        Apple ap;
        System.out.println("Here are all Apple cnstants: ");
        // use values()
        Apple allapples[] = Apple.values();
        for (Apple a: allapples)
            System.out.println(a);
        System.out.println();
        // use valueOf()
        ap = Apple.valueOf("Winesap");
        System.out.println("ap contains "+ap);

    }
}

class EnumDemo3 {
    public static void main(String args[]) {
        Apple2 ap;
        // Display price of winesap.
        System.out.println("Winesap costs "+ Apple2.Winesap.getPrice() + " cents. \n");

        // Display all apples and prices.
        System.out.println("All apple prices:");
        for (Apple2 a: Apple2.values())
            System.out.println(a + " costs "+ a.getPrice() + " cents.");
    }
}

class EnumDemo4 {
    public static void main(String args[]) {
        Apple ap, ap2, ap3;

        // Obtain all ordinal values using ordinal().
        System.out.println("Here are all apple constants and their ordinal vlaues");
        for (Apple a: Apple.values())
            System.out.println(a + " " + a.ordinal());
        ap = Apple.RedDel;
        ap2 = Apple.GoldenDel;
        ap3 = Apple.RedDel;
        System.out.println();

        // Demonstrate compareTo() and equals()
        if (ap.compareTo(ap2) < 0)
            System.out.println(ap + " comes before "+ap2);
        if (ap.compareTo(ap2) > 0)
            System.out.println(ap2 + " comes before "+ ap);
        if (ap.compareTo(ap3) == 0)
            System.out.println(ap + " equals "+ ap3);

        System.out.println();

        if (ap.equals(ap2))
            System.out.println("Error!");
        if (ap.equals(ap3))
            System.out.println(ap + " equals "+ap3);
        if (ap == ap3)
            System.out.println(ap + " == " + ap3);
    }
}

enum Answers {
    NO, YES, MAYBE, LATER, SOON, NEVER
}

class Question {
    Random rand = new Random();
    Answers ask() {
        int prob = (int) (100 * rand.nextDouble());

        if (prob < 15)
            return Answers.MAYBE; // 15%
        else if (prob < 30)
            return Answers.NO; // 15%
        else if (prob < 60)
            return Answers.YES; // 30%
        else if (prob < 75)
            return Answers.LATER; // 15%
        else if (prob < 98)
            return Answers.SOON; // 13%
        else
            return Answers.NEVER; // 2%
    }
}

class AskMe {
    static void answer(Answers result) {
        switch (result) {
            case NO:
                System.out.println("No");
                break;
            case YES:
                System.out.println("Yes");
                break;
            case MAYBE:
                System.out.println("Maybe");
                break;
            case LATER:
                System.out.println("Later");
                break;
            case SOON:
                System.out.println("Soon");
                break;
            case NEVER:
                System.out.println("Never");
                break;
            default:
                break;
        }
    }

    public static void main(String args[]) {
        Question q = new Question();
        answer(q.ask());
        answer(q.ask());
        answer(q.ask());
        answer(q.ask());
    }
}
