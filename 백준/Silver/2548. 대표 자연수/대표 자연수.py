import sys

input = sys.stdin.readline


def solve():
    N = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    print(arr[(N - 1) // 2])


solve()