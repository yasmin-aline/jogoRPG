package JogoRPG;

import java.util.Scanner;

public class Jogo {
    private Inimigo inimigo;
    private Jogador personagem; // Adicionando personagem como um atributo da classe Jogo - a classe inteira o enxergará

    Scanner entrada = new Scanner(System.in);

    int ataque;
    int opcao;
    String [] cenario = {"🏰 1- Castelo do Caos Encantado", "🏞️ 2- Vale dos Bugs Bizarros", "🏕️ 3- Montanha da Mente Mística", "🏝️ 4- Ilha da Imaginação Inexplorada", "🏫 5- Academia ElasTech", "🌄 6- Floresta da Orientação a Objetos"};
    public void contagemRegressiva(int qtd, boolean exibeNumero) {
        try {
            // Contagem regressiva de 3 até 1
            for (int i = qtd; i >= 1; i--) {
                if (exibeNumero){
                    System.out.print(i + "    ");
                }else{
                    System.out.print(".    ");
                }
                // Pausa de 1 segundo entre cada contagem
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("A contagem regressiva foi interrompida.");
        }
    }

    public void tempo(int qtd) {
        try {
            Thread.sleep(qtd);
        } catch (InterruptedException e) {
            System.out.println("Erro na passagem de tempo.");
        }
    }

    public void letraVermelha(){
        System.out.print("\u001B[31m");
    }

    public void letraVerde(){
        System.out.print("\u001B[32m");
    }

    public void letraPadrao(){
        System.out.print("\u001B[0m");
    }

    public void letraAmarela(){
        System.out.print("\u001B[33m");
    }

    public void letraAzul(){
        System.out.printf("\u001B[34m");
    }

    public void letraMagenta(){
        System.out.printf("\u001B[35m");
    }

    public void letraCiano(){
        System.out.printf("\u001B[36m");
    }

    public void letraBranca(){
        System.out.printf("\u001B[37m");
    }

    public void fundoVermelho(){
        System.out.printf("\u001B[41m");
    }

    public void fundoVerde(){
        System.out.printf("\u001B[42m");
    }

    public void fundoAmarelo(){
        System.out.printf("\u001B[43m");
    }

    public void fundoAzul(){
        System.out.printf("\u001B[44m");
    }

    public void fundoMagenta(){
        System.out.printf("\u001B[45m");
    }

    public void fundoCiano(){
        System.out.printf("\u001B[46m");
    }

    public void fundoBranco(){
        System.out.printf("\u001B[47m");
    }

    public void fundoPadrao(){
        System.out.printf("\u001B[49m");
    }
    public void exibeCaracteres(String[] texto){
        for (int i = 0; i < texto.length; i++) { // no nosso caso, esse for passará apenas uma vez, pois o array só tem 1 string - tam array é 1
            for (int j = 0; j < texto[i].length(); j++) { //o i sempre será 1, pois o array só tem 1 posição
                System.out.print(texto[i].charAt(j)); //charAt é um método que pega um caracter de uma determinada possição de uma String
                tempo(100);
            }
        }
    }

    public void titulo(){
        fundoAmarelo();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");

        fundoPadrao();
        String [] jogo = {"CodeCaos: A Jornada ElasTech pelo Reino de Java"};
        letraVermelha();
        exibeCaracteres(jogo);

        String [] versao = {" - Release 6.66"};
        letraVerde();
        exibeCaracteres(versao);

        letraPadrao();
    }
    public void historia() {
        System.out.println("\n\nEm uma academia de magia, o Professor Mal planeja subjugar os alunos para seus propósitos malignos. Sofia, Lina e Elena, alunas talentosas, descobrem seus planos");
        tempo(2700);
        System.out.println("\n \n    e decidem detê-lo. Com coragem e habilidades únicas, elas enfrentam desafios perigosos e confrontam o vilão em sua fortaleza. Com trabalho em equipe e");
        tempo(2700);
        System.out.println("\n \n       determinação, elas derrotam o Professor Mal, tornando-se heroínas celebradas e inspirando outros estudantes a defender o bem contra o mal.");
        tempo(2700);
    }

    public void msgInicial(){
        letraVermelha();
        System.out.printf("\n\nP r e p a r e - s e !\n\n");
        letraVerde();
        System.out.printf("O jogo iniciará em 3 segundos...\n\n");
        tempo(500);
        letraPadrao();
    }

    public void cenario(){
        int escolha;
        letraVerde();
        System.out.println("\n\n\nVamos configurar seu jogo");
        letraPadrao();
        do{
            System.out.print("\n\nCenários disponíveis: \n");
            for (String cenario : cenario) {
                System.out.println(cenario);
            }
            System.out.println("Escolha o cenário desejado entre 1 e " + cenario.length + ": ");
            while (!entrada.hasNextInt()) {
                System.out.println("Opção inválida! Digite um número correspondente à opção desejada.");
                System.out.print("Escolha uma opção: ");
                entrada.next(); // Limpar o buffer do scanner
            }
            escolha = entrada.nextInt();
            if (escolha > 0 && escolha <= cenario.length){
                System.out.println("Bem-vinda a " + cenario[escolha-1]);
            } else {
                // Caso contrário, informar ao usuário que o número é inválido
                System.out.println("Número inválido. O número deve estar entre 1 e " + cenario.length + ".");
            }
        }while(escolha == 0 || escolha > cenario.length);
    }

    public void criarInimigo(){
        letraAzul();
        System.out.println("\n\n\nAguarde enquanto sorteamos seu oponente");
        letraVermelha();
        contagemRegressiva(5,false);
        letraPadrao();
        this.inimigo = new Inimigo();
        inimigo.setNome(inimigo.nome());
        inimigo.setAvatar(inimigo.avatar());
        inimigo.mostraArsenal();
    }

    public Jogador criarPersonagem() {
        int tipoPersonagem;
        do {
            System.out.println("\n\nDigite 1 para jogar como Guerreira ou 2 para jogar como Maga: ");
            while (!entrada.hasNextInt()) {
                System.out.println("Opção inválida! Digite um número correspondente à opção desejada.");
                System.out.print("Escolha uma opção: ");
                entrada.next(); // Limpar o buffer do scanner
            }
            tipoPersonagem = entrada.nextInt();
            if (tipoPersonagem != 1 && tipoPersonagem != 2) {
                System.out.println("Opção inválida!");
            }
        } while (tipoPersonagem != 1 && tipoPersonagem != 2);

        entrada.nextLine(); //Consumir linha após o nextInt
        System.out.println("\n\nEntre com o nome da sua personagem: ");
        String nome = entrada.nextLine();

        Jogador personagem;
        if (tipoPersonagem == 1) {
            Guerreira guerreira = new Guerreira(nome);
            guerreira.avatar();
            guerreira.mostrarArsenal();
            personagem = guerreira;
        } else {
            Maga maga = new Maga(nome);
            maga.avatar();
            maga.mostrarArsenal();
            personagem = maga;
        }
        return personagem;
    }

    public void iniciarLuta() {
        do {
            ataque = personagemAtaca();
            if (inimigo.getPorcentagem_vida() <= 0) {
                break;
            }
            ataqueInimigo();
            if (personagem.getPorcentagem_vida() != 0 ){
                System.out.println(personagem.getPorcentagem_vida() + "% " + personagem.getAvatar());
                tempo(1000);
            }
        } while (personagem.getPorcentagem_vida() > 0 && inimigo.getPorcentagem_vida() > 0);
    }

    private int personagemAtaca() {
        ataque = personagem.poderAtaque();
        String arma;
        if (personagem instanceof Guerreira) {
            arma = selecionaArma(((Guerreira) personagem).arma);
        } else { // no caso de personagem instanceof Maga - ter sido instanciado a partir da classe Maga
            arma = selecionaArma(((Maga) personagem).arma);
        }

        // ESTE CÓDIGO COMENTADO É PARA SELEÇÃO RANDÔMICA DA ARMA DE ATAQUE
        /*if (personagem instanceof Guerreira) {
            arma = ((Guerreira) personagem).armaAtaque();
        } else { // no caso de personagem instanceof Maga - ter sido instanciado a partir da classe Maga
            arma = ((Maga) personagem).armaAtaque();
        }*/

        System.out.println("\n" + personagem.getPorcentagem_vida() + "% " + personagem.getAvatar() + " " + arma + " Poder deste ataque: " + ataque);
        tempo(1000);
        if (inimigo.getPorcentagem_vida() >= ataque) {
            inimigo.setPorcentagem_vida(inimigo.getPorcentagem_vida() - ataque);
        } else { // pra não ficar com % de vida negativa
            inimigo.setPorcentagem_vida(0);
            System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t" + inimigo.getPorcentagem_vida() + "% " + inimigo.getAvatar() + " - já era");
            tempo(1000);
        }
        return ataque;
    }

    public String selecionaArma(String[] arsenal){
        int escolha;
        letraVerde();
        do {
            System.out.print("\nArmamento/artefato disponível: ");
            for (int i = 0; i < arsenal.length; i++) {
                System.out.print((i + 1) + "." + arsenal[i] + "  ");
            }
            System.out.print("\nEscolha um item digitando o número correspondente: ");
            while (!entrada.hasNextInt()) {
                System.out.println("Opção inválida! Digite um número correspondente à opção desejada.");
                System.out.print("Escolha uma opção: ");
                entrada.next(); // Limpar o buffer do scanner
            }
            escolha = entrada.nextInt();
            if (escolha < 1 || escolha > arsenal.length) {
                System.out.println("Opção inválida! Escolha um número entre 1 e " + arsenal.length + ".");
            }
        } while (escolha < 1 || escolha > arsenal.length);
        letraPadrao();
        return arsenal[escolha - 1];
    }

    private void ataqueInimigo() {
        ataque = inimigo.poderAtaque();
        System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t" + inimigo.getPorcentagem_vida() + "% " + inimigo.getAvatar() + " " + inimigo.armaAtaque() + " Poder deste ataque: " + ataque);
        tempo(1000);
        if (personagem.getPorcentagem_vida() >= ataque) {
            personagem.setPorcentagem_vida(personagem.getPorcentagem_vida() - ataque);
        } else { // pra não ficar com % de vida negativa
            personagem.setPorcentagem_vida(0);
            System.out.println(personagem.getPorcentagem_vida() + "% " + personagem.getAvatar() + " - já era");
            tempo(1000);
        }
    }

    public void avaliarResultado() {
        if (personagem.getPorcentagem_vida() != 0) {
            personagem.aumentarNivel();
            System.out.println("\nVocê venceu! " + personagem.emojiFimDeJogo(1) + " seu nível aumentou para " + personagem.getNivel() + "\t \t \t" + inimigo.getNome() + " perdeu! " + inimigo.emojiFimDeJogo(2));
        } else {
            inimigo.aumentarNivel();
            System.out.println("\nVocê foi derrotada! " + personagem.emojiFimDeJogo(2) + " seu nível atual é " + personagem.getNivel() + "\t \t \t " + inimigo.getNome() + " venceu! " + inimigo.emojiFimDeJogo(1));
        }
    }

    public int menu(){
        do{
            letraCiano();
            System.out.println("\n");
            System.out.println("------------------------------");
            System.out.println("| * *** **** MENU **** *** * |");
            System.out.println("|----------------------------|");
            System.out.println("| 1. Jogar                   |");
            System.out.println("| 2. Instruções              |");
            System.out.println("| 3. Estatística             |");
            System.out.println("| 4. Sair                    |");
            System.out.println("|____________________________|");
            while (!entrada.hasNextInt()) {
                System.out.println("Opção inválida! Digite um número correspondente à opção desejada.");
                System.out.print("Escolha uma opção: ");
                entrada.next(); // Limpar o buffer do scanner
            }
            opcao = entrada.nextInt();
            if (opcao < 1 || opcao > 4){
                System.out.println("Opção inválida!");
            }
        }while (opcao < 1 || opcao > 4);
        return opcao;
    }

    public void instrucoes(){
        System.out.println("\n\nSeu objetivo é derrotar o inmigo, que é escolhido aleatoriamente pelo sitema entre os seguintes vilões: ");
        // tive que exibir de forma fixa os inimigos ao invés de usar o método inimigo.mostraInimigos pois a classe ainda não foi instanciada - o jogo ainda não foi iniciado
        String [] inimigos = {"Rafael, Icoma, Java ou Thanos"};
        letraVermelha();
        exibeCaracteres(inimigos);
        letraPadrao();
        System.out.println("\nVocê também precisará contar com a sorte.");
        System.out.println("Está preparada? Que comecem os jogos!!!");
        tempo(1500);
    }

    public void iniciarJogo() {
        opcao = 0;
        int rounds = 0;
        double porcent_vitorias = 0;
        titulo();
        historia();

        while (opcao != 4) {
            menu();
            switch (opcao) {
                case 1: // Jogar
                    cenario();
                    criarInimigo();
                    String dadosInimigo = inimigo.getPorcentagem_vida() + "% " + inimigo.getNome() + " " + inimigo.getAvatar();
                    tempo(1000);
                    boolean criarPersonagem = false;
                    String resposta;
                    if (rounds == 0) {
                        // 1ª batalha deve criar personagem
                        criarPersonagem = true;
                    }else{ // verificar se quer criar outro personagem ou continuar com o mesmo
                        do{
                            System.out.println("\n\nDeseja criar um novo personagem (S/N)?");//caso contrário, continuará a jogar com o anterior
                            resposta = entrada.next(); // não precisa ser next line, não será palavra composta
                            if (resposta.equalsIgnoreCase("s")) {
                                criarPersonagem = true;
                            }else if (resposta.equalsIgnoreCase("n")) {
                                criarPersonagem = false;
                            }else {
                                System.out.println("Resposta inválida. Digite 's' para sim ou 'n' para não.");
                            }
                        }while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n")); //pra ignorar se digitar em maiúscula ou minúscula
                    }

                    if (criarPersonagem){
                        rounds = 0; // zera pois será o primeiro round dessa personagem que está sendo criada
                        personagem = criarPersonagem();
                    }
                    personagem.setPorcentagem_vida(100);
                    ++rounds;
                    msgInicial();
                    contagemRegressiva(3, true);
                    String dadosJogador = personagem.getPorcentagem_vida() + "% " + personagem.getNome() + " " + personagem.getAvatar();
                    System.out.println("\n\n \t \t" + dadosJogador + "\t \t \t \t   VERSUS \t \t" + dadosInimigo);

                    iniciarLuta();
                    avaliarResultado();
                    tempo(1500);
                    break;
                case 2: // Instruções
                    instrucoes();
                    tempo(1500);
                    break;
                case 3:
                    letraAzul();
                    if (rounds == 0) {
                        System.out.println("\nVocê não participou de nenhuma batalha!");
                    }else {
                        System.out.println("\nEstatística");
                        letraPadrao();
                        System.out.println(personagem.getAvatar() + " " + personagem.getNome() + " participou de " + rounds + " batalhas");
                        System.out.println("Número de vitórias: " + personagem.getNivel());
                        System.out.println("Número de derrotas: " + (rounds - personagem.getNivel()));
                        if (personagem.getNivel() != 0) {
                            porcent_vitorias = ((double) personagem.getNivel() / rounds) * 100;
                            System.out.println("Porcentagem de vitórias: " + porcent_vitorias + " %");
                        }
                    }
                    tempo(1500);
                    break;
                default:
                    letraVerde();
                    System.out.println("\nObrigada por jogar CodeCaos.❤️ Sua jornada ElasTech pelo Reino de Java ainda não terminou!!! 😅😎");
                    tempo(1500);
                    break;
            }
        }
    }
}

