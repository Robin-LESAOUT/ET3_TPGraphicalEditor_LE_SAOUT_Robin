package application;


import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


import java.util.ArrayList;

import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;



import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;


public class Controller {

	private Modele model;
	
	@FXML
	private RadioButton selectBtn;
	
	@FXML
	private RadioButton ellipseBtn;
 
	@FXML
	private RadioButton rectangleBtn;
	
	@FXML
	private RadioButton lineBtn;
	
	@FXML
	private Button deleteBtn;
	
	@FXML
	private Button cloneBtn;
	
	@FXML
	private ColorPicker colorPicker;
	
	@FXML
	private ToggleGroup group;
	
	@FXML 
	private Pane Pane;
	
	Rectangle rectangle;
	Ellipse ellipse;
	Line ligne;
	
	private Color Couleur;
	
	public Controller() {
        model= new Modele(this,false,false,false,false);
    }
	
	public Rectangle createRectangle(double x,double y) {
		Rectangle r = new Rectangle(x,y,100,100);
		r.setStroke(Color.BLACK);
		r.setFill(null);
		return r;
	}
	
	public Ellipse createEllipse(double x, double y) {
		Ellipse e = new Ellipse(x,y,75,40);
		e.setStroke(Color.BLACK);
		e.setFill(null);
		return e;
	}
	
	public Line createLine (double x,double y,double a, double b) {
		Line l= new Line();
		l.setStartX(a);
		l.setStartY(b);
		l.setEndX(x);
		l.setEndY(y);
		return l;
	}
	
	public void clicEllipse(MouseEvent event) {
		model.setEl(true);
		model.setRec(false);
		model.setLi(false);
		model.setSelect(false);
	}
	
	public void clicRectangle(MouseEvent event) {
		model.setEl(false);
		model.setRec(true);
		model.setLi(false);
		model.setSelect(false);
	}
	
	public void clicSelect(MouseEvent event) {
		model.setEl(false);
		model.setRec(false);
		model.setLi(false);
		model.setSelect(true);
	}
	
	public void clicLigne(MouseEvent event) {
		model.setEl(false);
		model.setRec(false);
		model.setLi(true);
		model.setSelect(false);
	}
	
	
	public void initialize() {
		
		ArrayList<Rectangle> arrayR = new ArrayList<Rectangle>();
		ArrayList<Ellipse> arrayE = new ArrayList<Ellipse>();
		ArrayList<Line> arrayL = new ArrayList<Line>();
		
		
		colorPicker.setOnAction(new EventHandler() {
			public void handle(Event event) {
				Color couleur = colorPicker.getValue();
				model.setCouleur(couleur);
			}
		});
		
		Pane.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
				public void handle(MouseEvent event) {
					if(model.isEl()) {
						Ellipse e = createEllipse(event.getX(),event.getY());
						Pane.getChildren().add(arrayE.get(arrayE.size()-1));
					}
					else if (model.isRec()) {
						Rectangle r = createRectangle(event.getX(),event.getY());
						Pane.getChildren().add(arrayR.get(arrayR.size()-1));
					}
				}
			});
		
		/*
		pane.addEventHandler(MouseEvent.MOUSE_DRAGUED, new EventHandler<MouseEvent>()){
			new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					
				}
			}
				
		}*/
		     
		
		
	}
}
