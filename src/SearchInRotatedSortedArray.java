public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        // Test case 1
        int[] nums = {4,5,6,7,0,1,2};
        // Test case 2
        // int[] nums = {1};
        // Test case 3
        // int[] nums = {1, 2};
        // Test case 4
        // int[] nums = {1,2,3,4,5,6};
        // Test case 5
        // int[] nums = {1,3};

        System.out.println("Found target at index = "+obj.search(nums, 0));
    }

    public int search(int[] nums, int target) {
        if(nums.length == 1) {
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }

        int mid = nums.length / 2;
        int left = mid - 1;
        int right = mid + 1;

        if(nums[mid] == target)
            return mid;

        while(left <= right) {
            if(left < nums.length && left >= 0) {
                if(nums[left] == target)
                    return left;
                else
                    left = left - 1;
            }

            if(right < nums.length && right >= 0) {
                if(nums[right] == target)
                    return right;
                else
                    right = right + 1;
            }

            if(left < 0 && right > nums.length - 1)
                break;
        }

        return -1;
    }
}
