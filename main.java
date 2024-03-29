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

//LeetCode 209
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        int subLength = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                subLength = i - start + 1;
                result = Math.min(result, subLength);
                sum -= nums[start];
                start ++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
//滑动窗口 Time: O(N) Space: O(1)

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for(int i = 1; i < sums.length; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        System.out.println(Arrays.toString(sums));
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < sums.length; i++){
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + target, sums);
            if(end == sums.length) break;
            //System.out.println(end);
            //System.out.println(i);
            //System.out.println("-----");
            if(end - i < result) result = end - i;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    private int binarySearch(int start, int end, int key, int[] sums){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(sums[mid] > key){
                end = mid - 1;
            }
            else if(sums[mid] == key) return mid;
            else{
                start = mid + 1;
            }
        }
        return start;
    }
}
// binarySearch Time: O(NlogN) Space: O(N)

//LeetCode 59

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loop = 0;
        int start = 0;
        int count = 1;
        int i, j;
        while (loop++ < n / 2) { // 判断边界后，loop从1开始
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }
        if(n % 2 == 1) res[start][start] = count;
        return res;
    }
}
//Time: O(N^2) Space: O(1)

