interface MyIF {
    int getNumber();

    default String getString() {
        return "Default String";
    }

    static int getDefaultNumber() {
        return 0;
    }
}

class MyIFImp implements MyIF {
    public int getNumber() {
        return 100;
    }
}

class DefaultMehtodDemo {
    public static void main(String args[]) {
        MyIFImp obj = new MyIFImp();

        System.out.println(obj.getNumber());

        System.out.println(obj.getString());

       int defNumb = MyIF.getDefaultNumber();

    }
}