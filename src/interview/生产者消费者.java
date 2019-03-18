package interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-3-16 下午5:33
 **/
public class 生产者消费者 {
    private static final int SIZE = 5;

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        new Thread(new Consumer(queue)).start();
        new Thread(new Producer(SIZE, queue)).start();
    }

    static class Consumer implements Runnable {
        private Queue<Integer> queue;

        public Consumer(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    //要用while，不要用if
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //每消费了一个消息告诉生产者快去生产
                    queue.poll();
                    queue.notifyAll();
                }
            }
        }
    }

    static class Producer implements Runnable {
        private int maxSize;
        private Queue<Integer> queue;

        public Producer(int maxSize, Queue<Integer> queue) {
            this.maxSize = maxSize;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    // 这里必须使用while，当被唤醒之后仍需要进行判断
                    while (queue.size() == maxSize) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //每添加一个消息就唤醒一下，唤醒消费者别偷懒了快去消费
                    queue.offer(1);
                    queue.notifyAll();
                }
            }
        }
    }

    /**
     * 使用Lock和condition实现的生产者消费者
     */


    private static Queue<Integer> queue = new LinkedList<>();
    private static Lock lock = new ReentrantLock();
    private static Condition canConsume = lock.newCondition();
    private static Condition canProduce = lock.newCondition();

    static class ProducerUseLock implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == SIZE) {
                        canProduce.await();
                    }
                    queue.offer(1);
                    // 这里比用signalAll()更加高效，条件谓词多个的好处
                    canConsume.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ConsumerUseLock implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.isEmpty()) {
                        canConsume.await();
                    }
                    queue.poll();
                    canProduce.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    /**
     * 使用阻塞队列实现
     */
    private static BlockingQueue<Integer> bq = new LinkedBlockingDeque<>();

    static class ConsumerUseBQ implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    bq.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class ProducerUseBQ implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    bq.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}


