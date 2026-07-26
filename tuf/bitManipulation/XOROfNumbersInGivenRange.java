package bitManipulation;

public class XOROfNumbersInGivenRange {
}

class Solution {
    public int findRangeXOR(int l, int r) {
        //your code goes here
        return xor(r)^xor(l-1);
    }

    private int xor(int n){
        return switch (n % 4) {
            case 0 -> n;
            case 1 -> 1;
            case 2 -> n + 1;
            default -> 0;
        };
    }
}

/* Brute force
class Solution {
    public int findRangeXOR(int l, int r) {
         //your code goes here
         int ans = 0;
         for(int i=l; i<=r; i++){
            ans^=i;
         }
         return ans;
    }
}
*/
