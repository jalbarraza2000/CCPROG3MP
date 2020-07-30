package sample.Objects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/** The class Parcel represents a Parcel object with  name of the recipient,
 * destination, width capacity, height capacity, length capacity and weight capacity
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class Parcel
{
    /**
     * A blank constructor for the class Parcel
     */
    public Parcel()
    {


    }

    /**
     * This constructors accepts name of the recipient, destination, width capacity, height capacity, length capacity and weight capacity of the Parcel
     * @param name a String value that corresponds to the name of the recipient of the parcel
     * @param destination a String value that corresponds to the destination of the parcel
     * @param items an arrayList of items that contains the items in the parcel
     * @param maxNumItem a integer value that represents the maximum number of items the parcel can hold
     */

    public Parcel (String name, String destination, ArrayList<Item> items,int maxNumItem)
    {
        this.name = name;
        this.destination= destination;
        this.maxNumItem = maxNumItem;
        this.weightCapacity = 0;
        this.lengthCapacity = 0;
        this.widthCapacity = 0;
        this.heightCapacity = 0;
        this.tracking = new Tracking(strDate);
        this.dayMade = 0;
        this.price = 0;
        this.recipient = new Recipient(name, destination);
        this.items = new ArrayList<Item>();
        this.items = items;

    }

    /**
     *This method sets the variable day as the day the parcel was made
     * @param day a positive integer value
     */
    public void setDayMade(int day)
    {
        this.dayMade = day;
    }

    /**
     * This methods returns the day the parcel was made
     * @return the day the parcel was made
     */

    public int getDayMade()
    {
        return dayMade;
    }

    /**
     * This method returns the width capacity of the parcel
     * @return width capacity of the parcel
     */
    public double getWidthCapacity()
    {
        return this.widthCapacity;
    }

    /**
     * This method returns the length capacity of the parcel
     * @return length capacity of the parcel
     */
    public double getLengthCapacity()
    {
        return this.lengthCapacity;
    }

    /**
     * This method returns the height capacity of the parcel
     * @return height capacity of the parcel
     */
    public double getHeightCapacity()
    {
        return this.heightCapacity;
    }

    /**
     * This method returns the weight capacity of the parcel
     * @return weight capacity of the parcel
     */
    public double getWeightCapacity()
    {
        return weightCapacity;
    }

    /**
     * This method returns the destination of the parcel
     * @return destination of the parcel
     */

    /**
     * This method returns the destination of the parcel
     * @return the destination of the parcel
     */
    public String getDestination()
    {
        return this.destination;
    }

    /**
     * This method assigns the variable maxHeight to the height capacity of the parcel
     */
    public void getMaxHeight()
    {

        double maxHeight = 0;

        for(int i = 0; i < items.size(); i++)
        {
            maxHeight = maxHeight + items.get(i).getHeight();
        }

        this.heightCapacity = maxHeight;
    }

    /**
     * This method assigns the variable maxWeight to the weight capacity of the parcel
     */
    public void getMaxWeight()
    {

        double maxWeight = 0;

        for(int i = 0; i < items.size(); i++)
        {
            maxWeight = maxWeight + items.get(i).getKgWeight();
        }

        this.weightCapacity = maxWeight;
    }

    /**
     * This method assigns the variable maxLength to the length capacity of the parcel
     */
    public void getMaxLength()
    {

        double maxLength = items.get(0).getLength();

        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getLength() > maxLength)
                maxLength = items.get(i).getLength();
        }

        this.lengthCapacity = maxLength;
    }

    /**
     * This method assigns the variable maxWidth to the width capacity of the parcel
     */
    public void getMaxWidth()
    {

        double maxWidth = this.items.get(0).getWidth();

        for(int i = 0; i < this.items.size(); i++)
        {
            if(this.items.get(i).getWidth() > maxWidth)
                maxWidth = items.get(i).getWidth();
        }

        this.widthCapacity = maxWidth;
    }

    /**
     * This method returns the volumetric weight of the parcel
     * @return the volumetric weight of the parcel
     */

    public double getVolumetricWeight()
    {
        return (getLengthCapacity() * getWidthCapacity() * getHeightCapacity()) / 305.00;
    }

    /**
     * This method sets a boolean value as whether the parcel is insured
     * @param value a boolean value
     */
    public void setInsured(boolean value)
    {
        this.isInsured = value;
    }

    /**
     * Method returns true if dimensions of object fit within fixed box measurements. Different from checkPrintFlat
     * as this method checks only and does not print anything after.
     * @param f a Flat object
     * @param height a non-negative double value
     * @param length a non-negative double value
     * @param width a non-negative double value
     * @param weight a non-negative double value
     * @return a boolean value corresponding whether item dimension fits within parcel type / dimensions
     */

    public boolean checkOnlyFlat(Flat f, double height, double length, double width, double weight)
    {
        if (f.getHeight() >= height && f.getLength() >= length
                && f.getWidth() >= width && f.getWeight() >= weight)
            return true;

        return false;
    }

    /**
     * Method returns true if dimensions of object fit within fixed box measurements. Different from checkPrintBox
     * as this method checks only and does not print anything after.
     * @param b a Box object
     * @param height a non-negative double value
     * @param length a non-negative double value
     * @param width a non-negative double value
     * @return a boolean value corresponding whether item dimension fits within parcel type / dimensions
     */

    public boolean checkOnlyBox(Box b, double height, double length, double width)
    {
        if(b.getHeight() >= height && b.getLength() >= length
                && b.getWidth() >= width)
            return true;

        return false;
    }

    /**
     * Method recommends flat types given dimensions. If original orientation does not fit, method attempts
     * to rotate item and check if it now fits
     * @param f a Flat object
     * @return a boolean value corresponding whether item dimension fits within parcel type / dimensions
     */

    public boolean recommendFlat(Flat f)
    {

        if(this.checkOnlyFlat(f, this.heightCapacity, this.lengthCapacity , this.widthCapacity, this.weightCapacity) ||
                (this.checkOnlyFlat(f, this.heightCapacity, this.widthCapacity , this.lengthCapacity, this.weightCapacity)))
            return true;

        if(!this.checkOnlyFlat(f, this.heightCapacity, this.lengthCapacity , this.widthCapacity, this.weightCapacity) &&
                !this.checkOnlyFlat(f, this.heightCapacity, this.widthCapacity , this.lengthCapacity, this.weightCapacity))
            return false;

        return true;
    }

    /**
     * Method recommends box types given dimensions. If original orientation does not fit, method attempts
     * to rotate item and check if it now fits
     * @param b a Box object
     * @return a boolean value corresponding whether item dimension fits within parcel type / dimensions
     */

    public boolean recommendBox(Box b)
    {
        if(this.checkOnlyBox(b, this.heightCapacity, this.lengthCapacity , this.widthCapacity) ||
                this.checkOnlyBox(b, this.heightCapacity, this.widthCapacity , this.lengthCapacity))
            return true;

         if(!this.checkOnlyBox(b, this.heightCapacity, this.lengthCapacity , this.widthCapacity) &&
                !this.checkOnlyBox(b, this.heightCapacity, this.widthCapacity , this.lengthCapacity))
            return false;

        return true;
    }

    /**
     * This method sets the price of the parcel based on the int variable pack
     * @param pack an int variable that represents the type of package used
     */
    public void setPrice(int pack)
    {

        boolean mayISP = false;

        for(int i = 0; i < this.items.size(); i++)
        {
            if(this.items.get(i) instanceof irregularShapedProduct)
                mayISP = true;
        }

        if(mayISP)
        {
            if(pack == 0)
                price = 30;
            else if(pack == 1)
                price = 50;
            else if (pack >= 2 && pack <= 5)
            {
                if((30 * getVolumetricWeight()) > (40 * this.weightCapacity))
                    price = 30 * getVolumetricWeight();
                else
                    price = 40 * this.weightCapacity;
            }
            else
                price = 0;
        }

        else
        {
            if(pack == 0)
                this.price = 30;
            else if(pack == 1)
                this.price = 50;
            else if (pack >= 2 && pack <= 5)
            {
                this.price = (40 * this.weightCapacity);
            }
            else
                this.price = 0;

        }
    }

    /**
     * This methods returns the price of the parcel
     * @return the price of the parcel
     */
    public double getPrice()
    {
        return this.price;
    }

    /**
     * This method returns the insurance fee of the parcel
     * @return returns the insurance fee of the parcel
     */
    public double getInsuranceFee()
    {
        if (this.isInsured)
        {
            return (5.00 * items.size());
        }
        else
            return 0;
    }

    /**
     * This method computes and returns the final price of the parcel
     * @return the final price of the parcel
     */
    public double finalPrice()
    {

        if(this.destination.equalsIgnoreCase("Metro Manila"))
            this.price = this.price + 50;
        else if(this.destination.equalsIgnoreCase("Provincial Luzon"))
            this.price = this.price + 100;
        else if(this.destination.equalsIgnoreCase("Visayas"))
        {

            if(this.weightCapacity * 0.1 > 1000 &&  this.weightCapacity * 0.1 > getVolumetricWeight() * 0.1)
                this.price = this.price + (this.weightCapacity * 0.1);
            else if (1000 > this.weightCapacity * 0.1 && 1000 > getVolumetricWeight() * 0.1)
                this.price = this.price + 1000;
            else if (getVolumetricWeight() * 0.1 > 1000 & getVolumetricWeight() * 0.1 > this.weightCapacity *0.1)
                this.price = this.price + (getVolumetricWeight() * 0.1);
            System.out.println("Added");
        }

        else if(destination.equalsIgnoreCase("Mindanao"))
        {
            if(this.weightCapacity * 0.25 > 3000 &&  this.weightCapacity * 0.25 > getVolumetricWeight() * 0.25)
                this.price = this.price + (this.weightCapacity * 0.25);
            else if (3000 > (this.weightCapacity * 0.25) && 3000 > (getVolumetricWeight() * 0.25))
                this.price = this.price + 3000;
            else if (getVolumetricWeight() * 0.25 > 3000 & getVolumetricWeight() * 0.25 > this.weightCapacity * 0.25)
                this.price = this.price + (getVolumetricWeight() * 0.25);
        }

        if(this.isInsured)
            this.price = this.price + getInsuranceFee();

        return this.price;
    }

    /**
     * This method returns the maximum number of items the parcel can hold
     * @return returns the maximum number of items the parcel can hold
     */
    public int getMaxNumItems()
    {
        return maxNumItem;
    }

    /**
     * This method returns the name of the recipient fo the parcel
     * @return the name of the recipient fo the parcel
     */
    public String getName()
    {
        return  name;
    }

    /**
     * This method returns the update date of the parcel
     * @return returns the update date of the parcel
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method sets the variable updateDate as the parcel's update date
     * @param updateDate a date variable
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method returns the number position of the parcel
     * @return the number position of the parcel
     */
    public int getParcelNum() {
        return parcelNum;
    }

    /**
     * This method sets the parcelNum variable as the number of the parcel
     * @param parcelNum an int number representing a parcels number
     */
    public void setParcelNum(int parcelNum) {
        this.parcelNum = parcelNum;
    }

    /**
     * This method returns a string version of different variables
     * @return string
     */

    @Override
    public String toString() {
        return "Parcel #" + (this.parcelNum + 1) + " Update Date: " + dates2.format(this.getUpdateDate()) + " Status: " + this.tracking.ifDelivered();
    }

    /*
        These attributes are private to this specific controller as it is only used here
        Some attributes are protected in order for Parcel's subclasses to inherit
     */

    private String name;
    private String destination;
    private Recipient recipient;
    protected double widthCapacity;
    protected double lengthCapacity;
    protected double heightCapacity;
    protected double weightCapacity;
    protected boolean isInsured;
    protected double price;
    protected int dayMade;
    private int parcelNum;
    public Tracking tracking;
    private ArrayList<Item> items;
    private int maxNumItem;
    private Date updateDate, date = new Date();
    private SimpleDateFormat dates = new SimpleDateFormat("MMdd");
    private SimpleDateFormat dates2 = new SimpleDateFormat("MM/dd/yyy");
    private String strDate = dates.format(date);
}
