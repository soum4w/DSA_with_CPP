package greedy;

import java.util.Arrays;

public class Minimum_number_of_platforms_required_for_a_railway {
    public int findPlatform(int[] Arrival, int[] Departure) {
        //your code goes here
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        int platform = 0;
        int maxPlatform = 0;
        int i = 0; int j = 0;
        while(i<Arrival.length){
            if(Arrival[i]<=Departure[j]){
                platform++;
                i++;
                maxPlatform = Math.max(maxPlatform, platform);
            }
            else {
                platform--;
                j++;
            }
        }
        return maxPlatform;
    }
}