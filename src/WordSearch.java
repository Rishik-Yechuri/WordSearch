/*


PROBLEM: Word Search! 

    Given an m x n grid of characters board and a string word, return true if word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are             horizontally or vertically neighboring. The same letter cell may not be used more than once.
    
    
    E.g.
    INPUT:
    board = [["A","B","C","E"],
             ["S","F","C","S"],
             ["A","D","E","E"]], 
             
          
            
    word = "ABCCED"
    
    OUTPUT:
    True.
    
    1. Find all instances of the first letter of the word
    2. for each instance find second letter,and if not possible, remove location from 2d with locations
    3. repeat until a word is found, or until no instances are left
    
    
    1. Loop through every position on the board and run DFS on that position
 */

import java.io.*;
import java.util.*;


class Solution {
    public static void main(String[] args) {

        char[][] test = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word1 = "ABCCED";
        assert wordSearch(test, word1);

        String word2 = "SEE";
        assert wordSearch(test, word2);

        String word3 = "ABCB";
        assert !wordSearch(test, word3);

        String word4 = "ABCESEEDASA";
        assert !wordSearch(test, word4);

        String word5 = "ABCESEEDAS";
        assert wordSearch(test, word5);

        System.out.println("You've passed all the tests! :)");

    }

    public static boolean wordSearch(char[][] grid, String word) {
        for(int x=0;x<grid[0].length;x++){
            for(int y=0;y<grid.length;y++){
                if(DFSonLetter(grid,new int[grid[0].length][grid.length],0,x,y,word))return true;
            }
        }
        return false;
    }
    public static boolean DFSonLetter(char[][] grid, int[][] visitedSpots,int letterInWord,int x,int y,String wordToLookFor){
        if(x>=0 && x<grid[0].length && y >= 0 && y < grid.length){
            if(grid[y][x] == wordToLookFor.charAt(letterInWord)){
                if(letterInWord == wordToLookFor.length() - 1){
                    System.out.println("letter in word:" + letterInWord + " wordToLookFor.length:" + wordToLookFor.length());
                    return true;
                }
                visitedSpots[x][y] = 1;
                letterInWord++;
                if(letterInWord<wordToLookFor.length()){
                    if(x+1 < grid[0].length && !(visitedSpots[x+1][y] == 1)){
                        if(DFSonLetter(grid,visitedSpots,letterInWord,x+1,y,wordToLookFor)) return true;
                    }
                    if(x-1 >= 0 && !(visitedSpots[x-1][y] == 1)){
                        if (DFSonLetter(grid,visitedSpots,letterInWord,x-1,y,wordToLookFor)) return true;
                    }
                    if(y+1 < grid.length && !(visitedSpots[x][y+1] == 1)){
                        if (DFSonLetter(grid,visitedSpots,letterInWord,x,y+1,wordToLookFor)) return true;
                    }
                    if(y-1 >= 0 && !(visitedSpots[x][y-1] == 1)){
                        if (DFSonLetter(grid,visitedSpots,letterInWord,x,y-1,wordToLookFor)) return true;
                    }
                    return false;
                }else{

                }
            }else{
                return false;
            }
            return false;
        }
        return false;
    }
}