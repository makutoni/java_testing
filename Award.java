package com.epam;

public class Award {

    private final int value;

    private float soli;

    public Award(int value) {
        this.value = value;

        System.out.println("Award has value = " + this.value);
    }

    public Award(int value, float soli) {
        this.value = value;
        this.soli = soli;

        System.out.println("Award has value = " + this.value+" and soli = "+this.soli);
    }

    public int getValue() {
        return value;
    }

    public float getSoli() {
        return soli;
    }

    public void setSoli(float soli) {
        this.soli = soli;
    }

}