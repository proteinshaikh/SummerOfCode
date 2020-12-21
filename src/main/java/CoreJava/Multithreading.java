package CoreJava;
public class Multithreading {
    public static void main(String[] args) throws InterruptedException {
        Whatsapp whatsapp=new Whatsapp();
        Twitter twitter=new Twitter();
        for(int i=0;i<5;i++){
            whatsapp.run();
            Thread.sleep(1000);
            twitter.run();
        }
    }
}

class Whatsapp extends Thread{
    public void  run(){
        Thread thread=new Thread();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("whatsapp thread starts -> "+thread.getState()+" state");

    }
}

class Twitter implements Runnable{

    @Override
    public void run() {
        Thread thread2=new Thread(new Twitter());
        System.out.println("Twitter thread starts -> "+thread2.getState()+" state");


    }
}
