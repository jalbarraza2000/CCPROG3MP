package sample.Objects;

import java.util.ArrayList;

/** The class Tracking represents a Tracking object with the tracking number of a parcel,
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class Tracking
{

    /**
     * This constructor accepts the current date
     * @param Date a String variable that represents the current date
     */
    public Tracking(String Date)
    {
        trackingNum = new ArrayList<String>();
        destCodeList = new ArrayList<String>();
        this.Date = Date;
    }

    /**
     * This constructor accepts the destination of the parcel, the type of the parcel and the date
     * @param destination a String variable that represents the destination fo the parcel
     * @param parcelType an integer variable that represents the type of the parcel
     * @param Date a String variable that represents the current date
     */
    public Tracking(String destination, int parcelType, String Date)
    {
        this.destination = destination;
        this.trackingNumber = trackingNumber;
        this.parcelType = parcelType;
        this.Date = Date;
        trackingNum = new ArrayList<String>();
        destCodeList = new ArrayList<String>();
        this.status = "Preparing";
    }

    /**
     * This methods returns the status of the parcel with the tracking number specified
     * @param trackingNumber a string variable representing the tracking number of a parcel
     * @param j an ArrayList of Parcels
     * @return the status of the parcel with the specific trackingNumber
     */
    public String findTrackingNum(String trackingNumber,  ArrayList<Parcel> j)
    {
        for (int i = 0; i < j.size(); i++)
        {
            if (trackingNumber.equalsIgnoreCase(j.get(i).tracking.getTrackingNumber()))
            {
                return j.get(i).tracking.status;
            }
        }

        return j.get(0).tracking.status;
    }

    /**
     * This method assigns and returns the status of a parcel
     * @param day an integer variable that represents the current day
     * @param dayMadeList an integer variable that represents the day the parcel was made
     * @param returnDescode an ArrayList of of String
     * @param j an ArrayList of Parcel
     * @param counter2 a non-negative integer value
     * @return status of the parcel
     */

    /*
        This method uses the dayMade, and the current day in determining the status of a Parcel. It compares using the
        Destination Code found in the parcel.
     */

    public String getStatus(int day,int dayMadeList, ArrayList<String> returnDescode, ArrayList<Parcel> j,int counter2)
    {
        ArrayList<Integer> counter = new ArrayList<>();
                if(counter2==0)
                {
                     counter.add(0);
                    if (counter.get(0) > 1)
                    {
                        if (dayMadeList <= day - 1 && returnDescode.get(0).equalsIgnoreCase("MNL"))
                        {
                            j.get(0).tracking.status = "Delivered";
                            return  j.get(0).tracking.status;
                        }

                        else if (dayMadeList <= day - 2 && returnDescode.get(0).equalsIgnoreCase("LUZ") && day != 1)
                        {
                            j.get(0).tracking.status = "Delivered";
                            return  j.get(0).tracking.status;
                        }

                        else if (dayMadeList <= day - 4 && returnDescode.get(0).equalsIgnoreCase("VIS") && day != 1)
                        {
                            j.get(0).tracking.status = "Delivered";
                            return  j.get(0).tracking.status;
                        }

                        else if (dayMadeList <= day - 7 && returnDescode.get(0).equalsIgnoreCase("MIN") && day != 1)
                        {
                            j.get(0).tracking.status = "Delivered";
                            return  j.get(0).tracking.status;
                        }

                        else if (day== dayMadeList)
                        {
                            j.get(0).tracking.status = "Preparing";
                            return  j.get(0).tracking.status;
                        }

                        else
                        {
                            j.get(0).tracking.status = "Shipping";
                            return  j.get(0).tracking.status;
                        }
                    }

                    else
                    {
                        if (dayMadeList <= day - 1 && returnDescode.get(0).equalsIgnoreCase("MNL"))
                        {
                            j.get(0).tracking.status = "Delivered";
                            return  j.get(0).tracking.status;
                        }

                        else if (dayMadeList <= day - 2 && returnDescode.get(0).equalsIgnoreCase("LUZ") && day != 1)
                        {
                            j.get(0).tracking.status = "Delivered";
                            return  j.get(0).tracking.status;
                        }

                        else if (dayMadeList <= day - 4 && returnDescode.get(0).equalsIgnoreCase("VIS") && day != 1)
                        {
                            j.get(0).tracking.status = "Delivered";
                            return  j.get(0).tracking.status;
                        }

                        else if (dayMadeList <= day - 7 && returnDescode.get(0).equalsIgnoreCase("MIN") && day != 1)
                        {
                            j.get(0).tracking.status = "Delivered";
                            return  j.get(0).tracking.status;
                        }

                        else if (day== dayMadeList)
                        {
                            j.get(0).tracking.status = "Preparing";
                            return  j.get(0).tracking.status;
                        }

                        else
                        {
                            j.get(0).tracking.status = "Shipping";

                        }

                        counter.set(0, counter.get(0) + 1);
                        return  j.get(0).tracking.status;
                    }
        }

        else
        {
            counter.add(0);

            if (counter.get(0) > 1)
            {
                if (dayMadeList <= day - 1 && returnDescode.get(counter2).equalsIgnoreCase("MNL"))
                {
                    j.get(counter2).tracking.status = "Delivered";
                    return  j.get(counter2).tracking.status;
                }

                else if (dayMadeList <= day - 2 && returnDescode.get(counter2).equalsIgnoreCase("LUZ") && day != 1)
                {
                    j.get(counter2).tracking.status = "Delivered";
                    return  j.get(counter2).tracking.status;
                }

                else if (dayMadeList <= day - 4 && returnDescode.get(counter2).equalsIgnoreCase("VIS") && day != 1)
                {
                    j.get(counter2).tracking.status = "Delivered";
                    return  j.get(counter2).tracking.status;
                }

                else if (dayMadeList <= day - 7 && returnDescode.get(counter2).equalsIgnoreCase("MIN") && day != 1)
                {
                    j.get(counter2).tracking.status = "Delivered";
                    return  j.get(counter2).tracking.status;
                }

                else
                {
                    j.get(counter2).tracking.status = "Shipping";
                    return  j.get(counter2).tracking.status;
                }
            }

            else
            {
                if (dayMadeList <= day - 1 && returnDescode.get(counter2).equalsIgnoreCase("MNL"))
                {
                    j.get(counter2).tracking.status = "Delivered";
                    return  j.get(counter2).tracking.status;
                }

                else if (dayMadeList <= day - 2 && returnDescode.get(counter2).equalsIgnoreCase("LUZ") && day != 1)
                {
                    j.get(counter2).tracking.status = "Delivered";
                    return  j.get(counter2).tracking.status;
                }

                else if (dayMadeList <= day - 4 && returnDescode.get(counter2).equalsIgnoreCase("VIS") && day != 1)
                {
                    j.get(counter2).tracking.status = "Delivered";
                    return  j.get(counter2).tracking.status;
                }

                else if (dayMadeList <= day - 7 && returnDescode.get(counter2).equalsIgnoreCase("MIN") && day != 1)
                {
                    j.get(counter2).tracking.status = "Delivered";
                    return  j.get(counter2).tracking.status;
                }

                else if (day == 1)
                {
                    j.get(counter2).tracking.status = "Preparing";
                    return  j.get(counter2).tracking.status;
                }

                else
                {
                    j.get(counter2).tracking.status = "Shipping";
                }

                counter.set(0, counter.get(0) + 1);
                return  j.get(counter2).tracking.status;
            }
        }
    }

    /**
     * This method returns the date
     * @return the date
     */
    public String getDate()
    {
        return  Date;
    }

    /**
     * This method creates and sets the tracking number to a parcel
     * @param code a string variable that represents the packaging code
     * @param itemFormat a string variable
     * @param parcelFormat  a string variable
     * @param dCode a string variable that represents the destination code
     */
    public void setTrackingNumber(String code,String itemFormat, String parcelFormat, String dCode)
    {
        this.trackingNumber = code + getDate() + dCode + itemFormat + parcelFormat;
        trackingNum.add(trackingNumber);
    }

    /**
     * This method returns the tracking number of a parcel
     * @return Tracking number of a parcel
     */
    public String getTrackingNumber()
    {
        return trackingNumber;
    }

    /**
     * This method returns the status of a parcel
     * @return status of the parcel
     */
    public String ifDelivered()
    {
        return status;
    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    private String destination;
    private String trackingNumber;
    private String destCode;
    private String parcelCode;
    public String status;
    private ArrayList<String> trackingNum;
    private ArrayList<String> destCodeList;
    private int parcelType;
    private String Date;

}
