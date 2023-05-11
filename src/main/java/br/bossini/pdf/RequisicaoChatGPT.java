package br.bossini.pdf;

import lombok.*;

//getters
@Getter
//setters
@Setter
//construtor com todos os argumentos
@AllArgsConstructor
//construtor sem argumentos
@NoArgsConstructor
public class RequisicaoChatGPT {
  private String model;
  private String prompt;
  private int max_tokens;
}
