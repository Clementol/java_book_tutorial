package Generics;

class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    // Return ob.
    T getob() {
        return ob;
    }

    void showType() {
        System.out.println("Type of T is "+
            ob.getClass().getName()
        );
    }

}

class GenDemo {
    public static void main(String args[]) {
        Gen<Integer> iOb;

        iOb = new Gen<Integer>(88);
        iOb.showType();

        int v = iOb.getob();
        System.out.println("value: "+v);
        System.out.println();

        Gen<String> strOb = new Gen<String>("Generics Test");
        strOb.showType();

        String str = strOb.getob();
        System.out.println("Value: "+str);
    }
}

class TwoGen<T, V> {
    T ob1;
    V ob2;

    TwoGen(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    void showTypes() {
        System.out.println("Types of T is "+
            ob1.getClass().getName()
        );

        System.out.println("Type of V is "+
            ob2.getClass().getName()
        );
    }

    T getob1() {
        return ob1;
    }

    V getob2() {
        return ob2;
    }
}

class SimpleGen {
    public static void main(String args[]) {
        TwoGen<Integer, String> tgObj = new TwoGen<Integer, String>(88, "Generics");
        tgObj.showTypes();

        int v = tgObj.getob1();
        System.out.println("value: "+v);

        String str = tgObj.getob2();
        System.out.println("Value: "+ str);
    }
}

class Stats<T extends Number> {
    T[] nums; // array of Number of subclass

    Stats(T[] o) {
        nums = o;
    }

    double average() {
        double sum = 0.0;
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    boolean sameAvg(Stats<?> ob) {
        if (average() == ob.average()) return true;
        return false;
    }
}

class BoundsDemo {
    public static void main(String args[]) {
        Integer inums[] = { 1, 2, 3, 4, 5};
        Stats<Integer> iob = new Stats<Integer>(inums);
        double v = iob.average();
        System.out.println("iob average is "+v);

        Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Stats<Double> dob = new Stats<Double>(dnums);
        double w = dob.average();
        System.out.println("dob average is "+w);
    }
}

class WildcardDemo {
    public static void main(String args[]) {
        Integer inums[] = { 1, 2, 3, 4, 5 };
        Stats<Integer> iob = new Stats<Integer>(inums);
        double v = iob.average();
        System.out.println("iob average is "+v);

        Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Stats<Double> dob = new Stats<Double>(dnums);
        double w = dob.average();
        System.out.println("dob average is "+w);

        Float fnums[] = { 1.0F, 2.0F, 3.0F, 4.0F, 5.0F };
        Stats<Float> fob = new Stats<Float>(fnums);
        double x = fob.average();
        System.out.println("fob aveage is "+x);

        // see which arrays have same average.
        System.out.print("Average of iob and dob ");
        if (iob.sameAvg(dob))
            System.out.println("are the same.");
        else
            System.out.println("Differ.");

        System.out.print("Averages of iob and fob ");
        if (iob.sameAvg(fob))
            System.out.println("are the same");
        else
            System.out.println("differ.");
    }
}

class TwoD {
    int x, y;
    TwoD(int a, int b) {
        x = a;
        y = b;
    }
}

class ThreeD extends TwoD {
    int z;
    ThreeD(int a, int b, int c) {
        super(a, b);
        z = c;
    }
}

class FourD extends ThreeD {
    int t;
    FourD(int a, int b, int c, int d) {
        super(a, b, c);
        t = d;
    }
}

class Coords<T extends TwoD> {
    T[] coords;

    Coords(T[] o) { coords = o; }

    static void showXY(Coords<?>c) {
        System.out.println("X Y Coordinates:");
        for (int i=0; i<c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y);
        }
        System.out.println();
    }

    static void showXYZ(Coords<? extends ThreeD> c) {
        System.out.println("X Y Coordinates:");
        for (int i=0; i<c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y
                + " " + c.coords[i].z
            );
        }
        System.out.println();
    }

    static void showAll(Coords<? extends FourD> c) {
        System.out.println("X Y Coordinates:");
        for (int i=0; i<c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y
                + " " + c.coords[i].z + " " + c.coords[i].t
            );
        }
        System.out.println();
    }

    public static void main(String args[]) {
        TwoD td[] = {
            new TwoD(0, 0),
            new TwoD(7, 9),
            new TwoD(18, 4),
            new TwoD(-1, -23)
        };
        Coords<TwoD> tdlocs = new Coords<TwoD>(td);

        System.out.println("Contents of tdlocs.");
        showXY(tdlocs);
        
        FourD fd[] = {
            new FourD(1, 2, 3, 4),
            new FourD(6, 8, 14, 8),
            new FourD(22, 9, 4, 9),
            new FourD(3, -2, -234, 17),
        };
        Coords<FourD> fdlocs = new Coords<FourD>(fd);
        System.out.println("Contents of fdlocs.");
        showXY(fdlocs);
        showXYZ(fdlocs);
        showAll(fdlocs);
    }
}

class GenMethDemo {
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i=0; i<y.length; i++)
            if (x.equals(y[i])) return true;
        return false;
    }

    public static void main(String args[]) {
        Integer nums[] = { 1, 2, 3, 4, 5 };
        if (isIn(2, nums))
            System.out.println("2 is in nums");
        if (!isIn(7, nums))
            System.out.println("7 is not in nums");
        System.out.println();

        String strs[] = { "one", "two", "three", "four", "five"};
        if (isIn("two", strs))
            System.out.println("two is in strs");
        if (!isIn("seven", strs))
            System.out.println("seven is not in strs");
    }
}


class GenCons {
    private double val;
    <T extends Number> GenCons(T arg) {
        val = arg.doubleValue();
    }
    void showval() {
        System.out.println("val: "+val);
    }
}

class GenConsDemo {
    public static void main(String args[]) {
        GenCons test = new GenCons(100);
        GenCons test2 = new GenCons(123.5F);

        test.showval();
        test2.showval();
    }
}

interface MinMax<T extends Comparable<T>> {
    T min();
    T max();
}

class MyClass<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    MyClass(T[] o) { vals = o; }

    public T min() {
        T v = vals[0];

        for (int i=1; i<vals.length; i++) 
            if (vals[i].compareTo(v) < 0) v = vals[i];

        return v;
    }

    public T max() {
        T v = vals[0];
        for (int i=1; i<vals.length; i++) {
            if (vals[i].compareTo(v) > 0) v = vals[i];
        }
        return v;
    }
}

class GenIFDemo {
    public static void main(String args[]) {
        Integer inums[] = { 3, 6, 2, 8, 6 };
        Character chs[] = { 'b', 'r', 'p', 'w' };

        MyClass<Integer> iob = new MyClass<Integer>(inums);
        MyClass<Character> cob = new MyClass<Character>(chs);

        System.out.println("Max Value in inums: "+iob.max());
        System.out.println("Min value in inums: "+ iob.min());

        System.out.println("Max value in chs: "+ cob.max());
        System.out.println("Max value in chs: "+ cob.min());
    }
}


class NonGen {
    int num;

    NonGen(int i) {
        num = i;
    }

    int getnum() {
        return num;
    }
}

class Gen2<T> extends NonGen {
    T ob;
    
    Gen2(T o, int i) {
        super(i);
        ob = o;
    }

    // Return ob
    T getob() {
        return ob;
    }
}

class HierDemo2 {
    public static void main(String args[]) {
        Gen2<String> w = new Gen2<String>("Hello", 47);
        System.out.print(w.getob() + " ");
        System.out.println(w.getnum());
    }
}


class Gen3<T> {
    T ob;

    Gen3(T o) {
        ob = o;
    }

    T getob() {
        return ob;
    }
}

class Gen4<T> extends Gen3<T> {    
    Gen4(T o) {
        super(o);
    }
}

class HierDemo3 {
    public static void main(String args[]) {
        Gen3<Integer> iOb = new Gen3<Integer>(88);
        Gen4<Integer> iOb2 = new Gen4<Integer>(99);

        Gen3<String> strob2 = new Gen3<String>("Generics Test");
        
        if (iOb2 instanceof Gen4<?>)
            System.out.println("iob2 is instance of Gen2");

        // See if iob2 is some form of Gen.
        if (iOb2 instanceof Gen3<?>)
            System.out.println("iOb2 is instance of Gen");
        System.out.println();

        if (strob2 instanceof Gen4<?>)
            System.out.println("strOb2 is instance of Gen2");

        if (strob2 instanceof Gen3<?>)
            System.out.println("strOb2 is instance of Gen");

        System.out.println();

        if (iOb instanceof Gen4<?>)
            System.out.println("iOb is instance of Gen4");

        if (iOb instanceof Gen3<?>)
            System.out.println("iOb is instance of Gen3");


    }
}


class Gent<T> {
    T ob; // declare an object of type T

    Gent(T o) {
        ob = o;
    }

    T getob() {
        System.out.println("Gen's getob(): ");
        return ob;
    }
}

class Gent2<T> extends Gent<T> {
    Gent2(T o) {
        super(o);
    }

    T getob() {
        System.out.print("Gent2's getob(): ");
        return ob;
    }
}

class OverrideDemo {
    public static void main(String args[]) {
        Gent<Integer> iOb = new Gent<>(88);

        Gent2<Integer> iOb2 = new Gent2<Integer>(99);

        Gent2<?> strOb2 = new Gent2<String>("Generics Test");

        System.out.println(iOb.getob());
        System.out.println(iOb2.getob());
        System.out.println(strOb2.getob());
    }
}

class Gena<T extends Number> {
    T ob;
    T vals[];

    Gena(T o, T[] nums) {
        vals = nums;
    }
}

class GenArrays {
    public static void main(String args[]) {
        Integer n[] = { 1, 2, 3, 4, 5 };
        Gena<Integer> iOb = new Gena<Integer>(50, n);

        Gena<?> gens[] = new Gena[10];
    }
}