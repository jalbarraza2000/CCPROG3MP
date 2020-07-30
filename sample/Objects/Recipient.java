package sample.Objects;

/** The class Recipient represents a Recipient object
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */


public class Recipient {

    public Recipient (String name, String destination)
    {
        this.name = name;
        this.destination = destination;
    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    private String name;
    private String destination;
    private String trackingNum;

}
