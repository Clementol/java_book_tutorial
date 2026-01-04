class NativeDemo {
    int i;

    public static void main(String args[]) {
        NativeDemo ob = new NativeDemo();
        ob.i = 10;
        System.out.println("This is ob.i before the native method: "+ ob.i);
        ob.test();
    }

    public native void test();

    // Load DIL that contains static method
    static {
        System.loadLibrary("NativeDemo");
    }
}
