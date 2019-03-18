package interview;

/**
 * @Desc 产生死锁的简单例子
 * @Author gcc
 * @Date 19-3-16 下午5:19
 **/
public class DeadLock {
    // 顺序死锁,两个线程分别执行方法，某一时刻可能处出现死锁
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                // doSth
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                // doSth
            }
        }
    }

    //动态顺序死锁,当该方法被两个线程调用，分别为transfer(myfom, myto),transfer(myto, myfrom)会出现死锁
    //为解决这个问题，判断两个对象的hashcode，始终保持枷锁顺序是一致的。如果两个锁的hashcode相同，使用一个加时赛锁
    public void transferMoney(Accont from, Accont to, int amout) {
        synchronized (from) {
            synchronized (to) {
                from.debit(amout);
                to.credit(amout);
            }
        }
    }

    interface Accont {
        void debit(int amout);
        void credit(int amout);
    }

    // 协作对象之间的死锁，在持有锁的情况下调用另一个方法，而这个方法是另一个对象的加锁方法 见书174页

    // 资源死锁，线程A连接数据库1，并等待连接数据库2，线程B连接数据2，等待连接数据库1，
    // 饥饿死锁，单线程Executor情况下，提交任务1，而任务1等待任务2的完成。
    // 避免死锁：减少锁粒度，分析确保获取锁的顺序一致，锁支持定时取消

    //活锁：线程不断地重复执行相同的操作，但是总是失败，线程没有阻塞但是总是执行不下去。避免活锁：重试机制中引入随机性
}
