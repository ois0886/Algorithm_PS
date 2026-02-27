import sys
input = sys.stdin.readline

def solve():
    N = int(input())
    L = list(map(int, input().split()))
    J = list(map(int, input().split()))
    dp = [0] * 100

    for i in range(N):
        for w in range(99, L[i] - 1, -1):
            dp[w] = max(dp[w], dp[w - L[i]] + J[i])

    print(dp[99])

solve()
