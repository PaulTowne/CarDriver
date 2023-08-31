import java.awt.*;
import javax.swing.*;
import java.util.*;
public class PoliceCar extends Entity
{  
    private double xpos;
    private double ypos;
    private double health;
    private double velocity;
    private ProjectileParent projectile;
    Image c1;

    public PoliceCar(double x, double y, double hea, double vel, ProjectileParent proj)
    {
        super(x,y,hea,vel,proj);
        xpos = x;
        ypos = y;
        health = hea;
        velocity = vel;
        projectile = proj;
        Toolkit tool = Toolkit.getDefaultToolkit();
        // 24 pixels wide || 44 pixel long
        c1 = tool.getImage("PixelCar.png");
    }
    public void move(double x, double y)
    {
        xpos = xpos-x;
        ypos = ypos-y;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.ORANGE);
        g.drawOval((int)(xpos-10),(int)(ypos-10),20,20);
        g.drawImage(c1, 50, 50, null, null);

    }
    public double getX()
    {
        return xpos;
    }
    public double getY()
    {
        return ypos;
    }
    public double getHealth()
    {
        return health;
    }
    public double getVelocity()
    {
        return velocity;
    }
    public ProjectileParent getProjectile()
    {
        return projectile;
    }
    public void setX(double x)
    {
        xpos = xpos+x;
    }
    public void setY(double y)
    {
        ypos = ypos+y;
    }
    public void setHealth(double heal)
    {
        health = health + heal;
    }
    public void setVelocity(double vel)
    {
        velocity = velocity + vel;
    }
    public void setProjectile(ProjectileParent pro)
    {
        projectile = pro;
    }

}
