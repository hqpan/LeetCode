class Solution {
    private String str;
    private int index = 0;
    public boolean isNumber(String s) {
        if (s == null)
            return false;
        this.str = s.trim();
        boolean ans = isSignedInt();
        if (index < str.length() && str.charAt(index) == '.') {
            ++index;
            ans = isUnsignedInt() || ans;
        }
        if (index < str.length() && (str.charAt(index) == 'e' || str.charAt(index) == 'E')) {
            ++index;
            ans = ans && isSignedInt();
        }
        return ans && (index == str.length());
    }

    public boolean isUnsignedInt() {
        int indexOriginal = index;
        while (index < str.length() && '0' <= str.charAt(index) && str.charAt(index) <= '9')
            ++index;
        return indexOriginal < index;
    }

    public boolean isSignedInt() {
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-'))
            ++index;
        return isUnsignedInt();
    }
}