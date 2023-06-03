public class CardReader {
    int orderNumber=1;
    String cardNumber;
    int password;
    boolean cardValidation = true;

//    카드번호랑 비밀번호 글자수에 맞게만 입력하면 일단 무조건 결제 완료 되는걸로
//    카드db가 없으니까 따로 비교하는 로직 작성할 필요X
//    글자수 틀리면 결제실패 false 리턴
//    글자수만 맞으면 결제성공 true 리턴
//    카드정보 읽어오는 리더기에서 + 원래 credit card의 useCreditCard

    public CardReader() {
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber+1;
    }

    public void readCreditCard(String CardNumber, int password){
        this.cardNumber = CardNumber;
        this.password = password;

        checkCardValidation(this.cardNumber, this.password);
    }

    public boolean getCardValidation() {
        return cardValidation;
    }

    private void checkCardValidation(String CardNumber, int password) {
        int pwd = (int)( Math.log10(password)+1 );
        System.out.println(pwd);
        if(CardNumber.length()!=16 || pwd!=4 )
            cardValidation =false;
        useCreditCard(cardValidation);
    }

    private void useCreditCard(boolean valid){
        if (!valid) {
            System.out.println("결제실패");
            //처음화면으로 돌아가는 코드 작성? : Screen 호출 ?
        }
        else {
            //카드정보DB 없으니 유효성 검사 통과시 결제 성공
            // 주문번호 출력은 ??
            System.out.println("결제완료!");
            int orderNum = getOrderNumber();
            System.out.println("주문번호는 : " + orderNum);
            setOrderNumber(orderNum);
            //처음화면으로 돌아가는 코드 작성? : Screen 호출 ?
        }

    }



}
