class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> freq = new HashMap<>();
        for(int ele : nums){
            freq.merge(ele, 1, Integer::sum);
        }

        List<List<Integer>> bucketList = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++){
            bucketList.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> element : freq.entrySet()){
            int count = element.getValue();
            int key = element.getKey();
            bucketList.get(count).add(key);
        }

        int[] result = new int[k];
        int i = 0;
        for(int count = bucketList.size()-1 ; count >= 1; count--){
            for(int ele : bucketList.get(count)){
                result[i++] = ele;
                if(i == k) return result;
            }
        }
        return result;
    }
}
