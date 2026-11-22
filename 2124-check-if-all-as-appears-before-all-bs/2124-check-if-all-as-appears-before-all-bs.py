class Solution:
    def checkString(self, s: str) -> bool:
        # If "ba" appears anywhere, some 'b' comes before an 'a'
        return "ba" not in s