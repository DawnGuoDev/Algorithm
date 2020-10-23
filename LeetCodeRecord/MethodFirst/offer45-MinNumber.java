package MethodFirst;

import java.util.Arrays;
import java.util.Comparator;

class MinNumber {

    public String minNumber(int[] nums) {
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });

        StringBuffer res = new StringBuffer();
        for (String s : numStrings) {
            res.append(s);
        }

        return res.toString();
    }

    public void quickSort(String[] strings, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        String s = strings[right];

        while (i < j) {
            while ((strings[i] + s).compareTo(s + strings[i]) <= 0 && i< j) {
                i++;
            }

            while ((strings[j] + s).compareTo(s + strings[j]) >= 0 && i < j) {
                j--;
            } 

            String temp = strings[i];
            strings[i] = strings[j];
            strings[j] = temp; 
        }

        strings[right] = strings[i];
        strings[i] = s;

        quickSort(strings, left, i - 1);
        quickSort(strings, i + 1, right);
    }

    public void quickSort2(String[] strings, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = left;
        String s = strings[right];

        while (j <= right) {
            if ((strings[j] + s).compareTo(s + strings[j]) <= 0) {
                String temp = strings[i];
                strings[i] = strings[j];
                strings[j] = temp;
                i++;
                j++;
            } else {
                j++;
            }
        }

        quickSort2(strings, left, i - 2);
        quickSort2(strings, i, right);
    }

    public String minNumber2(int[] nums) {
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }
        
        quickSort2(numStrings, 0, nums.length - 1);

        StringBuffer res = new StringBuffer();
        for (String s : numStrings) {
            res.append(s);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        // System.out.println("103".compareTo("301"));
        MinNumber mn = new MinNumber();
        System.out.println(mn.minNumber2(new int[]{10, 2}));
    }

}
