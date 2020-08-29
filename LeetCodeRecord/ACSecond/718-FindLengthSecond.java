package ACSecond;

class FindLengthSecond {
    public int findLength(int[] A, int[] B) {
        int ALen = A.length;
        int BLen = B.length;

        int max = 0;
        for (int i = 0; i < ALen; i++) {
            int re = find(A, i, B, 0, Math.min(BLen, ALen - i));            
            if (re > max) {
                max = re;
            }
        }

        for (int j = 1; j < BLen; j++) {
            int re = find(A, 0, B, j, Math.min(ALen, BLen - j));
            if (re > max) {
                max = re;
            }
        }

        return max;
    }

    public int find(int[] A, int ABegin, int[] B, int BBegin, int len) {
        int max = 0;

        int k = 0;
        for (int i = 0; i < len; i++) {
            if (A[ABegin + i] == B[BBegin + i]) {
                k = k + 1;
            } else {
                k = 0;
            }

            if (k > max) {
                max = k;
            }
        }

        return max;
    } 

    public static void main(String[] args) {
        FindLengthSecond fl = new FindLengthSecond();
        System.out.println(fl.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }
}