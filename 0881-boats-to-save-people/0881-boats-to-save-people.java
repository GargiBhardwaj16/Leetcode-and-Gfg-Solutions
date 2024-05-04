class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result=0;
        for (int i = 0, j = people.length - 1; i <= j; ++result) {
               int remain = limit - people[j--];
               if (people[i] <= remain)
                ++i;
            }
        return result;
    }
}