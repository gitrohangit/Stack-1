// Time Complexity : O(3n) -> O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
//Approach : maintain a monotonic decreasing stack as we have to resolve last in element first.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < 2*n ; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int idx = st.pop();
                ans[idx] = nums[i%n];
            }

            // we completed the cycle and could not find next greater element
            if(i > n && i%n == st.peek()) return ans;

            // we only process values in the iteration.
            if(i < n){
                st.push(i);
            }
        }
        return ans;
    }
}