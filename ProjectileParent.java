import java.awt.*;
import javax.swing.*;
import java.util.*;
public abstract class ProjectileParent 
{
    private double xpos;
    private double ypos; 
    private double velocity;
    private double direction;
    private double dmg; 
    private boolean alive;
    private int lifeTime;
    public ProjectileParent(double x, double y, double vel, double dir, double dm)
    {
        xpos=x;
        ypos=y;
        velocity=vel;
        direction=dir;
        dmg=dm;  
    }
    public abstract boolean getAlive();
    public abstract double getX();
    public abstract double getY();
    public abstract double getVelocity();
    public abstract double getDirection();
    public abstract double getDmg();
    public abstract void setAlive(boolean live);
    public abstract void setX(double x);
    public abstract void setY(double y);
    public abstract void setVelocity(double v);
    public abstract void setDirection(double d);
    public abstract void draw(Graphics g);
    public abstract void move(double x, double y,car c);
    public abstract void setObstacleParents(ArrayList<ObstacleParent> obj);
}
