package bigcode232_es.cofferun;

public class ProccessOrder {
    private static int price = 0;
    private static int amount = 0;

    public static int getPrice() {
        return price;
    }

    public static int getAmount() {
        return amount;
    }


    public static void addCoffees(int num, int coffeePrice){
        amount += num;
        price += (num * coffeePrice);
    }

    public static void submitOrder(){
        //Submit an order
    }

    public static void clearData(){
        price = 0;
        amount = 0;
    }
}
