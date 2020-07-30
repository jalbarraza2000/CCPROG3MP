package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/** The class SP9Controller controls the Exit scene
 * It extends from MainController
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */


public class SP9Controller extends MainController implements Initializable
{
    /**
     * This method accepts the input password from the user, and exits the program if the entered password is valid
     */
    @FXML
    public void refresh()
    {
        model.setInputPassword(inputPassword.getText());
        for(int i=0;i<model.getUsers().size();i++)
        {
            if(model.getInputPassword().equalsIgnoreCase(model.getUsers().get(i).getPassword()))
            {
                System.exit(0);
            }
            else
                System.out.println("No user password exists");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {


    }

    @FXML private TextField inputPassword;
}
