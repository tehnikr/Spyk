/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpykWin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Spyk.SpykUser;

/**
 *
 * @author Tehnikr
 */
public class CoreUserWindow {

    SpykChatCoreWin SCMCore;

    CoreUserWindow (SpykChatCoreWin SCMCore){
        this.SCMCore = SCMCore;
    }

    public MenuItem getMenuItem(){

        MenuItem usertItem = new MenuItem("Пользователи в SCMCore");

        usertItem.setOnAction((ActionEvent event) -> {

            TableView userTab = new TableView<>();

            TableColumn<SpykUser, String> userIdt = new TableColumn<>("User Id");
            userIdt.setCellValueFactory(new PropertyValueFactory<>("userId"));

            TableColumn<SpykUser, String> userNamet = new TableColumn<>("User Name");
            userNamet.setCellValueFactory(new PropertyValueFactory<>("userName"));

            userTab.getColumns().addAll(userIdt, userNamet);
            userTab.setItems(SCMCore.getUlist());

            VBox kontPan = new VBox ();

            kontPan.getChildren().addAll(userTab);

            Scene secondScene = new Scene(kontPan, 500, 400);
            Stage newWindow = new Stage();
            newWindow.setTitle("Пользователи в SCMCore, кол-во: " + SCMCore.getuPlSize());
            newWindow.setScene(secondScene);
            newWindow.show();
        });

        return usertItem;
    }
}
