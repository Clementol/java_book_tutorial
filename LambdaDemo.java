import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

interface MyNumber {
    double getValue();
}

interface NumericTest {
    boolean test(int n);
}

class LambdaDemo {
    public static void main(String args[]) {
        MyNumber myNum;
        myNum = () -> 123.45;
        System.out.println("A Fixed value: "+ myNum.getValue());

        myNum = () -> Math.random() * 100;
        System.out.println("A random value: "+ myNum.getValue());
        System.out.println("Another random value: "+ myNum.getValue());

    }
}


class LambdaDemo2 {
    public static void main(String args[]) {
        NumericTest isEven = (n) -> (n%2) == 0;

        if (isEven.test(10)) System.out.println("10 is even");
        if (!isEven.test(9)) System.out.println("9 is not even");

        NumericTest isNonNeg = (n) -> n >= 0;

        if (isNonNeg.test(1)) System.out.println("1 is non-negative");
        if (isNonNeg.test(-1)) System.out.println("-1 is negative");

    }
}
interface NumericTest2 {
    boolean test(int n, int d);
}

class LambdaDemo3 {
    public static void main(String args[]) {
        NumericTest2 isFactor = (n, d) -> (n%d) == 0;
        if (isFactor.test(10, 2))
            System.out.println("2 is a factor of 10");

        if (!isFactor.test(10, 3))
            System.out.println("3 is not a factor of 10");
    }
}

interface NumericFunc {
    int func(int n);
}

class BlockLambdaDemo {
    public static void main(String args[]) {
        NumericFunc factorial = (n) -> {
            int result = 1;
            for (int i=1; i<= n; i++) {
                result = i * result;
            }
            return result;
        };
        System.out.println("The factorial of 3 is "+ factorial.func(3));
        System.out.println("The factorial of 5 is "+ factorial.func(5));
    }
}

interface StringFunc {
    String func(String n);
}

class BloackLambdaDemo2 {
    public static void main(String args[]) {
        StringFunc reverse = (str) -> {
            String result = "";
            int i;
            for (i = str.length()-1; i>=0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        System.out.println("Lambda reversed is "+ reverse.func("Lambda"));
        System.out.println("Expression reversed is "+ reverse.func("Expression"));
    }
}

interface SomeFunc<T> {
    T func(T t);
}

class GenericFunctionalInterfaceDemo {
    public static void main(String args[]) {
        SomeFunc<String> reverse = (str) -> {
            String result = "";
            int i;
            for (i = str.length()-1; i>=0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        System.out.println("Lambda reversed is "+ reverse.func("Lambda"));
        System.out.println("Expression reversed is "+ reverse.func("Expression"));

        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i=1; i <= n; i++) {
                result = i*result;
            }
            return result;
        };
        System.out.println("The factorial of 3 is "+ factorial.func(3));
        System.out.println("The factorial of 5 is "+ factorial.func(5));

    }
}


class LambdasAsArgumentsDemo {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String args[]) {
        String inStr = "Lambdas add power to Java";
        String outStr;
        System.out.println("Here is input string: "+ inStr);
        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("The string in uppercase: "+ outStr);

        outStr = stringOp((str) -> {
            String result = "";
            int i;
            for (i=0; i< str.length(); i++)
                if (str.charAt(i) != ' ')
                    result += str.charAt(i);
            return result;
        }, inStr);
        System.out.println("The string with spaces removed: "+outStr);

        StringFunc reverse = (str) -> {
            String result = "";
            int i;

            for (i=str.length()-1; i>=0; i--)
                result += str.charAt(i);
            return result;
        };
        System.out.println("The string reversed: "+ stringOp(reverse, inStr));
    }
}

interface DoubleNumericArrayFunc {
    double func(double n[]) throws EmptyArrayException;
}

class EmptyArrayException extends Exception {
    EmptyArrayException() {
        super("Array Empty");
    }
}

class LambdaExceptionDemo {
    public static void main(String args[]) throws EmptyArrayException {
        double[] values = { 1.0, 2.0, 3.0, 4.0 };

        DoubleNumericArrayFunc average = (n) -> {
            double sum = 0;
            if (n.length == 0)
                throw new EmptyArrayException();

            for (int i=0; i<n.length; i++) {
                sum += n[i];
            }
            return sum / n.length;
        };
        System.out.println("The average is "+ average.func(values));
        System.out.println("The average is "+ average.func(new double[0]));
    }
}


interface MyFunc {
    int func(int n);
}

class VarCapture {
    public static void main(String args[]) {
        int num = 10;
        MyFunc myLMyFunc = (n) -> {
            int v = num + n;
            return v;
        };
    }
}

class MyStringOps {
    static String strReverse(String str) {
        String result = "";
        int i;
        for (i = str.length() -1; i >= 0; i--) 
            result += str.charAt(i);
        return result;
    }
}

class MethodRefDemo {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }
    public static void main(String[] args) {
        String inStr = "Lambdas add power to Java";
        String outStr;

        outStr = stringOp(MyStringOps::strReverse, inStr);

        System.out.println("Original string: "+inStr);
        System.out.println("String reversed: "+outStr);
    }
}


interface MyFunc2<T> {
    int func(T[] vals, T v);
}

class MyArrayOps {
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;

        for(int i=0; i < vals.length; i++)
            if (vals[i] == v) count++;
        return count;
    }
}

class GenericMethodRefDemo {
    static <T> int myOp(MyFunc2<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String args[]) {
        Integer[] vals = { 1, 2, 3, 4, 2, 3, 4, 4, 5 };
        String[] strs = { "One", "Two", "Three", "Two" };
        int count;

        count = myOp(MyArrayOps::<Integer>countMatching, vals, 4);
        System.out.println("vals contains "+ count + " 4s");

        count = myOp(MyArrayOps::<String>countMatching, strs, "Two");
        System.out.println("str contains "+ count + " Twos");
    }
}

class MyClass {
    private int val;

    MyClass(int v) { val = v; }
    int getVal() { return val; }

}

class UseMethodRef {
    static int compareMC(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }

    public static void main(String args[]) {
        ArrayList<MyClass> al = new ArrayList<>();
        al.add(new MyClass(1));
        al.add(new MyClass(4));
        al.add(new MyClass(2));
        al.add(new MyClass(9));
        al.add(new MyClass(3));
        al.add(new MyClass(7));
        
        MyClass maxValObj = Collections.max(al, UseMethodRef::compareMC);
        System.out.println("Maximum value is: "+ maxValObj.getVal());
    }
}

interface MyFunc3 {
    MyClass2 func(int n);

}

class MyClass2 {
    private int val;

    MyClass2(int v) { val = v; }
    MyClass2() { val = 0; }
    int getVal() { return val; }
}

class ConstructorRefDemo {
    public static void main(String args[]) {
        MyFunc3 myClassCons = MyClass2::new;

        MyClass2 mc = myClassCons.func(100);
        System.out.println("Val in mc is "+ mc.getVal());
    }
}

class UseFunctionInterfaceDemo {
    public static void main(String args[]) {
        Function<Integer, Integer> factorial = (n) -> {
            int result = 1;
            for (int i=1; i<=n; i++) {
                result = i * result;
            }
            return result;
        };
        System.out.println("The factorial of 3 is "+ factorial.apply(3));
        System.out.println("The factorial of 5 is "+ factorial.apply(5));
    }
}