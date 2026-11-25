import random
from collections import Counter
from typing import List

class Solution:
    def smallestUniqueSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        MOD = (1 << 61) - 1
        base = random.randrange(10**6, MOD - 1)

        pre = [0] * (n + 1)
        pw = [1] * (n + 1)
        for i, x in enumerate(nums):
            pre[i + 1] = (pre[i] * base + (x % MOD) + 1) % MOD
            pw[i + 1] = pw[i] * base % MOD

        def has_unique(L):
            cnt = Counter()
            for i in range(n - L + 1):
                cnt[(pre[i + L] - pre[i] * pw[L]) % MOD] += 1
            return 1 in cnt.values()

        lo, hi = 1, n
        while lo < hi:
            mid = (lo + hi) // 2
            if has_unique(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo