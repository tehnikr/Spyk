package SpykWin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import Spyk.SpykUser;

/**
 *
 * @author Tehnikr
 */
public class SpykWinKont {

    int id;
    String nickName;
    Button nameBtn;
    Button msgOtprBtn;
    Tab tabKont;
    String messageTxt;
    TextField msgTF;
    SpykUser hM;

    VBox mTab;

    TextArea dialogTF;

    SpykWinKont(SpykUser h){
        hM = h;
        id = h.getId();
        nickName = h.getNickName();
        nameBtn = new Button(nickName);
    }

    Button getBtn(){
        return nameBtn;
    }

    void tabInit(SpykChatCoreWin SCMCore){
        messageTxt = "гы-гы";

        mTab = new VBox();
        dialogTF = new TextArea();
        msgTF = new TextField();

        msgOtprBtn = new Button("Отправить");

        msgOtprBtn.setOnAction((ActionEvent event) -> {
            messageTxt = msgTF.getText();
            msgTF.clear();
            System.out.println(SCMCore.myName.getUserName() + " говорит: " + messageTxt);
            dialogTF.appendText(SCMCore.myName.getUserName() +  ": " + messageTxt + "\n");

            SCMCore.addMsg(SCMCore.myName, hM, messageTxt);
        });

        tabKont = new Tab(nickName, mTab);

        mTab.getChildren().add(dialogTF);
        mTab.getChildren().add(msgTF);
        mTab.getChildren().add(msgOtprBtn);

    }


    String getName() {
        return nickName;
    }

    Tab getTab(SpykChatCoreWin SCMCore){
        tabInit(SCMCore);
        return tabKont;
    }

    public void refr (String qq){
        dialogTF.appendText("\n" + qq + "\n");
    }

    TextField getMsgTF(){
        return msgTF;
    }

    SpykUser getThisSpykUser (){
        return hM;
    }
}
