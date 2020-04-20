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

import com.github.aakira.expandablelayout.ExpandableWeightLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SegTrabajo extends AppCompatActivity {

    EditText con5ST, con5_1ST, cant1ST, cant2ST, cant3ST, cant4ST, cant5ST, cant5_1ST, valU1ST, valU2ST, valU3ST, valU4ST, valU5ST, valU5_1ST;
    EditText valT1ST, valT2ST, valT3ST, valT4ST, valT5ST, valT5_1ST, fuentePs1ST, fuentePs2ST, fuentePs3ST, fuentePs4ST, fuentePs5ST, fuentePs5_1ST, fuenteHogar1ST, fuenteHogar2ST, fuenteHogar3ST, fuenteHogar4ST, fuenteHogar5ST, fuenteHogar5_1ST;
    EditText totalST, total_psST, total_hogarST;//total_verifST;
    int GT, GT_PS, GT_HOG;
    String ShaPreSector;
    ArrayAdapter<String> dataAdapterS_A, dataAdapterS_A_peces, dataAdapterS_A_cerdos, dataAdapterS_A_bovino, dataAdapterS_A_aves_corral, dataAdapterS_C_restaurante, dataAdapterS_G_comercio, dataAdapterS_G_papeleria, dataAdapterS_G_ropa, dataAdapterS_S_peluqueria, dataAdapterOtros;
    Spinner con1ST, con2ST, con3ST, con4ST;
    TextView VSug1, VSug2, VSug3, VSug4;
    HashMap<String, String> hm = new HashMap<String, String>();
    AppCompatSpinner ver1ST, ver2ST, ver3ST, ver4ST, ver5ST, ver5_1ST, undM1ST, undM2ST, undM3ST, undM4ST, undM5ST, undM5_1ST;
    BottomNavigationView btnNV;
    Button ItemAdicional;
    ExpandableWeightLayout expandableLayout;
    private SharedPreferences sharedPreferences, sharedPreferencesRD, dataEncuenta;
    SharedPreferences.Editor editor, editorRD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seg_trabajo);
        ItemAdicional = findViewById(R.id.expandButton);
        ItemAdicional.setText("Tiene un insumo adicional? " + Character.toString((char) 9660) + " ");
        expandableLayout
                = (ExpandableWeightLayout) findViewById(R.id.expandableLayout);
        btnNV = findViewById(R.id.navigationView);
        con1ST = findViewById(R.id.CON1ST);
        con2ST = findViewById(R.id.CON2ST);
        con3ST = findViewById(R.id.CON3ST);
        con4ST = findViewById(R.id.CON4ST);
        con5ST = findViewById(R.id.CON5ST);
        con5_1ST = findViewById(R.id.CON5_1ST);
        cant1ST = findViewById(R.id.CAN1ST);
        cant2ST = findViewById(R.id.CAN2ST);
        cant3ST = findViewById(R.id.CAN3ST);
        cant4ST = findViewById(R.id.CAN4ST);
        cant5ST = findViewById(R.id.CAN5ST);
        cant5_1ST = findViewById(R.id.CAN5_1ST);
        undM1ST = findViewById(R.id.UM1ST);
        undM2ST = findViewById(R.id.UM2ST);
        undM3ST = findViewById(R.id.UM3ST);
        undM4ST = findViewById(R.id.UM4ST);
        undM5ST = findViewById(R.id.UM5ST);
        undM5_1ST = findViewById(R.id.UM5_1ST);
        valU1ST = findViewById(R.id.VU1ST);
        valU2ST = findViewById(R.id.VU2ST);
        valU3ST = findViewById(R.id.VU3ST);
        valU4ST = findViewById(R.id.VU4ST);
        valU5ST = findViewById(R.id.VU5ST);
        valU5_1ST = findViewById(R.id.VU5_1ST);
        ver1ST = findViewById(R.id.VERF1ST);
        ver2ST = findViewById(R.id.VERF2ST);
        ver3ST = findViewById(R.id.VERF3ST);
        ver4ST = findViewById(R.id.VERF4ST);
        ver5ST = findViewById(R.id.VERF5ST);
        ver5_1ST = findViewById(R.id.VERF5_1ST);
        valT1ST = findViewById(R.id.VT1ST);
        valT2ST = findViewById(R.id.VT2ST);
        valT3ST = findViewById(R.id.VT3ST);
        valT4ST = findViewById(R.id.VT4ST);
        valT5ST = findViewById(R.id.VT5ST);
        valT5_1ST = findViewById(R.id.VT5_1ST);
        fuentePs1ST = findViewById(R.id.PS1ST);
        fuentePs2ST = findViewById(R.id.PS2ST);
        fuentePs3ST = findViewById(R.id.PS3ST);
        fuentePs4ST = findViewById(R.id.PS4ST);
        fuentePs5ST = findViewById(R.id.PS5ST);
        fuentePs5_1ST = findViewById(R.id.PS5_1ST);
        fuenteHogar1ST = findViewById(R.id.HO1ST);
        fuenteHogar2ST = findViewById(R.id.HO2ST);
        fuenteHogar3ST = findViewById(R.id.HO3ST);
        fuenteHogar4ST = findViewById(R.id.HO4ST);
        fuenteHogar5ST = findViewById(R.id.HO5ST);
        fuenteHogar5_1ST = findViewById(R.id.HO5_1ST);
        VSug1 = findViewById(R.id.VSug1ST);
        VSug2 = findViewById(R.id.VSug2ST);
        VSug3 = findViewById(R.id.VSug3ST);
        VSug4 = findViewById(R.id.VSug4ST);
        totalST = findViewById(R.id.TOTAL_ST);
        total_psST = findViewById(R.id.TOTAL_PS_ST);
        total_hogarST = findViewById(R.id.TOTAL_HOGAR_ST);//total_verifST=findViewById(R.id.TOTAL_VERIFICACION_ST);
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
        ArrayAdapter<CharSequence> adapterUM = ArrayAdapter.createFromResource(this, R.array.und_medida, R.layout.textview);
        undM1ST.setAdapter(adapterUM);
        undM2ST.setAdapter(adapterUM);
        undM3ST.setAdapter(adapterUM);
        undM4ST.setAdapter(adapterUM);

        ShaPreSector = sharedPreferences.getString("codSector", "");
        //      Toast.makeText(this, ""+sharedPreferences.getString("codSector",""), Toast.LENGTH_SHORT).show();
        List<String> list_Sec_A = new ArrayList<String>();
        list_Sec_A.add("Seleccione......");
        list_Sec_A.add("OVEROL");
        list_Sec_A.add("DELANTAL");
        list_Sec_A.add("BOTAS");
        list_Sec_A.add("GUANTES");
        list_Sec_A.add("PROTECTOR SOLAR");
        list_Sec_A.add("CARETA");
        List<String> list_Sec_A_peces = new ArrayList<String>();
        list_Sec_A_peces.add("Seleccione......");
        list_Sec_A_peces.add("SALVAVIDAS");
        list_Sec_A_peces.add("FLOTADORES");
        list_Sec_A_peces.add("GUANTES");
        list_Sec_A_peces.add("LINTERNAS");
        list_Sec_A_peces.add("BOTIQUIN");
        List<String> list_Sec_A_cerdos = new ArrayList<String>();
        list_Sec_A_cerdos.add("Seleccione......");
        list_Sec_A_cerdos.add("OVEROL");
        list_Sec_A_cerdos.add("DELANTAL");
        list_Sec_A_cerdos.add("TAPABOCAS");
        list_Sec_A_cerdos.add("GUANTES");
        list_Sec_A_cerdos.add("BOTIQUIN");
        list_Sec_A_cerdos.add("CARETA");
        list_Sec_A_cerdos.add("DESINFECTANTES");
        List<String> list_Sec_A_bovino = new ArrayList<String>();
        list_Sec_A_bovino.add("Seleccione......");
        list_Sec_A_bovino.add("CARETA");
        list_Sec_A_bovino.add("TAPABOCAS");
        list_Sec_A_bovino.add("GUANTES");
        list_Sec_A_bovino.add("BOTAS PUNTA DE ACERO");
        list_Sec_A_bovino.add("BLOQUEADOR SOLAR");
        List<String> list_Sec_A_aves_corral = new ArrayList<String>();
        list_Sec_A_aves_corral.add("Seleccione......");
        list_Sec_A_aves_corral.add("OVEROL");
        list_Sec_A_aves_corral.add("DELANTAL");
        list_Sec_A_aves_corral.add("TABOCAS");
        list_Sec_A_aves_corral.add("CARETA");
        list_Sec_A_aves_corral.add("GUANTES");
        list_Sec_A_aves_corral.add("BOTAS");
        List<String> list_Sec_C_restaurante = new ArrayList<String>();
        list_Sec_C_restaurante.add("Seleccione......");
        list_Sec_C_restaurante.add("TAPABOCAS");
        list_Sec_C_restaurante.add("GORRO");
        list_Sec_C_restaurante.add("DELANTAL");
        list_Sec_C_restaurante.add("EXTINTOR");
        list_Sec_C_restaurante.add("SEÑALIZACIÓN SALIDAS DE EMERGENCIA");
        List<String> list_Sec_G_comercio = new ArrayList<String>();
        list_Sec_G_comercio.add("Seleccione......");//FRUVER
        list_Sec_G_comercio.add("BOTIQUIN");
        list_Sec_G_comercio.add("EXTINTOR");
        list_Sec_G_comercio.add("GORRO");
        list_Sec_G_comercio.add("TAPABOCAS");
        List<String> list_Sec_G_papeleria = new ArrayList<String>();
        list_Sec_G_papeleria.add("Seleccione......");
        list_Sec_G_papeleria.add("BOTIQUIN");
        list_Sec_G_papeleria.add("EXTINTOR");
        list_Sec_G_papeleria.add("SEÑALIZACION DE EMERGENCIA");
        List<String> list_Sec_G_ropa = new ArrayList<String>();
        list_Sec_G_ropa.add("Seleccione......");
        list_Sec_G_ropa.add("EXTINTOR");
        list_Sec_G_ropa.add("BOTIQUIN");
        list_Sec_G_ropa.add("SEÑALIZACION DE EMERGENCIA");
        List<String> list_Sec_S_peluqueria = new ArrayList<String>();
        list_Sec_S_peluqueria.add("Seleccione......");
        list_Sec_S_peluqueria.add("EXTINTOR");
        list_Sec_S_peluqueria.add("BOTIQUIN");
        list_Sec_S_peluqueria.add("SEÑALIZACION DE EMERGENCIA");
        List<String> list_Otros = new ArrayList<String>();  //mio 25 marzo
        list_Otros.add("Seleccione......");
        list_Otros.add("OVEROL");
        list_Otros.add("DELANTAL");
        list_Otros.add("BOTAS");
        list_Otros.add("GUANTES");
        list_Otros.add("PROTECTOR SOLAR");
        list_Otros.add("CARETA");
        list_Otros.add("SALVAVIDAS");
        list_Otros.add("FLOTADORES");
        list_Otros.add("GUANTES");
        list_Otros.add("LINTERNAS");
        list_Otros.add("BOTIQUIN");
        list_Otros.add("TAPABOCAS");
        list_Otros.add("GUANTES");
        list_Otros.add("BOTAS PUNTA DE ACERO");
        list_Otros.add("BLOQUEADOR SOLAR");
        list_Otros.add("CARETA");
        list_Otros.add("DESINFECTANTES");
        list_Otros.add("SEÑALIZACION DE EMERGENCIA");
        list_Otros.add("GORRO");
        list_Otros.add("SEÑALIZACIÓN SALIDAS DE EMERGENCIA");
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
            con1ST.setAdapter(dataAdapterS_A_peces);
            con2ST.setAdapter(dataAdapterS_A_peces);
            con3ST.setAdapter(dataAdapterS_A_peces);
            con4ST.setAdapter(dataAdapterS_A_peces);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0144")) {
            con1ST.setAdapter(dataAdapterS_A_cerdos);
            con2ST.setAdapter(dataAdapterS_A_cerdos);
            con3ST.setAdapter(dataAdapterS_A_cerdos);
            con4ST.setAdapter(dataAdapterS_A_cerdos);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0145")) {
            con1ST.setAdapter(dataAdapterS_A_aves_corral);
            con2ST.setAdapter(dataAdapterS_A_aves_corral);
            con3ST.setAdapter(dataAdapterS_A_aves_corral);
            con4ST.setAdapter(dataAdapterS_A_aves_corral);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0141")) {
            con1ST.setAdapter(dataAdapterS_A_bovino);
            con2ST.setAdapter(dataAdapterS_A_bovino);
            con3ST.setAdapter(dataAdapterS_A_bovino);
            con4ST.setAdapter(dataAdapterS_A_bovino);
        } else if (ShaPreSector.equals("SECCION A")) {
            con1ST.setAdapter(dataAdapterS_A);
            con2ST.setAdapter(dataAdapterS_A);
            con3ST.setAdapter(dataAdapterS_A);
            con4ST.setAdapter(dataAdapterS_A);
        }

        if (ShaPreSector.equals("SECCION C")) {
            con1ST.setAdapter(dataAdapterS_C_restaurante);
            con2ST.setAdapter(dataAdapterS_C_restaurante);
            con3ST.setAdapter(dataAdapterS_C_restaurante);
            con4ST.setAdapter(dataAdapterS_C_restaurante);
        } //


        if (ShaPreSector.equals("SECCION G") && (sharedPreferences.getString("codAct", "").substring(0, 3).equals("471") || sharedPreferences.getString("codAct", "").substring(0, 3).equals("472") || sharedPreferences.getString("codAct", "").equals("4781"))) {
            con1ST.setAdapter(dataAdapterS_G_comercio);
            con2ST.setAdapter(dataAdapterS_G_comercio);
            con3ST.setAdapter(dataAdapterS_G_comercio);
            con4ST.setAdapter(dataAdapterS_G_comercio);
        } //47
        else if (ShaPreSector.equals("SECCION G") && sharedPreferences.getString("codAct", "").substring(0, 2).equals("46")) {
            con1ST.setAdapter(dataAdapterS_G_ropa);
            con2ST.setAdapter(dataAdapterS_G_ropa);
            con3ST.setAdapter(dataAdapterS_G_ropa);
            con4ST.setAdapter(dataAdapterS_G_ropa);
        } else if (ShaPreSector.equals("SECCION G") && (sharedPreferences.getString("codAct", "").substring(0, 3).equals("479") || sharedPreferences.getString("codAct", "").equals("4789") || sharedPreferences.getString("codAct", "").equals("4782"))) {
            con1ST.setAdapter(dataAdapterS_G_papeleria);
            con2ST.setAdapter(dataAdapterS_G_papeleria);
            con3ST.setAdapter(dataAdapterS_G_papeleria);
            con4ST.setAdapter(dataAdapterS_G_papeleria);
        } else if (ShaPreSector.equals("SECCION G")) {
            con1ST.setAdapter(dataAdapterOtros);
            con2ST.setAdapter(dataAdapterOtros);
            con3ST.setAdapter(dataAdapterOtros);
            con4ST.setAdapter(dataAdapterOtros);
        }

        if (ShaPreSector.equals("SECCION S")) {
            con1ST.setAdapter(dataAdapterS_S_peluqueria);
            con2ST.setAdapter(dataAdapterS_S_peluqueria);
            con3ST.setAdapter(dataAdapterS_S_peluqueria);
            con4ST.setAdapter(dataAdapterS_S_peluqueria);
        } //
        if (ShaPreSector.equals("SECCION B") || ShaPreSector.equals("SECCION D") || ShaPreSector.equals("SECCION E") || ShaPreSector.equals("SECCION F") || ShaPreSector.equals("SECCION H") || ShaPreSector.equals("SECCION I") || ShaPreSector.equals("SECCION J") || ShaPreSector.equals("SECCION Q") || ShaPreSector.equals("SECCION R") || ShaPreSector.equals("SECCION T")) {
            con1ST.setAdapter(dataAdapterOtros);
            con2ST.setAdapter(dataAdapterOtros);
            con3ST.setAdapter(dataAdapterOtros);
            con4ST.setAdapter(dataAdapterOtros);
        }

        undM1ST.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM1ST", posicionUM);
                editorRD.commit();
                editor.putString("undM1ST", undM1ST.getSelectedItem().toString());
                editor.commit();
                if (!con1ST.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU1ST.setHint("Sugerido:"+hm.get(con1ST.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con1ST.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug1.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM2ST.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM2ST", posicionUM);
                editorRD.commit();
                editor.putString("undM2ST", undM2ST.getSelectedItem().toString());
                editor.commit();
                if (!con2ST.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU2ST.setHint("Sugerido:"+hm.get(con2ST.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con2ST.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug2.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM3ST.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM3ST", posicionUM);
                editorRD.commit();
                editor.putString("undM3ST", undM3ST.getSelectedItem().toString());
                editor.commit();
                if (!con3ST.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU3ST.setHint("Sugerido:"+hm.get(con3ST.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con3ST.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug3.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM4ST.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM4ST", posicionUM);
                editorRD.commit();
                editor.putString("undM4ST", undM4ST.getSelectedItem().toString());
                editor.commit();
                if (!con4ST.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU4ST.setHint("Sugerido:"+hm.get(con4ST.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con4ST.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug4.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM5ST.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM5ST", posicionUM);
                editorRD.commit();
                editor.putString("undM5ST", undM5ST.getSelectedItem().toString());
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM5_1ST.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                editorRD.putInt("undM5_1ST", posicionUM);
                editorRD.commit();
                editor.putString("undM5_1ST", undM5_1ST.getSelectedItem().toString());
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ver1ST.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver1ST", ver1ST.getSelectedItem().toString());
                editorRD.putString("ver1ST", ver1ST.getSelectedItem().toString());
                if (cant1ST.getText().toString().matches("")) {
                } else {

                    if (!valU1ST.getText().toString().matches("")) {
                        valT1ST.setText(String.valueOf(Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString())));
                        try {
                            GT = Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString()) + 0 + 0 + 0;
                            GT_PS = Integer.parseInt(fuentePs1ST.getText().toString());
                            GT_HOG = Integer.parseInt(fuenteHogar1ST.getText().toString());
                        } catch (Exception e) {
                        }
                        totalST.setText(String.valueOf(GT));
                        total_psST.setText(String.valueOf(GT_PS));
                        total_hogarST.setText(String.valueOf(GT_HOG));
                        editor.putString("valT1ST", valT1ST.getText().toString());
                        editorRD.putString("valT1ST", valT1ST.getText().toString());
                    } else {
                        editor.putString("valT1ST", "");
                        editorRD.putString("valT1ST", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ACTFijos.this, sharedPreferencesRD.getString("valT1CT", ""), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ver2ST.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver2ST", ver2ST.getSelectedItem().toString());
                editorRD.putString("ver2ST", ver2ST.getSelectedItem().toString());
                if (!cant2ST.getText().toString().matches("") && !cant1ST.getText().toString().matches("") && !valU2ST.getText().toString().matches("") && !valU1ST.getText().toString().matches("")) {
                    valT2ST.setText(String.valueOf(Integer.parseInt(cant2ST.getText().toString()) * Integer.parseInt(valU2ST.getText().toString())));
                    try {
                        GT = Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString()) + Integer.parseInt(cant2ST.getText().toString()) * Integer.parseInt(valU2ST.getText().toString()) + 0 + 0;
                        GT_PS = Integer.parseInt(fuentePs1ST.getText().toString()) + Integer.parseInt(fuentePs2ST.getText().toString());
                        GT_HOG = Integer.parseInt(fuenteHogar1ST.getText().toString()) + Integer.parseInt(fuenteHogar2ST.getText().toString());
                    } catch (Exception e) {
                    }
                    totalST.setText(String.valueOf(GT));
                    total_psST.setText(String.valueOf(GT_PS));
                    total_hogarST.setText(String.valueOf(GT_HOG));
                    editor.putString("valT2ST", valT2ST.getText().toString());
                    editorRD.putString("valT2ST", valT2ST.getText().toString());
                } else {
                    Toast.makeText(SegTrabajo.this, "Complete todos los datos del 2do recuadro.", Toast.LENGTH_SHORT).show();
                    editor.putString("valT2ST", "");
                    editorRD.putString("valT2ST", "");
                }
                editor.commit();
                editorRD.commit();
                //        Toast.makeText(ACTFijos.this, sharedPreferencesRD.getString("valT1CT", ""), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ver3ST.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver3ST", ver3ST.getSelectedItem().toString());
                editorRD.putString("ver3ST", ver3ST.getSelectedItem().toString());
                if (cant3ST.getText().toString().matches("") || valU3ST.getText().toString().matches("")) {
                    Toast.makeText(SegTrabajo.this, "Complete todos los datos del 3er recuadro.", Toast.LENGTH_LONG).show();

                } else {

                    if (!valU3ST.getText().toString().matches("")) {
                        valT3ST.setText(String.valueOf(Integer.parseInt(cant3ST.getText().toString()) * Integer.parseInt(valU3ST.getText().toString())));
                        editor.putString("valT3ST", valT3ST.getText().toString());
                        editorRD.putString("valT3ST", valT3ST.getText().toString());
                        if (!valU2ST.getText().toString().matches("") && !cant2ST.getText().toString().matches("")) {
                            try {
                                GT = Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString()) + Integer.parseInt(cant2ST.getText().toString()) * Integer.parseInt(valU2ST.getText().toString()) + Integer.parseInt(cant3ST.getText().toString()) * Integer.parseInt(valU3ST.getText().toString()) + 0;
                                GT_PS = Integer.parseInt(fuentePs1ST.getText().toString()) + Integer.parseInt(fuentePs2ST.getText().toString()) + Integer.parseInt(fuentePs3ST.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1ST.getText().toString()) + Integer.parseInt(fuenteHogar2ST.getText().toString()) + Integer.parseInt(fuenteHogar3ST.getText().toString());
                            } catch (Exception e) {
                            }
                            totalST.setText(String.valueOf(GT));
                            total_psST.setText(String.valueOf(GT_PS));
                            total_hogarST.setText(String.valueOf(GT_HOG));
                        }
                    } else {
                        editor.putString("valT3ST", "");
                        editorRD.putString("valT3ST", "");
                    }
                    editor.commit();
                    editorRD.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });

        ver4ST.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver4ST", ver4ST.getSelectedItem().toString());
                editorRD.putString("ver4ST", ver4ST.getSelectedItem().toString());
                if (cant4ST.getText().toString().matches("") || valU4ST.getText().toString().matches("")) {
                    Toast.makeText(SegTrabajo.this, "Complete todos los datos del 4to recuadro.", Toast.LENGTH_LONG).show();
                } else {

                    if (!valU4ST.getText().toString().matches("")) {
                        valT4ST.setText(String.valueOf(Integer.parseInt(cant4ST.getText().toString()) * Integer.parseInt(valU4ST.getText().toString())));

                        editor.putString("valT4ST", valT4ST.getText().toString());
                        editorRD.putString("valT4ST", valT4ST.getText().toString());
                        if (!valU2ST.getText().toString().matches("") && !valU3ST.getText().toString().matches("") && !cant2ST.getText().toString().matches("") && !cant3ST.getText().toString().matches("")) {

                            try {
                                GT = Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString()) + Integer.parseInt(cant2ST.getText().toString()) * Integer.parseInt(valU2ST.getText().toString()) + Integer.parseInt(cant3ST.getText().toString()) * Integer.parseInt(valU3ST.getText().toString()) + Integer.parseInt(cant4ST.getText().toString()) * Integer.parseInt(valU4ST.getText().toString());
                                GT_PS = Integer.parseInt(fuentePs1ST.getText().toString()) + Integer.parseInt(fuentePs2ST.getText().toString()) + Integer.parseInt(fuentePs3ST.getText().toString()) + Integer.parseInt(fuentePs4ST.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1ST.getText().toString()) + Integer.parseInt(fuenteHogar2ST.getText().toString()) + Integer.parseInt(fuenteHogar3ST.getText().toString()) + Integer.parseInt(fuenteHogar4ST.getText().toString());
                            } catch (Exception e) {
                            }
                            totalST.setText(String.valueOf(GT));
                            total_psST.setText(String.valueOf(GT_PS));
                            total_hogarST.setText(String.valueOf(GT_HOG));

                        }
                    } else {
                        editor.putString("valT4ST", "");
                        editorRD.putString("valT4ST", "");
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
        ver5ST.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SegTrabajo.this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver5ST", ver5ST.getSelectedItem().toString());
                editorRD.putString("ver5ST", ver5ST.getSelectedItem().toString());
                if (cant5ST.getText().toString().matches("")) {
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0;
                    if (!valU5ST.getText().toString().matches("")) {
                        valT5ST.setText(String.valueOf(Integer.parseInt(cant5ST.getText().toString()) * Integer.parseInt(valU5ST.getText().toString())));

                        editor.putString("valT5ST", valT5ST.getText().toString());
                        editorRD.putString("valT5ST", valT5ST.getText().toString());

                        if (valU1ST.getText().toString().matches("") && cant1ST.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString());
                        }
                        if (valU2ST.getText().toString().matches("") && cant2ST.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2ST.getText().toString()) * Integer.parseInt(valU2ST.getText().toString());
                        }
                        if (valU3ST.getText().toString().matches("") && cant3ST.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3ST.getText().toString()) * Integer.parseInt(valU3ST.getText().toString());
                        }
                        if (valU4ST.getText().toString().matches("") && cant4ST.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4ST.getText().toString()) * Integer.parseInt(valU4ST.getText().toString());
                        }

                        if (fuentePs1ST.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1ST.getText().toString());
                        }
                        if (fuentePs2ST.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2ST.getText().toString());
                        }
                        if (fuentePs3ST.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3ST.getText().toString());
                        }
                        if (fuentePs4ST.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4ST.getText().toString());
                        }

                        if (fuenteHogar1ST.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1ST.getText().toString());
                        }
                        if (fuenteHogar2ST.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2ST.getText().toString());
                        }
                        if (fuenteHogar3ST.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3ST.getText().toString());
                        }
                        if (fuenteHogar4ST.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4ST.getText().toString());
                        }

                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + Integer.parseInt(cant5ST.getText().toString()) * Integer.parseInt(valU5ST.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + Integer.parseInt(fuentePs5ST.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + Integer.parseInt(fuenteHogar5ST.getText().toString());
                        } catch (Exception e) {
                        }
                        totalST.setText(String.valueOf(GT));
                        total_psST.setText(String.valueOf(GT_PS));
                        total_hogarST.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5ST", "");
                        editorRD.putString("valT5ST", "");
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
        ver5_1ST.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();

                if (cant5_1ST.getText().toString().matches("") || valU5_1ST.getText().toString().matches("")) {
                    Toast.makeText(SegTrabajo.this, "Revise que este todo completo", Toast.LENGTH_LONG).show();
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorT5 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorPS5 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0, valorHogar5 = 0;
                    if (!valU5_1ST.getText().toString().matches("")) {
                        valT5_1ST.setText(String.valueOf(Integer.parseInt(cant5_1ST.getText().toString()) * Integer.parseInt(valU5_1ST.getText().toString())));

                        editor.putString("valT5_1ST", valT5_1ST.getText().toString());
                        editorRD.putString("valT5_1ST", valT5_1ST.getText().toString());

                        if (valU1ST.getText().toString().matches("") && cant1ST.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString());
                        }
                        if (valU2ST.getText().toString().matches("") && cant2ST.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2ST.getText().toString()) * Integer.parseInt(valU2ST.getText().toString());
                        }
                        if (valU3ST.getText().toString().matches("") && cant3ST.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3ST.getText().toString()) * Integer.parseInt(valU3ST.getText().toString());
                        }
                        if (valU4ST.getText().toString().matches("") && cant4ST.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4ST.getText().toString()) * Integer.parseInt(valU4ST.getText().toString());
                        }
                        if (valU5ST.getText().toString().matches("") && cant5ST.getText().toString().matches("")) {
                            valorT5 = 0;
                        } else {
                            valorT5 = Integer.parseInt(cant5ST.getText().toString()) * Integer.parseInt(valU5ST.getText().toString());
                        }

                        if (fuentePs1ST.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1ST.getText().toString());
                        }
                        if (fuentePs2ST.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2ST.getText().toString());
                        }
                        if (fuentePs3ST.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3ST.getText().toString());
                        }
                        if (fuentePs4ST.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4ST.getText().toString());
                        }
                        if (fuentePs5ST.getText().toString().matches("")) {
                            valorPS5 = 0;
                        } else {
                            valorPS5 = Integer.parseInt(fuentePs5ST.getText().toString());
                        }

                        if (fuenteHogar1ST.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1ST.getText().toString());
                        }
                        if (fuenteHogar2ST.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2ST.getText().toString());
                        }
                        if (fuenteHogar3ST.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3ST.getText().toString());
                        }
                        if (fuenteHogar4ST.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4ST.getText().toString());
                        }
                        if (fuenteHogar5ST.getText().toString().matches("")) {
                            valorHogar5 = 0;
                        } else {
                            valorHogar5 = Integer.parseInt(fuenteHogar5ST.getText().toString());
                        }


                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + valorT5 + Integer.parseInt(cant5_1ST.getText().toString()) * Integer.parseInt(valU5_1ST.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + valorPS5 + Integer.parseInt(fuentePs5_1ST.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + valorHogar5 + Integer.parseInt(fuenteHogar5_1ST.getText().toString());
                        } catch (Exception e) {
                        }
                        totalST.setText(String.valueOf(GT));
                        total_psST.setText(String.valueOf(GT_PS));
                        total_hogarST.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5_1ST", "");
                        editorRD.putString("valT5_1ST", "");
                    }
                    editor.putString("ver5_1ST", ver5_1ST.getSelectedItem().toString());
                    editorRD.putString("ver5_1ST", ver5_1ST.getSelectedItem().toString());
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
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
                        //SegTrabajo.super.onBackPressed();
                        Intent intent = new Intent(SegTrabajo.this, Inversion.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        // revisar             intent.putExtra("encuestas",sharedPreferences.getString("datosver", ""));
                        startActivity(intent);
                    }
                    break;
                    case R.id.next: {
                        //  SharedPreferences.Editor editor = sharedPreferences.edit();
                        //       editor.clear();editor.commit();

                        if (con1ST.getSelectedItem().toString().matches("Seleccione......") || cant1ST.getText().toString().matches("")
                                || valT1ST.getText().toString().matches("") || fuentePs1ST.getText().toString().matches("")
                                || fuenteHogar1ST.getText().toString().matches("") || totalST.getText().toString().matches("")) {
                            Toast.makeText(SegTrabajo.this, "Llene todos los campos, la seccion de Totales (abajo)", Toast.LENGTH_LONG).show();
                        } else {
                            // revisar               editor.putString("CC", editTextCC.getText().toString());
                            //       Toast.makeText(MainActivity.this, ""+nombre.getText().toString(), Toast.LENGTH_SHORT).show();
             /*               if(tipoProyec.getText()!=null) {

                                editor.putString("tipoP", tipoProyec.getText().toString());

                                //Toast.makeText(MainActivity.this, "no tiene segundo nombre", Toast.LENGTH_SHORT).show();
                            }
 */
                            editor.putString("con1ST", con1ST.getSelectedItem().toString());
                            if (con2ST.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con2ST", "");
                            } else {
                                editor.putString("con2ST", con2ST.getSelectedItem().toString());
                            }
                            if (con3ST.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con3ST", "");
                            } else {
                                editor.putString("con3ST", con3ST.getSelectedItem().toString());
                            }
                            if (con4ST.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con4ST", "");
                            } else {
                                editor.putString("con4ST", con4ST.getSelectedItem().toString());
                            }
                            if (con5ST.getText().toString().matches("")) {
                                editor.putString("con5ST", "");
                            } else {
                                editor.putString("con5ST", con5ST.getText().toString());
                            }
                            if (con5_1ST.getText().toString().matches("")) {
                                editor.putString("con5_1ST", "");
                            } else {
                                editor.putString("con5_1ST", con5_1ST.getText().toString());
                            }

                            if (cant1ST.getText().toString().matches("")) {
                                editor.putString("cant1ST", "");
                            } else {
                                editor.putString("cant1ST", cant1ST.getText().toString());
                            }
                            if (cant2ST.getText().toString().matches("")) {
                                editor.putString("cant2ST", "");
                            } else {
                                editor.putString("cant2ST", cant2ST.getText().toString());
                            }
                            if (cant3ST.getText().toString().matches("")) {
                                editor.putString("cant3ST", "");
                            } else {
                                editor.putString("cant3ST", cant3ST.getText().toString());
                            }
                            if (cant4ST.getText().toString().matches("")) {
                                editor.putString("cant4ST", "");
                            } else {
                                editor.putString("cant4ST", cant4ST.getText().toString());
                            }
                            if (cant5ST.getText().toString().matches("")) {
                                editor.putString("cant5ST", "");
                            } else {
                                editor.putString("cant5ST", cant5ST.getText().toString());
                            }
                            if (cant5_1ST.getText().toString().matches("")) {
                                editor.putString("cant5_1ST", "");
                            } else {
                                editor.putString("cant5_1ST", cant5_1ST.getText().toString());
                            }

                            if (valU1ST.getText().toString().matches("")) {
                                editor.putString("valU1ST", "");
                            } else {
                                editor.putString("valU1ST", valU1ST.getText().toString());
                            }
                            if (valU2ST.getText().toString().matches("")) {
                                editor.putString("valU2ST", "");
                            } else {
                                editor.putString("valU2ST", valU2ST.getText().toString());
                            }
                            if (valU3ST.getText().toString().matches("")) {
                                editor.putString("valU3ST", "");
                            } else {
                                editor.putString("valU3ST", valU3ST.getText().toString());
                            }
                            if (valU4ST.getText().toString().matches("")) {
                                editor.putString("valU4ST", "");
                            } else {
                                editor.putString("valU4ST", valU4ST.getText().toString());
                            }
                            if (valU5ST.getText().toString().matches("")) {
                                editor.putString("valU5ST", "");
                            } else {
                                editor.putString("valU5ST", valU5ST.getText().toString());
                            }
                            if (valU5_1ST.getText().toString().matches("")) {
                                editor.putString("valU5_1ST", "");
                            } else {
                                editor.putString("valU5_1ST", valU5_1ST.getText().toString());
                            }

                            if (fuentePs1ST.getText().toString().matches("")) {
                                editor.putString("fuentePs1ST", "");
                            } else {
                                editor.putString("fuentePs1ST", fuentePs1ST.getText().toString());
                            }
                            if (fuentePs2ST.getText().toString().matches("")) {
                                editor.putString("fuentePs2ST", "");
                            } else {
                                editor.putString("fuentePs2ST", fuentePs2ST.getText().toString());
                            }
                            if (fuentePs3ST.getText().toString().matches("")) {
                                editor.putString("fuentePs3ST", "");
                            } else {
                                editor.putString("fuentePs3ST", fuentePs3ST.getText().toString());
                            }
                            if (fuentePs4ST.getText().toString().matches("")) {
                                editor.putString("fuentePs4ST", "");
                            } else {
                                editor.putString("fuentePs4ST", fuentePs4ST.getText().toString());
                            }
                            if (fuentePs5ST.getText().toString().matches("")) {
                                editor.putString("fuentePs5ST", "");
                            } else {
                                editor.putString("fuentePs5ST", fuentePs5ST.getText().toString());
                            }
                            if (fuentePs5_1ST.getText().toString().matches("")) {
                                editor.putString("fuentePs5_1ST", "");
                            } else {
                                editor.putString("fuentePs5_1ST", fuentePs5_1ST.getText().toString());
                            }

                            if (fuenteHogar1ST.getText().toString().matches("")) {
                                editor.putString("fuenteHogar1ST", "");
                            } else {
                                editor.putString("fuenteHogar1ST", fuenteHogar1ST.getText().toString());
                            }
                            if (fuenteHogar2ST.getText().toString().matches("")) {
                                editor.putString("fuenteHogar2ST", "");
                            } else {
                                editor.putString("fuenteHogar2ST", fuenteHogar2ST.getText().toString());
                            }
                            if (fuenteHogar3ST.getText().toString().matches("")) {
                                editor.putString("fuenteHogar3ST", "");
                            } else {
                                editor.putString("fuenteHogar3ST", fuenteHogar3ST.getText().toString());
                            }
                            if (fuenteHogar4ST.getText().toString().matches("")) {
                                editor.putString("fuenteHogar4ST", "");
                            } else {
                                editor.putString("fuenteHogar4ST", fuenteHogar4ST.getText().toString());
                            }
                            if (fuenteHogar5ST.getText().toString().matches("")) {
                                editor.putString("fuenteHogar5ST", "");
                            } else {
                                editor.putString("fuenteHogar5ST", fuenteHogar5ST.getText().toString());
                            }
                            if (fuenteHogar5_1ST.getText().toString().matches("")) {
                                editor.putString("fuenteHogar5_1ST", "");
                            } else {
                                editor.putString("fuenteHogar5_1ST", fuenteHogar5ST.getText().toString());
                            }

                            if (totalST.getText().toString().matches("")) {
                                editor.putString("totalST", "");
                            } else {
                                editor.putString("totalST", totalST.getText().toString());
                            }
                            if (total_psST.getText().toString().matches("")) {
                                editor.putString("total_psST", "");
                            } else {
                                editor.putString("total_psST", total_psST.getText().toString());
                            }
                            if (total_hogarST.getText().toString().matches("")) {
                                editor.putString("total_hogarST", "");
                            } else {
                                editor.putString("total_hogarST", total_hogarST.getText().toString());
                            }
                            //       if(total_verifST.getText().toString().matches("")) {editor.putString("total_verifST","");}else{editor.putString("total_verifST",total_verifST.getText().toString());}
                            editor.commit();
                            editorRD.putInt("con1ST", con1ST.getSelectedItemPosition());     //14 marzo
                            editorRD.putInt("con2ST", con2ST.getSelectedItemPosition());
                            editorRD.putInt("con3ST", con3ST.getSelectedItemPosition());
                            editorRD.putInt("con4ST", con4ST.getSelectedItemPosition());
                            if (con5ST.getText().toString().matches("")) {
                                editorRD.putString("con5ST", "");
                            } else {
                                editorRD.putString("con5ST", con5ST.getText().toString());
                            }
                            if (con5_1ST.getText().toString().matches("")) {
                                editorRD.putString("con5_1ST", "");
                            } else {
                                editorRD.putString("con5_1ST", con5_1ST.getText().toString());
                            }

                            if (cant1ST.getText().toString().matches("")) {
                                editorRD.putString("cant1ST", "");
                            } else {
                                editorRD.putString("cant1ST", cant1ST.getText().toString());
                            }
                            if (cant2ST.getText().toString().matches("")) {
                                editorRD.putString("cant2ST", "");
                            } else {
                                editorRD.putString("cant2ST", cant2ST.getText().toString());
                            }
                            if (cant3ST.getText().toString().matches("")) {
                                editorRD.putString("cant3ST", "");
                            } else {
                                editorRD.putString("cant3ST", cant3ST.getText().toString());
                            }
                            if (cant4ST.getText().toString().matches("")) {
                                editorRD.putString("cant4ST", "");
                            } else {
                                editorRD.putString("cant4ST", cant4ST.getText().toString());
                            }
                            if (cant5ST.getText().toString().matches("")) {
                                editorRD.putString("cant5ST", "");
                            } else {
                                editorRD.putString("cant5ST", cant5ST.getText().toString());
                            }
                            if (cant5_1ST.getText().toString().matches("")) {
                                editorRD.putString("cant5_1ST", "");
                            } else {
                                editorRD.putString("cant5_1ST", cant5_1ST.getText().toString());
                            }

                          /*
                            if(undM1ST.getSelectedItem().toString().matches("")) {editorRD.putString("undM1ST","");}else{editorRD.putString("undM1ST",undM1ST.getSelectedItem().toString());}
                            if(undM2ST.getSelectedItem().toString().matches("")) {editorRD.putString("undM2ST","");}else{editorRD.putString("undM2ST",undM2ST.getSelectedItem().toString());}
                            if(undM3ST.getSelectedItem().toString().matches("")) {editorRD.putString("undM3ST","");}else{editorRD.putString("undM3ST",undM3ST.getSelectedItem().toString());}
                            if(undM4ST.getSelectedItem().toString().matches("")) {editorRD.putString("undM4ST","");}else{editorRD.putString("undM4ST",undM4ST.getSelectedItem().toString());}
                          */
                            if (valU1ST.getText().toString().matches("")) {
                                editorRD.putString("valU1ST", "");
                            } else {
                                editorRD.putString("valU1ST", valU1ST.getText().toString());
                            }
                            if (valU2ST.getText().toString().matches("")) {
                                editorRD.putString("valU2ST", "");
                            } else {
                                editorRD.putString("valU2ST", valU2ST.getText().toString());
                            }
                            if (valU3ST.getText().toString().matches("")) {
                                editorRD.putString("valU3ST", "");
                            } else {
                                editorRD.putString("valU3ST", valU3ST.getText().toString());
                            }
                            if (valU4ST.getText().toString().matches("")) {
                                editorRD.putString("valU4ST", "");
                            } else {
                                editorRD.putString("valU4ST", valU4ST.getText().toString());
                            }
                            if (valU5ST.getText().toString().matches("")) {
                                editorRD.putString("valU5ST", "");
                            } else {
                                editorRD.putString("valU5ST", valU5ST.getText().toString());
                            }
                            if (valU5_1ST.getText().toString().matches("")) {
                                editorRD.putString("valU5_1ST", "");
                            } else {
                                editorRD.putString("valU5_1ST", valU5_1ST.getText().toString());
                            }


                            if (fuentePs1ST.getText().toString().matches("")) {
                                editorRD.putString("fuentePs1ST", "");
                            } else {
                                editorRD.putString("fuentePs1ST", fuentePs1ST.getText().toString());
                            }
                            if (fuentePs2ST.getText().toString().matches("")) {
                                editorRD.putString("fuentePs2ST", "");
                            } else {
                                editorRD.putString("fuentePs2ST", fuentePs2ST.getText().toString());
                            }
                            if (fuentePs3ST.getText().toString().matches("")) {
                                editorRD.putString("fuentePs3ST", "");
                            } else {
                                editorRD.putString("fuentePs3ST", fuentePs3ST.getText().toString());
                            }
                            if (fuentePs4ST.getText().toString().matches("")) {
                                editorRD.putString("fuentePs4ST", "");
                            } else {
                                editorRD.putString("fuentePs4ST", fuentePs4ST.getText().toString());
                            }
                            if (fuentePs5ST.getText().toString().matches("")) {
                                editorRD.putString("fuentePs5ST", "");
                            } else {
                                editorRD.putString("fuentePs5ST", fuentePs5ST.getText().toString());
                            }
                            if (fuentePs5_1ST.getText().toString().matches("")) {
                                editorRD.putString("fuentePs5_1ST", "");
                            } else {
                                editorRD.putString("fuentePs5_1ST", fuentePs5_1ST.getText().toString());
                            }
                            if (fuenteHogar1ST.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar1ST", "");
                            } else {
                                editorRD.putString("fuenteHogar1ST", fuenteHogar1ST.getText().toString());
                            }
                            if (fuenteHogar2ST.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar2ST", "");
                            } else {
                                editorRD.putString("fuenteHogar2ST", fuenteHogar2ST.getText().toString());
                            }
                            if (fuenteHogar3ST.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar3ST", "");
                            } else {
                                editorRD.putString("fuenteHogar3ST", fuenteHogar3ST.getText().toString());
                            }
                            if (fuenteHogar4ST.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar4ST", "");
                            } else {
                                editorRD.putString("fuenteHogar4ST", fuenteHogar4ST.getText().toString());
                            }
                            if (fuenteHogar5ST.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar5ST", "");
                            } else {
                                editorRD.putString("fuenteHogar5ST", fuenteHogar5ST.getText().toString());
                            }
                            if (fuenteHogar5_1ST.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar5_1ST", "");
                            } else {
                                editorRD.putString("fuenteHogar5_1ST", fuenteHogar5_1ST.getText().toString());
                            }

                            if (totalST.getText().toString().matches("")) {
                                editorRD.putString("totalST", "");
                            } else {
                                editorRD.putString("totalST", totalST.getText().toString());
                            }
                            if (total_psST.getText().toString().matches("")) {
                                editorRD.putString("total_psST", "");
                            } else {
                                editorRD.putString("total_psST", total_psST.getText().toString());
                            }
                            if (total_hogarST.getText().toString().matches("")) {
                                editorRD.putString("total_hogarST", "");
                            } else {
                                editorRD.putString("total_hogarST", total_hogarST.getText().toString());
                            }
                            //   if(total_verifST.getText().toString().matches("")) {editorRD.putString("total_verifST","");}else{editorRD.putString("total_verifST",total_verifST.getText().toString());}

                            editorRD.commit();
                            if (sharedPreferences.getString("undM1ST", "").equals("U.medida..........") && !sharedPreferences.getString("con1ST", "").equals("SELECCIONE.......")) {
                                editor.putString("undM1ST", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM2ST", "").equals("U.medida..........") && !sharedPreferences.getString("con2ST", "").equals("SELECCIONE.......")) {
                                editor.putString("undM2ST", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM3ST", "").equals("U.medida..........") && !sharedPreferences.getString("con3ST", "").equals("SELECCIONE.......")) {
                                editor.putString("undM3ST", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM4ST", "").equals("U.medida..........") && !sharedPreferences.getString("con4ST", "").equals("SELECCIONE.......")) {
                                editor.putString("undM4ST", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM5ST", "").equals("U.medida..........") && !sharedPreferences.getString("con5ST", "").equals("")) {
                                editor.putString("undM5ST", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM5_1ST", "").equals("U.medida..........") && !sharedPreferences.getString("con5_1ST", "").equals("")) {
                                editor.putString("undM5_1ST", "Unidad");
                                editor.commit();
                            }

                            Intent intent = new Intent(SegTrabajo.this, Inversion.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            Toast.makeText(SegTrabajo.this, "Datos Guardados!", Toast.LENGTH_LONG).show();
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
        int tipop = sharedPreferencesRD.getInt("con1ST", 0);    //14 marzo
        con1ST.setSelection(tipop);                                         //14 marzo
        int tipop2 = sharedPreferencesRD.getInt("con2ST", 0);
        con2ST.setSelection(tipop2);
        int tipop3 = sharedPreferencesRD.getInt("con3ST", 0);    //14 marzo
        con3ST.setSelection(tipop3);
        int tipop4 = sharedPreferencesRD.getInt("con4ST", 0);
        con4ST.setSelection(tipop4);
        con5ST.setText(sharedPreferencesRD.getString("con5ST", ""));
        con5_1ST.setText(sharedPreferencesRD.getString("con5_1ST", ""));
        String tipop5 = sharedPreferencesRD.getString("cant1ST", "");
        cant1ST.setText(tipop5);
        String tipop6 = sharedPreferencesRD.getString("cant2ST", "");
        cant2ST.setText(tipop6);
        String tipop7 = sharedPreferencesRD.getString("cant3ST", "");
        cant3ST.setText(tipop7);
        String tipop8 = sharedPreferencesRD.getString("cant4ST", "");
        cant4ST.setText(tipop8);
        cant5ST.setText(sharedPreferencesRD.getString("cant5ST", ""));
        cant5_1ST.setText(sharedPreferencesRD.getString("cant5_1ST", ""));
        int tipop9 = sharedPreferencesRD.getInt("undM1ST", 0);
        undM1ST.setSelection(tipop9);
        int tipop10 = sharedPreferencesRD.getInt("undM2ST", 0);
        undM2ST.setSelection(tipop10);
        int tipop11 = sharedPreferencesRD.getInt("undM3ST", 0);
        undM3ST.setSelection(tipop11);
        int tipop12 = sharedPreferencesRD.getInt("undM4ST", 0);
        undM4ST.setSelection(tipop12);
        int tipop12_1 = sharedPreferencesRD.getInt("undM5ST", 0);
        undM5ST.setSelection(tipop12_1);
        undM5_1ST.setSelection(sharedPreferencesRD.getInt("undM5_1ST", 0));
        String tipop13 = sharedPreferencesRD.getString("valU1ST", "");
        valU1ST.setText(tipop13);
        String tipop14 = sharedPreferencesRD.getString("valU2ST", "");
        valU2ST.setText(tipop14);
        String tipop15 = sharedPreferencesRD.getString("valU3ST", "");
        valU3ST.setText(tipop15);
        String tipop16 = sharedPreferencesRD.getString("valU4ST", "");
        valU4ST.setText(tipop16);
        valU5ST.setText(sharedPreferencesRD.getString("valU5ST", ""));
        valU5_1ST.setText(sharedPreferencesRD.getString("valU5_1ST", ""));
        String tipop17 = sharedPreferencesRD.getString("ver1ST", "");
        if (tipop17.equals("Cumple")) {
            ver1ST.setSelection(0);
        } else {
            ver1ST.setSelection(1);
        }
        String tipop18 = sharedPreferencesRD.getString("ver2ST", "");
        if (tipop18.equals("Cumple")) {
            ver2ST.setSelection(0);
        } else {
            ver2ST.setSelection(1);
        }
        String tipop19 = sharedPreferencesRD.getString("ver3ST", "");
        if (tipop19.equals("Cumple")) {
            ver3ST.setSelection(0);
        } else {
            ver3ST.setSelection(1);
        }
        String tipop20 = sharedPreferencesRD.getString("ver4ST", "");
        if (tipop20.equals("Cumple")) {
            ver4ST.setSelection(0);
        } else {
            ver4ST.setSelection(1);
        }
        String tipop20_1 = sharedPreferencesRD.getString("ver5ST", "");
        if (tipop20_1.equals("Cumple")) {
            ver5ST.setSelection(0);
        } else {
            ver5ST.setSelection(1);
        }
        String tipop20_2 = sharedPreferencesRD.getString("ver5_1ST", "");
        if (tipop20_2.equals("Cumple")) {
            ver5_1ST.setSelection(0);
        } else {
            ver5_1ST.setSelection(1);
        }
        String tipop21 = sharedPreferencesRD.getString("valT1ST", "");
        valT1ST.setText(tipop21);
        String tipop22 = sharedPreferencesRD.getString("valT2ST", "");
        valT2ST.setText(tipop22);
        String tipop23 = sharedPreferencesRD.getString("valT3ST", "");
        valT3ST.setText(tipop23);
        String tipop24 = sharedPreferencesRD.getString("valT4ST", "");
        valT4ST.setText(tipop24);
        String tipop25 = sharedPreferencesRD.getString("valT5ST", "");
        valT5ST.setText(tipop25);
        valT5_1ST.setText(sharedPreferencesRD.getString("valT5_1ST", ""));

        String titulop26 = sharedPreferencesRD.getString("fuentePs1ST", "");
        fuentePs1ST.setText(titulop26);
        String titulop27 = sharedPreferencesRD.getString("fuentePs2ST", "");
        fuentePs2ST.setText(titulop27);
        String titulop28 = sharedPreferencesRD.getString("fuentePs3ST", "");
        fuentePs3ST.setText(titulop28);
        String titulop29 = sharedPreferencesRD.getString("fuentePs4ST", "");
        fuentePs4ST.setText(titulop29);
        String titulop29_1 = sharedPreferencesRD.getString("fuentePs5ST", "");
        fuentePs5ST.setText(titulop29_1);
        fuentePs5_1ST.setText(sharedPreferencesRD.getString("fuentePs5_1ST", ""));
        String titulop30 = sharedPreferencesRD.getString("fuenteHogar1ST", "");
        fuenteHogar1ST.setText(titulop30);
        String titulop31 = sharedPreferencesRD.getString("fuenteHogar2ST", "");
        fuenteHogar2ST.setText(titulop31);
        String titulop32 = sharedPreferencesRD.getString("fuenteHogar3ST", "");
        fuenteHogar3ST.setText(titulop32);
        String titulop33 = sharedPreferencesRD.getString("fuenteHogar4ST", "");
        fuenteHogar4ST.setText(titulop33);
        String titulop33_1 = sharedPreferencesRD.getString("fuenteHogar5ST", "");
        fuenteHogar5ST.setText(titulop33_1);
        fuenteHogar5_1ST.setText(sharedPreferencesRD.getString("fuenteHogar5_1ST", ""));
        String titulop34 = sharedPreferencesRD.getString("totalST", "");
        totalST.setText(titulop34);
        String titulop35 = sharedPreferencesRD.getString("total_psST", "");
        total_psST.setText(titulop35);
        String titulop36 = sharedPreferencesRD.getString("total_hogarST", "");
        total_hogarST.setText(titulop36);
        //   String titulop37 = sharedPreferencesRD.getString("total_verifST", "");
        //    total_verifST.setText(titulop37);


    }

    public void ir(View view) {
        totalST.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(totalST, InputMethodManager.SHOW_IMPLICIT);

    }

    public void calcular(View view) {
        switch (view.getId()) {
            case R.id.C1:
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant1ST.getText().toString().matches("")) {
                } else {

                    if (!valU1ST.getText().toString().matches("")) {
                        valT1ST.setText(String.valueOf(Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString())));
                        try {
                            GT = Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString()) + 0 + 0 + 0;
                            GT_PS = Integer.parseInt(fuentePs1ST.getText().toString());
                            GT_HOG = Integer.parseInt(fuenteHogar1ST.getText().toString());
                        } catch (Exception e) {
                        }
                        totalST.setText(String.valueOf(GT));
                        total_psST.setText(String.valueOf(GT_PS));
                        total_hogarST.setText(String.valueOf(GT_HOG));
                        editor.putString("valT1ST", valT1ST.getText().toString());
                        editorRD.putString("valT1ST", valT1ST.getText().toString());
                    } else {
                        editor.putString("valT1ST", "");
                        editorRD.putString("valT1ST", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ASTFijos.this, sharedPreferencesRD.getString("valT1ST", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C2:

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (!cant2ST.getText().toString().matches("") && !cant1ST.getText().toString().matches("") && !valU2ST.getText().toString().matches("") && !valU1ST.getText().toString().matches("")) {
                    valT2ST.setText(String.valueOf(Integer.parseInt(cant2ST.getText().toString()) * Integer.parseInt(valU2ST.getText().toString())));
                    try {
                        GT = Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString()) + Integer.parseInt(cant2ST.getText().toString()) * Integer.parseInt(valU2ST.getText().toString()) + 0 + 0;
                        GT_PS = Integer.parseInt(fuentePs1ST.getText().toString()) + Integer.parseInt(fuentePs2ST.getText().toString());
                        GT_HOG = Integer.parseInt(fuenteHogar1ST.getText().toString()) + Integer.parseInt(fuenteHogar2ST.getText().toString());
                    } catch (Exception e) {
                    }
                    totalST.setText(String.valueOf(GT));
                    total_psST.setText(String.valueOf(GT_PS));
                    total_hogarST.setText(String.valueOf(GT_HOG));
                    editor.putString("valT2ST", valT2ST.getText().toString());
                    editorRD.putString("valT2ST", valT2ST.getText().toString());
                } else {
                    Toast.makeText(this, "Complete todo los datos de arriba.", Toast.LENGTH_SHORT).show();
                    editor.putString("valT2ST", "");
                    editorRD.putString("valT2ST", "");
                }
                editor.commit();
                editorRD.commit();
                //        Toast.makeText(ASTFijos.this, sharedPreferencesRD.getString("valT1ST", ""), Toast.LENGTH_LONG).show();

                break;
            case R.id.C3:

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant3ST.getText().toString().matches("")) {
                } else {

                    if (!valU3ST.getText().toString().matches("")) {
                        valT3ST.setText(String.valueOf(Integer.parseInt(cant3ST.getText().toString()) * Integer.parseInt(valU3ST.getText().toString())));
                        editor.putString("valT3ST", valT3ST.getText().toString());
                        editorRD.putString("valT3ST", valT3ST.getText().toString());
                        if (!valU2ST.getText().toString().matches("") && !cant2ST.getText().toString().matches("")) {
                            try {
                                GT = Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString()) + Integer.parseInt(cant2ST.getText().toString()) * Integer.parseInt(valU2ST.getText().toString()) + Integer.parseInt(cant3ST.getText().toString()) * Integer.parseInt(valU3ST.getText().toString()) + 0;
                                GT_PS = Integer.parseInt(fuentePs1ST.getText().toString()) + Integer.parseInt(fuentePs2ST.getText().toString()) + Integer.parseInt(fuentePs3ST.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1ST.getText().toString()) + Integer.parseInt(fuenteHogar2ST.getText().toString()) + Integer.parseInt(fuenteHogar3ST.getText().toString());
                            } catch (Exception e) {
                            }
                            totalST.setText(String.valueOf(GT));
                            total_psST.setText(String.valueOf(GT_PS));
                            total_hogarST.setText(String.valueOf(GT_HOG));
                        }
                    } else {
                        editor.putString("valT3ST", "");
                        editorRD.putString("valT3ST", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ASTFijos.this, sharedPreferencesRD.getString("valT1ST", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C4:

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant4ST.getText().toString().matches("")) {
                } else {

                    if (!valU4ST.getText().toString().matches("")) {
                        valT4ST.setText(String.valueOf(Integer.parseInt(cant4ST.getText().toString()) * Integer.parseInt(valU4ST.getText().toString())));
                        editor.putString("valT4ST", valT4ST.getText().toString());
                        editorRD.putString("valT4ST", valT4ST.getText().toString());
                        if (!valU2ST.getText().toString().matches("") && !valU3ST.getText().toString().matches("") && !cant2ST.getText().toString().matches("") && !cant3ST.getText().toString().matches("")) {
                            try {
                                GT = Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString()) + Integer.parseInt(cant2ST.getText().toString()) * Integer.parseInt(valU2ST.getText().toString()) + Integer.parseInt(cant3ST.getText().toString()) * Integer.parseInt(valU3ST.getText().toString()) + Integer.parseInt(cant4ST.getText().toString()) * Integer.parseInt(valU4ST.getText().toString());
                                GT_PS = Integer.parseInt(fuentePs1ST.getText().toString()) + Integer.parseInt(fuentePs2ST.getText().toString()) + Integer.parseInt(fuentePs3ST.getText().toString()) + Integer.parseInt(fuentePs4ST.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1ST.getText().toString()) + Integer.parseInt(fuenteHogar2ST.getText().toString()) + Integer.parseInt(fuenteHogar3ST.getText().toString()) + Integer.parseInt(fuenteHogar4ST.getText().toString());
                            } catch (Exception e) {
                            }
                            totalST.setText(String.valueOf(GT));
                            total_psST.setText(String.valueOf(GT_PS));
                            total_hogarST.setText(String.valueOf(GT_HOG));
                        }
                    } else {
                        editor.putString("valT4ST", "");
                        editorRD.putString("valT4ST", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C5:
                Toast.makeText(SegTrabajo.this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant5ST.getText().toString().matches("")) {
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0;
                    if (!valU5ST.getText().toString().matches("")) {
                        valT5ST.setText(String.valueOf(Integer.parseInt(cant5ST.getText().toString()) * Integer.parseInt(valU5ST.getText().toString())));

                        editor.putString("valT5CT", valT5ST.getText().toString());
                        editorRD.putString("valT5CT", valT5ST.getText().toString());

                        if (valU1ST.getText().toString().matches("") && cant1ST.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString());
                        }
                        if (valU2ST.getText().toString().matches("") && cant2ST.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2ST.getText().toString()) * Integer.parseInt(valU2ST.getText().toString());
                        }
                        if (valU3ST.getText().toString().matches("") && cant3ST.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3ST.getText().toString()) * Integer.parseInt(valU3ST.getText().toString());
                        }
                        if (valU4ST.getText().toString().matches("") && cant4ST.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4ST.getText().toString()) * Integer.parseInt(valU4ST.getText().toString());
                        }

                        if (fuentePs1ST.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1ST.getText().toString());
                        }
                        if (fuentePs2ST.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2ST.getText().toString());
                        }
                        if (fuentePs3ST.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3ST.getText().toString());
                        }
                        if (fuentePs4ST.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4ST.getText().toString());
                        }

                        if (fuenteHogar1ST.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1ST.getText().toString());
                        }
                        if (fuenteHogar2ST.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2ST.getText().toString());
                        }
                        if (fuenteHogar3ST.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3ST.getText().toString());
                        }
                        if (fuenteHogar4ST.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4ST.getText().toString());
                        }

                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + Integer.parseInt(cant5ST.getText().toString()) * Integer.parseInt(valU5ST.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + Integer.parseInt(fuentePs5ST.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + Integer.parseInt(fuenteHogar5ST.getText().toString());
                        } catch (Exception e) {
                        }
                        totalST.setText(String.valueOf(GT));
                        total_psST.setText(String.valueOf(GT_PS));
                        total_hogarST.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5ST", "");
                        editorRD.putString("valT5ST", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C5_1:

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();

                if (cant5_1ST.getText().toString().matches("") || valU5_1ST.getText().toString().matches("")) {
                    Toast.makeText(SegTrabajo.this, "Revise que este todo completo", Toast.LENGTH_LONG).show();
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorT5 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorPS5 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0, valorHogar5 = 0;
                    if (!valU5_1ST.getText().toString().matches("")) {
                        valT5_1ST.setText(String.valueOf(Integer.parseInt(cant5_1ST.getText().toString()) * Integer.parseInt(valU5_1ST.getText().toString())));

                        editor.putString("valT5_1ST", valT5_1ST.getText().toString());
                        editorRD.putString("valT5_1ST", valT5_1ST.getText().toString());

                        if (valU1ST.getText().toString().matches("") && cant1ST.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1ST.getText().toString()) * Integer.parseInt(valU1ST.getText().toString());
                        }
                        if (valU2ST.getText().toString().matches("") && cant2ST.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2ST.getText().toString()) * Integer.parseInt(valU2ST.getText().toString());
                        }
                        if (valU3ST.getText().toString().matches("") && cant3ST.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3ST.getText().toString()) * Integer.parseInt(valU3ST.getText().toString());
                        }
                        if (valU4ST.getText().toString().matches("") && cant4ST.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4ST.getText().toString()) * Integer.parseInt(valU4ST.getText().toString());
                        }
                        if (valU5ST.getText().toString().matches("") && cant5ST.getText().toString().matches("")) {
                            valorT5 = 0;
                        } else {
                            valorT5 = Integer.parseInt(cant5ST.getText().toString()) * Integer.parseInt(valU5ST.getText().toString());
                        }

                        if (fuentePs1ST.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1ST.getText().toString());
                        }
                        if (fuentePs2ST.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2ST.getText().toString());
                        }
                        if (fuentePs3ST.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3ST.getText().toString());
                        }
                        if (fuentePs4ST.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4ST.getText().toString());
                        }
                        if (fuentePs5ST.getText().toString().matches("")) {
                            valorPS5 = 0;
                        } else {
                            valorPS5 = Integer.parseInt(fuentePs5ST.getText().toString());
                        }

                        if (fuenteHogar1ST.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1ST.getText().toString());
                        }
                        if (fuenteHogar2ST.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2ST.getText().toString());
                        }
                        if (fuenteHogar3ST.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3ST.getText().toString());
                        }
                        if (fuenteHogar4ST.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4ST.getText().toString());
                        }
                        if (fuenteHogar5ST.getText().toString().matches("")) {
                            valorHogar5 = 0;
                        } else {
                            valorHogar5 = Integer.parseInt(fuenteHogar5ST.getText().toString());
                        }


                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + valorT5 + Integer.parseInt(cant5_1ST.getText().toString()) * Integer.parseInt(valU5_1ST.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + valorPS5 + Integer.parseInt(fuentePs5_1ST.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + valorHogar5 + Integer.parseInt(fuenteHogar5_1ST.getText().toString());
                        } catch (Exception e) {
                        }
                        totalST.setText(String.valueOf(GT));
                        total_psST.setText(String.valueOf(GT_PS));
                        total_hogarST.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5_1ST", "");
                        editorRD.putString("valT5_1ST", "");
                    }
                    editor.putString("ver5_1ST", ver5_1ST.getSelectedItem().toString());
                    editorRD.putString("ver5_1ST", ver5_1ST.getSelectedItem().toString());
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
