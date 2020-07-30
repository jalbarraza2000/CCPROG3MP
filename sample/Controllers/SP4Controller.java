package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import sample.Objects.Box;
import sample.Objects.Flat;
import java.net.URL;
import java.util.ResourceBundle;

/** The class SP4Controller controls the Parcel Selection
 * It extends from MainController
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class SP4Controller extends MainController implements Initializable
{
    /**
     * This methods checks the flat, and recommends the appropriate parcel size
     */
    public void checkFlats()
    {
        if(model.getParcel().recommendFlat(flats[0]))
      {
                   img1.setVisible(true);
                   fltpouch1.setVisible(true);
                   img7.setVisible(false);
      }

      else
      {
          img1.setVisible(false);
          fltpouch1.setVisible(false);
          img7.setVisible(true);
      }

      if(model.getParcel().recommendFlat(flats[1]))
        {
            img2.setVisible(true);
            fltpouch2.setVisible(true);
            img8.setVisible(false);
        }

        else
        {
            img2.setVisible(false);
            fltpouch2.setVisible(false);
            img8.setVisible(true);
        }
    }
    /**
     * This methods checks the box, and recommends the appropriate parcel size
     */
    public void checkBox()
    {
        if(model.getParcel().recommendBox(boxes[0]))
        {
            img3.setVisible(true);
            bxsmall.setVisible(true);
            img9.setVisible(false);
        }

        else
        {
            img3.setVisible(false);
            bxsmall.setVisible(false);
            img9.setVisible(true);
        }

        if(model.getParcel().recommendBox(boxes[1]))
        {
            img4.setVisible(true);
            bxmed.setVisible(true);
            img10.setVisible(false);
        }

        else
        {
            img4.setVisible(false);
            bxmed.setVisible(false);
            img10.setVisible(true);
        }

        if(model.getParcel().recommendBox(boxes[2]))
        {
            img5.setVisible(true);
            bxLarg.setVisible(true);
            img11.setVisible(false);
        }

        else
        {
            img5.setVisible(false);
            bxLarg.setVisible(false);
            img11.setVisible(true);
        }

        if(model.getParcel().recommendBox(boxes[3]))
        {
            img6.setVisible(true);
            bxXL.setVisible(true);
            img12.setVisible(false);
        }

        else
        {
            img6.setVisible(false);
            bxXL.setVisible(false);
            img12.setVisible(true);
        }
    }

    /**
     * This method sets the type of parcel chosen by the user
     */
    @FXML
    public void selectPressed1()
    {
      if(checkBox.isSelected())
          model.getParcel().setInsured(true);
      else
          model.getParcel().setInsured(false);

        model.setPackStr("FLT");
        model.setPackInt(0);
        switcher.switchScene(fltpouch1, "FXMLs/SP5", model);
    }
    /**
     * This method sets the type of parcel chosen by the user
     */
    @FXML
    public void selectPressed2()
    {
        if(checkBox.isSelected())
            model.getParcel().setInsured(true);
        else
            model.getParcel().setInsured(false);

        model.setPackStr("FLT");
        model.setPackInt(1);
        switcher.switchScene(fltpouch1, "FXMLs/SP5", model);
    }
    /**
     * This method sets the type of parcel chosen by the user
     */
    @FXML
    public void selectPressed3()
    {
        if(checkBox.isSelected())
            model.getParcel().setInsured(true);
        else
            model.getParcel().setInsured(false);

        model.setPackStr("BOX");
        model.setPackInt(2);
        switcher.switchScene(fltpouch1, "FXMLs/SP5", model);
    }
    /**
     * This method sets the type of parcel chosen by the user
     */
    @FXML
    public void selectPressed4()
    {
        if(checkBox.isSelected())
            model.getParcel().setInsured(true);
        else
            model.getParcel().setInsured(false);

        model.setPackStr("BOX");
        model.setPackInt(3);
        switcher.switchScene(fltpouch1, "FXMLs/SP5", model);
    }
    /**
     * This method sets the type of parcel chosen by the user
     */
    @FXML
    public void selectPressed5()
    {
        if(checkBox.isSelected())
            model.getParcel().setInsured(true);
        else
            model.getParcel().setInsured(false);

        model.setPackStr("BOX");
        model.setPackInt(4);
        switcher.switchScene(fltpouch1, "FXMLs/SP5", model);
    }
    /**
     * This method sets the type of parcel chosen by the user
     */
    @FXML
    public void selectPressed6()
    {
     if(checkBox.isSelected())
            model.getParcel().setInsured(true);
        else
            model.getParcel().setInsured(false);

        model.setPackStr("BOX");
        model.setPackInt(5);
        switcher.switchScene(fltpouch1, "FXMLs/SP5", model);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        boxes[0] = new Box(10, 12, 5);
        boxes[1] = new Box(11, 14, 7);
        boxes[2] = new Box(12, 18, 9);
        boxes[3] = new Box(16, 20, 12);

        flats[0] = new Flat(14, 9, 1, 3000, 30);
        flats[1] = new Flat(18, 12, 3, 3000, 50);
    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    @FXML private Button fltpouch1, fltpouch2, bxsmall, bxmed, bxLarg, bxXL;
    @FXML private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12;
    @FXML private CheckBox checkBox;
    private Box[] boxes = new Box[4];
    private Flat[] flats = new Flat[2];


}
