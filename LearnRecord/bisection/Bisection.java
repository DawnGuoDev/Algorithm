package bisection;

public class Bisection {
    
    /**
     * 非递归的方式实现二分查找
     * @param array
     * @param len
     * @param value
     * @return
     */
    public int bsearch(int[] array, int len, int value) {
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 递归的方式实现二分查找
     * @param array
     * @param low
     * @param high
     * @param value
     * @return
     */
    public int bsearchInternally(int[] array, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high -  low) >> 1);
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] < value) {
            return bsearchInternally(array, mid + 1, high, value);
        } else {
            return bsearchInternally(array, low, mid - 1, value);
        }
    }


    /**
     * 查找第一个值等于给定值的 index
     * @param array
     * @param len
     * @param value
     * @return
     */
    public int bsearchFirstEqual(int[] array, int len, int value) {
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] < value) {
                low = mid + 1;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || array[mid - 1] != value) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的 index
     * @param array
     * @param len
     * @param value
     */
    public int bsearchLastEqual(int[] array, int len, int value) {
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (array[mid] < value) {
                low = mid + 1;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == len -1 || array[mid + 1] != value) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的 index
     * @param array
     * @param len
     * @param value
     * @return
     */
    public int bsearchFirstMore(int[] array, int len, int value) {
        int low = 0; 
        int high = len - 1;
        
        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] < value) {
                    return mid;
                }
                high = mid - 1;                
            }
        }

        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的 index
     * @param array
     * @param len
     * @param value
     * @return
     */
    public int bsearchLastLess(int[] array, int len, int value) {
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            
            if (array[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == len - 1 || array[mid + 1] > value) {
                    return mid;
                }
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 6, 8, 8, 8, 8, 18};
        Bisection b = new Bisection();
        
        System.out.println(b.bsearchFirstEqual(array, array.length, 8));
        System.out.println(b.bsearchLastEqual(array, array.length, 8));
        System.out.println(b.bsearchLastLess(array, array.length, 9));
        System.out.println(b.bsearchFirstMore(array, array.length, 9));

    }
}