package org.example;

import java.util.ArrayList;

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
}
