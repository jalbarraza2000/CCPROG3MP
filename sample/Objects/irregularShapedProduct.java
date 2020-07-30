package sample.Objects;


/** The class irregularShapedProduct represents an irregularShapedProduct object with  max length, max width
 * ,max height, weight, and price. This class extends the class product
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class irregularShapedProduct extends Product
{
    /**
     * A constructor that accepts the length, width, height, and weight of the irregularShapedProduct
     * @param length a non-negateve value that represents the length of the irregularShapedProduct
     * @param width a non-negateve value that represents the width of the irregularShapedProduct
     * @param height a non-negateve value that represents the height of the irregularShapedProduct
     * @param weight a non-negateve value that represents the weight  of the irregularShapedProduct
     */
    public irregularShapedProduct(double length, double width, double height, double weight)
    {
        super(length, width, height, weight);
        this.price = 0;
    }
}