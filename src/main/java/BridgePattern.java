//decouple an abstraction from its implementation so that the two can vary independently.

interface Color {
        String fill ();
}

public class BridgePattern {
        public static void main (String[] args) {
                Shape sqaure = new Square (new Blue ());
                Shape traingle = new Traingle (new Red ());

                System.out.println (sqaure.draw ());
                System.out.println (traingle.draw ());
        }
}

class Blue implements Color {
        @Override
        public String fill () {
                return "Color is Blue";
        }
}

class Red implements Color {
        @Override
        public String fill () {
                return "Color is Red";
        }
}

abstract class Shape {
        protected Color color;

        public Shape (Color color) {
                this.color = color;
        }

        abstract public String draw ();
}

class Square extends Shape {

        public Square (Color color) {
                super (color);
        }

        @Override
        public String draw () {
                return "Square drawn. " + color.fill ();
        }
}

class Traingle extends Shape {

        public Traingle (Color color) {
                super (color);
        }

        @Override
        public String draw () {
                return "Traingle drawn. " + color.fill ();
        }
}