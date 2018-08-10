package com.qfedu.test;

/**
 * @Author Bingove
 * @Date 2018/8/1 0001 下午 17:58
 */
public class Prime_Number {
    public static boolean isPrime(int number) {
        for(int i = 2;i < number;i++) {
            if(number%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void prime(int number) {
        for(int i = 2;i < number;i++) {
            if(isPrime(i)) {

                    System.out.print(i);


            }
        }
    }

    public static void main(String[] args) {
        prime(500);
    }

}
