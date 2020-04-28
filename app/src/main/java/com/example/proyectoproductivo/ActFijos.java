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

public class ActFijos extends AppCompatActivity {

    EditText con5AF, con5_1AF, cant1AF, cant2AF, cant3AF, cant4AF, cant5AF, cant5_1AF, valU1AF, valU2AF, valU3AF, valU4AF, valU5AF, valU5_1AF;
    EditText valT1AF, valT2AF, valT3AF, valT4AF, valT5AF, valT5_1AF, fuentePs1AF, fuentePs2AF, fuentePs3AF, fuentePs4AF, fuentePs5AF, fuentePs5_1AF, fuenteHogar1AF, fuenteHogar2AF, fuenteHogar3AF, fuenteHogar4AF, fuenteHogar5AF, fuenteHogar5_1AF;
    int GT, GT_PS, GT_HOG;
    String ShaPreSector;
    ArrayAdapter<String> dataAdapterS_A, dataAdapterS_A_peces, dataAdapterS_A_cerdos, dataAdapterS_A_bovino, dataAdapterS_A_aves_corral, dataAdapterS_C_restaurante, dataAdapterS_G_comercio, dataAdapterS_G_papeleria, dataAdapterS_G_ropa, dataAdapterS_S_peluqueria, dataAdapterOtros;
    Spinner con1AF, con2AF, con3AF, con4AF;
    Button ItemAdicional;
    ExpandableWeightLayout expandableLayout;
    //Comentado por DC - Verificación
    //AppCompatSpinner ver1AF, ver2AF, ver3AF, ver4AF, ver5AF, ver5_1AF, undM1AF, undM2AF, undM3AF, undM4AF, undM5AF, undM5_1AF;
    private AppCompatSpinner undM1AF, undM2AF, undM3AF, undM4AF, undM5AF, undM5_1AF;
    EditText totalAF, total_psAF, total_hogarAF, total_verifAF;
    BottomNavigationView btnNV;
    TextView VSug1, VSug2, VSug3, VSug4;
    HashMap<String, String> hm = new HashMap<>();
    private SharedPreferences sharedPreferences, sharedPreferencesRD, dataEncuenta;
    SharedPreferences.Editor editor, editorRD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_fijos);
        ItemAdicional = findViewById(R.id.expandButton);
        ItemAdicional.setText("Tiene un insumo adicional? " + Character.toString((char) 9660) + " ");
        expandableLayout
                = (ExpandableWeightLayout) findViewById(R.id.expandableLayout);
        btnNV = findViewById(R.id.navigationView);
        con1AF = findViewById(R.id.CON1AF);
        con2AF = findViewById(R.id.CON2AF);
        con3AF = findViewById(R.id.CON3AF);
        con4AF = findViewById(R.id.CON4AF);
        con5AF = findViewById(R.id.CON5AF);
        con5_1AF = findViewById(R.id.CON5_1AF);
        cant1AF = findViewById(R.id.CAN1AF);
        cant2AF = findViewById(R.id.CAN2AF);
        cant3AF = findViewById(R.id.CAN3AF);
        cant4AF = findViewById(R.id.CAN4AF);
        cant5AF = findViewById(R.id.CAN5AF);
        cant5_1AF = findViewById(R.id.CAN5_1AF);
        undM1AF = findViewById(R.id.UM1AF);
        undM2AF = findViewById(R.id.UM2AF);
        undM3AF = findViewById(R.id.UM3AF);
        undM4AF = findViewById(R.id.UM4AF);
        undM5AF = findViewById(R.id.UM5AF);
        undM5_1AF = findViewById(R.id.UM5_1AF);
        valU1AF = findViewById(R.id.VU1AF);
        valU2AF = findViewById(R.id.VU2AF);
        valU3AF = findViewById(R.id.VU3AF);
        valU4AF = findViewById(R.id.VU4AF);
        valU5AF = findViewById(R.id.VU5AF);
        valU5_1AF = findViewById(R.id.VU5_1AF);
        /*Comentado por DC - Verificación
        ver1AF = findViewById(R.id.VERF1AF);
        ver2AF = findViewById(R.id.VERF2AF);
        ver3AF = findViewById(R.id.VERF3AF);
        ver4AF = findViewById(R.id.VERF4AF);
        ver5AF = findViewById(R.id.VERF5AF);
        ver5_1AF = findViewById(R.id.VERF5_1AF);
        */
        valT1AF = findViewById(R.id.VT1AF);
        valT2AF = findViewById(R.id.VT2AF);
        valT3AF = findViewById(R.id.VT3AF);
        valT4AF = findViewById(R.id.VT4AF);
        valT5AF = findViewById(R.id.VT5AF);
        valT5_1AF = findViewById(R.id.VT5_1AF);
        fuentePs1AF = findViewById(R.id.PS1AF);
        fuentePs2AF = findViewById(R.id.PS2AF);
        fuentePs3AF = findViewById(R.id.PS3AF);
        fuentePs4AF = findViewById(R.id.PS4AF);
        fuentePs5AF = findViewById(R.id.PS5AF);
        fuentePs5_1AF = findViewById(R.id.PS5_1AF);
        fuenteHogar1AF = findViewById(R.id.HO1AF);
        fuenteHogar2AF = findViewById(R.id.HO2AF);
        fuenteHogar3AF = findViewById(R.id.HO3AF);
        fuenteHogar4AF = findViewById(R.id.HO4AF);
        fuenteHogar5AF = findViewById(R.id.HO5AF);
        fuenteHogar5_1AF = findViewById(R.id.HO5_1AF);
        VSug1 = findViewById(R.id.VSug1AF);
        VSug2 = findViewById(R.id.VSug2AF);
        VSug3 = findViewById(R.id.VSug3AF);
        VSug4 = findViewById(R.id.VSug4AF);
        totalAF = findViewById(R.id.TOTAL_AF);
        total_psAF = findViewById(R.id.TOTAL_PS_AF);
        total_hogarAF = findViewById(R.id.TOTAL_HOGAR_AF);//total_verifAF=findViewById(R.id.TOTAL_VERIFICACION_AF);
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
        //      Toast.makeText(this, ""+sharedPreferences.getString("codSector",""), Toast.LENGTH_SHORT).show();
        List<String> list_Sec_A = new ArrayList<String>();
        list_Sec_A.add("Seleccione......");
        list_Sec_A.add("FUMIGADORA DE ESPALDA");
        list_Sec_A.add("FUMIGADORA A MOTOR  DE GASOLINA");
        list_Sec_A.add("GUADAÑA");
        list_Sec_A.add("CARRETILLA");
        list_Sec_A.add("PALA");
        list_Sec_A.add("MACHETA");
        List<String> list_Sec_A_peces = new ArrayList<String>();
        list_Sec_A_peces.add("Seleccione......");
        list_Sec_A_peces.add("CANOA");
        list_Sec_A_peces.add("MOTOR");
        list_Sec_A_peces.add("REMOS");
        list_Sec_A_peces.add("BALSA");
        List<String> list_Sec_A_cerdos = new ArrayList<String>();
        list_Sec_A_cerdos.add("Seleccione......");
        list_Sec_A_cerdos.add("BEBEDEROS");
        list_Sec_A_cerdos.add("COMEDEROS");
        list_Sec_A_cerdos.add("CEPO");

        List<String> list_Sec_A_bovino = new ArrayList<String>();
        list_Sec_A_bovino.add("Seleccione......");
        list_Sec_A_bovino.add("PICA PASTO");
        list_Sec_A_bovino.add("BALDE LECHERO");
        list_Sec_A_bovino.add("VALLAS DE ALIMENTACIÓN");
        list_Sec_A_bovino.add("BOVINOS");
        List<String> list_Sec_A_aves_corral = new ArrayList<String>();
        list_Sec_A_aves_corral.add("Seleccione......");
        list_Sec_A_aves_corral.add("COMEDEROS");
        list_Sec_A_aves_corral.add("BEBEDEROS");
        list_Sec_A_aves_corral.add("NIDAL");
        List<String> list_Sec_C_restaurante = new ArrayList<String>();
        list_Sec_C_restaurante.add("Seleccione......");
        list_Sec_C_restaurante.add("ESTUFA");
        list_Sec_C_restaurante.add("NEVERA");
        list_Sec_C_restaurante.add("SILLAS");
        list_Sec_C_restaurante.add("MESAS");
        list_Sec_C_restaurante.add("MESON");
        List<String> list_Sec_G_comercio = new ArrayList<String>();
        list_Sec_G_comercio.add("Seleccione......");//FRUVER
        list_Sec_G_comercio.add("VITRINAS");
        list_Sec_G_comercio.add("ESTANTES");
        list_Sec_G_comercio.add("CONGELADOR");
        list_Sec_G_comercio.add("VERDURERO");
        ;
        list_Sec_G_comercio.add("CANASTILLAS");
        List<String> list_Sec_G_papeleria = new ArrayList<String>();
        list_Sec_G_papeleria.add("Seleccione......");
        list_Sec_G_papeleria.add("VITRINAS");
        list_Sec_G_papeleria.add("IMPRESORA");
        list_Sec_G_papeleria.add("MESAS");
        list_Sec_G_papeleria.add("COMPUTADOR");
        List<String> list_Sec_G_ropa = new ArrayList<String>();
        list_Sec_G_ropa.add("Seleccione......");
        list_Sec_G_ropa.add("VITRINAS");
        list_Sec_G_ropa.add("CORTINAS");
        list_Sec_G_ropa.add("ESTANTES");
        list_Sec_G_ropa.add("EXHIBIDOR DE ROPA");
        List<String> list_Sec_S_peluqueria = new ArrayList<String>();
        list_Sec_S_peluqueria.add("Seleccione......");
        list_Sec_S_peluqueria.add("ESPEJO");
        list_Sec_S_peluqueria.add("SILLAS PELUQUERIA");
        list_Sec_S_peluqueria.add("MESAS");
        list_Sec_S_peluqueria.add("SECADORES");
        list_Sec_S_peluqueria.add("PLANCHAS");
        List<String> list_Otros = new ArrayList<String>();  //mio 25 marzo
        list_Otros.add("Seleccione......");
        list_Otros.add("GUADAÑA");
        list_Otros.add("FUMIGADORA DE ESPALDA");
        list_Otros.add("FUMIGADORA A MOTOR  DE GASOLINA");
        list_Otros.add("CARRETILLA");
        list_Otros.add("PALA");
        list_Otros.add("CEPO");
        list_Otros.add("MACHETA");
        list_Otros.add("CANOA");
        list_Otros.add("MOTOR");
        list_Otros.add("REMOS");
        list_Otros.add("BALSA");
        list_Otros.add("BEBEDEROS");
        list_Otros.add("COMEDEROS");
        list_Otros.add("BALSA");
        list_Otros.add("PICA PASTO");
        list_Otros.add("BALDE LECHERO");
        list_Otros.add("VALLAS DE ALIMENTACIÓN");
        list_Otros.add("BOVINOS");
        list_Otros.add("ESTUFA");
        list_Otros.add("NEVERA");
        list_Otros.add("SILLAS");
        list_Otros.add("MESAS");
        list_Otros.add("MESON");
        list_Otros.add("VITRINAS");
        list_Otros.add("ESTANTES");
        list_Otros.add("CONGELADOR");
        list_Otros.add("VERDURERO");
        ;
        list_Otros.add("CANASTILLAS");
        list_Otros.add("IMPRESORA");
        list_Otros.add("MESAS");
        list_Otros.add("COMPUTADOR");
        list_Otros.add("CORTINAS");
        list_Otros.add("ESTANTES");
        list_Otros.add("EXHIBIDOR DE ROPA");
        list_Otros.add("ESPEJO");
        list_Otros.add("SILLAS PELUQUERIA");
        list_Otros.add("MESAS");
        list_Otros.add("SECADORES");
        list_Otros.add("PLANCHAS");

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
            con1AF.setAdapter(dataAdapterS_A_peces);
            con2AF.setAdapter(dataAdapterS_A_peces);
            con3AF.setAdapter(dataAdapterS_A_peces);
            con4AF.setAdapter(dataAdapterS_A_peces);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0144")) {
            con1AF.setAdapter(dataAdapterS_A_cerdos);
            con2AF.setAdapter(dataAdapterS_A_cerdos);
            con3AF.setAdapter(dataAdapterS_A_cerdos);
            con4AF.setAdapter(dataAdapterS_A_cerdos);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0145")) {
            con1AF.setAdapter(dataAdapterS_A_aves_corral);
            con2AF.setAdapter(dataAdapterS_A_aves_corral);
            con3AF.setAdapter(dataAdapterS_A_aves_corral);
            con4AF.setAdapter(dataAdapterS_A_aves_corral);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0141")) {
            con1AF.setAdapter(dataAdapterS_A_bovino);
            con2AF.setAdapter(dataAdapterS_A_bovino);
            con3AF.setAdapter(dataAdapterS_A_bovino);
            con4AF.setAdapter(dataAdapterS_A_bovino);
        } else if (ShaPreSector.equals("SECCION A")) {
            con1AF.setAdapter(dataAdapterS_A);
            con2AF.setAdapter(dataAdapterS_A);
            con3AF.setAdapter(dataAdapterS_A);
            con4AF.setAdapter(dataAdapterS_A);
        }

        if (ShaPreSector.equals("SECCION C")) {
            con1AF.setAdapter(dataAdapterS_C_restaurante);
            con2AF.setAdapter(dataAdapterS_C_restaurante);
            con3AF.setAdapter(dataAdapterS_C_restaurante);
            con4AF.setAdapter(dataAdapterS_C_restaurante);
        } //


        if (ShaPreSector.equals("SECCION G") && (sharedPreferences.getString("codAct", "").substring(0, 3).equals("471") || sharedPreferences.getString("codAct", "").substring(0, 3).equals("472") || sharedPreferences.getString("codAct", "").equals("4781"))) {
            con1AF.setAdapter(dataAdapterS_G_comercio);
            con2AF.setAdapter(dataAdapterS_G_comercio);
            con3AF.setAdapter(dataAdapterS_G_comercio);
            con4AF.setAdapter(dataAdapterS_G_comercio);
        } //47
        else if (ShaPreSector.equals("SECCION G") && sharedPreferences.getString("codAct", "").substring(0, 2).equals("46")) {
            con1AF.setAdapter(dataAdapterS_G_ropa);
            con2AF.setAdapter(dataAdapterS_G_ropa);
            con3AF.setAdapter(dataAdapterS_G_ropa);
            con4AF.setAdapter(dataAdapterS_G_ropa);
        } else if (ShaPreSector.equals("SECCION G") && (sharedPreferences.getString("codAct", "").substring(0, 3).equals("479") || sharedPreferences.getString("codAct", "").equals("4789") || sharedPreferences.getString("codAct", "").equals("4782"))) {
            con1AF.setAdapter(dataAdapterS_G_papeleria);
            con2AF.setAdapter(dataAdapterS_G_papeleria);
            con3AF.setAdapter(dataAdapterS_G_papeleria);
            con4AF.setAdapter(dataAdapterS_G_papeleria);
        } else if (ShaPreSector.equals("SECCION G")) {
            con1AF.setAdapter(dataAdapterOtros);
            con2AF.setAdapter(dataAdapterOtros);
            con3AF.setAdapter(dataAdapterOtros);
            con4AF.setAdapter(dataAdapterOtros);
        }

        if (ShaPreSector.equals("SECCION S")) {
            con1AF.setAdapter(dataAdapterS_S_peluqueria);
            con2AF.setAdapter(dataAdapterS_S_peluqueria);
            con3AF.setAdapter(dataAdapterS_S_peluqueria);
            con4AF.setAdapter(dataAdapterS_S_peluqueria);
        } //
        if (ShaPreSector.equals("SECCION B") || ShaPreSector.equals("SECCION D") || ShaPreSector.equals("SECCION E") || ShaPreSector.equals("SECCION F") || ShaPreSector.equals("SECCION H") || ShaPreSector.equals("SECCION I") || ShaPreSector.equals("SECCION J") || ShaPreSector.equals("SECCION Q") || ShaPreSector.equals("SECCION R") || ShaPreSector.equals("SECCION T")) {
            con1AF.setAdapter(dataAdapterOtros);
            con2AF.setAdapter(dataAdapterOtros);
            con3AF.setAdapter(dataAdapterOtros);
            con4AF.setAdapter(dataAdapterOtros);
        }

        ArrayAdapter<CharSequence> adapterUM = ArrayAdapter.createFromResource(this, R.array.und_medida, R.layout.textview);
        undM1AF.setAdapter(adapterUM);
        undM2AF.setAdapter(adapterUM);
        undM3AF.setAdapter(adapterUM);
        undM4AF.setAdapter(adapterUM);

        undM1AF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM1AF", posicionUM);
                editorRD.commit();
                editor.putString("undM1AF", undM1AF.getSelectedItem().toString());
                editor.commit();
                if (!con1AF.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU1AF.setHint("Sugerido:"+hm.get(con1AF.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con1AF.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug1.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM2AF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM2AF", posicionUM);
                editorRD.commit();
                editor.putString("undM2AF", undM2AF.getSelectedItem().toString());
                editor.commit();
                if (!con2AF.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU2AF.setHint("Sugerido:"+hm.get(con2AF.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con2AF.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug2.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM3AF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM3AF", posicionUM);
                editorRD.commit();
                editor.putString("undM3AF", undM3AF.getSelectedItem().toString());
                editor.commit();
                if (!con3AF.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU3AF.setHint("Sugerido:"+hm.get(con3AF.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con3AF.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug3.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        undM4AF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM4AF", posicionUM);
                editorRD.commit();
                editor.putString("undM4AF", undM4AF.getSelectedItem().toString());
                editor.commit();
                if (!con4AF.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU4AF.setHint("Sugerido:"+hm.get(con4AF.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con4AF.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug4.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        undM5AF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM5AF", posicionUM);
                editorRD.commit();
                editor.putString("undM5AF", undM5AF.getSelectedItem().toString());
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        undM5_1AF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                editorRD.putInt("undM5_1AF", posicionUM);
                editorRD.commit();
                editor.putString("undM5_1AF", undM5_1AF.getSelectedItem().toString());
                editor.commit();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /* Comentado por DC - Verificación
        ver1AF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver1AF", ver1AF.getSelectedItem().toString());
                editorRD.putString("ver1AF", ver1AF.getSelectedItem().toString());
                if (cant1AF.getText().toString().matches("")) {
                } else {

                    if (!valU1AF.getText().toString().matches("")) {
                        valT1AF.setText(String.valueOf(Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString())));
                        try {
                            GT = Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString()) + 0 + 0 + 0;
                            GT_PS = Integer.parseInt(fuentePs1AF.getText().toString());
                            GT_HOG = Integer.parseInt(fuenteHogar1AF.getText().toString());
                        } catch (Exception e) {
                        }
                        totalAF.setText(String.valueOf(GT));
                        total_psAF.setText(String.valueOf(GT_PS));
                        total_hogarAF.setText(String.valueOf(GT_HOG));
                        editor.putString("valT1AF", valT1AF.getText().toString());
                        editorRD.putString("valT1AF", valT1AF.getText().toString());
                    } else {
                        editor.putString("valT1AF", "");
                        editorRD.putString("valT1AF", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(AAFFijos.this, sharedPreferencesRD.getString("valT1GP", ""), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ver2AF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver2AF", ver2AF.getSelectedItem().toString());
                editorRD.putString("ver2AF", ver2AF.getSelectedItem().toString());
                if (!cant2AF.getText().toString().matches("") && !cant1AF.getText().toString().matches("") && !valU2AF.getText().toString().matches("") && !valU1AF.getText().toString().matches("")) {
                    valT2AF.setText(String.valueOf(Integer.parseInt(cant2AF.getText().toString()) * Integer.parseInt(valU2AF.getText().toString())));
                    try {
                        GT = Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString()) + Integer.parseInt(cant2AF.getText().toString()) * Integer.parseInt(valU2AF.getText().toString()) + 0 + 0;
                        GT_PS = Integer.parseInt(fuentePs1AF.getText().toString()) + Integer.parseInt(fuentePs2AF.getText().toString());
                        GT_HOG = Integer.parseInt(fuenteHogar1AF.getText().toString()) + Integer.parseInt(fuenteHogar2AF.getText().toString());
                    } catch (Exception e) {
                    }
                    totalAF.setText(String.valueOf(GT));
                    total_psAF.setText(String.valueOf(GT_PS));
                    total_hogarAF.setText(String.valueOf(GT_HOG));
                    editor.putString("valT2AF", valT2AF.getText().toString());
                    editorRD.putString("valT2AF", valT2AF.getText().toString());
                } else {
                    Toast.makeText(ActFijos.this, "Complete todos los datos del 2do recuadro.", Toast.LENGTH_SHORT).show();
                    editor.putString("valT2AF", "");
                    editorRD.putString("valT2AF", "");
                }
                editor.commit();
                editorRD.commit();
                //        Toast.makeText(AGPFijos.this, sharedPreferencesRD.getString("valT1GP", ""), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ver3AF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver3AF", ver3AF.getSelectedItem().toString());
                editorRD.putString("ver3AF", ver3AF.getSelectedItem().toString());
                if (cant3AF.getText().toString().matches("") || valU3AF.getText().toString().matches("")) {
                    Toast.makeText(ActFijos.this, "Complete todos los datos del 3er recuadro.", Toast.LENGTH_LONG).show();

                } else {

                    if (!valU3AF.getText().toString().matches("")) {
                        valT3AF.setText(String.valueOf(Integer.parseInt(cant3AF.getText().toString()) * Integer.parseInt(valU3AF.getText().toString())));
                        editor.putString("valT3AF", valT3AF.getText().toString());
                        editorRD.putString("valT3AF", valT3AF.getText().toString());
                        if (!valU2AF.getText().toString().matches("") && !cant2AF.getText().toString().matches("")) {
                            try {
                                GT = Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString()) + Integer.parseInt(cant2AF.getText().toString()) * Integer.parseInt(valU2AF.getText().toString()) + Integer.parseInt(cant3AF.getText().toString()) * Integer.parseInt(valU3AF.getText().toString()) + 0;
                                GT_PS = Integer.parseInt(fuentePs1AF.getText().toString()) + Integer.parseInt(fuentePs2AF.getText().toString()) + Integer.parseInt(fuentePs3AF.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1AF.getText().toString()) + Integer.parseInt(fuenteHogar2AF.getText().toString()) + Integer.parseInt(fuenteHogar3AF.getText().toString());
                            } catch (Exception e) {
                            }
                            totalAF.setText(String.valueOf(GT));
                            total_psAF.setText(String.valueOf(GT_PS));
                            total_hogarAF.setText(String.valueOf(GT_HOG));
                        }
                    } else {
                        editor.putString("valT3AF", "");
                        editorRD.putString("valT3AF", "");
                    }
                    editor.commit();
                    editorRD.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });
        ver4AF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver4AF", ver4AF.getSelectedItem().toString());
                editorRD.putString("ver4AF", ver4AF.getSelectedItem().toString());
                if (cant4AF.getText().toString().matches("") || valU4AF.getText().toString().matches("")) {
                    Toast.makeText(ActFijos.this, "Complete todos los datos del 4to recuadro.", Toast.LENGTH_LONG).show();
                } else {

                    if (!valU4AF.getText().toString().matches("")) {
                        valT4AF.setText(String.valueOf(Integer.parseInt(cant4AF.getText().toString()) * Integer.parseInt(valU4AF.getText().toString())));

                        editor.putString("valT4AF", valT4AF.getText().toString());
                        editorRD.putString("valT4AF", valT4AF.getText().toString());
                        if (!valU2AF.getText().toString().matches("") && !valU3AF.getText().toString().matches("") && !cant2AF.getText().toString().matches("") && !cant3AF.getText().toString().matches("")) {

                            try {
                                GT = Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString()) + Integer.parseInt(cant2AF.getText().toString()) * Integer.parseInt(valU2AF.getText().toString()) + Integer.parseInt(cant3AF.getText().toString()) * Integer.parseInt(valU3AF.getText().toString()) + Integer.parseInt(cant4AF.getText().toString()) * Integer.parseInt(valU4AF.getText().toString());
                                GT_PS = Integer.parseInt(fuentePs1AF.getText().toString()) + Integer.parseInt(fuentePs2AF.getText().toString()) + Integer.parseInt(fuentePs3AF.getText().toString()) + Integer.parseInt(fuentePs4AF.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1AF.getText().toString()) + Integer.parseInt(fuenteHogar2AF.getText().toString()) + Integer.parseInt(fuenteHogar3AF.getText().toString()) + Integer.parseInt(fuenteHogar4AF.getText().toString());
                            } catch (Exception e) {
                            }
                            totalAF.setText(String.valueOf(GT));
                            total_psAF.setText(String.valueOf(GT_PS));
                            total_hogarAF.setText(String.valueOf(GT_HOG));

                        }
                    } else {
                        editor.putString("valT4AF", "");
                        editorRD.putString("valT4AF", "");
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
        ver5AF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActFijos.this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver5AF", ver5AF.getSelectedItem().toString());
                editorRD.putString("ver5AF", ver5AF.getSelectedItem().toString());
                if (cant5AF.getText().toString().matches("")) {
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0;
                    if (!valU5AF.getText().toString().matches("")) {
                        valT5AF.setText(String.valueOf(Integer.parseInt(cant5AF.getText().toString()) * Integer.parseInt(valU5AF.getText().toString())));

                        editor.putString("valT5AF", valT5AF.getText().toString());
                        editorRD.putString("valT5AF", valT5AF.getText().toString());

                        if (valU1AF.getText().toString().matches("") && cant1AF.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString());
                        }
                        if (valU2AF.getText().toString().matches("") && cant2AF.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2AF.getText().toString()) * Integer.parseInt(valU2AF.getText().toString());
                        }
                        if (valU3AF.getText().toString().matches("") && cant3AF.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3AF.getText().toString()) * Integer.parseInt(valU3AF.getText().toString());
                        }
                        if (valU4AF.getText().toString().matches("") && cant4AF.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4AF.getText().toString()) * Integer.parseInt(valU4AF.getText().toString());
                        }

                        if (fuentePs1AF.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1AF.getText().toString());
                        }
                        if (fuentePs2AF.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2AF.getText().toString());
                        }
                        if (fuentePs3AF.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3AF.getText().toString());
                        }
                        if (fuentePs4AF.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4AF.getText().toString());
                        }

                        if (fuenteHogar1AF.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1AF.getText().toString());
                        }
                        if (fuenteHogar2AF.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2AF.getText().toString());
                        }
                        if (fuenteHogar3AF.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3AF.getText().toString());
                        }
                        if (fuenteHogar4AF.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4AF.getText().toString());
                        }

                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + Integer.parseInt(cant5AF.getText().toString()) * Integer.parseInt(valU5AF.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + Integer.parseInt(fuentePs5AF.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + Integer.parseInt(fuenteHogar5AF.getText().toString());
                        } catch (Exception e) {
                        }
                        totalAF.setText(String.valueOf(GT));
                        total_psAF.setText(String.valueOf(GT_PS));
                        total_hogarAF.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5AF", "");
                        editorRD.putString("valT5AF", "");
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
        ver5_1AF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();

                if (cant5_1AF.getText().toString().matches("") || valU5_1AF.getText().toString().matches("")) {
                    Toast.makeText(ActFijos.this, "Revise que este todo completo", Toast.LENGTH_LONG).show();
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorT5 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorPS5 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0, valorHogar5 = 0;
                    if (!valU5_1AF.getText().toString().matches("")) {
                        valT5_1AF.setText(String.valueOf(Integer.parseInt(cant5_1AF.getText().toString()) * Integer.parseInt(valU5_1AF.getText().toString())));

                        editor.putString("valT5_1AF", valT5_1AF.getText().toString());
                        editorRD.putString("valT5_1AF", valT5_1AF.getText().toString());

                        if (valU1AF.getText().toString().matches("") && cant1AF.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString());
                        }
                        if (valU2AF.getText().toString().matches("") && cant2AF.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2AF.getText().toString()) * Integer.parseInt(valU2AF.getText().toString());
                        }
                        if (valU3AF.getText().toString().matches("") && cant3AF.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3AF.getText().toString()) * Integer.parseInt(valU3AF.getText().toString());
                        }
                        if (valU4AF.getText().toString().matches("") && cant4AF.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4AF.getText().toString()) * Integer.parseInt(valU4AF.getText().toString());
                        }
                        if (valU5AF.getText().toString().matches("") && cant5AF.getText().toString().matches("")) {
                            valorT5 = 0;
                        } else {
                            valorT5 = Integer.parseInt(cant5AF.getText().toString()) * Integer.parseInt(valU5AF.getText().toString());
                        }

                        if (fuentePs1AF.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1AF.getText().toString());
                        }
                        if (fuentePs2AF.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2AF.getText().toString());
                        }
                        if (fuentePs3AF.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3AF.getText().toString());
                        }
                        if (fuentePs4AF.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4AF.getText().toString());
                        }
                        if (fuentePs5AF.getText().toString().matches("")) {
                            valorPS5 = 0;
                        } else {
                            valorPS5 = Integer.parseInt(fuentePs5AF.getText().toString());
                        }

                        if (fuenteHogar1AF.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1AF.getText().toString());
                        }
                        if (fuenteHogar2AF.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2AF.getText().toString());
                        }
                        if (fuenteHogar3AF.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3AF.getText().toString());
                        }
                        if (fuenteHogar4AF.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4AF.getText().toString());
                        }
                        if (fuenteHogar5AF.getText().toString().matches("")) {
                            valorHogar5 = 0;
                        } else {
                            valorHogar5 = Integer.parseInt(fuenteHogar5AF.getText().toString());
                        }


                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + valorT5 + Integer.parseInt(cant5_1AF.getText().toString()) * Integer.parseInt(valU5_1AF.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + valorPS5 + Integer.parseInt(fuentePs5_1AF.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + valorHogar5 + Integer.parseInt(fuenteHogar5_1AF.getText().toString());
                        } catch (Exception e) {
                        }
                        totalAF.setText(String.valueOf(GT));
                        total_psAF.setText(String.valueOf(GT_PS));
                        total_hogarAF.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5_1AF", "");
                        editorRD.putString("valT5_1AF", "");
                    }
                    editor.putString("ver5_1AF", ver5_1AF.getSelectedItem().toString());
                    editorRD.putString("ver5_1AF", ver5_1AF.getSelectedItem().toString());
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
         */

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
                        // ActFijos.super.onBackPressed();
                        Intent intent = new Intent(ActFijos.this, Inversion.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        // revisar             intent.putExtra("encuestas",sharedPreferences.getString("datosver", ""));
                        startActivity(intent);
                    }
                    break;
                    case R.id.next: {
                        //  SharedPreferences.Editor editor = sharedPreferences.edit();
                        //       editor.clear();editor.commit();

                        if (con1AF.getSelectedItem().toString().matches("Seleccione......") || cant1AF.getText().toString().matches("")
                                || valT1AF.getText().toString().matches("") || fuentePs1AF.getText().toString().matches("")
                                || fuenteHogar1AF.getText().toString().matches("") || totalAF.getText().toString().matches("")) {
                            Toast.makeText(ActFijos.this, "Llene todos los campos, la seccion de Totales (abajo)", Toast.LENGTH_LONG).show();
                        } else {
                            // revisar               editor.putString("CC", editTextCC.getText().toString());
                            //       Toast.makeText(MainActivity.this, ""+nombre.getText().toString(), Toast.LENGTH_SHORT).show();
             /*               if(tipoProyec.getText()!=null) {

                                editor.putString("tipoP", tipoProyec.getText().toString());

                                //Toast.makeText(MainActivity.this, "no tiene segundo nombre", Toast.LENGTH_SHORT).show();
                            }
 */

                            //       Toast.makeText(ActFijos.this, String.valueOf(Integer.parseInt(cant1AF.getText().toString())*Integer.parseInt(valU1AF.getText().toString())), Toast.LENGTH_SHORT).show();

                            editor.putString("con1AF", con1AF.getSelectedItem().toString());
                            if (con2AF.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con2AF", "");
                            } else {
                                editor.putString("con2AF", con2AF.getSelectedItem().toString());
                            }
                            if (con3AF.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con3AF", "");
                            } else {
                                editor.putString("con3AF", con3AF.getSelectedItem().toString());
                            }
                            if (con4AF.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con4AF", "");
                            } else {
                                editor.putString("con4AF", con4AF.getSelectedItem().toString());
                            }
                            if (con5AF.getText().toString().matches("")) {
                                editor.putString("con5AF", "");
                            } else {
                                editor.putString("con5AF", con5AF.getText().toString());
                            }
                            if (con5_1AF.getText().toString().matches("")) {
                                editor.putString("con5_1AF", "");
                            } else {
                                editor.putString("con5_1AF", con5_1AF.getText().toString());
                            }
                            if (cant1AF.getText().toString().matches("")) {
                                editor.putString("cant1AF", "");

                            } else {
                                editor.putString("cant1AF", cant1AF.getText().toString());

                            }
                            if (cant2AF.getText().toString().matches("")) {
                                editor.putString("cant2AF", "");
                            } else {
                                editor.putString("cant2AF", cant2AF.getText().toString());
                            }
                            if (cant3AF.getText().toString().matches("")) {
                                editor.putString("cant3AF", "");
                            } else {
                                editor.putString("cant3AF", cant3AF.getText().toString());
                            }
                            if (cant4AF.getText().toString().matches("")) {
                                editor.putString("cant4AF", "");
                            } else {
                                editor.putString("cant4AF", cant4AF.getText().toString());
                            }
                            if (cant5AF.getText().toString().matches("")) {
                                editor.putString("cant5AF", "");
                            } else {
                                editor.putString("cant5AF", cant5AF.getText().toString());
                            }
                            if (cant5_1AF.getText().toString().matches("")) {
                                editor.putString("cant5_1AF", "");
                            } else {
                                editor.putString("cant5_1AF", cant5_1AF.getText().toString());
                            }

                            if (valU1AF.getText().toString().matches("")) {
                                editor.putString("valU1AF", "");
                            } else {
                                editor.putString("valU1AF", valU1AF.getText().toString());
                            }
                            if (valU2AF.getText().toString().matches("")) {
                                editor.putString("valU2AF", "");
                            } else {
                                editor.putString("valU2AF", valU2AF.getText().toString());
                            }
                            if (valU3AF.getText().toString().matches("")) {
                                editor.putString("valU3AF", "");
                            } else {
                                editor.putString("valU3AF", valU3AF.getText().toString());
                            }
                            if (valU4AF.getText().toString().matches("")) {
                                editor.putString("valU4AF", "");
                            } else {
                                editor.putString("valU4AF", valU4AF.getText().toString());
                            }
                            if (valU5AF.getText().toString().matches("")) {
                                editor.putString("valU5AF", "");
                            } else {
                                editor.putString("valU5AF", valU5AF.getText().toString());
                            }
                            if (valU5_1AF.getText().toString().matches("")) {
                                editor.putString("valU5_1AF", "");
                            } else {
                                editor.putString("valU5_1AF", valU5_1AF.getText().toString());
                            }
                            /*if (ver1AF.getSelectedItem().toString().matches("")) {
                                editor.putString("ver1AF", "");
                            } else {
                                editor.putString("ver1AF",ver1AF.getSelectedItem().toString());
                            }
                            if (ver2AF.getSelectedItem().toString().matches("")) {
                                editor.putString("ver2AF", "");
                            } else {
                                editor.putString("ver2AF", ver2AF.getSelectedItem().toString());
                            }
                            if (ver3AF.getSelectedItem().toString().matches("")) {
                                editor.putString("ver3AF", "");
                            } else {
                                editor.putString("ver3AF", ver3AF.getSelectedItem().toString());
                            }
                            if (ver4AF.getSelectedItem().toString().matches("")) {
                                editor.putString("ver4AF", "");
                            } else {
                                editor.putString("ver4AF", ver4AF.getSelectedItem().toString());
                            }
                            if (ver5AF.getSelectedItem().toString().matches("")) {
                                editor.putString("ver5AF", "");
                            } else {
                                editor.putString("ver5AF", ver5AF.getSelectedItem().toString());
                            }*/

                            if (fuentePs1AF.getText().toString().matches("")) {
                                editor.putString("fuentePs1AF", "");
                            } else {
                                editor.putString("fuentePs1AF", fuentePs1AF.getText().toString());
                            }
                            if (fuentePs2AF.getText().toString().matches("")) {
                                editor.putString("fuentePs2AF", "");
                            } else {
                                editor.putString("fuentePs2AF", fuentePs2AF.getText().toString());
                            }
                            if (fuentePs3AF.getText().toString().matches("")) {
                                editor.putString("fuentePs3AF", "");
                            } else {
                                editor.putString("fuentePs3AF", fuentePs3AF.getText().toString());
                            }
                            if (fuentePs4AF.getText().toString().matches("")) {
                                editor.putString("fuentePs4AF", "");
                            } else {
                                editor.putString("fuentePs4AF", fuentePs4AF.getText().toString());
                            }
                            if (fuentePs5AF.getText().toString().matches("")) {
                                editor.putString("fuentePs5AF", "");
                            } else {
                                editor.putString("fuentePs5AF", fuentePs5AF.getText().toString());
                            }
                            if (fuentePs5_1AF.getText().toString().matches("")) {
                                editor.putString("fuentePs5_1AF", "");
                            } else {
                                editor.putString("fuentePs5_1AF", fuentePs5_1AF.getText().toString());
                            }
                            if (fuenteHogar1AF.getText().toString().matches("")) {
                                editor.putString("fuenteHogar1AF", "");
                            } else {
                                editor.putString("fuenteHogar1AF", fuenteHogar1AF.getText().toString());
                            }
                            if (fuenteHogar2AF.getText().toString().matches("")) {
                                editor.putString("fuenteHogar2AF", "");
                            } else {
                                editor.putString("fuenteHogar2AF", fuenteHogar2AF.getText().toString());
                            }
                            if (fuenteHogar3AF.getText().toString().matches("")) {
                                editor.putString("fuenteHogar3AF", "");
                            } else {
                                editor.putString("fuenteHogar3AF", fuenteHogar3AF.getText().toString());
                            }
                            if (fuenteHogar4AF.getText().toString().matches("")) {
                                editor.putString("fuenteHogar4AF", "");
                            } else {
                                editor.putString("fuenteHogar4AF", fuenteHogar4AF.getText().toString());
                            }
                            if (fuenteHogar5AF.getText().toString().matches("")) {
                                editor.putString("fuenteHogar5AF", "");
                            } else {
                                editor.putString("fuenteHogar5AF", fuenteHogar5AF.getText().toString());
                            }
                            if (fuenteHogar5_1AF.getText().toString().matches("")) {
                                editor.putString("fuenteHogar5_1AF", "");
                            } else {
                                editor.putString("fuenteHogar5_1AF", fuenteHogar5_1AF.getText().toString());
                            }
                            if (totalAF.getText().toString().matches("")) {
                                editor.putString("totalAF", "");
                            } else {
                                editor.putString("totalAF", totalAF.getText().toString());
                            }
                            if (total_psAF.getText().toString().matches("")) {
                                editor.putString("total_psAF", "");
                            } else {
                                editor.putString("total_psAF", total_psAF.getText().toString());
                            }
                            if (total_hogarAF.getText().toString().matches("")) {
                                editor.putString("total_hogarAF", "");
                            } else {
                                editor.putString("total_hogarAF", total_hogarAF.getText().toString());
                            }
                /*            if (total_verifAF.getText().toString().matches("")) {
                                editor.putString("total_verifAF", "");
                            } else {
                                editor.putString("total_verifAF", total_verifAF.getText().toString());
                            }*/
                            editor.commit();

                            editorRD.putInt("con1AF", con1AF.getSelectedItemPosition());     //14 marzo
                            editorRD.putInt("con2AF", con2AF.getSelectedItemPosition());
                            editorRD.putInt("con3AF", con3AF.getSelectedItemPosition());
                            editorRD.putInt("con4AF", con4AF.getSelectedItemPosition());

                            if (con5AF.getText().toString().matches("")) {
                                editorRD.putString("con5AF", "");
                            } else {
                                editorRD.putString("con5AF", con5AF.getText().toString());
                            }
                            if (con5_1AF.getText().toString().matches("")) {
                                editorRD.putString("con5_1AF", "");
                            } else {
                                editorRD.putString("con5_1AF", con5_1AF.getText().toString());
                            }
                            if (cant1AF.getText().toString().matches("")) {
                                editorRD.putString("cant1AF", "");
                            } else {
                                editorRD.putString("cant1AF", cant1AF.getText().toString());
                            }
                            if (cant2AF.getText().toString().matches("")) {
                                editorRD.putString("cant2AF", "");
                            } else {
                                editorRD.putString("cant2AF", cant2AF.getText().toString());
                            }
                            if (cant3AF.getText().toString().matches("")) {
                                editorRD.putString("cant3AF", "");
                            } else {
                                editorRD.putString("cant3AF", cant3AF.getText().toString());
                            }
                            if (cant4AF.getText().toString().matches("")) {
                                editorRD.putString("cant4AF", "");
                            } else {
                                editorRD.putString("cant4AF", cant4AF.getText().toString());
                            }
                            if (cant5AF.getText().toString().matches("")) {
                                editorRD.putString("cant5AF", "");
                            } else {
                                editorRD.putString("cant5AF", cant5AF.getText().toString());
                            }
                            if (cant5_1AF.getText().toString().matches("")) {
                                editorRD.putString("cant5_1AF", "");
                            } else {
                                editorRD.putString("cant5_1AF", cant5_1AF.getText().toString());
                            }
                   /*         if (undM1AF.getSelectedItem().toString().matches("")) {
                                editorRD.putString("undM1AF", "");
                            } else {
                                editorRD.putString("undM1AF", undM1AF.getSelectedItem().toString());
                            }
                            if (undM2AF.getText().toString().matches("")) {
                                editorRD.putString("undM2AF", "");
                            } else {
                                editorRD.putString("undM2AF", undM2AF.getText().toString());
                            }
                            if (undM3AF.getText().toString().matches("")) {
                                editorRD.putString("undM3AF", "");
                            } else {
                                editorRD.putString("undM3AF", undM3AF.getText().toString());
                            }
                            if (undM4AF.getText().toString().matches("")) {
                                editorRD.putString("undM4AF", "");
                            } else {
                                editorRD.putString("undM4AF", undM4AF.getText().toString());
                            }*/
                            if (valU1AF.getText().toString().matches("")) {
                                editorRD.putString("valU1AF", "");
                            } else {
                                editorRD.putString("valU1AF", valU1AF.getText().toString());
                            }
                            if (valU2AF.getText().toString().matches("")) {
                                editorRD.putString("valU2AF", "");
                            } else {
                                editorRD.putString("valU2AF", valU2AF.getText().toString());
                            }
                            if (valU3AF.getText().toString().matches("")) {
                                editorRD.putString("valU3AF", "");
                            } else {
                                editorRD.putString("valU3AF", valU3AF.getText().toString());
                            }
                            if (valU4AF.getText().toString().matches("")) {
                                editorRD.putString("valU4AF", "");
                            } else {
                                editorRD.putString("valU4AF", valU4AF.getText().toString());
                            }
                            if (valU5AF.getText().toString().matches("")) {
                                editorRD.putString("valU5AF", "");
                            } else {
                                editorRD.putString("valU5AF", valU5AF.getText().toString());
                            }
                            if (valU5_1AF.getText().toString().matches("")) {
                                editorRD.putString("valU5_1AF", "");
                            } else {
                                editorRD.putString("valU5_1AF", valU5_1AF.getText().toString());
                            }
                            /*  Comentado por DC - Verificación
                            if (ver1AF.getSelectedItem().toString().matches("Cumple")) {
                                editorRD.putString("ver1AF", ver1AF.getSelectedItem().toString());

                            } else {
                                editorRD.putString("ver1AF", "");
                            }
                            if (ver2AF.getSelectedItem().toString().matches("")) {
                                editorRD.putString("ver2AF", "");
                            } else {
                                editorRD.putString("ver2AF", ver2AF.getSelectedItem().toString());
                            }
                            if (ver3AF.getSelectedItem().toString().matches("")) {
                                editorRD.putString("ver3AF", "");
                            } else {
                                editorRD.putString("ver3AF", ver3AF.getSelectedItem().toString());
                            }
                            if (ver4AF.getSelectedItem().toString().matches("")) {
                                editorRD.putString("ver4AF", "");
                            } else {
                                editorRD.putString("ver4AF", ver4AF.getSelectedItem().toString());
                            }
                            if (ver5AF.getSelectedItem().toString().matches("")) {
                                editorRD.putString("ver5AF", "");
                            } else {
                                editorRD.putString("ver5AF", ver5AF.getSelectedItem().toString());
                            }
                            if (ver5_1AF.getSelectedItem().toString().matches("")) {
                                editorRD.putString("ver5_1AF", "");
                            } else {
                                editorRD.putString("ver5_1AF", ver5_1AF.getSelectedItem().toString());
                            }*/

                            if (fuentePs1AF.getText().toString().matches("")) {
                                editorRD.putString("fuentePs1AF", "");
                            } else {
                                editorRD.putString("fuentePs1AF", fuentePs1AF.getText().toString());
                            }
                            if (fuentePs2AF.getText().toString().matches("")) {
                                editorRD.putString("fuentePs2AF", "");
                            } else {
                                editorRD.putString("fuentePs2AF", fuentePs2AF.getText().toString());
                            }
                            if (fuentePs3AF.getText().toString().matches("")) {
                                editorRD.putString("fuentePs3AF", "");
                            } else {
                                editorRD.putString("fuentePs3AF", fuentePs3AF.getText().toString());
                            }
                            if (fuentePs4AF.getText().toString().matches("")) {
                                editorRD.putString("fuentePs4AF", "");
                            } else {
                                editorRD.putString("fuentePs4AF", fuentePs4AF.getText().toString());
                            }
                            if (fuentePs5AF.getText().toString().matches("")) {
                                editorRD.putString("fuentePs5AF", "");
                            } else {
                                editorRD.putString("fuentePs5AF", fuentePs5AF.getText().toString());
                            }
                            if (fuentePs5_1AF.getText().toString().matches("")) {
                                editorRD.putString("fuentePs5_1AF", "");
                            } else {
                                editorRD.putString("fuentePs5_1AF", fuentePs5_1AF.getText().toString());
                            }
                            if (fuenteHogar1AF.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar1AF", "");
                            } else {
                                editorRD.putString("fuenteHogar1AF", fuenteHogar1AF.getText().toString());
                            }
                            if (fuenteHogar2AF.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar2AF", "");
                            } else {
                                editorRD.putString("fuenteHogar2AF", fuenteHogar2AF.getText().toString());
                            }
                            if (fuenteHogar3AF.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar3AF", "");
                            } else {
                                editorRD.putString("fuenteHogar3AF", fuenteHogar3AF.getText().toString());
                            }
                            if (fuenteHogar4AF.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar4AF", "");
                            } else {
                                editorRD.putString("fuenteHogar4AF", fuenteHogar4AF.getText().toString());
                            }
                            if (fuenteHogar5AF.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar5AF", "");
                            } else {
                                editorRD.putString("fuenteHogar5AF", fuenteHogar5AF.getText().toString());
                            }
                            if (fuenteHogar5_1AF.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar5_1AF", "");
                            } else {
                                editorRD.putString("fuenteHogar5_1AF", fuenteHogar5_1AF.getText().toString());
                            }
                            if (totalAF.getText().toString().matches("")) {
                                editorRD.putString("totalAF", "");
                            } else {
                                editorRD.putString("totalAF", totalAF.getText().toString());
                            }
                            if (total_psAF.getText().toString().matches("")) {
                                editorRD.putString("total_psAF", "");
                            } else {
                                editorRD.putString("total_psAF", total_psAF.getText().toString());
                            }
                            if (total_hogarAF.getText().toString().matches("")) {
                                editorRD.putString("total_hogarAF", "");
                            } else {
                                editorRD.putString("total_hogarAF", total_hogarAF.getText().toString());
                            }
/*                            if (total_verifAF.getText().toString().matches("")) {
                                editorRD.putString("total_verifAF", "");
                            } else {
                                editorRD.putString("total_verifAF", total_verifAF.getText().toString());
                            }
*/
                            editorRD.commit();
                            if (sharedPreferences.getString("undM1AF", "").equals("U.medida..........") && !sharedPreferences.getString("con1AF", "").equals("SELECCIONE.......")) {
                                editor.putString("undM1AF", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM2AF", "").equals("U.medida..........") && !sharedPreferences.getString("con2AF", "").equals("SELECCIONE.......")) {
                                editor.putString("undM2AF", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM3AF", "").equals("U.medida..........") && !sharedPreferences.getString("con3AF", "").equals("SELECCIONE.......")) {
                                editor.putString("undM3AF", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM4AF", "").equals("U.medida..........") && !sharedPreferences.getString("con4AF", "").equals("SELECCIONE.......")) {
                                editor.putString("undM4AF", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM5AF", "").equals("U.medida..........") && !sharedPreferences.getString("con5AF", "").equals("")) {
                                editor.putString("undM5AF", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM5_1AF", "").equals("U.medida..........") && !sharedPreferences.getString("con5_1AF", "").equals("")) {
                                editor.putString("undM5_1AF", "Unidad");
                                editor.commit();
                            }

                            Intent intent = new Intent(ActFijos.this, Inversion.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            Toast.makeText(ActFijos.this, "Datos Guardados!", Toast.LENGTH_LONG).show();
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

        //       if(!(sharedPreferencesRD.getString("tipoP","").isEmpty() && sharedPreferencesRD.getString("tituloP","").isEmpty() && sharedPreferencesRD.getString("prodPrinc","").isEmpty()&& sharedPreferencesRD.getString("codAAF","").isEmpty()&& sharedPreferencesRD.getString("descrAAF","").isEmpty()&& sharedPreferencesRD.getString("descrPP","").isEmpty()&& sharedPreferencesRD.getString("oportunidades","").isEmpty())) {

        int tipop = sharedPreferencesRD.getInt("con1AF", 0);    //14 marzo
        con1AF.setSelection(tipop);                                         //14 marzo
        int tipop2 = sharedPreferencesRD.getInt("con2AF", 0);
        con2AF.setSelection(tipop2);
        int tipop3 = sharedPreferencesRD.getInt("con3AF", 0);    //14 marzo
        con3AF.setSelection(tipop3);
        int tipop4 = sharedPreferencesRD.getInt("con4AF", 0);
        con4AF.setSelection(sharedPreferencesRD.getInt("con4AF", 0));

        con5AF.setText(sharedPreferencesRD.getString("con5AF", ""));
        con5_1AF.setText(sharedPreferencesRD.getString("con5_1AF", ""));

        String tipop5 = sharedPreferencesRD.getString("cant1AF", "");
        cant1AF.setText(tipop5);
        String tipop6 = sharedPreferencesRD.getString("cant2AF", "");
        cant2AF.setText(tipop6);
        String tipop7 = sharedPreferencesRD.getString("cant3AF", "");
        cant3AF.setText(tipop7);
        String tipop8 = sharedPreferencesRD.getString("cant4AF", "");
        cant4AF.setText(tipop8);
        cant5AF.setText(sharedPreferencesRD.getString("cant5AF", ""));
        cant5_1AF.setText(sharedPreferencesRD.getString("cant5_1AF", ""));

        int tipop9 = sharedPreferencesRD.getInt("undM1AF", 0);
        undM1AF.setSelection(tipop9);
        int tipop10 = sharedPreferencesRD.getInt("undM2AF", 0);
        undM2AF.setSelection(tipop10);
        int tipop11 = sharedPreferencesRD.getInt("undM3AF", 0);
        undM3AF.setSelection(tipop11);
        int tipop12 = sharedPreferencesRD.getInt("undM4AF", 0);
        undM4AF.setSelection(tipop12);
        int tipop12_1 = sharedPreferencesRD.getInt("undM5AF", 0);
        undM5AF.setSelection(tipop12_1);
        undM5_1AF.setSelection(sharedPreferencesRD.getInt("undM5_1AF", 0));

        String tipop13 = sharedPreferencesRD.getString("valU1AF", "");
        valU1AF.setText(tipop13);
        String tipop14 = sharedPreferencesRD.getString("valU2AF", "");
        valU2AF.setText(tipop14);
        String tipop15 = sharedPreferencesRD.getString("valU3AF", "");
        valU3AF.setText(tipop15);
        String tipop16 = sharedPreferencesRD.getString("valU4AF", "");
        valU4AF.setText(tipop16);
        valU5AF.setText(sharedPreferencesRD.getString("valU5AF", ""));
        valU5_1AF.setText(sharedPreferencesRD.getString("valU5_1AF", ""));
        /* Comentado por Dayron - Verificación
        String tipop17 = sharedPreferencesRD.getString("ver1AF", "");
        if (tipop17.equals("Cumple")) {
            ver1AF.setSelection(0);

        } else {
            ver1AF.setSelection(1);
        }
        String tipop18 = sharedPreferencesRD.getString("ver2AF", "");
        if (tipop18.equals("Cumple")) {
            ver2AF.setSelection(0);
        } else {
            ver2AF.setSelection(1);
        }
        String tipop19 = sharedPreferencesRD.getString("ver3AF", "");
        if (tipop19.equals("Cumple")) {
            ver3AF.setSelection(0);
        } else {
            ver3AF.setSelection(1);
        }
        String tipop20 = sharedPreferencesRD.getString("ver4AF", "");
        if (tipop20.equals("Cumple")) {
            ver4AF.setSelection(0);
        } else {
            ver4AF.setSelection(1);
        }
        String tipop20_1 = sharedPreferencesRD.getString("ver5AF", "");
        if (tipop20_1.equals("Cumple")) {
            ver5AF.setSelection(0);
        } else {
            ver5AF.setSelection(1);
        }
        String tipop20_2 = sharedPreferencesRD.getString("ver5_1AF", "");
        if (tipop20_2.equals("Cumple")) {
            ver5_1AF.setSelection(0);
        } else {
            ver5_1AF.setSelection(1);
        }
        */
        String tipop21 = sharedPreferencesRD.getString("valT1AF", "");
        valT1AF.setText(tipop21);
        String tipop22 = sharedPreferencesRD.getString("valT2AF", "");
        valT2AF.setText(tipop22);
        String tipop23 = sharedPreferencesRD.getString("valT3AF", "");
        valT3AF.setText(tipop23);
        String tipop24 = sharedPreferencesRD.getString("valT4AF", "");
        valT4AF.setText(tipop24);
        String tipop25 = sharedPreferencesRD.getString("valT5AF", "");
        valT5AF.setText(tipop25);
        valT5_1AF.setText(sharedPreferencesRD.getString("valT5_1AF", ""));

        String titulop26 = sharedPreferencesRD.getString("fuentePs1AF", "");
        fuentePs1AF.setText(titulop26);
        String titulop27 = sharedPreferencesRD.getString("fuentePs2AF", "");
        fuentePs2AF.setText(titulop27);
        String titulop28 = sharedPreferencesRD.getString("fuentePs3AF", "");
        fuentePs3AF.setText(titulop28);
        String titulop29 = sharedPreferencesRD.getString("fuentePs4AF", "");
        fuentePs4AF.setText(titulop29);
        fuentePs5AF.setText(sharedPreferencesRD.getString("fuentePs5AF", ""));
        fuentePs5_1AF.setText(sharedPreferencesRD.getString("fuentePs5_1AF", ""));
        String titulop30 = sharedPreferencesRD.getString("fuenteHogar1AF", "");
        fuenteHogar1AF.setText(titulop30);
        String titulop31 = sharedPreferencesRD.getString("fuenteHogar2AF", "");
        fuenteHogar2AF.setText(titulop31);
        String titulop32 = sharedPreferencesRD.getString("fuenteHogar3AF", "");
        fuenteHogar3AF.setText(titulop32);
        String titulop33 = sharedPreferencesRD.getString("fuenteHogar4AF", "");
        fuenteHogar4AF.setText(titulop33);
        fuenteHogar5AF.setText(sharedPreferencesRD.getString("fuenteHogar5AF", ""));
        fuenteHogar5_1AF.setText(sharedPreferencesRD.getString("fuenteHogar5_1AF", ""));
        String titulop34 = sharedPreferencesRD.getString("totalAF", "");
        totalAF.setText(titulop34);
        String titulop35 = sharedPreferencesRD.getString("total_psAF", "");
        total_psAF.setText(titulop35);
        String titulop36 = sharedPreferencesRD.getString("total_hogarAF", "");
        total_hogarAF.setText(titulop36);
        String titulop37 = sharedPreferencesRD.getString("total_verifAF", "");
//        total_verifAF.setText(titulop37);

    }


    public void ir(View view) {
        totalAF.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(totalAF, InputMethodManager.SHOW_IMPLICIT);
    }

    public void calcular(View view) {
        switch (view.getId()) {
            case R.id.C1:
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant1AF.getText().toString().matches("")) {
                } else {

                    if (!valU1AF.getText().toString().matches("")) {
                        valT1AF.setText(String.valueOf(Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString())));
                        try {
                            GT = Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString()) + 0 + 0 + 0;
                            GT_PS = Integer.parseInt(fuentePs1AF.getText().toString());
                            GT_HOG = Integer.parseInt(fuenteHogar1AF.getText().toString());
                        } catch (Exception e) {
                        }
                        editor.putString("valT1AF", valT1AF.getText().toString());
                        editorRD.putString("valT1AF", valT1AF.getText().toString());
                        totalAF.setText(String.valueOf(GT));
                        total_psAF.setText(String.valueOf(GT_PS));
                        total_hogarAF.setText(String.valueOf(GT_HOG));
                    } else {
                        editor.putString("valT1AF", "");
                        editorRD.putString("valT1AF", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C2:

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (!cant2AF.getText().toString().matches("") && !cant1AF.getText().toString().matches("") && !valU2AF.getText().toString().matches("") && !valU1AF.getText().toString().matches("")) {
                    valT2AF.setText(String.valueOf(Integer.parseInt(cant2AF.getText().toString()) * Integer.parseInt(valU2AF.getText().toString())));
                    try {
                        GT = Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString()) + Integer.parseInt(cant2AF.getText().toString()) * Integer.parseInt(valU2AF.getText().toString()) + 0 + 0;
                        GT_PS = Integer.parseInt(fuentePs1AF.getText().toString()) + Integer.parseInt(fuentePs2AF.getText().toString());
                        GT_HOG = Integer.parseInt(fuenteHogar1AF.getText().toString()) + Integer.parseInt(fuenteHogar2AF.getText().toString());
                    } catch (Exception e) {
                    }
                    editor.putString("valT2AF", valT2AF.getText().toString());
                    editorRD.putString("valT2AF", valT2AF.getText().toString());
                    totalAF.setText(String.valueOf(GT));
                    total_psAF.setText(String.valueOf(GT_PS));
                    total_hogarAF.setText(String.valueOf(GT_HOG));
                } else {
                    Toast.makeText(this, "Complete todo los datos de arriba.", Toast.LENGTH_SHORT).show();
                    editor.putString("valT2AF", "");
                    editorRD.putString("valT2AF", "");
                }
                editor.commit();
                editorRD.commit();
                //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();

                break;
            case R.id.C3:
                Toast.makeText(this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant3AF.getText().toString().matches("")) {
                } else {

                    if (!valU3AF.getText().toString().matches("")) {
                        valT3AF.setText(String.valueOf(Integer.parseInt(cant3AF.getText().toString()) * Integer.parseInt(valU3AF.getText().toString())));
                        editor.putString("valT3AF", valT3AF.getText().toString());
                        editorRD.putString("valT3AF", valT3AF.getText().toString());
                        if (!valU2AF.getText().toString().matches("") && !cant2AF.getText().toString().matches("")) {
                            try {
                                GT = Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString()) + Integer.parseInt(cant2AF.getText().toString()) * Integer.parseInt(valU2AF.getText().toString()) + Integer.parseInt(cant3AF.getText().toString()) * Integer.parseInt(valU3AF.getText().toString()) + 0;
                                GT_PS = Integer.parseInt(fuentePs1AF.getText().toString()) + Integer.parseInt(fuentePs2AF.getText().toString()) + Integer.parseInt(fuentePs3AF.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1AF.getText().toString()) + Integer.parseInt(fuenteHogar2AF.getText().toString()) + Integer.parseInt(fuenteHogar3AF.getText().toString());
                            } catch (Exception e) {
                            }
                            totalAF.setText(String.valueOf(GT));
                            total_psAF.setText(String.valueOf(GT_PS));
                            total_hogarAF.setText(String.valueOf(GT_HOG));
                        }
                    } else {
                        editor.putString("valT3AF", "");
                        editorRD.putString("valT3AF", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C4:
                Toast.makeText(this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant4AF.getText().toString().matches("")) {
                } else {

                    if (!valU4AF.getText().toString().matches("")) {
                        valT4AF.setText(String.valueOf(Integer.parseInt(cant4AF.getText().toString()) * Integer.parseInt(valU4AF.getText().toString())));
                        editor.putString("valT4AF", valT4AF.getText().toString());
                        editorRD.putString("valT4AF", valT4AF.getText().toString());
                        if (!valU2AF.getText().toString().matches("") && !valU3AF.getText().toString().matches("") && !cant2AF.getText().toString().matches("") && !cant3AF.getText().toString().matches("")) {
                            try {
                                GT = Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString()) + Integer.parseInt(cant2AF.getText().toString()) * Integer.parseInt(valU2AF.getText().toString()) + Integer.parseInt(cant3AF.getText().toString()) * Integer.parseInt(valU3AF.getText().toString()) + Integer.parseInt(cant4AF.getText().toString()) * Integer.parseInt(valU4AF.getText().toString());
                                GT_PS = Integer.parseInt(fuentePs1AF.getText().toString()) + Integer.parseInt(fuentePs2AF.getText().toString()) + Integer.parseInt(fuentePs3AF.getText().toString()) + Integer.parseInt(fuentePs4AF.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1AF.getText().toString()) + Integer.parseInt(fuenteHogar2AF.getText().toString()) + Integer.parseInt(fuenteHogar3AF.getText().toString()) + Integer.parseInt(fuenteHogar4AF.getText().toString());
                            } catch (Exception e) {
                            }
                            // Toast.makeText(this, ""+String.valueOf(GT), Toast.LENGTH_SHORT).show();
                            totalAF.setText(String.valueOf(GT));
                            total_psAF.setText(String.valueOf(GT_PS));
                            total_hogarAF.setText(String.valueOf(GT_HOG));
                        }
                    } else {
                        editor.putString("valT4AF", "");
                        editorRD.putString("valT4AF", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C5:
                Toast.makeText(ActFijos.this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant5AF.getText().toString().matches("")) {
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0;
                    if (!valU5AF.getText().toString().matches("")) {
                        valT5AF.setText(String.valueOf(Integer.parseInt(cant5AF.getText().toString()) * Integer.parseInt(valU5AF.getText().toString())));

                        editor.putString("valT5CT", valT5AF.getText().toString());
                        editorRD.putString("valT5CT", valT5AF.getText().toString());

                        if (valU1AF.getText().toString().matches("") && cant1AF.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString());
                        }
                        if (valU2AF.getText().toString().matches("") && cant2AF.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2AF.getText().toString()) * Integer.parseInt(valU2AF.getText().toString());
                        }
                        if (valU3AF.getText().toString().matches("") && cant3AF.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3AF.getText().toString()) * Integer.parseInt(valU3AF.getText().toString());
                        }
                        if (valU4AF.getText().toString().matches("") && cant4AF.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4AF.getText().toString()) * Integer.parseInt(valU4AF.getText().toString());
                        }

                        if (fuentePs1AF.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1AF.getText().toString());
                        }
                        if (fuentePs2AF.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2AF.getText().toString());
                        }
                        if (fuentePs3AF.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3AF.getText().toString());
                        }
                        if (fuentePs4AF.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4AF.getText().toString());
                        }

                        if (fuenteHogar1AF.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1AF.getText().toString());
                        }
                        if (fuenteHogar2AF.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2AF.getText().toString());
                        }
                        if (fuenteHogar3AF.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3AF.getText().toString());
                        }
                        if (fuenteHogar4AF.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4AF.getText().toString());
                        }

                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + Integer.parseInt(cant5AF.getText().toString()) * Integer.parseInt(valU5AF.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + Integer.parseInt(fuentePs5AF.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + Integer.parseInt(fuenteHogar5AF.getText().toString());
                        } catch (Exception e) {
                        }
                        totalAF.setText(String.valueOf(GT));
                        total_psAF.setText(String.valueOf(GT_PS));
                        total_hogarAF.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5AF", "");
                        editorRD.putString("valT5AF", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C5_1:

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();

                if (cant5_1AF.getText().toString().matches("") || valU5_1AF.getText().toString().matches("")) {
                    Toast.makeText(ActFijos.this, "Revise que este todo completo", Toast.LENGTH_LONG).show();
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorT5 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorPS5 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0, valorHogar5 = 0;
                    if (!valU5_1AF.getText().toString().matches("")) {
                        valT5_1AF.setText(String.valueOf(Integer.parseInt(cant5_1AF.getText().toString()) * Integer.parseInt(valU5_1AF.getText().toString())));

                        editor.putString("valT5_1AF", valT5_1AF.getText().toString());
                        editorRD.putString("valT5_1AF", valT5_1AF.getText().toString());

                        if (valU1AF.getText().toString().matches("") && cant1AF.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1AF.getText().toString()) * Integer.parseInt(valU1AF.getText().toString());
                        }
                        if (valU2AF.getText().toString().matches("") && cant2AF.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2AF.getText().toString()) * Integer.parseInt(valU2AF.getText().toString());
                        }
                        if (valU3AF.getText().toString().matches("") && cant3AF.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3AF.getText().toString()) * Integer.parseInt(valU3AF.getText().toString());
                        }
                        if (valU4AF.getText().toString().matches("") && cant4AF.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4AF.getText().toString()) * Integer.parseInt(valU4AF.getText().toString());
                        }
                        if (valU5AF.getText().toString().matches("") && cant5AF.getText().toString().matches("")) {
                            valorT5 = 0;
                        } else {
                            valorT5 = Integer.parseInt(cant5AF.getText().toString()) * Integer.parseInt(valU5AF.getText().toString());
                        }

                        if (fuentePs1AF.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1AF.getText().toString());
                        }
                        if (fuentePs2AF.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2AF.getText().toString());
                        }
                        if (fuentePs3AF.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3AF.getText().toString());
                        }
                        if (fuentePs4AF.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4AF.getText().toString());
                        }
                        if (fuentePs5AF.getText().toString().matches("")) {
                            valorPS5 = 0;
                        } else {
                            valorPS5 = Integer.parseInt(fuentePs5AF.getText().toString());
                        }

                        if (fuenteHogar1AF.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1AF.getText().toString());
                        }
                        if (fuenteHogar2AF.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2AF.getText().toString());
                        }
                        if (fuenteHogar3AF.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3AF.getText().toString());
                        }
                        if (fuenteHogar4AF.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4AF.getText().toString());
                        }
                        if (fuenteHogar5AF.getText().toString().matches("")) {
                            valorHogar5 = 0;
                        } else {
                            valorHogar5 = Integer.parseInt(fuenteHogar5AF.getText().toString());
                        }


                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + valorT5 + Integer.parseInt(cant5_1AF.getText().toString()) * Integer.parseInt(valU5_1AF.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + valorPS5 + Integer.parseInt(fuentePs5_1AF.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + valorHogar5 + Integer.parseInt(fuenteHogar5_1AF.getText().toString());
                        } catch (Exception e) {
                        }
                        totalAF.setText(String.valueOf(GT));
                        total_psAF.setText(String.valueOf(GT_PS));
                        total_hogarAF.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5_1AF", "");
                        editorRD.putString("valT5_1AF", "");
                    }
                    /* Comentado por Dayron - Verificación
                    editor.putString("ver5_1AF", ver5_1AF.getSelectedItem().toString());
                    editorRD.putString("ver5_1AF", ver5_1AF.getSelectedItem().toString());
                     */

                    editor.commit();
                    editorRD.commit();
                }
                break;

        }


    }

    public void toogle(View view) {
        expandableLayout.toggle();
    }
}
