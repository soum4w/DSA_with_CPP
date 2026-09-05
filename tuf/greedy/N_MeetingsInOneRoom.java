package greedy;

import java.util.Arrays;

public class N_MeetingsInOneRoom {
}

class Pair{
    int start;
    int end;
    public Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int maxMeetings(int[] start, int[] end) {
        //your code goes here
        int n = start.length;
        Pair[] meetings = new Pair[n];
        for(int i=0; i<n; i++){
            meetings[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(meetings, (a,b)->a.end-b.end);
        int meetingCount = 1;
        int lastMeetingEndtime = meetings[0].end;
        for(int i=1; i<n; i++){
            if(lastMeetingEndtime<meetings[i].end) {
                meetingCount++;
                lastMeetingEndtime=meetings[i].end;
            }
        }
        return meetingCount;
    }
}