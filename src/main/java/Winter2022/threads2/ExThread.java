package Winter2022.threads2;

public class ExThread extends Thread{
    @Override
    public void run(){
        System.out.println("my thread" + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        for(int i=0; i< 5; i++){
            ExThread exThread = new ExThread();
            exThread.start();
            /*start: This method starts a new thread of execution and calls the run method of the Thread class.*/
            exThread.run(); /*
            run: This method is the entry point of the thread and contains the code that will be executed in the thread.
            When you call the run method directly, it will execute in the same thread as the caller, rather than in a new thread*/
        }

    }
}
