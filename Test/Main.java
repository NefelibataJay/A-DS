package Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String args[]) {
        new ArrayList<>();
        new HashMap<>();
        new HashSet<>();

        new LinkedList<>();
        new LinkedHashMap<>();
        new LinkedHashSet<>();

        new TreeMap<>();
        new TreeSet<>();

        // 每个方法加上 synchronized 关键字
        new Vector<>();
        new Hashtable<>();

        new CopyOnWriteArrayList<>();

        // jdk1.7 中加的是分段锁(Segment锁)，也就是锁的粒度更细了。
        // jdk1.8 中加的是 CAS 和 synchronized 结合的方式, 在元素上加锁。
        new ConcurrentHashMap<>();

        new CopyOnWriteArraySet<>();

        Collections.synchronizedList(new ArrayList<>());

        new ReentrantLock();

        new CountDownLatch(0);

        new ThreadLocal<>();
    }

}
