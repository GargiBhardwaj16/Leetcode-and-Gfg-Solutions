class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer>m=new HashMap<>();
        for(int i = 0; i < nums.length; i++){
           if (m.containsKey(nums[i]))
            {
                m.put(nums[i], m.get(nums[i]) + 1);
            }
            else
            {
                m.put(nums[i], 1);
            }
        }
       int arr[]=new int[k];
       //PriorityQueue<Map.Entry<Integer, Integer>> pq= new PriorityQueue<>((a, b) -> b-a);
        PriorityQueue<Map.Entry<Integer, Integer>> pq= new PriorityQueue<>((a, b)-> a.getValue().equals(b.getValue())
                           ? Integer.compare(b.getKey(),
                                             a.getKey())
                           : Integer.compare(b.getValue(),
                                             a.getValue()));
       for (Map.Entry<Integer, Integer> entry :m.entrySet())
             pq.add(entry);
       for (int i = 0; i < k; i++) {
            arr[i]=pq.poll().getKey();
        }
        return arr;
    }
}
