package source;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Programa {

    public static void main(String[] args) {
        Leitor leitor = null;
        
        //le expressoes e monta cada expressao em uma arvore
        try {
            leitor = new Leitor("expressoes.txt");
            String linhaAtual = leitor.leProximaLinha();
            while(linhaAtual != null) {
                BinaryTreeOfInteger arvore = new BinaryTreeOfInteger();
                arvore.setRoot("");
                
                String[] termos = linhaAtual.split(" ");
                //ignora o primeiro e o ultimo parentesis
                for(int i = 1; i < termos.length - 1; i++) {
                    if(termos[i].equals("("))
                        arvore.addLowerLevel("");
                    else {
                        if (termos[i].equals("+") || termos[i].equals("-") || 
                            termos[i].equals("*") || termos[i].equals("/") || termos[i].equals("^"))
                            arvore.setValueOnCursor(termos[i]);
                        else {
                            //aqui deveria fazer uma conversao para double so para conferir se
                            //o valor realmente eh um double
                            arvore.addOperando(termos[i]);
                        }
                    }
                                
                }
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado.");
        }
        catch (IOException e) {
            System.out.println("Erro na leitura do arquivo");
        } catch (Exception ex) {
            System.out.println("Erro:" + ex.getMessage());
        }
        finally {
            try {
                leitor.fechaArquivo();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
