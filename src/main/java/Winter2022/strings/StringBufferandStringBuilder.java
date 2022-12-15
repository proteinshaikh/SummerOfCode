package Winter2022.strings;

public class StringBufferandStringBuilder {
    public static void main(String[] args) {
        int N = 9999999;
        long t;

        //stringbuffer
        StringBuffer sbuff = new StringBuffer();
        t = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            sbuff.append(" ");
        }
        System.out.println("StringBuffer Timetaken: " + (System.currentTimeMillis() - t));

//stringbuilder
        StringBuilder sbuild = new StringBuilder();
        t = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            sbuff.append(" ");
        }
        System.out.println("StringBuilder Timetaken: " + (System.currentTimeMillis() - t));
    }
}
