// https://leetcode.cn/problems/binary-search/
public class LC704BinarySearch {
    public static int search(int[] nums, int target) {
        int index = -1;
        int mid=nums.length/2;
        int first = 0;
        int last = nums.length;

        for(first=0;last>first;mid = mid+(last-first)/2){
            if (nums[mid] < target) {
                first = mid+1;
            }
            if (nums[mid] > target) {
                last = mid-1;
            }
        }
        index=last;
//        for (int i = 0; i < nums.length; i++){
//            if (nums[i] == target)
//                index = i;
//        }
        return index;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 5;
        System.out.println(search(nums, target));
    }
    /*[-1,0,3,5,9,12]
       2
    */
}
