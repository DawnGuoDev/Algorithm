package backtracking;
/**
 * 现在我们有 n 个物品，每个物品的重量不等，并且不可分割。
 * 我们现在期望选择几件物品装进背包。在不超过背包所能装载
 * 的重量之下，如何让背包中物品的总重量最大。 
 */
public class Packbag {
    private int maxW = Integer.MIN_VALUE;
    
    public void maxBag(int itemNum, int sumW, int itemLen, int[] items, int maxCap) {
        if (sumW >= maxCap || itemNum >= itemLen) {
            if (sumW >= this.maxW) {
                this.maxW = sumW;
            }
            return;
        }

        maxBag(itemNum + 1, sumW, itemLen, items, maxCap); // 不取编号为 itemNum 的物品
        if (sumW + items[itemNum] <= maxCap) { // 取编号为 itemNum 的物品
            maxBag(itemNum + 1, sumW + items[itemNum], itemLen, items, maxCap);
        } 
    }

    public static void main(String[] arg) {
        Packbag p = new Packbag();
        int[] items = new int[]{1, 2, 3, 4, 5};
        p.maxBag(0, 0, 5, items, 8);

        System.out.println(p.maxW);
    }

}