package greedy;

import java.util.Arrays;

public class JobsequencingProblem {
    public int[] JobScheduling(int[][] Jobs) {
        //your code goes here
        Arrays.sort(Jobs, (a,b)->Integer.compare(b[2], a[2]));
        int maxDeadline=0;
        for(int[] job: Jobs) maxDeadline = Math.max(maxDeadline, job[1]);
        int[] slots = new int[maxDeadline+1];
        Arrays.fill(slots, -1);
        int count = 0;
        int profit = 0;
        for(int[] job:Jobs){
            int deadline = job[1];
            for(int j=deadline; j>=1; j--){
                if(slots[j]==-1){
                    slots[j] = job[2];
                    count++;
                    profit+=job[2];
                    break;
                }
            }
        }
        return new int[]{count, profit};
    }
}