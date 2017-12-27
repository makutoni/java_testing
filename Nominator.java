package com.epam;

public class Nominator {
    private String name;

    public Nominator(String name) {
        this.name = name;
        System.out.println("Nominator has name = " + this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void nominate(Nominee nominee, Award award) {
        nominee.receiveAward(award);
        System.out.println("The Nominator "+this.name+ " awards the nominee "+nominee.getName() + " with a bonus "+award.getValue());
    }

    public static void main(String[] args) {
        Nominator nominator = new Nominator("Alex Lukashenko");
        //list of employees
        Nominee[] nominee = {new Nominee("Bill Clinton"), new Nominee("Peter the First"), new Nominee("Margaret Thatcher")};
        //list of awards
        Award[] awards = new Award[12];
        for (int i=0;i<12;i++) {
            int summa = 50 + (int) (Math.random()*50000.0);
            awards[i] = new Award(summa,i % 3);
        }
        //rewarding
        int current = 0;
        for (int i=0;i<12;i++) {
            nominator.nominate(nominee[current], awards[i]);
            if (i % 4 == 3) {
                current++;
            }
        }
        //calculation of amount of awards with Soli=0
        int population = 0;
        for (int i=0;i<12;i++) {
            if (awards[i].getSoli()==0.0) {
                population = population+1;
            }
        }
        System.out.println("Population = "+population);
        //calculation of quantities
        double[] quantity = new double[population];
        int indx = 0;
        for (int i=0;i<12;i++) {
            double C = Math.random();
            int Z = 3 + (int)(Math.random()*3);
            if (awards[i].getSoli()==0.0) {
                double xx = (Z*Z*(awards[i].getValue())*(1-awards[i].getValue())/C*C);
                double yy = (1 + ((((Z*Z*awards[i].getValue()*(1-awards[i].getValue()))/(C*C))-1)/population));
                quantity[indx] = xx/yy;
                System.out.println("Quantity = "+quantity[indx]);
                indx++;
            }
        }
        //comparison
        if (quantity[0]>quantity[1]) {
            System.out.println("quantity of Bill Clinton's award1 is greater than quantity of Bill Clinton's award3");
        } else if (quantity[0]==quantity[1]) {
            System.out.println("quantity of Bill Clinton's award1 is equal the quantity of Bill Clinton's award3");
        } else {
            System.out.println("quantity of Bill Clinton's award1 is less the quantity of Bill Clinton's award3");
        }

        if (quantity[2]>=quantity[3]) {
            System.out.println("quantity of Peter the First award1 is greater or equal the quantity of Peter the First award3");
        } else {
            System.out.println("quantity of Peter the First award1 is less the quantity of Peter the First award3");
        }

        if (quantity[4]!=quantity[5]) {
            System.out.println("quantity of Margaret Thatcher's award1 is not equal the quantity of Margaret Thatcher's award3");
        } else {
            System.out.println("quantity of Margaret Thatcher's award1 is equal the quantity of Margaret Thatcher's award3");
        }

    }
}
