class Solution:
    def findMaximumXOR(self, nums: list[int]) -> int:
        ans = 0
        for bit in range(30, -1, -1):
            ans <<= 1
            prefixes = {x >> bit for x in nums}
            candidate = ans | 1
            # can we form `candidate` as XOR of two prefixes?
            if any((candidate ^ p) in prefixes for p in prefixes):
                ans = candidate
        return ans