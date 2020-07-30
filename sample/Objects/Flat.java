package sample.Objects;

/** The class Flat represents a Flat object with  width, length, height, weight, and
 * basePrice and extends the class Parcel
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class Flat extends Parcel
{

    /**
     * This constructor initializes the dimensions of a flat parcel
     * @param width a non-negative double value
     * @param length a non-negative double value
     * @param height a non-negative double value
     * @param weight a non-negative double value
     * @param basePrice a non-negative double value
     */

    public Flat(double width, double length, double height, double weight, double basePrice)
    {
        this.widthCapacity = width;
        this.lengthCapacity = length;
        this.heightCapacity = height;
        this.weightCapacity = weight;
        this.price = basePrice;

    }

    /**
     * This method returns the width of the flat
     * @return the width of the flat
     */

    public double getWidth()
    {
        return this.widthCapacity;
    }

    /**
     * This method returns the length of the flat
     * @return the length of the flat
     */
    public double getLength()
    {
        return this.lengthCapacity;
    }

    /**
     * This method returns the height of the flat
     * @return the height of the flat
     */
    public double getHeight()
    {
        return this.heightCapacity;
    }

    /**
     * This method gets the weight of the flat
     * @return the weight of the flat
     */

    public double getWeight()
    {
        return this.weightCapacity;
    }

    /**
     * This methods gets the double value price of the flat
     * @return a double value that is the price of the flat
     */

    public double getPrice()
    {
        return this.price;
    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    private double price;
}

