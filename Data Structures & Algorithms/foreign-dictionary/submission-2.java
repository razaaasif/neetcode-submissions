class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character,HashSet<Character>> adj = new HashMap<>();
        HashMap<Character,Integer> indegree = new HashMap<>();
        for(String word : words){
            //indegree indegree
            for(int i = 0 ; i < word.length(); i++){
                adj.putIfAbsent(word.charAt(i) ,  new HashSet<>());
                indegree.putIfAbsent(word.charAt(i),0);
            }
        }

        //adj creation
        for(int i = 0 ; i < words.length-1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int min = Math.min(w1.length(),w2.length());
            boolean found = false;
            for(int j = 0 ; j < min; j++){
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                if(ch1 != ch2){
                    if (adj.get(ch1).add(ch2)) {  // Only if newly added
                        indegree.put(ch2, indegree.get(ch2) + 1);
                    }
                    found = true ;
                    break;
                }
            }
            //invalid case ["abc","ab"]

            if(!found && w1.length() > w2.length()){
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        indegree.forEach((k,v) -> {if(v == 0){
            queue.offer(k);}
        });
        while(!queue.isEmpty()){
            Character ch = queue.poll();
            sb.append(ch);
            for(Character a : adj.get(ch)){
                indegree.put(a,indegree.get(a) - 1);
                if(indegree.get(a) == 0){
                    queue.offer(a);
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
