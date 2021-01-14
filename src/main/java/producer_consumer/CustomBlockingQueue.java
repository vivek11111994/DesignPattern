package producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue<E> {
        private final Queue<E> queue;
        private final int size;
        private final Object full = new Object ();
        private final Object empty = new Object ();

        public CustomBlockingQueue (int size) {
                queue = new LinkedList<E> ();
                this.size = size;
        }

        public void put (E e) throws InterruptedException {
                while (queue.size () == size) {
                        synchronized (full) {
                                full.wait ();
                        }
                }

                queue.add (e);
                synchronized (empty) {
                        empty.notifyAll ();
                }
        }

        public synchronized E get () throws InterruptedException {
                synchronized (this) {
                        while (queue.isEmpty ()) {
                                synchronized (empty) {
                                        empty.wait ();
                                }
                        }

                        E e = queue.remove ();
                        synchronized (full) {
                                full.notifyAll ();
                        }

                        return e;
                }
        }
}
