package br.bossini.pdf;

import com.google.gson.Gson;

public class TesteGSON {
  public static void main(String[] args) {
    //constrói um objeto RequisicaoChatGPT
    RequisicaoChatGPT requisicaoChatGPT = new RequisicaoChatGPT("text-davinci-003", "Qual a capital do Brasil?", 5);
    //constrói um objeto Gson
    Gson gson = new Gson();
    //converte o objeto RequisicaoChatGPT em uma String JSON
    String json = gson.toJson(requisicaoChatGPT);
    //imprime a String JSON
    System.out.println(json);
  }  
}

