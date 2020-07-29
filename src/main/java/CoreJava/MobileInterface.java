package CoreJava;

interface MobileInterface {

    void chargingPin();
    void screen();
    void stylus();
    void speaker();
}

abstract class Samsung implements MobileInterface{
    public void chargingPin(){
        System.out.println("This is charging pin");
    }
}

