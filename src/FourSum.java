import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FourSum {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        // Test case 1
        int[] nums = {1,0,-1,0,-2,2};
        // Test case 2
        // int[] nums = {2,2,2,2,2};

        FourSum fourSum = new FourSum();
        fourSum.fourSum(nums, 0);

        for(int i = 0; i < fourSum.res.size(); i++) {
            System.out.println();
            for(int j = 0; j < fourSum.res.get(i).size(); j++)
                System.out.print(fourSum.res.get(i).get(j) + " ");
        }

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(i);
            calc(nums, target, i + 1, curr, nums[i]);
        }

        for(int i = 0; i < res.size(); i++)
            Collections.sort(res.get(i));

        for(int i = 0; i < res.size(); i++) {
            for(int j = i + 1; j < res.size(); j++) {
                int cnt = 0;

                for(int k = 0; k < res.get(i).size(); k++) {
                    if(res.get(i).get(k) != res.get(j).get(k))
                        break;
                    else
                        cnt++;
                }

                if(cnt == 4) {
                    res.remove(j);
                    j--;
                }
            }
        }

        return res;
    }

    public void calc(int[] nums, int target, int ind, List<Integer> curr, int s) {
        if(curr.size() == 3 && ind < nums.length && s + nums[ind] == target) {
            List<Integer> inn = new ArrayList<>();
            for(int i = 0; i < curr.size(); i++)
                inn.add(nums[curr.get(i)]);
            inn.add(nums[ind]);
            res.add(inn);
        } else {

            for(int i = ind; i < nums.length; i++) {
                List<Integer> inn = new ArrayList<>(curr);
                inn.add(i);
                calc(nums, target, i + 1, inn, s + nums[i]);
            }
        }
    }
}
