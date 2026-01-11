// Last updated: 1/11/2026, 7:49:03 AM
1class Solution {
2    public int maximalRectangle(char[][] matrix) {
3        int[] arr = new int[matrix[0].length];
4		int ans = 0;
5		for (int i = matrix.length - 1; i >= 0; i--) { // last row se
6			for(int j=0;j<matrix[0].length;j++){
7                if(matrix[i][j]=='0'){
8                    arr[j]=0;
9                }
10                else{
11                    arr[j]++;
12                }
13            }
14            System.out.println(Area(arr));
15			ans = Math.max(ans, Area(arr));
16		}
17		return ans;
18    }
19    public static int Area(int[] arr) {
20		Stack<Integer> st = new Stack<>();
21		int ans = 0;
22		for (int i = 0; i < arr.length; i++) {
23			while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
24				int h = arr[st.pop()];
25				int r = i;
26				if (!st.isEmpty()) {
27					int l = st.peek();
28					ans = Math.max(ans, h * (r - l - 1));
29				} else {
30					ans = Math.max(ans, h * r);
31				}
32			}
33
34			st.push(i);
35		}
36		int r = arr.length;
37		while (!st.isEmpty()) {
38			int h = arr[st.pop()];
39			if (!st.isEmpty()) {
40				int l = st.peek();
41				ans = Math.max(ans, h * (r - l - 1));
42			} else {
43				ans = Math.max(ans, h * r);
44			}
45		}
46		return ans;
47	}
48
49}