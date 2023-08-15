package Winter2022.h.files;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileOP {

    static  void readFile() throws IOException {
        File file = new File("example.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream =  new BufferedInputStream(inputStream);

        byte[] buffer  = new byte[1024];
        int bytesRead;
        while((bytesRead = bufferedInputStream.read(buffer)) != -1){

        }
        bufferedInputStream.close();
        inputStream.close();
    }
}
