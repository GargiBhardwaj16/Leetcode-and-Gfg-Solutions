class Pair {
        char character;
        int count;

        Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().character == c) {
                stack.peek().count++;
            } else {
                stack.push(new Pair(c, 1));
            }

            if (stack.peek().count == k) {
                stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            for (int i = 0; i < p.count; i++) {
                result.insert(0, p.character);
            }
        }

        return result.toString();
    }
}