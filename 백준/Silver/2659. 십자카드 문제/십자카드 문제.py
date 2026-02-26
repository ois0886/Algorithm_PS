import sys
import bisect

input = sys.stdin.readline

def clock_num(s):
    # 4번 회전해서 가장 작은 수를 반환
    nums = []
    for i in range(4):
        nums.append(int(s[i:] + s[:i]))
    return min(nums)

def solve():
    arr = list(map(int, input().split()))
    s = ''.join(map(str, arr))
    smallest = clock_num(s)

    seen = set()
    result = []
    for num in range(1111, 10000):
        st = str(num)
        if '0' in st:
            continue
        cn = clock_num(st)
        if cn not in seen:
            seen.add(cn)
            result.append(cn)
    sorted_result = sorted(result)
    idx = bisect.bisect_left(sorted_result, smallest) + 1
    print(idx)

solve()
