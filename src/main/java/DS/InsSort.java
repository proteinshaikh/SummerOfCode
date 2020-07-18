package DS;



public class InsSort {

    public void ins(int[] array) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }

    public static void main(String[] args) {
        InsSort is = new InsSort();
        int[] array = {4, 6, 3, 10};
        is.ins(array);
        for(int k: array){
            System.out.print(k+" ");
        }
    }
}
