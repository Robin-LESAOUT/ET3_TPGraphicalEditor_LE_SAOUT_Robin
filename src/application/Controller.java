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
	
	public Rectangle createRectangle(double x,double y, ArrayList<Rectangle> array) {
		Rectangle r = new Rectangle(x,y,100,100);
		r.setStroke(Color.BLACK);
		r.setFill(colorPicker.getValue());
		array.add(r);
		return r;
	}
	
	public Rectangle setRectangle(Rectangle r, double X, double Y) {
		r.setWidth(X);
		r.setHeight(Y);
		return r;
	}
	
	public Ellipse createEllipse(double x, double y, ArrayList<Ellipse> array) {
		Ellipse e = new Ellipse(x,y,75,40);
		e.setStroke(Color.BLACK);
		e.setFill(colorPicker.getValue());
		array.add(e);
		return e;
	}
	
	public Ellipse setEllipse(Ellipse e, double X, double Y) {
		e.setRadiusX(X);
		e.setRadiusY(Y);
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
	
	public void clicColor(MouseEvent event) {
		model.setEl(false);
		model.setRec(false);
		model.setLi(false);
		model.setSelect(false);
		model.setCouleur(colorPicker.getValue());
	}
	
	
	public void initialize() {
		
		ArrayList<Rectangle> arrayR = new ArrayList<Rectangle>();
		ArrayList<Ellipse> arrayE = new ArrayList<Ellipse>();
		ArrayList<Line> arrayL = new ArrayList<Line>();
		
		ArrayList<Double> listeX = new ArrayList<Double>();
		ArrayList<Double> listeY = new ArrayList<Double>();
		
		
		
		rectangleBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				clicRectangle(event);
			}
		});
		
		ellipseBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				clicEllipse(event);
			}
		});
		
		lineBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				clicLigne(event);
			}
		});
		
		selectBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				clicSelect(event);
			}
		});
		

		
		
		Pane.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
				public void handle(MouseEvent event) {
					if(model.isEl()) {
						createEllipse(event.getX(),event.getY(),arrayE).addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								if(model.isSelect()) {
									boolean sel=false;
									if(!sel) {
										arrayE.get(arrayE.size()-1).setRadiusX(arrayE.get(arrayE.size()-1).getRadiusX()+10);
										arrayE.get(arrayE.size()-1).setRadiusY(arrayE.get(arrayE.size()-1).getRadiusY()+10);
										arrayE.get(arrayE.size()-1).setFill(colorPicker.getValue());
										sel=true;
									}
								}
							}
						});
						Pane.getChildren().add(arrayE.get(arrayE.size()-1));
						listeX.add(event.getX());
						listeY.add(event.getY());
					}
					else if (model.isRec()) {
						createRectangle(event.getX(),event.getY(),arrayR).addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								if(model.isSelect()) {
									arrayR.get(arrayR.size()-1).setWidth(arrayR.get(arrayR.size()-1).getWidth()+10);
									arrayR.get(arrayR.size()-1).setHeight(arrayR.get(arrayR.size()-1).getHeight()+10);
									arrayR.get(arrayR.size()-1).setFill(colorPicker.getValue());
								}
							}
						});
						Pane.getChildren().add(arrayR.get(arrayR.size()-1));
						listeX.add(event.getX());
						listeY.add(event.getY());
					}
				}
			});
			
		
		Pane.addEventHandler(MouseEvent.MOUSE_DRAGGED,new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent event) {
					if (model.isEl()) {
						setEllipse(arrayE.get(arrayE.size()-1), event.getX() - (listeX.get(listeX.size()-1)), event.getY() - ((listeY.get(listeY.size()-1))));
						arrayE.get(arrayE.size()-1).addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								if(model.isSelect()) {
									arrayE.get(arrayE.size()-1).setCenterX(event.getX());
									arrayE.get(arrayE.size()-1).setCenterY(event.getY());
								}
							}
						});
					}else if(model.isRec()) {
						setRectangle(arrayR.get(arrayR.size()-1),event.getX() - (listeX.get(listeX.size()-1)),event.getY()- ((listeY.get(listeY.size()-1))));
						arrayR.get(arrayR.size()-1).addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								if(model.isSelect()) {
									arrayR.get(arrayR.size()-1).setX(event.getX());
									arrayR.get(arrayR.size()-1).setY(event.getY());
								}
							}
						});
					}
				}
			});
		
		
		deleteBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				if(model.isSelect()) {
				Pane.getChildren().remove(arrayE.get(arrayE.size()-1));
				Pane.getChildren().remove(arrayR.get(arrayR.size()-1));
				}
			}
		});
		
		cloneBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				if(model.isSelect()) {
					if(model.isRec()) {
						createRectangle(event.getX()+10, event.getY(), arrayR);
						Pane.getChildren().add(arrayR.get(arrayR.size()-1));
					}
					else if(model.isEl()) {
						createEllipse(event.getX()+10, event.getY(), arrayE);
						Pane.getChildren().add(arrayE.get(arrayE.size()-1));
					}
				}
			}
		});
		
		
		/*
		arrayE.get(arrayE.size()-1).addEventHandler(MouseEvent.MOUSE_RELEASED,new EventHandler<MouseEvent>(){
						@Override
						public void handle(MouseEvent event) {
							arrayE.get(arrayE.size()-1).setRadiusX(arrayE.get(arrayE.size()-1).getRadiusX()-10);
							arrayE.get(arrayE.size()-1).setRadiusY(arrayE.get(arrayE.size()-1).getRadiusY()-10);
						}
					});
		
	*/
		
		
		////QuEstion 3
		/*
		Pane.addEventHandler(MouseEvent.MOUSE_PRESSED,new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				if (model.isEl()) {
					//setEllipse(arrayE.get(arrayE.size()-1), event.getX() - (listeX.get(listeX.size()-1)), event.getY() - ((listeY.get(listeY.size()-1))));
				}else if(model.isRec()) {
					//setRectangle(arrayR.get(arrayR.size()-1), event.getX() - (listeX.get(listeX.size()-1)),event.getY()- ((listeY.get(listeY.size()-1))));
				}
			}
		});
		*/
	}
}
