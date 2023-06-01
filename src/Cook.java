public class Cook {
    int selectionData; // 연결 필요

    public void Cook(int selectionData) {
        this.selectionData = selectionData;
    }
    public void makeKrabbyPatty(int KrabbyPatty) {
        Inventory.numOfKrabbyPatty-=KrabbyPatty;
    }
    public void makeDrink(int BulgogiBurger) {
        Inventory.numOfBulgogiBurger-=BulgogiBurger;
    }
    public void makeFrenchFries(int FrenchFries) {
        Inventory.numOfFrenchFries-=FrenchFries;
    }
    public void makeCheeseStick(int CheeseStick) {
        Inventory.numOfCheeseStick-=CheeseStick;
    }
    public void makeChickenNuggets(int ChickenNuggets) {
        Inventory.numOfChickenNuggets-=ChickenNuggets;
    }
    public void makeOrangejuice(int Orangejuice) {
        Inventory.amountOfOrangejuice-=Orangejuice;
    }
    public void makeCocaCola(int CocaCola) {
        Inventory.amountOfCocaCola-=CocaCola;
    }
    public void Sprite(int Sprite) {
        Inventory.amountOfSprite-=Sprite;
    }
}
