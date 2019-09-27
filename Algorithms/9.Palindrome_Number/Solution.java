//  Revert half of the number
class Solution {
    public boolean isPalindrome(int x) {
        if((x < 0) || ((x % 10 == 0) && (x != 0)))
            return false;
        int num = 0;
        while(x > num)
        {
            num = num * 10 + x % 10;
            x /= 10;
        }
        return (x == num) || (x == num / 10);
    }
}

// compare bit by bit
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int num = x;
        int ans = 0;
        while(num != 0)
        {
            ans = ans * 10 + num % 10;
            num /= 10;
        }
        return x == ans;
    }
}

// convert a numeric value to a string
class Solution {
    public boolean isPalindrome(int x) {
        String reverseString = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reverseString); 
    }
}

// create an array of bits
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        // create an array of bits
        int residue = 0;
        ArrayList array = new ArrayList();
        while(x != 0)
        {
            residue = x % 10;
            array.add(residue);
            x = x / 10;
        }
        // Determine whether an integer is a palindrome
        int length = array.size();
        for(int i = 0; i < length / 2; i++)
        {
            if(array.get(i) != array.get(length - 1 - i))
                return false;
        }
        return true;
    }
}
