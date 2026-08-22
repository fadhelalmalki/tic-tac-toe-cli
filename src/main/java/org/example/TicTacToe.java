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

    static void makeComputerMove(char[][] gameBoard){

        int computerPosition;

        while(true){
            computerPosition = r.nextInt(9) + 1;

            int row = (computerPosition - 1) / (3);
            int column = (computerPosition - 1) % (3);

            if(gameBoard[row][column] != 'X' && gameBoard[row][column] != 'O'){
                gameBoard[row][column] = 'O';
                System.out.println("\u001B[34m▀▄▀▄▀▄\u001B[0m Computer is playing again \u001B[34m▄▀▄▀▄▀\u001B[0m");
                System.out.println("Computer chose the position: " + computerPosition);
                break;
            }
        }
    }

    static boolean checkGameWinner(char[][] gameBoard, char gameMarker){
        for(int row = 0; row < 3; row++){
            if(gameBoard[row][0] == gameMarker && gameBoard[row][1] == gameMarker && gameBoard[row][2] == gameMarker){
                return true;
            }
        }
        for(int column = 0; column < 3; column++){
            if(gameBoard[0][column] == gameMarker && gameBoard[1][column] == gameMarker && gameBoard[2][column] ==gameMarker){
                return true;
            }
        }
        if(gameBoard[0][0] == gameMarker && gameBoard[1][1] == gameMarker && gameBoard[2][2] == gameMarker){
            return true;
        }
        if(gameBoard[0][2] == gameMarker && gameBoard[1][1] == gameMarker && gameBoard[2][0] == gameMarker){
            return true;
        }
        return false;
    }

    static boolean checkIsGameBoardFull(char[][] gameBoard){
        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 3; column++){
                if(gameBoard[row][column] != 'X' &&  gameBoard[row][column] != 'O'){
                    return false;
                }
            }
        }
        return true;
    }

    static int playOneGameRound(){

        char[][] gameBoard = makeGameBoard();
        System.out.println("\u001B[34m▀▄▀▄▀▄\u001B[0m Let’s begin a new game! \u001B[34m▄▀▄▀▄▀\u001B[0m");

        while(true){
            displayGameBoard(gameBoard);
            makePlayerMove(gameBoard);

            if(checkGameWinner(gameBoard, 'X')){
                displayGameBoard(gameBoard);
                System.out.println("\u001B[34m▀▄▀▄▀▄\u001B[0m \u001B[32mPlayer X won this game round!\u001B[0m \u001B[34m▄▀▄▀▄▀\u001B[0m");
                return 1;
            }
            if(checkIsGameBoardFull(gameBoard)){
                displayGameBoard(gameBoard);
                System.out.println("\u001B[31mNo winner this round!\u001B[0m");
                return 0;
            }

            makeComputerMove(gameBoard);

            if(checkGameWinner(gameBoard, 'O')){
                displayGameBoard(gameBoard);
                System.out.println("\u001B[34m▀▄▀▄▀▄\u001B[0m \u001B[31mComputer won this game round!\u001B[0m \u001B[34m▄▀▄▀▄▀\u001B[0m");
                return -1;
            }
            if(checkIsGameBoardFull(gameBoard)){
                displayGameBoard(gameBoard);
                System.out.println("\u001B[31mNo winner this round!\u001B[0m");
                return 0;
            }
        }
    }

    static void playThreeGameRounds(){

        int playerScore = 0;
        int computerScore = 0;

        for(int round = 1; round <= 3; round++){
            System.out.println("\n╔═══════════════════════════════╗");
            System.out.println("║           ROUND " + round + "   ║");
            System.out.println("╚═══════════════════════════════╝");

            int gameResult = playOneGameRound();
            if(gameResult == 1){
               playerScore++;
            }else if(gameResult == -1){
               computerScore++;
            }

            System.out.println("\n✦══════════ SCOREBOARD ══════════✦");
            System.out.println("      You      : " + playerScore);
            System.out.println("      Computer : " + computerScore);
            System.out.println("✦════════════════════════════════✦");
        }
        System.out.println("\n╔═════════════════════════════════╗");
        System.out.println("║          FINAL RESULT           ║");
        System.out.println("╚═════════════════════════════════╝");
        System.out.println("Your Score      : " + playerScore);
        System.out.println("Computer Score  : " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("\n\u001B[34m▀▄▀▄▀▄\u001B[0m \u001B[32mCongratulations! You are the overall winner!\u001B[0m \u001B[34m▄▀▄▀▄▀\u001B[0m");
        } else if (computerScore > playerScore) {
            System.out.println("\n\u001B[31mNoThe computer is the overall winner!\u001B[0m");
        } else {
            System.out.println("\n\u001B[31mNoIt's an overall draw!\u001B[0m");
        }
    }
}
