// Last updated: 12/15/2025, 5:12:57 PM
1class Solution {
2    public void nextPermutation(int[] nums) {
3        next_permutation(nums);
4    }
5    public static void next_permutation(int[] arr){
6        int p=-1;
7        int n= arr.length;
8        for(int i=n-2;i>=0;i--){
9            if(arr[i]<arr[i+1]){
10                p=i;
11                break;
12            }
13        }
14        if(p==-1){
15            reverse(arr, 0, n-1);
16            return;
17        }
18        int q=-1;
19        for(int i=n-1;i>=0;i--){
20            if(arr[i]>arr[p]){
21                q=i;
22                break;
23            }
24        }
25        //  swap p and q
26        int temp=arr[p];
27        arr[p]=arr[q];
28        arr[q]=temp;
29        reverse(arr, p+1, n-1);
30    }
31    public static void reverse(int arr[],int i,int j){
32        while(i<j){
33            int t=arr[i];
34            arr[i]=arr[j];
35            arr[j]=t;
36            j--;
37            i++;
38        }
39    }
40}
41
42