import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] A;
	static int[][] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		B = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = str.charAt(j) - '0';
			}
		}

		int answer = 0;

		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {

				if (A[i][j] != B[i][j]) {
					reverse(i, j);
					answer++;
				}

			}
		}

		if (sameChecking()) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}

	private static void reverse(int x, int y) {

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				A[i + x][j + y] = A[i + x][j + y] == 0 ? 1 : 0;
			}
		}
	}

	private static boolean sameChecking() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j])
					return false;
			}
		}

		return true;
	}
}