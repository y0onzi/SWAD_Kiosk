import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cook {

    public Cook(Inventory[] inventories,Cart cart){


        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServeFoods();
            }
        });
        timer.setRepeats(false); // 한 번만 실행하도록 설정
        timer.start();

    }

    private void ServeFoods() {
        JOptionPane.showMessageDialog(null, "직원: 맛있게 드세요~");
    }
}
