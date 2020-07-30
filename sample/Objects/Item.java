package sample.Objects;

/** The class Item is an abstract class that is a super class. It has a length and width.
 * Document, Product, and irregularShapedProduct are its subclasses.
 *
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public abstract class Item
{

    public Item()
    {

    }

    /**
     * This constructor initializes the item's length and width
     * @param length a non-negative double value
     * @param width a non-negative double value
     */

    public Item(double length, double width)
    {
        this.width = width;
        this.length = length;
    }

    /**
     * This method returns the length of the item
     * @return length of the item
     */

    public double getLength()
    {
        return length;
    }

    /**
     * This method returns the width of the item
     * @return width of the item
     */

    public double getWidth()
    {
        return width;
    }

    /**
     * This method returns the height of the item
     * @return height of the item
     */

    public double getHeight()
    {
        return height;
    }

    /**
     * This method changes the weight from grams into kilograms
     * @return a double value that corresponds to the weight in kilograms, and rounded up if value
     * is a fraction of a kilogram
     */

    public double getKgWeight()
    {
        return Math.ceil(this.weight / 1000);
    }

    /*
        These attributes are protected in order for it's subclasses to inherit them
     */

    protected double height;
    protected double weight;
    protected double length;
    protected double width;
    protected double price;

}
