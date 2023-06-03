import java.util.List;

public class Receipt {
    private List<String> items;
    private double totalPrice;

    public Receipt(List<String> items, double totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public void printReceipt() {
        System.out.println("========== 영수증 ==========");
        System.out.println("주문 상품:");
        for (String item : items) {
            System.out.println("- " + item);
            //연결이 안돼서 일단은 이름만 출력하는데
            // + 상품가격, 갯수 출력해야하게 수정해야돼요
        }
        System.out.println("===========================");
        System.out.println("총 결제 금액: " + totalPrice + "원");
        System.out.println("===========================");
    }
}

