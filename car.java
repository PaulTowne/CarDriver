import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.beans.VetoableChangeListener;

public class car
{
    int xpos=0;
    int ypos=0;
    double velocity =0; // data trunkates to 0 if you have too low a velocity. 
    double faceActual = 0;
    double friction = 1;
    double facing =0;  // in degrees. 
    boolean turnLeft = false;
    double moveX;
    double moveY;
    int alternate=0; // graphics (image)
    int carTail =49; // counter for tail
    int carTail2 =0; // another counter for tail
    int driftCounter =0; // adds up till activate drift tehn zeros
    int continuedDrift =0; // stacks up the longer the car is consecutively drifting
    Image c1;
    Image c2;
    Image c3;
    Image c4;
    boolean currentlyCollide = false;
    boolean pop = false;
    boolean uniX = true; // if moving = true
    boolean uniY = true;
    Collision collide;
    ArrayList<ObstacleParent> obj;
    ArrayList<Point> point;

    // tail lines
    double [] xList = new double[50];
    double [] yList = new double[50];
    int [] Xfin = new int[50];
    int [] Yfin = new int[50];
    double [] xList2 = new double[50];
    double [] yList2 = new double[50];
    int [] Xfin2 = new int[50];
    int [] Yfin2 = new int[50];

    int numPoints = 50; 
    // storing the moveX and moveY for tails // using point class for the x and y changes
    //ArrayList<PointDouble> storeMove = new ArrayList<PointDouble>();


    //int [] xList = {10,40,50};
    //int [] yList = {10,60,10};
    //int numPoints = 3;
    

    public car(int x, int y)
    {
        xpos =  x;
        ypos = y;
        Toolkit tool = Toolkit.getDefaultToolkit();
        // 24 pixels wide || 44 pixel long
        c1 = tool.getImage("PixelCar.png");
        c2 = tool.getImage("PixelCarTechno.png");
        c3 = tool.getImage("PixelCarTechnoO.png");
        c4 = tool.getImage("PixelCarTechno3.png");

        collide = new Collision();

        for(int i=0;i<xList.length;i++)
        {
            xList[i] = xpos;
            yList[i] = ypos;
            xList2[i] = xpos;
            yList2[i] = ypos;
        }
        
    }
    public void drawHelp(Graphics g)
    {
        for(int j=0;j<obj.size();j++)
        {
            double face = facing;
            int carX = xpos;
            int carY = ypos;
            g.setColor(Color.BLACK);
            for(int i=0;i<40;i++)
            {
                double frontX = 21*Math.cos(Math.toRadians(face+i))+carX;
                double frontY = 21*Math.sin(Math.toRadians(face+i))+carY;
                g.drawLine(xpos,ypos, (int)frontX,(int)frontY);
            }
            for(int i=320;i<360;i++)
            {
                double frontX = 21*Math.cos(Math.toRadians(face+i))+carX;
                double frontY = 21*Math.sin(Math.toRadians(face+i))+carY;
                g.drawLine(xpos,ypos, (int)frontX,(int)frontY);
            }
            // front sides 
            for(int i=30;i<60;i++)
            {
                double frontX = 15*Math.cos(Math.toRadians(face+i))+carX;
                double frontY = 15*Math.sin(Math.toRadians(face+i))+carY;
                g.drawLine(xpos,ypos, (int)frontX,(int)frontY);
            }
            for(int i=300;i<330;i++)
            {
                double frontX = 15*Math.cos(Math.toRadians(face+i))+carX;
                double frontY = 15*Math.sin(Math.toRadians(face+i))+carY;
                g.drawLine(xpos,ypos, (int)frontX,(int)frontY);
            }
            // sides
            for(int i=60;i<120;i++)
            {
                double frontX = 12*Math.cos(Math.toRadians(face-i))+carX;
                double frontY = 12*Math.sin(Math.toRadians(face-i))+carY;
                g.drawLine(xpos,ypos, (int)frontX,(int)frontY);
            
            }
            for(int i=240;i<300;i++)
            {
                double frontX = 12*Math.cos(Math.toRadians(face-i))+carX;
                double frontY = 12*Math.sin(Math.toRadians(face-i))+carY;
                g.drawLine(xpos,ypos, (int)frontX,(int)frontY);
                
            }
            // back sides
            for(int i=120;i<150;i++)
            {
                double frontX = 15*Math.cos(Math.toRadians(face-i))+carX;
                double frontY = 15*Math.sin(Math.toRadians(face-i))+carY;
                g.drawLine(xpos,ypos, (int)frontX,(int)frontY);
                
            }
            for(int i=210;i<240;i++)
            {
                double frontX = 15*Math.cos(Math.toRadians(face-i))+carX;
                double frontY = 15*Math.sin(Math.toRadians(face-i))+carY;
                g.drawLine(xpos,ypos, (int)frontX,(int)frontY);
                
            }
            //back
            for(int i=150;i<210;i++)
            {
                double frontX = 20*Math.cos(Math.toRadians(face-i))+carX;
                double frontY = 20*Math.sin(Math.toRadians(face-i))+carY;
                g.drawLine(xpos,ypos, (int)frontX,(int)frontY);
                
            }
        }
    }
    public void draw(Graphics g)
    {
         
        //g.setColor(Color.red);
        //g.drawLine(xpos, ypos, (int)(xpos+(50*Math.cos(Math.toRadians(faceActual)))), (int)(ypos+(50*Math.sin(Math.toRadians(faceActual)))));
        //g.setColor(Color.GREEN);
        //g.drawLine(xpos, ypos, (int)(xpos+(50*Math.cos(Math.toRadians(facing)))), (int)(ypos+(50*Math.sin(Math.toRadians(facing)))));
        
        
           //trails
           g.setColor(new Color(5,247,108));
           //g.setColor(Color.white);
           g.setColor(new Color(247,5,21,-0));
           for(int i=0;i<xList.length;i++)
           {
                Xfin[i] = (int)xList[i];
                Yfin[i] = (int)yList[i];
                Xfin2[i] = (int)xList2[i];
                Yfin2[i] = (int)yList2[i];
           }
           //g.drawPolyline(Xfin, Yfin, numPoints);
           //g.drawPolyline(Xfin2, Yfin2, numPoints);
           for(int i=0;i<Xfin.length-2;i++)
           {
                g.setColor(new Color(247,5,21,255-(i*5)));
                g.drawLine(Xfin[i], Yfin[i], Xfin[i+1], Yfin[i+1]);
                g.drawLine(Xfin2[i], Yfin2[i], Xfin2[i+1], Yfin2[i+1]);
           }
           
           
            Graphics2D g3d=(Graphics2D)g.create();
            g3d.translate(xpos,ypos); // Translate the center of our coordinates.
            g3d.rotate(Math.toRadians(faceActual));
            //g3d.drawImage(c2, -22, -12, null);
            //g3d.drawImage(c1, -22, -12, null);
            if(alternate<20)
                g3d.drawImage(c2, -22, -12, null);
            else if(alternate>=20 && alternate<40)
                g3d.drawImage(c3, -22, -12, null);
            else if(alternate>=40 && alternate<60)
                g3d.drawImage(c4, -22, -12, null);

                if(alternate==60)
                    alternate = 0;
                else
                    alternate++;
           
           g3d.dispose();
           
           
    }
    public void setObstable(ArrayList<ObstacleParent> ob)
    {
        obj = ob;
    }
    public void drift(double vel) // things to work on - dot set facing = actual when collide. stagger drift() itself so you drift the same direction for longer and increase rate respectively. The duration of drfit is = velocity
    {                   // velocity should decrease on drifting, not just on "turning". this doesnt work with negative velocity rn. It can turn into walls as im not colllide checking during drifting
        //System.out.println("drft");
        // have an "actual" car direction
        // depending on the speed you are going, it changes the rate at which the traveling direction can catch up to the turn direction
        // make sure its trying to get to the "shortest distance" face. so when you turn left or right it drifts the shorter distance
    
        // have a friction factor
        // rate of direction change is 
        // we change direction by .5 degrees a tick, we need to know the percentage changed based on the friction

        // lets set rate to a specific value and just call drift at varying amounts per second to simulate drift. the calling drift is done in the moveCar. 
        boolean col =false;
        // when velocity is too small. the rate skyrockets and it cant actually lock onto the faceactual. which means it just freaks out. 
        
        
        double rate = 30/Math.abs(velocity); // change
        //double rate = .5*80*Math.abs(friction/(velocity+.01)); // higher friction means higher rate (wheels would grab street better) // higher velocity means lower rate (harder to grab at high speeds)
        //System.out.println("rate = "+rate);
        // lets find out which direction we have to go
        
        //System.out.println("faceActual="+faceActual+" facing="+facing);
        int tempActual = (int)faceActual;
        int tempFacing = (int)facing;
        int iterate =0;
        boolean left= false;
        while(tempActual!= tempFacing)
        {
            tempFacing++;
            if(tempFacing>=360)
            {
                tempFacing = 0;
            }
            iterate++;
        }
        // change in velocity is depednet on the difference between actual and facing
        // if iterate is smaller than our rate, we have to lower rate
        if(iterate<rate)
            rate = (rate -(rate-iterate))/3;
        if(iterate>=180)
        {
            // this means its quicker to turn left to get to actual
            left = true;
        }
        else{
            //quicker to turn right
            left = false;
        }

        if(left)
        {
            // change is positive, 
            for(int i=0;i<obj.size();i++)
            {
                if(collide.collide(xpos,ypos, facing-rate, obj.get(i).getX()-moveX, obj.get(i).getY()-moveY, obj.get(i).getSize()))
                {
                    col = true;
                }
                
            }
            if(!col)
            {
                facing = facing - rate;
                if(facing<0)
                {
                    facing = 360 + facing;
                }
            }
            
            //velocity = velocity- .01;
        }
        else
        {
            for(int i=0;i<obj.size();i++)
            {
                if(collide.collide(xpos,ypos, facing+rate, obj.get(i).getX()-moveX, obj.get(i).getY()-moveY, obj.get(i).getSize()))
                {
                    col = true;
                }
                
            }
            if(!col)
            {
                facing = facing + rate;
                if(facing>360)
                {
                    facing = 360 - facing;
                }
            }
            //velocity = velocity- .01;
        } 
        
        // center teh face and faceActual by setting all values - faceactual. it would center it on 0 degrees and we could use 
        // velocity change up due to continuedDrift
        //velocity = velocity -(continuedDrift*.005);
        //System.out.println("vel change="+(continuedDrift*.005));
        //if(velocity<1)
            //velocity = 1;
        
    }
    public void moveCar() // we need to call the drift method based on the velocity of hte car (set a parameter for drift) which changed how much drift happens depending on velocity
    {
         // lets tame the # of objects we have to collide check with. 

        //facing = faceActual; // instead of this line. we call the drift method. which controls how fast the facing = faceActual
         moveX = velocity*Math.cos(Math.toRadians(facing));
         moveY = velocity*Math.sin(Math.toRadians(facing));
        boolean col = false;
        boolean colX = false;
        boolean colY = false;

        for(int i=0;i<obj.size();i++)
        {
             if(collide.collide(xpos,ypos, facing, obj.get(i).getX()-moveX, obj.get(i).getY()-moveY, obj.get(i).getSize()))
             {
                col = true;
             }
             if(collide.collide(xpos,ypos, facing, obj.get(i).getX()-moveX, obj.get(i).getY(), obj.get(i).getSize()))
             {
                colX = true;
             }
             if(collide.collide(xpos,ypos, facing, obj.get(i).getX(), obj.get(i).getY()-moveY, obj.get(i).getSize()))
             {
                colY = true;
             }
        }
        //System.out.println("face = "+facing+" move= "+moveX+" "+moveY+" collide?= "+colX+" "+colY+" "+col);
        // even if it collides, we back for x and y axis collisions separately to change how it moves after.  

            // new version
            if(!colY && !colX && col)
            {
                // total collide
                //System.out.println("total collide");
                // we dont move at all cause it collided. 
                moveX = 0;
                moveY = 0;

            }
            else
            {
                if(colX)
                {
                    //xpos = xpos+ (int)moveX; 
                    moveX = 0;
                }
                if(colY)
                {
                    //ypos = ypos+ (int)moveY; 
                    moveY =0;
                }
            }      
            if(colY || colX)
            {
                // this is the pop where it pops the velocity =3 function.
                if(velocity>3)
                {
                    velocity = velocity -.1; 
                }
                if(velocity<-3)
                {
                    velocity = velocity +.1;
                }
            }
        // drag
         
            //if(!colY && !colX && !col)
            //{
                if(Math.abs(facing - faceActual)>2)
                {
                    //for(int i=0;i<velocity) // call drift multiple times to simulate multiple calls a tick
                    drift(velocity); // can we stagger how much drift is called.
                    continuedDrift++;
                    //System.out.println("continued drift= "+continuedDrift);
                    if(continuedDrift>100)
                        continuedDrift = 100;
                }
                else
                { 
                    facing = faceActual;
                    //System.out.println("notdrift");
                    continuedDrift = 0;   
                }    
           // }
            //else{
                //facing = faceActual;
           // }
            
         // drift based velocity change
         if(velocity>0)
         {

             velocity = velocity- (velocity*(continuedDrift*.001));
             
         }
        else
        {
            velocity = velocity + (Math.abs(velocity)*(continuedDrift*.001));
             //velocity = velocity+ (continuedDrift*.005);
        }
         //if(velocity<=1)
           // velocity = 1;
        
        // trails  
        xList[0] = 18*Math.cos(Math.toRadians(faceActual+150))+xpos;
        yList[0] = 18*Math.sin(Math.toRadians(faceActual+150))+ypos;
        xList2[0] = 20*Math.cos(Math.toRadians(faceActual+210))+xpos;
        yList2[0] = 20*Math.sin(Math.toRadians(faceActual+210))+ypos;
        
        for(int i=xList.length-1;i>0;i--)
        {
            xList[i] = xList[i-1];
            yList[i] = yList[i-1];
            xList2[i] = xList2[i-1];
            yList2[i] = yList2[i-1];
        }
        for(int i=1;i<xList.length;i++)
        {
            xList[i] = xList[i]-moveX;
            yList[i] = yList[i]-moveY;
            xList2[i] = xList2[i]-moveX;
            yList2[i] = yList2[i]-moveY;
        }

            
    }
    public void setFace(double face)
    {
        if(face<0)
            turnLeft = true;
        else    
            turnLeft = false;
        boolean c = false;
        for(int i=0;i<obj.size();i++)
        {
             if(collide.collide(xpos, ypos, facing+face, obj.get(i).getX(), obj.get(i).getY(), obj.get(i).getSize()))
             {
                // collided, no rotate
                c= true;
             }
        }
        if(!c)
        {
            
            faceActual = faceActual + face;
            if(faceActual<0)
            {
                faceActual=360-Math.abs(face);
            }
            if(faceActual>=360)
            {
                faceActual = faceActual-360;
            }
            //facing = facing + face; 
        }
        // lowers speed whenever you are turning
        //velocity = velocity-.2;
        //if(velocity<1)
            //velocity = 1;
        
        
    }

    public int getX()
    {
        return xpos;
    }
    public int getY()
    {
        return ypos;
    }
    public double getMoveX()
    {
        
            return moveX;
        
    }
    public double getMoveY()
    {
        
            return moveY; 
        
    }
    public double getVelocity()
    {
        return velocity;
    }
    public void setVelocity(double vel)
    {
        velocity = vel;
    }
    public void changeVelocity(double vel)
    {
            velocity += vel;
    }
    public double getFacing()
    {
        return facing;
    }
}
