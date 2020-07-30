package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Objects.User;
import java.net.URL;
import java.util.*;


/** The class LG2Controller controls the Create User scene
 * It extends from MainController
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class LG2Controller extends MainController implements Initializable
{

    TimerTask task = new TimerTask()
    {
        @Override
        public void run()
        {
            day = day + 1;
            date.add(Calendar.DATE, 1);
            model.setDate(date);
            model.setDay(day);


        }
    };
    Timer timer = new Timer();
    long delay = 10000;
    long intervalPeriod = 10000;

    /**
     * This methods stores the data input of the user, add the user to the arrayList of users and switches scene to LG
     */
    @FXML
    public void submitData()
    {
        User user = new User (username.getText(), password.getText());
        model.getUsers().add(user);
        switcher.switchScene(submitButton, "FXMLs/LG", model);
        model.setCounter2(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        date.setTime(currentDay);
        timer.scheduleAtFixedRate(task, delay,
                intervalPeriod);
    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    @FXML TextField username, password;
    @FXML Button submitButton;
    private int day = 1;
    private Calendar date = Calendar.getInstance();
    private Date currentDay = date.getTime();
}