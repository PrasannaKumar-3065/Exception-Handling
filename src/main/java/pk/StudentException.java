package pk;
import java.util.*;
import java.util.logging.*;
import java.util.logging.Logger;

class STUDENT{
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    String name;
    char gradelevel;
    float gpa;

    void grade(float gpa){
        if(gpa < 5){
            gradelevel = 'F';
        }
        else if(gpa >5 && gpa < 7){
            gradelevel = 'B';
        }
        else if(gpa > 7){
            gradelevel = 'A';
        }
        String s = "Grade is "+gradelevel;
        LOGGER.info(s);
    }
    void update(float gpa){
        this.gpa = gpa;
        grade(gpa);
    }
    void display(){
        String s = name+"'s GPA is "+gpa;
        LOGGER.info(s);
    }
    STUDENT(String name, float gpa){
        this.name = name;
        this.gpa = gpa;
        grade(gpa);
    }
}

public class StudentException 
{
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
        int n = 1;
        LOGGER.info("Enter Name: ");
        String name = sc.next();
        LOGGER.log(Level.INFO,"GPA:");
        float gpa = sc.nextFloat();
        STUDENT s = new STUDENT(name,gpa);
        do{
            try{
                LOGGER.log(Level.INFO,"\n1.Display GPA 2.Edit GPA 3.Exit");
                int m = sc.nextInt();
                if(m == 1){
                    s.display();
                }
                else if(m==2){
                    LOGGER.log(Level.INFO,"Enter GPA: ");
                    gpa = sc.nextFloat();
                    s.update(gpa);
                }
                else{
                    n = 0;
                }
            }catch(Exception e){
                String s1 = ""+e;
                LOGGER.info(s1);
                sc.nextLine();
            }
        }while(n==1);
    }
}