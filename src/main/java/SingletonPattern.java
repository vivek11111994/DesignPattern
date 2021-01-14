public class SingletonPattern {
        public static void main (String[] args) {
                Base first = Base.getBaseInstance ();
                Base second = Base.getBaseInstance ();
                Base third = Base.getBaseInstance ();
        }
}

class Base {
        private static Base base = null;

        private Base () {
                System.out.println ("Base Constructor Called");
        }

        public static Base getBaseInstance () {
                synchronized (Base.class) {
                        if (base == null) {
                                base = new Base ();
                        }
                }

                return base;
        }
}
