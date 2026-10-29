class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int total = 10;      // n = 1 ka answer
        int current = 9;     // k digit numbers ka count (pehle digit ke liye 9 choices)
        int available = 9;   // agle digit ke liye bache hue choices

        for (int k = 2; k <= n && available > 0; k++) {
            current *= available;
            total += current;
            available--;
        }

        return total;
    }
}