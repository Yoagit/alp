package org.raoul.alp.model;

import java.util.HashSet;
import java.util.Set;

import org.raoul.alp.model.lifeform.Lifeform;
import org.raoul.alp.model.ressource.Ressource;

public class Playground {
    static Set<Ressource> onGround = new HashSet<>();
    static Set<Lifeform> alive = new HashSet<>();

    public static Set<Ressource> getOnGround() {
        return onGround;
    }

    public static Set<Lifeform> getAlive() {
        return alive;
    }
    
    public static void start(){
        for(Lifeform lf : alive){
            Thread thrd = new Thread(lf);
            thrd.start();
        }
    }
    
    public static void removeRessource(Ressource res){
        onGround.remove(res);
    }
    public static void addRessource(Ressource res){
        onGround.add(res);
    }
    public static void removeLifeform(Lifeform life){
        alive.remove(life);
    }
    public static void addLifeform(Lifeform life){
        alive.add(life);
        Thread thrd = new Thread(life);
        thrd.start();
    }
}
