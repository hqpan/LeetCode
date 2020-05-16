class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> st = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (st.containsKey(temp))
                st.put(temp, st.get(temp) + 1);
            else
                st.put(temp, 1);
        }
        for (int i = 0; i < s.length(); i++)
            if (st.get(s.charAt(i)) == 1)
                return s.charAt(i);
        return ' ';
    }
}