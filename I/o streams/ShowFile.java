import java.io.*;

class ShowFile {
    public static void main(String args[]) {
        int i = -1;
        FileInputStream fin = null;
        // First, confirm that a filename has been specified
        if (args.length != 1) {
            System.out.println("Usage showfile filename");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            do {
                try {

                    i = fin.read();
                    if (i != -1)
                        System.out.print((char) i);
                    ;
                } catch (IOException e) {
                    System.out.println("Error reading file");
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
            } catch (Exception e) {
                System.out.println("Error Closing File");
            }
        }

    }
}


class ShowFile2 {
    public static void main(String args[]) {
        int i = -1;
        // First, confirm that a filename has been specified
        if (args.length != 1) {
            System.out.println("Usage showfile filename");
            return;
        }
        // The following code uses a try-with-resources statement to open
        // a file and then automatically close it when the try block is left.
        try(FileInputStream fin = new FileInputStream(args[0])) {
            
            do {
                // try {

                    i = fin.read();
                    if (i != -1)
                        System.out.print((char) i);
                // } catch (IOException e) {
                //     System.out.println("Error reading file");
                // }

            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return;
        } catch (IOException e) {
            System.out.println("An I/O Error Occurred");
            return;
        } 

    }
}
