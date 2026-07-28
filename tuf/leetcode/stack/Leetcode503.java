package leetcode.stack;

import java.util.Deque;
import java.util.ArrayDeque;

public class Leetcode503 {
    public int[] nextGreaterElements(int[] nums) { //1 2 1 | 1 2 1
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
       for(int i=2*n-1; i>=0; i--){
           int idx = i%n;
           while(!stack.isEmpty() && stack.peek()<= nums[idx]) stack.pop();
           if(i<n) ans[idx] = (stack.isEmpty())? -1 : stack.peek();
           stack.push(nums[idx]);
       }
       return ans;
    }
}

