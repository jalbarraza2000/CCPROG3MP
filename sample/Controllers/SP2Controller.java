package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import sample.Objects.Document;
import sample.Objects.Parcel;
import sample.Objects.Product;
import sample.Objects.irregularShapedProduct;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/** The class SP2Controller controls the Item input screen
 * It extends from MainController
 @author Christian Tan and Jeric Barraza
 @version 1.0
 */

public class SP2Controller extends MainController implements Initializable
{

    /**
     * This method displays the folowins labels based on the boolean value , " value:
     * @param value a boolean value
     */
    public void setDocuVisible(boolean value)
    {
        DocuSpec.setVisible(value);
        DocuDescp.setVisible(value);
        pageSpec.setVisible(value);
        pglengthSpec.setVisible(value);
        pgwidthSpec.setVisible(value);
    }

    /**
     * This method displays the item number
     * @param counter specific number of each item
     */
    public void displayItemNum(int counter)
    {
        itemNum.setText((formatter.format(counter)));
        model.setItemNumberFormat(formatter.format(counter));
    }
    /**
     * This method displays the folowins labels based on the boolean value , " value:
     * @param value a boolean value
     */
    public void setProdElementsVisible(boolean value)
    {
        ProdSpec.setVisible(value);
        ProdVal1.setVisible(value);
        ProdVal2.setVisible(value);
        ProdVal3.setVisible(value);
        ProdVal4.setVisible(value);

    }


    /**
     * This method gets the input that the user has entered and switches scene
     * @throws Exception an Exception class
     */

    /*
        This method has two functions. First, it will check the max number of items inputted by the user in the previous
        scene, and then loops through using a counter. If the counter does not reach the maximum number of items, the
        method will allow for an entry of items, and it will call the same scene again for another input of item.
        If the max num item is met, it will generate information before switching to the next scene
     */
    @FXML
    public void refresh() throws Exception
    {
        try {
            if (model.getMaxNumItem() > model.getCounter()) {

                if (itemType.getValue().toString().equalsIgnoreCase("Document")) {
                    Document doc = new Document(Integer.parseInt(pageSpec.getText()), Double.parseDouble(pglengthSpec.getText()),
                            Double.parseDouble(pgwidthSpec.getText()));
                    model.addItems(doc);
                }

                if (itemType.getValue().toString().equalsIgnoreCase("Product")) {
                    Product prod = new Product(Double.parseDouble(ProdVal1.getText()), Double.parseDouble(ProdVal2.getText()),
                            Double.parseDouble(ProdVal3.getText()), Double.parseDouble(ProdVal4.getText()));
                    model.addItems(prod);
                }

                if (itemType.getValue().toString().equalsIgnoreCase("Irregular Shaped Product")) {
                    irregularShapedProduct ISP = new irregularShapedProduct(Double.parseDouble(ProdVal1.getText()), Double.parseDouble(ProdVal2.getText()),
                            Double.parseDouble(ProdVal3.getText()), Double.parseDouble(ProdVal4.getText()));
                    model.addItems(ISP);
                }

                j = model.getCounter() + 1;
                model.setCounter(j);

                if (model.getMaxNumItem() > model.getCounter())
                    switcher.switchScene(submitButton, "FXMLs/SP2", model);

            }

            if (model.getMaxNumItem() == model.getCounter()) {
                System.out.println(model.getItems().size());
                Parcel j = new Parcel(model.getRecipient(), model.getDestination(), model.getItems(), model.getMaxNumItem());
                model.setCounter(0);
                model.setParcel(j);
                model.getParcel().setDayMade(model.getDay());

                switcher.switchScene(submitButton, "FXMLs/SP3", model);
            }
        }catch (NumberFormatException a)
        {
            throw new Exception("Invalid input!");
        }
    }

    /**
     * Sets specific labels to visible, depending on the input value
     */
    @FXML
    public void showSpec()
    {

        if(itemType.getValue().toString().equalsIgnoreCase("Document"))
        {
            setProdElementsVisible(false);
            ProdDescp.setVisible(false);
            ISPDescp.setVisible(false);
            setDocuVisible(true);
        }
        else if(itemType.getValue().toString().equalsIgnoreCase("Product"))
        {
            setDocuVisible(false);
            ISPDescp.setVisible(false);
            ProdDescp.setVisible(true);
            setProdElementsVisible(true);
        }
        else
        {
            setDocuVisible(false);
            ISPDescp.setVisible(true);
            ProdDescp.setVisible(false);
            setProdElementsVisible(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        ProdDescp.setVisible(false);
        ISPDescp.setVisible(false);
        setProdElementsVisible(false);
        setDocuVisible(false);
        itemNum.setVisible(true);
        itemType.setItems(types);
    }

    /*
        These attributes are private to this specific controller as it is only used here
     */

    @FXML private ComboBox itemType;
    @FXML private ImageView DocuSpec, DocuDescp, ProdDescp, ISPDescp, ProdSpec;
    @FXML private TextField pageSpec, pglengthSpec, pgwidthSpec, ProdVal1, ProdVal2, ProdVal3, ProdVal4;
    @FXML private Label itemNum;
    @FXML private Button submitButton;
    private DecimalFormat formatter = new DecimalFormat("00");
    private DecimalFormat formatter2 = new DecimalFormat("000");
    private int j;
    private ObservableList<String> types = FXCollections.observableArrayList("Document", "Product",
            "Irregular Shaped Product");
}
