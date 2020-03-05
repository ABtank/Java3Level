package ru.abramov.lesson5.HomeWork5;


public class Car implements Runnable {
    private static int CARS_COUNT;


    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.cdl.countDown();
            MainClass.cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        MainClass.WIN.getAndAdd(1);
        if (MainClass.WIN.intValue()== 1) {
            System.out.println(name + " WIN");
        } else {
            System.out.println(name + " № " + MainClass.WIN);
        }
        if(MainClass.WIN.intValue()==MainClass.CARS_COUNT)MainClass.cdlend.countDown();
    }
}