import java.io.*;

class CopyFile {
    public static void main(String args[]) {
        int i = -1;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        // First confirm that both files have been specified.
        if (args.length != 2) {
            System.out.println("Usage: CopyFile from to");
            return;
        }
        try {
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);
            do {
                try {
                    i = fin.read();
                    if (i != -1)
                        fout.write(i);
                } catch (IOException e) {
                    System.out.println("I/O Error: " + e);
                }

            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Open File");
            return;
        } finally {
            // Close file in all cases.
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException e) {
                System.out.println("Error Closing input File");
            }
            try {
                if (fout != null)
                    fout.close();
            } catch (IOException e) {
                System.out.println("Error Closing output File");
            }
        }
    }
}

class CopyFile2 {
    public static void main(String args[]) {
        int i = -1;

        // First confirm that both files have been specified.
        if (args.length != 2) {
            System.out.println("Usage: CopyFile from to");
            return;
        }
        try (
                FileInputStream fin = new FileInputStream(args[0]);
                FileOutputStream fout = new FileOutputStream(args[1])) {
            do {

                i = fin.read();
                if (i != -1)
                    fout.write(i);

            } while (i != -1);
        } catch (IOException e) {
            System.out.println("I/O Error: "+e);
            return;
        }
    }
}
