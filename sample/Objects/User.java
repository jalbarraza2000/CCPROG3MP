package sample.Objects;

import java.util.ArrayList;

/** The class User represents a User object that has an arraylist of Parcels
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class User
{

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        parcels = new ArrayList<Parcel>();
        parcelIndex = 0;
    }

    public void addParcel(Parcel p)
    {
        parcels.add(p);
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public ArrayList<Parcel> getParcels()
    {
        return parcels;
    }

    public int getParcelIndex()
    {
        return parcelIndex;
    }

    public void setParcelIndex(int parcelIndex)
    {
        this.parcelIndex = parcelIndex;
    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    private String username;
    private String password;
    private ArrayList<Parcel> parcels;
    private int parcelIndex;
}
