/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fila_pilha_serelizacao;

/**
 *
 * @author informatica
 */
public class Exe {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) {
        Pilha p = new Pilha();
        p.iniPilha();
        Fila f = new Fila();
        f.iniFila();
        f.gravaFila();
        f.carregaFila();
    }
    
}
