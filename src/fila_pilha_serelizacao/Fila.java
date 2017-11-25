/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fila_pilha_serelizacao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author informatica
 */
class Pessoa {

    int senha;
    String nome;
    Pessoa proximo;
}

public class Fila {

    final String ARQUIVO_SERELIZACAO = ("C:\\Users\\Rose\\Pictures");

    Pessoa primeiro = null;
    Pessoa ultimo = null;

    public void inserir(Pessoa novo) {
        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            //o proximo do ultimo seria o de tras, portanto, o ultimo sera o novo agora.
            ultimo.proximo = novo;
            ultimo = novo;
        }
    }

    public void removeFila() {
        if (primeiro == null) {
            System.out.println("Fila vazia.");
        } else {
            primeiro = primeiro.proximo;
        }
    }

    public void mostraFila() {
        if (primeiro == null) {
            System.out.println("Fila vazia.");
        } else {
            Pessoa atual = primeiro;
            while (atual != null) {
                System.out.println("Senha: " + atual.senha + " - Nome: " + atual.nome);
                atual = atual.proximo;
            }
        }
    }

    public void iniFila() {
        Fila f = new Fila();
        Pessoa p1 = new Pessoa();
        p1.senha = 01;
        p1.nome = "A";
        Pessoa p2 = new Pessoa();
        p2.senha = 02;
        p2.nome = "B";
        Pessoa p3 = new Pessoa();
        p3.senha = 03;
        p3.nome = "C";
        System.out.println("insere pessoa e mostra fila");
        f.inserir(p1);
        f.inserir(p2);
        f.inserir(p3);
        f.mostraFila();
        System.out.println("remove pessoa e mostra fila");
        f.removeFila();
        f.mostraFila();
    }

    public void gravaFila() {
        System.out.println("Gravando fila.");
        try {
            if (primeiro == null) {
                System.out.println("Fila vazia");
            } else {
                FileOutputStream FOS = new FileOutputStream(ARQUIVO_SERELIZACAO);
                ObjectOutputStream OOS = new ObjectOutputStream(FOS);
                Pessoa atual = primeiro;
                while (atual != null) {
                    OOS.writeObject(atual);
                    atual = atual.proximo;
                }
                OOS.flush();
                FOS.flush();
                OOS.close();
                FOS.close();
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar gravar fila.");
        }
    }

    public void carregaFila() {
        System.out.println("Carregando fila.");
        try {
            FileInputStream FIS = new FileInputStream(ARQUIVO_SERELIZACAO);
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            while(FIS.available() > 0) {
                inserir((Pessoa)OIS.readObject());
            }
            OIS.close();
            FIS.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao tentar carregar fila.");
        }
    }
}
