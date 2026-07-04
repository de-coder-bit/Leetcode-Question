class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int k, int target, int start) {
        if (target == 0 && temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0 || temp.size() > k) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            temp.add(i);
            backtrack(result, temp, k, target - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}