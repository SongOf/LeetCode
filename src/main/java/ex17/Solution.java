package ex17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return new ArrayList();
        }
        int digitsLen=digits.length();
        List<List<Character>> map=new ArrayList();
        List<Character> rows=new ArrayList<Character>(){{add('a');add('b');add('c');}};
        map.add(rows);
        rows=new ArrayList<Character>(){{add('d');add('e');add('f');}};
        map.add(rows);
        rows=new ArrayList<Character>(){{add('g');add('h');add('i');}};
        map.add(rows);
        rows=new ArrayList<Character>(){{add('j');add('k');add('l');}};
        map.add(rows);
        rows=new ArrayList<Character>(){{add('m');add('n');add('o');}};
        map.add(rows);
        rows=new ArrayList<Character>(){{add('p');add('q');add('r');add('s');}};
        map.add(rows);
        rows=new ArrayList<Character>(){{add('t');add('u');add('v');}};
        map.add(rows);
        rows=new ArrayList<Character>(){{add('w');add('x');add('y');add('y');}};
        map.add(rows);
        if(digitsLen==1){

        }
        return new ArrayList();
    }
}
