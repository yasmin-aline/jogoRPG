package JogoRPG;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Jogador {
    Scanner entrada = new Scanner(System.in);

    private String nome;
    private int nivel;
    private int porcentagem_vida;
   // private int poder_ataque; //tirar ou implementar
    //private int poderDefesa; // valor do ataque - poder defesa e desc da % vida
    private String avatar;

    // Array de emojis pra Vencedor
    String [] emojiVencedor = {"🏆","👑","🎈","🥇","🎉","🥳"};

    // Array de emojis pra Perdedor
    String [] emojiPerdedor = {"💀","☠️","💔","⚰️","😢","😭","😔"};
    Random random = new Random();
    public Jogador(String nome){ // o id será gerado, o nome jogador será digitada pelo usuário
        this.nome = nome;
        this.nivel = 0; // sempre inicia o jogo com nível 0
        this.porcentagem_vida = 100; // sempre inicia o jogo com 100% de vida
        //this.poder_ataque = 0; // será randômico NEM PRECISA TER COMO ATRIBUTO, CADA ATAQUE TEM UM PODER
    }

    public Jogador(){ // o nome (do inimigo) nesse construtor será gerado randomicamente após a classe inimigo ser instanciada
        this.nivel = 0; // sempre inicia o jogo com nível 0
        this.porcentagem_vida = 100; // sempre inicia o jogo com 100% de vida
        //this.poder_ataque = 0; // será randômico NEM PRECISA TER COMO ATRIBUTO, CADA ATAQUE TEM UM PODER
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPorcentagem_vida() {
        return porcentagem_vida;
    }

    public void setPorcentagem_vida(int porcentagem_vida) {
        this.porcentagem_vida = porcentagem_vida;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int poderAtaque(){
        return (random.nextInt(21) + 10);
    } // de 10 a 30


    public String emojiFimDeJogo(int resultado){
        if (resultado == 1){ // Venceu o jogo
            return(emojiVencedor[random.nextInt(emojiVencedor.length)]);
        }else{
            return(emojiPerdedor[random.nextInt(emojiPerdedor.length)]);
        }
    }

    // método para incrementar o nível - que aqui será o número de vitórias
    public void aumentarNivel() {
        this.nivel++;
    }

    public void mostraArsenal(String[] arsenal, String mensagem) {
        System.out.print(mensagem);
        for (String item : arsenal) {
            System.out.print(item + " ");
        }
    }

    public String avatar(String[] lstAvatar){
        int escolha, i;
        do{
            System.out.println("\nAvatares disponíveis: ");
            i = 1;
            for (String avatar : lstAvatar){
                System.out.println(i + "- " + avatar);
                i++;
            }
            System.out.println("Escolha seu avatar entre 1 e " + lstAvatar.length + ": ");
            escolha = entrada.nextInt();
            if (escolha > 0 && escolha <= lstAvatar.length){
                System.out.println("O avatar escolhido foi: " + lstAvatar[escolha-1]);
                //setAvatar(avatar[escolha-1]);
            } else {
                // Caso contrário, informar ao usuário que o número é inválido
                System.out.println("Número inválido. O número deve estar entre 1 e " + lstAvatar.length + ".");
            }
        }while(escolha == 0 || escolha > lstAvatar.length);
        return lstAvatar[escolha-1]; // ou poderia retornar o índice da lista
    }
    public  void exibirRanking(List<Jogador> jogadores) {
        // o método comprator irá ordenar os jogadores pelo atributo nível em ordem decrescente
        jogadores.sort(Comparator.comparingInt(Jogador::getNivel).reversed());

        System.out.println("Ranking:");
        int posicao = 1;
        for (Jogador jogador : jogadores) {
            System.out.println(posicao + ". " + jogador.getNome() + " - Nível: " + jogador.getNivel());
            posicao++;
        }
    }

    public String armaAtaque(String[] arsenal){
        return(arsenal[random.nextInt(arsenal.length)]);
    }

}
