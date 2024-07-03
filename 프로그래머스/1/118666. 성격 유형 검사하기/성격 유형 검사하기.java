class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        int[][] score = new int[4][2];
        // R, T
        // C, F
        // J, M
        // A, N

        for (int i = 0; i < survey.length; i++) {
            if (survey[i].charAt(0) == 'R' || survey[i].charAt(0) == 'T') {
                if (survey[i].charAt(0) == 'R') {
                    switch (choices[i]) {
                        case 1:
                            score[0][0] += 3;
                            break;
                        case 2:
                            score[0][0] += 2;
                            break;
                        case 3:
                            score[0][0] += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            score[0][1] += 1;
                            break;
                        case 6:
                            score[0][1] += 2;
                            break;
                        case 7:
                            score[0][1] += 3;
                            break;
                    }
                } else {
                    switch (choices[i]) {
                        case 1:
                            score[0][1] += 3;
                            break;
                        case 2:
                            score[0][1] += 2;
                            break;
                        case 3:
                            score[0][1] += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            score[0][0] += 1;
                            break;
                        case 6:
                            score[0][0] += 2;
                            break;
                        case 7:
                            score[0][0] += 3;
                            break;
                    }
                }
            } else if (survey[i].charAt(0) == 'C' || survey[i].charAt(0) == 'F') {
                if (survey[i].charAt(0) == 'C') {
                    switch (choices[i]) {
                        case 1:
                            score[1][0] += 3;
                            break;
                        case 2:
                            score[1][0] += 2;
                            break;
                        case 3:
                            score[1][0] += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            score[1][1] += 1;
                            break;
                        case 6:
                            score[1][1] += 2;
                            break;
                        case 7:
                            score[1][1] += 3;
                            break;
                    }
                } else {
                    switch (choices[i]) {
                        case 1:
                            score[1][1] += 3;
                            break;
                        case 2:
                            score[1][1] += 2;
                            break;
                        case 3:
                            score[1][1] += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            score[1][0] += 1;
                            break;
                        case 6:
                            score[1][0] += 2;
                            break;
                        case 7:
                            score[1][0] += 3;
                            break;
                    }
                }
            } else if (survey[i].charAt(0) == 'J' || survey[i].charAt(0) == 'M') {
                if (survey[i].charAt(0) == 'J') {
                    switch (choices[i]) {
                        case 1:
                            score[2][0] += 3;
                            break;
                        case 2:
                            score[2][0] += 2;
                            break;
                        case 3:
                            score[2][0] += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            score[2][1] += 1;
                            break;
                        case 6:
                            score[2][1] += 2;
                            break;
                        case 7:
                            score[2][1] += 3;
                            break;
                    }
                } else {
                    switch (choices[i]) {
                        case 1:
                            score[2][1] += 3;
                            break;
                        case 2:
                            score[2][1] += 2;
                            break;
                        case 3:
                            score[2][1] += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            score[2][0] += 1;
                            break;
                        case 6:
                            score[2][0] += 2;
                            break;
                        case 7:
                            score[2][0] += 3;
                            break;
                    }
                }
            } else {
                if (survey[i].charAt(0) == 'A') {
                    switch (choices[i]) {
                        case 1:
                            score[3][0] += 3;
                            break;
                        case 2:
                            score[3][0] += 2;
                            break;
                        case 3:
                            score[3][0] += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            score[3][1] += 1;
                            break;
                        case 6:
                            score[3][1] += 2;
                            break;
                        case 7:
                            score[3][1] += 3;
                            break;
                    }
                } else {
                    switch (choices[i]) {
                        case 1:
                            score[3][1] += 3;
                            break;
                        case 2:
                            score[3][1] += 2;
                            break;
                        case 3:
                            score[3][1] += 1;
                            break;
                        case 4:
                            break;
                        case 5:
                            score[3][0] += 1;
                            break;
                        case 6:
                            score[3][0] += 2;
                            break;
                        case 7:
                            score[3][0] += 3;
                            break;
                    }
                }
            }
        }

        if (score[0][0] >= score[0][1]) {
            answer += "R";
        } else {
            answer += "T";
        }

        if (score[1][0] >= score[1][1]) {
            answer += "C";
        } else {
            answer += "F";
        }

        if (score[2][0] >= score[2][1]) {
            answer += "J";
        } else {
            answer += "M";
        }

        if (score[3][0] >= score[3][1]) {
            answer += "A";
        } else {
            answer += "N";
        }


        return answer;
    }
}
