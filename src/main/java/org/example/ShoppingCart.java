package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart {
    private ArrayList<Goods> contents;

    public ShoppingCart() {
        this.contents = new ArrayList<>();
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

    public double calculatePrice() {
        double price = 0;
        HashMap<Goods, Integer> totalContents = new HashMap<Goods, Integer>();
        for (Goods good : contents
             ) {
            totalContents.put(good, totalContents.getOrDefault(good, 0) + 1);
        }
        for (Goods good : totalContents.keySet()){
            Integer goodCount = totalContents.get(good);
            Double goodValue = good.price;
            price += goodCount * goodValue;
        }
        return price;
    }
}
