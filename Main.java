package com.company;
import java.io.*;
import java.util.*;

public class main {
    public static void main(String args[]) {
        ArrayList<String> items = new ArrayList<String>();
        items.add("Red-Hot Spicy Doritos");
        items.add("Cool Ranch Doritos");
        items.add("Coke");
        items.add("Pepsi");
        items.add("Diet Coke");
        items.add("5 Hour Energy");
        items.add("Mac Charger");
        items.add("Dell Charger");
        items.add("Sunflower Seeds");
        items.add("Peanuts");

        ArrayList<Double> itemsPrice = new ArrayList<Double>();
        itemsPrice.add(2.99);
        itemsPrice.add(2.99);
        itemsPrice.add(0.99);
        itemsPrice.add(0.99);
        itemsPrice.add(0.99);
        itemsPrice.add(3.99);
        itemsPrice.add(120.0);
        itemsPrice.add(50.0);
        itemsPrice.add(0.99);
        itemsPrice.add(0.99);

        ArrayList<String> custItem = new ArrayList<String>();
        ArrayList<Integer> custItemAmounts = new ArrayList<Integer>();
        String input;
        Scanner stringInput = new Scanner(System.in);

        String output = "";
        double total;
        double grandTotal = 0;
        System.out.print("\nEnter the name of the customer: ");
        while(!(input = stringInput.nextLine()).equalsIgnoreCase("no")){
            output += "\n" + input;
            total = 0; //assigning 0 for as initial for all customers
            System.out.println("Enter the name of items: (0 to exit at any time)");
            while(!(input = stringInput.nextLine()).equalsIgnoreCase("0")) {
                for(String i:items) {
                    if(i.contains(input) || i.equalsIgnoreCase(input)) {
                        total += itemsPrice.get(items.indexOf(i));
                        output += "\n\t"+input;
                        if(!custItem.contains(input)) {
                            custItem.add(input);
                            custItemAmounts.add(1);
                        }
                        else {
                            int index = custItem.indexOf(input);
                            custItemAmounts.set(index, custItemAmounts.get(index) + 1);
                        }
                        break;
                    }
                }
            }
            output += "\n\t\t"+total+"\n";
            grandTotal += total;
            System.out.print("\nEnter the name of the next customer (no to exit): ");
        }
        System.out.println("RECEIPT: \n"+output);
        System.out.println("\nInventory Sold: ");
        for(String i:custItem) {
            System.out.println("\t"+i+" ("+custItemAmounts.get(custItem.indexOf(i))+")");
        }
        System.out.println("\nGRAND TOTAL: "+grandTotal);
    }
}
