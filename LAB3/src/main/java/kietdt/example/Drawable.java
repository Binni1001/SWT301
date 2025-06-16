package kietdt.example;

interface Drawable {
    void draw();
}

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }

    public static void main(String[] args) {
        Drawable shape = new Circle();
        shape.draw();
    }
}
