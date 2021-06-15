//https://leetcode.com/problems/valid-palindrome/
class Palindrome {
    public boolean isPalindrome(String s) {
        s = s.replaceAll(
                "[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
