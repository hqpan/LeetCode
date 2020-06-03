class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            if (min > price)
                min = price;
            else if (price - min > res)
                res = price - min;
        }
        return res;
    }
}