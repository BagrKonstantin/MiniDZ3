package org.example;

public class Main {
    public static void main(String[] args) {
        int iterations = 20;
        Buffer buffer = new Buffer(5, 42);
        new Writer(buffer, iterations, 24).start();
        new Reader(buffer, iterations).start();
    }
}