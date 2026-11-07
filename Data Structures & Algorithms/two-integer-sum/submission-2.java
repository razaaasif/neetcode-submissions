class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(valueToIndex.get(target-nums[i]) != null) {
                return new int[]{valueToIndex.get(target-nums[i]), i};
            }
            valueToIndex.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
