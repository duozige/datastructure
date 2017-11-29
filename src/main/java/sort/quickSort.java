package sort;

public class quickSort {
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

    public static void sort(int[] nums, int start, int end){
        if(start >= end)
            return;
        int k = partition(nums, start, end);
        sort(nums, start, k -1);
        sort(nums, k + 1, end);
    }

    public static int partition(int[] nums, int start, int end){
        int i = start, j = end + 1;
        int key = nums[start];
        while (true){
            while (less(nums[++i], key))
                if(i >= end)
                    break;
            while (less(key, nums[--j]))
                if(j <= start)
                    break;

            if(i >= j)
                break;
            exch(nums, i, j);
        }
        exch(nums, start, j);
        return j;
    }

    public static void main(String[] args){
        int[] nums = {1, 5, 4, 7, 9, 0, 6, 2, 8, 3};
        sort(nums, 0, 9);
        show(nums);
    }
}
