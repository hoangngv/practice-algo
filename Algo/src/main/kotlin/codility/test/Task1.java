package codility.test;

public class Task1 {
    public static int solution(String S) {
        // if a bit is 0, we only use 1 bit shift operation (to devide 2)
        // if a bit is 1, we use both 1 subtract operation and 1 bit shift operation (except the first 1 -> only 1 operation)

        int N = S.length();
        int pos = -1;
        int count_1 = 0;
        int count_0 = 0;
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == '1') {
                pos = i;
                break;
            }
        }
        if (pos >= 0) {
            for (int i = pos; i < N; i++) {
                if (S.charAt(i) == '1') count_1++;
                else count_0++;
            }
            return count_1 * 2 + count_0 - 1;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        System.out.println("hello");
        String S = "000010";
        System.out.println(solution(S));
    }
}