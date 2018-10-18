package Viewer;

import Controller.DictionaryManagement;
import Models.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditController implements Initializable {

    @FXML
    private Text txtWord;
    @FXML
    private TextField txtPronounce;
    @FXML
    private TextArea txtMeaning;
    @FXML
    private Button jbCancel;
    @FXML
    private Pane rootPane;
    private Word wordToEdit;

    public void setWordToEdit(Word wordToEdit) {
        this.wordToEdit = wordToEdit;
        txtWord.setText(wordToEdit.getWord_target());
        txtPronounce.setText("///");
        txtPronounce.setText(wordToEdit.getWord_explain());
    }

    public  void CloseEditWindow(ActionEvent event)
    {
        Alert close =new Alert(Alert.AlertType.INFORMATION);
        close.setContentText("Thoát");
        Optional<ButtonType> result= close.showAndWait();
        ButtonType button=result.orElse(ButtonType.CANCEL);
        if(button==ButtonType.OK)
        {
            System.out.println("Dong cua so");
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        else
        {
            close.close();
        }
        HomeController.editStage = null;
    }
    @FXML
    public void saveDB(){
        wordToEdit.setWord_explain(txtMeaning.getText());
        DictionaryManagement.getInstance().getDBManager().edit(wordToEdit);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(rootPane.getParent().getUserData() instanceof Word){
            wordToEdit = (Word) txtWord.getParent().getUserData();
        }
    }
}
