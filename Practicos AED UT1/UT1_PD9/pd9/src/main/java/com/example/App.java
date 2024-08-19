package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int num = 5;
        try {
            int result = factorial(num);
            System.out.println("El factorial de " + num + " es " + result);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        long num2 = 5;
        if (isPrime(num2)) {
            System.out.println("El número es primo. La suma de los números pares hasta " + num2 + " es " + sumEven(num));
        } else {
            System.out.println("El número no es primo. La suma de los números impares hasta " + num2 + " es " + sumOdd(num));
        }
    }

    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        long sqrt = (long) Math.sqrt(n);
        for (long i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long sumEven(long n) {
        long sum = 0;
        long i = 0;
        while (i <= n) {
            sum += i;
            i += 2;
        }
        return sum;
    }

    public static long sumOdd(long n) {
        long sum = 0;
        long i = 1;
        while (i <= n) {
            sum += i;
            i += 2;
        }
        return sum;
    }

    public static int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo");
        }

        int result = 1;
        for (int i = 2; i <= num; i++) {
            if (Integer.MAX_VALUE / i < result) {
                throw new ArithmeticException("Desbordamiento de entero");
            }
            result *= i;
        }
        return result;
    }
}
