import sys

input = sys.stdin.readline


def solve():
    R, C = map(int, input().split())
    grid = [input().strip() for _ in range(R)]

    for r in range(R):
        for c in range(C):
            if grid[r][c] == '.':
                # 인접한 '.' 칸 개수 세기
                cnt = 0
                for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < R and 0 <= nc < C and grid[nr][nc] == '.':
                        cnt += 1
                # 인접한 길이 1개 이하면 막다른 길
                if cnt <= 1:
                    print(1)
                    return
    print(0)


solve()
