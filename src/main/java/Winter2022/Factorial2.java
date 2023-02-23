package Winter2022;

public class Factorial2 {
    public static void main(String[] args) {
        System.out.println(getFact(5));
        System.out.println(getFactRecursive(5));

    }

    static int getFact(int num) {
        int res = 1;
        for (int i = 0; i < num; i++) {
            res *= num - i;
        }
        return res;
    }

    static int getFactRecursive(int num) {
        if (num == 0) return 1;
        return num * (getFactRecursive(num - 1));
    }
}
