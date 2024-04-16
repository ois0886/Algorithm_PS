import java.util.*;

class Solution {

    static String[][] passwords = {
            {"0", "0", "0", "1", "1", "0", "1"},
            {"0", "0", "1", "1", "0", "0", "1"},
            {"0", "0", "1", "0", "0", "1", "1"},
            {"0", "1", "1", "1", "1", "0", "1"},
            {"0", "1", "0", "0", "0", "1", "1"},
            {"0", "1", "1", "0", "0", "0", "1"},
            {"0", "1", "0", "1", "1", "1", "1"},
            {"0", "1", "1", "1", "0", "1", "1"},
            {"0", "1", "1", "0", "1", "1", "1"},
            {"0", "0", "0", "1", "0", "1", "1"}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            String[][] lines = new String[n][m];
            for (int i = 0; i < n; i++) {
                lines[i] = sc.next().split("");
            }

            List<String> secretCode = new ArrayList<>(findSecretCode(lines));
            
            for (int i = secretCode.size() - 1; i >= 0; i--) {
                if (secretCode.get(i).equals("1")) {
                    break;
                }
                secretCode.remove(secretCode.size() - 1);
            }


            List<Integer> passwordCodes = new ArrayList<>(findPasswordCodes(secretCode));

            Collections.reverse(passwordCodes);

            System.out.println("#" + test_case + " " + defineIsRight(passwordCodes));
        }

        sc.close();
    }

    static List<String> findSecretCode(String[][] lines) {
        for (String[] line : lines) {
            boolean check = false;

            for (String code : line) {
                if (code.equals("1")) {
                    check = true;
                    break;
                }
            }

            if (check) {
                return Arrays.asList(line);
            }
        }
        
        return new ArrayList<>();
    }
    
    static List<Integer> findPasswordCodes(List<String> secretCode) {
        List<Integer> passwordCodes = new ArrayList<>();
        int i = secretCode.size() - 1;
        while (i >= 0) {
            List<String> temp = new ArrayList<String>();
            for (int j = 0; j < 7; j++) {
                temp.add(secretCode.get(i));
                i--;
            }

            Collections.reverse(temp);

            for (int k = 0; k < 10; k++) {
                if (Arrays.equals(passwords[k], temp.toArray())) {
                    passwordCodes.add(k);
                    break;
                }
            }

            if (secretCode.get(i).equals("0")) {
                break;
            }
        }
        
        return passwordCodes;
    }
    
    static int defineIsRight(List<Integer> passwords) {
        int odd = 0;
        int even = 0;
        for (int i = 1; i < 9; i++) {
            if (i % 2 == 1) {
                odd += passwords.get(i - 1);
            } else {
                even += passwords.get(i - 1);
            }
        }

        if ((odd * 3 + even) % 10 == 0) {
            return odd + even;
        }

        return 0;
    }
}