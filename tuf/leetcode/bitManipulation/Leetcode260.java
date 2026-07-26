package leetcode.bitManipulation;

public class Leetcode260 {
    public int[] singleNumber(int[] nums) {
        //XOR of all
        int xor = 0;
        for(int num:nums){
            xor^=num;
        }
        //find the right most set bit in xor
        int musk = xor & -xor;
        //divide in two groups
        int first = 0;
        int second = 0;
        for(int num:nums){
            if((num&musk)==0) first^=num;
            else second^=num;
        }
        if(first<second) return new int[]{first, second};
        return new int[]{second, first};
    }
}
