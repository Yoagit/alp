package org.raoul.alp.model.position;

public class Position2D implements Position<Position2D> {
    private double x, y;

    public Position2D(double x, double y) {
        super();
        this.x = x;
        this.y = y;
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
    }

}
