package br.bossini.pdf;

import javax.swing.JOptionPane;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Configurations configurations = new Configurations();
            Configuration config = null;
            config = configurations.properties("config.properties");
            String OPENAI_API_KEY = config.getString("OPENAI_API_KEY");
            JOptionPane.showMessageDialog(null, OPENAI_API_KEY);
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha técnica, tente novamente mais tarde");
        }
    }
}
