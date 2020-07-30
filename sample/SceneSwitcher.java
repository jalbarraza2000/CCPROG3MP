package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Controllers.*;
import java.io.IOException;

/** The class SceneSwitcher is a Utility Class that switches scene when an button is clicked
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class SceneSwitcher
{

    public void switchScene(Button button, String name, Model model)
    {
        Stage stage;
        Parent root = null;

        stage = (Stage) button.getScene().getWindow();
        try
        {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(name + ".fxml"));

            root = loader.load();

            /*
                These lines of code adds as a setter for the model. Enabling the model to be passed through the
                different scenes, if not for these codes, each scene would have different model objects and would not
                be updated
             */

            if(name.equalsIgnoreCase("FXMLs/SP1"))
            {
                SP1Controller controller = loader.getController();
                controller.setModel(model);
            }

            else if (name.equalsIgnoreCase("FXMLs/SP8"))
            {
                SP8Controller controller = loader.getController();
                controller.setModel(model);
            }

            else if(name.equalsIgnoreCase("FXMLs/SP2"))
            {
                SP2Controller controller = loader.getController();
                controller.setModel(model);
                controller.displayItemNum(model.getCounter() + 1);
            }

            else if (name.equalsIgnoreCase("FXMLs/SP3"))
            {
                SP3Controller controller = loader.getController();
                controller.setModel(model);
                controller.setLabels();
            }

            else if (name.equalsIgnoreCase("FXMLs/LG"))
            {
                LGController controller = loader.getController();
                controller.setModel(model);
            }

            else if (name.equalsIgnoreCase("FXMLs/LG2"))
            {
                LG2Controller controller = loader.getController();
                controller.setModel(model);
            }

            else if(name.equalsIgnoreCase("FXMLs/mainmenu"))
            {
                Controller controller = loader.getController();
                controller.setModel(model);
                controller.displayName();
            }

            else if (name.equalsIgnoreCase("FXMLs/SP4"))
            {
                SP4Controller controller = loader.getController();
                controller.setModel(model);
                controller.checkFlats();
                controller.checkBox();
            }

            else if (name.equalsIgnoreCase("FXMLs/SP5"))
            {
                SP5Controller controller = loader.getController();
                controller.setModel(model);
                controller.setParcelNumber();
                controller.initializePrice();
            }

            else if (name.equalsIgnoreCase("FXMLs/SP9"))
            {
                SP9Controller controller = loader.getController();
                controller.setModel(model);
            }

            else if (name.equalsIgnoreCase("FXMLs/RG"))
            {
                RGController controller = loader.getController();
                controller.setModel(model);
                controller.addObservableList();
            }

        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}