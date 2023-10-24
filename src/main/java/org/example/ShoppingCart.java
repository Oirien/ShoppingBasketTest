package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ShoppingCart {
    private ArrayList<Goods> contents;
    private HashSet<Goods> twoForOneSet;

    public ShoppingCart() {
        this.contents = new ArrayList<>();
        this.twoForOneSet = new HashSet<>();
    }

    public HashSet<Goods> getTwoForOneSet() {
        return twoForOneSet;
    }

    public void setTwoForOneSet(HashSet<Goods> twoForOneSet) {
        this.twoForOneSet = twoForOneSet;
    }

    public void addTwoForOneSet(Goods good){
        this.twoForOneSet.add(good);
    }

    public ArrayList<Goods> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Goods> contents) {
        this.contents = contents;
    }

    public void addGood(Goods good){
        this.contents.add(good);
    }

    public void removeGood(Goods good) {
        this.contents.remove(good);
    }

    public void emptyContents() {
        this.contents.clear();
    }

    public double calculatePrice(Boolean loyaltyCard) {
        double price = 0;
        HashMap<Goods, Integer> totalContents = new HashMap<Goods, Integer>();
        for (Goods good : contents
             ) {
            totalContents.put(good, totalContents.getOrDefault(good, 0) + 1);
        }
        for (Goods good : totalContents.keySet()){
            if (twoForOneSet.contains(good)){
                Integer twoForOne = (int) Math.ceil(totalContents.get(good)/2);
                totalContents.replace(good, twoForOne);
            }
            Integer goodCount = totalContents.get(good);
            Double goodValue = good.price;
            price += goodCount * goodValue;
        }
        if (price > 20.00){
            price = price * 0.90;
        }
        if (loyaltyCard == true){
            price = price * 0.98;
        }
        double roundedPrice = Math.round(price * 100.0)/100.0;
        return roundedPrice;
    }
}
