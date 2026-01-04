class Box3 {
    double width;
    double height;
    double depth;

    // Notice this constructor. It takes an object of type Box
    Box3(Box3 ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    Box3(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    Box3() {
        width = -1;
        height = -1;
        depth = -1;
    }

    Box3(double len) {
        width = height = depth = len;
    }

    double volume() {
        return width * height * depth;
    }
}

class OverloadCons2 {
    public static void main(String args[]){
        Box3 mybBox1 = new Box3(10, 20, 15);
        Box3 mybBox2 = new Box3();
        Box3 mycube = new Box3(7);

        Box3 myclone = new Box3(mybBox1);

        double vol;
        vol = mybBox1.volume();
        System.out.println("Volume of mybox1 is "+ vol);

        vol = mybBox2.volume();
        System.out.println("Volume of mybox2 is "+ vol);

        vol = mybBox2.volume();
        System.out.println("Volume of mybox2 is "+ vol);

        vol = mycube.volume();
        System.out.println("Volume of mybox1 is "+ vol);

        vol = myclone.volume();
        System.out.println("Volume of clone is " + vol);
    }
}
