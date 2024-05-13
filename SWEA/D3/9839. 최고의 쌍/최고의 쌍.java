import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; ++t) {
			int n = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int[] arr = new int[str.length];
			for(int i=0; i<arr.length; ++i) {
				arr[i] = Integer.parseInt(str[i]);
			}
			int maxMulti = -1;
			for(int i=0; i<arr.length-1; ++i) {
				int x = arr[i];
				for(int j=i+1; j<arr.length; ++j) {
					int y = arr[j];
					int z = x * y;
					int num = z % 10;
					z /= 10;
					boolean check = true;
                    
					while(z > 0){
						if(num - 1 == z%10){
							num--;
						}else{
							check = false;
							break;
						}
						z /= 10;
					}
					if(check && maxMulti < x*y){
						maxMulti = x*y;
					}
				}
			}
			bw.write("#"+t+" "+maxMulti+"\n");
		}
		br.close();
		bw.close();
	}

}