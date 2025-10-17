// Last updated: 10/17/2025, 7:31:25 PM
class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        char[][] res = deg(boxGrid);
        int r=res.length;
        int c=res[0].length;
        for(int j=0;j<c;j++){
            for(int i=r-1;i>=0;i--){//sabse niche bali row se chalu karna hai
                 if(res[i][j]=='*' || res[i][j]=='.'){
                    continue;
                 }
                 if(res[i][j]=='#'){
                    while(i+1<r && res[i+1][j]=='.'){
                        res[i][j]='.';
                        res[i+1][j]='#';
                        i++;
                    }
                 }
                
            }
        }
        return res;
    }
    public char[][] deg(char[][] mat){

        int n=mat.length,m=mat[0].length;
        char[][] res = new char[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[j][i]=mat[i][j];
            }
        }
        for(int i=0;i<m;i++){
            int k=0;
            for (int j = 0; j < n / 2; j++) {   // swap up to middle
                char temp = res[i][j];
                res[i][j] = res[i][n - 1 - j];
                res[i][n - 1 - j] = temp;
            }
        }
        return res;
    }

}