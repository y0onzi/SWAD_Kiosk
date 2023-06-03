public class Inventory {
    static int numOfKrabbyPatty = 100,
            numOfBulgogiBurger = 100,
            numOfChickenBurger = 100,
            numOfFrenchFries = 100,
            numOfCheeseStick = 100,
            numOfChickenNuggets = 100,
            amountOfOrangejuice = 100,
            amountOfCocaCola = 100,
            amountOfSprite = 100;

    int KrabbyPatty = 0;
    int BulgogiBurger = 0;
    int ChickenBurger = 0;
    int FrenchFries = 0;
    int CheeseStick = 0;
    int ChickenNuggets = 0;
    int Orangejuice = 0;
    int CocaCola = 0;
    int Sprite = 0;
    boolean inventoryStateofKrabbyPatty = true;
    boolean inventoryStateofBulgogiBurger = true;
    boolean inventoryStateofChickenBurger = true;
    boolean inventoryStateofFrenchFries = true;
    boolean inventoryStateofCheeseStick = true;
    boolean inventoryStateofChickenNuggets = true;
    boolean inventoryStateofOrangejuice = true;
    boolean inventoryStateofCocaCola = true;
    boolean inventoryStateofSprite = true;


    public static int getInv(int k) {
        if(k == 0)
            return numOfKrabbyPatty;
        else if(k == 1)
            return numOfBulgogiBurger;
        else if(k == 2)
            return numOfChickenBurger;
        else if(k == 3)
            return numOfFrenchFries;
        else if(k == 4)
            return numOfCheeseStick;
        else if(k == 5)
            return numOfChickenNuggets;
        else if(k == 6)
            return amountOfOrangejuice;
        else if(k == 7)
            return amountOfCocaCola;
        else
            return amountOfSprite;
    }

    public int getSelectedNum(int k) {
        if(k == 0)
            return KrabbyPatty;
        else if(k == 1)
            return BulgogiBurger;
        else if(k == 2)
            return ChickenBurger;
        else if(k == 3)
            return FrenchFries;
        else if(k == 4)
            return CheeseStick;
        else if(k == 5)
            return ChickenNuggets;
        else if(k == 6)
            return Orangejuice;
        else if(k == 7)
            return CocaCola;
        else
            return Sprite;
    }

    public boolean getCheckState(int k) {
        if(k == 0)
            return inventoryStateofKrabbyPatty;
        else if(k == 1)
            return inventoryStateofBulgogiBurger;
        else if(k == 2)
            return inventoryStateofChickenBurger;
        else if(k == 3)
            return inventoryStateofFrenchFries;
        else if(k == 4)
            return inventoryStateofCheeseStick;
        else if(k == 5)
            return inventoryStateofChickenNuggets;
        else if(k == 6)
            return inventoryStateofOrangejuice;
        else if(k == 7)
            return inventoryStateofCocaCola;
        else
            return inventoryStateofSprite;
    }

    public void setInventoryState(int KrabbyPatty, int BulgogiBurger, int ChickenBurger, int FrenchFries, int CheeseStick, int ChickenNuggets, int Orangejuice, int CocaCola, int Sprite) {
        this.KrabbyPatty = KrabbyPatty;
        this.BulgogiBurger = BulgogiBurger;
        this.ChickenBurger = ChickenBurger;
        this.FrenchFries = FrenchFries;
        this.CheeseStick = CheeseStick;
        this.ChickenNuggets = ChickenNuggets;
        this.Orangejuice = Orangejuice;
        this.CocaCola = CocaCola;
        this.Sprite = Sprite;

        // 재고 없으면 인벤상태 false
        inventoryStateofKrabbyPatty = numOfKrabbyPatty - KrabbyPatty >= 0;
        inventoryStateofBulgogiBurger = numOfBulgogiBurger - BulgogiBurger >= 0;
        inventoryStateofChickenBurger = numOfChickenBurger - ChickenBurger >= 0;
        inventoryStateofFrenchFries = numOfFrenchFries - FrenchFries >= 0;
        inventoryStateofCheeseStick = numOfCheeseStick - CheeseStick >= 0;
        inventoryStateofChickenNuggets = numOfChickenNuggets - ChickenNuggets >= 0;
        inventoryStateofOrangejuice = amountOfOrangejuice - Orangejuice >= 0;
        inventoryStateofCocaCola = amountOfCocaCola - CocaCola >= 0;
        inventoryStateofSprite = amountOfSprite - Sprite >= 0;
    }

    static public void updateInventory(int KrabbyPatty, int BulgogiBurger, int ChickenBurger, int FrenchFries, int CheeseStick, int ChickenNuggets, int Orangejuice, int CocaCola, int Sprite) {
        numOfKrabbyPatty+=KrabbyPatty;
        numOfBulgogiBurger+=BulgogiBurger;
        numOfChickenBurger+=ChickenBurger;
        numOfFrenchFries+=FrenchFries;
        numOfCheeseStick+=CheeseStick;
        numOfChickenNuggets+=ChickenNuggets;
        amountOfOrangejuice+=Orangejuice;
        amountOfCocaCola+=CocaCola;
        amountOfSprite+=Sprite;

    }
}
