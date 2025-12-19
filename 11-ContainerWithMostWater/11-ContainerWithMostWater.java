// Last updated: 12/19/2025, 10:54:14 AM
1class Solution {
2    public int maxArea(int[] arr) {
3       int sum=0;
4       int left=0;
5       int right=arr.length-1;
6       while(left < right){
7            int s=(right-left)*Math.min (arr[left],arr[right]);
8            sum = Math.max(sum,s);
9            if(arr[left]<arr[right]){
10                left++;
11            }
12            else{
13                right--;
14            }
15        }
16        return sum;
17    }
18}