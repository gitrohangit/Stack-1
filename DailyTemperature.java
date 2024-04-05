// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
//Approach : maintain a monotonic decreasing stack as we have to resolve last in element first i.e. keep resolving colder temperatures from the next encountered hotter temperature.


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int idx = st.pop();
                ans[idx] = i - idx;
            }
            st.push(i);
        }

        return ans;
    }
}

//Approach 2:
// Time Complexity : O(2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
//Approach : Start from reverse, and use the already calculated result to skip the middle days.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int hottest = 0;

        int[] ans = new int[temperatures.length];

        for(int i = temperatures.length - 1; i >= 0; i--){

            if(temperatures[i] >= hottest){
                hottest = temperatures[i];
            }
            else{
                int days = 1;
                while(temperatures[i] >= temperatures[i + days]){
                    // as we will not see a warmer day for the next ans[i+days], so directly jump to that day.
                    days += ans[i+days]; 
                }

                ans[i] = days;
            }

        }

        return ans;
    }
}