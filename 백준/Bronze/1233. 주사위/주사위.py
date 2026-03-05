import sys

input = sys.stdin.readline


def solve():
    x, y, z = map(int, input().split())
    list = [0] * 101
    for i in range(1, x + 1):
        for j in range(1, y + 1):
            for k in range(1, z + 1):
                sum = i + j + k
                list[sum] = list[sum] + 1

    print(list.index(max(list)))


# S1, S2, S3


solve()
