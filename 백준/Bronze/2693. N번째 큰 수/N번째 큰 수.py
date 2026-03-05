import sys

input = sys.stdin.readline


def solve():
    T = int(input())
    answer = []
    for _ in range(T):
        data = list(map(int, input().split()))
        data.sort(reverse=True)
        answer.append(str(data[2]))

    print('\n'.join(answer))


solve()
