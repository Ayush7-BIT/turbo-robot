class MergeShort {
    void merge(int a[], int beg, int mid, int end)
    {
        int i, j, k;
        int num1 = mid - beg + 1;
        int num2 = end - mid;

        int LeftArr[] = new int[num1];
        int RightArr[] = new int[num2];

        for (i = 0; i < num1; i++) {
            LeftArr[i] = a[beg + i];
        }
        for (j = 0; j < num2; j++) {
            RightArr[j] = a[mid + 1 + j];
        }

        i = 0;
        j = 0;
        k = beg;

        while (i < num1 && j < num2)
        {
            if(LeftArr[i] <= RightArr[j])
            {
                a[k] = LeftArr[i];
                i++;
            }
            else
            {
                a[k] = RightArr[j];
                j++;
            }
            k++;
        }
        while (i<num1)
        {
            a[k] = LeftArr[i];
            i++;
            k++;
        }

        while (j<num2)
        {
            a[k] = RightArr[j];
            j++;
            k++;
        }
    }


    void printArray(int a[], int n)
    {
        int i;
        for (i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }

    void mergeSort(int a[], int beg, int end)
    {
        if (beg < end)
        {
            int mid = (beg + end) / 2;
            mergeSort(a, beg, mid);
            mergeSort(a, mid + 1, end);
            merge(a, beg, mid, end);
        }
    }

    public static void main(String args[])
    {
        int a[] = { 10, 25, 80, 9, 48, 18 };
        int n = a.length;
        MergeShort obj1 = new MergeShort();
        System.out.println("\nBefore sorting:");
        obj1.printArray(a, n);
        obj1.mergeSort(a, 0, n - 1);
        System.out.println("\nAfter sorting:");
        obj1.printArray(a, n);
        System.out.println("");
    }

}
