import sys

input = sys.stdin.readline


def solve():
    # === DP 테이블 미리 구하기 (n 최대 64) ===
    MAX = 65

    # dp[i][j] = i자리 수에서 마지막 숫자가 j인 "줄어들지 않는 수"의 개수
    # 예: dp[2][3] = 4 → (03, 13, 23, 33)
    dp = [[0] * 10 for _ in range(MAX)]

    # 1자리: 0~9 각각 1개씩
    for j in range(10):
        dp[1][j] = 1

    # i자리 수 채우기 (2자리부터)
    for i in range(2, MAX):
        for j in range(10):
            # 마지막 숫자가 j이려면, 바로 앞 자리는 j 이하여야 함
            # → dp[i-1][0] + dp[i-1][1] + ... + dp[i-1][j]
            for k in range(j + 1):
                dp[i][j] += dp[i - 1][k]

    # === 테스트 케이스 처리 ===
    T = int(input())
    for _ in range(T):
        n = int(input())
        # n자리 줄어들지 않는 수의 총 개수
        # = 마지막 숫자가 0인 경우 + 1인 경우 + ... + 9인 경우
        print(sum(dp[n]))


solve()
