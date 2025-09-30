// Last updated: 9/30/2025, 8:30:15 PM
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ll = new ArrayList<>();
        int[] row = new int[matrix.length];
        int [] col = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<matrix[0].length;j++){
                if(min> matrix[i][j]){
                    min=matrix[i][j];
                }
            }
            row[i]=min;
        }
        for(int j=0;j<matrix[0].length;j++){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<matrix.length;i++){
                if(max< matrix[i][j]){
                    max=matrix[i][j];
                }
            }
            col[j]=max;
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==row[i] && matrix[i][j]==col[j]){
                    ll.add(matrix[i][j]);
                }
            }
        }
        return ll;
    }
}