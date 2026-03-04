import sys

input = sys.stdin.readline


def solve():
    N, M = map(int, input().split())
    data = [int(input()) for _ in range(M)]

    # 학생은 항상 같은 색의 보석만 가져감
    #
    def can(mid):
        total = 0
        for gem in data:
            total += (gem + mid - 1) // mid
        return total <= N

    lo, hi = 1, max(data)
    while lo < hi:
        mid = (lo + hi) // 2
        if can(mid):
            hi = mid
        else:
            lo = mid + 1

    print(lo)

solve()
