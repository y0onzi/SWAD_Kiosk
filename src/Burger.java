public class Burger extends WholeMenu {
    private String burgerDescription;

    public Burger(String name, int price, int calorie, String burgerDescription) {
        super(name, price, calorie);
        this.burgerDescription = burgerDescription;
    }

    public String getBurgerDescription() {
        return burgerDescription;
    }

    @Override
    public String[] createMenuInfoArray() {
        String[] menuInfo = new String[4];
        menuInfo[0] = " 메뉴명:   " + getName();
        menuInfo[1] = " 가격:    ￦" + getPrice();
        menuInfo[2] = " 칼로리:   " + getCalorie();
        menuInfo[3] = " 메뉴설명:  " + burgerDescription;
        return menuInfo;
    }
}