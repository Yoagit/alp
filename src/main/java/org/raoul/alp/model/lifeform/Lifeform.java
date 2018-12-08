package org.raoul.alp.model.lifeform;

import org.raoul.alp.model.Playground;
import org.raoul.alp.model.ressource.Food;
import org.raoul.alp.model.space.position.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Lifeform implements Runnable {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Lifeform.class);
    
    private int age, health;
    private Position<Position<?>> position;
    String name;

    public Lifeform(int health, Position<Position<?>> position, String name) {
        super();
        this.age = 0;
        this.health = health;
        this.position = position;
        this.name = name;
    }

    public Lifeform(int health, Position<Position<?>> position) {
        super();
        this.age = 0;
        this.health = health;
        this.position = position;
        this.name = this.getClass().getName();
    }

    public int getAge() {
        return age;
    }

    public int getHealth() {
        return health;
    }

    public Position<Position<?>> getPosition() {
        return position;
    }

    public String getName() {
        return this.name;
    }

    public abstract void lifeCycle();
    public abstract void mitosis();

    protected void older() {
        this.age++;
    }

    protected void decay() {
        this.health--;
    }

    protected void decay(int decayValue) {
        this.health-=decayValue;
    }

    protected void heal() {
        this.health=100;
    }

    protected boolean isFormAlive() {
        return this.health > 0;
    }
    
    protected boolean isHealNeeded(){
        return this.health < 40;
    }

    @Override
    public void run() {
        while(this.isFormAlive()){
            this.lifeCycle();
            if (this.getHealth() == 100){
                this.mitosis();
            }
            try {
                //LOGGER.info(String.format("Name: %s, Age: %s, Health: %s", this.getName(), this.age, this.health));
                Thread.sleep((long) 10);
            } catch (InterruptedException e) {
                LOGGER.error("Can't sleep");
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Playground.addRessource(new Food(this.position, 1));
        Playground.removeLifeform(this);
    }
}
