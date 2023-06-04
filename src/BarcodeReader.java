import javax.swing.*;

public class BarcodeReader {

    Controller controller;
    private String CouponCode;
    private boolean isCouponUsed;

    public BarcodeReader() {
    }

    public boolean useCoupon(Cart cart, String CouponCode){

        isCouponUsed=CouponCode.equals("2023discount50");
        if (isCouponUsed){
            JOptionPane.showMessageDialog(null, "50퍼센트 할인 쿠폰이 적용되었습니다");
        }
        else {
            JOptionPane.showMessageDialog(null, "잘못된 코드입니다");
        }
        return isCouponUsed;
    }

    public boolean getIsCouponUsed(){
        return isCouponUsed;
    }
}
