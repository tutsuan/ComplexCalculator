//Matheus Nascimento 23484
//Camila Mayara Lenke Vieira 21872
package Calculadora_complexos;
import java.util.ArrayList;
import java.util.List;

public class Historico {
    private List<Operacao> operacoes;

    public Historico() {
        this.operacoes = new ArrayList<>();
    }

    public void adicionarOperacao(Operacao operacao) {
        if(operacao.getOperador()=='S'||operacao.getOperador()=='I'||operacao.getOperador()=='F'||operacao.getOperador()=='C'){

        }
        operacoes.add(operacao);
    }
    public void adicionarOperacao2(Operacao operacao) {// tentativa de fazer entrar so o simbolo no historico*******
        if(operacao.getOperador()=='S'||operacao.getOperador()=='I'||operacao.getOperador()=='F'||operacao.getOperador()=='C'){
            Operacao nova_operacao = new Operacao(0, 0, operacao.getOperador());
            operacoes.add(nova_operacao);
        } else if (operacao.getOperador() == '+' || operacao.getOperador() == '-' || operacao.getOperador() == '*' || operacao.getOperador() == '/') {
            operacoes.add(operacao);
        }
    }




    public void removerOperacao(int index) {
        operacoes.remove(index);
    }


    public void moverOperacao(int fromIndex, int toIndex) {
        Operacao operacao = operacoes.remove(fromIndex);
        operacoes.add(toIndex, operacao);
    }

    public void imprimirHistorico() {
        if (operacoes.size() == 0) {
            System.out.println("Histórico vazio");
            return;
        }

        System.out.println("Histórico de operações:");
        for (int i = 0; i < operacoes.size(); i++) {

            System.out.print((i+1) + ": ");
            operacoes.get(i).imprimir();
        }
        System.out.println();
    }

    public void limparHistorico() {
        operacoes.clear();
    }
    public void trocarOperacoes(int index1, int index2) {
        Operacao operacao1 = operacoes.get(index1);
        Operacao operacao2 = operacoes.get(index2);
        operacoes.set(index1, operacao2);
        operacoes.set(index2, operacao1);


    }


    public Historico(List<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    public Operacao getOperacao(int index) {
        return operacoes.get(index);
    }
    public int getTamanho() {
        return operacoes.size();
    }


}

