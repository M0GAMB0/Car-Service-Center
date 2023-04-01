import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


//Interface for diffent services to achieve abstraction
//Blueprint of services of Car Service
 interface Service{
    int basicService();
    int engineFixing();
    int clutchFixing();
    int brakeFixing();
    int gearFixing();
}
//Services charges for different models
class Hatchback implements Service{
    @Override
    public int basicService(){
        return 2000;
    }
    @Override
    public int engineFixing(){
        return 5000;
    }
    @Override
    public int clutchFixing(){
        return 2000;
    }
    @Override
    public int brakeFixing(){
        return 1000;
    }
    @Override
    public int gearFixing(){
        return 3000;
    }
}
class Sedan implements Service{
     @Override
    public int basicService(){
        return 4000;
    }
    @Override
    public int engineFixing(){
        return 8000;
    }
    @Override
    public int clutchFixing(){
        return 4000;
    }
    @Override
    public int brakeFixing(){
        return 1500;
    }
    @Override
    public int gearFixing(){
        return 6000;
    }
}
class Suv implements Service{
     @Override
    public int basicService(){
        return 5000;
    }
    @Override
    public int engineFixing(){
        return 10000;
    }
    @Override
    public int clutchFixing(){
        return 6000;
    }
    @Override
    public int brakeFixing(){
        return 2500;
    }
    @Override
    public int gearFixing(){
        return 8000;
    }
}
class CarService{
    Service carModel;
    private LinkedList<String> serviceCodes;
    private int total_bill=0; //for calculating total sum of bill

    CarService(String car,LinkedList<String> list){
        car.toLowerCase();
        //defining carModel
        if(car.equals("hatchback")){
            carModel=new Hatchback();
        }
        else if(car.equals("sedan")){
            carModel=new Sedan();
        }
        else if(car.equals("suv")){
            carModel=new Suv();
        }
        serviceCodes=list; //list of serviceCodes entered by customer
    }
    public void repair(){ 
        for(int i=0;i<serviceCodes.size();i++){
            String code=serviceCodes.get(i);
            //calculating bill and printing
            //a detailed bill with the total amount for each service request
            switch(code){
                case "BS01": total_bill+=carModel.basicService();
                             System.out.println("Charges for Basic Servicing - Rs. "+carModel.basicService());
                             break;
                case "EF01": total_bill+=carModel.engineFixing();
                             System.out.println("Charges for Engine Fixing - Rs. "+carModel.engineFixing());
                             break;
                case "CF01": total_bill+=carModel.clutchFixing();
                             System.out.println("Charges for Clutch Fixing - Rs. "+carModel.clutchFixing());
                             break;
                case "BF01": total_bill+=carModel.brakeFixing();
                             System.out.println("Charges for Brake Fixing - Rs. "+carModel.brakeFixing());
                             break;
                case "GF01": total_bill+=carModel.gearFixing();
                             System.out.println("Charges for Gear Fixing - Rs. "+carModel.gearFixing());
                             break;
            }
        }
        System.out.println("Total Bill - Rs. "+total_bill);
        //a complimentary cleaning specified in the bill
        if(total_bill>10000){
            System.out.println("As your service charge exceeded more than 10000 we also offered you Car cleaning");
        }
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println("**************************Car Service Center******************************");
            System.out.print("Enter Type Of Car - Hatchback, Sedan or SUV : ");
            String type=sc.next();
            type.toLowerCase();
            HashSet<String> models=new HashSet<>(); 
            models.add("hatchback");
            models.add("sedan");
            models.add("suv");
            while(!models.contains(type)){
                System.out.println("!!!!!!!Enter in below 3 types!!!!!");
                System.out.println("Hatchback, Sedan or SUV");
                System.out.print("Enter Type Of Car - Hatchback, Sedan or SUV : ");
                type=sc.next();
                type.toLowerCase();
            }
            System.out.println();
            System.out.println("********************Our Services********************");
            System.out.println("Basic Servicing : BS01");
            System.out.println("Engine Fixing : EF01");
            System.out.println("Clutch Fixing : CF01");
            System.out.println("Brake Fixing : BF01");
            System.out.println("Gear Fixing : GF01");
            LinkedList<String> serviceCodes = new LinkedList<>();
            System.out.print("Enter total number of Services you want : ");
            String s=sc.next();
            while(s.charAt(0)>'5' || s.charAt(0)<'1'){
                System.out.println("****We offer only 5 services****");
                System.out.println("Please Enter between 1 to 5");
                s=sc.next();
            }
            int n=Integer.parseInt(s);
            if(n==0){
                System.out.println();
                System.out.println("Thankyou ! Visit us Again...");
                    break;
            }
            System.out.println();
            HashSet<String> set=new HashSet<>();
            for(int i=1;i<=n;i++){
                System.out.print("Enter service code : ");
                String code=sc.next();
                code.toLowerCase();
                if((code.equals("BS01")||code.equals("EF01")|| code.equals("CF01")|| code.equals("BF01")||code.equals("GF01")) && !set.contains(code))
                {
                    serviceCodes.add(code);
                    set.add(code);
                }
                else if(set.contains(code)){
                    System.out.println();
                    System.out.println("!!!!!!!Code already Entered!!!!");
                    i--;
                }
                else{
                    System.out.println();
                    System.out.println("!!!!!!!Enter codes correctly!!!!");
                    System.out.println("For example - \"BS01\" for Basic Service");
                    i--;
                }
                System.out.println();
            }
            CarService cs=new CarService(type, serviceCodes);
            System.out.println("***************************Total Bill***************************");
            cs.repair();
            System.out.println("*********************************************************************************");
            boolean over=false;
            while(true){
                System.out.print("Want to exit (Y or N):");
                String res=sc.next();
                if(res.equals("Y") || res.equals("y")){
                    over=true;
                    System.out.println();
                    System.out.println("Thankyou ! Visit us Again...");
                    break;
                }
                else if(res.equals("N") || res.equals("n")){
                    break;
                }
                else{
                    System.out.println();
                    System.out.println("***Answer with Y for yes and N for no***");
                }
            }
            if(over)break;
        }
    }
}
