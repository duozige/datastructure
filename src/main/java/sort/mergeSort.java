package sort;

public class mergeSort {
    private static int[] copy;
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

    public static void merge(int nums[], int start, int mid, int end){
        int i = start, j = mid + 1;
        for(int k = start; k <= end; k++)
            copy[k] = nums[k];

        for(int k = start; k <= end; k++){
            if(i > mid)
                nums[k] = copy[j++];
            else if(j > end)
                nums[k] = copy[i++];
            else if(less(copy[i],copy[j]))
                nums[k] = copy[i++];
            else
                nums[k] = copy[j++];
        }
    }

    public static void sort(int nums[], int start, int end){
        if(start >= end)
            return;
        int mid = start + (end - start)/2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public static void main(String[] args){
        int[] nums = {1, 5, 4, 7, 9, 0, 6, 2, 8, 3};
        copy = new int[nums.length];
        sort(nums, 0, 9);
        show(nums);
    }

}
