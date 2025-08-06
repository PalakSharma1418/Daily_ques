// Last updated: 8/6/2025, 4:47:42 PM
class Solution {
  public int[] findDiagonalOrder(int[][] mat) {
        int size = mat.length * mat[0].length;
        int[] res = new int[size];
        int k = 0;
        int sum = 0;
        int revFlag = 1;
        while(k < size){
            //to move in diagonal
            //reverse alternate
            int s = 0;
            int e = 0;
            int sFlag = 0;
            for(int i = 0;i < mat.length;i++){
                for(int j = 0;j < mat[0].length;j++){
                    if(i + j == sum){
                        res[k] = mat[i][j];
                        if(sFlag == 0){
                            s = k;
                            sFlag = 1;
                        }
                        e = k;
                        k++;
                    }
                }
            }
            if(revFlag == 1){
                reverse(res, s, e);
            }
            if(revFlag == 1){
                revFlag = 0;
            }else{
                revFlag = 1;
            }    
            sum++;
        }
        return res;
    }
    public void reverse(int[] arr, int start, int end){
        int i = start;
        int j = end;
        while(i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}