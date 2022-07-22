package com.company;

import java.util.Scanner;

public class Base_Burger {
    private String breadRoll;
    private String meat;
    private boolean additionals;
    private int tomatoes;
    private boolean lettuce;
    private int pickles;
    private boolean chips;
    private double basePrice;
    private double newPrice;

    public Base_Burger(String breadRoll, String meat) {
        this.breadRoll = breadRoll;
        this.meat = meat;
        this.basePrice = 8.99;
        this.additionals = false;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getBreadRoll() {
        return breadRoll;
    }

    public double additionals() {
        newPrice = getBasePrice();
        boolean add = false;
        Scanner bam = new Scanner(System.in);
        System.out.println("Would you like additionals?");
        if (bam.nextLine().equals("Y")) {
            additionals = true;
        } else {
            System.out.println("Total Price for Burger is $" + newPrice);
        }
        return Math.floor(newPrice);
    }

    public void add() {
        System.out.println("Enter P for pickles, T for tomatoes, C for chips and L for lettuce");
        Scanner scanner = new Scanner(System.in);
        String chosen = scanner.nextLine();
        if (chosen.equals("P")) {
            extraPickles();
        } else if (chosen.equals("T")) {
            extraTomatoes();
        } else if (chosen.equals("C")) {
            addChips();
        } else if (chosen.equals("L")) {
            addLettuce();
        } else {
            return;
        }
        System.out.println("Would you like more additionals? Y or N");
        if(scanner.nextLine().equals("Y")){
            add();
        }
    }



    public double extraPickles() {
        newPrice = getBasePrice();
        if (this.additionals) {
            System.out.println("Would you like some pickles?");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("Y")) {
                System.out.println("Enter how much you want: ");
                int amount = scanner.nextInt();
                this.pickles = amount;
                System.out.println("That will be $" + Math.round(amount * 1.20) + " extra");
                newPrice = getBasePrice() + Math.floor(amount * 1.20);
            } else {
                newPrice = getBasePrice();
            }
        }
        return newPrice;
    }

    public double extraTomatoes() {
        newPrice = getBasePrice();
        if (this.additionals) {
            System.out.println("Would you like some tomatoes? ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("Y")) {
                System.out.println("How many?");
                int amount = scanner.nextInt();
                this.tomatoes = amount;
                System.out.println("That will be $" + (amount * 1.10) + " extra");
                newPrice = getBasePrice() + Math.floor(amount * 1.10);

            }
        } else {
            newPrice = getBasePrice();
        }
        return newPrice;
    }

    public double addLettuce() {
        newPrice = getBasePrice();
        if (this.additionals) {
            System.out.println("Would you like some lettuce? Y or N.");
            this.lettuce = true;
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("Y")) {
                System.out.println("Regular is 1 and extra is 2");
                int amount = scanner.nextInt();
                System.out.println("That wille be $" + (amount * 1.10) + " extra");
                newPrice += (amount * 1.10);
            }
        }
        return newPrice;
    }

    public double addChips() {
        newPrice = getBasePrice();
        if (this.additionals) {
            System.out.println("Would you like some chips? Y or N.");
            this.chips = true;
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("Y")) {
                System.out.println("How many bags?");
                int amount = scanner.nextInt();
                System.out.println("That will be $" + (amount * 1.60) + " extra");
                newPrice += (amount * 1.60);
            }
        }
        return newPrice;
    }
    public void total(){
        System.out.println("Your total is $"+ Math.round(newPrice));
        System.out.println("This Burger consists of " + tomatoes + " tomatoes " + pickles + " pickles ");
        if(chips){
            System.out.println("with bag of chips");
        }
        if(lettuce){
            System.out.println("and extra lettuce");
        }
    }

}

