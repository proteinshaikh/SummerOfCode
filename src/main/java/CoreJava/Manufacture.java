package CoreJava;

public class Manufacture extends Samsung implements MobileInterface {
    public static void main(String[] args) {
        Manufacture mf = new
                Manufacture();
        mf.chargingPin();
        mf.screen();
        mf.speaker();
        mf.stylus();
    }

    @Override
    public void screen() {
        System.out.println("This is screen");

    }

    @Override
    public void stylus() {
        System.out.println("This is stylus");
    }

    @Override
    public void speaker() {
        System.out.println("This is speaker");
    }
}
