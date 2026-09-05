package heap;

public class minHeaptoMaxHeap {
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;
        for(int i=n/2-1; i>=0; i--){
            heapifyDown(nums, i, n);
        }
        return nums;
    }

    private void heapifyDown(int[] nums, int index, int n){
        while(true){
            int largest = index;
            int leftChild = index*2 + 1;
            int rightChild = index*2 +2;
            if(leftChild<n && nums[leftChild]>nums[largest]) largest = leftChild;
            if(rightChild<n && nums[rightChild]>nums[largest]) largest = rightChild;
            if(largest==index) break;
            //swap
            int temp = nums[largest];
            nums[largest] = nums[index];
            nums[index] = temp;
            index = largest;
        }
    }
}
