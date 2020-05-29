package application;

import java.awt.TextField;

import com.sun.javafx.geom.Rectangle;


import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

public class Modele {
	
	private boolean select;
	private boolean rec;
	private boolean el;
	private boolean li;
	private Controller controller;
	private Color Couleur;
	
	public Modele(Controller c, boolean select, boolean rec, boolean el, boolean li) {
		this.select=select;
		this.rec=rec;
		this.el=el;
		this.li=li;
		controller=c;
	}
	
	public Color getCouleur() {
		return Couleur;
	}

	public void setCouleur(Color couleur) {
		Couleur = couleur;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isRec() {
		return rec;
	}

	public void setRec(boolean rec) {
		this.rec = rec;
	}

	public boolean isEl() {
		return el;
	}

	public void setEl(boolean el) {
		this.el = el;
	}

	public boolean isLi() {
		return li;
	}

	public void setLi(boolean li) {
		this.li = li;
	}

	public Controller getController() {
		return controller;
	}


	
	
	

	
	
	
	
}
