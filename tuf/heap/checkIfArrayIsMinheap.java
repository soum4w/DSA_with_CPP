package heap;

public class checkIfArrayIsMinheap {
}

class Solution {
    public boolean isHeap(int[] nums) {
        int n = nums.length;
        for(int i=0; i<=n/2-1; i++){
            int leftChild = i*2 +1;
            int rightChild = i*2+ 2;
            if(leftChild<n && nums[leftChild]<nums[i]) return false;
            if(rightChild<n && nums[rightChild]<nums[i]) return false;
        }
        return true;
    }
}
