/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.library;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class Vector2d {
    private double x;
    private double y;
    
    public Vector2d(double newX, double newY) {
        x = newX;
        y = newY;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getTheta() {
        double theta = Math.toDegrees(Math.atan2(y, x));
	if ((theta < -360) || (theta > 360)) {
            theta = theta % 360;
	}
	if (theta < 0) {
            theta = 360 + theta;
	}
        return theta;
    }
    
    public Vector2d add(Vector2d v)
	{
		x += v.getX(); 
		y += v.getY();
		
		return this;
	}
    
    public Vector2d sub(Vector2d v)
	{
		x -= v.getX(); 
		y -= v.getY();
		
		return this;
	}
    
    public Vector2d multi(Vector2d v)
	{
		x *= v.getX(); 
		y *= v.getY();
		
		return this;
	}
    
    public Vector2d multi(int i)
	{
		x *= i; 
		y *= i;
		
		return this;
	}
}
