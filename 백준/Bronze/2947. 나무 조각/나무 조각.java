import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while (!checking(arr)) {
            // 1
            if(arr[0] > arr[1]){
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
                for(int i = 0; i < 5; i++){
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
            }
            // 2
            if(arr[1] > arr[2]){
                int temp = arr[1];
                arr[1] = arr[2];
                arr[2] = temp;
                for(int i = 0; i < 5; i++){
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
            }
            // 3
            if(arr[2] > arr[3]){
                int temp = arr[2];
                arr[2] = arr[3];
                arr[3] = temp;
                for(int i = 0; i < 5; i++){
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
            }
            // 4
            if(arr[3] > arr[4]){
                int temp = arr[3];
                arr[3] = arr[4];
                arr[4] = temp;
                for(int i = 0; i < 5; i++){
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean checking(int[] arr) {
        for (int i = 1; i < 5; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}