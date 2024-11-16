import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        // Test case 1
        int n = 3;
        // Test case 2
        // int n = 1;
        // Test case 3
        // int n = 8;

        obj.generateParenthesis(n);

        for(int i = 0; i < obj.res.size(); i++)
            System.out.println(obj.res.get(i));
    }

    public List<String> generateParenthesis(int n) {
        generate(n, "", 0, 0);
        return res;
    }

    public void generate(int n, String s, int open, int close) {
        if(open < n)
            generate(n, s + "(", open + 1, close);

        if(close < n && open > close)
            generate(n, s + ")", open, close + 1);

        if(open == close && open == n)
            res.add(s);
    }
}
