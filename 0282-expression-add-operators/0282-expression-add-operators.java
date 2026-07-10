import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, String path, String num,
                           int target, int index, long value, long prev) {
        if (index == num.length()) {
            if (value == target) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;

            String curStr = num.substring(index, i + 1);
            long cur = Long.parseLong(curStr);

            if (index == 0) {
                backtrack(result, curStr, num, target, i + 1, cur, cur);
            } else {
                backtrack(result, path + "+" + curStr, num, target,
                        i + 1, value + cur, cur);

                backtrack(result, path + "-" + curStr, num, target,
                        i + 1, value - cur, -cur);

                backtrack(result, path + "*" + curStr, num, target,
                        i + 1, value - prev + prev * cur, prev * cur);
            }
        }
    }
}