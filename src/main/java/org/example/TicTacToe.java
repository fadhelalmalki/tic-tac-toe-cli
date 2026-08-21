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

    }

    static void startWelcoming(String text) throws InterruptedException {
        for (char character : text.toCharArray()) {
            System.out.print(character);
            Thread.sleep(3);
        }
        System.out.println("\n\u001B[36m                   .oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.\u001B[0m");
        System.out.println("\n                                            \u001B[35mLet The Game Begin!\u001B[0m");
        System.out.println("\n\u001B[36m                   .oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.\u001B[0m");
    }

    static int chooseGameRound(){
        return 0;
    }

    static int playOneGameRound(){
        return 0;
    }

    static void playThreeGameRounds(){
    }

    static char[][] makeGameBoard(){
        return null;
    }

    static void displayGameBoard(){
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
