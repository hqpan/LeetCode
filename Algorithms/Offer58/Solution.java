// Solution of LeetCode 151 & ½£Ö¸ Offer 58-I
class Solution {
    public String reverseWords(String s) {
        if (s == null)
            return s;
        String[] str = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--)
            if (!str[i].trim().equals(""))
                builder.append(str[i].trim() + " ");
        return builder.toString().trim();
    }
}

// ½£Ö¸ Offer 58-II
class Solution {
    public String reverseLeftWords(String s, int n) {
        if (s == null || n < 0)
            throw new RuntimeException("Invalid input!");
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}