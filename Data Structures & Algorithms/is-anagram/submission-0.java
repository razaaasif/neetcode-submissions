class Solution {
    public boolean isAnagram(String s, String t) {
        //edge case
        if(s.length() != t.length()) return false;
        //take 2 hash table
        int[] hash = new int[26];

    
        //remove data from on and add data in one
        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }
        //loop again if any is not equal to 0 return false
        for(int i = 0; i < 26 ; i++){
            if(hash[i] != 0) return false;
        }
        return true;
    }
}
