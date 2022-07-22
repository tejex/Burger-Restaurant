package com.company;

public class deluxeBurger extends Base_Burger {
    private String breadRoll;
    private String meat;
    private double BasePrice;
    private double newPrice;
    private int chips;
    private String drink;

    public deluxeBurger(String breadRoll, String meat) {
        super(breadRoll, meat);
        this.BasePrice =11.29;
        this.meat = meat;
        this.breadRoll = breadRoll;
        this.chips = 1;
        this.drink = "Coca-Cola";
        this.newPrice = BasePrice;
    }

    @Override
    public double getBasePrice() {
        return BasePrice;
    }

    @Override
    public void total(){
        System.out.println("The toal for this burger is: " + newPrice);
        System.out.println("Order consists of: "+ chips + " bag of chips, a can of "+drink+" and extra meat." );
    }



}
