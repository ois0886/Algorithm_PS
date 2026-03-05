import sys

input = sys.stdin.readline


def solve():
    A, B = map(int, input().split())
    seq = []
    # 1이 1번
    # 2가 2번
    # 3이 3번
    # 4가 4번
    i = 1
    while len(seq) < B:
        for _ in range(i):
            seq.append(i)
        i += 1

    print(sum(seq[A - 1:B]))


solve()
