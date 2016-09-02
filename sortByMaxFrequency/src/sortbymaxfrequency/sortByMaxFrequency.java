
package sortbymaxfrequency;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class sortByMaxFrequency {

    public static void main(String[] args) {

        int s[] = {2, 5, 5, 8, 10, 8, 8, 5, 6, 6};
        int p[] = new int[s.length];
        sortingByMaxFrequency2(s, p);
    }

    public static void sortingByMaxFrequency2(int s[], int p[]) {
        dataFrequency freq[] = new dataFrequency[s.length];

        for (int i = 0; i < s.length; i++) {
            freq[i] = new dataFrequency(0, 0);
        }
        int j = 0;
        int k = 0;
        int m = 0;
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        // a , 2    --> a , 3
        for (int c : s) {
            //System.out.println(" c=  " + c);
            if (hashMap.get(c) != null) { // element is present
                hashMap.put(c, hashMap.get(c) + 1);
            } else // character found for first time
            {
                hashMap.put(c, 1);
            }

        }

//        System.out.println("Printing frequncy ...... ");
//        System.out.println("Key    Value ");

        // while(!hashMap.isEmpty())
        // {
        //int max=Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {

            freq[j].data = entry.getKey();
            freq[j].freq = entry.getValue();
            j++;
            // System.out.println(entry.getKey() + "  "+ entry.getValue());
        }
//
//      hashMap.remove(k);
//    }
        System.out.println("Pre passing  ");
        printArray(freq);
        mergeSort(freq, 0, freq.length - 1);
        System.out.println("after sorting-----");
        printArray(freq);

        System.out.println("after sorting-----");

        for (int l = freq.length - 1; l >= 0; l--) {
            for (int f = freq[l].freq; f > 0; f--) {
                System.out.println("data :: " + freq[f].data);
                p[m++] = freq[l].data;
            }

            //  System.out.print(p[l]+ " ");
        }
        System.out.println("Output-----");
        printArrayWithoutFreq(p);

    }

    public static void printArrayWithoutFreq(int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);

        }
    }

    public static void printArray(dataFrequency[] temp) {
        for (int i = 0; i < temp.length; i++) {
            System.out.println("i = " + i + " a= " + temp[i].data + " freq " + temp[i].freq);

        }
    }

    public static void mergeSort(dataFrequency a[], int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, h);
            merge(a, l, m, h);
        }


        //iterative merge sort

    }

    public static void merge(dataFrequency a[], int low, int mid, int high) {
        int l = low;
        int mid1 = mid + 1;
        dataFrequency temp[] = new dataFrequency[a.length];
        for (int i = 0; i < temp.length; i++) {
            System.out.println("i = " + i + " a= " + a[i].freq);
            temp[i] = new dataFrequency(0, 0);
        }

        int indx = low;

        while ((l <= mid) && (mid1 <= high)) {
            System.out.println(" low :: " + low + " mid1 :: " + mid1 + " :: high :: " + high);
            if (a[l].freq < a[mid1].freq) {
                temp[indx].freq = a[l].freq;
                temp[indx].data = a[l].data;
                l++;
            } else {
                temp[indx].freq = a[mid1].freq;
                temp[indx].data = a[mid1].data;
                mid1++;
            }
            indx++;
        }

        if (l <= mid) {
            for (int i = l; i <= mid; i++) {
                temp[indx].freq = a[i].freq;
                temp[indx].data = a[i].data;
                indx++;
            }

        } else {
            for (int j = mid1; j <= high; j++) {
                temp[indx].freq = a[j].freq;
                temp[indx].data = a[j].data;
                indx++;
            }
        }

        for (int i = low; i <= high; i++) {
            a[i].data = temp[i].data;
            a[i].freq = temp[i].freq;
        }

    }
}

class dataFrequency {

    int data;
    int freq;

    public dataFrequency(int data, int freq) {
        this.data = data;
        this.freq = freq;
    }
}
