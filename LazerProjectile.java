import java.awt.*;
import javax.swing.*;
import java.util.*;
public class LazerProjectile extends ProjectileParent 
{
    private double xpos;
    private double ypos; 
    private double velocity;
    private double direction;
    private double dmg; 
    private boolean alive = true;
    Collision collide;
    private int lifeTime =1000;
    private int opac=0;
    private ArrayList<ObstacleParent> obstacleArray;
    public LazerProjectile(double x, double y, double vel, double dir, double dm)
    {
        super(x,y,vel,dir,dm);
        xpos=x;
        ypos=y;
        velocity=vel;
        direction=dir;
        dmg=dm;  
        collide = new Collision();
        lifeTime = lifeTime- ((int)velocity*40);
        if(lifeTime<200)
            lifeTime = 200;
    }
    public void draw(Graphics g)
    {
        double x2 = 20*Math.cos(Math.toRadians(direction+180))+xpos;
        double y2 = 20*Math.sin(Math.toRadians(direction+180))+ypos;
        if(lifeTime>255)
            opac = 255;
        else
            opac = lifeTime;
        g.setColor(new Color(255,0,0,opac));
        g.drawLine((int)xpos,(int)ypos,(int)x2,(int)y2);
    }
    public void move(double xCarMove, double yCarMove, car c) // make proj collide with obstacles
    {
        lifeTime = lifeTime-1;
        //System.out.println(lifeTime);
        //System.out.println("projectile move");
        //System.out.println("In proj: Car x and y ="+c.getX()+" "+c.getY());
        boolean boom = false;
        double moveX;
        double moveY;
        xpos = xpos-xCarMove;
        ypos = ypos-yCarMove; 
        for(int i=0;i<velocity;i++)
        {
            moveX = Math.cos(Math.toRadians(direction));
            moveY = Math.sin(Math.toRadians(direction));
            for(int k=0;k<obstacleArray.size();k++)
            {
                if(collide.collide(xpos,ypos,obstacleArray.get(k).getX(),obstacleArray.get(k).getY(),obstacleArray.get(k).getSize()))
                {
                    alive = false;
                }
            }
            if(!collide.collide(direction, xpos,ypos) && alive == true)
            {
                        xpos = xpos+ moveX;
                        ypos = ypos+ moveY;
            }
            else{
                // delete object from list
                // call some "death" actiavation. for graphics and structure
                alive = false;
            }

            // call collides here and in the previous part
            // wait since we are making it "move" multiple times in a single tick. we can just take the whole distance it would have traveled and test for collision
            // so test a line from the the beginning of the loop and the end. and test for collision. 
        }
        if(lifeTime <=0)
            alive = false;
        

    }
    public boolean getAlive()
    {
        return alive;
    }
    public double getX()
    {
        return xpos;
    }
    public double getY()
    {
        return ypos;
    }
    public double getVelocity()
    {
        return velocity;
    }
    public double getDirection()
    {
        return direction;
    }
    public double getDmg()
    {
        return dmg;
    }
    public void setObstacleParents(ArrayList<ObstacleParent> obj)
    {
        obstacleArray = obj;
    }
    public void setAlive(boolean live)
    {
        alive = live;
    }
    public void setX(double x)
    {
        xpos = xpos+x;
    }
    public void setY(double y)
    {
        ypos = ypos+y;
    }
    public void setVelocity(double v)
    {
        velocity = velocity+v;
    }
    public void setDirection(double d)
    {
        direction = direction+d;
    }
}
