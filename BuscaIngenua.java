import java.util.*;
import java.io.*;
public class BuscaIngenua{
    protected final int MAX = 1000000;
    protected String[] arranjo;
    int size = 0;
    BuscaIngenua(){arranjo = new String[MAX];}

    void insert(String s){
        arranjo[size] = s;
        size++;
    }

    boolean find(String a){
        for(int i = 0; i < size; i++){
            if(arranjo[i].equals(a)) return true ;
        }
    return false;
    }

    public static void main(String[] args){
        try{
            for(int i = 1000; i < 100000; i += 1000){

                long inicio = System.currentTimeMillis();

                for(int j = 0; j < 50; j++){

                    String nome = "saida" + i + ".txt";
                    String verificar = "verificar" + i + ".txt";
                    File arq = new File(nome);
                    File arqVerificar = new File(verificar);
                    Scanner ler = new Scanner(arq);
                    BuscaIngenua lista = new BuscaIngenua();

                    while (ler.hasNextLine()) {
                        String linha = ler.nextLine();
                        lista.insert(linha);
                    }

                    Scanner ler2 = new Scanner(arqVerificar);
                    String saida = "";
                    while (ler2.hasNextLine()) {
                        String linha = ler2.nextLine();
                        boolean possui = lista.find(linha);
                        if (possui == true) {
                            saida = saida + linha + "\n";
                        }
                    }

                    FileWriter escrever = new FileWriter("saidaverificada" + i + ".txt");
                    escrever.write(saida);
                    escrever.close();
                    ler.close();
                    ler2.close();
                }

                System.out.println("O tempo de execucao medio no programa, com " + i + " elementos, foi de: " + (System.currentTimeMillis() - inicio) / 50 + "ms");
            }
        }
        catch(IOException e){}
    }    
}