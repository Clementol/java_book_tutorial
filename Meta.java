import java.lang.annotation.*;
import java.lang.reflect.Method;

// An annotation type declaration
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str() default "Testing";
    int val() default 9000;
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle {
    int value(); // this variable name must be value
}

class Meta {
    // Annotate a method
    @MyAnno(str = "Two parameters", val = 19)
    public static void myMeth(String str, int i) {
        Meta ob = new Meta();

        // Obtain the annotation for this method
        // and display the values of the members
        try {
            Class<?> c = ob.getClass();
            // Now, get a method object that represents this methd
            Method m = c.getMethod("myMeth", String.class, int.class);

            // next get the annotation for this class
            MyAnno anno = m.getAnnotation(MyAnno.class);
            // Finally display the values
            System.out.println(anno.str() + " "+ anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println("Mehtod Not Found");
        }

    }
    public static void main(String args[]) {
        myMeth("test", 10);
    }
}


@What(description = "An annotation test class")
@MyAnno(str = "Meta2", val = 99)
class Meta2 {

    @What(description = "An annotation test method")
    @MyAnno(str = "Testing", val = 100)
    public static void myMeth() {
        Meta2 ob = new Meta2();

        try {
            Annotation annos[] = ob.getClass().getAnnotations();
            // Display all annotations for Meta2.
            System.out.println("All annotations for Meta2:");
            for(Annotation a: annos)
                System.out.println(a);
            System.out.println();
            Method m = ob.getClass().getMethod("myMeth");
            annos = m.getAnnotations();


            System.out.println("All annotations for myMeth:");
            for(Annotation a: annos)
                System.out.println(a);

        } catch (NoSuchMethodException e) {
            System.out.println("Method Not Found.");
        }
    }
    public static void main(String args[]) {
        myMeth();
    }
}


class Meta3 {
    // Annotate a method using the default values
    @MyAnno()
    public static void myMeth() {
        Meta3 ob = new Meta3();
        // Obtain the annotation for this method
        // and display the values of the members
        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth");

            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " +  anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println("Mehtod Not Found");
        }
    }
    public static void main(String args[]) {
        myMeth();
    }
}

class Single {
    // Annotate a method using a single-member annotation.
    @MySingle(100)
    public static void myMeth() {
        Single ob = new Single();
        try {
            Method m = ob.getClass().getMethod("myMeth");
            MySingle anno = m.getAnnotation(MySingle.class);
            System.out.println(anno.value());
        } catch (NoSuchMethodException e) {
            System.out.println("Method Not Found.");
        }
    }
    public static void main(String args[]) {
        myMeth();
    }
}
