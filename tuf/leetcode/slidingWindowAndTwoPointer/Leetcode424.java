package leetcode.slidingWindowAndTwoPointer;

import java.util.Map;
import java.util.HashMap;

public class Leetcode424 {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for(int right=0; right<s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            while(map.size()>k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0) map.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}