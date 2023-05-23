//Matheus Nascimento 23484
//Camila Mayara Lenke Vieira 21872
package Calculadora_complexos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i;
        Scanner sc = new Scanner(System.in);
        Estrutura_complexos[] C = new Estrutura_complexos[100];
        Historico historico= new Historico();//criando o historico em paralelo com os complexos
        System.out.println("Bem vindo a calculadora, precione 'A' seguido de ENTER para visualizar a ajuda.");
        for (int j = 0; j < 100; j++)
            C[j]= new Estrutura_complexos(0,0);
        for (i = 2; i < 100; i++){
            C[i] = new Estrutura_complexos(sc);
            char simbolo = C[i].getSimbolo();
            switch (simbolo) {
                case '+':
                    Estrutura_complexos resultadoSoma = C[i].soma(C[i], C[i+1]);
                    C[i+2] = resultadoSoma;
                    Operacao nova_operacao_som = new Operacao(C[i].getReal(), C[i].getImaginario(),C[i].getSimbolo());
                    historico.adicionarOperacao(nova_operacao_som);
                    System.out.println(resultadoSoma);
                    break;

                case '-':
                    Estrutura_complexos resultadoSubtracao = C[i].subtracao(C[i], C[i+1]);
                    C[i+2] = resultadoSubtracao;
                    Operacao nova_operacao_sub = new Operacao(C[i].getReal(), C[i].getImaginario(),C[i].getSimbolo());
                    historico.adicionarOperacao(nova_operacao_sub);
                    System.out.println(resultadoSubtracao);
                    break;
                case '*':
                    Estrutura_complexos resultadoMultiplicacao = C[i].multiplicacao(C[i], C[i+1]);
                    C[i+2] = resultadoMultiplicacao;
                    Operacao nova_operacao_mul = new Operacao(C[i].getReal(), C[i].getImaginario(),C[i].getSimbolo());
                    historico.adicionarOperacao(nova_operacao_mul);
                    System.out.println(resultadoMultiplicacao);
                    break;
                case '/':
                    Estrutura_complexos resultadoDivisao = C[i].divisao(C[i], C[i+1]);
                    C[i+2] = resultadoDivisao;
                    Operacao nova_operacao_div = new Operacao(C[i].getReal(), C[i].getImaginario(),C[i].getSimbolo());
                    historico.adicionarOperacao(nova_operacao_div);
                    System.out.println(resultadoDivisao);
                    break;
                case 'S':
                    Estrutura_complexos resultadoSimetrico = C[i+1].simetrico(C[i+1]);
                    C[i+2] = resultadoSimetrico;
                    Operacao nova_operacao_simetrico = new Operacao(C[i].getReal(), C[i].getImaginario(),C[i].getSimbolo());
                    historico.adicionarOperacao(nova_operacao_simetrico);
                    System.out.println(resultadoSimetrico);
                    break;
                case 'T'://para usar esse metodo usamos um compelexo 0 que se atualiza com o resultado para a operacao seguinte
                    // Troca a ordem das operações
                    int posicao1 = (int)C[i].getReal();
                    int posicao2 = (int)C[i].getImaginario();
                    historico.trocarOperacoes(posicao1-1, posicao2-1);
                    Estrutura_complexos Czero= new Estrutura_complexos(0,0);
                    int k=0;
                    C[k]=Czero;
                    for (k = 0; k < historico.getOperacoes().size(); k++) {
                        Operacao operacao = historico.getOperacao(k);
                        char simboloOperacao = operacao.getOperador();
                        double real=operacao.getNumero1();
                        double imaginario=operacao.getNumero2();
                        Estrutura_complexos operando = new Estrutura_complexos(real,imaginario);
                        Estrutura_complexos resultado;
                        switch (simboloOperacao) {
                            case '+':
                                resultado = Czero.soma(Czero, operando);
                                System.out.print(Czero);
                                System.out.print(simboloOperacao);
                                System.out.println(operando);
                                Czero = resultado;
                                System.out.println("="+resultado);

                                break;
                            case '-':
                                resultado = Czero.subtracao(Czero, operando);
                                System.out.print(Czero);
                                System.out.print(simboloOperacao);
                                System.out.println(operando);
                                Czero = resultado;
                                System.out.println("="+resultado);

                                break;
                            case '*':
                                resultado = Czero.multiplicacao(Czero, operando);
                                System.out.print(Czero);
                                System.out.print(simboloOperacao);
                                System.out.println(operando);
                                Czero = resultado;
                                System.out.println("="+resultado);

                                break;
                            case '/':
                                resultado = Czero.divisao(Czero, operando);
                                System.out.print(Czero);
                                System.out.print(simboloOperacao);
                                System.out.println(operando);
                                Czero = resultado;
                                System.out.println("="+resultado);

                                break;
                            case 'S':
                                resultado = Czero.simetrico(Czero);
                                System.out.println(Czero);
                                System.out.print("->"+simboloOperacao);
                                Czero = resultado;
                                System.out.println(resultado);
                                break;
                            case 'P':
                                resultado = Czero.potenciacao(Czero,(int)real);
                                System.out.println(Czero);
                                System.out.print("->"+simboloOperacao);
                                Czero = resultado;
                                System.out.println(resultado);
                                break;
                            case 'C':
                                resultado = Czero.conjugado(Czero);
                                System.out.println(Czero);
                                System.out.print("->"+simboloOperacao);
                                Czero = resultado;
                                System.out.println(resultado);
                                break;
                            case 'I':
                                resultado = Czero.inverso(Czero);
                                System.out.println(Czero);
                                System.out.print("->"+simboloOperacao);
                                Czero = resultado;
                                System.out.println(resultado);
                                break;
                        }
                    }
                    break;

                case 'A':
                    C[0].imprimirAjuda();
                    break;
                case 'P':
                    C[i].setImaginario(0);
                    Estrutura_complexos resultadoPotencia = C[i+1].potenciacao(C[i+1],(int)C[i].getReal());
                    C[i+2] = resultadoPotencia;
                    Operacao nova_operacao_poten = new Operacao(C[i].getReal(), C[i].getImaginario(),C[i].getSimbolo());
                    historico.adicionarOperacao(nova_operacao_poten);
                    System.out.println(resultadoPotencia);
                    break;
                case 'C':
                    Estrutura_complexos resultadoConjugado = C[i+1].conjugado(C[i+1]);
                    C[i+2] = resultadoConjugado;
                    Operacao nova_operacao_conjugado = new Operacao(C[i].getReal(), C[i].getImaginario(),C[i].getSimbolo());
                    historico.adicionarOperacao2(nova_operacao_conjugado);
                    System.out.println(resultadoConjugado);
                    break;
                case 'F':
                    System.out.println("Fechando Calculadora");

                    return;
                case 'M':
                    historico.moverOperacao(((int)C[i].getReal())-1,((int)C[i].getImaginario())-1);
                    break;

                case 'R':
                    historico.removerOperacao(((int)C[i].getReal())-1);
                    break;
                case 'H':
                    historico.imprimirHistorico();
                    break;
                case 'L':
                    historico.limparHistorico();
                    break;
                case 'I' :
                    Estrutura_complexos resultado_inverso=C[i+1].inverso(C[i+1]);
                    C[i+2]=resultado_inverso;
                    Operacao nova_operacao_inverso = new Operacao(C[i].getReal(), C[i].getImaginario(),C[i].getSimbolo());
                    historico.adicionarOperacao2(nova_operacao_inverso);
                    System.out.println(resultado_inverso);
                    break;

                default:
                    System.out.println("Opcao invalida, tende + 1 2 ");
            }
    }
        sc.close();
    }

}
