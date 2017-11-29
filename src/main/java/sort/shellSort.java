package sort;

public class shellSort {
    public static boolean less(int x, int y){
        return x < y;
    }

    public static void exch(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static boolean isSorted(int[] nums){
        for(int i = 1; i < nums.length; i++){
            return  !less(nums[i], nums[i-1]);
        }
        return true;
    }

    public static void show(int[] nums){
        for(int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void sort(int[] nums){
        int N = nums.length;
        int h = 1;
        while (h < N/3)
            h = h * 3 + 1;

        while (h > 0){
            for(int i = h; i < N; i++){
                for(int j = i; j >= h  && less(nums[j], nums[j - h]); j -= h)
                    exch(nums, j, j - h);
            }
            h /= 3;
        }
    }

    public static void main(String[] args){
        int[] nums = {1, 5, 4, 7, 9, 0, 6, 2, 8, 3};
        sort(nums);
        show(nums);
    }
}
