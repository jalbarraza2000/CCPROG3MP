package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/** The class SP8Controller controls the Tracking scene
 * It extends from MainController
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */


public class SP8Controller extends MainController implements Initializable
{

    @FXML
    /**
     * This method accepts the tracking number that the user entered  and checks if it is valid, and displays necessary information if the tracking number is valid.
     */

    /*
        This method displays the different values in the parcel. The code seems long because we are accessing specific parcels, which need specific
        identifiers. model.getIndex is used extensively here since it is the method used to get the index of the parcel that is
        being tracked.
     */
    public void enterTrackingNum() throws Exception
    {
        try {
            model.inputTrackingNum(userInputTracking.getText());
            System.out.println("Current Day " + model.getDay());
            System.out.println("Day made " + model.getUsers().get(model.getUserIndex()).getParcels().
                    get(model.getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).getDayMade());


            summary.setVisible(true);

            recipient.setText(model.getUsers().get(model.getUserIndex()).getParcels().get(model.
                    getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).getName());

            destination.setText(model.getUsers().get(model.getUserIndex()).getParcels().get(model.
                    getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).getDestination());

            numItems.setText(Integer.toString(model.getUsers().get(model.getUserIndex()).getParcels().get(model.
                    getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).getMaxNumItems()));

            type.setText(model.getPackStr());

            length.setText(Double.toString(model.getUsers().get(model.getUserIndex()).getParcels().get
                    (model.getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).getLengthCapacity()));
            width.setText(Double.toString(model.getUsers().get
                    (model.getUserIndex()).getParcels().get(model.getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).getWidthCapacity()));

            height.setText(Double.toString(model.getUsers().
                    get(model.getUserIndex()).getParcels().get(model.getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).getHeightCapacity()));

            weight.setText(Double.toString(model.getUsers().
                    get(model.getUserIndex()).getParcels().get(model.getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).getWeightCapacity()));

            System.out.println(model.getUsers().get(model.getUserIndex()).getParcels().
                    get(model.getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).tracking.getStatus(model.getDay(),
                    model.getUsers().get(model.getUserIndex()).getParcels().get(model.getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).getDayMade(), model.getCodeList(),
                    model.getUsers().get(model.getUserIndex()).getParcels(), model.getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())));

            model.getUsers().get(model.getUserIndex()).getParcels().
                    get(model.getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).setUpdateDate(model.getDate().getTime());

            System.out.println(dates2.format(model.getUsers().get(model.getUserIndex()).getParcels().
                    get(model.getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).getUpdateDate()));

            System.out.println(model.getUsers().get(model.getUserIndex()).getParcels().
                    get(model.getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).toString());

            status.setText(model.getUsers().get(model.getUserIndex()).getParcels().get(model.getIndex(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels())).
                    tracking.findTrackingNum(model.getTrackingNum(), model.getUsers().get(model.getUserIndex()).getParcels()));
        }
        catch (IndexOutOfBoundsException a)
        {
            if(model.getCounter2()==0)
            throw new Exception("No parcel has been sent");
            else
                throw new Exception("Invalid tracking number");
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        summary.setVisible(false);

    }
    @FXML private TextField userInputTracking;
    @FXML private ImageView summary;
    @FXML private Label recipient,destination,numItems, type,length,height,width, weight, status;
    private SimpleDateFormat dates2 = new SimpleDateFormat("MM/dd/yyy");
}
