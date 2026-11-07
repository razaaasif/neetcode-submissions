class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        if(n <= 1){ return false; }
        Set<Integer> processed = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(processed.contains(nums[i])){
                return true;
            } else {
                processed.add(nums[i]);
            }
        } 
        return false;
    }
}