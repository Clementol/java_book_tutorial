class Box2 {
    double width;
    double height;
    double depth;

    Box2(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    Box2() {
        width = -1;
        height = -1;
        depth = -1;
    }

    Box2(double len) {
        width = height = depth = len;
    }

    double voluem() {
        return width * height * depth;
    }
}

class OverloadCons {
    public static void main(String args[]) {
        Box2 myBox1 = new Box2(10, 20, 15);
        Box2 myBox2 = new Box2();
        Box2 mycube = new Box2(7);

        double vol;

        vol = myBox1.voluem();
        System.out.println("Volume of mybox1 is " + vol);

        vol = myBox2.voluem();
        System.out.println("Volume of mybox1 is " + vol);

        vol = mycube.voluem();
        System.out.println("Volume of mybox1 is " + vol);
    }
}
