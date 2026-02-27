import sys
from bisect import bisect_left
input = sys.stdin.readline

def solve():
    N = int(input())
    arr = list(map(int, input().split()))
    arr.sort()

    count = 0
    for i in range(N):
        # arr[i]가 큰 쪽일 때, 작은 쪽 >= arr[i] * 0.9인 경계를 찾음
        # 정수 비교로 바꾸면: arr[j] * 10 >= arr[i] * 9
        lo = bisect_left(arr, arr[i] * 9 / 10)
        # lo ~ i-1 범위가 arr[i]와 쌍이 되는 원소들
        count += i - lo

    print(count)

solve()
