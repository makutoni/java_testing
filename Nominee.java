package com.epam;

public class Nominee {
    private String name;

    public Nominee(String name) {
        this.name = name;
        System.out.println("Nominee has name = " + this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void receiveAward(Award award) {
        if (award.getSoli() == 0) {
            System.out.println("Nominee "+this.name+ " has received award witout correction:"+award.getValue());
        } else {
            float amoumnt = award.getSoli() * award.getValue();
            float loss = (award.getValue() - amoumnt) * 100 / award.getValue();
            System.out.println(loss + " receive in percentage ");
            System.out.println("Nominee "+this.name+ " has received award with correction:"+amoumnt);
        }
    }
}
