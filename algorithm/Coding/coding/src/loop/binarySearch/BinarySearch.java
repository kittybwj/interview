package loop.binarySearch;

/**
 * 二分查找
 * 在有序数组中查找元素k，返回k所在的下标。如未找到，返回-1
 */
public class BinarySearch {
    public int binarySearch(int[] arr,int k){
        int a = 0;
        int b = arr.length;
        while (a<b){
            //int m = (a+b)/2;//修改前：(a+b)/2 may overflow!
            int m = a + (b-a)/2; //修改后
            if (k < arr[m]){
                b = m;
            }else if (k > arr[m]){
                a = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(new int[]{1,2,10,15,100},15));
        System.out.println(bs.binarySearch(new int[]{1,2,10,15,100},-2));
        System.out.println(bs.binarySearch(new int[]{1,2,10,15,100},200));
        System.out.println(bs.binarySearch(new int[]{1,2,10,15,100},13));
        System.out.println(bs.binarySearch(new int[]{},15));
        System.out.println(bs.binarySearch(new int[]{12},15));
        System.out.println(bs.binarySearch(new int[]{15},15));
    }
}
