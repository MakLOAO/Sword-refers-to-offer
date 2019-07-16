package FindNumsAppearOnce;

public class Solution {

/**
 * @program: offer
 *
 * @description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * @author: makaloo
 *
 * @create: 2019-07-16 15:46
 **/
// 位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
// 算法思路：针对上面的性质，先对数组所有元素进行异或，得到的结果就是这两个只出现了一次的数字(记为A,B)的异或的结果
// 该异或结果中的二进制的1，表现为A和B二进制形式中不同的位
// 取第一个异或结果1所在位数k，把原数组分为两组，分组标准是第k位是否为1，这样A和B必定分到不同两组
// 然后对这两组分别异或求解即可得到A和B的结果了
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        // 算法中具体步骤表现为：得到异或解，找到第一个1，分组并分别异或
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        // 得到异或解：
        int bitResult = 0;
        for (int i : array) {
            bitResult ^= i;
        }
        // 找到第一个1
        int index = 0;
        while ((bitResult & 1) != 1) {
            bitResult = bitResult >> 1;
            index++;
        }
        // 分组并分别异或
        for (int i : array) {
            if (((i >> index) & 1) == 1) num1[0] ^= i;
            else num2[0] ^= i;
        }
    }
}
