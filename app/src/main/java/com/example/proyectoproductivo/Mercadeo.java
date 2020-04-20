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

public class Mercadeo extends AppCompatActivity {

    EditText con5MER, con5_1MER, cant1MER, cant2MER, cant3MER, cant4MER, cant5MER, cant5_1MER, valU1MER, valU2MER, valU3MER, valU4MER, valU5MER, valU5_1MER;
    EditText valT1MER, valT2MER, valT3MER, valT4MER, valT5MER, valT5_1MER, fuentePs1MER, fuentePs2MER, fuentePs3MER, fuentePs4MER, fuentePs5MER, fuentePs5_1MER, fuenteHogar1MER, fuenteHogar2MER, fuenteHogar3MER, fuenteHogar4MER, fuenteHogar5MER, fuenteHogar5_1MER;
    EditText totalMER, total_psMER, total_hogarMER;//total_verifMER;
    AppCompatSpinner ver1MER, ver2MER, ver3MER, ver4MER, ver5MER, ver5_1MER, undM1MER, undM2MER, undM3MER, undM4MER, undM5MER, undM5_1MER;
    Spinner con1MER, con2MER, con3MER, con4MER;
    TextView VSug1, VSug2, VSug3, VSug4;
    int GT, GT_PS, GT_HOG;
    String ShaPreSector;
    ArrayAdapter<String> dataAdapterS_A, dataAdapterS_A_peces, dataAdapterS_A_cerdos, dataAdapterS_A_bovino, dataAdapterS_A_aves_corral, dataAdapterS_C_restaurante, dataAdapterS_G_comercio, dataAdapterS_G_papeleria, dataAdapterS_G_ropa, dataAdapterS_S_peluqueria, dataAdapterOtros;
    HashMap<String, String> hm = new HashMap<String, String>();
    BottomNavigationView btnNV;
    private SharedPreferences sharedPreferences, sharedPreferencesRD, dataEncuenta;
    SharedPreferences.Editor editor, editorRD;
    Button ItemAdicional;
    ExpandableWeightLayout expandableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercadeo);
        ItemAdicional = findViewById(R.id.expandButton);
        ItemAdicional.setText("Tiene un insumo adicional? " + Character.toString((char) 9660) + " ");
        expandableLayout
                = (ExpandableWeightLayout) findViewById(R.id.expandableLayout);
        btnNV = findViewById(R.id.navigationView);
        con1MER = findViewById(R.id.CON1MER);
        con2MER = findViewById(R.id.CON2MER);
        con3MER = findViewById(R.id.CON3MER);
        con4MER = findViewById(R.id.CON4MER);
        con5MER = findViewById(R.id.CON5MER);
        con5_1MER = findViewById(R.id.CON5_1MER);
        cant1MER = findViewById(R.id.CAN1MER);
        cant2MER = findViewById(R.id.CAN2MER);
        cant3MER = findViewById(R.id.CAN3MER);
        cant4MER = findViewById(R.id.CAN4MER);
        cant5MER = findViewById(R.id.CAN5MER);
        cant5_1MER = findViewById(R.id.CAN5_1MER);
        undM1MER = findViewById(R.id.UM1MER);
        undM2MER = findViewById(R.id.UM2MER);
        undM3MER = findViewById(R.id.UM3MER);
        undM4MER = findViewById(R.id.UM4MER);
        undM5MER = findViewById(R.id.UM5MER);
        undM5_1MER = findViewById(R.id.UM5_1MER);
        valU1MER = findViewById(R.id.VU1MER);
        valU2MER = findViewById(R.id.VU2MER);
        valU3MER = findViewById(R.id.VU3MER);
        valU4MER = findViewById(R.id.VU4MER);
        valU5MER = findViewById(R.id.VU5MER);
        valU5_1MER = findViewById(R.id.VU5_1MER);
        ver1MER = findViewById(R.id.VERF1MER);
        ver2MER = findViewById(R.id.VERF2MER);
        ver3MER = findViewById(R.id.VERF3MER);
        ver4MER = findViewById(R.id.VERF4MER);
        ver5MER = findViewById(R.id.VERF5MER);
        ver5_1MER = findViewById(R.id.VERF5_1MER);
        valT1MER = findViewById(R.id.VT1MER);
        valT2MER = findViewById(R.id.VT2MER);
        valT3MER = findViewById(R.id.VT3MER);
        valT4MER = findViewById(R.id.VT4MER);
        valT5MER = findViewById(R.id.VT5MER);
        valT5_1MER = findViewById(R.id.VT5_1MER);
        fuentePs1MER = findViewById(R.id.PS1MER);
        fuentePs2MER = findViewById(R.id.PS2MER);
        fuentePs3MER = findViewById(R.id.PS3MER);
        fuentePs4MER = findViewById(R.id.PS4MER);
        fuentePs5MER = findViewById(R.id.PS5MER);
        fuentePs5_1MER = findViewById(R.id.PS5_1MER);
        fuenteHogar1MER = findViewById(R.id.HO1MER);
        fuenteHogar2MER = findViewById(R.id.HO2MER);
        fuenteHogar3MER = findViewById(R.id.HO3MER);
        fuenteHogar4MER = findViewById(R.id.HO4MER);
        fuenteHogar5MER = findViewById(R.id.HO5MER);
        fuenteHogar5_1MER = findViewById(R.id.HO5_1MER);
        VSug1 = findViewById(R.id.VSug1MER);
        VSug2 = findViewById(R.id.VSug2MER);
        VSug3 = findViewById(R.id.VSug3MER);
        VSug4 = findViewById(R.id.VSug4MER);
        totalMER = findViewById(R.id.TOTAL_MER);
        total_psMER = findViewById(R.id.TOTAL_PS_MER);
        total_hogarMER = findViewById(R.id.TOTAL_HOGAR_MER);//total_verifMER=findViewById(R.id.TOTAL_VERIFICACION_MER);
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
        undM1MER.setAdapter(adapterUM);
        undM2MER.setAdapter(adapterUM);
        undM3MER.setAdapter(adapterUM);
        undM4MER.setAdapter(adapterUM);

        ShaPreSector = sharedPreferences.getString("codSector", "");
        //      Toast.makeText(this, ""+sharedPreferences.getString("codSector",""), Toast.LENGTH_SHORT).show();
        List<String> list_Sec_A = new ArrayList<String>();
        list_Sec_A.add("Seleccione......");
        list_Sec_A.add("CANASTILLAS");
        list_Sec_A.add("COSTALES");
        list_Sec_A.add("GUACALES");
        list_Sec_A.add("EMPAQUES");
        List<String> list_Sec_A_peces = new ArrayList<String>();
        list_Sec_A_peces.add("Seleccione......");
        list_Sec_A_peces.add("AVISO");
        list_Sec_A_peces.add("PERIFONEO");
        list_Sec_A_peces.add("BOLSAS");
        List<String> list_Sec_A_cerdos = new ArrayList<String>();

        list_Sec_A_cerdos.add("Seleccione......");
        list_Sec_A_cerdos.add("ARETES GANADO PORCINO");
        list_Sec_A_cerdos.add("AVISO");
        list_Sec_A_cerdos.add("PERIFONEO");

        List<String> list_Sec_A_bovino = new ArrayList<String>();

        list_Sec_A_bovino.add("Seleccione......");
        list_Sec_A_bovino.add("BOTELLAS");
        list_Sec_A_bovino.add("AVISO");
        list_Sec_A_bovino.add("PERIFONEO");
        List<String> list_Sec_A_aves_corral = new ArrayList<String>();
        list_Sec_A_aves_corral.add("Seleccione......");
        list_Sec_A_aves_corral.add("CUBETAS");
        list_Sec_A_aves_corral.add("JAULAS");
        List<String> list_Sec_C_restaurante = new ArrayList<String>();

        list_Sec_C_restaurante.add("Seleccione......");
        list_Sec_C_restaurante.add("AVISO");
        list_Sec_C_restaurante.add("CARTELES");
        list_Sec_C_restaurante.add("PERIFONEO");
        List<String> list_Sec_G_comercio = new ArrayList<String>();
        list_Sec_G_comercio.add("Seleccione......");//FRUVER    AVISOS?
        list_Sec_G_comercio.add("AVISO");
        list_Sec_G_comercio.add("PERIFONEO");
        list_Sec_G_comercio.add("VOLANTES");
        List<String> list_Sec_G_papeleria = new ArrayList<String>();
        list_Sec_G_papeleria.add("Seleccione......");
        list_Sec_G_papeleria.add("AVISO");
        list_Sec_G_papeleria.add("PERIFONEO");
        list_Sec_G_papeleria.add("VOLANTES");
        List<String> list_Sec_G_ropa = new ArrayList<String>();
        list_Sec_G_ropa.add("Seleccione......");
        list_Sec_G_ropa.add("AVISO");
        list_Sec_G_ropa.add("VOLANTES");
        list_Sec_G_ropa.add("PERIFONEO");
        List<String> list_Sec_S_peluqueria = new ArrayList<String>();
        list_Sec_S_peluqueria.add("Seleccione......");
        list_Sec_S_peluqueria.add("AVISO");
        list_Sec_S_peluqueria.add("VOLANTES");
        list_Sec_S_peluqueria.add("PERIFONEO");
        List<String> list_Otros = new ArrayList<String>();  //mio 25 marzo
        list_Otros.add("Seleccione......");
        list_Otros.add("CANASTILLAS");
        list_Otros.add("COSTALES");
        list_Otros.add("GUACALES");
        list_Otros.add("EMPAQUES");
        list_Otros.add("AVISO");
        list_Otros.add("BOLSAS");
        list_Otros.add("ARETES GANADO PORCINO");
        list_Otros.add("PERIFONEO");
        list_Otros.add("ARETES GANADO PORCINO");
        list_Otros.add("BOLSAS");
        list_Otros.add("ARETES GANADO PORCINO");
        list_Otros.add("VOLANTES");
        list_Otros.add("BOTELLAS");
        list_Otros.add("BOLSAS");
        list_Otros.add("CUBETAS");
        list_Otros.add("CARTELES");
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
            con1MER.setAdapter(dataAdapterS_A_peces);
            con2MER.setAdapter(dataAdapterS_A_peces);
            con3MER.setAdapter(dataAdapterS_A_peces);
            con4MER.setAdapter(dataAdapterS_A_peces);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0144")) {
            con1MER.setAdapter(dataAdapterS_A_cerdos);
            con2MER.setAdapter(dataAdapterS_A_cerdos);
            con3MER.setAdapter(dataAdapterS_A_cerdos);
            con4MER.setAdapter(dataAdapterS_A_cerdos);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0145")) {
            con1MER.setAdapter(dataAdapterS_A_aves_corral);
            con2MER.setAdapter(dataAdapterS_A_aves_corral);
            con3MER.setAdapter(dataAdapterS_A_aves_corral);
            con4MER.setAdapter(dataAdapterS_A_aves_corral);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0141")) {
            con1MER.setAdapter(dataAdapterS_A_bovino);
            con2MER.setAdapter(dataAdapterS_A_bovino);
            con3MER.setAdapter(dataAdapterS_A_bovino);
            con4MER.setAdapter(dataAdapterS_A_bovino);
        } else if (ShaPreSector.equals("SECCION A")) {
            con1MER.setAdapter(dataAdapterS_A);
            con2MER.setAdapter(dataAdapterS_A);
            con3MER.setAdapter(dataAdapterS_A);
            con4MER.setAdapter(dataAdapterS_A);
        }

        if (ShaPreSector.equals("SECCION C")) {
            con1MER.setAdapter(dataAdapterS_C_restaurante);
            con2MER.setAdapter(dataAdapterS_C_restaurante);
            con3MER.setAdapter(dataAdapterS_C_restaurante);
            con4MER.setAdapter(dataAdapterS_C_restaurante);
        } //


        if (ShaPreSector.equals("SECCION G") && (sharedPreferences.getString("codAct", "").substring(0, 3).equals("471") || sharedPreferences.getString("codAct", "").substring(0, 3).equals("472") || sharedPreferences.getString("codAct", "").equals("4781"))) {
            con1MER.setAdapter(dataAdapterS_G_comercio);
            con2MER.setAdapter(dataAdapterS_G_comercio);
            con3MER.setAdapter(dataAdapterS_G_comercio);
            con4MER.setAdapter(dataAdapterS_G_comercio);
        } //47
        else if (ShaPreSector.equals("SECCION G") && sharedPreferences.getString("codAct", "").substring(0, 2).equals("46")) {
            con1MER.setAdapter(dataAdapterS_G_ropa);
            con2MER.setAdapter(dataAdapterS_G_ropa);
            con3MER.setAdapter(dataAdapterS_G_ropa);
            con4MER.setAdapter(dataAdapterS_G_ropa);
        } else if (ShaPreSector.equals("SECCION G") && (sharedPreferences.getString("codAct", "").substring(0, 3).equals("479") || sharedPreferences.getString("codAct", "").equals("4789") || sharedPreferences.getString("codAct", "").equals("4782"))) {
            con1MER.setAdapter(dataAdapterS_G_papeleria);
            con2MER.setAdapter(dataAdapterS_G_papeleria);
            con3MER.setAdapter(dataAdapterS_G_papeleria);
            con4MER.setAdapter(dataAdapterS_G_papeleria);
        } else if (ShaPreSector.equals("SECCION G")) {
            con1MER.setAdapter(dataAdapterOtros);
            con2MER.setAdapter(dataAdapterOtros);
            con3MER.setAdapter(dataAdapterOtros);
            con4MER.setAdapter(dataAdapterOtros);
        }


        if (ShaPreSector.equals("SECCION S")) {
            con1MER.setAdapter(dataAdapterS_S_peluqueria);
            con2MER.setAdapter(dataAdapterS_S_peluqueria);
            con3MER.setAdapter(dataAdapterS_S_peluqueria);
            con4MER.setAdapter(dataAdapterS_S_peluqueria);
        } //
        if (ShaPreSector.equals("SECCION B") || ShaPreSector.equals("SECCION D") || ShaPreSector.equals("SECCION E") || ShaPreSector.equals("SECCION F") || ShaPreSector.equals("SECCION H") || ShaPreSector.equals("SECCION I") || ShaPreSector.equals("SECCION J") || ShaPreSector.equals("SECCION Q") || ShaPreSector.equals("SECCION R") || ShaPreSector.equals("SECCION T")) {
            con1MER.setAdapter(dataAdapterOtros);
            con2MER.setAdapter(dataAdapterOtros);
            con3MER.setAdapter(dataAdapterOtros);
            con4MER.setAdapter(dataAdapterOtros);
        }

        undM1MER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM1MER", posicionUM);
                editorRD.commit();
                editor.putString("undM1MER", undM1MER.getSelectedItem().toString());
                editor.commit();
                if (!con1MER.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU1MER.setHint("Sugerido:"+hm.get(con1MER.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con1MER.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug1.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM2MER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM2MER", posicionUM);
                editorRD.commit();
                editor.putString("undM2MER", undM2MER.getSelectedItem().toString());
                editor.commit();
                if (!con2MER.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU2MER.setHint("Sugerido:"+hm.get(con2MER.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con2MER.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug2.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM3MER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM3MER", posicionUM);
                editorRD.commit();
                editor.putString("undM3MER", undM3MER.getSelectedItem().toString());
                editor.commit();
                if (!con3MER.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU3MER.setHint("Sugerido:"+hm.get(con3MER.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con3MER.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug3.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM4MER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM4MER", posicionUM);
                editorRD.commit();
                editor.putString("undM4MER", undM4MER.getSelectedItem().toString());
                editor.commit();
                if (!con4MER.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU4MER.setHint("Sugerido:"+hm.get(con4MER.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con4MER.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug4.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        undM5MER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM5MER", posicionUM);
                editorRD.commit();
                editor.putString("undM5MER", undM5MER.getSelectedItem().toString());
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        undM5_1MER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                editorRD.putInt("undM5_1MER", posicionUM);
                editorRD.commit();
                editor.putString("undM5_1MER", undM5_1MER.getSelectedItem().toString());
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ver1MER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver1MER", ver1MER.getSelectedItem().toString());
                editorRD.putString("ver1MER", ver1MER.getSelectedItem().toString());
                if (cant1MER.getText().toString().matches("")) {
                } else {

                    if (!valU1MER.getText().toString().matches("")) {
                        valT1MER.setText(String.valueOf(Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString())));
                        try {
                            GT = Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString()) + 0 + 0 + 0;
                            GT_PS = Integer.parseInt(fuentePs1MER.getText().toString());
                            GT_HOG = Integer.parseInt(fuenteHogar1MER.getText().toString());
                        } catch (Exception e) {
                        }
                        totalMER.setText(String.valueOf(GT));
                        total_psMER.setText(String.valueOf(GT_PS));
                        total_hogarMER.setText(String.valueOf(GT_HOG));
                        editor.putString("valT1MER", valT1MER.getText().toString());
                        editorRD.putString("valT1MER", valT1MER.getText().toString());
                    } else {
                        editor.putString("valT1MER", "");
                        editorRD.putString("valT1MER", "");
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

        ver2MER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver2MER", ver2MER.getSelectedItem().toString());
                editorRD.putString("ver2MER", ver2MER.getSelectedItem().toString());
                if (!cant2MER.getText().toString().matches("") && !cant1MER.getText().toString().matches("") && !valU2MER.getText().toString().matches("") && !valU1MER.getText().toString().matches("")) {
                    valT2MER.setText(String.valueOf(Integer.parseInt(cant2MER.getText().toString()) * Integer.parseInt(valU2MER.getText().toString())));
                    try {
                        GT = Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString()) + Integer.parseInt(cant2MER.getText().toString()) * Integer.parseInt(valU2MER.getText().toString()) + 0 + 0;
                        GT_PS = Integer.parseInt(fuentePs1MER.getText().toString()) + Integer.parseInt(fuentePs2MER.getText().toString());
                        GT_HOG = Integer.parseInt(fuenteHogar1MER.getText().toString()) + Integer.parseInt(fuenteHogar2MER.getText().toString());
                    } catch (Exception e) {
                    }
                    totalMER.setText(String.valueOf(GT));
                    total_psMER.setText(String.valueOf(GT_PS));
                    total_hogarMER.setText(String.valueOf(GT_HOG));
                    editor.putString("valT2MER", valT2MER.getText().toString());
                    editorRD.putString("valT2MER", valT2MER.getText().toString());
                } else {
                    Toast.makeText(Mercadeo.this, "Complete todos los datos del 2do recuadro.", Toast.LENGTH_SHORT).show();
                    editor.putString("valT2MER", "");
                    editorRD.putString("valT2MER", "");
                }
                editor.commit();
                editorRD.commit();
                //        Toast.makeText(ACTFijos.this, sharedPreferencesRD.getString("valT1CT", ""), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ver3MER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver3MER", ver3MER.getSelectedItem().toString());
                editorRD.putString("ver3MER", ver3MER.getSelectedItem().toString());
                if (cant3MER.getText().toString().matches("") || valU3MER.getText().toString().matches("")) {
                    Toast.makeText(Mercadeo.this, "Complete todos los datos del 3er recuadro.", Toast.LENGTH_LONG).show();

                } else {

                    if (!valU3MER.getText().toString().matches("")) {
                        valT3MER.setText(String.valueOf(Integer.parseInt(cant3MER.getText().toString()) * Integer.parseInt(valU3MER.getText().toString())));
                        editor.putString("valT3MER", valT3MER.getText().toString());
                        editorRD.putString("valT3MER", valT3MER.getText().toString());
                        if (!valU2MER.getText().toString().matches("") && !cant2MER.getText().toString().matches("")) {
                            try {
                                GT = Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString()) + Integer.parseInt(cant2MER.getText().toString()) * Integer.parseInt(valU2MER.getText().toString()) + Integer.parseInt(cant3MER.getText().toString()) * Integer.parseInt(valU3MER.getText().toString()) + 0;
                                GT_PS = Integer.parseInt(fuentePs1MER.getText().toString()) + Integer.parseInt(fuentePs2MER.getText().toString()) + Integer.parseInt(fuentePs3MER.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1MER.getText().toString()) + Integer.parseInt(fuenteHogar2MER.getText().toString()) + Integer.parseInt(fuenteHogar3MER.getText().toString());
                            } catch (Exception e) {
                            }
                            totalMER.setText(String.valueOf(GT));
                            total_psMER.setText(String.valueOf(GT_PS));
                            total_hogarMER.setText(String.valueOf(GT_HOG));
                        }
                    } else {
                        editor.putString("valT3MER", "");
                        editorRD.putString("valT3MER", "");
                    }
                    editor.commit();
                    editorRD.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });

        ver4MER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver4MER", ver4MER.getSelectedItem().toString());
                editorRD.putString("ver4MER", ver4MER.getSelectedItem().toString());
                if (cant4MER.getText().toString().matches("") || valU4MER.getText().toString().matches("")) {
                    Toast.makeText(Mercadeo.this, "Complete todos los datos del 4to recuadro.", Toast.LENGTH_LONG).show();
                } else {

                    if (!valU4MER.getText().toString().matches("")) {
                        valT4MER.setText(String.valueOf(Integer.parseInt(cant4MER.getText().toString()) * Integer.parseInt(valU4MER.getText().toString())));

                        editor.putString("valT4MER", valT4MER.getText().toString());
                        editorRD.putString("valT4MER", valT4MER.getText().toString());
                        if (!valU2MER.getText().toString().matches("") && !valU3MER.getText().toString().matches("") && !cant2MER.getText().toString().matches("") && !cant3MER.getText().toString().matches("")) {

                            try {
                                GT = Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString()) + Integer.parseInt(cant2MER.getText().toString()) * Integer.parseInt(valU2MER.getText().toString()) + Integer.parseInt(cant3MER.getText().toString()) * Integer.parseInt(valU3MER.getText().toString()) + Integer.parseInt(cant4MER.getText().toString()) * Integer.parseInt(valU4MER.getText().toString());
                                GT_PS = Integer.parseInt(fuentePs1MER.getText().toString()) + Integer.parseInt(fuentePs2MER.getText().toString()) + Integer.parseInt(fuentePs3MER.getText().toString()) + Integer.parseInt(fuentePs4MER.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1MER.getText().toString()) + Integer.parseInt(fuenteHogar2MER.getText().toString()) + Integer.parseInt(fuenteHogar3MER.getText().toString()) + Integer.parseInt(fuenteHogar4MER.getText().toString());
                            } catch (Exception e) {
                            }
                            totalMER.setText(String.valueOf(GT));
                            total_psMER.setText(String.valueOf(GT_PS));
                            total_hogarMER.setText(String.valueOf(GT_HOG));

                        }
                    } else {
                        editor.putString("valT4MER", "");
                        editorRD.putString("valT4MER", "");
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
        ver5MER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Mercadeo.this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver5MER", ver5MER.getSelectedItem().toString());
                editorRD.putString("ver5MER", ver5MER.getSelectedItem().toString());
                if (cant5MER.getText().toString().matches("")) {
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0;
                    if (!valU5MER.getText().toString().matches("")) {
                        valT5MER.setText(String.valueOf(Integer.parseInt(cant5MER.getText().toString()) * Integer.parseInt(valU5MER.getText().toString())));

                        editor.putString("valT5MER", valT5MER.getText().toString());
                        editorRD.putString("valT5MER", valT5MER.getText().toString());

                        if (valU1MER.getText().toString().matches("") && cant1MER.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString());
                        }
                        if (valU2MER.getText().toString().matches("") && cant2MER.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2MER.getText().toString()) * Integer.parseInt(valU2MER.getText().toString());
                        }
                        if (valU3MER.getText().toString().matches("") && cant3MER.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3MER.getText().toString()) * Integer.parseInt(valU3MER.getText().toString());
                        }
                        if (valU4MER.getText().toString().matches("") && cant4MER.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4MER.getText().toString()) * Integer.parseInt(valU4MER.getText().toString());
                        }

                        if (fuentePs1MER.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1MER.getText().toString());
                        }
                        if (fuentePs2MER.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2MER.getText().toString());
                        }
                        if (fuentePs3MER.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3MER.getText().toString());
                        }
                        if (fuentePs4MER.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4MER.getText().toString());
                        }

                        if (fuenteHogar1MER.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1MER.getText().toString());
                        }
                        if (fuenteHogar2MER.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2MER.getText().toString());
                        }
                        if (fuenteHogar3MER.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3MER.getText().toString());
                        }
                        if (fuenteHogar4MER.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4MER.getText().toString());
                        }

                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + Integer.parseInt(cant5MER.getText().toString()) * Integer.parseInt(valU5MER.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + Integer.parseInt(fuentePs5MER.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + Integer.parseInt(fuenteHogar5MER.getText().toString());
                        } catch (Exception e) {
                        }
                        totalMER.setText(String.valueOf(GT));
                        total_psMER.setText(String.valueOf(GT_PS));
                        total_hogarMER.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5MER", "");
                        editorRD.putString("valT5MER", "");
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
        ver5_1MER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();

                if (cant5_1MER.getText().toString().matches("") || valU5_1MER.getText().toString().matches("")) {
                    Toast.makeText(Mercadeo.this, "Revise que este todo completo", Toast.LENGTH_LONG).show();
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorT5 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorPS5 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0, valorHogar5 = 0;
                    if (!valU5_1MER.getText().toString().matches("")) {
                        valT5_1MER.setText(String.valueOf(Integer.parseInt(cant5_1MER.getText().toString()) * Integer.parseInt(valU5_1MER.getText().toString())));

                        editor.putString("valT5_1MER", valT5_1MER.getText().toString());
                        editorRD.putString("valT5_1MER", valT5_1MER.getText().toString());

                        if (valU1MER.getText().toString().matches("") && cant1MER.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString());
                        }
                        if (valU2MER.getText().toString().matches("") && cant2MER.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2MER.getText().toString()) * Integer.parseInt(valU2MER.getText().toString());
                        }
                        if (valU3MER.getText().toString().matches("") && cant3MER.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3MER.getText().toString()) * Integer.parseInt(valU3MER.getText().toString());
                        }
                        if (valU4MER.getText().toString().matches("") && cant4MER.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4MER.getText().toString()) * Integer.parseInt(valU4MER.getText().toString());
                        }
                        if (valU5MER.getText().toString().matches("") && cant5MER.getText().toString().matches("")) {
                            valorT5 = 0;
                        } else {
                            valorT5 = Integer.parseInt(cant5MER.getText().toString()) * Integer.parseInt(valU5MER.getText().toString());
                        }

                        if (fuentePs1MER.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1MER.getText().toString());
                        }
                        if (fuentePs2MER.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2MER.getText().toString());
                        }
                        if (fuentePs3MER.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3MER.getText().toString());
                        }
                        if (fuentePs4MER.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4MER.getText().toString());
                        }
                        if (fuentePs5MER.getText().toString().matches("")) {
                            valorPS5 = 0;
                        } else {
                            valorPS5 = Integer.parseInt(fuentePs5MER.getText().toString());
                        }

                        if (fuenteHogar1MER.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1MER.getText().toString());
                        }
                        if (fuenteHogar2MER.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2MER.getText().toString());
                        }
                        if (fuenteHogar3MER.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3MER.getText().toString());
                        }
                        if (fuenteHogar4MER.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4MER.getText().toString());
                        }
                        if (fuenteHogar5MER.getText().toString().matches("")) {
                            valorHogar5 = 0;
                        } else {
                            valorHogar5 = Integer.parseInt(fuenteHogar5MER.getText().toString());
                        }


                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + valorT5 + Integer.parseInt(cant5_1MER.getText().toString()) * Integer.parseInt(valU5_1MER.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + valorPS5 + Integer.parseInt(fuentePs5_1MER.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + valorHogar5 + Integer.parseInt(fuenteHogar5_1MER.getText().toString());
                        } catch (Exception e) {
                        }
                        totalMER.setText(String.valueOf(GT));
                        total_psMER.setText(String.valueOf(GT_PS));
                        total_hogarMER.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5_1MER", "");
                        editorRD.putString("valT5_1MER", "");
                    }
                    editor.putString("ver5_1MER", ver5_1MER.getSelectedItem().toString());
                    editorRD.putString("ver5_1MER", ver5_1MER.getSelectedItem().toString());
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
                        // Mercadeo.super.onBackPressed();
                        Intent intent = new Intent(Mercadeo.this, Inversion.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        // revisar             intent.putExtra("encuestas",sharedPreferences.getString("datosver", ""));
                        startActivity(intent);
                    }
                    break;
                    case R.id.next: {
                        //  SharedPreferences.Editor editor = sharedPreferences.edit();
                        //       editor.clear();editor.commit();

                        if (con1MER.getSelectedItem().toString().matches("Seleccione......") || cant1MER.getText().toString().matches("")
                                || valT1MER.getText().toString().matches("") || fuentePs1MER.getText().toString().matches("")
                                || fuenteHogar1MER.getText().toString().matches("") || totalMER.getText().toString().matches("")) {
                            Toast.makeText(Mercadeo.this, "Llene todos los campos, la seccion de Totales (abajo)", Toast.LENGTH_LONG).show();
                        } else {
                            // revisar               editor.putString("CC", editTextCC.getText().toString());
                            //       Toast.makeText(MainActivity.this, ""+nombre.getText().toString(), Toast.LENGTH_SHORT).show();
             /*               if(tipoProyec.getText()!=null) {

                                editor.putString("tipoP", tipoProyec.getText().toString());

                                //Toast.makeText(MainActivity.this, "no tiene segundo nombre", Toast.LENGTH_SHORT).show();
                            }
 */

                            editor.putString("con1MER", con1MER.getSelectedItem().toString());
                            if (con2MER.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con2MER", "");
                            } else {
                                editor.putString("con2MER", con2MER.getSelectedItem().toString());
                            }
                            if (con3MER.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con3MER", "");
                            } else {
                                editor.putString("con3MER", con3MER.getSelectedItem().toString());
                            }
                            if (con4MER.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con4MER", "");
                            } else {
                                editor.putString("con4MER", con4MER.getSelectedItem().toString());
                            }
                            if (con5MER.getText().toString().matches("")) {
                                editor.putString("con5MER", "");
                            } else {
                                editor.putString("con5MER", con5MER.getText().toString());
                            }
                            if (con5_1MER.getText().toString().matches("")) {
                                editor.putString("con5_1MER", "");
                            } else {
                                editor.putString("con5_1MER", con5_1MER.getText().toString());
                            }

                            if (cant1MER.getText().toString().matches("")) {
                                editor.putString("cant1MER", "");
                            } else {
                                editor.putString("cant1MER", cant1MER.getText().toString());
                            }
                            if (cant2MER.getText().toString().matches("")) {
                                editor.putString("cant2MER", "");
                            } else {
                                editor.putString("cant2MER", cant2MER.getText().toString());
                            }
                            if (cant3MER.getText().toString().matches("")) {
                                editor.putString("cant3MER", "");
                            } else {
                                editor.putString("cant3MER", cant3MER.getText().toString());
                            }
                            if (cant4MER.getText().toString().matches("")) {
                                editor.putString("cant4MER", "");
                            } else {
                                editor.putString("cant4MER", cant4MER.getText().toString());
                            }
                            if (cant5MER.getText().toString().matches("")) {
                                editor.putString("cant5MER", "");
                            } else {
                                editor.putString("cant5MER", cant5MER.getText().toString());
                            }
                            if (cant5_1MER.getText().toString().matches("")) {
                                editor.putString("cant5_1MER", "");
                            } else {
                                editor.putString("cant5_1MER", cant5_1MER.getText().toString());
                            }

                            if (valU1MER.getText().toString().matches("")) {
                                editor.putString("valU1MER", "");
                            } else {
                                editor.putString("valU1MER", valU1MER.getText().toString());
                            }
                            if (valU2MER.getText().toString().matches("")) {
                                editor.putString("valU2MER", "");
                            } else {
                                editor.putString("valU2MER", valU2MER.getText().toString());
                            }
                            if (valU3MER.getText().toString().matches("")) {
                                editor.putString("valU3MER", "");
                            } else {
                                editor.putString("valU3MER", valU3MER.getText().toString());
                            }
                            if (valU4MER.getText().toString().matches("")) {
                                editor.putString("valU4MER", "");
                            } else {
                                editor.putString("valU4MER", valU4MER.getText().toString());
                            }
                            if (valU5MER.getText().toString().matches("")) {
                                editor.putString("valU5MER", "");
                            } else {
                                editor.putString("valU5MER", valU5MER.getText().toString());
                            }
                            if (valU5_1MER.getText().toString().matches("")) {
                                editor.putString("valU5_1MER", "");
                            } else {
                                editor.putString("valU5_1MER", valU5_1MER.getText().toString());
                            }


                            if (fuentePs1MER.getText().toString().matches("")) {
                                editor.putString("fuentePs1MER", "");
                            } else {
                                editor.putString("fuentePs1MER", fuentePs1MER.getText().toString());
                            }
                            if (fuentePs2MER.getText().toString().matches("")) {
                                editor.putString("fuentePs2MER", "");
                            } else {
                                editor.putString("fuentePs2MER", fuentePs2MER.getText().toString());
                            }
                            if (fuentePs3MER.getText().toString().matches("")) {
                                editor.putString("fuentePs3MER", "");
                            } else {
                                editor.putString("fuentePs3MER", fuentePs3MER.getText().toString());
                            }
                            if (fuentePs4MER.getText().toString().matches("")) {
                                editor.putString("fuentePs4MER", "");
                            } else {
                                editor.putString("fuentePs4MER", fuentePs4MER.getText().toString());
                            }
                            if (fuentePs5MER.getText().toString().matches("")) {
                                editor.putString("fuentePs5MER", "");
                            } else {
                                editor.putString("fuentePs5MER", fuentePs5MER.getText().toString());
                            }
                            if (fuentePs5_1MER.getText().toString().matches("")) {
                                editor.putString("fuentePs5_1MER", "");
                            } else {
                                editor.putString("fuentePs5_1MER", fuentePs5_1MER.getText().toString());
                            }
                            if (fuenteHogar1MER.getText().toString().matches("")) {
                                editor.putString("fuenteHogar1MER", "");
                            } else {
                                editor.putString("fuenteHogar1MER", fuenteHogar1MER.getText().toString());
                            }
                            if (fuenteHogar2MER.getText().toString().matches("")) {
                                editor.putString("fuenteHogar2MER", "");
                            } else {
                                editor.putString("fuenteHogar2MER", fuenteHogar2MER.getText().toString());
                            }
                            if (fuenteHogar3MER.getText().toString().matches("")) {
                                editor.putString("fuenteHogar3MER", "");
                            } else {
                                editor.putString("fuenteHogar3MER", fuenteHogar3MER.getText().toString());
                            }
                            if (fuenteHogar4MER.getText().toString().matches("")) {
                                editor.putString("fuenteHogar4MER", "");
                            } else {
                                editor.putString("fuenteHogar4MER", fuenteHogar4MER.getText().toString());
                            }
                            if (fuenteHogar5MER.getText().toString().matches("")) {
                                editor.putString("fuenteHogar5MER", "");
                            } else {
                                editor.putString("fuenteHogar5MER", fuenteHogar5MER.getText().toString());
                            }
                            if (fuenteHogar5_1MER.getText().toString().matches("")) {
                                editor.putString("fuenteHogar5_1MER", "");
                            } else {
                                editor.putString("fuenteHogar5_1MER", fuenteHogar5_1MER.getText().toString());
                            }
                            if (totalMER.getText().toString().matches("")) {
                                editor.putString("totalMER", "");
                            } else {
                                editor.putString("totalMER", totalMER.getText().toString());
                            }
                            if (total_psMER.getText().toString().matches("")) {
                                editor.putString("total_psMER", "");
                            } else {
                                editor.putString("total_psMER", total_psMER.getText().toString());
                            }
                            if (total_hogarMER.getText().toString().matches("")) {
                                editor.putString("total_hogarMER", "");
                            } else {
                                editor.putString("total_hogarMER", total_hogarMER.getText().toString());
                            }
                            //       if(total_verifMER.getText().toString().matches("")) {editor.putString("total_verifMER","");}else{editor.putString("total_verifMER",total_verifMER.getText().toString());}editor.commit();
                            editorRD.putInt("con1MER", con1MER.getSelectedItemPosition());     //14 marzo
                            editorRD.putInt("con2MER", con2MER.getSelectedItemPosition());
                            editorRD.putInt("con3MER", con3MER.getSelectedItemPosition());
                            editorRD.putInt("con4MER", con4MER.getSelectedItemPosition());
                            if (con5MER.getText().toString().matches("")) {
                                editorRD.putString("con5MER", "");
                            } else {
                                editorRD.putString("con5MER", con5MER.getText().toString());
                            }
                            if (con5_1MER.getText().toString().matches("")) {
                                editorRD.putString("con5_1MER", "");
                            } else {
                                editorRD.putString("con5_1MER", con5_1MER.getText().toString());
                            }

                            if (cant1MER.getText().toString().matches("")) {
                                editorRD.putString("cant1MER", "");
                            } else {
                                editorRD.putString("cant1MER", cant1MER.getText().toString());
                            }
                            if (cant2MER.getText().toString().matches("")) {
                                editorRD.putString("cant2MER", "");
                            } else {
                                editorRD.putString("cant2MER", cant2MER.getText().toString());
                            }
                            if (cant3MER.getText().toString().matches("")) {
                                editorRD.putString("cant3MER", "");
                            } else {
                                editorRD.putString("cant3MER", cant3MER.getText().toString());
                            }
                            if (cant4MER.getText().toString().matches("")) {
                                editorRD.putString("cant4MER", "");
                            } else {
                                editorRD.putString("cant4MER", cant4MER.getText().toString());
                            }
                            if (cant5MER.getText().toString().matches("")) {
                                editorRD.putString("cant5MER", "");
                            } else {
                                editorRD.putString("cant5MER", cant5MER.getText().toString());
                            }
                            if (cant5_1MER.getText().toString().matches("")) {
                                editorRD.putString("cant5_1MER", "");
                            } else {
                                editorRD.putString("cant5_1MER", cant5_1MER.getText().toString());
                            }

                      /*
                            if(undM1MER.getText().toString().matches("")) {editorRD.putString("undM1MER","");}else{editorRD.putString("undM1MER",undM1MER.getText().toString());}
                            if(undM2MER.getText().toString().matches("")) {editorRD.putString("undM2MER","");}else{editorRD.putString("undM2MER",undM2MER.getText().toString());}
                            if(undM3MER.getText().toString().matches("")) {editorRD.putString("undM3MER","");}else{editorRD.putString("undM3MER",undM3MER.getText().toString());}
                            if(undM4MER.getText().toString().matches("")) {editorRD.putString("undM4MER","");}else{editorRD.putString("undM4MER",undM4MER.getText().toString());}
                           */
                            if (valU1MER.getText().toString().matches("")) {
                                editorRD.putString("valU1MER", "");
                            } else {
                                editorRD.putString("valU1MER", valU1MER.getText().toString());
                            }
                            if (valU2MER.getText().toString().matches("")) {
                                editorRD.putString("valU2MER", "");
                            } else {
                                editorRD.putString("valU2MER", valU2MER.getText().toString());
                            }
                            if (valU3MER.getText().toString().matches("")) {
                                editorRD.putString("valU3MER", "");
                            } else {
                                editorRD.putString("valU3MER", valU3MER.getText().toString());
                            }
                            if (valU4MER.getText().toString().matches("")) {
                                editorRD.putString("valU4MER", "");
                            } else {
                                editorRD.putString("valU4MER", valU4MER.getText().toString());
                            }
                            if (valU5MER.getText().toString().matches("")) {
                                editorRD.putString("valU5MER", "");
                            } else {
                                editorRD.putString("valU5MER", valU5MER.getText().toString());
                            }
                            if (valU5_1MER.getText().toString().matches("")) {
                                editorRD.putString("valU5_1MER", "");
                            } else {
                                editorRD.putString("valU5_1MER", valU5_1MER.getText().toString());
                            }

                            if (fuentePs1MER.getText().toString().matches("")) {
                                editorRD.putString("fuentePs1MER", "");
                            } else {
                                editorRD.putString("fuentePs1MER", fuentePs1MER.getText().toString());
                            }
                            if (fuentePs2MER.getText().toString().matches("")) {
                                editorRD.putString("fuentePs2MER", "");
                            } else {
                                editorRD.putString("fuentePs2MER", fuentePs2MER.getText().toString());
                            }
                            if (fuentePs3MER.getText().toString().matches("")) {
                                editorRD.putString("fuentePs3MER", "");
                            } else {
                                editorRD.putString("fuentePs3MER", fuentePs3MER.getText().toString());
                            }
                            if (fuentePs4MER.getText().toString().matches("")) {
                                editorRD.putString("fuentePs4MER", "");
                            } else {
                                editorRD.putString("fuentePs4MER", fuentePs4MER.getText().toString());
                            }
                            if (fuentePs5MER.getText().toString().matches("")) {
                                editorRD.putString("fuentePs5MER", "");
                            } else {
                                editorRD.putString("fuentePs5MER", fuentePs5MER.getText().toString());
                            }
                            if (fuentePs5_1MER.getText().toString().matches("")) {
                                editorRD.putString("fuentePs5_1MER", "");
                            } else {
                                editorRD.putString("fuentePs5_1MER", fuentePs5_1MER.getText().toString());
                            }

                            if (fuenteHogar1MER.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar1MER", "");
                            } else {
                                editorRD.putString("fuenteHogar1MER", fuenteHogar1MER.getText().toString());
                            }
                            if (fuenteHogar2MER.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar2MER", "");
                            } else {
                                editorRD.putString("fuenteHogar2MER", fuenteHogar2MER.getText().toString());
                            }
                            if (fuenteHogar3MER.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar3MER", "");
                            } else {
                                editorRD.putString("fuenteHogar3MER", fuenteHogar3MER.getText().toString());
                            }
                            if (fuenteHogar4MER.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar4MER", "");
                            } else {
                                editorRD.putString("fuenteHogar4MER", fuenteHogar4MER.getText().toString());
                            }
                            if (fuenteHogar5MER.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar5MER", "");
                            } else {
                                editorRD.putString("fuenteHogar5MER", fuenteHogar5MER.getText().toString());
                            }
                            if (fuenteHogar5_1MER.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar5_1MER", "");
                            } else {
                                editorRD.putString("fuenteHogar5_1MER", fuenteHogar5_1MER.getText().toString());
                            }

                            if (totalMER.getText().toString().matches("")) {
                                editorRD.putString("totalMER", "");
                            } else {
                                editorRD.putString("totalMER", totalMER.getText().toString());
                            }
                            if (total_psMER.getText().toString().matches("")) {
                                editorRD.putString("total_psMER", "");
                            } else {
                                editorRD.putString("total_psMER", total_psMER.getText().toString());
                            }
                            if (total_hogarMER.getText().toString().matches("")) {
                                editorRD.putString("total_hogarMER", "");
                            } else {
                                editorRD.putString("total_hogarMER", total_hogarMER.getText().toString());
                            }
                            //       if(total_verifMER.getText().toString().matches("")) {editorRD.putString("total_verifMER","");}else{editorRD.putString("total_verifMER",total_verifMER.getText().toString());}
                            editorRD.commit();
                            if (sharedPreferences.getString("undM1MER", "").equals("U.medida..........") && !sharedPreferences.getString("con1MER", "").equals("SELECCIONE.......")) {
                                editor.putString("undM1MER", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM2MER", "").equals("U.medida..........") && !sharedPreferences.getString("con2MER", "").equals("SELECCIONE.......")) {
                                editor.putString("undM2MER", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM3MER", "").equals("U.medida..........") && !sharedPreferences.getString("con3MER", "").equals("SELECCIONE.......")) {
                                editor.putString("undM3MER", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM4MER", "").equals("U.medida..........") && !sharedPreferences.getString("con4MER", "").equals("SELECCIONE.......")) {
                                editor.putString("undM4MER", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM5MER", "").equals("U.medida..........") && !sharedPreferences.getString("con5MER", "").equals("")) {
                                editor.putString("undM5MER", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM5_1MER", "").equals("U.medida..........") && !sharedPreferences.getString("con5_1MER", "").equals("")) {
                                editor.putString("undM5_1MER", "Unidad");
                                editor.commit();
                            }

                            Intent intent = new Intent(Mercadeo.this, Inversion.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            Toast.makeText(Mercadeo.this, "Datos Guardados!", Toast.LENGTH_LONG).show();
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
        int tipop = sharedPreferencesRD.getInt("con1MER", 0);    //14 marzo
        con1MER.setSelection(tipop);                                         //14 marzo
        int tipop2 = sharedPreferencesRD.getInt("con2MER", 0);
        con2MER.setSelection(tipop2);
        int tipop3 = sharedPreferencesRD.getInt("con3MER", 0);    //14 marzo
        con3MER.setSelection(tipop3);
        int tipop4 = sharedPreferencesRD.getInt("con4MER", 0);
        con4MER.setSelection(tipop4);

        con5MER.setText(sharedPreferencesRD.getString("con5MER", ""));
        con5_1MER.setText(sharedPreferencesRD.getString("con5_1MER", ""));
        String tipop5 = sharedPreferencesRD.getString("cant1MER", "");
        cant1MER.setText(tipop5);
        String tipop6 = sharedPreferencesRD.getString("cant2MER", "");
        cant2MER.setText(tipop6);
        String tipop7 = sharedPreferencesRD.getString("cant3MER", "");
        cant3MER.setText(tipop7);
        String tipop8 = sharedPreferencesRD.getString("cant4MER", "");
        cant4MER.setText(tipop8);
        cant5MER.setText(sharedPreferencesRD.getString("cant5MER", ""));
        cant5_1MER.setText(sharedPreferencesRD.getString("cant5_1MER", ""));
        int tipop9 = sharedPreferencesRD.getInt("undM1MER", 0);
        undM1MER.setSelection(tipop9);
        int tipop10 = sharedPreferencesRD.getInt("undM2MER", 0);
        undM2MER.setSelection(tipop10);
        int tipop11 = sharedPreferencesRD.getInt("undM3MER", 0);
        undM3MER.setSelection(tipop11);
        int tipop12 = sharedPreferencesRD.getInt("undM4MER", 0);
        undM4MER.setSelection(tipop12);
        int tipop12_1 = sharedPreferencesRD.getInt("undM5MER", 0);
        undM5MER.setSelection(tipop12_1);
        undM5_1MER.setSelection(sharedPreferencesRD.getInt("undM5_1MER", 0));
        String tipop13 = sharedPreferencesRD.getString("valU1MER", "");

        valU1MER.setText(tipop13);
        String tipop14 = sharedPreferencesRD.getString("valU2MER", "");
        valU2MER.setText(tipop14);
        String tipop15 = sharedPreferencesRD.getString("valU3MER", "");
        valU3MER.setText(tipop15);
        String tipop16 = sharedPreferencesRD.getString("valU4MER", "");
        valU4MER.setText(tipop16);
        valU5MER.setText(sharedPreferencesRD.getString("valU5MER", ""));
        valU5_1MER.setText(sharedPreferencesRD.getString("valU5_1MER", ""));

        String tipop17 = sharedPreferencesRD.getString("ver1MER", "");

        if (tipop17.equals("Cumple")) {
            ver1MER.setSelection(0);
        } else {
            ver1MER.setSelection(1);
        }
        String tipop18 = sharedPreferencesRD.getString("ver2MER", "");
        if (tipop18.equals("Cumple")) {
            ver2MER.setSelection(0);
        } else {
            ver2MER.setSelection(1);
        }
        String tipop19 = sharedPreferencesRD.getString("ver3MER", "");
        if (tipop19.equals("Cumple")) {
            ver3MER.setSelection(0);
        } else {
            ver3MER.setSelection(1);
        }
        String tipop20 = sharedPreferencesRD.getString("ver4MER", "");
        if (tipop20.equals("Cumple")) {
            ver4MER.setSelection(0);
        } else {
            ver4MER.setSelection(1);
        }
        String tipop20_1 = sharedPreferencesRD.getString("ver5MER", "");
        if (tipop20_1.equals("Cumple")) {
            ver5MER.setSelection(0);
        } else {
            ver5MER.setSelection(1);
        }
        String tipop20_2 = sharedPreferencesRD.getString("ver5_1MER", "");
        if (tipop20_2.equals("Cumple")) {
            ver5_1MER.setSelection(0);
        } else {
            ver5_1MER.setSelection(1);
        }

        String tipop21 = sharedPreferencesRD.getString("valT1MER", "");
        valT1MER.setText(tipop21);
        String tipop22 = sharedPreferencesRD.getString("valT2MER", "");
        valT2MER.setText(tipop22);
        String tipop23 = sharedPreferencesRD.getString("valT3MER", "");
        valT3MER.setText(tipop23);
        String tipop24 = sharedPreferencesRD.getString("valT4MER", "");
        valT4MER.setText(tipop24);
        String tipop25 = sharedPreferencesRD.getString("valT5MER", "");
        valT5MER.setText(tipop25);
        valT5_1MER.setText(sharedPreferencesRD.getString("valT5_1MER", ""));

        String titulop26 = sharedPreferencesRD.getString("fuentePs1MER", "");
        fuentePs1MER.setText(titulop26);
        String titulop27 = sharedPreferencesRD.getString("fuentePs2MER", "");
        fuentePs2MER.setText(titulop27);
        String titulop28 = sharedPreferencesRD.getString("fuentePs3MER", "");
        fuentePs3MER.setText(titulop28);
        String titulop29 = sharedPreferencesRD.getString("fuentePs4MER", "");
        fuentePs4MER.setText(titulop29);
        fuentePs5MER.setText(sharedPreferencesRD.getString("fuentePs5MER", ""));
        fuentePs5_1MER.setText(sharedPreferencesRD.getString("fuentePs5_1MER", ""));
        String titulop30 = sharedPreferencesRD.getString("fuenteHogar1MER", "");
        fuenteHogar1MER.setText(titulop30);
        String titulop31 = sharedPreferencesRD.getString("fuenteHogar2MER", "");
        fuenteHogar2MER.setText(titulop31);
        String titulop32 = sharedPreferencesRD.getString("fuenteHogar3MER", "");
        fuenteHogar3MER.setText(titulop32);
        String titulop33 = sharedPreferencesRD.getString("fuenteHogar4MER", "");
        fuenteHogar4MER.setText(titulop33);
        fuenteHogar5MER.setText(sharedPreferencesRD.getString("fuenteHogar5MER", ""));
        fuenteHogar5_1MER.setText(sharedPreferencesRD.getString("fuenteHogar5_1MER", ""));
        String titulop34 = sharedPreferencesRD.getString("totalMER", "");
        totalMER.setText(titulop34);
        String titulop35 = sharedPreferencesRD.getString("total_psMER", "");
        total_psMER.setText(titulop35);
        String titulop36 = sharedPreferencesRD.getString("total_hogarMER", "");
        total_hogarMER.setText(titulop36);
        //     String titulop37 = sharedPreferencesRD.getString("total_verifMER", "");
        //     total_verifMER.setText(titulop37);


    }

    public void ir(View view) {
        totalMER.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(totalMER, InputMethodManager.SHOW_IMPLICIT);
    }

    public void calcular(View view) {
        switch (view.getId()) {
            case R.id.C1:
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant1MER.getText().toString().matches("")) {
                } else {

                    if (!valU1MER.getText().toString().matches("")) {
                        valT1MER.setText(String.valueOf(Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString())));
                        try {
                            GT = Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString()) + 0 + 0 + 0;
                            GT_PS = Integer.parseInt(fuentePs1MER.getText().toString());
                            GT_HOG = Integer.parseInt(fuenteHogar1MER.getText().toString());
                        } catch (Exception e) {
                        }
                        totalMER.setText(String.valueOf(GT));
                        total_psMER.setText(String.valueOf(GT_PS));
                        total_hogarMER.setText(String.valueOf(GT_HOG));
                        editor.putString("valT1MER", valT1MER.getText().toString());
                        editorRD.putString("valT1MER", valT1MER.getText().toString());
                    } else {
                        editor.putString("valT1MER", "");
                        editorRD.putString("valT1MER", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(AMERFijos.this, sharedPreferencesRD.getString("valT1MER", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C2:
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();

                if (!cant2MER.getText().toString().matches("") && !cant1MER.getText().toString().matches("") && !valU2MER.getText().toString().matches("") && !valU1MER.getText().toString().matches("")) {
                    valT2MER.setText(String.valueOf(Integer.parseInt(cant2MER.getText().toString()) * Integer.parseInt(valU2MER.getText().toString())));
                    try {
                        GT = Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString()) + Integer.parseInt(cant2MER.getText().toString()) * Integer.parseInt(valU2MER.getText().toString()) + 0 + 0;
                        GT_PS = Integer.parseInt(fuentePs1MER.getText().toString()) + Integer.parseInt(fuentePs2MER.getText().toString());
                        GT_HOG = Integer.parseInt(fuenteHogar1MER.getText().toString()) + Integer.parseInt(fuenteHogar2MER.getText().toString());
                    } catch (Exception e) {
                    }
                    totalMER.setText(String.valueOf(GT));
                    total_psMER.setText(String.valueOf(GT_PS));
                    total_hogarMER.setText(String.valueOf(GT_HOG));
                    editor.putString("valT2MER", valT2MER.getText().toString());
                    editorRD.putString("valT2MER", valT2MER.getText().toString());
                } else {
                    Toast.makeText(this, "Complete todo los datos de arriba.", Toast.LENGTH_SHORT).show();
                    editor.putString("valT2MER", "");
                    editorRD.putString("valT2MER", "");
                }
                editor.commit();
                editorRD.commit();
                //        Toast.makeText(AMERFijos.this, sharedPreferencesRD.getString("valT1MER", ""), Toast.LENGTH_LONG).show();

                break;
            case R.id.C3:
                Toast.makeText(this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant3MER.getText().toString().matches("")) {
                } else {

                    if (!valU3MER.getText().toString().matches("")) {
                        valT3MER.setText(String.valueOf(Integer.parseInt(cant3MER.getText().toString()) * Integer.parseInt(valU3MER.getText().toString())));
                        editor.putString("valT3MER", valT3MER.getText().toString());
                        editorRD.putString("valT3MER", valT3MER.getText().toString());
                        if (!valU2MER.getText().toString().matches("") && !cant2MER.getText().toString().matches("")) {
                            try {
                                GT = Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString()) + Integer.parseInt(cant2MER.getText().toString()) * Integer.parseInt(valU2MER.getText().toString()) + Integer.parseInt(cant3MER.getText().toString()) * Integer.parseInt(valU3MER.getText().toString()) + 0;
                                GT_PS = Integer.parseInt(fuentePs1MER.getText().toString()) + Integer.parseInt(fuentePs2MER.getText().toString()) + Integer.parseInt(fuentePs3MER.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1MER.getText().toString()) + Integer.parseInt(fuenteHogar2MER.getText().toString()) + Integer.parseInt(fuenteHogar3MER.getText().toString());
                            } catch (Exception e) {
                            }
                            totalMER.setText(String.valueOf(GT));
                            total_psMER.setText(String.valueOf(GT_PS));
                            total_hogarMER.setText(String.valueOf(GT_HOG));
                        }
                    } else {
                        editor.putString("valT3MER", "");
                        editorRD.putString("valT3MER", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(AMERFijos.this, sharedPreferencesRD.getString("valT1MER", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C4:

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant4MER.getText().toString().matches("")) {
                } else {

                    if (!valU4MER.getText().toString().matches("")) {
                        valT4MER.setText(String.valueOf(Integer.parseInt(cant4MER.getText().toString()) * Integer.parseInt(valU4MER.getText().toString())));
                        editor.putString("valT4MER", valT4MER.getText().toString());
                        editorRD.putString("valT4MER", valT4MER.getText().toString());
                        if (!valU2MER.getText().toString().matches("") && !valU3MER.getText().toString().matches("") && !cant2MER.getText().toString().matches("") && !cant3MER.getText().toString().matches("")) {

                            try {
                                GT = Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString()) + Integer.parseInt(cant2MER.getText().toString()) * Integer.parseInt(valU2MER.getText().toString()) + Integer.parseInt(cant3MER.getText().toString()) * Integer.parseInt(valU3MER.getText().toString()) + Integer.parseInt(cant4MER.getText().toString()) * Integer.parseInt(valU4MER.getText().toString());
                                GT_PS = Integer.parseInt(fuentePs1MER.getText().toString()) + Integer.parseInt(fuentePs2MER.getText().toString()) + Integer.parseInt(fuentePs3MER.getText().toString()) + Integer.parseInt(fuentePs4MER.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1MER.getText().toString()) + Integer.parseInt(fuenteHogar2MER.getText().toString()) + Integer.parseInt(fuenteHogar3MER.getText().toString()) + Integer.parseInt(fuenteHogar4MER.getText().toString());
                            } catch (Exception e) {
                            }
                            totalMER.setText(String.valueOf(GT));
                            total_psMER.setText(String.valueOf(GT_PS));
                            total_hogarMER.setText(String.valueOf(GT_HOG));
                        }
                    } else {
                        editor.putString("valT4MER", "");
                        editorRD.putString("valT4MER", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C5:
                Toast.makeText(Mercadeo.this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant5MER.getText().toString().matches("")) {
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0;
                    if (!valU5MER.getText().toString().matches("")) {
                        valT5MER.setText(String.valueOf(Integer.parseInt(cant5MER.getText().toString()) * Integer.parseInt(valU5MER.getText().toString())));

                        editor.putString("valT5GP", valT5MER.getText().toString());
                        editorRD.putString("valT5GP", valT5MER.getText().toString());

                        if (valU1MER.getText().toString().matches("") && cant1MER.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString());
                        }
                        if (valU2MER.getText().toString().matches("") && cant2MER.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2MER.getText().toString()) * Integer.parseInt(valU2MER.getText().toString());
                        }
                        if (valU3MER.getText().toString().matches("") && cant3MER.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3MER.getText().toString()) * Integer.parseInt(valU3MER.getText().toString());
                        }
                        if (valU4MER.getText().toString().matches("") && cant4MER.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4MER.getText().toString()) * Integer.parseInt(valU4MER.getText().toString());
                        }

                        if (fuentePs1MER.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1MER.getText().toString());
                        }
                        if (fuentePs2MER.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2MER.getText().toString());
                        }
                        if (fuentePs3MER.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3MER.getText().toString());
                        }
                        if (fuentePs4MER.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4MER.getText().toString());
                        }

                        if (fuenteHogar1MER.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1MER.getText().toString());
                        }
                        if (fuenteHogar2MER.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2MER.getText().toString());
                        }
                        if (fuenteHogar3MER.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3MER.getText().toString());
                        }
                        if (fuenteHogar4MER.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4MER.getText().toString());
                        }

                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + Integer.parseInt(cant5MER.getText().toString()) * Integer.parseInt(valU5MER.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + Integer.parseInt(fuentePs5MER.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + Integer.parseInt(fuenteHogar5MER.getText().toString());
                        } catch (Exception e) {
                        }
                        totalMER.setText(String.valueOf(GT));
                        total_psMER.setText(String.valueOf(GT_PS));
                        total_hogarMER.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5MER", "");
                        editorRD.putString("valT5MER", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C5_1:

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();

                if (cant5_1MER.getText().toString().matches("") || valU5_1MER.getText().toString().matches("")) {
                    Toast.makeText(Mercadeo.this, "Revise que este todo completo", Toast.LENGTH_LONG).show();
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorT5 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorPS5 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0, valorHogar5 = 0;
                    if (!valU5_1MER.getText().toString().matches("")) {
                        valT5_1MER.setText(String.valueOf(Integer.parseInt(cant5_1MER.getText().toString()) * Integer.parseInt(valU5_1MER.getText().toString())));

                        editor.putString("valT5_1MER", valT5_1MER.getText().toString());
                        editorRD.putString("valT5_1MER", valT5_1MER.getText().toString());

                        if (valU1MER.getText().toString().matches("") && cant1MER.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1MER.getText().toString()) * Integer.parseInt(valU1MER.getText().toString());
                        }
                        if (valU2MER.getText().toString().matches("") && cant2MER.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2MER.getText().toString()) * Integer.parseInt(valU2MER.getText().toString());
                        }
                        if (valU3MER.getText().toString().matches("") && cant3MER.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3MER.getText().toString()) * Integer.parseInt(valU3MER.getText().toString());
                        }
                        if (valU4MER.getText().toString().matches("") && cant4MER.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4MER.getText().toString()) * Integer.parseInt(valU4MER.getText().toString());
                        }
                        if (valU5MER.getText().toString().matches("") && cant5MER.getText().toString().matches("")) {
                            valorT5 = 0;
                        } else {
                            valorT5 = Integer.parseInt(cant5MER.getText().toString()) * Integer.parseInt(valU5MER.getText().toString());
                        }

                        if (fuentePs1MER.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1MER.getText().toString());
                        }
                        if (fuentePs2MER.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2MER.getText().toString());
                        }
                        if (fuentePs3MER.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3MER.getText().toString());
                        }
                        if (fuentePs4MER.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4MER.getText().toString());
                        }
                        if (fuentePs5MER.getText().toString().matches("")) {
                            valorPS5 = 0;
                        } else {
                            valorPS5 = Integer.parseInt(fuentePs5MER.getText().toString());
                        }

                        if (fuenteHogar1MER.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1MER.getText().toString());
                        }
                        if (fuenteHogar2MER.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2MER.getText().toString());
                        }
                        if (fuenteHogar3MER.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3MER.getText().toString());
                        }
                        if (fuenteHogar4MER.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4MER.getText().toString());
                        }
                        if (fuenteHogar5MER.getText().toString().matches("")) {
                            valorHogar5 = 0;
                        } else {
                            valorHogar5 = Integer.parseInt(fuenteHogar5MER.getText().toString());
                        }


                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + valorT5 + Integer.parseInt(cant5_1MER.getText().toString()) * Integer.parseInt(valU5_1MER.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + valorPS5 + Integer.parseInt(fuentePs5_1MER.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + valorHogar5 + Integer.parseInt(fuenteHogar5_1MER.getText().toString());
                        } catch (Exception e) {
                        }
                        totalMER.setText(String.valueOf(GT));
                        total_psMER.setText(String.valueOf(GT_PS));
                        total_hogarMER.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5_1MER", "");
                        editorRD.putString("valT5_1MER", "");
                    }
                    editor.putString("ver5_1MER", ver5_1MER.getSelectedItem().toString());
                    editorRD.putString("ver5_1MER", ver5_1MER.getSelectedItem().toString());
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
