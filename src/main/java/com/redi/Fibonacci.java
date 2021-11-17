package com.redi;

public class Fibonacci {

    // 2^n = 2^1000
    public long get(int index) {
        if (index < 0)
            throw new IllegalArgumentException("Index should never be negative");

        // This is to prevent long overflow and must also be tested.
        if (index > 90)
            throw new IllegalArgumentException("Index should never be > 90");

        if (index == 0)
            return 0;

        if (index == 1)
            return 1;

        // We switch to an iterative approach to prevent
        // stack overflow due to the recursive nature of
        // the previous implementation
        long a = 0;
        long b = 1;
        for (int i = 2; i <= index; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
