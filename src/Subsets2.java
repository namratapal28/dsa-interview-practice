import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets2 {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Subsets2 obj = new Subsets2();

        // Test case 1
        int[] nums = {1, 2, 2};
        // Test case 2
        // int[] nums = {0};
        // Test case 3
        // int[] nums = {1, 2};
        // Test case 4
        // int[] nums = {1, 2, 3, 4};

        obj.subsetsWithDup(nums);

        for (int i = 0; i < obj.res.size(); i++) {
            System.out.println();
            for (int j = 0; j < obj.res.get(i).size(); j++) {
                System.out.print(obj.res.get(i).get(j) + " ");
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> inn = new ArrayList<>();
        res.add(inn);

        for(int i = 0; i < nums.length; i++) {
            inn = new ArrayList<>();
            inn.add(i);

            List<Integer> val = new ArrayList<>();
            val.add(nums[i]);
            res.add(val);

            calc(nums, i + 1, inn, val);
        }

        for(int i = 0; i < res.size(); i++)
            Collections.sort(res.get(i));

        for(int i = 0; i < res.size(); i++) {
            for(int j = i + 1; j < res.size(); j++) {
                if(res.get(i).size() == res.get(j).size()) {
                    int cnt = res.get(i).size();

                    for(int k = 0; k < res.get(i).size(); k++) {
                        if(res.get(i).get(k) != res.get(j).get(k))
                            break;
                        else
                            cnt--;
                    }

                    if(cnt == 0) {
                        res.remove(j);
                        j--;
                    }
                }
            }
        }

        return res;
    }

    public void calc(int[] nums, int ind, List<Integer> indices, List<Integer> values) {
        for(int i = ind; i < nums.length; i++) {
            List<Integer> inn = new ArrayList<>(indices);
            List<Integer> val = new ArrayList<>(values);
            if(!indices.contains(i)) {
                inn.add(i);
                val.add(nums[i]);
                res.add(val);
            }
            calc(nums, i + 1, inn, val);
        }
    }
}
