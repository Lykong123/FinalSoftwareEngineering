import java.util.ArrayList;
import java.util.Scanner;

public class PlantingShop {
    ArrayList<Plants> plants = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    //method for menu
    public void menu(){
        System.out.println("----------Planting Shop---------");
        System.out.println("1: Add plants and show plants name");
        System.out.println("2: Calculate total price and display");
        System.out.println("4: Exit the program");
        System.out.println("---------------------------------");
    }

    //method to add show plants
    public void addAndShowPlants(){
        ArrayList<String> flower = new ArrayList<>();
        flower.add("Sunflower");
        flower.add("Rose");
        flower.add("Apple");
        flower.add("Daisy");
        flower.add("Blueberry");
        flower.add("Mango");
        flower.add("Banana");
        ArrayList<String> type = new ArrayList<>();
        type.add("small");
        type.add("medium");
        type.add("large");
        System.out.println("List plants in the shop: ");
        for(int i=0; i<5; i++){
            System.out.println(flower.get(i).toString());
        }
        System.out.println("Type of plants are: ");
        for(int i=0; i<3; i++){
            System.out.println(type.get(i).toString());
        }
        Plants p = new Plants(flower, type);
        plants.add(p);
    }

    //method to calculate and show total price
    public  void calculatePrice(){
        ArrayList<String> flowers = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        System.out.println("How many plants do you want to buy? ");
        int num = Integer.parseInt(sc.nextLine());
        double sum = 0;
        System.out.print("Input index: ");
        int index= Integer.parseInt(sc.nextLine());
        Plants plants = checkFlowerByName(index);
        if(plants!=null){
            for (int i=0; i<num ;i++){
                System.out.print("Input plant name: ");
                String flower = sc.nextLine();
                System.out.print("Input price: ");
                double price = Double.parseDouble(sc.nextLine());
                sum = sum+price;
                flowers.add(flower);
                prices.add(price);
            }
            System.out.println("Display total price before discount: "+sum);

            if((sum >50 && sum < 100)){
                double finalPrice = sum - sum * 0.05;
                System.out.println("Price after discount is: "+finalPrice);
            }
            else if((sum >= 100 && sum<200)){
                double finalPrice = sum - sum*0.1;
                System.out.println("Price after discount is: "+finalPrice);
            }else if((sum >=200)){
                double finalPrice = sum -sum*0.15;
                System.out.println("Price after discount is: "+finalPrice);
            }else{
                System.out.println("No discount for customer who spend less than 50$");
            }
        }else{
            System.out.println("Not exit in the shop");
        }
    }

    //method to verify if the flower in the shop or not
    public Plants checkFlowerByName(int i){
        int j=0;
        for (Plants p: plants) {
            if(i==j){
                return p;
            }
        }
        return  null;
    }

    public static void main(String[] args){
        PlantingShop plantingShop = new PlantingShop();
        Scanner sc = new Scanner(System.in);
        plantingShop.menu();
        Plants p = new Plants();
        int opt;
        do{
            System.out.print("Input your option: ");
            opt = Integer.parseInt(sc.nextLine());
            switch (opt){
                case 1:
                    plantingShop.addAndShowPlants();
                    break;
                case 2:
                    plantingShop.calculatePrice();
                    break;
                 default:
                     System.out.println("Exit the program");
                     System.exit(0);
            }
        }while (opt!=0);
    }
}

class Plants{
    ArrayList<String> flower = new ArrayList<>();
    ArrayList<String> type = new ArrayList<>();
    double price;
    double discount;
    double finalPrice;

    public  Plants(){

    }
    public Plants(ArrayList<String> type, ArrayList<String> flower){
        this.type = type;
        this.flower = flower;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
       this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public ArrayList<String> getFlower() {
        return flower;
    }

    public void setFlower(ArrayList<String> flower) {
        this.flower = flower;
    }
}
