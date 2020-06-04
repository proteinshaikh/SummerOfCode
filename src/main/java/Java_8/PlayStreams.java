package Java_8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PlayStreams {

    public static void main(String[] args) {
        PlayStreams playStreams=new PlayStreams();
        playStreams.PlayList();
    }

    public void PlayList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        Stream<Integer> stream = list.stream();

        stream.forEach((Integer element) -> {
            System.out.println(element);
        });
    }
}
