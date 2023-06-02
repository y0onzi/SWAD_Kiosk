public class Cook {
    int selectionData; // 연결 필요

    public static void makeKrabbyPatty(int KrabbyPatty) {
        Inventory.numOfKrabbyPatty-=KrabbyPatty;
    }
    public static void makeBulgogiBurger(int BulgogiBurger) {
        Inventory.numOfBulgogiBurger-=BulgogiBurger;
    }
    public static void makeChickenBurger(int ChickenBurger) {
        Inventory.numOfChickenBurger-=ChickenBurger;
    }
    public static void makeFrenchFries(int FrenchFries) {
        Inventory.numOfFrenchFries-=FrenchFries;
    }
    public static void makeCheeseStick(int CheeseStick) {
        Inventory.numOfCheeseStick-=CheeseStick;
    }
    public static void makeChickenNuggets(int ChickenNuggets) {
        Inventory.numOfChickenNuggets-=ChickenNuggets;
    }
    public static void makeOrangejuice(int Orangejuice) {
        Inventory.amountOfOrangejuice-=Orangejuice;
    }
    public static void makeCocaCola(int CocaCola) {
        Inventory.amountOfCocaCola-=CocaCola;
    }
    public static void makeSprite(int Sprite) {
        Inventory.amountOfSprite-=Sprite;
    }
}
