import java.text.DecimalFormat;
import java.util.Scanner;
import pacote.quartoHotel;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#, ##0.00");
        double totalHotel = 0;
        quartoHotel[][] matriz = new quartoHotel[2] [5];
        for(int v = 0; v<2; v++){
            for(int c = 0; c<5; c++){
                matriz [v][c] =new quartoHotel(c, (double) (Math.random()*100));
            }
        }
        int opcao = 0;
        do{
            System.out.println("\nMenu");
            System.out.println("1 - Consultar quartos");
            System.out.println("2 - Reservar Quarto");
            System.out.println("3 - Liberar quarto");
            System.out.println("4 - Consultar faturamento do Hotel");
            System.out.println("5 - Sair");
            opcao = ler.nextInt();
            
            switch(opcao){

                /* Consulta de Quartos */
                case 1: System.out.println("\nDigite o andar (1 ou 2): ");
                        int andar = ler.nextInt() - 1;
                        if(andar != 0 && andar != 1){
                            System.out.println("Digite um andar válido!");
                            break;
                        }
                        int quarto;
                        if(andar == 0){
                            System.out.println("\nDigite o quarto(de 1 a 5)");
                            quarto = ler.nextInt() - 1;
                            if(quarto >= 5 || quarto < 0){
                                System.out.println("Digite um quarto válido!");
                                break;
                            }
                            if(matriz[andar][quarto].getSituacao() == true){
                                System.out.println("Quarto " + (quarto + 1) + " já foi reservado! ");
                            }else{
                                System.out.println("Quarto " + (quarto + 1) + " não está reservado! ");
                            }
                        }
                        if(andar == 1){
                            System.out.println("\nDigite o quarto(de 6 a 10)");
                            quarto = ler.nextInt() - 6;
                            if(quarto >= 5 || quarto < 0){
                                System.out.println("Digite um quarto válido!");
                                break;
                            }
                            if(matriz[andar][quarto].getSituacao() == true){
                                System.out.println("Quarto " + quarto + " já foi reservado! ");
                            }else{
                                System.out.println("Quarto " + quarto + " está não está reservado! ");
                            }
                        }       
                        break;

                /* Reservar Quarto */
                case 2: 
                        System.out.println("\n Digite o seu RG: ");
                        int hosRG = ler.nextInt();
                        System.out.println("Digite o andar (1 a 2): ");
                        andar = ler.nextInt() - 1;
                        if(andar != 0 && andar != 1){
                            System.out.println("Digite um andar válido!");
                            break;
                        }
                        if(andar == 0){
                            System.out.println("Digite o quarto (de 1 a 5)");
                            quarto = ler.nextInt() - 1;
                            if(quarto >= 5 || quarto < 0){
                                System.out.println("Digite um quarto válido!");
                                break;
                            }
                            if(matriz[andar][quarto].getSituacao() == true){
                                System.out.println("O quarto já esta reservado");
                                break;
                            }
                            matriz[andar][quarto].reservar(hosRG);
                            System.out.println("Quarto" + (quarto + 1) + "reservado");
                        }
                        if(andar == 1){
                            System.out.println("Digite o quarto (de 6 a 10)");
                            quarto = ler.nextInt() - 6;
                            if(quarto >= 5 || quarto < 0){
                                System.out.println("Digite um quarto válido!");
                                break;
                            }
                            if(matriz[andar][quarto].getSituacao() == true){
                                System.out.println("O quarto já esta reservado");
                                break;
                            }
                            matriz[andar][quarto].reservar(hosRG);
                            System.out.println("Quarto" + (quarto + 6) + "reservado");
                        }
                break;

                /* Liberar Quarto */        
                case 3: 
                    System.out.println("Digite quantos dias o hospede ficou no quarto");
                    int numDias = ler.nextInt();
                    if(numDias < 0){
                        System.out.println("Digite uma quantidade de dias válida!");
                        break;
                    }    
                    System.out.println("\n Digite o andar do quarto que deseja liberar: ");
                    andar = ler.nextInt() - 1;
                        if(andar != 0 && andar != 1){
                            System.out.println("Digite um andar válido!");
                            break;
                        }
                        if(andar == 0){
                            System.out.println("Digite o quarto (de 1 a 5)");
                            quarto = ler.nextInt() - 1;
                            if(quarto >= 5 || quarto < 0){
                                System.out.println("Digite um quarto válido!");
                                break;
                            }
                            if(matriz[andar][quarto].getSituacao() == false){
                                System.out.println("O quarto já esta livre");
                                break;
                            }
                            matriz[andar][quarto].liberar(numDias);
                            System.out.println("Quarto liberado, preço a pagar é de " + df.format(matriz[andar][quarto].getTotalFaturado()));
                        }
                        if(andar == 1){
                            System.out.println("Digite o quarto (de 6 a 10)");
                            quarto = ler.nextInt() - 6;
                            if(quarto >= 5 || quarto < 0){
                                System.out.println("Digite um quarto válido!");
                                break;
                            }
                            if(matriz[andar][quarto].getSituacao() == false){
                                System.out.println("O quarto já esta livre");
                                break;
                            }
                            matriz[andar][quarto].liberar(numDias);
                            System.out.println("Quarto liberado, preço a pagar é de " + df.format(matriz[andar][quarto].getTotalFaturado()));
                        }
                    break;
                
                /* Consultar faturamento do Hotel */    
                case 4:
                    totalHotel = 0;    
                    for(int f = 0; f<2; f++){
                        for(int t = 0; t<5; t++){
                            totalHotel += matriz[f][t].getTotalFaturado();
                        }
                    }    
                    System.out.println("\n O faturamento do hotel é de: " +
                    df.format(totalHotel));
                    break;
                
                /* Opção para sair do sistema */
                case 5: System.out.println("Saindo do sistema.");
                break;
                
                /* Em caso de opção errada */
                default: System.out.println("Opção inválida, por favor digite uma opção válida!");
                break;
            }
        }while(opcao != 5);
    }
}