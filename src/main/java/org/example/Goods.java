package org.example;

public enum Goods {
    CHEESE("cheese", 3.25),
    HAM("ham", 2.50),
    BREAD("bread", 1.25),
    MUSTARD("mustard", 1.75),
    POTATO("potato", .65);

    String goodName;
    Double price;

    Goods(String goodName, Double price){
        this.goodName = goodName;
        this.price = price;
    }
}
