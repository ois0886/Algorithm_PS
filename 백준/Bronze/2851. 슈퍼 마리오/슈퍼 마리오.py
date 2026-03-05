import sys

input = sys.stdin.readline


def solve():
    arr = [int(input()) for _ in range(10)]
    prefix = [0] * 11

    for i in range(10):
        prefix[i + 1] = prefix[i] + arr[i]

    x = float('inf')
    answer = 0

    for i in range(1, len(prefix)):
        if x > abs(100 - prefix[i]) or abs(100 - prefix[i]) == x and prefix[i] > answer:
            answer = prefix[i]
            x = abs(100 - prefix[i])

    print(answer)


# --- 1차원 누적합 ---
# arr = [3, 1, 4, 1, 5]
# prefix = [0] * (len(arr) + 1)
# for i in range(len(arr)):
#     prefix[i + 1] = prefix[i] + arr[i]
# # prefix = [0, 3, 4, 8, 9, 14]
# # 구간 [1, 3) 합 = prefix[3] - prefix[1] = 8 - 3 = 5


solve()
