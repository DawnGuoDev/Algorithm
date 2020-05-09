package recursion;

import java.security.Key;
import java.util.HashMap;

import sun.launcher.resources.launcher;

public class Fibonacci {
    private HashMap<Integer, Integer> hasSolvedMap;

    public Fibonacci() {
        this.hasSolvedMap = new HashMap<Integer, Integer>();
    }

    public int fibo(int n) {
        int ret;

        if (1 == n || 2 == n) {
            return 1;
        }
        
       if (this.hasSolvedMap.containsKey(n)) {
           return this.hasSolvedMap.get(n);
       }

       ret = fibo(n - 1) + fibo(n - 2);
       this.hasSolvedMap.put(n, ret);

        return ret;
    }

    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci();
        System.out.println(fb.fibo(1000));
    }
}