import java.util.*;
import java.io.*;
public class ArvoreBinariaDeBusca {
    private NodeBT raiz;

    public ArvoreBinariaDeBusca(){
        raiz = null;
    }

    NodeBT insertRecursive(NodeBT root, int newTarefa){
        if(root == null){
            root = new NodeBT(newTarefa);
            return root;
        }
        else if(newTarefa > root.getTarefa())
            root.filhoD = insertRecursive(root.filhoD, newTarefa);
        else if(newTarefa < root.getTarefa())
            root.filhoE = insertRecursive(root.filhoE, newTarefa);
            
        return root;
    }


    void insert(int t){
        raiz = insertRecursive(raiz, t);
    }

    NodeBT find(int a){
        return findRec(raiz, a);
    }
    
    NodeBT findRec(NodeBT root, int a){
        if(root == null || root.tarefa == a){
            return root;
        }
        if(root.tarefa > a){
            return findRec(root.filhoE, a);
        }
        return findRec(root.filhoD, a);
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
                    ArvoreBinariaDeBusca lista = new ArvoreBinariaDeBusca();
    

                    while (ler.hasNextLine()) {
                        int linha = Integer.parseInt(ler.nextLine());
                        lista.insert(linha);
                    }

                    Scanner ler2 = new Scanner(arqVerificar);
                    String saida = "";

                    while (ler2.hasNextLine()) {
                        int linha = Integer.parseInt(ler2.nextLine());
                        NodeBT temp = lista.find(linha);
                        if (temp != null) {
                            saida = saida + linha + "\n";
                        }
                    }

                    FileWriter escrever = new FileWriter("saidaverificada" + i + ".txt");
                    escrever.write(saida);

                    escrever.close();
                    ler.close();
                    ler2.close();
                }
                
                System.out.println("O tempo de execucao medio no programa, com " + i + " elementos, foi de: " + (System.currentTimeMillis() - inicio)/50 + "ms");

            }
        }
        catch(IOException e){}
    }
}
