import java.awt.*;
import javax.swing.*;
import javax.swing.JTextField;
public class Game1 extends Frame
{
  static int row;
  static int col;
  static JFrame fi;
  static JTextField input = new JTextField();
  public Game1 (int r,int c)
  {
    fi = new JFrame();
    row = r;
    col = c;
    fi.setSize(300,300);
    fi.setLayout(new GridLayout(10,10));
    Box1 easy = new Box1("Easy");
    Box1 medium = new Box1("Medium"); 
    Box1 hard = new Box1("Hard"); 
    //fi.add(input); 
    fi.setBackground(Color.GRAY);
    fi.add(easy);
    fi.add(easy);
    fi.add(medium);
    fi.add(hard);
    fi.setVisible(true);
  }  
   static void createGame(double difficulty)
   {/*
     if (size < 1)
       size = 10;
     else
       size = input.getText();*/
     new GridFrame1(row,col,difficulty);
   }
}