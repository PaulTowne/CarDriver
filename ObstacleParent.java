import java.awt.*;
import javax.swing.*;
import java.util.*;

public abstract class ObstacleParent 
{
    private double xpos;
    private double ypos;
    private int health;
    private int size;

    public ObstacleParent(double xpos, double ypos, int health, int size)
    {
        this.xpos = xpos;
        this.ypos = ypos;
        this.health = health; 
        this.size = size;
    }
    public abstract double getX();
    public abstract double getY();
    public abstract int getSize();
    public abstract void setX(int x);
    public abstract void setY(int y);
    public abstract void addX(double x);
    public abstract void addY(double y);
    public abstract void draw(Graphics g);
    public abstract void setHealth(int heal);
    public abstract int getHealth();
}
