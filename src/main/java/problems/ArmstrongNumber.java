package problems;


//  0, 1, 153, 370, 371 and 407 are armstrong numbers
public class ArmstrongNumber {
    public static void main(String[] args) {
        System.out.println(isArmstrongNumber(153));
    }

    static boolean isArmstrongNumber(int num) {
        boolean isArmstrong = false;
        int origNum = num;
        int inputNum = num;

        int counter = 0;
        while (num != 0) {
            num = num / 10;
            if (num != 0) {
                counter++;
            }
        }

        if (counter != 0) {
            counter++;
        }

        int sum = 0;
        for (int i = 0; i < counter; i++) {
            int mod = origNum % 10;
            origNum /= 10;
            sum += (int) Math.pow(mod, counter);
        }
        if (sum == inputNum) {
            isArmstrong = true;
        }
        return isArmstrong;
    }
}
