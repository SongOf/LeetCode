package ex5702;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/14 10:54
 * @Version 1.0
 */
public class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < 2; j++) {
                if(!map.containsKey(edges[i][j])) {
                    map.put(edges[i][j], 0);
                }
                map.put(edges[i][j], map.get(edges[i][j]) + 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> item : set) {
            if(item.getValue() == edges.length) return item.getKey();
        }
        return -1;
    }
}
