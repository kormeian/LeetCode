class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        HashSet<String> set = new HashSet<String>();

        while (i < s.length()) {
            boolean isValid = set.contains(String.valueOf(s.charAt(i)));
            if(!isValid){
                set.add(String.valueOf(s.charAt(i)));
                i++;
                maxLength = Math.max(maxLength,set.size());
            }else{
                set.remove(String.valueOf(s.charAt(j++)));
            }
        }
        return maxLength;
    }
}