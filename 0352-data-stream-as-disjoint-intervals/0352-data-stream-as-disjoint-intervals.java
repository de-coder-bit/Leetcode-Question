import java.util.*;

class SummaryRanges {
    // key = start of interval, value = end of interval
    private final TreeMap<Integer, Integer> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int value) {
        Integer lowKey = map.floorKey(value);     // greatest start <= value
        Integer highKey = map.higherKey(value);   // smallest start > value

        // Already covered by an existing interval
        if (lowKey != null && map.get(lowKey) >= value) {
            return;
        }

        boolean mergeLeft = lowKey != null && map.get(lowKey) + 1 == value;
        boolean mergeRight = highKey != null && highKey == value + 1;

        if (mergeLeft && mergeRight) {
            // Bridge two intervals into one
            map.put(lowKey, map.get(highKey));
            map.remove(highKey);
        } else if (mergeLeft) {
            map.put(lowKey, value);
        } else if (mergeRight) {
            map.put(value, map.get(highKey));
            map.remove(highKey);
        } else {
            map.put(value, value);
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            res[i][0] = e.getKey();
            res[i][1] = e.getValue();
            i++;
        }
        return res;
    }
}