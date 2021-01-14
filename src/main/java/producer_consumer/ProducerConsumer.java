package producer_consumer;

import com.sun.tools.classfile.ConstantPool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {
        public static void main (String[] args) {
                Queue<Person> queue = new LinkedList<Person>();
                int size = 50;


                int threadPoolSize = Runtime.getRuntime ().availableProcessors ();
                ExecutorService executorService = Executors.newFixedThreadPool (threadPoolSize);

                executorService.execute (new Producer (queue, size));
                executorService.execute (new Producer (queue, size));
                executorService.execute (new Producer (queue, size));

                executorService.execute (new Consumer (queue, size));
                executorService.execute (new Consumer (queue, size));
                executorService.execute (new Consumer (queue, size));
        }
}
