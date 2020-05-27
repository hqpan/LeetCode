class Solution {
    public int[][] findContinuousSequence(int target) {
        if (target < 3)
            throw new RuntimeException("Invalid input!");
        int before = 1;
        int behind = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (before <= target / 2) {
            if (sum < target) {
                sum += behind;
                behind++;
            } else if (sum > target) {
                sum -= before;
                before++;
            } else {
                int[] row = new int[behind - before];
                for (int i = 0; i < behind - before; i++)
                    row[i] = i + before;
                res.add(row);
                sum -= before;
                before++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}