import java.util.Scanner;
//Abstract class for DispenseChain
abstract class DispenseChain{
    protected DispenseChain nextChain;
    public void setNextChain(DispenseChain nextChain){
        this.nextChain=nextChain;
    }
    public abstract void dispense(int amount);
}

//For 1000 Tk Notes
class Tk1000 extends DispenseChain{
    private int noteStock;
    public Tk1000(int noteStock){
        this.noteStock=noteStock;
    }

    public void dispense(int amount){
        if(amount>=1000 && this.noteStock>0){
            int needNote=amount/1000;
            int dispenseNote=Math.min(needNote,this.noteStock);
            this.noteStock-=dispenseNote;
            int dispenseAmount=dispenseNote*1000;
            int remainder=amount-dispenseAmount;
            System.out.println("Dispensing "+dispenseNote+" notes of 1000 Tk.(Remaining Stock: "+this.noteStock+")");
            if(remainder>0 && this.nextChain!=null){
                this.nextChain.dispense(remainder);
            }
        }
        else if(this.nextChain!=null){
            this.nextChain.dispense(amount);
        }
        else{
            System.out.println("Error : Cannot dispense the remaining "+amount+" Tk.");
        }
    }
}

//For 500 Tk Notes
class Tk500 extends DispenseChain{
    private int noteStock;
    public Tk500(int noteStock){
        this.noteStock=noteStock;
    }

    public void dispense(int amount){
        if(amount>=500 && this.noteStock>0){
            int needNote=amount/500;
            int dispenseNote=Math.min(needNote,this.noteStock);
            this.noteStock-=dispenseNote;
            int dispenseAmount=dispenseNote*500;
            int remainder=amount-dispenseAmount;
            System.out.println("Dispensing "+dispenseNote+" notes of 500 Tk.(Remaining Stock: "+this.noteStock+")");
            if(remainder>0 && this.nextChain!=null){
                this.nextChain.dispense(remainder);
            }
        }
        else if(this.nextChain!=null){
            this.nextChain.dispense(amount);
        }
        else{
            System.out.println("Error : Cannot dispense the remaining "+amount+" Tk.");
        }
    }
}

//For 200 Tk Notes
class Tk200 extends DispenseChain{
    private int noteStock;
    public Tk200(int noteStock){
        this.noteStock=noteStock;
    }

    public void dispense(int amount){
        if(amount>=200 && this.noteStock>0){
            int needNote=amount/200;
            int dispenseNote=Math.min(needNote,this.noteStock);
            this.noteStock-=dispenseNote;
            int dispenseAmount=dispenseNote*200;
            int remainder=amount-dispenseAmount;
            System.out.println("Dispensing "+dispenseNote+" notes of 200 Tk.(Remaining Stock: "+this.noteStock+")");
            if(remainder>0 && this.nextChain!=null){
                this.nextChain.dispense(remainder);
            }
        }
        else if(this.nextChain!=null){
            this.nextChain.dispense(amount);
        }
        else{
            System.out.println("Error : Cannot dispense the remaining "+amount+" Tk.");
        }
    }
}

//For 100 Tk Notes
class Tk100 extends DispenseChain{
    private int noteStock;
    public Tk100(int noteStock){
        this.noteStock=noteStock;
    }

    public void dispense(int amount){
        if(amount>=100 && this.noteStock>0){
            int needNote=amount/100;
            int dispenseNote=Math.min(needNote,this.noteStock);
            this.noteStock-=dispenseNote;
            int dispenseAmount=dispenseNote*100;
            int remainder=amount-dispenseAmount;
            System.out.println("Dispensing "+dispenseNote+" notes of 100 Tk.(Remaining Stock: "+this.noteStock+")");
            if(remainder>0){
                System.out.println("Error : Machine ran out of cash! Remaining "+remainder+" Tk cannot be dispensed.");
            }
        }
        else{
            System.out.println("Error : Machine ran out of 100 Tk notes or amount is too small. Remaining "+amount+" Tk.");
        }
    }
}
//This the Main class
public class CoR{
    private DispenseChain c1;
    public CoR(){
        //Set every note stock by using constructor
        this.c1=new Tk1000(100);
        DispenseChain c2=new Tk500(50);
        DispenseChain c3=new Tk200(20);
        DispenseChain c4=new Tk100(10);
        
        //Connect to the Chain
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
    }
    public static void main(String[] args) {
        CoR atm=new CoR();
        
        Scanner sc=new Scanner(System.in);
        //Take the withdraw amount from the user
        System.out.print("Enter your withdraw amount : ");
        int withdrawAmount=sc.nextInt();
        System.out.println("Withdrawing : "+withdrawAmount+" Tk.");
        if(withdrawAmount%100!=0){
            System.out.println("Error : Amount should be in multiples of 100.");
            return;
        }
        atm.c1.dispense(withdrawAmount);
    }
}