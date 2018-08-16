import java.util.Scanner;

class Point{
    int x;
    int y;
    boolean pass;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.pass = false;
    }

    public int distance(Point p){
        return Math.abs(x - p.x) + Math.abs(y - p.y);
    }
}

public class AliKuaiDi {
    public static final Point p0 = new Point(0,0);
    public static int min = Integer.MAX_VALUE;

    public static int minPath(Point start, Point[] points, int sum, int count){
        if(count == points.length){
            min = Math.min(min, sum +start.distance(p0));
            return min;
        }
        for(int i = 0; i<points.length; i++){
            if(points[i].pass == false){
                sum += points[i].distance(start);
                if(sum < min){
                    points[i].pass = true;
                    minPath(points[i], points, sum, count+1);
                }
                sum -= points[i].distance(start);
                points[i].pass = false;
            }
        }
        return min;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int pnum = Integer.parseInt(input.nextLine().trim());

        Point[] points = new Point[pnum];
        for(int i = 0; i<pnum; i++){
            String[] locations = input.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        int min = minPath(p0, points, 0, 0);
        System.out.println(min);
    }
}