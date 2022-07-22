package com.company;

import java.util.Scanner;

public class healthyBurger extends Base_Burger {
    private String breadRoll;
    private double BasePrice;
    private double newPrice;
    private boolean additionals;
    private int avocado;
    private int eggs;

    @Override
    public double getBasePrice() {
        return BasePrice;
    }

    public healthyBurger(String breadRoll, String meat) {
        super("brown rye", meat);
        BasePrice = 10.99;
    }
    @Override
    public double additionals() {
        newPrice = getBasePrice();
        boolean add = false;
        Scanner bam = new Scanner(System.in);
        System.out.println("Would you like additionals  on your healthy burger?");
        if (bam.nextLine().equals("Y")) {
            additionals = true;
        } else {
            System.out.println("Total Price for Burger is $" + newPrice);
        }
        return Math.floor(newPrice);
    }



    @Override
    public void add() {
        System.out.println("Enter P for pickles, T for tomatoes, C for chips, L for lettuce, A for avocado and E for eggs");
        Scanner scanner = new Scanner(System.in);
        String chosen = scanner.nextLine();
        switch (chosen) {
            case "P":
                extraPickles();
                break;
            case "T":
                extraTomatoes();
                break;
            case "C":
                addChips();
                break;
            case "L":
                addLettuce();
                break;
            case "A":
                addAvocado();
                break;
            case "E":
                addEggs();
                break;
        }
        System.out.println("Would you like more additionals? Y or N");
        if(scanner.nextLine().equals("Y")){
            add();
        }
    }
    public double addAvocado() {
        newPrice = getBasePrice();
        if (this.additionals) {
            System.out.println("Would you like some avocado?");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("Y")) {
                System.out.println("Enter how many slices do you want: ");
                int amount = scanner.nextInt();
                this.avocado = amount;
                System.out.println("That will be $" + Math.round(amount * 0.98) + " extra");
                newPrice = getBasePrice() + Math.floor(amount * 1.20);
            } else {
                newPrice = getBasePrice();
            }
        }
        return newPrice;
    }
    public double addEggs() {
        newPrice = getBasePrice();
        if (this.additionals) {
            System.out.println("Would you like some eggs?");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("Y")) {
                System.out.println("Enter how many eggs do you want: ");
                int amount = scanner.nextInt();
                this.eggs = amount;
                System.out.println("That will be $" + Math.round(amount * 0.89) + " extra");
                newPrice = getBasePrice() + Math.floor(amount * 0.89);
            } else {
                newPrice = getBasePrice();
            }
        }
        return newPrice;
    }
    @Override
    public void total(){
        System.out.println("Your total is $"+ newPrice);
        System.out.println("Burger order consists of: "+ avocado + " avocado, and " + eggs +" egg(s)" + "Thank you!!");
    }



}