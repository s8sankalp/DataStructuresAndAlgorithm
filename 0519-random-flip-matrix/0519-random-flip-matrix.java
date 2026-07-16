class Solution {

    private int rows, cols;
    private int total;
    private HashMap<Integer, Integer> map;
    private Random rand;

    public Solution(int m, int n) {
        rows = m;
        cols = n;
        total = m * n;
        map = new HashMap<>();
        rand = new Random();
    }

    public int[] flip() {
        int x = rand.nextInt(total);

        total--;

        int idx = map.getOrDefault(x, x);

        map.put(x, map.getOrDefault(total, total));

        return new int[]{idx / cols, idx % cols};
    }

    public void reset() {
        total = rows * cols;
        map.clear();
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */