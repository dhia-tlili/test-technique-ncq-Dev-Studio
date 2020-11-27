
class Solution {
public static int solution(int[] A) {

    int N = A.length;

    if (N == 0) {
        return 0;
    }

    int sum = 0;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < N; i++) {

        int value = Math.abs(A[i]);
        sum += value;

        if (max < value) {
            max = value;
        }

        A[i] = value;
    }


    // A      = [4, -4,1, 6]
    // A(abs) = [4, 4, 1, 6]

    // Max value = 
    // Sum value = 

    
    int[] counts = new int[max + 1];

    for (int value : A) {
        counts[value]++;
    }

    
    int[] Total = new int[sum + 1];

    for (int i = 1; i < Total.length; i++) {
        Total[i] = -1;
    }

    for (int i = 1; i < counts.length; i++) {

        for (int j = 0; j < Total.length; j++) {

            if (Total[j] >= 0) {
                Total[j] = counts[i];
            } else if (j - i >= 0 && Total[j - i] > 0) {
                Total[j] = Total[j - i] - 1;
            }
        }
    }

    int result = sum;

    for (int i = 0; i < Total.length / 2 + 1; i++) {

        if (Total[i] >= 0 && result > Math.abs(sum - 2 * i)) {
            result = Math.abs(sum - 2 * i);
        }
    }

    return result;
}
}