package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import sample.Model;
import sample.SceneSwitcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/** The class SP1Controller controls the input name and destination
 * It extends from MainController
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class SP1Controller extends MainController implements Initializable
{

    /**
     * This method stores the input data entered by the user and switches scene to SP2
     * @throws Exception a NumberFormatExecption
     */
    @FXML
    public void nextPage() throws Exception {
        try {
            model.setMaxNumItem(Integer.parseInt(numItems.getText()));
            model.setDestination(locationRegion.getValue().toString());
            model.setDestCode(model.getDestination());
            model.setRecipient(nameField.getText());
            switcher.switchScene(submitButton, "FXMLs/SP2", model);
        }
        catch (NumberFormatException a){
            throw new  Exception("Invalid data entered");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        locationRegion.setValue("Select Region");
        locationRegion.setItems(regions);
    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    @FXML private ComboBox locationRegion;
    @FXML private Button submitButton;
    @FXML private TextField numItems, nameField;
    private ObservableList<String> regions = FXCollections.observableArrayList("Metro Manila", "Provincial Luzon",
            "Visayas", "Mindanao");

}
