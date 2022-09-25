import java.util.Scanner;
public class test1
{
  public static void main(String args[])
  {  
    int size;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a row/collumn size.");
    size = sc.nextInt();
    while (size <= 0)
    {
      System.out.println("Enter a row/collumn size. (Greater than 0)");
      size = sc.nextInt();
    }
    new Game1(size,size);
  }
}  