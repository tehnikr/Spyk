package SpykWin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
 * @author Tehnikr


            To-do: Реализовать меню и панель разработчика
            To-do: Реализовать отправкусообщений в вкладке
 */

public class SpykWin extends Application {

    public SpykChatCoreWin SCMCore;

    @Override
    public void start(Stage primaryStage) {

        SCMCore = new SpykChatCoreWin();

        // Create MenuBar
        MenuBar menuBar = new MenuBar();

        // Create menus
        Menu fileMenu = new Menu("File");
        Menu serverMenu = new Menu("Сервер");
        Menu helpMenu = new Menu("Help");

        // Create MenuItems
        MenuItem newItem = new MenuItem("New");
        MenuItem openFileItem = new MenuItem("Загрузить сообщения из файла");
        MenuItem exitItem = new MenuItem("Exit");
        MenuItem aboutItem = new MenuItem("О программе");


        // Add menuItems to the Menus
        fileMenu.getItems().addAll(newItem, openFileItem, exitItem);

        serverMenu.getItems().addAll(
                (new CoreUserWindow(SCMCore)).getMenuItem(),
                (new CoreMessageWindow(SCMCore)).getMenuItem());

        helpMenu.getItems().addAll(aboutItem);

        // Add Menus to the MenuBar
        menuBar.getMenus().addAll(fileMenu, serverMenu, helpMenu);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);



        VBox kontPan = new VBox ();
        VBox chatPan = new VBox ();


        Label testText = new Label ("Проверка");
        chatPan.getChildren().add(testText);

        HBox hBox = new HBox (kontPan, chatPan);

        Node groupIcon = new ImageView(
                new Image(getClass().getResourceAsStream("myspace.png"))
        );

        Node kontIcon = new ImageView(
                new Image(getClass().getResourceAsStream("technorati.png"))
        );

        TreeItem<String> rootItem1 = new TreeItem<String> ("root");
        rootItem1.setExpanded(true);
        TreeItem<String> userTree = new TreeItem<String> ("Контакты", kontIcon);
        TreeItem<String> chatTree = new TreeItem<String> ("Чаты", groupIcon);
        rootItem1.getChildren().add(userTree);
        rootItem1.getChildren().add(chatTree);
        //rootItem1.addEventHandler();


        SCMCore.getKontListWin().forEach((n)->{
            TreeItem<String> item = new TreeItem<String> (n.getName());
            userTree.getChildren().add(item);
            //item.addEventHandler(EventType.ROOT, eventHandler);
        });

        int sizeOfUserTree = userTree.getChildren().size();

        // Todo По клику в выборе юзера содём объект диалог, в нём храним элементы отправки сообщений...
        // ыва

        // TODO Проверка гитхаба


        for (int i = 1; i < sizeOfUserTree; i++) {
            System.out.println(userTree.getChildren().get(i).getValue());
        }

        TreeView<String> treeKont = new TreeView<String> (rootItem1);

        treeKont.setShowRoot(false);

        MultipleSelectionModel<TreeItem<String>> selModTreeKont = treeKont.getSelectionModel();

        //selModTreeKont

        root.setCenter(hBox);
        Scene scene = new Scene(root,700,300);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        kontPan.getChildren().add(treeKont);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
