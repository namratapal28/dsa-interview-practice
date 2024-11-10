import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Subsets obj = new Subsets();

        // Test case 1
        int[] nums = {1,2,3};
        // Test case 2
        // int[] nums = {0};
        // Test case 3
        // int[] nums = {1, 2};
        // Test case 4
        // int[] nums = {1, 2, 3, 4};

        obj.subsets(nums);

        for(int i = 0; i < obj.res.size(); i++) {
            System.out.println();
            for(int j = 0; j < obj.res.get(i).size(); j++) {
                System.out.print(obj.res.get(i).get(j) + " ");
            }
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> inn = new ArrayList<>();
        res.add(inn);

        for(int i = 0; i < nums.length; i++) {
            inn = new ArrayList<>();
            inn.add(nums[i]);
            res.add(inn);
            calc(nums, i + 1, inn);
        }

        return res;
    }

    public void calc(int[] nums, int ind, List<Integer> l) {
        for(int i = ind; i < nums.length; i++) {
            List<Integer> inn = new ArrayList<>(l);
            if(!l.contains(nums[i])) {
                inn.add(nums[i]);
                res.add(inn);
            }
            calc(nums, i + 1, inn);
        }
    }
}
