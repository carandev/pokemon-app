package me.carandev;

import java.io.IOException;
import java.net.URL;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * MainWindow
 */
public class MainWindow extends JFrame{

  public MainWindow() throws IOException{
    ApiRequest apiRequest = new ApiRequest();
    JSONArray data = apiRequest.getPokemons();
    setTitle("Pokemon API");
    
    for (int index = 0; index < data.length(); index++) {
      JSONObject pokemon = data.getJSONObject(index);
      
      String pokemonUrl = pokemon.getString("url");
      
      JSONObject pokemonInformation = apiRequest.getPokemon(pokemonUrl);
      
      URL imageUrl = new URL(pokemonInformation.getJSONObject("sprites").getString("front_default"));
      
      Icon icon = new ImageIcon(imageUrl);
      
      JButton buttonImage = new JButton(icon);
      JPanel panel = new JPanel();
      
      buttonImage.addActionListener(new ButtonInformationEvent(pokemonUrl));
      
      panel.add(new JLabel(pokemonInformation.getString("name")));
      panel.add(buttonImage);
      panel.setSize(100, 100);

      add(panel);
    }
    
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    setSize(900, 900);
    setLayout(new GridLayout(5,5,5,5));
  }

}