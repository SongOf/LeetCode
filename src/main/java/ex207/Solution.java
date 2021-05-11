package ex207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/3/14 20:54
 * @Version 1.0
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //图的邻接表
        List<Integer>[] graphic = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphic[i] = new ArrayList<>();
        }
        //A->B A课程修完 B课程才可以修
        for (int i = 0; i < prerequisites.length; i++) {
            graphic[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        //入度数即先修课程数
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, 0);
        for (int i = 0; i < numCourses; i++) {
            List<Integer> nextNodes = graphic[i];
            for(Integer nxtNode : nextNodes) {
                inDegree[nxtNode]++;
            }
        }
        //入度为0说明没有先修课程，可以先修这个课程
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        //课程修完 所有后继课程的入度-1
        while (!queue.isEmpty()) {
            Integer courseToFinish = queue.poll();
            numCourses--;
            List<Integer> nextNodes = graphic[courseToFinish];
            for(Integer nxtNode : nextNodes) {
                inDegree[nxtNode]--;
                if(inDegree[nxtNode] == 0) {
                    queue.offer(nxtNode);
                }
            }
        }
        return numCourses == 0;
    }
}
