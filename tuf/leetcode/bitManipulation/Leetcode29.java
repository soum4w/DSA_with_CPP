package leetcode.bitManipulation;

public class Leetcode29 {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        boolean negative = (dividend<0) ^ (divisor<0);

        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);

        long ans = 0;
        while(dvd>=dvs){
            long temp = dvs;
            long multiple = 1;
            while (temp<<1 <=dvd){
                temp = temp<<1;
                multiple = multiple<<1;
            }
            ans+=multiple;
            dvd-=temp;
        }
        if(negative) ans = -ans;
        return (int)ans;
    }
}