
import java.util.*;

public class Snake {
    private List<int[]> points;

    public Snake() {
        points = new ArrayList<int[]>();
    }
    
    public Snake(int[] point) {
        points = new ArrayList<int[]>();
        points.add(point);
    }
    
    public Snake(int x, int y) {
        points = new ArrayList<int[]>();
        int[] point = {x,y};
        points.add(point);
    }
    
    public List<int[]> getPoints() {
        return points;
    }
    
    public void insertPoint(int[] point){
        points.add(point);
    }
    
    public void inserPoint(int x, int y){
        int[] point = {x,y};
        points.add(point);
    }
}
