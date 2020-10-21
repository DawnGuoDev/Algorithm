package MethodFirst;

import java.util.ArrayList;
import java.util.List;

class SpiraOrder {
    public List<Integer> spiraOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int rows = matrix.length;
        if (rows == 0) {
            return res;
        }
        int columns = matrix[0].length;
        int leftMargin = 0;
        int rightMargin = columns - 1;
        int upMargin = 0;
        int bottomMargin = rows - 1;

        while (leftMargin <= rightMargin && upMargin <= bottomMargin) {
            // 从左到右   
            for (int i = leftMargin; i <= rightMargin; i++) {
                res.add(matrix[upMargin][i]);
            }
            upMargin ++;
            if (upMargin > bottomMargin) {
                break;
            }

            // 从上往下
            for (int i = upMargin; i <= bottomMargin; i++) {
                res.add(matrix[i][rightMargin]);
            }
            rightMargin --;
            if (rightMargin < leftMargin) {
                break;
            }

            // 从右往左
            for (int i = rightMargin; i >= leftMargin; i--) {
                res.add(matrix[bottomMargin][i]);
            }
            bottomMargin --;
            if (bottomMargin < upMargin) {
                break;
            }

            // 从下往上
            for (int i = bottomMargin; i >= upMargin; i--) {
                res.add(matrix[i][leftMargin]);
            }
            leftMargin ++;
            if (leftMargin > rightMargin) {
                break;
            }
        }

        return res;
    }
    
}
