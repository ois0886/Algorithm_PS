import sys
input = sys.stdin.readline

def solve():
    R, C = map(int, input().split())
    grid = [input().strip() for _ in range(R)]
    words = []

    # 가로: 각 행을 #으로 split
    for r in range(R):
        for word in grid[r].split('#'):
            if len(word) >= 2:
                words.append(word)

    # 세로: 각 열을 위에서 아래로 읽어서 #으로 split
    for c in range(C):
        col = ''.join(grid[r][c] for r in range(R))
        for word in col.split('#'):
            if len(word) >= 2:
                words.append(word)

    words.sort()
    print(words[0])

solve()
