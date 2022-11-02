package com.interview.sde.java.search;

//https://leetcode.com/problems/search-in-rotated-sorted-array
public class SearchRotatedArray {

    static int getRotationsRight(int[] nums, int init, int end) {
        int mid = (end + init) / 2;

        if (end > init) {
            if (nums[mid] > nums[end]) {
                return getRotationsRight(nums, mid + 1, end);
            }
            return getRotationsRight(nums, init, mid);
        }

        return mid;
    }


    static int search(int[] nums, int target) {
        int rotation = getRotationsRight(nums, 0, nums.length - 1);

        return (nums[rotation] <= target && target <= nums[nums.length - 1]) ?
                binarySearch(nums, target, rotation, nums.length - 1) :
                binarySearch(nums, target, 0, rotation - 1);
    }

    static int binarySearch(int[] nums, int target, int init, int end) {
        if (end < init) {
            return -1;
        }
        int mid = (end + init) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, target, init, mid - 1);
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, end);
        }

        return mid;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); //4
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1)); //5
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2)); //6
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); //-1
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4)); //0
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5)); //1
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6)); //2
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7)); //3

        System.out.println(search(new int[]{5, 1, 3}, 3)); //2


        System.out.println(search(new int[]{4}, 7)); //-1
        System.out.println(search(new int[]{4}, 4)); //0
/////
    }
}
