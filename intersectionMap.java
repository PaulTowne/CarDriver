import java.awt.*;
import javax.swing.*;
import java.util.*;

public class intersectionMap extends MapParent
{
    private double xpos;
    private double ypos;
    private int variation;
    private ArrayList<ObstacleParent> obj;
    Image im;
    void change(int var) // will make the graphics etc 
    {

    }

    public intersectionMap(double xpos, double ypos, int variation)
    {
        super(xpos,ypos,variation);
        this.xpos = xpos;
        this.ypos = ypos;
        this.variation = variation;
        change(variation);
        Toolkit tool = Toolkit.getDefaultToolkit();
         im = tool.getImage("intersection.jpg");
    }
    public double getX()
    {   
        return xpos;
    } 
    public double getY()
    {
        return ypos;
    }
    public void changeX(double x)
    {
        xpos = xpos + x;
    }
    public void changeY(double y)
    {
        ypos = ypos + y;
    }
    public int getVariation()
    {
        return variation;
    }
    public void draw(Graphics g) // separate the collision and image drawing logic. so
    {
        // draws based on the variation
        //drawing intersection part
        //g.drawImage(im, (int)xpos, (int)ypos, null);

        // drawing techno version
        
        g.setColor(Color.white);
        for(int i=0;i<4;i++)
        {
            g.drawRect((int)xpos+(i*485)+50,(int)ypos+50,350,350);
        }
        for(int i=0;i<4;i++)
        {
            g.drawRect((int)xpos+(i*485)+50,(int)ypos+550,350,350);
        }
        
    }
    public ArrayList<ObstacleParent> getObs()
    {
        return obj;
    }
}
