package Spyk;

import java.util.Date;

/**
 *
 * @author Tehnikr
 */
public class SpykMessage {

    private String msgText = "Ку-ку!";
    private int id = 0;
    public SpykUser otprvt;
    public SpykUser poluch;
    private Date d;

    public SpykMessage(Date d, SpykUser otpvt, SpykUser polch, String msgText) {
        this.otprvt = otpvt;
        this.poluch = polch;
        this.msgText = msgText;
    }

    public SpykMessage(int id, Date d, SpykUser otpvt, SpykUser polch, String msgText) {
        this(d, otpvt, polch, msgText);
        this.id = id;
    }

    public String getMessageText() {
        return msgText;
    }

    int getId() {
        return id;
    }

    public SpykUser getOtprvt(){
        System.out.println(otprvt);
        return otprvt;
    }

    public SpykUser getPoluch(){
        return poluch;
    }

    void setId (int id){
        this.id = id;
    }
}
