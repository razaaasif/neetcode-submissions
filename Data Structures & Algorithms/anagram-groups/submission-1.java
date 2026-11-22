class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramGroups = new HashMap<>();
        for(String str : strs){

            anagramGroups.computeIfAbsent(getKey(str), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramGroups.values());
    }
    private String getKey(String str){
        int[] ch = new int[26];
        for(int i = 0 ; i < str.length(); i++){
            ch[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            sb.append('a' + ch[i]);
        }
        return sb.toString();
    }
}
