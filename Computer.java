public class Computer extends Player{
        
    public Computer(int player){
        super(player);
        this.player = player;
        System.out.println("Player 'Computer' created");
    }
    @Override
    public void play(Board board){
        Try(board);
        board.setPosition(attempt, player); //player == jogador
    }
  
    @Override
    public void Try(Board board){
        int INF = 0x3f3f3f3f;

            int[] auxiliar = new int[4];
            
            if(player == 1){
                auxiliar = board.verifica(board, -1);
            }else{
                auxiliar = board.verifica(board, 1);
            }
            
            /*Se nao houver uma posição possivel de se ganhar,
                é verificado uma posição do oponente ganhar,
                caso nenhum dos casos possiveis, joga na primeira posição vazia
            */  
            if(auxiliar[3] == -INF){
                if(player != 1){
                    auxiliar = board.verifica(board, -1);
                }else{
                    auxiliar = board.verifica(board, 1);
                }                
            }
            
            attempt = auxiliar;
            
    }
}