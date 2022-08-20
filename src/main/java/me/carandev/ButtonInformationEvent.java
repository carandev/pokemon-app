package me.carandev;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;

import org.json.JSONObject;

/**
 * ButtonInformationEvent
 */
public class ButtonInformationEvent implements ActionListener{

	JFrame pokemonDescription;

	public ButtonInformationEvent(String url){
		ApiRequest apiRequest = new ApiRequest();
		try {
			JSONObject pokemonInformation = apiRequest.getPokemon(url);
			
			pokemonDescription = new PokemonInformationWindow(pokemonInformation);

		} catch (IOException exception){
			System.out.println(exception);
		} 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pokemonDescription.setVisible(true);
	}

		
}