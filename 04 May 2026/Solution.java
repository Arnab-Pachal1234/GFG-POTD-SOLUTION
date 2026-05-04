class Solution {
    public boolean isBinaryPalindrome(int n) {
        // code here
        String str = Integer.toBinaryString(n);
        boolean check = true;
        int start =0,end = str.length()-1;
        while(start<=end)
        {
            if(str.charAt(start)!=str.charAt(end))
            {
                check = false;
                break;
            }
            start++;
            end--;
        }
        return check;
        
    }
};

/*
if any string of length exist 
then we can say that the string is palindrome if and only if 
for each and and every I 
s[i]==s[n-i-1]
1 1 1 1 1
1 0 0 0 1
1 1 0 1 1
0 1 0 1 0
0 1 0 1 1
*/