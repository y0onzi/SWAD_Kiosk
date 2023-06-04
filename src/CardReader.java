import javax.swing.*;

public class CardReader {
    int orderNumber=1;
    boolean isCardUsed;

    public CardReader() {
    }

    public int getOrderNumber() {
        return orderNumber++;
    }


    public boolean useCreditCard(String password){
        isCardUsed=password.equals("1234");

        //비밀번호 일치시 결제 성공
        if (isCardUsed) {
            JOptionPane.showMessageDialog(null, "결제에 성공했습니다.");
        }
        else {
            JOptionPane.showMessageDialog(null, "결제에 실패했습니다.");
        }

        return isCardUsed;
    }



}
