import javax.lang.model.type.IntersectionType;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.awt.*;
import java.io.*;
import java.math.BigDecimal;
import java.nio.MappedByteBuffer;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.*;
public class panel extends JPanel
{
    boolean w = false;
    boolean a = false;
    boolean s = false;
    boolean d = false;
    boolean space = false;

    // obstacles
    ArrayList<ObstacleParent> obstacle = new ArrayList<ObstacleParent>();
    ArrayList<MapParent> panels = new ArrayList<MapParent>();
    // entity
    car car = new car(1000,500);

    // panels
    intersectionMap inter;

    // Projectiles
    ArrayList<ProjectileParent> fire = new ArrayList<ProjectileParent>();

    // Entity
    ArrayList<Entity> entity = new ArrayList<Entity>();

    public panel()
    {
        addKeyListener(new KeyEventDemo());
        //addMouseListener(new MouseClass());
        //Timer tdraw = new Timer(1,new TimeListenerDraw());
        Timer t = new Timer(1, new TimeListener());
        //Timer t2= new Timer(20,new TimeListener2());
        t.start();
        //t2.start();
        //tdraw.start();
        setFocusable(true);

        // creating obstables
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            {
                obstacle.add(new basicObstacle(100+(i*600), 400+(j*600), 100, 200));
            }
        }

        // create and draw panels
        for(int i=0; i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                //panels.add(new intersectionMap(i*2000, j*1000, 0));
            }
        }

        // creating the projectiles
        for(int i=0;i<10;i++)
        {
            fire.add(new LazerProjectile(300, 300+(i*50), 30, -10, 1));
        }

        //creating entity
        for(int i=0;i<10;i++)
        {
            entity.add(new PoliceCar(400,300+(i*50),1,1,new LazerProjectile(0, 0, 1, 0, 1)));
        }
    }
    // moves all the obstacles for us. // maybe make this where I update the position of everyone on =screen, not just the obstacles
    void moveObstacle(double x, double y)
    {
        //System.out.println("moveObstacle= "+x+" "+y);
        for(int i=0;i<obstacle.size();i++)
        {
            obstacle.get(i).addX(-x);
            obstacle.get(i).addY(-y);
        }
        for(int i=0;i<panels.size();i++)
        {
            panels.get(i).changeX(-x);
            panels.get(i).changeY(-y);
        }
    }
    ArrayList<ObstacleParent> trimObstacle()
    {
        ArrayList<ObstacleParent> trimmed = new ArrayList<ObstacleParent>();
        for(int i=0;i<obstacle.size();i++)
        {
            double dis = Math.sqrt(Math.pow((1000 - obstacle.get(i).getX()),2) + Math.pow((500-obstacle.get(i).getY()),2));
            int sizeOfLargestItem = 300;
            if(dis<sizeOfLargestItem)
                trimmed.add(obstacle.get(i));
        }
        return trimmed;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,2000,1000);
        car.draw(g);
        for(int i=0;i<panels.size();i++)
        {
            panels.get(i).draw(g);
        }
        for(int i=0;i<obstacle.size();i++)
            obstacle.get(i).draw(g);
        //car.drawHelp(g);

        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(""+car.getVelocity(), 100, 900);

        // draw projectile
        for(int i=0;i<fire.size();i++)
        {
            fire.get(i).draw(g);
        }
        //System.out.println("fire Size in panel: "+fire.size());
        // draw entity
        for(int i=0;i<entity.size();i++)
        {
            entity.get(i).draw(g);
        }
        
        
        
        // testing graphics
        // drawing velocity
        
        
    }
    public class TimeListenerDraw implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
        }
    }
    public class TimeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            car.setObstable(trimObstacle());
            for(int i=0;i<fire.size();i++)
            {
                fire.get(i).setObstacleParents(obstacle);
            }
            if(a ==true)
            {
                car.setFace(-6); /// keep as whole numbers for drag
            }
            if(d == true)
            {
                car.setFace(6);
            }
            if(w == true)
            {
                car.changeVelocity(.5);
            }
            if(s == true)
            {
                car.changeVelocity(-.5);
            }
            if(space == true)
            {
                //System.out.println("fire");
                for(int i=0;i<1;i++)
                {
                    LazerProjectile proj = new LazerProjectile(car.getX()-100, car.getY()+200, 30, -40, 1);
                    proj.setObstacleParents(obstacle);
                    fire.add(proj);
                }
            }

            if(car.getVelocity()<10 && !s)
            {   
                car.changeVelocity(.2);
            }

              

            car.moveCar();
            
            moveObstacle(car.getMoveX(), car.getMoveY());

            // projectile move
            for(int i=0;i<fire.size();i++)
            {
                fire.get(i).move(car.getMoveX(),car.getMoveY(),car);
                //System.out.println("panel: proj "+i+" pos x and y "+fire.get(i).getX()+" "+fire.get(i).getX());
               // System.out.println("# of proj: "+fire.size());
                if(fire.get(i).getAlive() == false)
                {
                    fire.remove(i);
                }
            }
            // delete projectiles out of range of car
            
                
            
            // entity move
            for(int i=0;i<entity.size();i++)
            {
                entity.get(i).move(car.getMoveX(),car.getMoveY());
            }
            


            repaint();
            //}

            
            
        }
    }
    public class TimeListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
        }
    }

    public class KeyEventDemo implements KeyListener
    {
        public void keyTyped(KeyEvent e){}
        public void keyReleased(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
                w = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_A)
            {
                a = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
                s = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                d = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                space = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_E)
            {
                //e1= false;
            }
        }
        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
                w = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_A)
            {
                a = true;
                //System.out.println("click a");
            }
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
                s = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                d = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                space = true;
                
            }
            
        }
    }

}