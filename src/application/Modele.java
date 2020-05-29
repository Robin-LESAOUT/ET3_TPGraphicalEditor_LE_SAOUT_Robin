package application;

import java.awt.TextField;

import com.sun.javafx.geom.Rectangle;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;

public class Modele {

	private int rouge,bleu,vert;
	private Controlleur controller;
	
	public Modele(Controlleur c) {
		controller=c;
	}
	
	public void setRouge(int r) {
		rouge=r;
		controller.actualiserVue();
	}
	
	public void setBleu(int b) {
		bleu=b;
		controller.actualiserVue();
	}
	
	public void setVert(int v) {
		vert=v;
		controller.actualiserVue();
	}

	public int getRouge() {
		return rouge;
	}

	public int getBleu() {
		return bleu;
	}

	public int getVert() {
		return vert;
	}
	
}
