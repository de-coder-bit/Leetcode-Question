class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;

        int[] mask = new int[n];
        int[] len = new int[n];

        for (int i = 0; i < n; i++) {
            int bitMask = 0;

            for (char c : words[i].toCharArray()) {
                bitMask |= 1 << (c - 'a');
            }

            mask[i] = bitMask;
            len[i] = words[i].length();
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, len[i] * len[j]);
                }
            }
        }

        return max;
    }
}