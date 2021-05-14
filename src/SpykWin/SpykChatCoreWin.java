/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpykWin;

import java.util.ArrayList;
import Spyk.*;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.Button;

/**
 *
 * @author Tehnikr
 */
public class SpykChatCoreWin extends SpykChatCore {

    SpykChatCoreWin(){
        SpykChatCore();
    }

    ArrayList<SpykWinKont> kL;

    ArrayList<SpykWinKont> getKontListWin() {

        kL = new ArrayList<>();

        this.uPl.forEach((n)->{
            if (n.getId() != this.myName.getId())kL.add(new SpykWinKont(n));
        });

        return kL;
    }
}
