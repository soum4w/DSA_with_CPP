package leetcode.slidingWindowAndTwoPointer;

//Sliding window
public class Leetcode930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0;
        int zeroCount = 0;
        int currentSum = 0;
        int totalSubarrays = 0;
        for(int right=0; right<nums.length; right++){
            currentSum+=nums[right];
            while(left<right && (nums[left]==0 || currentSum>goal)){
                if(nums[left]==1) zeroCount=0;
                else zeroCount++;
                currentSum-=nums[left];
                left++;
            }
            if(currentSum==goal) totalSubarrays+= 1+zeroCount;
        }
        return totalSubarrays;
    }
}

/*

Approach 1 : Subarray sum equals K (Prefix Sum)

public class Leetcode930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int ans = 0;
        for(int num: nums){
            prefixSum+=num;
            int remaining = prefixSum-goal;
            if(map.containsKey(remaining)) ans+=map.get(remaining);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return ans;
    }
}
*/
