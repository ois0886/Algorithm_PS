import sys

input = sys.stdin.readline


def solve():
    # N: 운동해야 하는 시간(분)
    # m: 최소 맥박 (초기 맥박이기도 함)
    # M: 최대 맥박 (이걸 넘으면 안 됨)
    # T: 운동 시 맥박 증가량
    # R: 휴식 시 맥박 감소량
    N, m, M, T, R = map(int, input().split())

    # 초기 맥박이 m인데, m + T > M이면 한 번도 운동 못 함
    # 휴식해도 m 아래로 안 내려가니까 영원히 운동 불가
    if m + T > M:
        print(-1)
        return

    now = m      # 초기 맥박은 m
    answer = 0   # 총 소요 시간 (운동 + 휴식)

    while N > 0:
        if now + T <= M:
            # 운동 가능 → 운동
            now += T
            N -= 1
        else:
            # 운동 불가 → 휴식 (맥박은 m 아래로 안 내려감)
            now = now - R if now - R >= m else m
        answer += 1

    print(answer)


solve()
