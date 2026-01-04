import java.util.Map;

class CharDemo {
    public static void main(String args[]) {
        char ch1, ch2;
        ch1 = 88;
        ch2 = 'Y';
        
        System.out.print("ch1 and ch2: ");
        System.out.println(ch1 + " " + ch2);
        ch1++;
       Map<String, Character> obj = Map.of("ch1", ch1, "ch2", ch2);
       System.out.println(obj);
       System.out.println(obj.containsKey("ch1"));
        System.out.println("ch1 is now " + ch2 + " after increment by 1");
    }
}

