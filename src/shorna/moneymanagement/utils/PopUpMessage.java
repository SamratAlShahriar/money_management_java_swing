package shorna.moneymanagement.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Mst. Taslima Aktar Shorna
 */
public class PopUpMessage {
    //popup for only to show the message
    public static void popUpMsgBox(String infoMessage, String titleBar, int msgType) {
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, msgType);
    }

    public static void popUpInputBox(String infoMessage, String titleBar, int msgType) {
        JOptionPane.showInputDialog(null, infoMessage, "" + titleBar, msgType);
    }

    public static void popUpErrorBox(String infoMessage, String titleBar) {
       JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.ERROR_MESSAGE);
    }
}
