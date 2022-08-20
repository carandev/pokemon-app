package me.carandev;

import java.net.MalformedURLException;
import java.net.URL;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * PokemonInformationWindow
 */
public class PokemonInformationWindow extends JFrame{

	private String pokemonName;
	private URL pokemonImgUrl;
	private JSONArray abilities;
	private JSONArray stats;

	public PokemonInformationWindow(JSONObject pokemonInformation) throws IOException{
		pokemonName = pokemonInformation.getString("name");
		pokemonImgUrl = new URL(pokemonInformation.getJSONObject("sprites").getString("front_default"));
		abilities = pokemonInformation.getJSONArray("abilities");
		stats = pokemonInformation.getJSONArray("stats");

		setTitle(pokemonName);
		setSize(600,600);
		setLayout(new GridLayout(2, 2));
		add(createImageFrame());
	}	

	public JPanel createImageFrame(){
		JPanel panelImage = new JPanel();
		panelImage.add(new JLabel(pokemonName));
		panelImage.add(new JLabel(new ImageIcon(pokemonImgUrl)));

		return panelImage;
	}
}