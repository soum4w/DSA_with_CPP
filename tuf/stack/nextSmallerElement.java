package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class nextSmallerElement {
    public int[] nextSmallerElements(int[] arr) {
        // Your code goes here
        Deque<Integer> stack = new ArrayDeque<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()>=arr[i]) stack.pop();
            ans[i] = (stack.isEmpty()) ? -1:stack.peek();
            stack.push(arr[i]);
        }
        return ans;
    }
}
