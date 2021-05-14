package Spyk;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Tehnikr
 */
public class SpykUser {

    int id;
    String nickName;

    public SpykUser(int idi, String nickNamei){
        id = idi;
        nickName = nickNamei;
    }

    public SpykUser(String f, String nickName){
        this.id = 5;
        this.nickName = nickName;
    }

    public String getUserId() {
        return String.valueOf(id);
    }

    //public void setUserId(String firstName) {
    //    this.id = 5;
    //}

    public int getId(){
        return id;
    }

    public String getNickName(){
        return nickName;
    }

    public String getUserName() {
        System.out.println(nickName);
        return nickName;
    }

    ObservableList<SpykUser> getContList() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        ObservableList<SpykUser> cl;

        cl = FXCollections.observableArrayList();

        cl.addAll(
                new SpykUser(0,"Маша"),
                new SpykUser(0,"Маша"),
                new SpykUser(0,"Маша"));

        return cl;
    }

}
