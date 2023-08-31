import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Collision 
{
    int carX;
    int carY;
    int targetX;
    int targetY;
    ArrayList<Point> point = new ArrayList<Point>();


    public Collision()
    {

    }
    public ArrayList<Point> getArray()
    {
        return point;
    }
    // this is for projectiles and checking if they collide with any objects
    public boolean collide()
    {


        return false;
    }
    // between projectile and objects
    public boolean collide(double xpoint, double ypoint, double targetx, double targety, int size)
    {
        if((xpoint >targetx) && (xpoint < (targetx +size)) && (ypoint > targety) && (ypoint <(targety+size)))
            {
                //point.add(new Point((int)frontX,(int)frontY));
                //System.out.println("collided");
                return true;
            }
        //System.out.println("not collide");
        return false;
    }
    // this is for projectiles and checking if they collide with the car
    public boolean collide(double face, double projx, double projy)
    {
        //System.out.println("in collide: for proj");
        //PointDouble point1 = new PointDouble((15*Math.cos(Math.toRadians(face))),(15*Math.sin(Math.toRadians(face))));
        //PointDouble point2 = new PointDouble((15*Math.cos(Math.toRadians(face+180))),(15*Math.sin(Math.toRadians(face+180))));

        //double distanceP1 = Math.sqrt(Math.pow((point1.getX()-projx),2) + Math.pow((point1.getY()-projy),2));
        //double distanceP2 = Math.sqrt(Math.pow((point2.getX()-projx),2) + Math.pow((point2.getY()-projy),2));
        //if(distanceP1<30 || distanceP2<30)
        //if(projx>1050 && projx >950 && projy>450 && projy<550)
        if(Math.abs(projx-1000)<10 && Math.abs(projy-500)<10)
        {
            
                // System.out.println("In collide: Boom");
                return true;
            
        }

        return false;
    }
    // between car and unmoveable square obstacles 
    public boolean collide(double carX, double carY, double face, double targetX, double targetY, int size)
    {
        
        double frontX;
        double frontY;
        // front 
        for(int i=0;i<30;i++)
        {
             frontX = 21*Math.cos(Math.toRadians(face-i))+carX;
             frontY = 21*Math.sin(Math.toRadians(face-i))+carY;
            if((frontX >targetX) && (frontX < (targetX +size)) && (frontY > targetY) && (frontY <(targetY+size)))
            {
                //point.add(new Point((int)frontX,(int)frontY));
                return true;
            }
        }
        for(int i=330;i<360;i++)
        {
             frontX = 21*Math.cos(Math.toRadians(face-i))+carX;
             frontY = 21*Math.sin(Math.toRadians(face-i))+carY;
            if((frontX >targetX) && (frontX < (targetX +size)) && (frontY > targetY) && (frontY <(targetY+size)))
            {
                //point.add(new Point((int)frontX,(int)frontY));
                return true;
            }
        }
        // front sides 
        for(int i=30;i<60;i++)
        {
             frontX = 15*Math.cos(Math.toRadians(face-i))+carX;
             frontY = 15*Math.sin(Math.toRadians(face-i))+carY;
            if((frontX >targetX) && (frontX < (targetX +size)) && (frontY > targetY) && (frontY <(targetY+size)))
            {
                //point.add(new Point((int)frontX,(int)frontY));
                return true;
            }
        }
        for(int i=300;i<330;i++)
        {
             frontX = 15*Math.cos(Math.toRadians(face-i))+carX;
             frontY = 15*Math.sin(Math.toRadians(face-i))+carY;
            if((frontX >targetX) && (frontX < (targetX +size)) && (frontY > targetY) && (frontY <(targetY+size)))
            {
                //point.add(new Point((int)frontX,(int)frontY));
                return true;
            }
        }
        // sides
        for(int i=60;i<120;i++)
        {
             frontX = 12*Math.cos(Math.toRadians(face-i))+carX;
             frontY = 12*Math.sin(Math.toRadians(face-i))+carY;
            if((frontX >targetX) && (frontX < (targetX +size)) && (frontY > targetY) && (frontY <(targetY+size)))
            {
                //point.add(new Point((int)frontX,(int)frontY));
                return true;
            }
        }
        for(int i=240;i<300;i++)
        {
             frontX = 12*Math.cos(Math.toRadians(face-i))+carX;
             frontY = 12*Math.sin(Math.toRadians(face-i))+carY;
            if((frontX >targetX) && (frontX < (targetX +size)) && (frontY > targetY) && (frontY <(targetY+size)))
            {
                //point.add(new Point((int)frontX,(int)frontY));
                return true;
            }
        }
        // back sides
        for(int i=120;i<150;i++)
        {
             frontX = 15*Math.cos(Math.toRadians(face-i))+carX;
             frontY = 15*Math.sin(Math.toRadians(face-i))+carY;
            if((frontX >targetX) && (frontX < (targetX +size)) && (frontY > targetY) && (frontY <(targetY+size)))
            {
                //point.add(new Point((int)frontX,(int)frontY));
                return true;
            }
        }
        for(int i=210;i<240;i++)
        {
             frontX = 15*Math.cos(Math.toRadians(face-i))+carX;
             frontY = 15*Math.sin(Math.toRadians(face-i))+carY;
            if((frontX >targetX) && (frontX < (targetX +size)) && (frontY > targetY) && (frontY <(targetY+size)))
            {
                //point.add(new Point((int)frontX,(int)frontY));
                return true;
            }
        }
        //back
        for(int i=150;i<210;i++)
        {
             frontX = 20*Math.cos(Math.toRadians(face-i))+carX;
             frontY = 20*Math.sin(Math.toRadians(face-i))+carY;
            if((frontX >targetX) && (frontX < (targetX +size)) && (frontY > targetY) && (frontY <(targetY+size)))
            {
                //point.add(new Point((int)frontX,(int)frontY));
                return true;
            }
        }
         

        return false;

    }
}
