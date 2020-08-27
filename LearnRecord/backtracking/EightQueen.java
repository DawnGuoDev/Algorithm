package backtracking;

public class EightQueen {
    private int[] result = new int[8];
    private int count = 0;

    public void eightQueen(int row) {
        if (row >= 8) {
            print(result);
            this.count++;
            return;
        }

        for (int column = 0; column < 8; column++) {
            if (isOK(row, column)) {
                result[row] = column;
                eightQueen(row + 1);
            }
        }
    }

    public boolean isOK(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                return false;
            }
            
            if (leftUp >= 0 && result[i] == leftUp) {
                return false;
            }

            if (rightUp <= 7 && result[i] == rightUp) {
                return false;
            }

            leftUp--;
            rightUp--;
        }

        return true;
    }
    
    public void print(int[] result) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (result[i] == j) {
                    System.out.print("Q\t");
                } else {
                    System.out.print("*\t");
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        EightQueen eq = new EightQueen();

        eq.eightQueen(0);

        System.out.println(eq.count);
    }
}