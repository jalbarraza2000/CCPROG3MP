package sample;

import sample.Objects.Item;
import sample.Objects.Parcel;
import sample.Objects.User;

import java.util.ArrayList;
import java.util.Calendar;

/** The class Model houses all the data that runs through the program.
 * It is passed between scenes
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class Model
{

    /**
     * A blank constructor for the class Model
     */
    public Model()
    {

    }

    /**
     * This method returns the recipient of the parcel
     * @return recipient of the parcel
     */
    public String getRecipient()
    {
        return recipient;
    }

    /**
     * This method returns the destination of the parcel
     * @return destination of the parcel
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * This method returns the maximum number of items the parcel can hold
     * @return the maximum number of items the parcel can hold
     */
    public int getMaxNumItem()
    {
        return maxNumItem;
    }

    /**
     * This method sets the variable recipient as the recipient of the parcel
     * @param recipient a String variable
     */
    public void setRecipient(String recipient)
    {
        this.recipient = recipient;
    }

    /**
     * This method sets the variable destination as the destination of the parcel
     * @param destination a String variable
     */
    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    /**
     * This method sets the maximum number of items the parcel can hold
     * @param maxNumItem a positive integer
     */
    public void setMaxNumItem(int maxNumItem)
    {
        this.maxNumItem = maxNumItem;
    }

    /**
     * This method returns the counter
     * @return counter
     */
    public int getCounter()
    {
        return counter;
    }

    /**
     * This method sets the counter variable as the counter
     * @param counter a non-negative integer
     */
    public void setCounter(int counter)
    {
        this.counter = counter;
    }

    /**
     * This method adds the item I to the arrayList of items
     * @param i an Item object
     */
    public void addItems(Item i)
    {
        items.add(i);
    }

    /**
     * This method returns the arrayList of items
     * @return arrayList of Items
     */
    public ArrayList<Item> getItems()
    {
        return this.items;
    }

    /**
     * This method returns the arrayList of the users
     * @return arrayList of the users
     */
    public ArrayList<User> getUsers()
    {
        return users;
    }

    /**
     * This method returns the index of the current user
     * @return index of the current user
     */
    public int getUserIndex()
    {
        return userIndex;
    }

    /**
     * This method sets the variable userIndex as the index of the current user
     * @param userIndex a non-negative integer
     */
    public void setUserIndex(int userIndex)
    {
        this.userIndex = userIndex;
    }

    /**
     * This method sets the destination code according to the variable destination
     * @param destination a String variable
     */
    public void setDestCode(String destination)
    {
        if(destination.equalsIgnoreCase("Metro Manila"))
        {
            this.destCode="MNL";
            destCodeList.add(this.destCode);
        }
        else if(destination.equalsIgnoreCase("Provincial Luzon"))
        {
            this.destCode="LUZ";
            destCodeList.add(this.destCode);

        }
        else if(destination.equalsIgnoreCase("Visayas"))
        {
            this.destCode="VIS";
            destCodeList.add(this.destCode);
        }
        else if(destination.equalsIgnoreCase("Mindanao"))
        {
            this.destCode="MIN";
            destCodeList.add(this.destCode);
        }
    }

    /**
     * This method returns the destination code
     * @return destination code
     */
    public String getDestCode()
    {
        return destCode;
    }

    /**
     * This method returns the code of the chosen packaging
     * @return code of the chosen packaging
     */
    public String getPackStr()
    {
        return pack;
    }

    /**
     * This method returns the integer value corresponding to the type of packaging used
     * @return integer value corresponding to the type of packaging used
     */
    public int getPackInt()
    {
        return packInt;
    }

    /**
     * This method sets the variable packInt as the integer corresponding to a type of package used
     * @param packInt a non-negative integer corresponding to a type of packaging
     */
    public void setPackInt(int packInt)
    {
        this.packInt = packInt;
    }

    /**
     * This methods sets the variable pack as the code for the specific packaging used
     * @param pack a String variable
     */
    public void setPackStr(String pack)
    {
        this.pack = pack;
    }

    /**
     * This method sets the variable inputTrackingNum as the inputTrackingNum
     * @param inputTrackingNum a String variable
     */
    public void inputTrackingNum(String inputTrackingNum)
    {
        this.inputTrackingNum = inputTrackingNum;
    }

    /**
     * This method returns the index of a specific parcel, given its trackingNumber
     * @param trackingNumber a String variable
     * @param j an ArrayList of Parcels
     * @return the index of the parcel
     */
    public int getIndex(String trackingNumber,ArrayList<Parcel> j)
    {
        int i =0;
        while(i<j.size())
        {
            if(trackingNumber.equalsIgnoreCase(j.get(i).tracking.getTrackingNumber()))
                return i;
            else
                i++;
        }
        return i;
    }

    /**
     * This method sets the variable num as counter2
     * @param num a non-negative integer value
     */
    public void setCounter2(int num)
    {
        this.counter2 = num;
    }

    /**
     * This method returns the counter 2 variable
     * @return the counter 2 variable
     */
    public int getCounter2()
    {
       return counter2;
    }

    /**
     * This method increments the variable counter and returns it
     * @param counter a non-negative integer value
     * @return counter
     */
    public int incrementCounter2(int counter)
    {
        counter++;
        return counter;
    }

    /**
     * This method returns the ArrayList of Strings destCodeList which holds the destination codes
     * @return  the ArrayList of Strings destCodeList which holds the destination codes
     */
    public ArrayList<String> getCodeList()
    {
        return destCodeList;
    }

    /**
     * This method sets the variable inputPassword as the inputPassword
     * @param inputPassword a String variable
     */
    public void setInputPassword(String inputPassword)
    {
        this.inputPassword = inputPassword;
    }

    /**
     * This method returns the input password
     * @return the input password
     */
    public String getInputPassword()
    {
        return inputPassword;
    }

    /**
     * This method returns the current day
     * @return current day
     */
    public int getDay()
    {
        return this.day;
    }

    /**
     * This method sets the variable day as the current day
     * @param day a positive integer
     */
    public void setDay(int day)
    {
        this.day = day;
    }

    /**
     * This method returns the parcelNumberFormat
     * @return returns the parcelNumberFormat
     */
    public String getParcelNumberFormat()
    {
        return parcelNumberFormat;
    }

    /**
     * This method sets the variable parcelNumberFormat as the parcelNumberFormat
     * @param parcelNumberFormat a String variable
     */
    public void setParcelNumberFormat(String parcelNumberFormat)
    {
        this.parcelNumberFormat = parcelNumberFormat;
    }

    /**
     * This method returns the itemNumberFormat
     * @return the itemNumberFormat
     */
    public String getItemNumberFormat()
    {
        return itemNumberFormat;
    }
    /**
     * This method sets the variable itemNumberFormat as the itemNumberFormat
     * @param itemNumberFormat a String variable
     */
    public void setItemNumberFormat(String itemNumberFormat)
    {
        this.itemNumberFormat = itemNumberFormat;
    }

    /**
     * This method returns the tracking numer
     * @return the tracking number
     */
    public String getTrackingNum()
    {
        return inputTrackingNum;
    }

    /**}
     * This method returns the date
     * @return the date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * This method sets the date as the date
     * @param date a calendar object
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * This methods returns a Parcel object
     * @return a Parcel object
     */
    public Parcel getParcel() {
        return parcel;
    }

    /**
     * This method sets the variable parcel, as the parcel
     * @param parcel a Parcel object
     */
    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    private String inputTrackingNum;
    private String recipient;
    private String destination;
    private String destCode;
    private ArrayList<String> destCodeList = new ArrayList<>();
    private int maxNumItem;
    private int counter2;
    private int counter = 0, packInt;
    private int userIndex;
    private String pack;
    private Parcel parcel;
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<User> users = new ArrayList<User>();
    private String itemNumberFormat;
    private String parcelNumberFormat;
    private String inputPassword;
    private Calendar date = Calendar.getInstance();
    private int day = 1;
}
