package org.raoul.alp.model.space.position;

import org.raoul.alp.model.space.Space2D;

public class Position2D implements Position<Position2D> {
    private double x, y;
    private Space2D space;

    public Position2D(double x, double y, Space2D space) {
        super();
        this.x = x;
        this.y = y;
        this.space = space;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public double distanceTo(Position2D p) {
        double distx = this.x - p.getX();
        double disty = this.y - p.getY();
        return Math.sqrt(distx*distx + disty*disty);
    }

    @Override
    public void moveTo(Position2D p, double distance) {
        double distx = p.getX() - this.x;
        double disty = p.getY() - this.y;
        if (Math.sqrt(distx*distx + disty*disty) <= distance){
            this.x = p.getX();
            this.y = p.getY();
        } else {
            this.x = this.x + distx * (distance/Math.sqrt(distx*distx + disty*disty));
            this.y = this.y + disty * (distance/Math.sqrt(distx*distx + disty*disty));
        }
    }
    
    @Override
    public Position2D get2DPosition(){
        return this;
    }

    @Override
    public String toString() {
        return "Position2D [x=" + x + ", y=" + y + "]";
    }
    
    @Override
    public void randomMove(double distance){
        double angle = Math.random()*2*Math.PI;
        this.x = this.x + Math.cos(angle) * distance;
        this.y = this.y + Math.sin(angle) * distance;
        if (this.x < 0) this.x=0;
        if (this.x > space.getWidth()) this.x = this.space.getWidth();
        if (this.y < 0) this.y=0;
        if (this.y > space.getHeight()) this.y = this.space.getHeight();
    }
    
    @Override
    public Position2D duplicate(){
        return new Position2D(this.x, this.y, this.space);
    }

}
