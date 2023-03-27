package org.example;
import java.util.Random;

public class Writer extends Thread {
    private final Buffer buffer;
    private int iterations;
    private final Random randomizer;

    public Writer(Buffer buf, int iterations, int seed) {
        buffer = buf;
        this.iterations = iterations;
        randomizer = new Random(seed);
    }

    @Override
    public void run() {
        while (iterations != 0) {
            try {
                if (!buffer.isFull()) {
                    synchronized (buffer) {
                        int value = randomizer.nextInt(100);
                        System.out.println("Writer generated: " + value);
                        buffer.put(value);
                    }
                    --iterations;
                } else {
                    Thread.sleep(10);
                }
            } catch (InterruptedException error) {
                System.out.println(error);
            }

        }
    }
}
