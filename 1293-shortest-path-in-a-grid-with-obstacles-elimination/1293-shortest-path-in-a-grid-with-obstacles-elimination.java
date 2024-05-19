class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int shortestPath(final int[][] grid, final int k) {
        final int m = grid.length, n = grid[0].length;

        final Queue<int[]> queue = new LinkedList<>();
        final int[][] visited = new int[m][n];
        
        for(final int[] v : visited)
            Arrays.fill(v, Integer.MAX_VALUE);

        visited[0][0] = 0;

        queue.offer(new int[] {0, 0, 0});

        int distance = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-- > 0) {
                final int[] curr = queue.poll();

                if(curr[0] == m - 1 && curr[1] == n - 1)
                    return distance;

                for(final int[] direction : DIRECTIONS) {
                    final int newX = curr[0] + direction[0];
                    final int newY = curr[1] + direction[1];

                    if(newX >= m || newX < 0 || newY >= n || newY < 0)
                        continue;

                    final int newK = grid[newX][newY] + curr[2];

                    if(newK > k)
                        continue;

                    if (visited[newX][newY] <= newK)
                        continue;

                    visited[newX][newY] = newK;
                    queue.offer(new int[] {newX, newY, newK});
                }
            }

            distance++;
        }

        return -1;
    }
}