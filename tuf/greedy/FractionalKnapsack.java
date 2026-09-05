package greedy;

public class FractionalKnapsack {
}
class Solution {
    class Item{
        int val;
        int wt;
        double ratio;
        Item(int val, int wt ){
            this.val = val;
            this.wt = wt;
            this.ratio = (double) val/wt;
        }
    }

    public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        // Your code goes here
        int n = val.length;
        Item[] items = new Item[n];
        for(int i=0; i<n; i++){
            items[i] = new Item(val[i], wt[i]);
        }
        Arrays.sort(items, (a,b)->Double.compare(b.ratio, a.ratio));
        double ans = 0;
        for(Item item:items){
            if(cap>=item.wt){
                ans+=item.val;
                cap-=item.wt;
            } else {
                ans += cap*item.ratio;
                break;
            }
        }
        return ans;
    }
}