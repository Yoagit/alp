package org.raoul.alp.model;

import java.util.HashSet;
import java.util.Set;

import org.raoul.alp.model.lifeform.Lifeform;
import org.raoul.alp.model.ressource.Ressource;
import org.raoul.alp.model.space.Space;
import org.raoul.alp.model.space.position.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Playground {

    private static final Logger LOGGER = LoggerFactory.getLogger(Playground.class);

    static private Set<Ressource> onGround = new HashSet<>();
    static private Set<Lifeform> alive = new HashSet<>();
    static private Space SPACE;
    
    public static void setSpace(Space space){
        SPACE = space;
    }
    
    public static Space getSpace(){
        return SPACE;
    }
    
    public static Position getRandomPosition(){
        return SPACE.getRandomPosition();
    }
    public static Position getRandomOrientedPosition(){
        return SPACE.getRandomOrientedPosition();
    }

    public static Set<Ressource> getOnGround() {
        synchronized (onGround) {
            return new HashSet<>(onGround);
        }
    }

    public static Set<Lifeform> getAlive() {
        synchronized (alive) {
            return new HashSet<>(alive);
        }
    }

    public static void removeRessource(Ressource res) {
        synchronized (onGround) {
            LOGGER.debug("removeRessource start: " + onGround.size());
            onGround.remove(res);
            LOGGER.debug("removeRessource done-: " + onGround.size());
        }
    }

    public static void addRessource(Ressource res) {
        synchronized (onGround) {
            LOGGER.debug("addRessource start: " + onGround.size());
            onGround.add(res);
            LOGGER.debug("addRessource done-: " + onGround.size());
        }
    }

    public static void removeLifeform(Lifeform life) {
        synchronized (alive) {
            LOGGER.debug("removeLifeform start: " + alive.size());
            alive.remove(life);
            LOGGER.debug("removeLifeform done-: " + alive.size());
        }
    }

    public static void addLifeform(Lifeform life) {
        synchronized (alive) {
            LOGGER.debug("addLifeform start: " + alive.size());
            alive.add(life);
            LOGGER.debug("addLifeform done-: " + alive.size());
        }
        Thread thrd = new Thread(life);
        thrd.start();
    }
}
