package com.coord.conv;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

/*
    * VV BEGINNING VV
*/
public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView hint;
    TextView sel;
    TextView result;

    EditText inputLat;
    EditText inputLon;
    Button N_button;
    Button S_button;
    Button W_button;
    Button E_button;

    // format vars:
    int lati_type = 0;
    int lon_type = 0;
    int coordLat;
    int coordLon;
    // ---

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hint=(TextView) findViewById(R.id.textView30);
        sel=(TextView) findViewById(R.id.sel);
        result=(TextView) findViewById(R.id.result);
        radioGroup = findViewById(R.id.radio_group);

        inputLat = (EditText) findViewById(R.id.inputLat);
        inputLon = (EditText) findViewById(R.id.inputLon);

        N_button = (Button) findViewById(R.id.N_button);
        S_button = (Button) findViewById(R.id.S_button);
        W_button = (Button) findViewById(R.id.W_button);
        E_button = (Button) findViewById(R.id.E_button);
    }

    public void RadioClicked(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        Toast.makeText(this, "MODE: " + radioButton.getText(),
                Toast.LENGTH_SHORT).show();

        /*
         * normal mode:
         */
        if (v.getId() == R.id.radio1){
            // clear all and hide the half-deg mode hint /initialise
            sel.setText(" - - -  * ");
            result.setText(" - - -  * ");

            inputLat.getText().clear();
            inputLon.getText().clear();
            hint.setText(" ");
            inputLat.requestFocus();

            // ENTER values and their types
            // N & S
            N_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    coordLat = Integer.parseInt(inputLat.getText().toString());
                    showToast(String.valueOf(coordLat)+" N");
                    lati_type = 8; // NORTH
                    inputLon.requestFocus();
                }
            });

            S_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    coordLat = Integer.parseInt(inputLat.getText().toString());
                    showToast(String.valueOf(coordLat) +" S");
                    lati_type = 2; // SOUTH
                    inputLon.requestFocus();
                }
            });
            // W & E
            W_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    coordLon = Integer.parseInt(inputLon.getText().toString());
                    showToast(String.valueOf(coordLon)+" W");
                    lon_type = 4; // WEST
                    checkCoords();
                }
            });

            E_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    coordLon = Integer.parseInt(inputLon.getText().toString());
                    showToast(String.valueOf(coordLon)+" E");
                    lon_type = 6; // EAST
                    checkCoords();
                }
            });
            // END of entering values
        }


        /*
         * half-degree mode:
         */
        else if (v.getId() == R.id.radio2){
            // init
            sel.setText(" - - -  * ");
            result.setText(" - - -  * ");

            inputLat.getText().clear();
            inputLon.getText().clear();
            hint.setText("(30)");
            inputLat.requestFocus();

            // N & S values
            N_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    coordLat = Integer.parseInt(inputLat.getText().toString());
                    showToast(String.valueOf(coordLat) +"30 N");
                    lati_type = 8; // NORTH
                    inputLon.requestFocus();
                }
            });
            S_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    coordLat = Integer.parseInt(inputLat.getText().toString());
                    showToast(String.valueOf(coordLat) +"30 S");
                    lati_type = 2; // SOUTH
                    inputLon.requestFocus();
                }
            });
            // W & E values:
            W_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    coordLon = Integer.parseInt(inputLon.getText().toString());
                    showToast(String.valueOf(coordLon)+" W");
                    lon_type = 4; // WEST
                    checkCoords_half_deg();
                }
            });

            E_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    coordLon = Integer.parseInt(inputLon.getText().toString());
                    showToast(String.valueOf(coordLon)+" E");
                    lon_type = 6; // EAST
                    checkCoords_half_deg();
                }
            });
            // END of entering values
        }
    }


// own functions:
    private void showToast(String text)
    {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    // NORMAL MODE:
    private void checkCoords()
    {
        // check the value types for correct format:
        if (lati_type == 8){
            if(lon_type == 4){
                // N W
                sel.setText("| | |  Sel: "+String.valueOf(coordLat)+"N "+String.valueOf(coordLon)+"W  | | |");

                if(coordLon == 100) result.setText("***  "+String.valueOf(coordLat)+"N00  ***   WEST");
                else if(coordLon == 0) result.setText("***  "+String.valueOf(coordLat)+"00N  ***   WEST");
                else if(coordLon < 100) result.setText("***  "+String.valueOf(coordLat)+String.valueOf(coordLon)+"N  ***   WEST");
                else result.setText("***  "+String.valueOf(coordLat)+"N"+String.valueOf(coordLon-100)+"  ***   WEST");
            }
            else {
                // N E
                sel.setText("| | |  Sel: "+String.valueOf(coordLat)+"N "+String.valueOf(coordLon)+"E  | | |");

                if(coordLon == 100) result.setText("***  "+String.valueOf(coordLat)+"E00  ***   EAST");
                else if(coordLon == 0) result.setText("***  "+String.valueOf(coordLat)+"00E  ***   EAST");
                else if(coordLon < 100) result.setText("***  "+String.valueOf(coordLat)+String.valueOf(coordLon)+"E  ***   EAST");
                else result.setText("***  "+String.valueOf(coordLat)+"E"+String.valueOf(coordLon-100)+"  ***   EAST");
            }
        }
        else if (lati_type == 2) {
            if(lon_type == 4){
                // S W
                sel.setText("| | |  Sel: "+String.valueOf(coordLat)+"S "+String.valueOf(coordLon)+"W  | | |");

                if(coordLon == 100) result.setText("***  "+String.valueOf(coordLat)+"W00  ***   WEST");
                else if(coordLon == 0) result.setText("***  "+String.valueOf(coordLat)+"00W  ***   WEST");
                else if(coordLon < 100) result.setText("***  "+String.valueOf(coordLat)+String.valueOf(coordLon)+"W  ***   WEST");
                else result.setText("***  "+String.valueOf(coordLat)+"W"+String.valueOf(coordLon-100)+"  ***   WEST");
            }
            else {
                // S E
                sel.setText("| | |  Sel: "+String.valueOf(coordLat)+"S "+String.valueOf(coordLon)+"E  | | |");

                if(coordLon == 100) result.setText("***  "+String.valueOf(coordLat)+"S00  ***   EAST");
                else if(coordLon == 0) result.setText("***  "+String.valueOf(coordLat)+"00S  ***   EAST");
                else if(coordLon < 100) result.setText("***  "+String.valueOf(coordLat)+String.valueOf(coordLon)+"S  ***   EAST");
                else result.setText("***  "+String.valueOf(coordLat)+"S"+String.valueOf(coordLon-100)+"  ***   EAST");
            }
        }

        else {
            sel.setText(" - - -  * ");
            result.setText(" - - -  * ");
        }
    }

    // HALF-DEGREE MODE:
    private void checkCoords_half_deg()
    {
        int num = coordLat;
        int digitB = num % 10;  //split last digit from number
        num /= 10;    // divide num by 10.
        int digitA = num % 10;  //split last digit from number

        // check the value types for correct format:
        if (lati_type == 8){
            if(lon_type == 4){
                // N W
                sel.setText("| | |  Sel: "+String.valueOf(coordLat)+"30N "+String.valueOf(coordLon)+"W  | | |");

                if(coordLon == 100) result.setText("***  "+String.valueOf(digitA)+"N"+String.valueOf(digitB)+"00  ***   WEST");
                else if(coordLon == 0) result.setText("***  N"+String.valueOf(coordLat)+"00  ***   WEST");
                else if(coordLon < 100) result.setText("***  N"+String.valueOf(coordLat)+String.valueOf(coordLon)+"  ***   WEST");
                else result.setText("***  "+String.valueOf(digitA)+"N"+String.valueOf(digitB)+String.valueOf(coordLon-100)+"  ***   WEST");
            }
            else {
                // N E
                sel.setText("| | |  Sel: "+String.valueOf(coordLat)+"30N "+String.valueOf(coordLon)+"E  | | |");

                if(coordLon == 100) result.setText("***  "+String.valueOf(digitA)+"E"+String.valueOf(digitB)+"00  ***   EAST");
                else if(coordLon == 0) result.setText("***  E"+String.valueOf(coordLat)+"00  ***   EAST");
                else if(coordLon < 100) result.setText("***  E"+String.valueOf(coordLat)+String.valueOf(coordLon)+"  ***   EAST");
                else result.setText("***  "+String.valueOf(digitA)+"E"+String.valueOf(digitB)+String.valueOf(coordLon-100)+"  ***   EAST");
            }
        }
        else if (lati_type == 2) {
            if(lon_type == 4){
                // S W
                sel.setText("| | |  Sel: "+String.valueOf(coordLat)+"30S "+String.valueOf(coordLon)+"W  | | |");

                if(coordLon == 100) result.setText("***  "+String.valueOf(digitA)+"W"+String.valueOf(digitB)+"00  ***   WEST");
                else if(coordLon == 0) result.setText("***  W"+String.valueOf(coordLat)+"00  ***   WEST");
                else if(coordLon < 100) result.setText("***  W"+String.valueOf(coordLat)+String.valueOf(coordLon)+"  ***   WEST");
                else result.setText("***  "+String.valueOf(digitA)+"W"+String.valueOf(digitB)+String.valueOf(coordLon-100)+"  ***   WEST");
            }
            else {
                // S E
                sel.setText("| | |  Sel: "+String.valueOf(coordLat)+"30S "+String.valueOf(coordLon)+"E  | | |");

                if(coordLon == 100) result.setText("***  "+String.valueOf(digitA)+"S"+String.valueOf(digitB)+"00  ***   EAST");
                else if(coordLon == 0) result.setText("***  S"+String.valueOf(coordLat)+"00  ***   EAST");
                else if(coordLon < 100) result.setText("***  S"+String.valueOf(coordLat)+String.valueOf(coordLon)+"  ***   EAST");
                else result.setText("***  "+String.valueOf(digitA)+"S"+String.valueOf(digitB)+String.valueOf(coordLon-100)+"  ***   EAST");
            }
        }

        else {
            sel.setText(" - - -  * ");
            result.setText(" - - -  * ");
        }
    }
}