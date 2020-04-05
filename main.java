package algo_learn;

public class main {
    public static void main(String[] args) {
        Array a =  new Array(10);
        a.insert(0, 3);
        a.insert(0, 2);
        a.insert(0, 1);
        a.insert(0, 0);
        a.printAll();
       
        a.insertArray(new int[]{1,2,3,4,5,5});
        a.printAll();
    }
}