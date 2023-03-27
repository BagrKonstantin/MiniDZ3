package org.example;

public class Reader extends Thread {
    private final Buffer buffer;
    private int iterations;

    public Reader(Buffer buffer, int iterations) {
        this.buffer = buffer;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        while (iterations != 0) {
            try {
                if (!buffer.isEmpty()) {
                    synchronized (buffer) {
                        Integer value = buffer.pop();
                        System.out.println("Reader: " + value);
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
