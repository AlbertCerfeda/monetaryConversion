package Controller;

import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class Controller implements Runnable, ActionListener {
    private double originalValue;
    private double intermediateValue;
    private double convertedValue;

    private String originalCurrency;
    private String convertedCurrency;

    private View v;
    public Controller(View v) {
        this.v=v;

        new Thread(this).start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==v.getjButton2()){
            System.exit(0);
        }
    }

    @Override
    public void run() {
        for(;;){
            getValues();
            switch(originalCurrency){
                case "Euros":
                    intermediateValue=originalValue;
                    break;
                case "Dollars":
                    intermediateValue=originalValue*0.898309;
                    break;
                case "Yens":
                    intermediateValue=originalValue*0.00819;
                    break;
            }

            switch(convertedCurrency){
                case "Euros":
                    convertedValue=intermediateValue;
                    break;
                case "Dollars":
                    convertedValue=intermediateValue*1.113243;
                    break;
                case "Yens":
                    convertedValue=intermediateValue*122.007109;
                    break;
            }

            v.getjTextArea1().setText(""+convertedValue);

        }
    }
    private void getValues(){
        originalValue=Double.parseDouble(""+v.getjSpinner2().getValue());
        originalCurrency=(String)v.getjComboBox1().getSelectedItem();
        convertedCurrency=(String)v.getjComboBox2().getSelectedItem();
    }
}
