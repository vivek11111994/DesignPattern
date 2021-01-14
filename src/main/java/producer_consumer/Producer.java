package producer_consumer;

import java.util.Queue;
import java.util.Random;
import java.util.UUID;

public class Producer implements Runnable {
        private final Queue<Person> queue;
        private final int size;

        public Producer (Queue<Person> queue, int size) {
                this.queue = queue;
                this.size = size;
        }

        @Override
        public void run () {
                while (true) {
                        synchronized (queue) {
                                while (queue.size () == size) {
                                        try {
                                                System.out.println ("Queue is full, wait till there is some space available.");
                                                queue.wait ();
                                        } catch (InterruptedException e) {
                                                e.printStackTrace ();
                                        }
                                }

                                queue.add (new Person (UUID.randomUUID ().toString (), new Random ().nextInt ()));
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
