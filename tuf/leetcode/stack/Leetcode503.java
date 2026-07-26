package leetcode.stack;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;

public class Leetcode503 {
    public int[] nextGreaterElements(int[] nums) { //1 2 3 4 1 2 3 4
        //build the 2n size array
        int[] arr = new int[nums.length*2];
        for(int i=0; i<nums.length; i++){
            arr[i] = nums[i];
            arr[i+nums.length] = nums[i];
        }
        //now the greater array is arr and the subset is nums
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        //process the subset nums
        for(int i=nums.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i]) stack.pop();
            if(stack.isEmpty()) map.put(arr[i], -1);
            else map.put(arr[i], stack.peek());
            stack.push(arr[i]);
        }
        //build ans
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++) ans[i] = map.get(nums[i]);
        return ans;
    }
}

