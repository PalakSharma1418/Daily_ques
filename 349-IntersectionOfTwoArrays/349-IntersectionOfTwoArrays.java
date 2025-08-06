// Last updated: 8/6/2025, 4:48:29 PM
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs = new HashSet<>();
        
        for(int i :  nums1)
        {
            hs.add(i);
        }
        Set<Integer> common = new HashSet<>();   
        for(int i : nums2)
        {
            if(hs.contains(i))
            {
                common.add(i);
            }
        }
        int[] arr = new int[common.size()];
        int j = 0;
        for(int i : common)
        {
            arr[j] = i;
            j++;
        }
        return arr;
    }
}
// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         // Arrays.sort(num1);
//         // Arrays.sort(num2);
//         HashSet<Integer> set= new HashSet<>();
//         int n= nums1.length;
//         int m= nums2.length;
//         if(n<m){
//             for(int i=0;i<n;i++){
//                 for(int j=0;j<m;j++){
//                     if(nums1[i]==nums2[j]){
//                         set.add(nums1[i]);
//                         break;
//                     }
//                 }
//             }
//         }
//         else{
//              for(int i=0;i<m;i++){
//                 for(int j=0;j<n;j++){
//                     if(nums2[i]==nums1[j]){
//                         set.add(nums2[i]);
//                         break;
//                     }
//                 }
//             }
//         }
//         int [] arr= new int[set.size()];
//         int i = 0;
//         for (int num : set) {
//             arr[i++] = num;
//         }
//         return arr;
//     }
// }