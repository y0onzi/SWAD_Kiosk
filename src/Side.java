public class Side extends WholeMenu {
    private String SideDescription;

    public Side(String name, int price, int calorie, String SideDescription) {
        super(name, price, calorie);
        this.SideDescription = SideDescription;
    }

    public String getBurgerDescription() {
        return SideDescription;
    }

    @Override
    public String[] createMenuInfoArray() {
        String[] menuInfo = new String[4];
        menuInfo[0] = " 메뉴명:   " + getName();
        menuInfo[1] = " 가격:    ￦" + getPrice();
        menuInfo[2] = " 칼로리:   " + getCalorie();
        menuInfo[3] = " 메뉴설명:  " + SideDescription;
        return menuInfo;
    }
}