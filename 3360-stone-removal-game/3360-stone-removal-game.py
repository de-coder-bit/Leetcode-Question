class Solution:
    def canAliceWin(self, n: int) -> bool:
        take = 10
        alice_wins = False

        while n >= take:
            n -= take
            take -= 1
            alice_wins = not alice_wins

        return alice_wins