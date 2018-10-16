package com.example.zhiyong.food;


public class Food {
    private String name;
    private boolean spicy;
    private boolean seafood;
    private boolean sour;
    private int price;
    private int pic;

    public Food(String name, int price, int pic, boolean spicy, boolean seafood, boolean sour) {
        this.name = name;
        this.spicy = spicy;
        this.seafood = seafood;
        this.sour = sour;
        this.price = price;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public boolean isSeafood() {
        return seafood;
    }

    public void setSeafood(boolean seafood) {
        this.seafood = seafood;
    }

    public boolean isSour() {
        return sour;
    }

    public void setSour(boolean sour) {
        this.sour = sour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }


}
