import javax.swing.*;

public class Printer {
    int selectionData; // 연결 필요
    public void printReceipt() {
        JOptionPane.showMessageDialog(null, "영수증:" + selectionData ); // 팝업창, 내용 추가(연결) 필요
    }
}
