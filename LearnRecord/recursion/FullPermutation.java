package recursion;

public class FullPermutation {
    
    public void fullPermutation(char[] list, int start) {
        if (list.length == start) {
            System.out.println(list);
        }
        
        for (int i = start; i < list.length; i++) {
            swap(list, i, start);
            fullPermutation(list, start + 1);
            swap(list, i, start);
        }
    }

    public void swap (char[] list, int i, int j) {
        char temp;
        temp = list[i];
        list[i] = list[j];
        list[j] = temp;
        return;
    }
    public static void main(String[] args) {
        new FullPermutation().fullPermutation(new char[]{'1', '2', '3'}, 0);
    }
}