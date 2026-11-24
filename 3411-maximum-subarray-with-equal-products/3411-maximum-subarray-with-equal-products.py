from math import gcd, lcm

class Solution:
    def maxLength(self, nums: list[int]) -> int:
        n = len(nums)
        best = 0
        for i in range(n):
            p, g, l = 1, 0, 1
            for j in range(i, n):
                p *= nums[j]
                g = gcd(g, nums[j])
                l = lcm(l, nums[j])
                if p == g * l:
                    best = max(best, j - i + 1)
        return best