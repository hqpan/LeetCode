class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();
        int currMax = 0;
        int res = 0;
        HashMap<Character, Integer> st = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (!st.containsKey(temp) || i - st.get(temp) > currMax) {
                currMax++;
                res = Math.max(currMax, res);            
            } else {
                res = Math.max(currMax, res);
                currMax = i - st.get(temp);
            }
            st.put(temp, i);
        }
        return res;
    }
}