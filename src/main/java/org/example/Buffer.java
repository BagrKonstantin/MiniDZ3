package org.example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Buffer {
    private final Deque<Integer> data;
    private final int capacity;
    private final Random sleepingRandomizer;

    public Buffer(int bufferSize, int seed) {
        data = new LinkedList<>();
        this.capacity = bufferSize;
        sleepingRandomizer = new Random(seed);
    }

    public void put(Integer value) throws InterruptedException {
        data.push(value);
        Thread.sleep(sleepingRandomizer.nextInt(100));
    }

    public Integer pop() throws InterruptedException {
        Integer value = data.poll();
        Thread.sleep(sleepingRandomizer.nextInt(100));
        return value;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public boolean isFull() {
        return data.size() >= capacity;
    }


}
