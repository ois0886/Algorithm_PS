import sys
from collections import Counter

input = sys.stdin.readline

def solve():
    N = int(input())
    result = []
    for _ in range(N):
        line = list(map(int, input().split()))
        k = line[0]
        data = line[1:]
        cnt = Counter(data)

        check = False
        num = 0
        for key in cnt :
            if cnt[key] > k // 2 :
                check = True
                num = key

        if check :
            result.append(str(num))
        else :
            result.append("SYJKGW")

    print('\n'.join(result))


solve()
