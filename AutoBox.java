public class AutoBox {
    public static void main(String args[]) {
        Integer iOb = 100;
        Double dOb = 98.6;
        dOb = dOb + iOb;
        System.out.println("dOb after expression: "+dOb);

        switch(iOb) {
            case 1: System.out.println("one");
            break;
            case 2: System.out.println("two");
            break;
            default: System.out.println("error");
        }
    }
}
