package application;

import javafx.scene.control.TextField;
import java.io.File;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;

public class Controller {

	private Modele model;
	
	@FXML
	Slider slid1;
	
	@FXML
	Slider slid2;
 
	@FXML
	Slider slid3;
	
	@FXML
	TextField txt1;
	
	@FXML
	TextField txt2;
	
	@FXML
	TextField txt3;
	
	@FXML
	TextField hexacolor;
	
	@FXML
	Rectangle hexacube;
	
	public void initialize() {
		model=new Modele(this);
		
		// sliders
		slid1.setValue(0);
		slid2.setValue(0);
		slid3.setValue(0);
		
		//textfields
		txt1.setText("0");
		txt2.setText("0");
		txt3.setText("0");
		
		// couleur hexa
		hexacolor.setText("#000000");
		
		// carre de couleur
		hexacube.setFill(Color.BLACK);
		
		slid1.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    model.setRouge(new_val.intValue());
            }
        });
		
		slid2.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    model.setVert(new_val.intValue());
            }
        });
		
		slid3.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    model.setBleu(new_val.intValue());
            }
        });
		
		txt1.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
            	try {
            	int r=Integer.parseInt(new_val);
				if (r>255) {
					r=255;
				}
				else if (r<0) {
					r=0;
				}
				model.setRouge(r);
            	}
            	catch(Exception e) {
            		System.out.println(e.getMessage());
            	}
				
			}
		});
		
		txt2.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
            	try {
            	int g=Integer.parseInt(new_val);
				if (g>255) {
					g=255;
				}
				else if (g<0) {
					g=0;
				}
				model.setVert(g);
            	}
            	catch(Exception e) {
            		System.out.println(e.getMessage());
            	}
				
			}
		});
	
	
	txt3.textProperty().addListener(new ChangeListener<String>() {
        public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
        	try {
        	int b=Integer.parseInt(new_val);
			b=checkVal(b);
			model.setBleu(b);
        	}
        	catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
			
		}
	});
	
	hexacolor.textProperty().addListener(new ChangeListener<String>() {
        public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
        	int r=Integer.parseInt(new_val.substring(1,3),16);
        	int g=Integer.parseInt(new_val.substring(3,5),16);
        	int b=Integer.parseInt(new_val.substring(5,7),16);
        	r=checkVal(r);
        	g=checkVal(g);
        	b=checkVal(b);
        	model.setRouge(r);
        	model.setBleu(b);
        	model.setVert(g);			
		}
	});
	}
	public void actualiserVue() {
		setR(model.getRouge());
		setG(model.getVert());
		setB(model.getBleu());
		
		setSlidRed();
		setSlidBlue();
		setSlidGreen();
		setHexa(model.getRouge(),model.getVert(),model.getBleu());
	}
	
	public void setR(int r) {
		txt1.setText(""+r);
	}
	public void setB(int b) {
		txt3.setText(""+b);
	}
	public void setG(int g) {
		txt2.setText(""+g);
	}

	public void setHexa(int r,int g,int b) {
		hexacolor.setText("#"+String.format("%02x%02x%02x",r,g,b));
		hexacube.setFill(Color.rgb(r,g,b));
	}
	public void setSlidRed() {
		slid1.adjustValue(model.getRouge());
	}
	public void setSlidBlue() {
		slid3.adjustValue(model.getBleu());
	}
	public void setSlidGreen() {
		slid2.adjustValue(model.getVert());
	}
	public int checkVal(int val) {
		int res=val;
		if (res>255) {
			res=255;
		}
		else if (res<0) {
			res=0;
		}
		return res;
	}
}
