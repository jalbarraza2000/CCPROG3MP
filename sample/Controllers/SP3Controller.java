package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

/** The class SP3Controller controls the Parcel Summary
 * It extends from MainController
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class SP3Controller extends MainController implements Initializable{
    /**
     * This method sets the components of the indicated labels
     */
    public void setLabels()
    {

        calculateMax();

        numItems.setText(Integer.toString(model.getMaxNumItem()));

        length.setText(Double.toString(model.getParcel().getLengthCapacity()));
        width.setText(Double.toString(model.getParcel().getWidthCapacity()));
        weight.setText(Double.toString(model.getParcel().getWeightCapacity()));
        height.setText(Double.toString(model.getParcel().getHeightCapacity()));

    }

    /**
     * This method calculates the maximum dimension the specific parcel can hold
     */
    public void calculateMax()
    {

        model.getParcel().getMaxHeight();
        model.getParcel().getMaxLength();
        model.getParcel().getMaxWeight();
        model.getParcel().getMaxWidth();
    }

    /**
     * This method switches scene to SP4
     */
    @FXML
    public void checkParcel()
    {
        switcher.switchScene(finishButton, "FXMLs/SP4", model);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    @FXML private Button finishButton;
    @FXML private Label numItems, length, width, weight, height;

}
