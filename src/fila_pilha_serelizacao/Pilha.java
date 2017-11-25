/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fila_pilha_serelizacao;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Werner A.K.
 */
class Caderno {

    int id;
    String nome;
    Caderno proximo;
}

public class Pilha {

    final String ARQUIVO_SERELIZACAO = ("C:\\Users\\Rose\\Pictures") + "\\atividade";

    static Caderno topo = null;

    public void empilhar(Caderno novo) {
        novo.proximo = topo;
        topo = novo;
    }

    public void listar() {
        if (topo == null) {
            System.out.println("A pilha está vazia.");
        } else {
            Caderno atual = topo;
            while (atual != null) {
                System.out.println("Id: " + atual.id + " - Caderno:" + atual.nome);
                atual = atual.proximo;
            }
        }
    }

    public void remove() {
        if (topo == null) {
            System.out.println("A pilha está vazia.");
        } else {
            Caderno removido = topo;
            //o proximo do topo é o caderno de baixo, ou seja, o anterior
            topo = topo.proximo;
            System.out.println("Caderno removido: " + removido.nome);
        }
    }

    public void iniPilha() {
        Pilha p = new Pilha();
        Caderno c1 = new Caderno();
        c1.nome = "Matemática";
        c1.id = 01;
        Caderno c2 = new Caderno();
        c2.id = 02;
        c2.nome = "Biologia";
        System.out.println("empilha caderno e mostra pilha");
        p.empilhar(c1);
        p.empilhar(c2);
        p.listar();
        System.out.println("remove caderno e mostra pilha");
        p.remove();
        p.listar();
    }

    public void gravaPilha() {
        try {
            if (topo == null) {
                System.out.println("Pilha vazia.");
            } else {
                FileOutputStream FOS = new FileOutputStream(ARQUIVO_SERELIZACAO);
                ObjectOutputStream OOS = new ObjectOutputStream(FOS);
                Caderno atual = topo;
                
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar gravar Pilha.");
        }
    }
}
