import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Box extends Button implements MouseListener 
{
  boolean checked = false;
  boolean mine = false;
  int xCoord;
  static int safeClicks=0;
  double difficulty;
  char label;
  public Box (boolean isMine, int x)
  {
    this.setBackground(new Color (200,200,255));
    this.addMouseListener(this);
    mine = isMine;
    xCoord = x;
  }
  public Box (String diff)
  {
    this.addMouseListener(this);
    if (diff.equals("Easy"))
    {
      difficulty = .1;
      setLabel("Easy");
      label = 'e';
    }
    else if (diff.equals("Medium"))
    {
      difficulty = .3;
      setLabel("Medium");
      label = 'm';
    }
    else if (diff.equals("Hard"))
    {
      difficulty = .5;
      setLabel("Hard");
      label = 'h';
    }
  }
  public void setCheck (boolean status)
  {
    checked = status;
  }
  public void setMine (boolean death)
  {
    mine = death;
  }
  public void mousePressed(MouseEvent click){}
  public void mouseReleased(MouseEvent click){}
  public void mouseExited(MouseEvent click){}
  public void mouseEntered(MouseEvent click){}
  public void mouseClicked(MouseEvent click)
  {
    if (label == 'e' || label == 'm' || label == 'h')
    {
      Game.fi.setVisible(false);
      Game.createGame(difficulty);
    }
    //System.out.println(xCoord + "," + yCoord);
    else if (SwingUtilities.isLeftMouseButton(click) && !checked)
    {
      if (mine)
        try
      {
        setLabel("X");
        this.setBackground(Color.RED);
        this.removeMouseListener(this);
        System.out.println("you lose");
        Thread.sleep(1000);
        GridFrame.f.setVisible(false);
      }
      catch(InterruptedException ex) 
      {
        Thread.currentThread().interrupt();
      }
      else if (GridFrame.getTotalSafe() <= safeClicks  + 1)
      {
        this.removeMouseListener(this);
        System.out.println("you win");
        GridFrame.f.setVisible(false);
      }
      else
      {
        setLabel("" + GridFrame.getNumMines(xCoord));
        this.setBackground(Color.GRAY);
        setCheck(true);
        safeClicks++;
        this.removeMouseListener(this);
        //System.out.println(safeClicks);
      }
    }
    else
    {
      if (!checked)
      {
        setCheck(true);
        setLabel("check");
        this.setBackground(Color.YELLOW);
      }
      else if (SwingUtilities.isRightMouseButton(click))
      {
        this.setBackground(new Color (200,200,255));
        setLabel("");
        setCheck(false);
      }
    }
  }
}
