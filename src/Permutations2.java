import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Permutations2 obj = new Permutations2();

        // Test case 1
        int[] nums = {1,1,2};
        // Test case 2
        // int[] nums = {1,2,3};
        // Test case 3
        // int[] nums = {1,2,3,4,5,6};

        obj.permuteUnique(nums);

        for (int i = 0; i < obj.res.size(); i++) {
            System.out.println();
            for (int j = 0; j < obj.res.get(i).size(); j++) {
                System.out.print(obj.res.get(i).get(j) + " ");
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        backtrack(new ArrayList<>(), nums);

        for(int i = 0; i < res.size(); i++) {
            for(int j = i + 1; j < res.size(); j++) {
                int cnt = 0;

                for(int k = 0; k < res.get(i).size(); k++) {
                    if(res.get(i).get(k) != res.get(j).get(k))
                        break;
                    else
                        cnt++;
                }

                if(cnt == nums.length) {
                    res.remove(j);
                    j--;
                }
            }
        }

        return res;
    }

    public void backtrack(List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length) {
            List<Integer> inn = new ArrayList<>();
            for(int i = 0; i < tempList.size(); i++)
                inn.add(nums[tempList.get(i)]);
            res.add(inn);
        }
        else {
            for(int i = 0; i < nums.length; i++) {
                if(!tempList.contains(i)) {
                    tempList.add(i);
                    backtrack(tempList, nums);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
