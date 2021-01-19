package TicTacToe;
import java.util.*;

public class utilities {

    public static boolean player_1 = true;
    public static char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                                        {'-', '+', '-', '+', '-'},
                                        {' ', '|', ' ', '|', ' '},
                                        {'-', '+', '-', '+', '-'},
                                        {' ', '|', ' ', '|', ' '},};


    public static void print_board(){
        System.out.println();
        for(char [] row : gameBoard){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
    }


    public static int get_row_board_index(int row){
        if (row == 1){
            return 0;
        }
        else if (row == 3){
            return (row+1);
        }
        return row;
    }


    public static int get_col_board_index(int col){
        if (col == 1){
            return 0;
        }
        else if (col == 3){
            return (col+1);
        }
        return col;
    }


    public static boolean is_valid_move(int row, int col){
        int row_index;
        int col_index;
        if ((row <= 3 && row >= 1) && (col <= 3 && col >= 1)){
            row_index = get_row_board_index(row);
            col_index = get_col_board_index(col);
            if (gameBoard[row_index][col_index] == ' '){
                return true;
            }
        }
        return false;
    }


    public static Hashtable<String, Integer> get_user_input(Scanner scan){
        Hashtable<String, Integer> input = new Hashtable<String, Integer>();
        int row;
        int col;
        System.out.println("Enter row:");
        row = scan.nextInt();
        System.out.println("Enter column:");
        col = scan.nextInt();
        if (is_valid_move(row, col)){
            input.put("row", row);
            input.put("col", col);
        }
        return input;
    }


    public static boolean is_board_full(){
        for (char[] row: gameBoard){
            for(char c: row){
                if (c == ' '){
                    return false;
                }
            }
        }
        return true;
    }


    public static void make_move(int row, int col){
        char piece;
        int row_index = get_row_board_index(row);
        int col_index = get_col_board_index(col);
        if (player_1){piece = 'X';}else{piece = 'O';}
        gameBoard[row_index][col_index] = piece;
    }


    public static void update_player(){
        if (player_1){player_1 = false;} else{player_1 = true;}
    }
}
