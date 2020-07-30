package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/** The class RGController controls the Report Generation
 * It extends from MainController
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class RGController extends MainController implements Initializable
{

    /**
     * This method creates an observable list and displays it
     */

    /*
        This method loops through the parcel size, and then Updates the Status and UpdateDate of each Parcel in the
        Users ArrayList of Parcels. Then it calls the toString method, which returns a string containing the update date
        and the status, and finally adds it into the ObservableList to show in the ListView
     */
    public void addObservableList()
    {
        for(int i = 0; i < model.getUsers().get(model.getUserIndex()).getParcels().size(); i++)
        {
            model.getUsers().get(model.getUserIndex()).getParcels().get(i).tracking.getStatus(model.getDay(),
                    model.getUsers().get(model.getUserIndex()).getParcels().get(i).getDayMade(), model.getCodeList(),
                    model.getUsers().get(model.getUserIndex()).getParcels(), i);

            model.getUsers().get(model.getUserIndex()).getParcels().
                    get(i).setUpdateDate(model.getDate().getTime());

            stringData.add(model.getUsers().get(model.getUserIndex()).getParcels().get(i).toString());
        }

        ObservableList<String> data = FXCollections.observableList(stringData);
        listView.setItems(data);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    @FXML private ListView listView;
    private ArrayList<String> stringData =  new ArrayList<String>();
}
