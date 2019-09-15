class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start == destination)
            return 0;
        if(destination < start)
        {
            int temp = start;
            start = destination;
            destination = temp;
        }
        
        int ans1 = 0;
        for(int i=start; i<destination; i++)
        {
            ans1 += distance[i];
        }
        
        int ans2 = 0;
        for(int i=0; i<start; i++)
        {
            ans2 += distance[i];
        }
        for(int i=destination; i<distance.length; i++)
        {
            ans2 += distance[i];
        }
        
        return ans1<ans2 ? ans1 : ans2;
    }
}
