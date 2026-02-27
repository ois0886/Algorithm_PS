import sys
from collections import deque
input = sys.stdin.readline

def solve():
    N = int(input())
    result = deque([])
    '''
    1. 2 1 4 3에서 2를 가장 뒤로 옮긴다. (1 4 3 2)
    2. 1을 책상 위에 옮겨놓는다. (4 3 2) -> 반드시 1
    3. 4 3 2 에서 4, 3을 뒤로 옮긴다. (2 4 3)
    4. 2를 책상 위로 옮겨놓는다. (4 3) -> 반드시 2
    5. 4 3 에서 가장 앞에 있는 것을 뒤로 3번 옮긴다. (3 4)
    6. 3을 책상 위로 옮겨놓는다. (4) -> 반드시 3
    7. 4를 책상 위로 옮겨놓는다. (완료) -> 반드시4
    
    -> N번 반복한다.
    1. number가 들어오고, 뒤집기
    이거 걍 구현이네
    '''

    for number in range(N, 0, -1) :
        result.appendleft(number)
        result.rotate(number)

    print(*result)

solve()
