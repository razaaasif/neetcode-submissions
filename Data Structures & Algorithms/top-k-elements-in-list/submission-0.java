class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int n : nums){
            freq.merge(n, 1, Integer::sum);
        }

        List<Map.Entry<Integer,Integer>> freqList = new ArrayList<>(freq.entrySet());
        freqList.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = freqList.get(i).getKey();
        }
        return result;
    }
}
