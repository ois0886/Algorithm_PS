import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String[] video_len_arr = video_len.split(":");
        String[] pos_arr = pos.split(":");
        String[] op_start_arr = op_start.split(":");
        String[] op_end_arr = op_end.split(":");
        int cmd_length = commands.length;
        
        int[] video_len_int = new int[2];
        int[] pos_int = new int[2];
        int[] op_start_int = new int[2];
        int[] op_end_int = new int[2];
        
        for(int i =0; i< 2; i++){
            video_len_int[i] = Integer.parseInt(video_len_arr[i], 10);
            pos_int[i] = Integer.parseInt(pos_arr[i], 10);
            op_start_int[i] = Integer.parseInt(op_start_arr[i], 10);
            op_end_int[i] = Integer.parseInt(op_end_arr[i], 10);
        }
        
        System.out.println(op_start_int[1] + pos_int[1]);
        //오프닝 구간인 경우
        if((op_start_int[0] < pos_int[0] || op_start_int[0] == pos_int[0] && op_start_int[1] <= pos_int[1]) && (op_end_int[0] > pos_int[0] || op_end_int[0] ==pos_int[0] && op_end_int[1] >= pos_int[1])){
            pos_int[0] = op_end_int[0];
            pos_int[1] = op_end_int[1];
            System.out.println("Check");
        }
        
        for(int j = 0; j< cmd_length ; j++){
            if(commands[j].equals("next")){
                pos_int = next_cmd(pos_int, op_start_int, op_end_int, video_len_int);
            }
            else if(commands[j].equals("prev")){
                pos_int = prev_cmd(pos_int, op_start_int, op_end_int, video_len_int);
            }
            
            //오프닝 구간인 경우
            if((op_start_int[0] < pos_int[0] || op_start_int[0] == pos_int[0] && op_start_int[1] <= pos_int[1]) && (op_end_int[0] > pos_int[0] || op_end_int[0] ==pos_int[0] && op_end_int[1] >= pos_int[1])){
                pos_int[0] = op_end_int[0];
                pos_int[1] = op_end_int[1];
            }
        }
        
        if(pos_int[0] < 10){
            answer = "0" + Integer.toString(pos_int[0]) + ":";
        }else{
            answer = Integer.toString(pos_int[0]) + ":";
        }
        
        if(pos_int[1] < 10){
            answer = answer + "0" + Integer.toString(pos_int[1]);
        }else{
            answer = answer + Integer.toString(pos_int[1]);
        }
        
        return answer;
    }
    
    private int[] prev_cmd(int[] pos_int, int[] op_start, int[] op_end, int[] video_len){
        if(pos_int[1]< 10){
            pos_int[1] = pos_int[1] + 50;
            pos_int[0] -= 1;
        }else{
            pos_int[1] -= 10;
        }
        
        if(pos_int[0] < 0 || pos_int[0] == 0 && pos_int[1] < 0){
            pos_int[0] = 0;
            pos_int[1] = 0;
        }
        
        
        return pos_int;
    }
    
    private int[] next_cmd(int[] pos_int, int[] op_start, int[] op_end, int[] video_len){
        if(pos_int[1] > 50){  
            pos_int[1] = pos_int[1] - 50;
            pos_int[0] += 1;
        }else{
            pos_int[1] += 10;
        }
        
        if(pos_int[0] > video_len[0] || pos_int[0] == video_len[0] && pos_int[1] > video_len[1]){ // 끝부분인 경우
            pos_int[0] = video_len[0];
            pos_int[1] = video_len[1];
        }
        
        return pos_int;
    }
}