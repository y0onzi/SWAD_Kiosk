public class WholeMenu {
    private String name;
    private double price;
    private int calorie;

    //생성자
    public WholeMenu(String menuName, double price, int calorie) {
        this.name = menuName;
        this.price = price;
        this.calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCalorie() {
        return calorie;
    }

    public String[] createMenuInfoArray() {
        String[] menuInfo = new String[3];
        menuInfo[0] = " 메뉴명:   " + name;
        menuInfo[1] = " 가격:    ￦" + price;
        menuInfo[2] = " 칼로리:   " + calorie;
        return menuInfo;
    }

}