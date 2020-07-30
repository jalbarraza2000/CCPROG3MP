package sample.Objects;

/** The class Product represents a Product object with length, width
 * , height, weight, and price. This class extends the class Item
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class Product extends Item
{

    /**
     * This constructor initializes the length, width, height, and weight of a document item
     * @param length a double value that corresponds to the length of product
     * @param width a double value that corresponds to the width of product
     * @param height a double value that corresponds to the height of product
     * @param weight a double value that corresponds to the weight of product
     */

    public Product (double length, double width, double height, double weight)
    {
        super(length, width);
        this.height = height;
        this.weight = weight;
        this.price = 0;
    }
}
