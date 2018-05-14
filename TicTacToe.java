/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 
/**
 *
 * @author Administrador
 */
import java.util.Scanner;
//import conteudo.Imagem;
 
public class TicTacToe {
    private Board board;
    private int turn=1, who=1;
    private Player player1;
    private Player player2;
    public Scanner input = new Scanner(System.in);
 
     
    public TicTacToe(){
        board = new Board();
        startPlayers();
        while(  Play() );
      
    }
     
    public void startPlayers(){
        System.out.println("Who will be player1 ?");
        if(choosePlayer() == 1)
            this.player1 = new Human(1);
        else
            this.player1 = new Computer(1);
         
        System.out.println("----------------------");
        System.out.println("Who will be Player 2 ?");
         
        if(choosePlayer() == 1)
            this.player2 = new Human(2);
        else
            this.player2 = new Computer(2);
         
    }
     
    public int choosePlayer(){
        int option=0;
         
        do{
            System.out.println("1. Human");
            System.out.println("2. Computer\n");
            System.out.print("Option: ");
            option = input.nextInt();
             
            if(option != 1 && option != 2)
                System.out.println("Invalid Option! Try again");
        }while(option != 1 && option != 2);
         
        return option;
    }
     
    public boolean Play(){
        board.showBoard();
        if(won() == 0 ){ //Verifica quem ganhou ou se nao acabou a jogada
            if(board.fullBoard()){
                System.out.println("\nFull Board. Draw!");
                return false;
            }
            
           if(turn == 8){
               
    
               if(board.checkDraw(-1) && board.checkDraw(1)){
                   System.out.println("DEU VELHA MALUCO!!");
                    return false;
               }
           }
            
            if(turn == 9){
              
                if(board.checkDraw(-1)){
                    System.out.println("DEU VELHA MALUCO!!");
                    return false;
                }   
            }
             
            System.out.println("----------------------");
            System.out.println("\nTurn "+turn);
            System.out.println("It's turn of Player " + who() );
             
            if(who()==1)
                player1.play(board);
            else
                player2.play(board);
             
             
             
            who++;
            turn++;
 
            return true;
        } else{
            if(won() == -1 )
                System.out.println("Player 1 won!");
            else if(won() == 1)
                System.out.println("Player 2 won!");
             
            return false;
        }
             
    }
     
    public int who(){
        if(who%2 == 1)
            return 1;
        else
            return 2;
    }
     
    public int won(){
        if(board.checkLines() == 1)
            return 1;
        if(board.checkColumns() == 1)
            return 1;
        if(board.checkDiagonals() == 1)
            return 1;
         
        if(board.checkLines() == -1)
            return -1;
        if(board.checkColumns() == -1)
            return -1;
        if(board.checkDiagonals() == -1)
            return -1;
         
        return 0;
    }
     
    public static void main(String args[]) {
        new TicTacToe();
    }
}