package producer_consumer;

import java.util.Queue;

public class Consumer implements Runnable {
        private final Queue<Person> queue;
        private final int size;

        public Consumer (Queue<Person> queue, int size) {
                this.queue = queue;
                this.size = size;
        }

        @Override
        public void run () {
                while (true) {
                        synchronized (queue) {
                                while (queue.isEmpty ()) {
                                        try {
                                                System.out.println ("Queue is Empty, wait till there is something available.");
                                                queue.wait ();
                                        } catch (InterruptedException e) {
                                                e.printStackTrace ();
                                        }
                                }

                                Person person = queue.remove ();
                                System.out.println ("name : " + person.getName ());
                                System.out.println ("age : " + person.getAge ());

                                queue.notifyAll ();
                        }

                        try {
                                Thread.sleep (1000);
                        } catch (InterruptedException e) {
                                e.printStackTrace ();
                        }
                }
        }
}
