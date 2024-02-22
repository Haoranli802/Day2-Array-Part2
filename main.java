//LeetCode 977
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int right = 0;
        int left = nums.length - 1;
        for(int i = nums.length-1; i >= 0; i--){
            if(nums[right] * nums[right] > nums[left] * nums[left]){
                result[i] = nums[right] * nums[right];
                right ++;
            }
            else{
                result[i] = nums[left] * nums[left];
                left --;
            }
        }
        return result;
    }
}

//双指针法 Time: O(N) Space O(N)

