import sys

input = sys.stdin.readline


def solve():
    # === 입력 ===
    # N: 회전 초밥 벨트에 놓인 접시의 수 (2 ≤ N ≤ 30,000)
    # d: 초밥의 가짓수 (2 ≤ d ≤ 3,000)
    # k: 연속해서 먹는 접시의 수 (2 ≤ k ≤ 3,000, k ≤ N)
    # c: 쿠폰 번호 - 무료로 추가 제공되는 초밥 종류 (1 ≤ c ≤ d)
    N, d, k, c = map(int, input().split())

    # belt: 벨트 위 초밥 종류를 순서대로 저장한 리스트
    # 예) [7, 9, 7, 30, 2, 7, 9, 25]
    belt = [int(input()) for _ in range(N)]

    # === 슬라이딩 윈도우 준비 ===
    # cnt[i]: 현재 윈도우 안에 초밥 종류 i가 몇 개 있는지 카운트
    # 인덱스 0은 사용하지 않음 (초밥 번호는 1부터 시작)
    cnt = [0] * (d + 1)

    # kinds: 현재 윈도우 안의 서로 다른 초밥 종류 수
    kinds = 0

    # 첫 번째 윈도우 [0, k) 구간을 세팅
    for i in range(k):
        if cnt[belt[i]] == 0:      # 처음 등장하는 종류면
            kinds += 1              # 종류 수 증가
        cnt[belt[i]] += 1          # 해당 초밥 카운트 증가

    # 쿠폰 초밥이 윈도우에 없으면 +1 (무료로 추가 제공되므로)
    ans = kinds + (1 if cnt[c] == 0 else 0)

    # === 슬라이딩: 윈도우를 한 칸씩 오른쪽으로 이동 ===
    for i in range(1, N):
        # 1) 윈도우에서 빠지는 원소: 이전 윈도우의 맨 왼쪽 (인덱스 i-1)
        out = belt[i - 1]
        cnt[out] -= 1
        if cnt[out] == 0:          # 빠진 후 그 종류가 0개가 되면
            kinds -= 1              # 종류 수 감소

        # 2) 윈도우에 들어오는 원소: 새 윈도우의 맨 오른쪽
        #    원형 벨트이므로 % N으로 인덱스를 순환시킴
        inp = belt[(i + k - 1) % N]
        if cnt[inp] == 0:          # 처음 등장하는 종류면
            kinds += 1              # 종류 수 증가
        cnt[inp] += 1              # 해당 초밥 카운트 증가

        # 3) 현재 윈도우의 종류 수 + 쿠폰 보너스로 최댓값 갱신
        cur = kinds + (1 if cnt[c] == 0 else 0)
        ans = max(ans, cur)

    print(ans)


solve()
