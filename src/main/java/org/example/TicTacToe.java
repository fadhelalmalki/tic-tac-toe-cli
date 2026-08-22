package org.example;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static Scanner s = new Scanner(System.in);
    static Random r = new Random();

    static void main() {

        String title = """                
█▀▀▀▀▀▀▀▀▀▀█ █▀▀▀▀█  ▄▀▀▀▀▀▀▀▀▀█      █▀▀▀▀▀▀▀▀▀▀█  ▄▀▀▀▀▀▀▀▀▀█  ▄▀▀▀▀▀▀▀▀▀█      █▀▀▀▀▀▀▀▀▀▀█  ▄▀▀▀▀▀▀▀▀▄   ▄▀▀▀▀▀▀▀▀▀█
█▄▄▄·   ▄▄▄█ ▀    ▓ █·   ▄▄▄▄▄▄█      █▄▄▄·   ▄▄▄█ █   .▄▄   ∙▀ █·   ▄▄▄▄▄▄█      █▄▄▄·   ▄▄▄█ ▀    ▄▄ .  █ █·   ▄▄▄▄▄▄█
   ▓  . ▓    ▓    ▓ ▓  . ▓               ▓  . ▓    ▓    ▐▄▌.  ▓ ▓  . ▓               ▓  . ▓    ▓    ▓ ▌   ▓ ▓  . ▓▄▄▄▄▄▄
   ▒ ∙  ▒    ▒   ·▒ ▒ ∙  ▒               ▒ ∙  ▒    ▒∙ . ▄▄▄   ▒ ▒ ∙  ▒               ▒ ∙  ▒    ▒  · ▒ ▓   ▒ ▒ ∙  ▄▄▄▄▄▄▒
   ░    ░    ░ .  ░ ░    ░▄▄▄▄▄▄         ░    ░    ░    ░ ░  ·░ ░    ░▄▄▄▄▄▄         ░    ░    ░    ░▄░·. ░ ░    ░▄▄▄▄▄▄
   █    █    █    █ █    .    ·█         █    █    █ .  █ █   █ █    .    ·█         █    █    █   .      █ █    .    ·█
   █▄▄▄▄█    █▄▄▄▄█ █▄▄▄▄▄▄▄▄▄▄█         █▄▄▄▄█    █▄▄▄▄█ █▄▄▄█ █▄▄▄▄▄▄▄▄▄▄█         █▄▄▄▄█     ▀▄▄▄▄▄▄▄▄▀  █▄▄▄▄▄▄▄▄▄▄█  
                """;
        try{
            startWelcoming(title);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

        int gameRoundType = chooseGameRound();
        if(gameRoundType == 1){
            playOneGameRound();
        }else if(gameRoundType == 2){
            playThreeGameRounds();
        }
   }

    static void startWelcoming(String text) throws InterruptedException {
        for (char character : text.toCharArray()) {
            System.out.print(character);
            Thread.sleep(3);
        }
        System.out.println("\n                   \u001B[36m.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.\u001B[0m");
        System.out.println("\n                                               \u001B[35mLet The Game Begin!\u001B[0m");
        System.out.println("\n                   \u001B[36m.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.\u001B[0m");
    }

    static int chooseGameRound(){

        while(true){
            System.out.println("                               \u001B[34m▀▄▀▄▀▄\u001B[0m You play as X, while the computer plays as O \u001B[34m▄▀▄▀▄▀\u001B[0m\n");
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║        CHOOSE YOUR CHOICE        ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║  1. Play one game round          ║");
            System.out.println("║  2. Play three game rounds       ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("Choose your choice: ");
            String choice = s.nextLine();
            if(choice.equals("1")){
                return 1;
            }else if(choice.equals("2")){
                return 2;
            }

            System.out.println("\u001B[31mPlease enter a valid choice\u001B[0m\n");
        }
    }

    static char[][] makeGameBoard(){

        char[][] gameBoard = new char[3][3];
        char boardPosition = '1';

        for(int row = 0 ; row < 3 ; row++){
            for(int column = 0 ; column < 3 ; column++){
                gameBoard[row][column] = boardPosition;
                boardPosition++;
            }
        }
        return gameBoard;
    }

    static void displayGameBoard(char[][] gameBoard) {
        System.out.println();

        for (int row = 0; row < 3; row++) {
            System.out.println("     |     |     ");
            System.out.println("  " + gameBoard[row][0] + "  |  " + gameBoard[row][1] + "  |  " + gameBoard[row][2]);

            if (row < 2) {
                System.out.println("-----+-----+-----");
            }
        }

        System.out.println("     |     |     ");
        System.out.println();
    }

    static void makePlayerMove(char[][] gameBoard){

        while(true){
            System.out.println("\u001B[34m▀▄▀▄▀▄\u001B[0m Choose your position number for this turn (1-9): \u001B[34m▄▀▄▀▄▀\u001B[0m");
            int playerPosition = s.nextInt();

            if(playerPosition < 1 || playerPosition > 9){
                System.out.println("\u001B[31mPlease enter a position number between 1 and 9\u001B[0m");
                continue;
            }

            int row = (playerPosition - 1) / (3);
            int column = (playerPosition - 1) % (3);

            if(gameBoard[row][column] == 'X' || gameBoard[row][column] == 'O'){
                System.out.println("\u001B[31mThis position is taken, please reenter another position number\u001B[0m");
                continue;
            }

            gameBoard[row][column] = 'X';
            break;
        }
    }

    static void makeComputerMove(){

    }

    static int playOneGameRound(){
        return 0;
    }

    static void playThreeGameRounds(){
    }

    static boolean checkGameWinner(){
        return false;
    }

    static boolean checkIsGameBoardFull(){
        return false;
    }
}
