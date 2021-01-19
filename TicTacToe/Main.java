package TicTacToe;
import java.util.Scanner;
import java.util.*;

public class Main {


    public static void run_game(){
        Scanner scan = new Scanner(System.in);
        while (true){
            if (utilities.is_board_full()){
                //full board
                System.out.println("\n"+"\033[0;1m"+"GAME OVER.");
                utilities.print_board();
                break;
            }
            utilities.print_board();
            Hashtable<String, Integer> move = utilities.get_user_input(scan);
            if (move.containsKey("row")){
                //valid move
                utilities.make_move(move.get("row"), move.get("col"));
                if (is_winning_move.check_win(utilities.gameBoard)){
                    utilities.print_board();
                    break;
                }
                utilities.update_player();
            }
            else {
                //invalid move
                if(utilities.player_1){System.out.println("Player 1 - Invalid move. Try again.");}else{System.out.println("Player 2 - Invalid move. Try again.");}
            }
        }
        scan.close();
    }


    public static void main(String[] args) {
        run_game();
    }


}
