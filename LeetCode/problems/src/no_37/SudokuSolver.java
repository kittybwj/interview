package no_37;

import java.util.Arrays;

/**
 * Created by kitty on 2019/1/22.
 */
class Solution {
    public char[][] temp;
    public char[][] row;
    public char[][] column;
    public char[][] box;
    public int flag = 0;

    private void solve(int i,int j,int value,char[][] board){
        if (i == 9){
            return;
        }
        //回退
        if (flag == 1){
            if (temp[i][j] == '.'){
                int v = board[i][j] -'0';
                board[i][j] = '.';
                row[i][v-1] = ' ';
                column[j][v-1] = ' ';
                int num = i/3*3+j/3;
                box[num][v-1] = ' ';
                value = v+1;
            }else {
                if (j==0){
                    solve(i-1,8,1,board);
                }else {
                    solve(i,j-1,1,board);
                }
            }
        }
        if (board[i][j] == '.'){
            if (value>9){
                if (j==0){
                    solve(i-1,8,1,board);
                }else {
                    solve(i,j-1,1,board);
                }
            }
            int k = 1;
            if (flag==1)
            {
                k = value;
            }

            for( ;k<=9;k++){
                if(row[i][k-1] != '.' && column[j][k-1] !='.' && box[i/3*3+j/3][k-1] !='.' ){
                    flag = 0;
                    board[i][j] = (char)('0' + k);
                    row[i][k-1] = '.';
                    column[j][k-1] = '.';
                    int num = i/3*3+j/3;
                    box[num][k-1] = '.';
                    if (j==8){
                        solve(i+1,0,1,board);
                    }else {
                        solve(i,j+1,1,board);
                    }
                }
                if (k == 9 && board[i][j] == '.'){
                    flag = 1;
                    if (j==0){
                        solve(i-1,8,1,board);
                    }else {
                        solve(i,j-1,1,board);
                    }
                }
            }
        }else {
            if (j==8){
                solve(i+1,0,1,board);
            }else {
                solve(i,j+1,1,board);
            }
        }
    }

    public void solveSudoku(char[][] board) {
        //行数组、列数组、方块数组
        temp = new char[9][9];
        row = new char[9][9];
        column = new char[9][9];
        box = new char[9][9];

        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                temp[i][j] = board[i][j];
                if(board[i][j] !='.'){
                    int intNum = board[i][j] - '0';
                    row[i][intNum-1] = '.';
                    column[j][intNum-1] = '.';
                    int num = i/3*3+j/3;
                    box[num][intNum-1] = '.';
                }
            }
        }

        solve(0,0,1,board);
    }

    public void solveSudoku1(char[][] board) {
        //行数组、列数组、方块数组
        temp = new char[9][9];
        row = new char[9][9];
        column = new char[9][9];
        box = new char[9][9];

        solve(0,0,1,board);
    }
}