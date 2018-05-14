/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author Administrador
 */
public class Board {
    private int[][] Board= new int[3][3];
     
     
    public Board(){
        clearBoard();
    }
     
    public void clearBoard(){
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                getBoard()[line][column]=0;
    }
     
    public void showBoard(){
        System.out.println();
        for(int line=0 ; line<3 ; line++){
         
            for(int column=0 ; column<3 ; column++){
                 
                if(getBoard()[line][column]==-1){
                    System.out.print(" X ");
                }
                if(getBoard()[line][column]==1){
                    System.out.print(" O ");
                }
                if(getBoard()[line][column]== 0){
                    System.out.print("   ");
                }
                 
                if(column==0 || column==1)
                    System.out.print("|");
            }
            System.out.println();
        }
                 
    }
 
    public int getPosition(int[] attempt){
        return getBoard()[attempt[0]][attempt[1]];
    }
     
    public void setPosition(int[] attempt, int player){
        if(player == 1)
            getBoard()[attempt[0]][attempt[1]] = -1;
        else
            getBoard()[attempt[0]][attempt[1]] = 1;
    }
 
    public int checkLines(){
        for(int line=0 ; line<3 ; line++){
 
            if( (getBoard()[line][0] + getBoard()[line][1] + getBoard()[line][2]) == -3)
                return -1;
            if( (getBoard()[line][0] + getBoard()[line][1] + getBoard()[line][2]) == 3)
                return 1;
        }
         
        return 0;
                 
    }
     
    public int verificarLinhaColuna(int linha, int coluna, int who){
        
        int contador = 0; //se o contador ficar igual a 2, entao nao da velha
        
           for(int i=0 ; i<3 ; i++){
               //System.out.printf("COMPARANDO b = %d -- who = %d\n", Board[i][coluna], who); 
               if(getBoard()[i][coluna] == who){
                    contador++;
                } 
            }
           //System.out.printf("Coluna = %d -> board = [%d] [%d] = %d\n", who, linha, coluna, contador);
           
           if(contador == 2){
               return 2; // nao vai dar velha pq encontrei posicoes igual ao who
           }
           
           
           contador = 0;
           for(int i=0 ; i<3 ; i++){
               //System.out.printf("COMPARANDO b = %d -- who = %d\n", Board[linha][i], who);
                if(getBoard()[linha][i] == who){
                    contador++;
                } 
            }
         //System.out.printf("Linha = %d -> board = [%d] [%d] = %d\n", who, linha, coluna, contador);
           if(contador == 2){
               return 2;
           }
           else{
               return 0;
           }
         
       
    }
     
     
    public int verificarDiagonal(int linha, int coluna, int who){
         
        int contador=0; 
         int i=0;
         int aux=2;
                 
            if(linha == 0 && coluna == 0 || linha == 2 && coluna == 2){
                for(i=0 ; i<3 ; i++){
                    if(getBoard()[i][i] == who){
                        contador++;
                    }
                }
                //System.out.printf("contador diagonal = %d\n", contador);
                 if(contador == 2){
                    return contador;
                 }   
                 else{
                    return 0;
                 }
            }
             
             
            
            else if(linha == 2 && coluna == 0 || linha == 0 && coluna == 2){
                for(i=0 ; i<3 ; i++){
                    if(getBoard()[i][aux-i] == who){
                        contador++;
                    }
                }
                
                if(contador == 2){
                    return contador;
                 }   
                 else{
                    return 0;
                 }
            }
             
             
             
            else if(linha == 1 && coluna == 1){
                for(i=0 ; i<3 ; i++){
                    if(getBoard()[i][i] == who){
                        contador++;
                    }
                }
                if(contador == 2){
                    return contador;
                }
                
                contador = 0;
                for(i=0 ; i<3 ; i++){
                    if(getBoard()[i][aux-i] == who){
                        contador++;
                    }
                }
                
                if(contador == 2){
                        return contador;
                    }
                    else{
                        return 0;
                    }
            }
             
           return 0;
        }
     
     
    public boolean checkDraw(int who){
      
        int linhaVelha;
        int colunaVelha;
        int contador=0;
         
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (getBoard()[linha][coluna] == 0){
                    
                        contador=0;
                        linhaVelha = linha; // NAO PRECISAVA TER FEITO ISSO, MAS TO COM PREGUICA DE APAGAR AS PARADAS
                        colunaVelha = coluna;
                        //achei a celular vazia, agora fazer as comparacoes
                        if(linhaVelha==0 && colunaVelha==1 || linhaVelha==1 && colunaVelha==0 || linhaVelha==1 && colunaVelha==2 || linhaVelha==2 && colunaVelha==1){
                             contador = verificarLinhaColuna(linhaVelha, colunaVelha, who);
                             if(contador >= 2)
                             {
                                 return false;
                             }
                             //System.out.printf("velha %d -> ESSE PRINT DE DOIDO =  %d\n", who, contador);
                        }
                        else{
                            contador = verificarLinhaColuna(linhaVelha, colunaVelha, who);
                            //System.out.printf("velha %d -> print coluna =  %d\n", who, contador);
                            if(contador >= 2){
                                return false;
                            }
                            contador=0;
                            contador = verificarDiagonal(linhaVelha, colunaVelha, who);
                            //System.out.printf("velha %d -> print diag =  %d\n", who, contador);
                            if(contador >= 2){
                                return false;
                            }
                           
                        }
                         
                  }
            }
        }
        //System.out.printf("valor do contador = %d\n", contador);
         
       return true;
 
        
    }
     
    public int checkColumns(){
        for(int column=0 ; column<3 ; column++){
 
            if( (getBoard()[0][column] + getBoard()[1][column] + getBoard()[2][column]) == -3)
                return -1;
            if( (getBoard()[0][column] + getBoard()[1][column] + getBoard()[2][column]) == 3)
                return 1;
        }
         
        return 0;
                 
    }
     
    public int checkDiagonals(){
        if( (getBoard()[0][0] + getBoard()[1][1] + getBoard()[2][2]) == -3)
            return -1;
        if( (getBoard()[0][0] + getBoard()[1][1] + getBoard()[2][2]) == 3)
            return 1;
        if( (getBoard()[0][2] + getBoard()[1][1] + getBoard()[2][0]) == -3)
            return -1;
        if( (getBoard()[0][2] + getBoard()[1][1] + getBoard()[2][0]) == 3)
            return 1;
         
        return 0;
    }
     
    public boolean fullBoard(){
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                if( getBoard()[line][column]==0 )
                    return false;
        return true;
    }
    
      
    /*Faz a verificação se existe duas posições na tabela iguais 
        mesma linha, ou mesma coluna ou diagonais
        e verifica se a posição é do jogador ou do oponente
    
    retorna : as duas posições para colocar na matriz e a soma dos valores da posição
        Para verificar se a chance é de ganhar ou perder.
    */
    
    public int[] verifica(Board board, int valor){
        int INF = 0x3f3f3f3f;

        //For para verificar todas as primeiro as linhas e depois as colunas
        for (int i = 0; i < 3; i++) {
            
            if (board.getPosition(new int[] {i,0}) == board.getPosition(new int[] {i,1}) && 
                    board.getPosition(new int[] {i,2}) == 0 && 
                    board.getPosition(new int[] {i,0}) == valor)
            {
                return new int[] {i,2, (board.getPosition(new int[] {i,0}) + board.getPosition(new int[] {i,1})), INF};            
            
            }else if (board.getPosition(new int[] {i,0}) == board.getPosition(new int[] {i,2}) && 
                    board.getPosition(new int[] {i,1}) == 0 && 
                    board.getPosition(new int[] {i,0}) == valor)
            {
                return new int[] {i,1, board.getPosition(new int[] {i,0}) + board.getPosition(new int[] {i,2}), INF};
            
            }else if (board.getPosition(new int[] {i,2}) == board.getPosition(new int[] {i,1}) && 
                    board.getPosition(new int[] {i,0}) == 0 &&
                    board.getPosition(new int[] {i,2})  == valor)
            {
                return new int[] {i,0, board.getPosition(new int[] {i,2}) + board.getPosition(new int[] {i,1}), INF};
            
            }

            if (board.getPosition(new int[] {0,i}) == board.getPosition(new int[] {1,i}) && 
                    board.getPosition(new int[] {2,i}) == 0 &&
                    board.getPosition(new int[] {0,i}) == valor)
            {
                return new int[] {2,i, board.getPosition(new int[] {0,i}) + board.getPosition(new int[] {1,i}), INF};            
            
            }else if (board.getPosition(new int[] {0,i}) == board.getPosition(new int[] {2,i}) && 
                    board.getPosition(new int[] {1,i}) == 0 &&
                    board.getPosition(new int[] {0,i}) == valor)
            {
                return new int[] {1,i, board.getPosition(new int[] {0,i}) + board.getPosition(new int[] {2,i}), INF};
            
            }else if (board.getPosition(new int[] {2,i}) == board.getPosition(new int[] {1,i}) && 
                    board.getPosition(new int[] {0,i}) == 0 &&
                    board.getPosition(new int[] {2,i}) == valor)
            {
                return new int[] {0,i, board.getPosition(new int[] {2,i}) + board.getPosition(new int[] {1,i}), INF};

            }
        }
        
        if (board.getPosition(new int[] {0,0}) == board.getPosition(new int[] {1,1}) && 
                board.getPosition(new int[] {2,2}) == 0 &&
                board.getPosition(new int[] {0,0}) == valor)
        {
            return new int[] {2, 2, board.getPosition(new int[] {0,0}) + board.getPosition(new int[] {1,1}), INF};            
        
        }else if (board.getPosition(new int[] {0,0}) == board.getPosition(new int[] {2,2}) && 
                board.getPosition(new int[] {1,1}) == 0 &&
                board.getPosition(new int[] {0,0}) == valor)
        {
            return new int[] {1, 1, board.getPosition(new int[] {0,0}) + board.getPosition(new int[] {2,2}), INF};            
    
        
        }else if (board.getPosition(new int[] {2,2}) == board.getPosition(new int[] {1,1}) && 
                board.getPosition(new int[] {0,0}) == 0 &&
                board.getPosition(new int[] {2,2}) == valor)
        {
            return new int[] {0, 0, board.getPosition(new int[] {2,2}) + board.getPosition(new int[] {1,1}), INF};            
    
        }
            
        if (board.getPosition(new int[] {0,2}) == board.getPosition(new int[] {1,1}) && 
                board.getPosition(new int[] {2,0}) == 0 &&
                board.getPosition(new int[] {0,2}) == valor)
        {
            return new int[] {2, 0, board.getPosition(new int[] {0,2}) + board.getPosition(new int[] {1,1}), INF};
            
        }else if (board.getPosition(new int[] {0,2}) == board.getPosition(new int[] {2,0}) && 
                board.getPosition(new int[] {1,1}) == 0 &&
                board.getPosition(new int[] {0,2}) == valor)
        {
            return new int[] {1, 1, board.getPosition(new int[] {0,2}) + board.getPosition(new int[] {2,0}), INF};            

        }else if (board.getPosition(new int[] {1,1}) == board.getPosition(new int[] {2,0}) && 
                board.getPosition(new int[] {0,2}) == 0 &&
                board.getPosition(new int[] {1,1}) == valor)
        {
            return new int[] {0, 2, board.getPosition(new int[] {1,1}) + board.getPosition(new int[] {2,0}), INF};            

        }
        
        int[] attempt = new int[4];
//        boolean flag = true;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                if(board.getPosition(new int[] {i,j}) == 0){
                    attempt[0] = i;
                    attempt[1] = j;
                    attempt[2] = 0;
                    attempt[3] = -INF;
                    return attempt;
                }
            }
        }
        
        return attempt;
    }

    /**
     * @return the Board
     */
    public int[][] getBoard() {
        return Board;
    }

    /**
     * @param Board the Board to set
     */
    public void setBoard(int[][] Board) {
        this.Board = Board;
    }
}


