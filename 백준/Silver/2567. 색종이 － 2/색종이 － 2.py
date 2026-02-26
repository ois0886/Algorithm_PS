import sys

input = sys.stdin.readline


def solve():
    board = [[0] * 100 for _ in range(100)]
    N = int(input())
    for _ in range(N):
        x, y = map(int, input().split())
        for i in range(x, x + 10):
            for j in range(y, y + 10):
                board[i][j] = 1
    ans = 0
    for i in range(100):
        for j in range(100):
            if board[i][j] == 1:
                for di, dj in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                    ni, nj = i + di, j + dj
                    if ni < 0 or nj < 0 or ni >= 100 or nj >= 100 or board[ni][nj] == 0:
                        ans += 1
    print(ans)


solve()
