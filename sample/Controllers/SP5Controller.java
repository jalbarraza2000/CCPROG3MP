package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/** The class SP5Controller controls the Price Breakdown
 * It extends from MainController
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class SP5Controller extends MainController implements Initializable
{
    /**
     * This method sets a specific number to a specific parcel
     */

    /*
        At this point in the program, the parcel created is final, and so it will be added onto the ArrayList<Parcel>
        of the User. After this, necessary information will be generated such as it's parcelnumber within the User's Array
        List, the ParcelIndex will increase, ParcelNumberFormat is generated, and finally the tracking number is generated
     */

    public void setParcelNumber() {

        int parcelIndex= model.getUsers().get(model.getUserIndex()).getParcelIndex();

        model.getUsers().get(model.getUserIndex()).addParcel(model.getParcel());
        model.getUsers().get(model.getUserIndex()).getParcels().get(model.getUsers().get(model.getUserIndex()).getParcelIndex()).setParcelNum(parcelIndex);
        System.out.println(model.getUsers().get(model.getUserIndex()).getParcels().get(model.getUsers().get(model.getUserIndex()).getParcelIndex()).getParcelNum());
        model.getUsers().get(model.getUserIndex()).setParcelIndex(model.getUsers().get(model.getUserIndex()).getParcelIndex() + 1);
        model.setParcelNumberFormat(formatter2.format(model.getUsers().get(model.getUserIndex()).getParcelIndex()));
        model.getUsers().get(model.getUserIndex()).getParcels().get(model.getUsers().get(model.getUserIndex()).getParcelIndex() - 1).
                tracking.setTrackingNumber(model.getPackStr(),model.getItemNumberFormat(),model.getParcelNumberFormat(), model.getDestCode());

    }

    /**
     * This method initializes the price of the parcel
     */

    /*
        This method calculates the insurance fee, then displays it, calculates for the intial price without delivery fee,
        then displays it, and does the same procedure for the final price and the delivery fee.
        The initial update date and tracking number is also shown
     */
    public void initializePrice()
    {
        double initialprice, insurancefee, finalprice;


       insurancefee =  model.getUsers().get(model.getUserIndex()).getParcels().
                get(model.getUsers().get(model.getUserIndex()).getParcelIndex() - 1).getInsuranceFee();

       insuranceFee.setText(Double.toString(insurancefee));

         model.getUsers().get(model.getUserIndex()).getParcels().get(model.getUsers().
                get(model.getUserIndex()).getParcelIndex() - 1).setPrice(model.getPackInt());

        initialprice = model.getUsers().get(model.getUserIndex()).getParcels().
                get(model.getUsers().get(model.getUserIndex()).getParcelIndex() - 1).getPrice();

        initialPrice.setText(Double.toString(initialprice));

        model.getUsers().get(model.getUserIndex()).getParcels().get(model.getUsers().
                get(model.getUserIndex()).getParcelIndex() - 1).finalPrice();

        finalprice = (model.getUsers().get(model.getUserIndex()).getParcels().
                get(model.getUsers().get(model.getUserIndex()).getParcelIndex() - 1).getPrice());

        totalPrice.setText(Double.toString(finalprice));

        deliveryFee.setText(Double.toString(finalprice - initialprice - insurancefee));

        trackingNumber.setText(model.getUsers().get(model.getUserIndex()).getParcels().get(model.getUsers().get(model.getUserIndex()).getParcelIndex() - 1).tracking.getTrackingNumber());
        System.out.println(model.getUsers().get(model.getUserIndex()).getParcels().get(model.getUsers().get(model.getUserIndex()).getParcelIndex() - 1).tracking.getTrackingNumber());

        System.out.println(model.getUsers().get(model.getUserIndex()).getParcels().
                get(model.getUsers().get(model.getUserIndex()).getParcelIndex()-1).tracking.getStatus(model.getDay(),
                model.getUsers().get(model.getUserIndex()).getParcels().get(model.getUsers().get(model.getUserIndex()).getParcelIndex()-1).getDayMade(),
                model.getCodeList(), model.getUsers().get(model.getUserIndex()).getParcels(), model.getCounter2()));

        model.setCounter2(model.incrementCounter2(model.getCounter2()));

        model.getUsers().get(model.getUserIndex()).getParcels().get(model.getUsers().get(model.getUserIndex()).getParcelIndex() - 1).setUpdateDate(model.getDate().getTime());

        System.out.println(dates2.format(model.getUsers().get(model.getUserIndex()).getParcels().get(model.getUsers().get(model.getUserIndex()).getParcelIndex() - 1).getUpdateDate()));
    }




    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    @FXML private Label initialPrice, deliveryFee, insuranceFee, totalPrice,trackingNumber;
    private DecimalFormat formatter2 = new DecimalFormat("000");
    private SimpleDateFormat dates2 = new SimpleDateFormat("MM/dd/yyy");
}
