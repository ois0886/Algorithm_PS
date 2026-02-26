import sys

input = sys.stdin.readline
def solve():
    N = int(input())
    sum = 0
    arr = [int(input()) for _ in range(N)]
    arr.sort()
    for i in range(N) :
        sum += abs(arr[i] - (i + 1))

    print(sum)
solve()
