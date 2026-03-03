import sys

input = sys.stdin.readline


def solve():
    # N: 지름길의 개수 (1 ≤ N ≤ 12)
    # D: 고속도로의 길이 (1 ≤ D ≤ 10,000)
    N, D = map(int, input().split())

    # shortcuts: 지름길 정보를 담는 리스트
    # 각 원소는 (시작 위치, 도착 위치, 지름길 길이) 튜플
    # 예) [(0, 50, 10), (0, 50, 20), (50, 100, 10), ...]
    shortcuts = []
    for _ in range(N):
        start, end, length = map(int, input().split())
        shortcuts.append((start, end, length))

    # dist[i]: 위치 0에서 위치 i까지의 최소 이동 거리
    # 지름길 없이 직진하면 거리 = 위치값이므로 i로 초기화
    # D+1 크기로 만들어서 dist[D]가 최종 답
    dist = [i for i in range(D + 1)]

    # 위치 1부터 D까지 한 칸씩 이동하면서 최소 거리 갱신
    for i in range(1, D + 1):
        # 1) 직진: 이전 위치에서 1km 이동
        dist[i] = min(dist[i], dist[i - 1] + 1)

        # 2) 지름길: 도착지가 i인 지름길이 있으면 비교
        for start, end, length in shortcuts:
            if end == i and start <= i:
                # 지름길이 D 범위 안이고, 직진보다 빠르면 갱신
                dist[i] = min(dist[i], dist[start] + length)

    print(dist[D])

solve()
