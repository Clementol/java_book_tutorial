import java.io.*;

class MakeString {
    public static void main(String args[]) {
        char c[] = { 'J', 'a', 'v', 'a' };
        String s1 = new String(c);
        String s2 = new String(s1);

        System.out.println(s1);
        System.out.println(s2);
    }
}

class SubStringCons {
    public static void main(String args[]) {
        byte ascii[] = { 65, 66, 67, 68, 69, 70 };
        String s1 = new String(ascii);
        System.out.println(s1);

        String s2 = new String(ascii, 2, 3);
        System.out.println(s2);
    }
}

class GetCharsDemo {
    public static void main(String args[]) {
        String s = "This is a demo of the getChars method";
        int start = 10;
        int end = 14;
        char buf[] = new char[end - start];
        s.getChars(start, end, buf, 0);
        System.out.println(buf);
        char ca[] = "demo".toCharArray();
        System.out.println(ca);
    }
}

class EqualsDemo {
    public static void main(String args[]) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Good-bye";
        String s4 = "HELLO";

        System.out.println(s1 + " equals " + s2 + " -> " + s1.equals(s2));
        System.out.println(s1 + " equals " + s3 + " -> " + s1.equals(s3));
        System.out.println(s1 + " equals " + s4 + " -> " + s1.equals(s4));
        System.out.println(s1 + " equalsIgnoreCase  " + s4 + " -> " + s1.equalsIgnoreCase(s4));
    }
}

class EqualsNotEqualTo {
    public static void main(String args[]) {
        String s1 = "Hello";
        String s2 = new String(s1);

        System.out.println(s1 + " equals " + s2 + " -> " + s1.equals(s2));
        System.out.println(s1 + " == " + s2 + " -> " + (s1 == s2));
        System.out.println("s1 and s2" + s1.compareTo(s2));

    }
}

class SortingString {
    static String arr[] = {
            "Now", "is", "the", "time", "for", "all", "good", "men",
            "to", "come", "to", "the", "aid", "of", "thier", "country"
    };

    public static void main(String args[]) {
        for (int j = 0; j < arr.length; j++) {
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i].compareTo(arr[j]) < 0) {
                    String t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
            System.out.println(arr[j]);
        }
    }
}

class indexOfDemo {
    public static void main(String args[]) {

        String s = "Now is the time for all good men " +
                "to come to the aid of their country.";
        System.out.println(s);
        System.out.println("indexOf(t) = " +
                s.indexOf('t'));
        System.out.println("lastIndexOf(t) = " +
                s.lastIndexOf('t'));
        System.out.println("indexOf(the) = " +
                s.indexOf("the"));
        System.out.println("lastIndexOf(the) = " +
                s.lastIndexOf("the"));
        System.out.println("indexOf(t, 10) = " +
                s.indexOf('t', 10));
        System.out.println("lastIndexOf(t, 60) = " +
                s.lastIndexOf('t', 60));
        System.out.println("indexOf(the, 10) = " +
                s.indexOf("the", 10));
        System.out.println("lastIndexOf(the, 60) = " +
                s.lastIndexOf("the", 60));
    }
}

class StringReplace {
    public static void main(String args[]) {
        String org = "The is a test. This is, too.";
        String search = "is";
        String sub = "was";
        String result = "";
        int i;

        do {
            System.out.println(org);
            i = org.indexOf(search);
            if (i != -1) {
                result = org.substring(0, i);
                result = result + sub;
                result = result + org.substring(i + search.length());
                org = result;
            }
        } while (i != -1);
    }
}


class UseTrim {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter 'stop' to quit.");
        System.out.println("Enter State: ");
        do {
            str = br.readLine();
            str = str.trim();

            if (str.equals("Illinois"))
                System.out.println("Capital is Springfield");
            else if (str.equals("Missouri"))
                System.out.println("Capital is Jefferson City.");
            else if (str.equals("California"))
                System.out.println("Capital is Sacramento.");
            else if (str.equals("Washington"))
                System.out.println("Capital is Olympia.");
        } while (!str.equals("stop"));
    }
}

class StringJoinDemo {
    public static void main(String args[]) {
        String result = String.join(" ","Alpha", "Beta", "Gamma");
        System.out.println(result);
        
        result = String.join(", ", "John", "ID#: 569", "E-mail: Jogh#HerbSchildt.com");
        System.out.println(result);
    }
}

class AppendDemo {
    public static void main(String args[]) {
        String s;
        int a = 42;
        StringBuffer sb = new StringBuffer(40);
        s = sb.append("b = ").append(a).append("!").toString();
        System.out.println(s);
    }
}

class InsertDemo {
    public static void main(String args[]) {
        StringBuffer sb = new StringBuffer("I Java!");
        sb.insert(2, "like ");
        System.out.println(sb);
    }
}

class ReverseDemo {
    public static void main(String args[]) {
        StringBuffer s = new StringBuffer("abcde");

        System.out.println(s);
        s.reverse();
        System.out.println(s);
    }
}

class DeleteDemo {
    public static void main(String args[]) {
        StringBuffer sb = new StringBuffer("This is a test");
        sb.delete(4, 7);
        System.out.println("After delete: "+sb);

        sb.deleteCharAt(0);
        System.out.println("After deleteCharAt: "+sb);
    }
}

class ReplaceDemo {
    public static void main(String args[]) {
        StringBuffer sb = new StringBuffer("THis is a test");
        sb.replace(5, 7, "was");
        System.out.println("After replace: "+ sb);
    }
}
