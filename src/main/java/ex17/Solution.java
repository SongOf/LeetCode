package ex17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinationRes = new ArrayList<>();
        if(digits == null || digits.length() == 0) return combinationRes;
        Map<Character, String> numToCharsMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        traceBack(combinationRes, numToCharsMap, digits, 0, new StringBuffer());
        return combinationRes;
    }
    public void traceBack(List<String> combinationRes, Map<Character, String> numToCharsMap, String digits, int index, StringBuffer combination) {
        if(index == digits.length()) combinationRes.add(combination.toString());
        else {
            String chs = numToCharsMap.get(digits.charAt(index));
            for (int i = 0; i < chs.length(); i++) {
                combination.append(chs.charAt(i));
                traceBack(combinationRes, numToCharsMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.letterCombinations("2");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
