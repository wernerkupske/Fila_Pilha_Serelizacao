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
class Caderno{
    int id;
    String nome;
    Caderno proximo;
}

public class Pilha {
    static Caderno topo = null;
    
    
    public void empilhar(Caderno novo){
        novo.proximo = topo;
        topo = novo;
    }
    
    public void listar() {
        if (topo == null) {
            System.out.println("A pilha está vazia.");
        } else {
            Caderno atual = topo;
            while (atual != null){
                System.out.println("Id: "+atual.id+" - Caderno:" + atual.nome);
                atual = atual.proximo;
            }
        }
    }
    
    public void remove(){
        if(topo == null){
            System.out.println("A pilha está vazia.");
        } else {
            Caderno removido = topo;
            //o proximo do topo é o caderno de baixo, ou seja, o anterior
            topo = topo.proximo;
            System.out.println("Caderno removido: "+removido.nome);
        }
    }
    
}
