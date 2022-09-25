import java.awt.*;
import javax.swing.*;
public class GridFrame extends Frame
{
  static boolean[] grid;
  static int numbRow;
  static int numbCol;
  int totalMines=0;
  static int totalSafe=0;
  static JFrame f = new JFrame();
  GridFrame(int numRows, int numCols, double difficulty)
  {
    numbRow = numRows;
    numbCol = numCols;
    boolean[] gridArray = new boolean [numRows*numCols];
    for(int i=0; i < (numRows*numCols); i++)
    {
      gridArray[i] = false;
    }
    f.setSize(500,500);  
    f.setLayout(new GridLayout(numRows,numCols));  
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    for(int i=0; i < (numRows*numCols); i++)
    {
      if (Math.random() <= difficulty)
      {
        f.add(new Box(true,i));
        gridArray[i] = (true);
     //   System.out.println("true");
        totalMines++;
      }
      else
      {
        f.add(new Box(false,i));
        gridArray[i] = (false);
        totalSafe++;
      //  System.out.println("false");
      } 
    }
    grid = gridArray;
    f.setTitle("Minesweeper                                             Number of Mines: " + totalMines);
  }
  public static int getNumMines(int xVal)
  {
    int numMines = 0;
    if ((xVal)%(numbCol) != 0 && xVal >= 1 && grid[xVal-1] == true)
      numMines++;
    if ((xVal+1)%(numbCol) != 0 && xVal < numbRow*numbCol-1 && grid[xVal+1] == true)
      numMines++;
    if (xVal >= numbCol && grid[xVal-numbCol] == true)
      numMines++;
    if ((xVal)%(numbCol) != 0 && xVal >= numbCol+1 && grid[xVal-(numbCol+1)] == true)
      numMines++;
    if ((xVal+1)%(numbCol) != 0 && xVal >= numbCol-1 && grid[xVal-(numbCol-1)] == true)
      numMines++;
    if ((xVal)%(numbCol) != 0 && xVal <= numbRow*numbCol - numbCol && grid[xVal+(numbCol-1)] == true)
      numMines++;
    if (xVal <= numbRow*numbCol - (numbCol+1) && grid[xVal+numbCol] == true)
      numMines++;
    if ((xVal+1)%(numbCol) != 0 && xVal <= numbRow*numbCol - (numbCol+2) && grid[xVal+(numbCol+1)] == true)
      numMines++;
    return numMines;
  }
  public int getTotalMines()
  {
    return totalMines;
  }
   public static int getTotalSafe()
  {
    return totalSafe;
  }
   public static int getNumRows()
  {
    return numbRow;
  }
   public static int getNumCols()
  {
    return numbCol;
  }
}
