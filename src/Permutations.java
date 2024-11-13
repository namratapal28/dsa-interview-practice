import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations obj = new Permutations();

        // Test case 1
        int[] nums = {1, 2, 3};
        // Test case 2
        // int[] nums = {0};
        // Test case 3
        // int[] nums = {1, 2};
        // Test case 4
        // int[] nums = {1, 2, 3, 4};

        List<List<Integer>> res = obj.permute(nums);

        for (int i = 0; i < res.size(); i++) {
            System.out.println();
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        calc(res, new ArrayList<>(), nums);

        return res;
    }

    public void calc(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length)
            res.add(new ArrayList<>(tempList));
        else {
            for(int i = 0; i < nums.length; i++) {
                if(!tempList.contains(nums[i])) {
                    tempList.add(nums[i]);
                    calc(res, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
