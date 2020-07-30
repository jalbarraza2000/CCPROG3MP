package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/** The class Controller controls the main menu screen
 * It extends from MainController
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class Controller extends MainController implements Initializable
{
    /**
     * This method displays the name of the user
     */

    public void displayName()
    {
        name.setText(model.getUsers().get(model.getUserIndex()).getUsername());
        dayLabel.setText(dates2.format(model.getDate().getTime()));
        System.out.println(model.getDay());
    }

    /**
     * This methods changes the scene to RG.fxml
     */
    @FXML
    public void gotoRG()
    {
        switcher.switchScene(generateReport, "FXMLs/RG", model);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    @FXML private Button generateReport;
    @FXML private Label name, dayLabel;
    private SimpleDateFormat dates2 = new SimpleDateFormat("MM/dd/yyy");

}
