class Solution {
    class Pair<F, S> {
        private F first;
        private S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        List<Pair<Integer, Pair<Integer, Integer>>> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int dx = (0 - points[i][0]) * (0 - points[i][0]);
            int dy = (0 - points[i][1]) * (0 - points[i][1]);
            int d = dx + dy;

            Pair<Integer, Integer> p = new Pair<>(points[i][0], points[i][1]);
            l.add(new Pair<>(d, p));
        }

        Collections.sort(l, new Comparator<Pair<Integer, Pair<Integer, Integer>>>() {
            @Override
            public int compare(Pair<Integer, Pair<Integer, Integer>> p1, Pair<Integer, Pair<Integer, Integer>> p2) {
                return p1.getFirst().compareTo(p2.getFirst()); // Ascending order
            }
        });

        int[][] arr = new int[k][2];
        for (int i = 0; i < k; i++) {
            arr[i][0] = l.get(i).getSecond().getFirst();
            arr[i][1] = l.get(i).getSecond().getSecond();
        }
        return arr;
    }
}