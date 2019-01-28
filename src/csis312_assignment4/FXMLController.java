/*
 * Controller for Shopping List Example (ws)
 */
package csis312_assignment4;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/* CSIS 312 Assignment 4
* @Isaac Craig & Nick Romnano
* 
* - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
* - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
* - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted *   with a proper citation in the comments of my program. 
* - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce     apparently correct results when in fact it does not.
*
**/
public class FXMLController implements Initializable {
    AddressBookModel myList;

    @FXML
    private TableView<Address> addressTable;
    
    @FXML
    private TextField lastField;

    @FXML
    private TextField birthdayField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField stateField;

    @FXML
    private TextField zipField;

    @FXML
    private TextField firstField;

    @FXML
    private Button buttonClear;

    @FXML
    private Button buttonFind;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonOpen;

    @FXML
    private TableColumn<?, ?> firstColumn;

    @FXML
    private TableColumn<?, ?> lastColumn;

    @FXML
    private TableColumn<?, ?> birthdayColumn;

    @FXML
    private TableColumn<?, ?> addressColumn;

    @FXML
    private TableColumn<?, ?> stateColumn;

    @FXML
    private TableColumn<?, ?> zipColumn;

    @FXML
    private AnchorPane anchorPane;

    //FXMLController(String AddressBookGUIfxml) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    /**
     * Add or modify shopping list Address when update button is pressed
     * @param event 
     */
    @FXML
    void handleButtonUpdate(ActionEvent event) {
        Address i = new Address(firstField.getText(),lastField.getText(),
        birthdayField.getText(),addressField.getText(), stateField.getText(), zipField.getText());
        myList.addAddress(i);
        updateDisplay();
        clearFields();
        addressField.requestFocus();
        updateDisplay();
    }

    /**
     * Removes shopping list Addresses with matching description
     * @param event 
     */
    @FXML
    void handleButtonDelete(ActionEvent event) {
        Address i = new Address(firstField.getText(),lastField.getText(),
        birthdayField.getText(),addressField.getText(), stateField.getText(), zipField.getText());
        myList.removeAddress(i);
        updateDisplay();
        clearFields();
    }

    /**
     * Finds shopping list Addresses based on the description
     * @param event 
     */
    @FXML
    void handleButtonFind(ActionEvent event) {
        Address i = new Address(firstField.getText(),lastField.getText());
        List<Address> l = myList.findFirstLast(i);
        addressTable.getItems().setAll(l);
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myList = new AddressBookModel();
        myList.loadList();
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("First"));
        lastColumn.setCellValueFactory(new PropertyValueFactory<>("Last"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<>("State"));
        zipColumn.setCellValueFactory(new PropertyValueFactory<>("Zip"));
        updateDisplay();
    }
    

    /**
     * Clears the text fields and updates the display
     * @param event 
     */
    @FXML
    void handleButtonClear(ActionEvent event) {
        clearFields();
        updateDisplay();
    }

    /**
     * Populates the text fields when a row in the table is clicked
     * @param event 
     */
    @FXML
    void handleTableClick(MouseEvent event) {
        Address i = addressTable.getSelectionModel().getSelectedItem();
        if (i != null) {
            addressField.setText(i.getAddress());
            firstField.setText(String.valueOf(i.getFirst()));
            lastField.setText(String.valueOf(i.getLast()));
            birthdayField.setText(String.valueOf(i.getBirthday()));
            stateField.setText(String.valueOf(i.getState()));
            zipField.setText(String.valueOf(i.getZip()));
        }
    }

    /**
     * Intercepts the ENTER key and adds/updates a record if applicable
     * @param event 
     */
    @FXML
    void handleEnterKey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (addressField.getText().length() > 0) {
                Address i = new Address(firstField.getText(),lastField.getText(),
                birthdayField.getText(),addressField.getText(), stateField.getText(), zipField.getText());
                myList.addAddress(i);
                updateDisplay();
                clearFields();
                addressField.requestFocus();
            }
        }
    }
    
    @FXML
    void handleButtonOpen(ActionEvent event){

    }

    /**
     * Updates the display including the total Address count and cost
     */
    private void updateDisplay() {
        addressTable.getItems().setAll(myList.getItems());  
    }

    
    /**
     * Clears the text fields
     */
    private void clearFields() {
        firstField.setText("");
        lastField.setText("");
        birthdayField.setText("");
        addressField.setText("");
        stateField.setText("");
        zipField.setText("");
        
    }
    
}