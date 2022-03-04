package com.gan;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("第一题：");
        Scanner input = new Scanner(System.in);
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum(nums));
        System.out.println("第二题：");
        int[] flowerbed = new int[]{1,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerbed,1));
        System.out.println(canPlaceFlowers(flowerbed,2));
        System.out.println("第三题：");
        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
    public static int MoreThanHalfNum(int[] array) {
        Arrays.sort(array);
        int majority = array[array.length/2];
        int cnt = array.length/2 + 1;
        for(int i = 0;i<array.length;i++){
            if(majority == array[i]){
                cnt --;
            }
        }
        if(cnt <= 0){
            return array[array.length/2];
        }else{
            return 0;
        }
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int count = 0;
        while (i < flowerbed.length){
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }
    public static int eraseOverlapIntervals(int[][] val) {
        Arrays.sort(val, (a, b) -> a[0] - b[0]);
        int res = 0, n = val.length;
        if(n == 0) return res;
        int[] cur = val[0];
        for(int i = 1; i < n; i++) {
            if(val[i][0] < cur[1]) {
                res ++;
                cur[1] = Math.min(val[i][1], cur[1]);
            } else {
                cur = val[i];
            }
        }
        return res;
    }
}
