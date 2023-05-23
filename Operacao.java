//Matheus Nascimento 23484
//Camila Mayara Lenke Vieira 21872
package Calculadora_complexos;

    public class Operacao {
            private double numero1;
            private double numero2;
            private char operador;

            public Operacao(double numero1, double numero2, char operador) {
                this.numero1 = numero1;
                this.numero2 = numero2;
                this.operador = operador;
                if(operador=='S'||operador=='I'||operador=='F'||operador=='C'){

                }
            }

            public void imprimir() {
                System.out.println(operador +" "+numero1 + " " + numero2+ "i");
            }

            // getters e setters

            public double getNumero1() {
                return numero1;
            }

            public void setNumero1(double numero1) {
                this.numero1 = numero1;
            }

            public double getNumero2() {
                return numero2;
            }

            public void setNumero2(double numero2) {
                this.numero2 = numero2;
            }

            public char getOperador() {
                return operador;
            }

            public void setOperador(char operador) {
                this.operador = operador;
            }
        }
