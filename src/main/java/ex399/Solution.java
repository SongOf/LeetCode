package ex399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/4/5 9:28
 * @Version 1.0
 */
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationSize = equations.size();
        UnionFind unionFind = new UnionFind(equationSize * 2);
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < equationSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);
            if(!map.containsKey(var1)) map.put(var1, index++);
            if(!map.containsKey(var2)) map.put(var2, index++);
            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }
        int querySize = queries.size();
        double[] res = new double[querySize];
        for (int i = 0; i < querySize; i++) {
            Integer idx1 = map.get(queries.get(i).get(0));
            Integer idx2 = map.get(queries.get(i).get(1));
            if(idx1 == null || idx2 == null) res[i] = -1.0d;
            else res[i] = unionFind.isConnected(idx1, idx2);
        }
        return res;
    }
    private class UnionFind {
        private int[] parent;
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }
        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return;
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }
        public int find(int x) {
            if(x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] = weight[x] * weight[origin];
            }
            return parent[x];
        }
        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                return weight[x] / weight[y];
            }
            else {
                return -1.0d;
            }
        }
    }
}
