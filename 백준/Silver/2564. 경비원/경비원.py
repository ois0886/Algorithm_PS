import sys

input = sys.stdin.readline


def solve():
    # X: 블록 가로 길이, Y: 블록 세로 길이
    X, Y = map(int, input().split())

    # N: 상점의 개수
    N = int(input())

    # stores: 상점 위치 리스트 (방향, 거리) 튜플
    stores = []
    for _ in range(N):
        direction, dist = map(int, input().split())
        stores.append((direction, dist))

    # 동근이의 위치
    dong_dir, dong_dist = map(int, input().split())

    # 둘레 = 직사각형 한 바퀴
    perimeter = 2 * (X + Y)

    # 방향+거리 → 둘레 위 1차원 위치로 변환
    # 왼쪽 위 꼭짓점(0)에서 시계방향으로 쭉 펼친 거리
    #
    #     0 ──→ 북쪽 ──→ X
    #     │                │
    #   서쪽             동쪽
    #     │                │
    #   2X+Y ←── 남쪽 ←── X+Y
    #
    def to_pos(direction, dist):
        if direction == 1:  # 북쪽: 왼쪽에서 dist만큼
            return dist
        if direction == 2:  # 남쪽: 오른쪽에서 dist만큼 (반대방향)
            return X + Y + (X - dist)
        if direction == 3:  # 서쪽: 아래에서 dist만큼 (반대방향)
            return 2 * X + Y + (Y - dist)
        if direction == 4:  # 동쪽: 위에서 dist만큼
            return X + dist

    # 동근이의 둘레 위 위치
    dong_pos = to_pos(dong_dir, dong_dist)

    # 각 상점까지의 최단거리 합산
    result = 0
    for direction, dist in stores:
        store_pos = to_pos(direction, dist)

        # 시계방향 거리
        clockwise = abs(dong_pos - store_pos)
        # 반시계방향 거리
        counter = perimeter - clockwise
        # 둘 중 짧은 쪽 선택
        result += min(clockwise, counter)

    print(result)


solve()
