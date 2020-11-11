package MethodFirst;

import java.util.HashSet;

class IsHappy {
    public int getNext(int oldNum) {
        int newNum = 0;
        while (oldNum != 0) {
            int temp = oldNum % 10;
            newNum += temp * temp;
            oldNum = oldNum / 10;
        }

        return newNum;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do {
            slow = getNext(slow);
            fast = getNext(fast);
            fast = getNext(fast);
        } while(slow != fast);

        return slow == 1;
    }

    public boolean isHappy2(int n) {
        HashSet<Integer> nums = new HashSet<Integer>();

        while (n != 1 && !nums.contains(n)) {
            nums.add(n);            
            n = getNext(n);
        }

        return n == 1;
    }
}
