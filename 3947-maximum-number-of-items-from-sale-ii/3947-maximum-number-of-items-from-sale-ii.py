from typing import List

class Solution:
    def maximumSaleItems(self, items: List[List[int]], budget: int) -> int:
        n = len(items)

        cnt = [0] * (n + 1)
        for f, _ in items:
            cnt[f] += 1

        # multiples[f] = un items ki ginti jinka factor f ka multiple hai
        multiples = [0] * (n + 1)
        for f in range(1, n + 1):
            if cnt[f]:
                multiples[f] = sum(cnt[f::f])

        mn = min(p for _, p in items)
        ans = 0

        for f, p in sorted(items, key=lambda x: x[1]):
            if p >= 2 * mn or p > budget:
                break
            take = min(multiples[f] - 1, budget // p)  # khud ko exclude karein
            ans += 2 * take
            budget -= take * p

        return ans + budget // mn