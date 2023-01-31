package pk;
import java.util.logging.*;
import java.util.*;

class Point{
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    String check(int x, int y){
        return (this.x == x && this.y == y) ? "\n true the values are same":"\n false the values are same";    
    }
    Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

public class PointsException 
{
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    public static void main( String[] args ) throws CloneNotSupportedException
    {
        try{
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Enter x1:");
        int x1 = sc.nextInt();
        LOGGER.info("Enter y1:");
        int y1 = sc.nextInt();
        Point p = new Point(x1,y1);
        Point p1 = new Point(p);
        LOGGER.info("Enter x2:");
        p1.x = sc.nextInt();
        LOGGER.info("Enter y2:");
        p1.y = sc.nextInt();
        String s = p.check(p1.x, p1.y);
        LOGGER.info(s);
        s="Original object value x:"+p.x+" y:"+p.y;
        LOGGER.info(s);
        s="Clonned object value x:"+p1.x+" y:"+p1.y;
        LOGGER.info(s);
        }catch(Exception e){
            String s = ""+e;
            LOGGER.info(s);
        }
    }
}