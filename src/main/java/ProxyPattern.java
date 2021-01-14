interface ActualClass {
        void print (String value);
}

public class ProxyPattern {
        public static void main (String[] args) {
                ProxyClassImpl proxyClass = new ProxyClassImpl ();

                proxyClass.print ("Vivek");
        }
}

class ProxyClassImpl implements ActualClass {
        private final ActualClass actualClass;

        public ProxyClassImpl () {
                this.actualClass = new ActualClassImpl ();
        }

        public void print (String value) {
                actualClass.print (value);
        }
}

class ActualClassImpl implements ActualClass {

        public void print (String value) {
                System.out.println (value);
        }
}
