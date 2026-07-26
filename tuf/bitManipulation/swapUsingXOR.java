package bitManipulation;

public class swapUsingXOR {
    public int[] swap(int a, int b) {
        // Your code goes here
        a = a^b;
        b = a^b;
        a = a^b;
        return new int[]{a, b};
    }
}
