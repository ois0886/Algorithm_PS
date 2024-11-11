import java.io.*;

class Main {

    static int n;

    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int row = 0;
        int col = 0;

        String[] str_row = new String[n];
        String[] str_col = new String[n];

        for (int i = 0; i < n; i++) {
            str_row[i] = br.readLine();
        }


        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < n; j++) {
                str.append(str_row[j].charAt(i));
            }
            str_col[i] = str.toString();
        }

        for (int i = 0; i < n; i++) {
            String[] arr = str_row[i].split("X");
            for (String s : arr) {
                if (s.length() >= 2) row++;
            }
        }

        for (int i = 0; i < n; i++) {
            String[] arr = str_col[i].split("X");
            for (String s : arr) {
                if (s.length() >= 2) col++;
            }
        }


        sb.append(row).append(" ").append(col);
        System.out.println(sb);

    }
}