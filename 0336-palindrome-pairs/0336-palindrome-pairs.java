class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            for (int j = 0; j <= word.length(); j++) {

                String left = word.substring(0, j);
                String right = word.substring(j);

                // Case 1
                if (isPalindrome(left)) {
                    String rev = new StringBuilder(right).reverse().toString();
                    Integer idx = map.get(rev);

                    if (idx != null && idx != i) {
                        ans.add(Arrays.asList(idx, i));
                    }
                }

                // Case 2
                if (right.length() > 0 && isPalindrome(right)) {
                    String rev = new StringBuilder(left).reverse().toString();
                    Integer idx = map.get(rev);

                    if (idx != null && idx != i) {
                        ans.add(Arrays.asList(i, idx));
                    }
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }

        return true;
    }
}