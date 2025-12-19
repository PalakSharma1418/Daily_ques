// Last updated: 12/19/2025, 10:58:27 AM
1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        int n=nums1.length;
4        int m=nums2.length;
5        int indele1=-1,indele2=-1;
6        int t=n+m;
7        int ind2=t/2,ind1=ind2-1;
8        int cnt=0;
9        int i=0,j=0;
10        while(i<n && j<m){
11            if(nums1[i] < nums2[j]){
12                if(cnt==ind1) indele1=nums1[i];
13                if(cnt==ind2) indele2=nums1[i];
14                cnt++;
15                i++;
16            }
17            else{
18                if(cnt==ind1) indele1=nums2[j];
19                if(cnt==ind2) indele2=nums2[j];
20                cnt++;
21                j++;
22            }
23            if(indele1 !=-1 && indele2 != -1){
24                break;
25            }
26        }
27        while(i<n){
28             if(cnt==ind1) indele1=nums1[i];
29             if(cnt==ind2) indele2=nums1[i];
30             cnt++;
31             i++;
32             if(indele1 !=-1 && indele2 != -1){
33                break;
34            }
35        }
36        while(j<m){
37            if(cnt==ind1) indele1=nums2[j];
38            if(cnt==ind2) indele2=nums2[j];
39            cnt++;
40            j++;
41            if(indele1 !=-1 && indele2 != -1){
42                break;
43            }
44        }
45        if(t%2==1){
46            return indele2;
47        }
48        return (double)((double)(indele1+indele2)/2.0);
49    }
50}