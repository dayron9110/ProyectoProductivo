package com.example.proyectoproductivo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.github.aakira.expandablelayout.ExpandableWeightLayout;
import com.riyagayasen.easyaccordion.AccordionExpansionCollapseListener;
import com.riyagayasen.easyaccordion.AccordionView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GastosPreo extends AppCompatActivity {

    EditText con5GP, con5_1GP, cant1GP, cant2GP, cant3GP, cant4GP, cant5GP, cant5_1GP, valU1GP, valU2GP, valU3GP, valU4GP, valU5GP, valU5_1GP;
    EditText valT1GP, valT2GP, valT3GP, valT4GP, valT5GP, valT5_1GP, fuentePs1GP, fuentePs2GP, fuentePs3GP, fuentePs4GP, fuentePs5GP, fuentePs5_1GP, fuenteHogar1GP, fuenteHogar2GP, fuenteHogar3GP, fuenteHogar4GP, fuenteHogar5GP, fuenteHogar5_1GP;
    EditText totalGP, total_psGP, total_hogarGP;//total_verifGP;
    AppCompatSpinner ver1GP, ver2GP, ver3GP, ver4GP, ver5GP, ver5_1GP, undM1GP, undM2GP, undM3GP, undM4GP, undM5GP, undM5_1GP;
    int GT, GT_PS, GT_HOG;
    private AccordionView accordionViewOne;
    TextView VSug1, VSug2, VSug3, VSug4;
    Button ItemAdicional;
    HashMap<String, String> hm = new HashMap<String, String>();
    String ShaPreSector;
    ExpandableWeightLayout expandableLayout;
    Spinner con1GP, con2GP, con3GP, con4GP;
    ArrayAdapter<String> dataAdapterS_A, dataAdapterS_A_peces, dataAdapterS_A_cerdos, dataAdapterS_A_bovino, dataAdapterS_A_aves_corral, dataAdapterS_C_restaurante, dataAdapterS_G_comercio, dataAdapterS_G_papeleria, dataAdapterS_G_ropa, dataAdapterS_S_peluqueria, dataAdapterOtros;
    BottomNavigationView btnNV;
    private SharedPreferences sharedPreferences, sharedPreferencesRD, dataEncuenta;
    SharedPreferences.Editor editor, editorRD;
    Button c5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos_preo);
        // accordionViewOne = (AccordionView) findViewById(R.id.accordion);
        ItemAdicional = findViewById(R.id.expandButton);
        ItemAdicional.setText("Tiene un insumo adicional? " + Character.toString((char) 9660) + " ");

        expandableLayout
                = (ExpandableWeightLayout) findViewById(R.id.expandableLayout);
        btnNV = findViewById(R.id.navigationView);
        con1GP = findViewById(R.id.CON1GP);
        con2GP = findViewById(R.id.CON2GP);
        con3GP = findViewById(R.id.CON3GP);
        con4GP = findViewById(R.id.CON4GP);
        con5GP = findViewById(R.id.CON5GP);
        con5_1GP = findViewById(R.id.CON5_1GP);
        cant1GP = findViewById(R.id.CAN1GP);
        cant2GP = findViewById(R.id.CAN2GP);
        cant3GP = findViewById(R.id.CAN3GP);
        cant4GP = findViewById(R.id.CAN4GP);
        cant5GP = findViewById(R.id.CAN5GP);
        cant5_1GP = findViewById(R.id.CAN5_1GP);
        undM1GP = findViewById(R.id.UM1GP);
        undM2GP = findViewById(R.id.UM2GP);
        undM3GP = findViewById(R.id.UM3GP);
        undM4GP = findViewById(R.id.UM4GP);
        undM5GP = findViewById(R.id.UM5GP);
        undM5_1GP = findViewById(R.id.UM5_1GP);
        valU1GP = findViewById(R.id.VU1GP);
        valU2GP = findViewById(R.id.VU2GP);
        valU3GP = findViewById(R.id.VU3GP);
        valU4GP = findViewById(R.id.VU4GP);
        valU5GP = findViewById(R.id.VU5GP);
        valU5_1GP = findViewById(R.id.VU5_1GP);
        VSug1 = findViewById(R.id.VSug1GP);
        VSug2 = findViewById(R.id.VSug2GP);
        VSug3 = findViewById(R.id.VSug3GP);
        VSug4 = findViewById(R.id.VSug4GP);

        ver1GP = findViewById(R.id.VERF1GP);
        ver2GP = findViewById(R.id.VERF2GP);
        ver3GP = findViewById(R.id.VERF3GP);
        ver4GP = findViewById(R.id.VERF4GP);
        ver5GP = findViewById(R.id.VERF5GP);
        ver5_1GP = findViewById(R.id.VERF5_1GP);
        valT1GP = findViewById(R.id.VT1GP);
        valT2GP = findViewById(R.id.VT2GP);
        valT3GP = findViewById(R.id.VT3GP);
        valT4GP = findViewById(R.id.VT4GP);
        valT5GP = findViewById(R.id.VT5GP);
        valT5_1GP = findViewById(R.id.VT5_1GP);
        fuentePs1GP = findViewById(R.id.PS1GP);
        fuentePs2GP = findViewById(R.id.PS2GP);
        fuentePs3GP = findViewById(R.id.PS3GP);
        fuentePs4GP = findViewById(R.id.PS4GP);
        fuentePs5GP = findViewById(R.id.PS5GP);
        fuentePs5_1GP = findViewById(R.id.PS5_1GP);
        fuenteHogar1GP = findViewById(R.id.HO1GP);
        fuenteHogar2GP = findViewById(R.id.HO2GP);
        fuenteHogar3GP = findViewById(R.id.HO3GP);
        fuenteHogar4GP = findViewById(R.id.HO4GP);
        fuenteHogar5GP = findViewById(R.id.HO5GP);
        fuenteHogar5_1GP = findViewById(R.id.HO5_1GP);
        totalGP = findViewById(R.id.TOTAL_GP);
        total_psGP = findViewById(R.id.TOTAL_PS_GP);
        total_hogarGP = findViewById(R.id.TOTAL_HOGAR_GP);//total_verifGP=findViewById(R.id.TOTAL_VERIFICACION_GP);
        c5 = findViewById(R.id.C5);

        sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        sharedPreferencesRD = getSharedPreferences("recuperadatos", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editorRD = sharedPreferencesRD.edit();

        try {
            InputStreamReader is = new InputStreamReader(getAssets()
                    .open("precios_sugeridos.csv"));
            BufferedReader reader = new BufferedReader(is);
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(";");
                String nom_item = tokens[0];
                String price = tokens[1];
                hm.put(nom_item, price);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        ShaPreSector = sharedPreferences.getString("codSector", "");
        Toast.makeText(this, "" + sharedPreferences.getString("codSector", ""), Toast.LENGTH_SHORT).show();
        List<String> list_Sec_A = new ArrayList<String>();
        list_Sec_A.add("Seleccione......");
        list_Sec_A.add("MALLA PLASTICA");
        list_Sec_A.add("MALLA METALICA");
        list_Sec_A.add("ESTACAS DE MADERA");
        list_Sec_A.add("ALAMBRE");
        list_Sec_A.add("CABUYA");
        list_Sec_A.add("CAL DOLOMITA");
        List<String> list_Sec_A_peces = new ArrayList<String>();
        list_Sec_A_peces.add("Seleccione......");
        list_Sec_A_peces.add("PIOLA");
        list_Sec_A_peces.add("AGUJA DE MADERA");
        list_Sec_A_peces.add("NAILON");
        list_Sec_A_peces.add("FABRICACIÓN CAVAS");
        List<String> list_Sec_A_cerdos = new ArrayList<String>();
        list_Sec_A_cerdos.add("Seleccione......");
        list_Sec_A_cerdos.add("CEMENTO");
        list_Sec_A_cerdos.add("MADERA");
        list_Sec_A_cerdos.add("TEJAS");
        list_Sec_A_cerdos.add("TUBOS PBC");
        list_Sec_A_cerdos.add("PERFILES METALICOS");
        List<String> list_Sec_A_bovino = new ArrayList<String>();
        list_Sec_A_bovino.add("Seleccione......");
        list_Sec_A_bovino.add("ESTACAS DE MADERA");
        list_Sec_A_bovino.add("ALAMBRE");
        list_Sec_A_bovino.add("CABUYA");
        List<String> list_Sec_A_aves_corral = new ArrayList<String>();
        list_Sec_A_aves_corral.add("Seleccione......");
        list_Sec_A_aves_corral.add("MALLA PLASTICA");
        list_Sec_A_aves_corral.add("MALLA METALICA");
        list_Sec_A_aves_corral.add("AMARRES");
        list_Sec_A_aves_corral.add("MADERA");
        list_Sec_A_aves_corral.add("ILUMINACION");
        list_Sec_A_aves_corral.add("TEJAS ZINC");
        List<String> list_Sec_C_restaurante = new ArrayList<String>();
        list_Sec_C_restaurante.add("Seleccione......");
        list_Sec_C_restaurante.add("ILUMINACION");
        list_Sec_C_restaurante.add("PINTURA");
        list_Sec_C_restaurante.add("CABLEADO");
        List<String> list_Sec_G_comercio = new ArrayList<String>();
        list_Sec_G_comercio.add("Seleccione......");//FRUVER
        list_Sec_G_comercio.add("PINTURA");
        list_Sec_G_comercio.add("ALUMBRADO");
        list_Sec_G_comercio.add("PUERTAS");
        list_Sec_G_comercio.add("CABLEADO");
        List<String> list_Sec_G_papeleria = new ArrayList<String>();
        list_Sec_G_papeleria.add("Seleccione......");
        list_Sec_G_papeleria.add("PINTURA");
        list_Sec_G_papeleria.add("ILUMINACION");
        list_Sec_G_papeleria.add("REJAS ENRROLLABLES");
        list_Sec_G_papeleria.add("CABLEADO");
        List<String> list_Sec_G_ropa = new ArrayList<String>();
        list_Sec_G_ropa.add("Seleccione......");
        list_Sec_G_ropa.add("PINTURA");
        list_Sec_G_ropa.add("ILUMINACION");
        list_Sec_G_ropa.add("SEPARACIONES/VESTIERES");
        list_Sec_G_ropa.add("CABLEADO");
        List<String> list_Sec_S_peluqueria = new ArrayList<String>();
        list_Sec_S_peluqueria.add("Seleccione......");
        list_Sec_S_peluqueria.add("PINTURA");
        list_Sec_S_peluqueria.add("ILUMINACION");
        list_Sec_S_peluqueria.add("CABLEADO");
        List<String> list_Otros = new ArrayList<String>();  //mio 25 marzo
        list_Otros.add("Seleccione......");
        list_Otros.add("MALLA PLASTICA");
        list_Otros.add("MALLA METALICA");
        list_Otros.add("ESTACAS DE MADERA");
        list_Otros.add("ALAMBRE");
        list_Otros.add("CABUYA");
        list_Otros.add("CAL DOLOMITA");
        list_Otros.add("PIOLA");
        list_Otros.add("AGUJA DE MADERA");
        list_Otros.add("NAILON");
        list_Otros.add("FABRICACIÓN CAVAS");
        list_Otros.add("CEMENTO");
        list_Otros.add("MADERA");
        list_Otros.add("TEJAS");
        list_Otros.add("TUBOS PBC");
        list_Otros.add("PERFILES METALICOS");
        list_Otros.add("AMARRES");
        list_Otros.add("PUERTAS");
        list_Otros.add("ILUMINACION");
        list_Otros.add("TEJAS ZINC");
        list_Otros.add("PINTURA");
        list_Otros.add("CABLEADO");
        list_Otros.add("REJAS ENRROLLABLES");
        list_Otros.add("SEPARACIONES/VESTIERES");
        list_Otros.add("ALUMBRADO");
        dataAdapterS_A = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list_Sec_A);
        dataAdapterS_A.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterS_A_peces = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list_Sec_A_peces);
        dataAdapterS_A_peces.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterS_A_cerdos = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list_Sec_A_cerdos);
        dataAdapterS_A_cerdos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterS_A_bovino = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list_Sec_A_bovino);
        dataAdapterS_A_bovino.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterS_A_aves_corral = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list_Sec_A_aves_corral);
        dataAdapterS_A_aves_corral.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterS_C_restaurante = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list_Sec_C_restaurante);
        dataAdapterS_C_restaurante.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterS_G_comercio = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list_Sec_G_comercio);
        dataAdapterS_G_comercio.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterS_G_papeleria = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list_Sec_G_papeleria);
        dataAdapterS_G_papeleria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterS_G_ropa = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list_Sec_G_ropa);
        dataAdapterS_G_ropa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterS_S_peluqueria = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list_Sec_S_peluqueria);
        dataAdapterS_S_peluqueria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterOtros = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list_Otros);
        dataAdapterOtros.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").substring(0, 2).equals("03")) {
            con1GP.setAdapter(dataAdapterS_A_peces);
            con2GP.setAdapter(dataAdapterS_A_peces);
            con3GP.setAdapter(dataAdapterS_A_peces);
            con4GP.setAdapter(dataAdapterS_A_peces);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0144")) {
            con1GP.setAdapter(dataAdapterS_A_cerdos);
            con2GP.setAdapter(dataAdapterS_A_cerdos);
            con3GP.setAdapter(dataAdapterS_A_cerdos);
            con4GP.setAdapter(dataAdapterS_A_cerdos);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0145")) {
            con1GP.setAdapter(dataAdapterS_A_aves_corral);
            con2GP.setAdapter(dataAdapterS_A_aves_corral);
            con3GP.setAdapter(dataAdapterS_A_aves_corral);
            con4GP.setAdapter(dataAdapterS_A_aves_corral);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0141")) {
            con1GP.setAdapter(dataAdapterS_A_bovino);
            con2GP.setAdapter(dataAdapterS_A_bovino);
            con3GP.setAdapter(dataAdapterS_A_bovino);
            con4GP.setAdapter(dataAdapterS_A_bovino);
        } else if (ShaPreSector.equals("SECCION A")) {
            con1GP.setAdapter(dataAdapterS_A);
            con2GP.setAdapter(dataAdapterS_A);
            con3GP.setAdapter(dataAdapterS_A);
            con4GP.setAdapter(dataAdapterS_A);
        }

        if (ShaPreSector.equals("SECCION C")) {
            con1GP.setAdapter(dataAdapterS_C_restaurante);
            con2GP.setAdapter(dataAdapterS_C_restaurante);
            con3GP.setAdapter(dataAdapterS_C_restaurante);
            con4GP.setAdapter(dataAdapterS_C_restaurante);
        } //


        if (ShaPreSector.equals("SECCION G") && (sharedPreferences.getString("codAct", "").substring(0, 3).equals("471") || sharedPreferences.getString("codAct", "").substring(0, 3).equals("472") || sharedPreferences.getString("codAct", "").equals("4781"))) {
            con1GP.setAdapter(dataAdapterS_G_comercio);
            con2GP.setAdapter(dataAdapterS_G_comercio);
            con3GP.setAdapter(dataAdapterS_G_comercio);
            con4GP.setAdapter(dataAdapterS_G_comercio);
        } //47
        else if (ShaPreSector.equals("SECCION G") && sharedPreferences.getString("codAct", "").substring(0, 2).equals("46")) {
            con1GP.setAdapter(dataAdapterS_G_ropa);
            con2GP.setAdapter(dataAdapterS_G_ropa);
            con3GP.setAdapter(dataAdapterS_G_ropa);
            con4GP.setAdapter(dataAdapterS_G_ropa);
        } else if (ShaPreSector.equals("SECCION G") && (sharedPreferences.getString("codAct", "").substring(0, 3).equals("479") || sharedPreferences.getString("codAct", "").equals("4789") || sharedPreferences.getString("codAct", "").equals("4782"))) {
            con1GP.setAdapter(dataAdapterS_G_papeleria);
            con2GP.setAdapter(dataAdapterS_G_papeleria);
            con3GP.setAdapter(dataAdapterS_G_papeleria);
            con4GP.setAdapter(dataAdapterS_G_papeleria);
        } else if (ShaPreSector.equals("SECCION G")) {
            con1GP.setAdapter(dataAdapterOtros);
            con2GP.setAdapter(dataAdapterOtros);
            con3GP.setAdapter(dataAdapterOtros);
            con4GP.setAdapter(dataAdapterOtros);
        }

        if (ShaPreSector.equals("SECCION S")) {
            con1GP.setAdapter(dataAdapterS_S_peluqueria);
            con2GP.setAdapter(dataAdapterS_S_peluqueria);
            con3GP.setAdapter(dataAdapterS_S_peluqueria);
            con4GP.setAdapter(dataAdapterS_S_peluqueria);
        } //
//ShaPreSector.equals("SECCION A")||ShaPreSector.equals("SECCION C")||ShaPreSector.equals("SECCION G")||ShaPreSector.equals("SECCION S")
        if (!(ShaPreSector.equals("SECCION A") || ShaPreSector.equals("SECCION C") || ShaPreSector.equals("SECCION G") || ShaPreSector.equals("SECCION S"))) {
            con1GP.setAdapter(dataAdapterOtros);
            con2GP.setAdapter(dataAdapterOtros);
            con3GP.setAdapter(dataAdapterOtros);
            con4GP.setAdapter(dataAdapterOtros);
        }

        expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
            }

            @Override
            public void onPreClose() {
            }
        });

        ArrayAdapter<CharSequence> adapterUM = ArrayAdapter.createFromResource(this, R.array.und_medida, R.layout.textview);
        undM1GP.setAdapter(adapterUM);
        undM2GP.setAdapter(adapterUM);
        undM3GP.setAdapter(adapterUM);
        undM4GP.setAdapter(adapterUM);
//if(!con1GP.getSelectedItem().toString().equals("Seleccione......"))
//{valU1GP.setHint("->$"+hm.get(con1GP.getSelectedItem().toString()));}

        undM1GP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //  Toast.makeText(GastosPreo.this, ""+hm.get(con1GP.getSelectedItem().toString()), Toast.LENGTH_SHORT).show();
                if (!con1GP.getSelectedItem().toString().equals("Seleccione......")) {
                    // valU1GP.setHint("Sugerido:"+hm.get(con1GP.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con1GP.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug1.setText(WordtoSpan);
                }
                editorRD.putInt("undM1GP", posicionUM);
                editorRD.commit();
                editor.putString("undM1GP", undM1GP.getSelectedItem().toString());
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM2GP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                if (!con2GP.getSelectedItem().toString().equals("Seleccione......")) {
                    //  valU2GP.setHint("Sugerido:"+hm.get(con2GP.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con2GP.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug2.setText(WordtoSpan);
                }
                editorRD.putInt("undM2GP", posicionUM);
                editorRD.commit();
                editor.putString("undM2GP", undM2GP.getSelectedItem().toString());
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM3GP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                if (!con3GP.getSelectedItem().toString().equals("Seleccione......")) {
                    //valU3GP.setHint("Sugerido:"+hm.get(con3GP.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con3GP.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug3.setText(WordtoSpan);
                }
                editorRD.putInt("undM3GP", posicionUM);
                editorRD.commit();
                editor.putString("undM3GP", undM3GP.getSelectedItem().toString());
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM4GP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                if (!con4GP.getSelectedItem().toString().equals("Seleccione......")) {
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con4GP.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug4.setText(WordtoSpan);
                }
                editorRD.putInt("undM4GP", posicionUM);
                editorRD.commit();
                editor.putString("undM4GP", undM4GP.getSelectedItem().toString());
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
            }
        });
        undM5GP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM5GP", posicionUM);
                editorRD.commit();
                editor.putString("undM5GP", undM5GP.getSelectedItem().toString());
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM5_1GP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                editorRD.putInt("undM5_1GP", posicionUM);
                editorRD.commit();
                editor.putString("undM5_1GP", undM5_1GP.getSelectedItem().toString());
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ver1GP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver1GP", ver1GP.getSelectedItem().toString());
                editorRD.putString("ver1GP", ver1GP.getSelectedItem().toString());
                if (cant1GP.getText().toString().matches("")) {
                } else {

                    if (!valU1GP.getText().toString().matches("")) {
                        valT1GP.setText(String.valueOf(Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString())));
                        try {
                            GT = Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString()) + 0 + 0 + 0;
                            GT_PS = Integer.parseInt(fuentePs1GP.getText().toString());
                            GT_HOG = Integer.parseInt(fuenteHogar1GP.getText().toString());
                        } catch (Exception e) {
                        }
                        totalGP.setText(String.valueOf(GT));
                        total_psGP.setText(String.valueOf(GT_PS));
                        total_hogarGP.setText(String.valueOf(GT_HOG));
                        editor.putString("valT1GP", valT1GP.getText().toString());
                        editorRD.putString("valT1GP", valT1GP.getText().toString());
                    } else {
                        editor.putString("valT1GP", "");
                        editorRD.putString("valT1GP", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(AGPFijos.this, sharedPreferencesRD.getString("valT1GP", ""), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ver2GP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver2GP", ver2GP.getSelectedItem().toString());
                editorRD.putString("ver2GP", ver2GP.getSelectedItem().toString());
                if (!cant2GP.getText().toString().matches("") && !cant1GP.getText().toString().matches("") && !valU2GP.getText().toString().matches("") && !valU1GP.getText().toString().matches("")) {
                    valT2GP.setText(String.valueOf(Integer.parseInt(cant2GP.getText().toString()) * Integer.parseInt(valU2GP.getText().toString())));
                    try {
                        GT = Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString()) + Integer.parseInt(cant2GP.getText().toString()) * Integer.parseInt(valU2GP.getText().toString()) + 0 + 0;
                        GT_PS = Integer.parseInt(fuentePs1GP.getText().toString()) + Integer.parseInt(fuentePs2GP.getText().toString());
                        GT_HOG = Integer.parseInt(fuenteHogar1GP.getText().toString()) + Integer.parseInt(fuenteHogar2GP.getText().toString());
                    } catch (Exception e) {
                    }
                    totalGP.setText(String.valueOf(GT));
                    total_psGP.setText(String.valueOf(GT_PS));
                    total_hogarGP.setText(String.valueOf(GT_HOG));
                    editor.putString("valT2GP", valT2GP.getText().toString());
                    editorRD.putString("valT2GP", valT2GP.getText().toString());
                } else {
                    Toast.makeText(GastosPreo.this, "Complete todos los datos del 2do recuadro.", Toast.LENGTH_SHORT).show();
                    editor.putString("valT2GP", "");
                    editorRD.putString("valT2GP", "");
                }
                editor.commit();
                editorRD.commit();
                //        Toast.makeText(AGPFijos.this, sharedPreferencesRD.getString("valT1GP", ""), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ver3GP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver3GP", ver3GP.getSelectedItem().toString());
                editorRD.putString("ver3GP", ver3GP.getSelectedItem().toString());
                if (cant3GP.getText().toString().matches("") || valU3GP.getText().toString().matches("")) {
                    Toast.makeText(GastosPreo.this, "Complete todos los datos del 3er recuadro.", Toast.LENGTH_LONG).show();

                } else {

                    if (!valU3GP.getText().toString().matches("")) {
                        valT3GP.setText(String.valueOf(Integer.parseInt(cant3GP.getText().toString()) * Integer.parseInt(valU3GP.getText().toString())));
                        editor.putString("valT3GP", valT3GP.getText().toString());
                        editorRD.putString("valT3GP", valT3GP.getText().toString());
                        if (!valU2GP.getText().toString().matches("") && !cant2GP.getText().toString().matches("")) {
                            try {
                                GT = Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString()) + Integer.parseInt(cant2GP.getText().toString()) * Integer.parseInt(valU2GP.getText().toString()) + Integer.parseInt(cant3GP.getText().toString()) * Integer.parseInt(valU3GP.getText().toString()) + 0;
                                GT_PS = Integer.parseInt(fuentePs1GP.getText().toString()) + Integer.parseInt(fuentePs2GP.getText().toString()) + Integer.parseInt(fuentePs3GP.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1GP.getText().toString()) + Integer.parseInt(fuenteHogar2GP.getText().toString()) + Integer.parseInt(fuenteHogar3GP.getText().toString());
                            } catch (Exception e) {
                            }
                            totalGP.setText(String.valueOf(GT));
                            total_psGP.setText(String.valueOf(GT_PS));
                            total_hogarGP.setText(String.valueOf(GT_HOG));
                        }
                    } else {
                        editor.putString("valT3GP", "");
                        editorRD.putString("valT3GP", "");
                    }
                    editor.commit();
                    editorRD.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });

        ver4GP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver4GP", ver4GP.getSelectedItem().toString());
                editorRD.putString("ver4GP", ver4GP.getSelectedItem().toString());
                if (cant4GP.getText().toString().matches("") || valU4GP.getText().toString().matches("")) {
                    Toast.makeText(GastosPreo.this, "Complete todos los datos del 4to recuadro.", Toast.LENGTH_LONG).show();
                } else {

                    if (!valU4GP.getText().toString().matches("")) {
                        valT4GP.setText(String.valueOf(Integer.parseInt(cant4GP.getText().toString()) * Integer.parseInt(valU4GP.getText().toString())));

                        editor.putString("valT4GP", valT4GP.getText().toString());
                        editorRD.putString("valT4GP", valT4GP.getText().toString());
                        if (!valU2GP.getText().toString().matches("") && !valU3GP.getText().toString().matches("") && !cant2GP.getText().toString().matches("") && !cant3GP.getText().toString().matches("")) {

                            try {
                                GT = Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString()) + Integer.parseInt(cant2GP.getText().toString()) * Integer.parseInt(valU2GP.getText().toString()) + Integer.parseInt(cant3GP.getText().toString()) * Integer.parseInt(valU3GP.getText().toString()) + Integer.parseInt(cant4GP.getText().toString()) * Integer.parseInt(valU4GP.getText().toString());
                                GT_PS = Integer.parseInt(fuentePs1GP.getText().toString()) + Integer.parseInt(fuentePs2GP.getText().toString()) + Integer.parseInt(fuentePs3GP.getText().toString()) + Integer.parseInt(fuentePs4GP.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1GP.getText().toString()) + Integer.parseInt(fuenteHogar2GP.getText().toString()) + Integer.parseInt(fuenteHogar3GP.getText().toString()) + Integer.parseInt(fuenteHogar4GP.getText().toString());
                            } catch (Exception e) {
                            }
                            totalGP.setText(String.valueOf(GT));
                            total_psGP.setText(String.valueOf(GT_PS));
                            total_hogarGP.setText(String.valueOf(GT_HOG));

                        }
                    } else {
                        editor.putString("valT4GP", "");
                        editorRD.putString("valT4GP", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ver5GP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GastosPreo.this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver5GP", ver5GP.getSelectedItem().toString());
                editorRD.putString("ver5GP", ver5GP.getSelectedItem().toString());
                if (cant5GP.getText().toString().matches("")) {
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0;
                    if (!valU5GP.getText().toString().matches("")) {
                        valT5GP.setText(String.valueOf(Integer.parseInt(cant5GP.getText().toString()) * Integer.parseInt(valU5GP.getText().toString())));

                        editor.putString("valT5GP", valT5GP.getText().toString());
                        editorRD.putString("valT5GP", valT5GP.getText().toString());

                        if (valU1GP.getText().toString().matches("") && cant1GP.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString());
                        }
                        if (valU2GP.getText().toString().matches("") && cant2GP.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2GP.getText().toString()) * Integer.parseInt(valU2GP.getText().toString());
                        }
                        if (valU3GP.getText().toString().matches("") && cant3GP.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3GP.getText().toString()) * Integer.parseInt(valU3GP.getText().toString());
                        }
                        if (valU4GP.getText().toString().matches("") && cant4GP.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4GP.getText().toString()) * Integer.parseInt(valU4GP.getText().toString());
                        }

                        if (fuentePs1GP.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1GP.getText().toString());
                        }
                        if (fuentePs2GP.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2GP.getText().toString());
                        }
                        if (fuentePs3GP.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3GP.getText().toString());
                        }
                        if (fuentePs4GP.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4GP.getText().toString());
                        }

                        if (fuenteHogar1GP.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1GP.getText().toString());
                        }
                        if (fuenteHogar2GP.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2GP.getText().toString());
                        }
                        if (fuenteHogar3GP.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3GP.getText().toString());
                        }
                        if (fuenteHogar4GP.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4GP.getText().toString());
                        }

                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + Integer.parseInt(cant5GP.getText().toString()) * Integer.parseInt(valU5GP.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + Integer.parseInt(fuentePs5GP.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + Integer.parseInt(fuenteHogar5GP.getText().toString());
                        } catch (Exception e) {
                        }
                        totalGP.setText(String.valueOf(GT));
                        total_psGP.setText(String.valueOf(GT_PS));
                        total_hogarGP.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5GP", "");
                        editorRD.putString("valT5GP", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ver5_1GP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();

                if (cant5_1GP.getText().toString().matches("") || valU5_1GP.getText().toString().matches("")) {
                    Toast.makeText(GastosPreo.this, "Revise que este todo completo", Toast.LENGTH_LONG).show();
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorT5 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorPS5 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0, valorHogar5 = 0;
                    if (!valU5_1GP.getText().toString().matches("")) {
                        valT5_1GP.setText(String.valueOf(Integer.parseInt(cant5_1GP.getText().toString()) * Integer.parseInt(valU5_1GP.getText().toString())));

                        editor.putString("valT5_1GP", valT5_1GP.getText().toString());
                        editorRD.putString("valT5_1GP", valT5_1GP.getText().toString());

                        if (valU1GP.getText().toString().matches("") && cant1GP.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString());
                        }
                        if (valU2GP.getText().toString().matches("") && cant2GP.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2GP.getText().toString()) * Integer.parseInt(valU2GP.getText().toString());
                        }
                        if (valU3GP.getText().toString().matches("") && cant3GP.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3GP.getText().toString()) * Integer.parseInt(valU3GP.getText().toString());
                        }
                        if (valU4GP.getText().toString().matches("") && cant4GP.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4GP.getText().toString()) * Integer.parseInt(valU4GP.getText().toString());
                        }
                        if (valU5GP.getText().toString().matches("") && cant5GP.getText().toString().matches("")) {
                            valorT5 = 0;
                        } else {
                            valorT5 = Integer.parseInt(cant5GP.getText().toString()) * Integer.parseInt(valU5GP.getText().toString());
                        }

                        if (fuentePs1GP.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1GP.getText().toString());
                        }
                        if (fuentePs2GP.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2GP.getText().toString());
                        }
                        if (fuentePs3GP.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3GP.getText().toString());
                        }
                        if (fuentePs4GP.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4GP.getText().toString());
                        }
                        if (fuentePs5GP.getText().toString().matches("")) {
                            valorPS5 = 0;
                        } else {
                            valorPS5 = Integer.parseInt(fuentePs5GP.getText().toString());
                        }

                        if (fuenteHogar1GP.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1GP.getText().toString());
                        }
                        if (fuenteHogar2GP.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2GP.getText().toString());
                        }
                        if (fuenteHogar3GP.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3GP.getText().toString());
                        }
                        if (fuenteHogar4GP.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4GP.getText().toString());
                        }
                        if (fuenteHogar5GP.getText().toString().matches("")) {
                            valorHogar5 = 0;
                        } else {
                            valorHogar5 = Integer.parseInt(fuenteHogar5GP.getText().toString());
                        }


                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + valorT5 + Integer.parseInt(cant5_1GP.getText().toString()) * Integer.parseInt(valU5_1GP.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + valorPS5 + Integer.parseInt(fuentePs5_1GP.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + valorHogar5 + Integer.parseInt(fuenteHogar5_1GP.getText().toString());
                        } catch (Exception e) {
                        }
                        totalGP.setText(String.valueOf(GT));
                        total_psGP.setText(String.valueOf(GT_PS));
                        total_hogarGP.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5_1GP", "");
                        editorRD.putString("valT5_1GP", "");
                    }
                    editor.putString("ver5_1GP", ver5_1GP.getSelectedItem().toString());
                    editorRD.putString("ver5_1GP", ver5_1GP.getSelectedItem().toString());
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /*accordionViewOne.setOnExpandCollapseListener(new AccordionExpansionCollapseListener() {
            @Override
            public void onExpanded(AccordionView view) {

            }
            @Override
            public void onCollapsed(AccordionView view) {

            }
        });*/


        btnNV.getMenu().findItem(R.id.atras).setChecked(true);
        btnNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int mMenuId = item.getItemId();
                for (int i = 0; i < btnNV.getMenu().size(); i++) {
                    MenuItem menuItem = btnNV.getMenu().getItem(i);
                    boolean isChecked = menuItem.getItemId() == item.getItemId();
                    menuItem.setChecked(isChecked);
                }

                switch (item.getItemId()) {
                    case R.id.atras: {
                        //enviar todos los cvs
                        // GastosPreo.super.onBackPressed();
                        Intent intent = new Intent(GastosPreo.this, Inversion.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        // revisar             intent.putExtra("encuestas",sharedPreferences.getString("datosver", ""));
                        startActivity(intent);
                    }
                    break;
                    case R.id.next: {
                        //  SharedPreferences.Editor editor = sharedPreferences.edit();
                        //       editor.clear();editor.commit();

                        if (con1GP.getSelectedItem().toString().matches("Seleccione......") || cant1GP.getText().toString().matches("")
                                || valT1GP.getText().toString().matches("") || fuentePs1GP.getText().toString().matches("")
                                || fuenteHogar1GP.getText().toString().matches("") || totalGP.getText().toString().matches("")) {
                            Toast.makeText(GastosPreo.this, "Llene todos los campos, la seccion de Totales (abajo)", Toast.LENGTH_LONG).show();
                        } else {
                            // revisar               editor.putString("CC", editTextCC.getText().toString());
                            //       Toast.makeText(MainActivity.this, ""+nombre.getText().toString(), Toast.LENGTH_SHORT).show();
             /*               if(tipoProyec.getText()!=null) {

                                editor.putString("tipoP", tipoProyec.getText().toString());

                                //Toast.makeText(MainActivity.this, "no tiene segundo nombre", Toast.LENGTH_SHORT).show();
                            }
 */
                            //

                            editor.putString("con1GP", con1GP.getSelectedItem().toString());     //14 marzo
                            if (con2GP.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con2GP", "");
                            } else {
                                editor.putString("con2GP", con2GP.getSelectedItem().toString());
                            }
                            if (con3GP.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con3GP", "");
                            } else {
                                editor.putString("con3GP", con3GP.getSelectedItem().toString());
                            }
                            if (con4GP.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con4GP", "");
                            } else {
                                editor.putString("con4GP", con4GP.getSelectedItem().toString());
                            }
                            if (con5GP.getText().toString().matches("")) {
                                editor.putString("con5GP", "");
                            } else {
                                editor.putString("con5GP", con5GP.getText().toString());
                            }
                            if (con5_1GP.getText().toString().matches("")) {
                                editor.putString("con5_1GP", "");
                            } else {
                                editor.putString("con5_1GP", con5_1GP.getText().toString());
                            }

                            if (cant1GP.getText().toString().matches("")) {
                                editor.putString("cant1GP", "");
                            } else {
                                editor.putString("cant1GP", cant1GP.getText().toString());
                            }
                            if (cant2GP.getText().toString().matches("")) {
                                editor.putString("cant2GP", "");
                            } else {
                                editor.putString("cant2GP", cant2GP.getText().toString());
                            }
                            if (cant3GP.getText().toString().matches("")) {
                                editor.putString("cant3GP", "");
                            } else {
                                editor.putString("cant3GP", cant3GP.getText().toString());
                            }
                            if (cant4GP.getText().toString().matches("")) {
                                editor.putString("cant4GP", "");
                            } else {
                                editor.putString("cant4GP", cant4GP.getText().toString());
                            }
                            if (cant5GP.getText().toString().matches("")) {
                                editor.putString("cant5GP", "");
                            } else {
                                editor.putString("cant5GP", cant5GP.getText().toString());
                            }
                            if (cant5_1GP.getText().toString().matches("")) {
                                editor.putString("cant5_1GP", "");
                            } else {
                                editor.putString("cant5_1GP", cant5_1GP.getText().toString());
                            }

                            if (valU1GP.getText().toString().matches("")) {
                                editor.putString("valU1GP", "");
                            } else {
                                editor.putString("valU1GP", valU1GP.getText().toString());
                            }
                            if (valU2GP.getText().toString().matches("")) {
                                editor.putString("valU2GP", "");
                            } else {
                                editor.putString("valU2GP", valU2GP.getText().toString());
                            }
                            if (valU3GP.getText().toString().matches("")) {
                                editor.putString("valU3GP", "");
                            } else {
                                editor.putString("valU3GP", valU3GP.getText().toString());
                            }
                            if (valU4GP.getText().toString().matches("")) {
                                editor.putString("valU4GP", "");
                            } else {
                                editor.putString("valU4GP", valU4GP.getText().toString());
                            }
                            if (valU5GP.getText().toString().matches("")) {
                                editor.putString("valU5GP", "");
                            } else {
                                editor.putString("valU5GP", valU5GP.getText().toString());
                            }
                            if (valU5_1GP.getText().toString().matches("")) {
                                editor.putString("valU5_1GP", "");
                            } else {
                                editor.putString("valU5_1GP", valU5_1GP.getText().toString());
                            }

                            /*if (ver5GP.getSelectedItem().toString().matches("")) {
                                editor.putString("ver5GP", "");
                            } else {
                                editor.putString("ver5GP", ver5GP.getSelectedItem().toString());
                            }*/

                            if (fuentePs1GP.getText().toString().matches("")) {
                                editor.putString("fuentePs1GP", "");
                            } else {
                                editor.putString("fuentePs1GP", fuentePs1GP.getText().toString());
                            }
                            if (fuentePs2GP.getText().toString().matches("")) {
                                editor.putString("fuentePs2GP", "");
                            } else {
                                editor.putString("fuentePs2GP", fuentePs2GP.getText().toString());
                            }
                            if (fuentePs3GP.getText().toString().matches("")) {
                                editor.putString("fuentePs3GP", "");
                            } else {
                                editor.putString("fuentePs3GP", fuentePs3GP.getText().toString());
                            }
                            if (fuentePs4GP.getText().toString().matches("")) {
                                editor.putString("fuentePs4GP", "");
                            } else {
                                editor.putString("fuentePs4GP", fuentePs4GP.getText().toString());
                            }
                            if (fuentePs5GP.getText().toString().matches("")) {
                                editor.putString("fuentePs5GP", "");
                            } else {
                                editor.putString("fuentePs5GP", fuentePs5GP.getText().toString());
                            }
                            if (fuentePs5_1GP.getText().toString().matches("")) {
                                editor.putString("fuentePs5_1GP", "");
                            } else {
                                editor.putString("fuentePs5_1GP", fuentePs5_1GP.getText().toString());
                            }

                            if (fuenteHogar1GP.getText().toString().matches("")) {
                                editor.putString("fuenteHogar1GP", "");
                            } else {
                                editor.putString("fuenteHogar1GP", fuenteHogar1GP.getText().toString());
                            }
                            if (fuenteHogar2GP.getText().toString().matches("")) {
                                editor.putString("fuenteHogar2GP", "");
                            } else {
                                editor.putString("fuenteHogar2GP", fuenteHogar2GP.getText().toString());
                            }
                            if (fuenteHogar3GP.getText().toString().matches("")) {
                                editor.putString("fuenteHogar3GP", "");
                            } else {
                                editor.putString("fuenteHogar3GP", fuenteHogar3GP.getText().toString());
                            }
                            if (fuenteHogar4GP.getText().toString().matches("")) {
                                editor.putString("fuenteHogar4GP", "");
                            } else {
                                editor.putString("fuenteHogar4GP", fuenteHogar4GP.getText().toString());
                            }
                            if (fuenteHogar5GP.getText().toString().matches("")) {
                                editor.putString("fuenteHogar5GP", "");
                            } else {
                                editor.putString("fuenteHogar5GP", fuenteHogar5GP.getText().toString());
                            }
                            if (fuenteHogar5_1GP.getText().toString().matches("")) {
                                editor.putString("fuenteHogar5_1GP", "");
                            } else {
                                editor.putString("fuenteHogar5_1GP", fuenteHogar5_1GP.getText().toString());
                            }

                            if (totalGP.getText().toString().matches("")) {
                                editor.putString("totalGP", "");
                            } else {
                                editor.putString("totalGP", totalGP.getText().toString());
                            }
                            if (total_psGP.getText().toString().matches("")) {
                                editor.putString("total_psGP", "");
                            } else {
                                editor.putString("total_psGP", total_psGP.getText().toString());
                            }
                            if (total_hogarGP.getText().toString().matches("")) {
                                editor.putString("total_hogarGP", "");
                            } else {
                                editor.putString("total_hogarGP", total_hogarGP.getText().toString());
                            }
//if(total_verifGP.getText().toString().matches("")) {editor.putString("total_verifGP","");}else{editor.putString("total_verifGP",total_verifGP.getText().toString());}
                            editor.commit();
                            editorRD.putInt("con1GP", con1GP.getSelectedItemPosition());     //14 marzo
                            editorRD.putInt("con2GP", con2GP.getSelectedItemPosition());
                            editorRD.putInt("con3GP", con3GP.getSelectedItemPosition());
                            editorRD.putInt("con4GP", con4GP.getSelectedItemPosition());
                            if (con5GP.getText().toString().matches("")) {
                                editorRD.putString("con5GP", "");
                            } else {
                                editorRD.putString("con5GP", con5GP.getText().toString());
                            }
                            if (con5_1GP.getText().toString().matches("")) {
                                editorRD.putString("con5_1GP", "");
                            } else {
                                editorRD.putString("con5_1GP", con5_1GP.getText().toString());
                            }
                            if (cant1GP.getText().toString().matches("")) {
                                editorRD.putString("cant1GP", "");
                            } else {
                                editorRD.putString("cant1GP", cant1GP.getText().toString());
                            }
                            if (cant2GP.getText().toString().matches("")) {
                                editorRD.putString("cant2GP", "");
                            } else {
                                editorRD.putString("cant2GP", cant2GP.getText().toString());
                            }
                            if (cant3GP.getText().toString().matches("")) {
                                editorRD.putString("cant3GP", "");
                            } else {
                                editorRD.putString("cant3GP", cant3GP.getText().toString());
                            }
                            if (cant4GP.getText().toString().matches("")) {
                                editorRD.putString("cant4GP", "");
                            } else {
                                editorRD.putString("cant4GP", cant4GP.getText().toString());
                            }
                            if (cant5GP.getText().toString().matches("")) {
                                editorRD.putString("cant5GP", "");
                            } else {
                                editorRD.putString("cant5GP", cant5GP.getText().toString());
                            }
                            if (cant5_1GP.getText().toString().matches("")) {
                                editorRD.putString("cant5_1GP", "");
                            } else {
                                editorRD.putString("cant5_1GP", cant5_1GP.getText().toString());
                            }
/*
if(undM1GP.getText().toString().matches("")) {editorRD.putString("undM1GP","");}else{editorRD.putString("undM1GP",undM1GP.getText().toString());}
if(undM2GP.getText().toString().matches("")) {editorRD.putString("undM2GP","");}else{editorRD.putString("undM2GP",undM2GP.getText().toString());}
if(undM3GP.getText().toString().matches("")) {editorRD.putString("undM3GP","");}else{editorRD.putString("undM3GP",undM3GP.getText().toString());}
if(undM4GP.getText().toString().matches("")) {editorRD.putString("undM4GP","");}else{editorRD.putString("undM4GP",undM4GP.getText().toString());}
*/
                            if (valU1GP.getText().toString().matches("")) {
                                editorRD.putString("valU1GP", "");
                            } else {
                                editorRD.putString("valU1GP", valU1GP.getText().toString());
                            }
                            if (valU2GP.getText().toString().matches("")) {
                                editorRD.putString("valU2GP", "");
                            } else {
                                editorRD.putString("valU2GP", valU2GP.getText().toString());
                            }
                            if (valU3GP.getText().toString().matches("")) {
                                editorRD.putString("valU3GP", "");
                            } else {
                                editorRD.putString("valU3GP", valU3GP.getText().toString());
                            }
                            if (valU4GP.getText().toString().matches("")) {
                                editorRD.putString("valU4GP", "");
                            } else {
                                editorRD.putString("valU4GP", valU4GP.getText().toString());
                            }
                            if (valU5GP.getText().toString().matches("")) {
                                editorRD.putString("valU5GP", "");
                            } else {
                                editorRD.putString("valU5GP", valU5GP.getText().toString());
                            }
                            if (valU5_1GP.getText().toString().matches("")) {
                                editorRD.putString("valU5_1GP", "");
                            } else {
                                editorRD.putString("valU5_1GP", valU5_1GP.getText().toString());
                            }

                            /*if (ver5GP.getSelectedItem().toString().matches("")) {
                                editorRD.putString("ver5GP", "");
                            } else {
                                editorRD.putString("ver5GP", ver5GP.getSelectedItem().toString());
                            }*/
                            if (fuentePs1GP.getText().toString().matches("")) {
                                editorRD.putString("fuentePs1GP", "");
                            } else {
                                editorRD.putString("fuentePs1GP", fuentePs1GP.getText().toString());
                            }
                            if (fuentePs2GP.getText().toString().matches("")) {
                                editorRD.putString("fuentePs2GP", "");
                            } else {
                                editorRD.putString("fuentePs2GP", fuentePs2GP.getText().toString());
                            }
                            if (fuentePs3GP.getText().toString().matches("")) {
                                editorRD.putString("fuentePs3GP", "");
                            } else {
                                editorRD.putString("fuentePs3GP", fuentePs3GP.getText().toString());
                            }
                            if (fuentePs4GP.getText().toString().matches("")) {
                                editorRD.putString("fuentePs4GP", "");
                            } else {
                                editorRD.putString("fuentePs4GP", fuentePs4GP.getText().toString());
                            }
                            if (fuentePs5GP.getText().toString().matches("")) {
                                editorRD.putString("fuentePs5GP", "");
                            } else {
                                editorRD.putString("fuentePs5GP", fuentePs5GP.getText().toString());
                            }
                            if (fuentePs5_1GP.getText().toString().matches("")) {
                                editorRD.putString("fuentePs5_1GP", "");
                            } else {
                                editorRD.putString("fuentePs5_1GP", fuentePs5_1GP.getText().toString());
                            }

                            if (fuenteHogar1GP.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar1GP", "");
                            } else {
                                editorRD.putString("fuenteHogar1GP", fuenteHogar1GP.getText().toString());
                            }
                            if (fuenteHogar2GP.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar2GP", "");
                            } else {
                                editorRD.putString("fuenteHogar2GP", fuenteHogar2GP.getText().toString());
                            }
                            if (fuenteHogar3GP.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar3GP", "");
                            } else {
                                editorRD.putString("fuenteHogar3GP", fuenteHogar3GP.getText().toString());
                            }
                            if (fuenteHogar4GP.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar4GP", "");
                            } else {
                                editorRD.putString("fuenteHogar4GP", fuenteHogar4GP.getText().toString());
                            }
                            if (fuenteHogar5GP.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar5GP", "");
                            } else {
                                editorRD.putString("fuenteHogar5GP", fuenteHogar5GP.getText().toString());
                            }
                            if (fuenteHogar5_1GP.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar5_1GP", "");
                            } else {
                                editorRD.putString("fuenteHogar5_1GP", fuenteHogar5_1GP.getText().toString());
                            }

                            if (totalGP.getText().toString().matches("")) {
                                editorRD.putString("totalGP", "");
                            } else {
                                editorRD.putString("totalGP", totalGP.getText().toString());
                            }
                            if (total_psGP.getText().toString().matches("")) {
                                editorRD.putString("total_psGP", "");
                            } else {
                                editorRD.putString("total_psGP", total_psGP.getText().toString());
                            }
                            if (total_hogarGP.getText().toString().matches("")) {
                                editorRD.putString("total_hogarGP", "");
                            } else {
                                editorRD.putString("total_hogarGP", total_hogarGP.getText().toString());
                            }
//if(total_verifGP.getText().toString().matches("")) {editorRD.putString("total_verifGP","");}else{editorRD.putString("total_verifGP",total_verifGP.getText().toString());}
                            editorRD.commit();
                            if (sharedPreferences.getString("undM1GP", "").equals("U.medida..........") && !sharedPreferences.getString("con1GP", "").equals("SELECCIONE.......")) {
                                editor.putString("undM1GP", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM2GP", "").equals("U.medida..........") && !sharedPreferences.getString("con2GP", "").equals("SELECCIONE.......")) {
                                editor.putString("undM2GP", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM3GP", "").equals("U.medida..........") && !sharedPreferences.getString("con3GP", "").equals("SELECCIONE.......")) {
                                editor.putString("undM3GP", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM4GP", "").equals("U.medida..........") && !sharedPreferences.getString("con4GP", "").equals("SELECCIONE.......")) {
                                editor.putString("undM4GP", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM5GP", "").equals("U.medida..........") && !sharedPreferences.getString("con5GP", "").equals("")) {
                                editor.putString("undM5GP", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM5_1GP", "").equals("U.medida..........") && !sharedPreferences.getString("con5_1GP", "").equals("")) {
                                editor.putString("undM5_1GP", "Unidad");
                                editor.commit();
                            }

                            Intent intent = new Intent(GastosPreo.this, Inversion.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            Toast.makeText(GastosPreo.this, "Datos Guardados!", Toast.LENGTH_LONG).show();
                            startActivity(intent);

                        }

                    }
                    break;

                }
                return true;

            }
        });
        loadData();
    }

    public void loadData() {


        //       if(!(sharedPreferencesRD.getString("tipoP","").isEmpty() && sharedPreferencesRD.getString("tituloP","").isEmpty() && sharedPreferencesRD.getString("prodPrinc","").isEmpty()&& sharedPreferencesRD.getString("codAct","").isEmpty()&& sharedPreferencesRD.getString("descrAct","").isEmpty()&& sharedPreferencesRD.getString("descrPP","").isEmpty()&& sharedPreferencesRD.getString("oportunidades","").isEmpty())) {
        int tipop = sharedPreferencesRD.getInt("con1GP", 0);    //14 marzo
        con1GP.setSelection(tipop);                                         //14 marzo
        int tipop2 = sharedPreferencesRD.getInt("con2GP", 0);
        con2GP.setSelection(tipop2);
        int tipop3 = sharedPreferencesRD.getInt("con3GP", 0);    //14 marzo
        con3GP.setSelection(tipop3);
        int tipop4 = sharedPreferencesRD.getInt("con4GP", 0);
        con4GP.setSelection(tipop4);
        con5GP.setText(sharedPreferencesRD.getString("con5GP", ""));
        con5_1GP.setText(sharedPreferencesRD.getString("con5_1GP", ""));

        String tipop5 = sharedPreferencesRD.getString("cant1GP", "");
        cant1GP.setText(tipop5);
        String tipop6 = sharedPreferencesRD.getString("cant2GP", "");
        cant2GP.setText(tipop6);
        String tipop7 = sharedPreferencesRD.getString("cant3GP", "");
        cant3GP.setText(tipop7);
        String tipop8 = sharedPreferencesRD.getString("cant4GP", "");
        cant4GP.setText(tipop8);
        cant5GP.setText(sharedPreferencesRD.getString("cant5GP", ""));
        cant5_1GP.setText(sharedPreferencesRD.getString("cant5_1GP", ""));

        int tipop9 = sharedPreferencesRD.getInt("undM1GP", 0);
        undM1GP.setSelection(tipop9);
        int tipop10 = sharedPreferencesRD.getInt("undM2GP", 0);
        undM2GP.setSelection(tipop10);
        int tipop11 = sharedPreferencesRD.getInt("undM3GP", 0);
        undM3GP.setSelection(tipop11);
        int tipop12 = sharedPreferencesRD.getInt("undM4GP", 0);
        undM4GP.setSelection(tipop12);
        int tipop12_1 = sharedPreferencesRD.getInt("undM5GP", 0);
        undM5GP.setSelection(tipop12_1);
        undM5_1GP.setSelection(sharedPreferencesRD.getInt("undM5_1GP", 0));

        String tipop13 = sharedPreferencesRD.getString("valU1GP", "");
        valU1GP.setText(tipop13);
        String tipop14 = sharedPreferencesRD.getString("valU2GP", "");
        valU2GP.setText(tipop14);
        String tipop15 = sharedPreferencesRD.getString("valU3GP", "");
        valU3GP.setText(tipop15);
        String tipop16 = sharedPreferencesRD.getString("valU4GP", "");
        valU4GP.setText(tipop16);
        String tipop17 = sharedPreferencesRD.getString("valU5GP", "");
        valU5GP.setText(tipop17);
        valU5_1GP.setText(sharedPreferencesRD.getString("valU5_1GP", ""));

        if (sharedPreferencesRD.getString("ver1GP", "").equals("Cumple")) {
            ver1GP.setSelection(0);
        } else {
            ver1GP.setSelection(1);
        }
        String tipop18 = sharedPreferencesRD.getString("ver2GP", "");
        if (tipop18.equals("Cumple")) {
            ver2GP.setSelection(0);
        } else {
            ver2GP.setSelection(1);
        }
        String tipop19 = sharedPreferencesRD.getString("ver3GP", "");
        if (tipop19.equals("Cumple")) {
            ver3GP.setSelection(0);
        } else {
            ver3GP.setSelection(1);
        }
        String tipop20 = sharedPreferencesRD.getString("ver4GP", "");
        if (tipop20.equals("Cumple")) {
            ver4GP.setSelection(0);
        } else {
            ver4GP.setSelection(1);
        }
        String tipop20_1 = sharedPreferencesRD.getString("ver5GP", "");
        if (tipop20_1.equals("Cumple")) {
            ver5GP.setSelection(0);
        } else {
            ver5GP.setSelection(1);
        }
        String tipop20_2 = sharedPreferencesRD.getString("ver5_1GP", "");
        if (tipop20_2.equals("Cumple")) {
            ver5_1GP.setSelection(0);
        } else {
            ver5_1GP.setSelection(1);
        }

        String tipop21 = sharedPreferencesRD.getString("valT1GP", "");
        valT1GP.setText(tipop21);
        String tipop22 = sharedPreferencesRD.getString("valT2GP", "");
        valT2GP.setText(tipop22);
        String tipop23 = sharedPreferencesRD.getString("valT3GP", "");
        valT3GP.setText(tipop23);
        String tipop24 = sharedPreferencesRD.getString("valT4GP", "");
        valT4GP.setText(tipop24);
        String tipop25 = sharedPreferencesRD.getString("valT5GP", "");
        valT5GP.setText(tipop25);
        valT5_1GP.setText(sharedPreferencesRD.getString("valT5_1GP", ""));

        String titulop26 = sharedPreferencesRD.getString("fuentePs1GP", "");
        fuentePs1GP.setText(titulop26);
        String titulop27 = sharedPreferencesRD.getString("fuentePs2GP", "");
        fuentePs2GP.setText(titulop27);
        String titulop28 = sharedPreferencesRD.getString("fuentePs3GP", "");
        fuentePs3GP.setText(titulop28);
        String titulop29 = sharedPreferencesRD.getString("fuentePs4GP", "");
        fuentePs4GP.setText(titulop29);
        fuentePs5GP.setText(sharedPreferencesRD.getString("fuentePs5GP", ""));
        fuentePs5_1GP.setText(sharedPreferencesRD.getString("fuentePs5_1GP", ""));
        String titulop30 = sharedPreferencesRD.getString("fuenteHogar1GP", "");
        fuenteHogar1GP.setText(titulop30);
        String titulop31 = sharedPreferencesRD.getString("fuenteHogar2GP", "");
        fuenteHogar2GP.setText(titulop31);
        String titulop32 = sharedPreferencesRD.getString("fuenteHogar3GP", "");
        fuenteHogar3GP.setText(titulop32);
        String titulop33 = sharedPreferencesRD.getString("fuenteHogar4GP", "");
        fuenteHogar4GP.setText(titulop33);
        fuenteHogar5GP.setText(sharedPreferencesRD.getString("fuenteHogar5GP", ""));
        fuenteHogar5_1GP.setText(sharedPreferencesRD.getString("fuenteHogar5_1GP", ""));
        String titulop34 = sharedPreferencesRD.getString("totalGP", "");
        totalGP.setText(titulop34);
        String titulop35 = sharedPreferencesRD.getString("total_psGP", "");
        total_psGP.setText(titulop35);
        String titulop36 = sharedPreferencesRD.getString("total_hogarGP", "");
        total_hogarGP.setText(titulop36);


    }


    public void ir(View view) {
        totalGP.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(totalGP, InputMethodManager.SHOW_IMPLICIT);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        //accordionViewOne.setExpanded(Boolean.TRUE);
    }

    public void calcular(View view) {
        switch (view.getId()) {
            case R.id.C1:
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant1GP.getText().toString().matches("")) {
                } else {

                    if (!valU1GP.getText().toString().matches("")) {
                        valT1GP.setText(String.valueOf(Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString())));
                        try {
                            GT = Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString()) + 0 + 0 + 0;
                            GT_PS = Integer.parseInt(fuentePs1GP.getText().toString());
                            GT_HOG = Integer.parseInt(fuenteHogar1GP.getText().toString());
                        } catch (Exception e) {
                        }
                        totalGP.setText(String.valueOf(GT));
                        total_psGP.setText(String.valueOf(GT_PS));
                        total_hogarGP.setText(String.valueOf(GT_HOG));
                        editor.putString("valT1GP", valT1GP.getText().toString());
                        editorRD.putString("valT1GP", valT1GP.getText().toString());
                    } else {
                        editor.putString("valT1GP", "");
                        editorRD.putString("valT1GP", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(AGPFijos.this, sharedPreferencesRD.getString("valT1GP", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C2:
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (!cant2GP.getText().toString().matches("") && !cant1GP.getText().toString().matches("") && !valU2GP.getText().toString().matches("") && !valU1GP.getText().toString().matches("")) {
                    valT2GP.setText(String.valueOf(Integer.parseInt(cant2GP.getText().toString()) * Integer.parseInt(valU2GP.getText().toString())));
                    try {
                        GT = Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString()) + Integer.parseInt(cant2GP.getText().toString()) * Integer.parseInt(valU2GP.getText().toString()) + 0 + 0;
                        GT_PS = Integer.parseInt(fuentePs1GP.getText().toString()) + Integer.parseInt(fuentePs2GP.getText().toString());
                        GT_HOG = Integer.parseInt(fuenteHogar1GP.getText().toString()) + Integer.parseInt(fuenteHogar2GP.getText().toString());
                    } catch (Exception e) {
                    }
                    totalGP.setText(String.valueOf(GT));
                    total_psGP.setText(String.valueOf(GT_PS));
                    total_hogarGP.setText(String.valueOf(GT_HOG));
                    editor.putString("valT2GP", valT2GP.getText().toString());
                    editorRD.putString("valT2GP", valT2GP.getText().toString());
                } else {
                    Toast.makeText(this, "Complete todo los datos de arriba.", Toast.LENGTH_SHORT).show();
                    editor.putString("valT2GP", "");
                    editorRD.putString("valT2GP", "");
                }
                editor.commit();
                editorRD.commit();
                //        Toast.makeText(AGPFijos.this, sharedPreferencesRD.getString("valT1GP", ""), Toast.LENGTH_LONG).show();

                break;
            case R.id.C3:
                Toast.makeText(this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant3GP.getText().toString().matches("")) {
                } else {

                    if (!valU3GP.getText().toString().matches("")) {
                        valT3GP.setText(String.valueOf(Integer.parseInt(cant3GP.getText().toString()) * Integer.parseInt(valU3GP.getText().toString())));
                        editor.putString("valT3GP", valT3GP.getText().toString());
                        editorRD.putString("valT3GP", valT3GP.getText().toString());
                        if (!valU2GP.getText().toString().matches("") && !cant2GP.getText().toString().matches("")) {
                            try {
                                GT = Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString()) + Integer.parseInt(cant2GP.getText().toString()) * Integer.parseInt(valU2GP.getText().toString()) + Integer.parseInt(cant3GP.getText().toString()) * Integer.parseInt(valU3GP.getText().toString()) + 0;
                                GT_PS = Integer.parseInt(fuentePs1GP.getText().toString()) + Integer.parseInt(fuentePs2GP.getText().toString()) + Integer.parseInt(fuentePs3GP.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1GP.getText().toString()) + Integer.parseInt(fuenteHogar2GP.getText().toString()) + Integer.parseInt(fuenteHogar3GP.getText().toString());
                            } catch (Exception e) {
                            }
                            totalGP.setText(String.valueOf(GT));
                            total_psGP.setText(String.valueOf(GT_PS));
                            total_hogarGP.setText(String.valueOf(GT_HOG));
                        }
                    } else {
                        editor.putString("valT3GP", "");
                        editorRD.putString("valT3GP", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(AGPFijos.this, sharedPreferencesRD.getString("valT1GP", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C4:
                Toast.makeText(this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant4GP.getText().toString().matches("")) {
                } else {

                    if (!valU4GP.getText().toString().matches("")) {
                        valT4GP.setText(String.valueOf(Integer.parseInt(cant4GP.getText().toString()) * Integer.parseInt(valU4GP.getText().toString())));

                        editor.putString("valT4GP", valT4GP.getText().toString());
                        editorRD.putString("valT4GP", valT4GP.getText().toString());
                        if (!valU2GP.getText().toString().matches("") && !valU3GP.getText().toString().matches("") && !cant2GP.getText().toString().matches("") && !cant3GP.getText().toString().matches("")) {

                            try {
                                GT = Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString()) + Integer.parseInt(cant2GP.getText().toString()) * Integer.parseInt(valU2GP.getText().toString()) + Integer.parseInt(cant3GP.getText().toString()) * Integer.parseInt(valU3GP.getText().toString()) + Integer.parseInt(cant4GP.getText().toString()) * Integer.parseInt(valU4GP.getText().toString());
                                GT_PS = Integer.parseInt(fuentePs1GP.getText().toString()) + Integer.parseInt(fuentePs2GP.getText().toString()) + Integer.parseInt(fuentePs3GP.getText().toString()) + Integer.parseInt(fuentePs4GP.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1GP.getText().toString()) + Integer.parseInt(fuenteHogar2GP.getText().toString()) + Integer.parseInt(fuenteHogar3GP.getText().toString()) + Integer.parseInt(fuenteHogar4GP.getText().toString());
                            } catch (Exception e) {
                            }
                            totalGP.setText(String.valueOf(GT));
                            total_psGP.setText(String.valueOf(GT_PS));
                            total_hogarGP.setText(String.valueOf(GT_HOG));

                        }
                    } else {
                        editor.putString("valT4GP", "");
                        editorRD.putString("valT4GP", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C5:

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver5GP", ver5GP.getSelectedItem().toString());
                if (cant5GP.getText().toString().matches("") || valU5GP.getText().toString().matches("")) {
                    Toast.makeText(GastosPreo.this, "Revise que este todo completo", Toast.LENGTH_LONG).show();
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0;
                    if (!valU5GP.getText().toString().matches("")) {
                        valT5GP.setText(String.valueOf(Integer.parseInt(cant5GP.getText().toString()) * Integer.parseInt(valU5GP.getText().toString())));

                        editor.putString("valT5GP", valT5GP.getText().toString());
                        editorRD.putString("valT5GP", valT5GP.getText().toString());

                        if (valU1GP.getText().toString().matches("") && cant1GP.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString());
                        }
                        if (valU2GP.getText().toString().matches("") && cant2GP.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2GP.getText().toString()) * Integer.parseInt(valU2GP.getText().toString());
                        }
                        if (valU3GP.getText().toString().matches("") && cant3GP.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3GP.getText().toString()) * Integer.parseInt(valU3GP.getText().toString());
                        }
                        if (valU4GP.getText().toString().matches("") && cant4GP.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4GP.getText().toString()) * Integer.parseInt(valU4GP.getText().toString());
                        }

                        if (fuentePs1GP.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1GP.getText().toString());
                        }
                        if (fuentePs2GP.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2GP.getText().toString());
                        }
                        if (fuentePs3GP.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3GP.getText().toString());
                        }
                        if (fuentePs4GP.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4GP.getText().toString());
                        }

                        if (fuenteHogar1GP.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1GP.getText().toString());
                        }
                        if (fuenteHogar2GP.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2GP.getText().toString());
                        }
                        if (fuenteHogar3GP.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3GP.getText().toString());
                        }
                        if (fuenteHogar4GP.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4GP.getText().toString());
                        }

                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + Integer.parseInt(cant5GP.getText().toString()) * Integer.parseInt(valU5GP.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + Integer.parseInt(fuentePs5GP.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + Integer.parseInt(fuenteHogar5GP.getText().toString());
                        } catch (Exception e) {
                        }
                        totalGP.setText(String.valueOf(GT));
                        total_psGP.setText(String.valueOf(GT_PS));
                        total_hogarGP.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5GP", "");
                        editorRD.putString("valT5GP", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C5_1:

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();

                if (cant5_1GP.getText().toString().matches("") || valU5_1GP.getText().toString().matches("")) {
                    Toast.makeText(GastosPreo.this, "Revise que este todo completo", Toast.LENGTH_LONG).show();
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorT5 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorPS5 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0, valorHogar5 = 0;
                    if (!valU5_1GP.getText().toString().matches("")) {
                        valT5_1GP.setText(String.valueOf(Integer.parseInt(cant5_1GP.getText().toString()) * Integer.parseInt(valU5_1GP.getText().toString())));

                        editor.putString("valT5_1GP", valT5_1GP.getText().toString());
                        editorRD.putString("valT5_1GP", valT5_1GP.getText().toString());

                        if (valU1GP.getText().toString().matches("") && cant1GP.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1GP.getText().toString()) * Integer.parseInt(valU1GP.getText().toString());
                        }
                        if (valU2GP.getText().toString().matches("") && cant2GP.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2GP.getText().toString()) * Integer.parseInt(valU2GP.getText().toString());
                        }
                        if (valU3GP.getText().toString().matches("") && cant3GP.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3GP.getText().toString()) * Integer.parseInt(valU3GP.getText().toString());
                        }
                        if (valU4GP.getText().toString().matches("") && cant4GP.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4GP.getText().toString()) * Integer.parseInt(valU4GP.getText().toString());
                        }
                        if (valU5GP.getText().toString().matches("") && cant5GP.getText().toString().matches("")) {
                            valorT5 = 0;
                        } else {
                            valorT5 = Integer.parseInt(cant5GP.getText().toString()) * Integer.parseInt(valU5GP.getText().toString());
                        }

                        if (fuentePs1GP.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1GP.getText().toString());
                        }
                        if (fuentePs2GP.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2GP.getText().toString());
                        }
                        if (fuentePs3GP.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3GP.getText().toString());
                        }
                        if (fuentePs4GP.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4GP.getText().toString());
                        }
                        if (fuentePs5GP.getText().toString().matches("")) {
                            valorPS5 = 0;
                        } else {
                            valorPS5 = Integer.parseInt(fuentePs5GP.getText().toString());
                        }

                        if (fuenteHogar1GP.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1GP.getText().toString());
                        }
                        if (fuenteHogar2GP.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2GP.getText().toString());
                        }
                        if (fuenteHogar3GP.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3GP.getText().toString());
                        }
                        if (fuenteHogar4GP.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4GP.getText().toString());
                        }
                        if (fuenteHogar5GP.getText().toString().matches("")) {
                            valorHogar5 = 0;
                        } else {
                            valorHogar5 = Integer.parseInt(fuenteHogar5GP.getText().toString());
                        }


                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + valorT5 + Integer.parseInt(cant5_1GP.getText().toString()) * Integer.parseInt(valU5_1GP.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + valorPS5 + Integer.parseInt(fuentePs5_1GP.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + valorHogar5 + Integer.parseInt(fuenteHogar5_1GP.getText().toString());
                        } catch (Exception e) {
                        }
                        totalGP.setText(String.valueOf(GT));
                        total_psGP.setText(String.valueOf(GT_PS));
                        total_hogarGP.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5_1GP", "");
                        editorRD.putString("valT5_1GP", "");
                    }
                    editor.putString("ver5_1GP", ver5_1GP.getSelectedItem().toString());
                    editorRD.putString("ver5_1GP", ver5_1GP.getSelectedItem().toString());
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
                break;
        }

    }


    public void toogle(View view) {
        expandableLayout.toggle();
    }
}
