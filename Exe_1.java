class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int f =0;
        int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i<r; ++i){
            for(int y = 0; y<c; ++y){
                if(grid[i][y]==2){
                    q.add(new Pair(i,y));
                } else if(grid[i][y]==1){
                    ++f;
                }
            }
        }
        int t =0;
        while(!q.isEmpty()){
            Queue<Pair> tq = new LinkedList<>();
        while(!q.isEmpty()){
            Pair p = q.remove();
            for(int[] w:d){
                int rc = w[0]+p.r;
                int cc = w[1]+p.c;
                if(rc>=0 && rc<r && cc>=0 && cc<c && grid[rc][cc]==1){
                    tq.add(new Pair(rc,cc));
                    grid[rc][cc] = 2;
                    --f;
                }
                }
            }
                q=tq;
                if(!q.isEmpty()){
                    ++t;}
        }
        return f==0 ? t:-1;
    }
}
class Pair{
    int r,c;
    Pair(int r, int c){
        this.r =r;
        this.c =c;
    }
}
//tc=O(mn)
//sc=O(mn)
