class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // start
            events.add(new int[]{b[1], b[2]});  // end
        }

        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, Integer> heights = new TreeMap<>();
        heights.put(0, 1);

        int prevMax = 0;

        for (int[] e : events) {
            int x = e[0];
            int h = e[1];

            if (h < 0) {
                heights.put(-h, heights.getOrDefault(-h, 0) + 1);
            } else {
                heights.put(h, heights.get(h) - 1);
                if (heights.get(h) == 0) {
                    heights.remove(h);
                }
            }

            int currMax = heights.lastKey();

            if (currMax != prevMax) {
                result.add(Arrays.asList(x, currMax));
                prevMax = currMax;
            }
        }

        return result;
    }
}