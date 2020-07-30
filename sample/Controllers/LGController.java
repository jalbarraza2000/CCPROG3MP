package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/** The class LGController controls the Login screen
 * It extends from MainController
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class LGController extends MainController implements Initializable
{
    @FXML
    /**
     * This method accepts the input of the user, and switches scene to mainmenu if the data entered is valid
     */
    public void submitData()
    {
        for(int i = 0; i < model.getUsers().size(); i++)
        {
            if (username.getText().equalsIgnoreCase(model.getUsers().get(i).getUsername()))
            {
                if(password.getText().equalsIgnoreCase(model.getUsers().get(i).getPassword()))
                {
                    model.setUserIndex(i);
                    switcher.switchScene(submitButton, "FXMLs/mainmenu", model);

                }
            }
        }
    }

    /**
     * This method switches the scene to LG2
     */
    @FXML
    public void newUserScene()
    {
        switcher.switchScene(newUser, "FXMLs/LG2", model);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    @FXML private Button newUser, submitButton;
    @FXML private TextField username, password;
}