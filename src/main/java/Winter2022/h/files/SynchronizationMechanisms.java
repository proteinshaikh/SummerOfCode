package Winter2022.h.files;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizationMechanisms {

    private static final ReentrantLock fileLock = new ReentrantLock();

    public static void main(String[] args) {
        // Thread to write to the file
        Thread writeThread = new Thread(
                () -> {
                    try {
                        writeToFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
        writeThread.start();

        // Thread to read from the file
        Thread readThread = new Thread(
                () -> {
                    try {
                        readFromFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
        readThread.start();
    }

    private static void writeToFile() throws IOException {
        fileLock.lock();
        try {
            FileWriter writer = new FileWriter("File.txt");
            writer.write("hello world!");
            writer.close();
        } catch (IOException e) {
            System.out.println(
                    "Error writing to file: "
                            + e.getMessage()
            );
        } finally {
            fileLock.unlock();
        }
    }

    private static void readFromFile() throws IOException {
        fileLock.lock();
        try (
                BufferedReader reader = new BufferedReader(
                        new FileReader("File.txt")
                )
        ) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println("reading file : " + line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(
                    "Error reading file: "
                            + e.getMessage()
            );
        } finally {
            fileLock.unlock();
        }
    }
}
