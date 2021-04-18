package DataStructure.Chapter04.Demo;


public class MergeSort {

    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi){
//        aux = new Comparable[a.length];
        // merage a[lo..mid] and a[mid+1..hi]
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++){
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable a, Comparable b){
        if (a.compareTo(b) < 0)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        Character[] a = {'a', 'f', 'c', 't', 'f', 'y', 'e'};
//        Character[] a = {'a', 'c', 'e', 'g', 'b', 'd', 'f', 'h'};
        MergeSort.sort(a);
//        mergeSort.merge(a, 0, 4, 7);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("END");
    }
}
