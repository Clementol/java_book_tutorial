class NewThread implements Runnable {
    String name; // name of thread
    Thread t;

    NewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: "+ t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("CHild Thread: " + i);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println(name + "interrupted.");
        }
        System.out.println(name + "Exiting");
    }
}

class MultiThreadDemo {
    public static void main(String args[]) {
        new NewThread("One");
        new NewThread("Two");
        new NewThread("Three");

        try {
            // wait for other threads to end
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting");
    }
}

class DemoJoin {
    public static void main(String args[]) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");
        NewThread ob3 = new NewThread("Three");

        System.out.println("Thread one is alive: " + ob1.t.isAlive());
         System.out.println("Thread two is alive: " + ob2.t.isAlive());
        System.out.println("Thread three is alive: " + ob3.t.isAlive());
        // wait for threads to finish
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch(InterruptedException e) {
            System.out.println("Main thread Interruption");
        }
    }
}
