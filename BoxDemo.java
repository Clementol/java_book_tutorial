class Box {
    double width;
    double height;
    double depth;

    Box(double w, double h, double d) {
        System.out.println("Constructing Box");
        width = w;
        height = h;
        depth = d;
    }

    // display volume of a box
    double volume() {
        return width * height * depth;
    }

}

class BoxDemo {
    public static void main(String args[]) {
        Box myBox1 = new Box(10, 20, 15);
        Box myBox2 = new Box(3,6,9);
        double vol;


        vol = myBox1.volume();
        System.out.println("Volume is "+ vol);
        vol = myBox2.volume();
        System.out.println("Volume is "+ vol);

    }
}
