package org.raoul.alp.model.space.position;

import org.raoul.alp.model.space.Space2D;

public class Position2DOriented extends Position2D implements PositionOriented<Position2D> {

    double angle;

    public Position2DOriented(double x, double y, Space2D space) {
        super(x, y, space);
        this.angle = Math.random() * Math.PI * 2;
    }

    public Position2DOriented(double x, double y, Space2D space, double angle) {
        super(x, y, space);
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    @Override
    public double anglevariation(Position2D position) {
        double result = 0;
        double varX = position.getX() - this.getX();
        double varY = position.getY() - this.getY();
        if (varX != 0) {
            result = Math.atan(varY / varX);
            if ((varX < 0) && (varY > 0)) {
                result = Math.PI + result;
            }
            if ((varX < 0) && (varY < 0)) {
                result = result - Math.PI;
            }
        } else {
            result = Math.PI / 2 * Math.signum(varY);
        }
        result = result - this.angle;
        return result;
    }

    @Override
    public void randomMove(double distance){
        this.angle += (Math.random()-0.5)/10;
        this.angle = this.move(distance, this.angle);
    }
    
    @Override
    public Position2DOriented duplicate(){
        return new Position2DOriented(this.getX(), this.getY(), this.getSpace());
    }
}
