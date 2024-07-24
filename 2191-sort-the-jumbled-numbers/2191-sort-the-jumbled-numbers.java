// Class to hold the original number and its mapped value
    class MappedNumber {
        int originalValue;
        int mappedValue;
        
        MappedNumber(int originalValue, int mappedValue) {
            this.originalValue = originalValue;
            this.mappedValue = mappedValue;
        }
    }
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Create an array of the same length as nums to hold the mapped values
        int n = nums.length;
        MappedNumber[] mappedNumbers = new MappedNumber[n];
        
        for (int i = 0; i < n; i++) {
            mappedNumbers[i] = new MappedNumber(nums[i], mapNumber(nums[i], mapping));
        }
        
        // Sort based on the mapped value and maintain the original order using stable sort
        Arrays.sort(mappedNumbers, Comparator.comparingInt(a -> a.mappedValue));
        
        // Extract the original numbers from the sorted mapped numbers
        for (int i = 0; i < n; i++) {
            nums[i] = mappedNumbers[i].originalValue;
        }
        
        return nums;
    }
    // Helper method to map the number using the given mapping
    private int mapNumber(int num, int[] mapping) {
        if (num == 0) return mapping[0];
        
        int mappedNum = 0;
        int place = 1;
        
        while (num > 0) {
            int digit = num % 10;
            mappedNum += mapping[digit] * place;
            place *= 10;
            num /= 10;
        }
        
        // Return the mapped number
        return mappedNum;
    }
}