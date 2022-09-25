import java.awt.*;
import javax.swing.*;
import javax.swing.JTextField;
public class Game extends Frame
{
  static int row;
  static int col;
  static JFrame fi;
  static JTextField input = new JTextField();
  public Game (int r,int c)
  {
    fi = new JFrame();
    row = r;
    col = c;
    fi.setSize(300,300);
    fi.setLayout(new GridLayout(10,10));
    Box easy = new Box("Easy");
    Box medium = new Box("Medium"); 
    Box hard = new Box("Hard"); 
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
     new GridFrame(row,col,difficulty);
   }
}
