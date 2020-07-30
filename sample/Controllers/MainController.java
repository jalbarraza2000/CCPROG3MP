package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Model;
import sample.SceneSwitcher;

/** The class MainController is an abstract class that is a parent class to all controller classes
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public abstract class MainController {
    @FXML protected Button trackButton,  homeButton, sendButton, exitButton;

    /**
     * This method sets the variable model as the model of the program
     * @param model A Model variable
     */
    public void setModel(Model model)
    {
        this.model = model;
    }

    /**
     * This method clears the arrayList of items and switches scene to SP8
     */
    @FXML
    public void goTrack()
    {
        model.getItems().clear();
        switcher.switchScene(trackButton, "FXMLs/SP8", model);
    }
    /**
     * This method clears the arrayList of items and switches scene to main menu
     */
    @FXML
    public void goHome()
    {
        model.getItems().clear();
        System.out.println("Cleared");
        switcher.switchScene(homeButton, "FXMLs/mainmenu", model);
    }
    /**
     * This method clears the arrayList of items and switches scene to SP9
     */
    @FXML
    public void exit()
    {
        model.getItems().clear();
        switcher.switchScene(exitButton, "FXMLs/SP9", model);
    }
    /**
     * This method clears the arrayList of items and switches scene to SP1
     */
    @FXML
    public void sendParcel()
    {
        model.getItems().clear();
        switcher.switchScene(sendButton, "FXMLs/SP1", model);
    }

    /*
        These attributes are protected in order for it's subclasses to inherit them
     */
    
    protected SceneSwitcher switcher = new SceneSwitcher();
    protected Model model = new Model();
}
