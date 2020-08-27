package recursion;

public class Factorial {
    
    public int fac(int n) {
        if (1 == n) {
            return 1;
        }

        return n * fac(n - 1);
    }

    public static void main(String[] args) {
        Factorial ft = new Factorial();
        System.out.println(ft.fac(20));
    }
}