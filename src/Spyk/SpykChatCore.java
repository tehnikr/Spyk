package Spyk;

import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Tehnikr
 */

public class SpykChatCore {

    public ObservableList<SpykUser>             uPl;
    public ObservableList<SpykMessage>          mPl;
    public ObservableList<SpykUser>      myContList;

    public SpykUser                          myName;


    public void SpykChatCore (){

        uPl = FXCollections.observableArrayList();
        mPl = FXCollections.observableArrayList();
        myName = login();
        myContList = myName.getContList();
        loadLocalDB();
    }


    void loadLocalDB(){

        uPl.add(new SpykUser(0,"Маша"));
        uPl.add(new SpykUser(1,"Вера"));
        uPl.add(new SpykUser(2,"Витя"));
        uPl.add(new SpykUser(3,"Пётр"));


        mPl.add(new SpykMessage(new Date(), uPl.get(0), uPl.get(1),"sdfwre df wqf sd"));
        mPl.add(new SpykMessage(new Date(), uPl.get(3), uPl.get(1),"wdwdwdwd"));
        mPl.add(new SpykMessage(new Date(), uPl.get(2), uPl.get(3),"wcwdw ecfwef fw"));
        mPl.add(new SpykMessage(new Date(), uPl.get(3), uPl.get(0),"jh"));



        SpykMessage f = new SpykMessage(new Date(), uPl.get(2), uPl.get(0),"rfrfr");
        SpykMessage s = new SpykMessage(new Date(), uPl.get(3), uPl.get(2),"fff");
        SpykMessage l = new SpykMessage(new Date(), uPl.get(0), uPl.get(3),"sdf");
        SpykMessage k = new SpykMessage(new Date(), uPl.get(2), uPl.get(1),"ergerg");
        SpykMessage m = new SpykMessage(new Date(), uPl.get(0), uPl.get(3),"rsdfvfwr");
        SpykMessage b = new SpykMessage(new Date(), uPl.get(0), uPl.get(2),"fffeeeeee");

        mPl.add(f);
        mPl.add(s);
        mPl.add(l);
        mPl.add(k);
        mPl.add(m);
        mPl.add(b);
    }

    public void addMsg(SpykUser oTpr, SpykUser pLch, String textMsg){
        mPl.add(new SpykMessage(new Date(), oTpr, pLch, textMsg));
    }

    SpykUser login(){
        SpykUser mynName = new SpykUser (838, "Tehnikr");
        uPl.add(mynName);
        return mynName;
    }

    public int getmPlSize(){
        return mPl.size();
    }

    public int getuPlSize(){
        return uPl.size();
    }

    public ObservableList getUlist(){
        return uPl;
    }

    public ObservableList getMlist(){
        return mPl;
    }

    public void addUser(int i, String timur) {
        uPl.add(new SpykUser(i,timur));
    }
}
