interface Sort {
        void arrange ();
}

public class StratergyPattern {
        public static void main (String[] args) {
                Number number = new Number (new QuickSort ());

                number.arrange ();
        }
}

class Number {
        private final Sort sort;

        public Number (Sort sort) {
                this.sort = sort;
        }

        public void arrange () {
                sort.arrange ();
        }
}

class BubbleSort implements Sort {

        public void arrange () {
                System.out.println ("BubbleSort");
        }
}

class QuickSort implements Sort {

        public void arrange () {
                System.out.println ("QuickSort");
        }
}

class MergeSort implements Sort {

        public void arrange () {
                System.out.println ("MergeSort");
        }
}
