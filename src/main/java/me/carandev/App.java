package me.carandev;

import java.io.IOException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App
{
  public static void main( String[] args ) throws IOException
  {
    ApiRequest apiRequest = new ApiRequest();
    JSONArray data = apiRequest.getPokemons();
    JFrame frame = new JFrame("Pokemon API");
    
    for (int index = 0; index < data.length(); index++) {
      JSONObject pokemon = data.getJSONObject(index);
      
      String pokemonUrl = pokemon.getString("url");
      
      JSONObject pokemonInformation = apiRequest.getPokemon(pokemonUrl);
      
      URL imageUrl = new URL(pokemonInformation.getJSONObject("sprites").getString("front_default"));
      
      Icon icon = new ImageIcon(imageUrl);
      
      JButton buttonImage = new JButton(icon);
      JPanel panel = new JPanel();
      JLabel title = new JLabel(pokemonInformation.getString("name"));
      
      buttonImage.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
        }
      });
      
      panel.add(title);
      panel.add(buttonImage);
      
      frame.add(panel);
    }
    
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setSize(900, 900);
    frame.setLayout(new GridLayout(5,5,5,5));
  }
}
