package Algorithms.problems;

public class Sorted_Merge_10_1 {

    public static void main(String[] args) {
        Sorted_Merge_10_1 sm=new Sorted_Merge_10_1();
        System.out.println(sm.merge(new int[]{1}, new int[]{2},0,0 ));

    }

    public boolean merge(int [] a, int [] b, int lastA, int lastB){
        int indexA=lastA-1;
        int indexB=lastB-1;
        int indexMerged=lastB+lastA-1;

        while(indexB>0){
            if(indexA>=0 && a[indexA]> b[indexB]){
                a[indexMerged] = a[indexA];
                indexA--;
            }else {
                a[indexMerged]= b[indexB];
                indexB--;
            }
            indexMerged--;
        }

        return true;
    }

}
