package SpykWin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Spyk.SpykMessage;
import Spyk.SpykUser;

/**
 * @author Tehnikr
 */

public class CoreMessageWindow {

    SpykChatCoreWin SCMCore;

    CoreMessageWindow (SpykChatCoreWin SCMCore){
        this.SCMCore = SCMCore;
    }

    public MenuItem getMenuItem(){

        MenuItem msgItem = new MenuItem("Сообщения в SCMCore");

        msgItem.setOnAction((ActionEvent event) -> {

            Label kolMsg = new Label("Количество сообщений: " + SCMCore.getmPlSize());

            TableView msgTab = new TableView<>();

            TableColumn<SpykMessage, String> otprvtName = new TableColumn<>("Отправитель");
            otprvtName.setCellValueFactory(new PropertyValueFactory<>("otprvtNameText"));

            TableColumn<SpykMessage, String> poluchName = new TableColumn<>("Получатель");
            poluchName.setCellValueFactory(new PropertyValueFactory<>("poluchNameText"));

            TableColumn<SpykMessage, String> msgText = new TableColumn<>("Текст сообщения");
            msgText.setCellValueFactory(new PropertyValueFactory<>("messageText"));


            msgTab.getColumns().addAll(otprvtName, poluchName, msgText);
            msgTab.setItems(SCMCore.getMlist());

            VBox kontPan = new VBox ();

            Button addUserB = new Button("AddUserB");

            addUserB.setOnAction((ActionEvent event1) -> {
                SCMCore.addUser(56,"Timur");
            });

            kontPan.getChildren().addAll(kolMsg, msgTab, addUserB);

            Scene secondScene = new Scene(kontPan, 400, 500);
            Stage newWindow = new Stage();
            newWindow.setTitle("Сообщения в SCMCore");
            newWindow.setScene(secondScene);
            newWindow.show();
        });

        return msgItem;
    }
}
