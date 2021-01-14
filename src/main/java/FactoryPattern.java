interface Animal {
        void motion ();
}

public class FactoryPattern {
        public static void main (String[] args) {
                AnimalFactory animalFactory = new AnimalFactory ();
                Animal animal = animalFactory.getAnimal ("crawls");

                animal.motion ();
        }
}

class AnimalFactory {
        public Animal getAnimal (String motion) {
                if (motion.equals ("runs")) {
                        return new Lion ();
                } else if (motion.equals ("crawls")) {
                        return new Snake ();
                } else if (motion.equals ("jumps")) {
                        return new Frog ();
                }

                return new Unknown ();
        }
}

class Lion implements Animal {
        public void motion () {
                System.out.println ("Lion runs");
        }
}

class Snake implements Animal {
        public void motion () {
                System.out.println ("Snake crawls");
        }
}

class Frog implements Animal {
        public void motion () {
                System.out.println ("Frog jumps");
        }
}

class Unknown implements Animal {
        public void motion () {
                System.out.println ("Unkown does nothing");
        }
}
