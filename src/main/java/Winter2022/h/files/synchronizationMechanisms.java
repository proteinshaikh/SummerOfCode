package Winter2022.h.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Semaphore;

public class synchronizationMechanisms {
    private static final Semaphore writeSemaphore = new Semaphore(1);
    private static final Object fileLock = new Object();
    private static boolean isWriting = false;

    public static void main(String[] args) {


        //thread to write to the file
        Thread writeThread = new Thread(() -> {
            try {
                writeToFile("File.txt", "hello world!");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        writeThread.start();

        //thread to read from the file
        Thread readThread = new Thread(() -> {
            try {
                readFromFile("File.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        readThread.start();

    }

    private static void readFromFile(String fileName) throws IOException {



        synchronized (fileLock) {
            while (isWriting) {
                try {
                    fileLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //read from the file
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                System.out.println("error reading file : " + e.getMessage());
            }
        }
    }

    private static void writeToFile(String fileName, String data) throws IOException, InterruptedException {

        writeSemaphore.acquire();

        synchronized (fileLock) {
            isWriting = true;

            FileWriter writer = new FileWriter(fileName);
            writer.write(data);
            writer.close();

            isWriting = false;
            fileLock.notifyAll();
        }

        writeSemaphore.release();

    }
}
