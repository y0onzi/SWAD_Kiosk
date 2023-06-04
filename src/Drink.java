public class Drink extends WholeMenu {
    private int DrinkVolume;

    //생성자
    public Drink(String name, int price, int calorie, int DrinkVolume) {
        super(name, price, calorie);
        this.DrinkVolume = DrinkVolume;
    }

    public int getDrinkVolume() {
        return DrinkVolume;
    }

    @Override
    public String[] createMenuInfoArray() {
        String[] menuInfo = new String[4];
        menuInfo[0] = " 메뉴명:   " + getName();
        menuInfo[1] = " 가격:    ￦" + getPrice();
        menuInfo[2] = " 칼로리:   " + getCalorie();
        menuInfo[3]=" 음료용량:  "+DrinkVolume+"ml" ;
        return menuInfo;
    }
}
