interface Library {
        void print (String value);
}

interface Adapter {
        void printInteger (int value);
}

public class AdapterPattern {
        public static void main (String[] args) {
                Library library = new LibraryImpl ();

                library.print ("Vivek Awasthi");

                Adapter adapter = new AdapterImpl (library);
                adapter.printInteger (26);
        }
}

class LibraryImpl implements Library {
        public void print (String value) {
                System.out.println (value);
        }
}

class AdapterImpl implements Adapter {
        private final Library library;

        public AdapterImpl (Library library) {
                this.library = library;
        }

        public void printInteger (int value) {
                library.print (Integer.toString (value));
        }
}