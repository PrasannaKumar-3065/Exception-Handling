package pk;
import java.util.*;
import java.util.logging.*;

abstract class Shapes{
    static double radius;
    static double base;
    static double length;
    static double height;
    static double breadth;
    static double side1;
    static double side2;
    double ans;
    protected static final Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    abstract void perimeter();
    abstract void area();

}

class Triangle extends Shapes{
    
    void perimeter(){
        ans = (Shapes.side1+Shapes.side2+Shapes.base);
        LOGGER.log(Level.INFO,Double.toString(ans),"Perimeter of triangle: "+ans);
    }

    void area(){
        ans = 0.5*(Shapes.base*Shapes.height);
        LOGGER.log(Level.INFO,Double.toString(ans),"Area of triangle: "+ans);
    }

    Triangle(double side1, double side2, double base, double height){
        Shapes.side1 = side1;
        Shapes.side2 = side2;
        Shapes.base = base;
        Shapes.height = height;  
    }
}

class Circle extends Shapes{
    void perimeter(){
        ans = 2*3.14*Shapes.radius;
        LOGGER.log(Level.INFO,Double.toString(ans),"Perimeter of circle: "+ans);
    }

    void area(){
        ans = 3.14*(Shapes.radius*Shapes.radius);
        LOGGER.log(Level.INFO,Double.toString(ans),"Area of circle: "+ans);
    }

    Circle(double radius){
        Shapes.radius = radius;
    }
}
class Rectangle extends Shapes{
    void perimeter(){
        ans = 2*(Shapes.length+Shapes.breadth);
        LOGGER.log(Level.INFO,Double.toString(ans),"Perimeter of rectangle: "+ans);
    }

    void area(){
        ans = (Shapes.length*Shapes.breadth);
        LOGGER.log(Level.INFO,Double.toString(ans),"Area of rectangle: "+ans);
    }
    Rectangle(double length, double breadth){
        Shapes.length = length;
        Shapes.breadth = breadth;
    }
}

public class ShapeException {
    private static final Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = 1;
        do{
            try{
                LOGGER.log(Level.INFO,"\n1.Triangle 2.Rectangle 3.Circle\n");
                int choice = sc.nextInt();
                if(choice == 1){
                    LOGGER.log(Level.INFO,"\nenter side 1: ");
                    double side1 = sc.nextDouble();
                    LOGGER.log(Level.INFO,"\nenter side 2: ");
                    double side2 = sc.nextDouble();
                    LOGGER.log(Level.INFO,"\nenter base: ");
                    double base = sc.nextDouble();
                    LOGGER.log(Level.INFO,"\nenter height: ");
                    double height = sc.nextDouble();

                    Shapes s = new Triangle(side1,side2,base,height);
                    s.perimeter();
                    s.area();
                }
                else if(choice == 2){
                    LOGGER.log(Level.INFO,"enter length: ");
                    double length = sc.nextDouble();
                    LOGGER.log(Level.INFO,"enter breadth: ");
                    double breadth = sc.nextDouble();

                    Shapes s = new Rectangle(length, breadth);
                    s.perimeter();
                    s.area();
                }
                else if(choice == 3){
                    LOGGER.log(Level.INFO,"enter radius: ");
                    double radius = sc.nextDouble();

                    Shapes s = new Circle(radius);
                    s.perimeter();
                    s.area();
                }
                else{
                    LOGGER.log(Level.INFO,"exiting..");
                    n=0;
                }
            }catch(Exception e){
                String s = ""+e;
                LOGGER.info(s);
                sc.nextLine();
                LOGGER.info("_______________________________________________");
            }
        }while(n == 1);
    }
    
}