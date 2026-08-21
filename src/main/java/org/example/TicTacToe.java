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

            System.out.println("\u001B[31mPlease enter a valid choice\u001B[0m \n");
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

    static void displayGameBoard(){
    }

    static int playOneGameRound(){
        return 0;
    }

    static void playThreeGameRounds(){
    }

    static void makePlayerMove(){
    }

    static void makeComputerMove(){
    }

    static boolean checkGameWinner(){
        return false;
    }

    static boolean checkIsGameBoardFull(){
        return false;
    }
}
