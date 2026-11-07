class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> traversed = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(traversed.get(target-nums[i]) != null) {
                return new int[]{traversed.get(target-nums[i]), i};
            }
            traversed.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
