import java.awt.*;

public class PewPew
{
    private int myX;
    private int myY;
    private int mySize;
    private Color myColor;
    private int mydx;

    // constructors
    public PewPew(int x, int y)
    {
        mySize = 10;
        myY = y;
        myX = x;
        myColor = new Color(10, 10, 10);
        mydx = 5;
    }

    public void resetSquare(int x, int y){
        mySize = 8;
        myY = y;
        myX = x;
        myColor = new Color(10, 10, 10);
        mydx = 5;
    }

    public int getMyY(){
        return myY;
    }

    public int getMyX(){
        return myX;
    }

    public int getMySize(){
        return mySize;
    }

    //instance methods
    public void move()
    {
        myX += mydx;  //Move a certain distance upwards - this will happen every animation step

    }

    public void adddx(int dx)  //Allows the keyboard listener to modify animated behavior
    {
        mydx += dx;
    }

    public void draw(Graphics myBuffer)
    {
        myBuffer.setColor(myColor);
        myBuffer.fillRect(myX, myY, mySize, mySize);
    }
}
