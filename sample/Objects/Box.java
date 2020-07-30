package sample.Objects;


/** The class Box represents a Box object with  width, length, height,
 * basePrice and extends the class Parcel
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */
public class Box extends Parcel
{

    /**
     * This constructor initializes the dimensions of a box parcel type
     * @param widthCapacity a non-negative double value
     * @param lengthCapacity a non-negative double value
     * @param heightCapacity a non-negative double value
     */

    public Box(double widthCapacity, double lengthCapacity, double heightCapacity)
    {
        this.widthCapacity = widthCapacity;
        this.lengthCapacity = lengthCapacity;
        this.heightCapacity = heightCapacity;
        this.basePrice = 40;
    }

    /**
     * This method returns the width of the box
     * @return the width of the box
     */

    public double getWidth()
    {
        return widthCapacity;
    }

    /**
     * This method returns the length of the box
     * @return the length of the box
     */
    public double getLength()
    {
        return lengthCapacity;
    }

    /**
     * This method returns the height of the box
     * @return the height of the box
     */
    public double getHeight()
    {
        return heightCapacity;
    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    private double  basePrice;

}
