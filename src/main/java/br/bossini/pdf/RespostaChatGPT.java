package br.bossini.pdf;
import lombok.*;
import java.util.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaChatGPT {
  private List <Choice> choices;
}
