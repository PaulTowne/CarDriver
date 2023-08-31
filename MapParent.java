import java.awt.*;
import javax.swing.*;
import java.util.*;

public abstract class MapParent 
{
    private double xpos;
    private double ypos;
    private int variation;
    private ArrayList<ObstacleParent> obj;
    public MapParent(double xpos, double ypos, int variation)
    {
        this.xpos = xpos;
        this.ypos = ypos;
        this.variation = variation;
    }
    public abstract double getX(); // these are what the object positions are dependent on. 
    public abstract double getY();// these are what changes when the car moves.
    public abstract void changeX(double x);
    public abstract void changeY(double y);
    public abstract int getVariation(); // which version of a type of panel will be like
    public abstract void draw(Graphics g); 
    public abstract ArrayList<ObstacleParent> getObs(); // gets the objects. 

}
