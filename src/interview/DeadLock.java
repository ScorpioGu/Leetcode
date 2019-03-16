package interview;

/**
 * @Desc 产生死锁的简单例子
 * @Author gcc
 * @Date 19-3-16 下午5:19
 **/
public class DeadLock {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                synchronized (DeadLock.class) {
                    Thread.sleep(1000);
                    synchronized (Object.class) {
                        Thread.sleep(1000);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                synchronized (Object.class) {
                    Thread.sleep(1000);
                    synchronized (DeadLock.class) {
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
