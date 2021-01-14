import java.util.ArrayList;
import java.util.List;

interface Observer {
        void update (int value);
}

public class ObserverPattern {
        public static void main (String[] args) {
                Observing1 observing1 = new Observing1 ();
                Observing2 observing2 = new Observing2 ();
                Observed observed = new Observed ();

                // Observer pattern starts here
                observed.register (observing1);
                observed.register (observing2);

                observed.changeValue (10);
                observed.changeValue (100);

                observed.unRegister (observing1);
                observed.unRegister (observing2);
        }
}

class Observing1 implements Observer {
        public Observing1 () {
                System.out.println ("Observing1 constructor");
        }

        public void update (int value) {
                System.out.println ("New Value in Observing1 : " + value);
        }
}

class Observing2 implements Observer {
        public Observing2 () {
                System.out.println ("Observing2 constructor");
        }

        public void update (int value) {
                System.out.println ("New Value in Observing2 : " + value);
        }
}

class Observed {
        List<Observer> observerList;

        public Observed () {
                observerList = new ArrayList<Observer> ();
                System.out.println ("Observed constructor");
        }

        public void register (Observer observer) {
                System.out.println ("Register");
                observerList.add (observer);
        }

        public void unRegister (Observer observer) {
                System.out.println ("UnRegister");
                for (int i = 0; i < observerList.size (); i++) {
                        if (observerList.get (i) == observer) {
                                observerList.remove (observer);
                        }
                }
        }

        public void changeValue (int value) {
                for (Observer o : observerList) {
                        o.update (value);
                }
        }
}
