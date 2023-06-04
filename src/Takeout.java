public class Takeout {
    private boolean isTakeout;

    //생성자
    public Takeout(boolean isTakeout) {
        this.isTakeout = isTakeout; //(트루일경우 포장)

    }


    public boolean getTakeout() {
        return isTakeout;
    }

}