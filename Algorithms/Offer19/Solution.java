// Approach 1: Recursion
class Solution {
    private String s;
    private String p;
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        this.s = s;
        this.p = p;
        return match(0, 0);
    }

    public boolean match(int indexS, int indexP) {        
        if (indexS == s.length() && indexP == p.length())
            return true;
        if (indexS != s.length() && indexP == p.length())
            return false;
        boolean currChar = (indexS != s.length()) && (p.charAt(indexP) == '.' || s.charAt(indexS) == p.charAt(indexP));
        if (indexP + 1 < p.length() && p.charAt(indexP + 1) == '*')
            return match(indexS, indexP + 2) || (currChar && match(indexS + 1, indexP));
        return currChar && match(indexS + 1, indexP + 1);
    }
}