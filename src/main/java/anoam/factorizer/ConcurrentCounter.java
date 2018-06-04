package anoam.factorizer;

import java.util.concurrent.locks.ReentrantLock;

class ConcurrentCounter implements Counter {
    int value = 1;
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public int next() {
        lock.lock();
        try {
            return value ++;
        } finally {
            lock.unlock();
        }
    }
}
