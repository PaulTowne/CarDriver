import java.awt.*;
import javax.swing.*;
import java.util.*;
public abstract class Entity
{  
    private double xpos;
    private double ypos;
    private double health;
    private double velocity;
    private ProjectileParent projectile;

    public Entity(double x, double y, double hea, double vel, ProjectileParent proj)
    {
        xpos = x;
        ypos = y;
        health = hea;
        velocity = vel;
        projectile = proj;
    }
    public abstract void draw(Graphics g);
    public abstract void move(double x, double y);
    public abstract double getX();
    public abstract double getY();
    public abstract double getHealth();
    public abstract double getVelocity();
    public abstract ProjectileParent getProjectile();
    public abstract void setX(double x);
    public abstract void setY(double y);
    public abstract void setHealth(double heal);
    public abstract void setVelocity(double vel);
    public abstract void setProjectile(ProjectileParent pro);

}