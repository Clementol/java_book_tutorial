import java.io.*;
import java.net.*;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

class InetAddressTest {
    public static void main(String args[]) {
        try {
            InetAddress Address = InetAddress.getLocalHost();
            System.out.println(Address);

            Address = InetAddress.getByName("www.HerbSchildt.com");
            System.out.println(Address);

            InetAddress SW[] = InetAddress.getAllByName("www.nba.com");
            for (int i=0; i<SW.length; i++)
                System.out.println(SW[i]);
         } catch (UnknownHostException e) {
            System.out.println("UnknownHostException" + e);
        }
    }    
}

class Whois {
    public static void main(String args[]) {
        int c;
        try (Socket s = new Socket("whois.internic.net", 43)) {
            
            ;
    
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
    
            String str = (args.length == 0 ? "MHProfessional.com" : args[0]) + "\n";
            byte buf[] = str.getBytes();
            System.out.println("String size: " + str.length() + " Buf size: " + buf.length);
        
            out.write(buf);
    
            while((c = in.read()) != -1) {
                System.out.print((char) c);
                // Thread.sleep(2);
            }
        } catch (Exception e) {
            System.out.println("Eror connection" + e);
        }
    }
}

class URLDemo {
    public static void main(String args[]) throws Exception {
        URL hp = new URI("http://www.HerbSchildt.com/WhatsNew").toURL();
        
        System.out.println("Protocol: "+ hp.getProtocol());
        System.out.println("Port: "+ hp.getPort());
        System.out.println("Default Port: "+ hp.getDefaultPort());

        System.out.println("Host: "+ hp.getHost());
        System.out.println("File: "+ hp.getFile());
        System.out.println("Ext: "+ hp.toExternalForm());
    }
}

class UCDemo {
    public static void main(String args[]) throws Exception {
        int c;
        URL hp = new URI("http://www.internic.net").toURL();
        URLConnection hpCon = hp.openConnection();

        long d = hpCon.getDate();
        if (d == 0)
            System.out.println("No date information");
        else
            System.out.println("Date: "+ new Date(d));

        d = hpCon.getExpiration();
        if (d == 0)
            System.out.println("No expiration information: "+ new Date(d));
        else
            System.out.println("Expires: " + new Date(d));
        d = hpCon.getLastModified();
        if (d == 0)
            System.out.println("No last-modified: "+ new Date(d));
        else
            System.out.println("Last-Modified: "+ new Date(d));

        long len = hpCon.getContentLengthLong();
        if (len == -1)
            System.out.println("Content length unavailable.");
        else
            System.out.println("Content-Length: "+len);

        if (len != 0) {
            System.out.println("======= Content ======");
            InputStream input = hpCon.getInputStream();
            while (((c = input.read()) != -1)) {
                System.out.print((char) c);
            }
            input.close();
        }
        else
            System.out.println("No content available.");
    }
}

class HttpURLDemo {
    public static void main(String args[]) throws Exception {
        URL hp = new URI("http://www.google.com").toURL();
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

        System.out.println("Request method is "+ hpCon.getRequestMethod());
        System.out.println("Response code is "+ hpCon.getResponseCode());

        System.out.println("Response Message  is "+ hpCon.getResponseMessage());

        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        Set<String> hdrField = hdrMap.keySet();
        System.out.println("\n Here is the header");

        for (String k: hdrField) {
            System.out.println("Key: " + k + "Value: " + hdrMap.get(k));
        }
    }
}

class WriteServer {
    public static int serverPort = 998;
    public static int clientPort = 999;
    public static int buffer_size = 1024;
    public static DatagramSocket ds;
    public static byte buffer[] = new byte[buffer_size];

    public static void TheServer() throws Exception {
        int pos = 0;
        while (true) {
            int c = System.in.read();
            switch (c) {
                case -1:
                    System.out.println("Server Quits.");
                    ds.close();
                    return;
                case '\r':
                    break;
                case '\n':
                    System.out.println("pos ->" + pos + "buufer -> " + buffer + " host: "+ InetAddress.getLocalHost());
                    ds.send(new DatagramPacket(buffer, pos, InetAddress.getLocalHost(), clientPort));
                    pos = 0;
                    break;
                default:
                    buffer[pos++] = (byte) c;
            }
        }
    }

    public static void TheClient() throws Exception {
        while (true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            System.out.println(new String(p.getData(), 0, p.getLength()));
        }
    }

    public static void main(String args[]) throws Exception {
        if (args.length == 1) {
            ds = new DatagramSocket(serverPort);
            TheServer();
        } else {
            ds = new DatagramSocket(clientPort);
            TheClient();
        }
    }
}

