package br.bossini.pdf;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatGPTClient {
  public String criarPergunta(
      String OPENAI_API_KEY,
      String assunto,
      String tipo,
      String dificuldade,
      String perguntaExemplo) throws Exception {

    String prompt = "Elabore uma questão sobre %s, do tipo %s com 4 alternativas, de dificuldade %s.".formatted(assunto,
        tipo, dificuldade);
    prompt += perguntaExemplo == null ? "" : String.format("Use a seguinte questão de exemplo: %s", perguntaExemplo);

    RequisicaoChatGPT requisicao = new RequisicaoChatGPT("text-davinci-003", prompt, 100);
    Gson gson = new Gson();
    RequestBody requestBody = RequestBody.create(gson.toJson(requisicao), MediaType.parse("application/json"));

    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
        .url("https://api.openai.com/v1/completions")
        .addHeader("Content-Type", "application/json")
        .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
        .post(requestBody)
        .build();

    Response response = client.newCall(request).execute();
    RespostaChatGPT resposta = gson.fromJson(response.body().string(), RespostaChatGPT.class);
    String completion = resposta.getChoices().get(0).getText().trim();
    return completion;

  }
}
