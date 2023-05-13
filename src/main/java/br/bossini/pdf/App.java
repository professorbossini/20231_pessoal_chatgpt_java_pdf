package br.bossini.pdf;

import javax.swing.JOptionPane;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

public class App 
{
    public static void main( String[] args ){
        try {
            Configurations configurations = new Configurations();
            Configuration config = null;
            config = configurations.properties("config.properties");
            String OPENAI_API_KEY = config.getString("OPENAI_API_KEY");
            String assunto =  "Java";
            String dificuldade = "Fácil";
            String tipo = "alternativa";
            ChatGPTClient client = new ChatGPTClient();
            String perguntaCriada = client.criarPergunta(OPENAI_API_KEY, assunto, tipo, dificuldade, tipo);
            JOptionPane.showMessageDialog(null, perguntaCriada);
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha técnica, tente novamente mais tarde");
        }
    }
}
