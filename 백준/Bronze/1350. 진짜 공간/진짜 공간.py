import sys

input = sys.stdin.readline


def solve():

    N = int(input())
    data = list(map(int, input().split()))
    cluster = int(input())
    num = N

    for i in range(N) :
        if data[i] > cluster and data[i] != 0:
            num += (data[i] // cluster)
            if (data[i] % cluster) == 0 :
                num -= 1
        if data[i] == 0 :
            num -= 1

    print(num * cluster)

# S1, S2, S3


solve()
