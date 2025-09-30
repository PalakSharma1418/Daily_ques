// Last updated: 9/30/2025, 8:28:58 PM
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
            int j=0;
            int k=image[i].length-1;
            while(j<=k){
                int temp=image[i][j]^1;
                image[i][j]=image[i][k]^1;
                image[i][k]=temp;
                j++;
                k--;
            }
            
        }
        return image;
    }
}