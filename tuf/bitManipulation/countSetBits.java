package bitManipulation;

public class countSetBits {
    public int countSetBits(int n) {
        // Your code goes here
        int count=0;
        while(n>0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
