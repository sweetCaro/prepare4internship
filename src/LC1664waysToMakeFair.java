import java.util.ArrayList;
import java.util.List;
/*public class LC1664waysToMakeFair {

    public static int waysToMakeFair(int[] nums) {
        int ways=0;
        int sumOfEvens=0;
        int sumOfOdds=0;
        int[] tempNums = new int[nums.length];
        int index=0;
        for (int i=0;i<nums.length;i++) {
            for(int j=0;j<nums.length;j++) {
                if(j==i) continue;
                tempNums[index]=nums[j];
                //System.out.println(tempNums[index]);
                index++;
            }
            index=0;
            for (int k = 0; k < tempNums.length; k++) {
                if (k % 2 == 0) sumOfEvens += tempNums[k];
                if (k % 2 != 0) sumOfOdds += tempNums[k];
            }
            //System.out.println(sumOfEvens);
            //System.out.println(sumOfOdds);
            if (sumOfEvens == sumOfOdds) ways++;
            sumOfEvens=0;
            sumOfOdds=0;
        }
        return ways;
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        System.out.println(waysToMakeFair(nums));
    }
}
*/

/**以上做法超时了
 * 选择一个位置i，删除i位置的元素，删除后i之后的下标会因此发生改变
 *设preOdd[i]表示i之前所有奇数位置元素的和，preEven[i]表示i之前所有偶数位置元素的和
 *sufOdd[i]表示i之后所有奇数位置元素的和，sufEven[i]表示i之后所有偶数位置元素的和
 *如果preOdd[i]+sufEven==preEven[i]+sufOdd[i]
 *那么就是平衡数组
 * 滚动数组
 */
public class LC1664waysToMakeFair {

    public static int waysToMakeFair(int[] nums) {
        int ways=0;
        int preEven=0;
        int preOdd=0;
        int sufEven=0;
        int sufOdd=0;
        for(int i =0; i < nums.length; i++) {
            if((i&1)!=0){
                sufOdd+=nums[i];
            }
            else{
                sufEven+=nums[i];
            }
        }
        //滚动数组
        for(int i=0;i<nums.length;i++){
            if((i&1)!=0) sufOdd-=nums[i];//
            else sufEven-=nums[i];
            if(preOdd+sufEven==preEven+sufOdd) ways++;
            if((i&1)!=0) preOdd+=nums[i];//加回来
            else preEven+=nums[i];//还原原来的数组
        }
        return ways;
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,1,1};
        System.out.println(waysToMakeFair(nums));
    }

}