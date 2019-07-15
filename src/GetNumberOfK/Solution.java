package GetNumberOfK;

public class Solution {

/**
 * @program: offer
 *
 * @description: 统计一个数字在排序数组中出现的次数。
 *
 * @author: makaloo
 *
 * @create: 2019-07-14 22:23
 **/
//    public int GetNumberOfK(int [] array , int k) {
//        if (array == null || array.length == 0) return 0;
//        int min = array.length, ans = 0; // min初始值为array.length，当数组中没有该元素时，第二个循环就不会进入
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == k) {
//                min = i;
//                break;
//            }
//        }
//        for (int i = min; i < array.length; i++) {
//            if (array[i] == k) ans++;
//            else break;
//        }
//        return ans;
//    }

    // 使用折半查找，必须找k出现的第一个和最后一个下标，而不是找比k小的最大元素和比k大的最小元素，因为不一定有元素比k小或比k大
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) return 0;
        int firstK = getFirstK(array, k);
        int lastK = getLastK(array, k);
        if (firstK != -1 && lastK != -1)
            return lastK - firstK + 1;
        return 0;
    }

    private int getFirstK(int[] array, int k) {
        int low = 0, high = array.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] > k)
                high = mid - 1;
            else if (array[mid] < k)
                low = mid + 1;
            else if (mid - 1 >= 0 && array[mid - 1] == k) // 当array[mid]不是第一个k时，仍然需要往前折半查找，判断他是第一个k：他是第0个元素或者他之前的元素不等于k
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    private int getLastK(int[] array, int k) {
        int low = 0, high = array.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] > k)
                high = mid - 1;
            else if (array[mid] < k)
                low = mid + 1;
            else if (mid + 1 < array.length && array[mid + 1] == k) // 当array[mid]不是最后一个k时，仍然需要往后折半查找
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
