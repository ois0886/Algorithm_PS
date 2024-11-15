import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine().trim());
        int[] arrA = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = Integer.parseInt(br.readLine().trim());
        int[] arrB = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 두 수열의 공통되는 숫자 집합 구하기
        Set<Integer> setA = new HashSet<>();
        for (int num : arrA) {
            setA.add(num);
        }

        Set<Integer> commonElements = new HashSet<>();
        for (int num : arrB) {
            if (setA.contains(num)) {
                commonElements.add(num);
            }
        }

        // 공통되는 숫자가 없으면 0 출력 후 종료
        if (commonElements.isEmpty()) {
            System.out.println(0);
            return;
        }

        List<Integer> result = new ArrayList<>();

        while (!commonElements.isEmpty()) {
            // 공통 숫자들 중 최대값 찾기
            int maxVal = Collections.max(commonElements);
            result.add(maxVal);

            // 각각의 A와 B 수열에서 최대값 이후의 부분 수열로 업데이트
            int idx1 = findIndex(arrA, maxVal);
            int idx2 = findIndex(arrB, maxVal);
            arrA = Arrays.copyOfRange(arrA, idx1 + 1, arrA.length);
            arrB = Arrays.copyOfRange(arrB, idx2 + 1, arrB.length);

            // 새로운 공통 숫자 집합 구하기
            setA.clear();
            for (int num : arrA) {
                setA.add(num);
            }

            commonElements.clear();
            for (int num : arrB) {
                if (setA.contains(num)) {
                    commonElements.add(num);
                }
            }
        }

        // 결과 출력
        System.out.println(result.size());
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static int findIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1; // should never reach here if the value exists in the array
    }
}
