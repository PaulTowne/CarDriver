import java.awt.*;
import javax.swing.*;
import java.util.*;

public class basicObstacle extends ObstacleParent
{
    private double xpos;
    private double ypos;
    private int health;
    private int size;
    public basicObstacle(double xpos, double ypos, int health, int size)
    {
        super(xpos,ypos,health,size);
        this.xpos = xpos;
        this.ypos = ypos;
        this.health = health; 
        this.size = size;
    }
    public  double getX()
    {
        return xpos;
    }
    public  double getY()
    {
        return ypos;
    }
    public  void setX(int x)
    {
        xpos =x; 
    }
    public  void setY(int y)
    {
        ypos = y; 
    }
    public void addY(double y)
    {
        ypos = ypos + y;
    }
    public void addX(double x)
    {
        xpos = xpos + x;
    }
    public  void draw(Graphics g)
    {
        double distance = Math.sqrt(Math.pow(Math.abs(1000-(xpos+size)),2)+Math.pow(Math.abs(500-(ypos+size)),2))/5;
        //System.out.println(distance);
        distance = 255 - distance;
        if(distance<0)
            distance = 0;
        g.setColor(new Color(0,0,255,(int)distance));
        g.fillRect((int)xpos, (int)ypos, size, size);
    }
    public  void setHealth(int heal)
    {
        health = heal;
    }
    public  int getHealth()
    {
        return health;
    }
    public int getSize()
    {
        return size;
    }

}
