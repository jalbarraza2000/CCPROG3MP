package sample.Objects;


/** The class Document represents a Document object with length, width
 * , height, weight, number of pages, and price. This class extends the class Item
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */


public class Document extends Item
{

    /**
     * This constructor initializes the length, width, number of pages, height, and weight of a document item
     * @param pages an int value that corresponds to the number of pages in the document item
     * @param length a double value that corresponds to the length of the paper to be sent
     * @param width a double value that corresponds to the width of the paper to be sent
     */

    public Document(int pages, double length, double width)
    {

        super(length, width);
        this.pages = pages;

        this.price = 0;
        this.height = this.pages * 0.04;
        this.weight = this.pages * 8;

    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    private int pages;

}

