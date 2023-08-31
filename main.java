import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
public class main extends JFrame
{
    public static void main(String [] args)
    {
        JFrame frame = new JFrame("MiniGame");
        frame.setSize(2000,1000);
        frame.setContentPane(new panel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
}