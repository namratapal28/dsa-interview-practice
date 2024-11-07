import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        // Test case 1
        int[] nums = {-1,0,1,2,-1,-4};
        // Test case 2
        // int[] nums = {0,1,1};
        // Test case 3
        // int[] nums = {0,0,0};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> res = threeSum.threeSum(nums);

        for(int i = 0; i < res.size(); i++) {
            System.out.println();
            for(int j = 0; j < res.get(i).size(); j++)
                System.out.print(res.get(i).get(j) + " ");
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        res.add(l);
                    }
                }
            }
        }

        for(int i = 0; i < res.size(); i++)
            Collections.sort(res.get(i));

        for(int i = 0; i < res.size(); i++) {
            for(int j = i + 1; j < res.size(); j++) {
                int cnt = 0;

                for(int k = 0; k < res.get(i).size(); k++){
                    if(res.get(i).get(k) != res.get(j).get(k))
                        break;
                    else
                        cnt++;
                }

                if(cnt == 3) {
                    res.remove(j);
                    j--;
                }
            }
        }

        return res;
    }
}
