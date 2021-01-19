package TicTacToe;

public class is_winning_move {

    //globals
    public static boolean win_player_1 = false;
    public static boolean win_player_2 = false;


    public static void set_winner(char piece){
        if (piece == 'X') {
            win_player_1 = true;
        } else if (piece == 'O'){
            win_player_2 = true;
        }
    }


    public static void horizontal_win(char[][] gameBoard){
        for (char[] row: gameBoard){
            char piece = row[0];
            if (row[0] == row[2] && row[2]== row[4] && piece != ' '){
                set_winner(piece);
            }
        }
    }


    public static void vertical_win(char[][] gameBoard){
        for (int i = 0; i < gameBoard[0].length; i++) {
            char piece = gameBoard[0][i];
            if (gameBoard[0][i] == gameBoard[2][i] && gameBoard[2][i] == gameBoard[4][i] && piece != ' '){
                set_winner(piece);
            }
        }
    }


    public static void diagonal_win(char[][] gameBoard){
        char position;
        char piece = ' ';
        for (int row = 0; row < gameBoard.length; row++){
            for (int col = 0; col < gameBoard[row].length; col++){
                if (row == col){
                    position = gameBoard[row][col];
                    if (row == 0){
                        if(position==' '){break;}else{piece = position;}
                    }
                    else {
                        if(position != piece){break;}else if(row == 4 && gameBoard[2][2] == piece){set_winner(piece);}
                    }
                }
            }
        }
    }


    public static void anti_diagonal_win(char[][] gameBoard){
        char position;
        char piece = ' ';
        for (int row = 0; row < gameBoard.length; row++){
            for (int col = 0; col < gameBoard[row].length; col++){
                if(row + col == gameBoard.length - 1){
                    position = gameBoard[row][col];
                    if (col == gameBoard.length-1){
                        if(position==' '){break;}else{piece=position;}
                    }
                    else {
                        if(position!=piece){break;}else if(col==0 && gameBoard[2][2] == piece){set_winner(piece);}
                    }
                }
            }
        }
    }


    public static boolean check_win(char[][] gameBoard){
        horizontal_win(gameBoard);
        vertical_win(gameBoard);
        diagonal_win(gameBoard);
        anti_diagonal_win(gameBoard);
        if (win_player_1){
            System.out.println("\n"+"\033[0;1m"+"Player 1 wins!");
            return true;
        }
        else if (win_player_2){
            System.out.println("\n"+"\033[0;1m"+"Player 2 wins!");
            return true;
        }
        return false;
    }


}
