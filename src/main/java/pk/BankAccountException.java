package pk;
import java.util.*;
import java.util.logging.*;
class BANK {
    String name;
    int accno;
    int balance;
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    void withdraw(int amount){
        if(balance < amount){
            String s = "Current balance is "+balance+". amount "+amount+" cannot be withdrawn.";
            LOGGER.info(s);
        }
        else if(balance-amount < 500){
            LOGGER.info("Minimum balance must be atleast 500");
        }
        else{
            this.balance -= amount;
            String s = "Current balance: "+balance;
            LOGGER.info(s);
        }
    } 
    void withdraw(){
        this.balance -= 100;
    }    
    void deposit(int amount){
        this.balance += amount;
        String s = "Current balance: "+balance;
        LOGGER.info(s);
    }
    BANK(String name, int accno, int balance){
        this.name = name;
        this.accno = accno;
        this.balance = balance;
    }
}

public class BankAccountException 
{
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        LOGGER.log(Level.INFO,"My bank \n");
        LOGGER.log(Level.INFO,"name :");
        String name = sc.next();
        LOGGER.log(Level.INFO,"account number :");
        int accno  = sc.nextInt();
        BANK b = new BANK(name,accno,500);
        int start = 1;
        do{
            try{
                LOGGER.info("1.deposit 2.withdraw 3.check balance 4.exit");
                int s = sc.nextInt();
                if(s == 1){
                    LOGGER.info("Enter amount: ");
                    int amount = sc.nextInt();
                    b.deposit(amount);
                }
                else if(s == 2){
                    LOGGER.info("Enter amount: ");
                    int amount = sc.nextInt();
                    b.withdraw(amount);
                    
                }
                else if(s == 3){
                    String m = ""+b.balance;
                    LOGGER.info(m);
                }
                else if(s == 4){
                    start = 0;
                }
            }catch(Exception e){
                String s = ""+e;
                LOGGER.info(s);
                sc.nextLine();
                LOGGER.info("_______________________________________________");
            }
        }while(start== 1);
    }
}