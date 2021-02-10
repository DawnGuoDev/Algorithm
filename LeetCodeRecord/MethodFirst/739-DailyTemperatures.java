package MethodFirst;

import java.util.Stack;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<int[]> stack = new Stack<int[]>();
        int[] res = new int[T.length];

        for (int i = 0; i < T.length; i ++) {
            while (!stack.empty() && stack.peek()[1] < T[i]) {
                int[] temp = stack.pop();
                res[temp[0]] = i - temp[0];                        
            }

            stack.push(new int[]{i, T[i]});
        }

        return res;
    }    

    public int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];

        for (int i = T.length - 2; i >= 0; i --) {
            for (int j = i + 1; j < T.length; j+=res[j]) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }

                if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }

        return res;
    }
}
