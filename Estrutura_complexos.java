//Matheus Nascimento 23484
//Camila Mayara Lenke Vieira 21872
package Calculadora_complexos;
import java.util.*;
public class Estrutura_complexos {
    private char simbolo;
    private double real;
    private double imaginario;
    private Historico historico;

    public Estrutura_complexos(Scanner sc){//criando e direcionando as posicoes de forma encapsulada de acordo com cada input
        while(true) {
            try {
                int i = 0;
                System.out.println("Indique sua operacao:");
                String formula_completa = sc.nextLine();
                if (formula_completa.length() <= 1) {// quer dizer que e so uma operacao sobre um complexo como o simetrico 'S'
                    simbolo = formula_completa.toUpperCase().charAt(0);
                    break;
                }
                if (formula_completa.length() == 3) {// quer dizer que e uma potencia ou remover 'P 2' ou 'R 3'
                    simbolo = formula_completa.toUpperCase().charAt(0);
                    String[] objetos_separados2 = formula_completa.split(Character.toString(' '));
                    List<Object> valores2 = new ArrayList<>();
                    for (i = 0; i < objetos_separados2.length; i++) {
                        String objetos = objetos_separados2[i].trim();
                        try {
                            valores2.add(Double.parseDouble(objetos));
                        } catch (NumberFormatException e) {
                            valores2.add(objetos.charAt(0));
                        }
                    }
                    real = (double) valores2.get(1);
                    break;
                }
                if (formula_completa.length() > 3) {// quer dizer que esta criando propriamente um complexo para operacoes
                    try {
                        String[] objetos_separados = formula_completa.split(Character.toString(' '));
                        List<Object> valores = new ArrayList<>();
                        for (i = 0; i < objetos_separados.length; i++) {
                            String objetos = objetos_separados[i].trim();
                            try {
                                valores.add(Double.parseDouble(objetos));
                            } catch (NumberFormatException e) {
                                valores.add(objetos.charAt(0));
                            }
                        }
                        simbolo = (char) valores.get(0);
                        char sim = Character.toUpperCase(simbolo);
                        simbolo = sim;
                        real = (double) valores.get(1);
                        imaginario = (double) valores.get(2);
                        break;
                    } catch (Exception e) {
                        System.out.println("------------------------------");
                        System.out.println("|Formato errado, tente: + 1 2|");
                        System.out.println("------------------------------");
                    }
                }
            }catch (Exception e) {
                System.out.println("------------------------------");
                System.out.println("|Formato errado, tente: + 1 2|");
                System.out.println("------------------------------");
            }
        }
    }

    public Estrutura_complexos(double real, double imaginario) {
        this.imaginario=imaginario;
        this.real=real;
    }

    public Estrutura_complexos soma(Estrutura_complexos C1, Estrutura_complexos C2){
        return new Estrutura_complexos(C1.real+C2.real,C1.imaginario+C2.imaginario);
    }
    public Estrutura_complexos multiplicacao(Estrutura_complexos C1,Estrutura_complexos C2){
        //𝑧 × 𝑤 = (𝑎𝑐 − 𝑏𝑑) + (𝑎𝑑 + 𝑏𝑐)𝑖
        return new Estrutura_complexos((C1.real*C2.real)-(C1.imaginario*C2.imaginario),
                (C1.real*C2.imaginario)+(C1.imaginario*C2.real));
    }

    public Estrutura_complexos subtracao(Estrutura_complexos C1,Estrutura_complexos C2){
       // 𝑧 − 𝑤 = 𝑧 + (−𝑤)
        return new Estrutura_complexos(C2.real-C1.real,C2.imaginario-C1.imaginario);
    }
    public Estrutura_complexos simetrico(Estrutura_complexos C1){
        return new Estrutura_complexos(-C1.real, -C1.imaginario);
    }
    public Estrutura_complexos conjugado(Estrutura_complexos C1){
        return new Estrutura_complexos(C1.real,-C1.imaginario);
    }
    public Estrutura_complexos inverso(Estrutura_complexos C1){
        return new Estrutura_complexos(C1.real/(Math.pow(C1.real,2)+Math.pow(C1.imaginario,2))
                ,-C1.imaginario/(Math.pow(C1.real,2)+Math.pow(C1.imaginario,2)));
    }

    public static Estrutura_complexos potenciacao(Estrutura_complexos C1, int N){
        double theta = Math.atan2(C1.imaginario, C1.real);
        double r = Math.pow(Math.sqrt(Math.pow(C1.real, 2) + Math.pow(C1.imaginario, 2)), N);
        return new Estrutura_complexos (Math.round(r * Math.cos(N * theta)), Math.round(r * Math.sin(N * theta)));
    }
    public Estrutura_complexos divisao(Estrutura_complexos C1, Estrutura_complexos C2){
        double denominador = C1.real * C1.real + C1.imaginario * C1.imaginario;
        double parteReal = ((((C1.real * C2.real + C1.imaginario * C2.imaginario) / denominador)));
        double parteImaginaria = (-1*((C1.imaginario * C2.real - C1.real * C2.imaginario) / denominador));
        return new Estrutura_complexos(parteReal, parteImaginaria);
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public double getImaginario() {
        return imaginario;
    }

    public void setImaginario(double imaginario) {
        this.imaginario = imaginario;
    }


    public String toString(){
        char sinal;
        if(this.imaginario<0)
            sinal=' ';
        else
            sinal='+';
        return "|" + real+" " +sinal +" " +imaginario+"i|";
    }

    public Estrutura_complexos(char simbolo, double real, double imaginario, Historico historico) {
        this.simbolo = simbolo;
        this.real = real;
        this.imaginario = imaginario;
        this.historico = historico;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    public void imprimirAjuda(){
        System.out.println("Para realizar uma operação, insira o símbolo da operação (+, -, *, /) " +
                "seguido do número complexo no formato + a(real) b(imaginario), separados por espaço.");
        System.out.println("\nInsira:");
        System.out.println("'+' - Para calcular adição. Exemplo: (+ 2 3), (+ 4 -5).");
        System.out.println("'-' - Para calcular subtração. Exemplo: (- 2 3), (- 4 -5).");
        System.out.println("'' - Para calcular multiplição . Exemplo: ( 2 3), (* 4 -5).");
        System.out.println("'/' - Para calcular divisão. Exemplo: (/ 2 3), (/4 -5).");
        System.out.println("'P' - Para calcular a potência. Exemplo: (p 2).");
        System.out.println("'H' - Para imprimir o histórico.");
        System.out.println("'T' - Para trocar a ordem de duas operações no histórico. Exemplo: (t 1 2).");
        System.out.println("'M' - Para mover uma operação no histórico. Exemplo: (m 1 7).");
        System.out.println("'S' - Para calcular o valor simétrico.");
        System.out.println("'C' - Para calcular o valor conjugado.");
        System.out.println("'I' - Para calcular o valor inverso.");
        System.out.println("'R' - Para remover um item do histórico.");
        System.out.println("\nPara sair do programa, digite 'F'.\n");
    }
}

