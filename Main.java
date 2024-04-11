package atividade01.ProjetoTESTE;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static void salvarTemposEmArquivo(List<List<Long>> tempos) {
        try {
            FileWriter arquivo = new FileWriter("t_exeCM345714000.txt");
            for (List<Long> temposIteracao : tempos) {
                for (Long tempo : temposIteracao) {
                    arquivo.write(tempo.toString() + ",");
                }
                arquivo.write("\n");
            }
            arquivo.close();
            System.out.println("Tempos de execução salvos com sucesso em tempos_execucao.txt");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os tempos de execução: " + e.getMessage());
        }
    }
    public static void main(String[] args){
		
		Busca_IF b = new Busca();
        
		final int numeroParaBuscar = -1; 
    
        final int[] vetor1000 = b.geraVetorNumericoOrdenado(1000);
        
        // Número de iterações para calcular a média
        int numIteracoes = 100;
        
        List<List<Long>> tempos = new ArrayList<>();

        for (int i = 0; i < numIteracoes; i++) {
            List<Long> temposIteracao = new ArrayList<>();
            long antes, depois;
            
            antes = System.nanoTime();
            b.buscaLinear_iterativa(vetor1000, numeroParaBuscar);
            depois = System.nanoTime();
            temposIteracao.add(depois - antes);
            
            antes = System.nanoTime();
            b.buscaLinear_iterativa_duasPontas(vetor1000, numeroParaBuscar);
            depois = System.nanoTime();
            temposIteracao.add(depois - antes);

            antes = System.nanoTime();
            b.buscaLinear_recursiva(vetor1000, numeroParaBuscar);
            depois = System.nanoTime();
            temposIteracao.add(depois - antes);
            
            antes = System.nanoTime();
            b.buscaBinaria_iterativa(vetor1000, numeroParaBuscar);
            depois = System.nanoTime();
            temposIteracao.add(depois - antes);
            
            antes = System.nanoTime();
            b.buscaBinaria_recursiva(vetor1000, numeroParaBuscar);
            depois = System.nanoTime();
            temposIteracao.add(depois - antes);

            tempos.add(temposIteracao);
        }

        // Imprimir os tempos de execução armazenados para cada iteração
        for (int i = 0; i < tempos.size(); i++) {
            System.out.println("Iteração " + (i+1) + ":");
            List<Long> temposIteracao = tempos.get(i);
            for (int j = 0; j < temposIteracao.size(); j++) {
                System.out.println("   Tempo de execução do algoritmo " + (j+1) + ": " + temposIteracao.get(j));
            }
        }

        salvarTemposEmArquivo(tempos);
    }
}
