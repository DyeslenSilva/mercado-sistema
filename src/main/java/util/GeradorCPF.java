package util;

import java.util.Random;

public class GeradorCPF {
    
    public static String gerarCPF() {
        Random random = new Random();
        
        // Gerar os nove primeiros dígitos aleatórios
        int n1 = random.nextInt(10);
        int n2 = random.nextInt(10);
        int n3 = random.nextInt(10);
        int n4 = random.nextInt(10);
        int n5 = random.nextInt(10);
        int n6 = random.nextInt(10);
        int n7 = random.nextInt(10);
        int n8 = random.nextInt(10);
        int n9 = random.nextInt(10);
        
        // Calcular o primeiro dígito verificador
        int d1 = calcularDigitoVerificador(n1, n2, n3, n4, n5, n6, n7, n8, n9);
        
        // Calcular o segundo dígito verificador
        int d2 = calcularDigitoVerificador(n1, n2, n3, n4, n5, n6, n7, n8, n9, d1);
        
        // Retornar o CPF completo
        return String.format("%d%d%d%d%d%d%d%d%d%d%d", n1, n2, n3, n4, n5, n6, n7, n8, n9, d1, d2);
    }
    
    private static int calcularDigitoVerificador(int... digitos) {
        int soma = 0;
        int peso = digitos.length + 1;
        
        for (int digito : digitos) {
            soma += digito * peso--;
        }
        
        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }

    public static void main(String[] args) {
        String cpf = GeradorCPF.gerarCPF();
        System.out.println("CPF gerado: " + cpf);
    }
}
