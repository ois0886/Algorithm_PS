import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class Solution {

    //ext 값이 val_ext보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순으로 정렬
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        LinkedList<Data> dataList = new LinkedList<>();

        for (int[] datum : data) {
            dataList.add(new Data(datum[0], datum[1], datum[2], datum[3]));
        }

        LinkedList<Data> Result = new LinkedList<>();

        switch (ext) {
            case "code":
                for (Data value : dataList) {
                    if (value.code < val_ext) {
                        Result.add(value);
                    }
                }
                break;
            case "date":
                for (Data value : dataList) {
                    if (value.date < val_ext) {
                        Result.add(value);
                    }
                }
                break;
            case "maximum":
                for (Data value : dataList) {
                    if (value.maximum < val_ext) {
                        Result.add(value);
                    }
                }
                break;
            case "remain":
                for (Data value : dataList) {
                    if (value.remain < val_ext) {
                        Result.add(value);
                    }
                }
                break;
        }

        switch (sort_by) {
            case "code":
                Result.sort(Comparator.comparingInt(a -> a.code));
                break;
            case "date":
                Result.sort(Comparator.comparingInt(a -> a.date));
                break;
            case "maximum":
                Result.sort(Comparator.comparingInt(a -> a.maximum));
                break;
            case "remain":
                Result.sort(Comparator.comparingInt(a -> a.remain));
                break;
        }



        int[][] answer = new int[Result.size()][4];
        for(int i = 0; i < Result.size(); i++){
            answer[i][0] = Result.get(i).code;
            answer[i][1] = Result.get(i).date;
            answer[i][2] = Result.get(i).maximum;
            answer[i][3] = Result.get(i).remain;
        }

        return answer;
    }
}

class Data {
    int code;
    int date;
    int maximum;
    int remain;

    Data(int code, int date, int maximum, int remain) {
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }
}