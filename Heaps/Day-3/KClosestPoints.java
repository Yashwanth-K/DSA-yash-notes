// k closest points to origin
import java.util.*;
public class KClosestPoints {

    public int[][] findKClosestPoints(int[][] points,int k){
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));

        for (int[] point:points){
            minheap.add(point);
        }
        int[][] result = new int[k][2];
        for (int i=0;i<k;i++){
            result[i] = minheap.poll();
        }
        return result;

    }
    public static void main(String[] args) {
        KClosestPoints kcp = new KClosestPoints();
        int[][] points = {{1,3},{-2,2},{5,8},{0,1}};
        int k = 2;
        int[][] result = kcp.findKClosestPoints(points, k);
        System.out.println(Arrays.deepToString(result));

        // for (int[] point : result) {
        //     System.out.println("[" + point[0] + ", " + point[1] + "]");
        // }
        
    }

    
}
