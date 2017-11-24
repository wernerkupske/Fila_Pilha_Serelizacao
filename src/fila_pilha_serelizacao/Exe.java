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
        Caderno c1 = new Caderno();
        c1.nome = "Matemática";
        c1.id = 01;
        Caderno c2 = new Caderno();
        c2.id = 02;
        c2.nome = "Biologia";
        p.empilhar(c1);
        p.empilhar(c2);
        p.listar();
        p.remove();
        p.listar();
    }
    
}
