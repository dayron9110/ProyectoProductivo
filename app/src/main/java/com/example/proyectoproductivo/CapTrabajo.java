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

public class CapTrabajo extends AppCompatActivity {

    EditText con5CT, con5_1CT, cant1CT, cant2CT, cant3CT, cant4CT, cant5CT, cant5_1CT, valU1CT, valU2CT, valU3CT, valU4CT, valU5CT, valU5_1CT;
    EditText valT1CT, valT2CT, valT3CT, valT4CT, valT5CT, valT5_1CT, fuentePs1CT, fuentePs2CT, fuentePs3CT, fuentePs4CT, fuentePs5CT, fuentePs5_1CT, fuenteHogar1CT, fuenteHogar2CT, fuenteHogar3CT, fuenteHogar4CT, fuenteHogar5CT, fuenteHogar5_1CT;
    int GT, GT_PS, GT_HOG;
    ArrayAdapter<String> dataAdapterS_A, dataAdapterS_A_peces, dataAdapterS_A_cerdos, dataAdapterS_A_bovino, dataAdapterS_A_aves_corral, dataAdapterS_C_restaurante, dataAdapterS_G_comercio, dataAdapterS_G_papeleria, dataAdapterS_G_ropa, dataAdapterS_S_peluqueria, dataAdapterOtros;
    EditText totalCT, total_psCT, total_hogarCT;//total_verifCT;
    Spinner con1CT, con2CT, con3CT, con4CT;
    Button ItemAdicional;
    ExpandableWeightLayout expandableLayout;
    TextView VSug1, VSug2, VSug3, VSug4;
    AppCompatSpinner ver1CT, ver2CT, ver3CT, ver4CT, ver5CT, ver5_1CT, undM1CT, undM2CT, undM3CT, undM4CT, undM5CT, undM5_1CT;
    BottomNavigationView btnNV;
    String ShaPreSector;
    private SharedPreferences sharedPreferences, sharedPreferencesRD, dataEncuenta;
    SharedPreferences.Editor editor, editorRD;
    HashMap<String, String> hm = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap_trabajo);
        ItemAdicional = findViewById(R.id.expandButton);
        ItemAdicional.setText("Tiene un insumo adicional? " + Character.toString((char) 9660) + " ");
        expandableLayout
                = (ExpandableWeightLayout) findViewById(R.id.expandableLayout);
        btnNV = findViewById(R.id.navigationView);
        con1CT = findViewById(R.id.CON1CT);
        con2CT = findViewById(R.id.CON2CT);
        con3CT = findViewById(R.id.CON3CT);
        con4CT = findViewById(R.id.CON4CT);
        con5CT = findViewById(R.id.CON5CT);
        con5_1CT = findViewById(R.id.CON5_1CT);
        cant1CT = findViewById(R.id.CAN1CT);
        cant2CT = findViewById(R.id.CAN2CT);
        cant3CT = findViewById(R.id.CAN3CT);
        cant4CT = findViewById(R.id.CAN4CT);
        cant5CT = findViewById(R.id.CAN5CT);
        cant5_1CT = findViewById(R.id.CAN5_1CT);
        undM1CT = findViewById(R.id.UM1CT);
        undM2CT = findViewById(R.id.UM2CT);
        undM3CT = findViewById(R.id.UM3CT);
        undM4CT = findViewById(R.id.UM4CT);
        undM5CT = findViewById(R.id.UM5CT);
        undM5_1CT = findViewById(R.id.UM5_1CT);
        valU1CT = findViewById(R.id.VU1CT);
        valU2CT = findViewById(R.id.VU2CT);
        valU3CT = findViewById(R.id.VU3CT);
        valU4CT = findViewById(R.id.VU4CT);
        valU5CT = findViewById(R.id.VU5CT);
        valU5_1CT = findViewById(R.id.VU5_1CT);
        ver1CT = findViewById(R.id.VERF1CT);
        ver2CT = findViewById(R.id.VERF2CT);
        ver3CT = findViewById(R.id.VERF3CT);
        ver4CT = findViewById(R.id.VERF4CT);
        ver5CT = findViewById(R.id.VERF5CT);
        ver5_1CT = findViewById(R.id.VERF5_1CT);
        valT1CT = findViewById(R.id.VT1CT);
        valT2CT = findViewById(R.id.VT2CT);
        valT3CT = findViewById(R.id.VT3CT);
        valT4CT = findViewById(R.id.VT4CT);
        valT5CT = findViewById(R.id.VT5CT);
        valT5_1CT = findViewById(R.id.VT5_1CT);
        fuentePs1CT = findViewById(R.id.PS1CT);
        fuentePs2CT = findViewById(R.id.PS2CT);
        fuentePs3CT = findViewById(R.id.PS3CT);
        fuentePs4CT = findViewById(R.id.PS4CT);
        fuentePs5CT = findViewById(R.id.PS5CT);
        fuentePs5_1CT = findViewById(R.id.PS5_1CT);
        fuenteHogar1CT = findViewById(R.id.HO1CT);
        fuenteHogar2CT = findViewById(R.id.HO2CT);
        fuenteHogar3CT = findViewById(R.id.HO3CT);
        fuenteHogar4CT = findViewById(R.id.HO4CT);
        fuenteHogar5CT = findViewById(R.id.HO5CT);
        fuenteHogar5_1CT = findViewById(R.id.HO5_1CT);
        VSug1 = findViewById(R.id.VSug1CT);
        VSug2 = findViewById(R.id.VSug2CT);
        VSug3 = findViewById(R.id.VSug3CT);
        VSug4 = findViewById(R.id.VSug4CT);

        totalCT = findViewById(R.id.TOTAL_CT);
        total_psCT = findViewById(R.id.TOTAL_PS_CT);
        total_hogarCT = findViewById(R.id.TOTAL_HOGAR_CT);
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
        list_Sec_A.add("FERTILIZANTES");
        list_Sec_A.add("HERBICIDAS");
        list_Sec_A.add("INSECTICIDAS");
        list_Sec_A.add("FINGICIDAS");
        list_Sec_A.add("SEMILLAS");
        list_Sec_A.add("PLANTULAS");
        List<String> list_Sec_A_peces = new ArrayList<String>();
        list_Sec_A_peces.add("Seleccione......");
        list_Sec_A_peces.add("CALANDRIO Y /O ANZUELOS");
        list_Sec_A_peces.add("BARREDERAS");
        list_Sec_A_peces.add("MALLA");
        list_Sec_A_peces.add("PLOMO");
        list_Sec_A_peces.add("BALDE");
        List<String> list_Sec_A_cerdos = new ArrayList<String>();
        list_Sec_A_cerdos.add("Seleccione......");
        list_Sec_A_cerdos.add("CONCENTRADO");
        list_Sec_A_cerdos.add("ANTIPARASITARIOS");
        list_Sec_A_cerdos.add("VITAMINAS");
        list_Sec_A_cerdos.add("PORCINOS");
        List<String> list_Sec_A_bovino = new ArrayList<String>();
        list_Sec_A_bovino.add("Seleccione......");
        list_Sec_A_bovino.add("CONCENTRADO");
        list_Sec_A_bovino.add("SAL Y MELASA");
        list_Sec_A_bovino.add("BOVINOS");
        list_Sec_A_bovino.add("MEDICAMENTOS");
        List<String> list_Sec_A_aves_corral = new ArrayList<String>();
        list_Sec_A_aves_corral.add("Seleccione......");
        list_Sec_A_aves_corral.add("MEDICAMENTOS");
        list_Sec_A_aves_corral.add("VITAMINAS");
        list_Sec_A_aves_corral.add("CONCENTRADO");
        list_Sec_A_aves_corral.add("AVES DE CORRAL");
        List<String> list_Sec_C_restaurante = new ArrayList<String>();
        list_Sec_C_restaurante.add("Seleccione......");
        list_Sec_C_restaurante.add("VERDURAS");
        list_Sec_C_restaurante.add("FRUTAS");
        list_Sec_C_restaurante.add("TUBERCULOS");
        list_Sec_C_restaurante.add("LEGUMBRES");
        list_Sec_C_restaurante.add("BEBIDAS");
        List<String> list_Sec_G_comercio = new ArrayList<String>();
        list_Sec_G_comercio.add("Seleccione......");//FRUVER
        list_Sec_G_comercio.add("VERDURAS");
        list_Sec_G_comercio.add("FRUTAS");
        list_Sec_G_comercio.add("TUBERCULOS");
        list_Sec_G_comercio.add("LEGUMBRES");
        ;
        list_Sec_G_comercio.add("BEBIDAS");
        List<String> list_Sec_G_papeleria = new ArrayList<String>();
        list_Sec_G_papeleria.add("Seleccione......");
        list_Sec_G_papeleria.add("UTILES ESCOLARES(cuadernos,esferos,lapices y marcadores,tijeras,colbon,cartulinas,cinta)");
        List<String> list_Sec_G_ropa = new ArrayList<String>();
        list_Sec_G_ropa.add("Seleccione......");
        list_Sec_G_ropa.add("ROPA");
        list_Sec_G_ropa.add("CALZADO");
        list_Sec_G_ropa.add("ACCESORIOS");
        List<String> list_Sec_S_peluqueria = new ArrayList<String>();
        list_Sec_S_peluqueria.add("Seleccione......");
        list_Sec_S_peluqueria.add("ESMALTES");
        list_Sec_S_peluqueria.add("TINTURAS");
        list_Sec_S_peluqueria.add("GEL");
        list_Sec_S_peluqueria.add("LACA");
        list_Sec_S_peluqueria.add("SHAMPOOS");
        List<String> list_Otros = new ArrayList<String>();  //mio 25 marzo
        list_Otros.add("Seleccione......");
        list_Otros.add("FERTILIZANTES");
        list_Otros.add("HERBICIDAS");
        list_Otros.add("INSECTICIDAS");
        list_Otros.add("FINGICIDAS");
        list_Otros.add("SEMILLAS");
        list_Otros.add("PLANTULAS");
        list_Otros.add("PLOMO");
        list_Otros.add("BALDE");
        list_Otros.add("CALANDRIO Y /O ANZUELOS");
        list_Otros.add("BARREDERAS");
        list_Otros.add("MALLA");
        list_Otros.add("CONCENTRADO");
        list_Otros.add("ANTIPARASITARIOS");
        list_Otros.add("VITAMINAS");
        list_Otros.add("PORCINOS");
        list_Otros.add("AVES DE CORRAL");
        list_Otros.add("SAL Y MELASA");
        list_Otros.add("BOVINOS");
        list_Otros.add("MEDICAMENTOS");
        list_Otros.add("VERDURAS");
        list_Otros.add("FRUTAS");
        list_Otros.add("TUBERCULOS");
        list_Otros.add("LEGUMBRES");
        list_Otros.add("BEBIDAS");
        list_Otros.add("UTILES ESCOLARES(cuadernos,esferos,lapices y marcadores,tijeras,colbon,cartulinas,cinta)");
        list_Otros.add("ROPA");
        list_Otros.add("CALZADO");
        list_Otros.add("ACCESORIOS");
        list_Otros.add("ESMALTES");
        list_Otros.add("TINTURAS");
        list_Otros.add("GEL");
        list_Otros.add("LACA");
        list_Otros.add("SHAMPOOS");

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
            con1CT.setAdapter(dataAdapterS_A_peces);
            con2CT.setAdapter(dataAdapterS_A_peces);
            con3CT.setAdapter(dataAdapterS_A_peces);
            con4CT.setAdapter(dataAdapterS_A_peces);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0144")) {
            con1CT.setAdapter(dataAdapterS_A_cerdos);
            con2CT.setAdapter(dataAdapterS_A_cerdos);
            con3CT.setAdapter(dataAdapterS_A_cerdos);
            con4CT.setAdapter(dataAdapterS_A_cerdos);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0145")) {
            con1CT.setAdapter(dataAdapterS_A_aves_corral);
            con2CT.setAdapter(dataAdapterS_A_aves_corral);
            con3CT.setAdapter(dataAdapterS_A_aves_corral);
            con4CT.setAdapter(dataAdapterS_A_aves_corral);
        } else if (ShaPreSector.equals("SECCION A") && sharedPreferences.getString("codAct", "").equals("0141")) {
            con1CT.setAdapter(dataAdapterS_A_bovino);
            con2CT.setAdapter(dataAdapterS_A_bovino);
            con3CT.setAdapter(dataAdapterS_A_bovino);
            con4CT.setAdapter(dataAdapterS_A_bovino);
        } else if (ShaPreSector.equals("SECCION A")) {
            con1CT.setAdapter(dataAdapterS_A);
            con2CT.setAdapter(dataAdapterS_A);
            con3CT.setAdapter(dataAdapterS_A);
            con4CT.setAdapter(dataAdapterS_A);
        }

        if (ShaPreSector.equals("SECCION C")) {
            con1CT.setAdapter(dataAdapterS_C_restaurante);
            con2CT.setAdapter(dataAdapterS_C_restaurante);
            con3CT.setAdapter(dataAdapterS_C_restaurante);
            con4CT.setAdapter(dataAdapterS_C_restaurante);
        } //


        if (ShaPreSector.equals("SECCION G") && (sharedPreferences.getString("codAct", "").substring(0, 3).equals("471") || sharedPreferences.getString("codAct", "").substring(0, 3).equals("472") || sharedPreferences.getString("codAct", "").equals("4781"))) {
            con1CT.setAdapter(dataAdapterS_G_comercio);
            con2CT.setAdapter(dataAdapterS_G_comercio);
            con3CT.setAdapter(dataAdapterS_G_comercio);
            con4CT.setAdapter(dataAdapterS_G_comercio);
        } //47
        else if (ShaPreSector.equals("SECCION G") && sharedPreferences.getString("codAct", "").substring(0, 2).equals("46")) {
            con1CT.setAdapter(dataAdapterS_G_ropa);
            con2CT.setAdapter(dataAdapterS_G_ropa);
            con3CT.setAdapter(dataAdapterS_G_ropa);
            con4CT.setAdapter(dataAdapterS_G_ropa);
        } else if (ShaPreSector.equals("SECCION G") && (sharedPreferences.getString("codAct", "").substring(0, 3).equals("479") || sharedPreferences.getString("codAct", "").equals("4789") || sharedPreferences.getString("codAct", "").equals("4782"))) {
            con1CT.setAdapter(dataAdapterS_G_papeleria);
            con2CT.setAdapter(dataAdapterS_G_papeleria);
            con3CT.setAdapter(dataAdapterS_G_papeleria);
            con4CT.setAdapter(dataAdapterS_G_papeleria);
        } else if (ShaPreSector.equals("SECCION G")) {
            con1CT.setAdapter(dataAdapterOtros);
            con2CT.setAdapter(dataAdapterOtros);
            con3CT.setAdapter(dataAdapterOtros);
            con4CT.setAdapter(dataAdapterOtros);
        }


        if (ShaPreSector.equals("SECCION S")) {
            con1CT.setAdapter(dataAdapterS_S_peluqueria);
            con2CT.setAdapter(dataAdapterS_S_peluqueria);
            con3CT.setAdapter(dataAdapterS_S_peluqueria);
            con4CT.setAdapter(dataAdapterS_S_peluqueria);
        } //
//9602
        if (ShaPreSector.equals("SECCION B") || ShaPreSector.equals("SECCION D") || ShaPreSector.equals("SECCION E") || ShaPreSector.equals("SECCION F") || ShaPreSector.equals("SECCION H") || ShaPreSector.equals("SECCION I") || ShaPreSector.equals("SECCION J") || ShaPreSector.equals("SECCION Q") || ShaPreSector.equals("SECCION R") || ShaPreSector.equals("SECCION T")) {
            con1CT.setAdapter(dataAdapterOtros);
            con2CT.setAdapter(dataAdapterOtros);
            con3CT.setAdapter(dataAdapterOtros);
            con4CT.setAdapter(dataAdapterOtros);
        }


        ArrayAdapter<CharSequence> adapterUM = ArrayAdapter.createFromResource(this, R.array.und_medida, R.layout.textview);
        undM1CT.setAdapter(adapterUM);
        undM2CT.setAdapter(adapterUM);
        undM3CT.setAdapter(adapterUM);
        undM4CT.setAdapter(adapterUM);

        undM1CT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM1CT", posicionUM);
                editorRD.commit();
                editor.putString("undM1CT", undM1CT.getSelectedItem().toString());
                editor.commit();
                if (!con1CT.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU1CT.setHint("Sugerido:"+hm.get(con1CT.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con1CT.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug1.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM2CT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM2CT", posicionUM);
                editorRD.commit();
                editor.putString("undM2CT", undM2CT.getSelectedItem().toString());
                editor.commit();
                if (!con2CT.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU2CT.setHint("Sugerido:"+hm.get(con2CT.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con2CT.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug2.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM3CT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM3CT", posicionUM);
                editorRD.commit();
                editor.putString("undM3CT", undM3CT.getSelectedItem().toString());
                editor.commit();
                if (!con3CT.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU3CT.setHint("Sugerido:"+hm.get(con3CT.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con3CT.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug3.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        undM4CT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM4CT", posicionUM);
                editorRD.commit();
                editor.putString("undM4CT", undM4CT.getSelectedItem().toString());
                editor.commit();
                if (!con4CT.getSelectedItem().toString().equals("Seleccione......")) {
                    //    valU4CT.setHint("Sugerido:"+hm.get(con4CT.getSelectedItem().toString()));
                    Spannable WordtoSpan = new SpannableString("Sugerido:  " + hm.get(con4CT.getSelectedItem().toString()));
                    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    VSug4.setText(WordtoSpan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM5CT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                //Toast.makeText(ActFijos.this, ""+String.valueOf(posicionUM), Toast.LENGTH_SHORT).show();
                editorRD.putInt("undM5CT", posicionUM);
                editorRD.commit();
                editor.putString("undM5CT", undM5CT.getSelectedItem().toString());
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        undM5_1CT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.RED);
                }
                int posicionUM = position;
                editorRD.putInt("undM5_1CT", posicionUM);
                editorRD.commit();
                editor.putString("undM5_1CT", undM5_1CT.getSelectedItem().toString());
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ver1CT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver1CT", ver1CT.getSelectedItem().toString());
                editorRD.putString("ver1CT", ver1CT.getSelectedItem().toString());
                if (cant1CT.getText().toString().matches("")) {
                } else {

                    if (!valU1CT.getText().toString().matches("")) {
                        valT1CT.setText(String.valueOf(Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString())));
                        try {
                            GT = Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString()) + 0 + 0 + 0;
                            GT_PS = Integer.parseInt(fuentePs1CT.getText().toString());
                            GT_HOG = Integer.parseInt(fuenteHogar1CT.getText().toString());
                        } catch (Exception e) {
                        }
                        totalCT.setText(String.valueOf(GT));
                        total_psCT.setText(String.valueOf(GT_PS));
                        total_hogarCT.setText(String.valueOf(GT_HOG));
                        editor.putString("valT1CT", valT1CT.getText().toString());
                        editorRD.putString("valT1CT", valT1CT.getText().toString());
                    } else {
                        editor.putString("valT1CT", "");
                        editorRD.putString("valT1CT", "");
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

        ver2CT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver2CT", ver2CT.getSelectedItem().toString());
                editorRD.putString("ver2CT", ver2CT.getSelectedItem().toString());
                if (!cant2CT.getText().toString().matches("") && !cant1CT.getText().toString().matches("") && !valU2CT.getText().toString().matches("") && !valU1CT.getText().toString().matches("")) {
                    valT2CT.setText(String.valueOf(Integer.parseInt(cant2CT.getText().toString()) * Integer.parseInt(valU2CT.getText().toString())));
                    try {
                        GT = Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString()) + Integer.parseInt(cant2CT.getText().toString()) * Integer.parseInt(valU2CT.getText().toString()) + 0 + 0;
                        GT_PS = Integer.parseInt(fuentePs1CT.getText().toString()) + Integer.parseInt(fuentePs2CT.getText().toString());
                        GT_HOG = Integer.parseInt(fuenteHogar1CT.getText().toString()) + Integer.parseInt(fuenteHogar2CT.getText().toString());
                    } catch (Exception e) {
                    }
                    totalCT.setText(String.valueOf(GT));
                    total_psCT.setText(String.valueOf(GT_PS));
                    total_hogarCT.setText(String.valueOf(GT_HOG));
                    editor.putString("valT2CT", valT2CT.getText().toString());
                    editorRD.putString("valT2CT", valT2CT.getText().toString());
                } else {
                    Toast.makeText(CapTrabajo.this, "Complete todos los datos del 2do recuadro.", Toast.LENGTH_SHORT).show();
                    editor.putString("valT2CT", "");
                    editorRD.putString("valT2CT", "");
                }
                editor.commit();
                editorRD.commit();
                //        Toast.makeText(ACTFijos.this, sharedPreferencesRD.getString("valT1CT", ""), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ver3CT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver3CT", ver3CT.getSelectedItem().toString());
                editorRD.putString("ver3CT", ver3CT.getSelectedItem().toString());
                if (cant3CT.getText().toString().matches("") || valU3CT.getText().toString().matches("")) {
                    Toast.makeText(CapTrabajo.this, "Complete todos los datos del 3er recuadro.", Toast.LENGTH_LONG).show();

                } else {

                    if (!valU3CT.getText().toString().matches("")) {
                        valT3CT.setText(String.valueOf(Integer.parseInt(cant3CT.getText().toString()) * Integer.parseInt(valU3CT.getText().toString())));
                        editor.putString("valT3CT", valT3CT.getText().toString());
                        editorRD.putString("valT3CT", valT3CT.getText().toString());
                        if (!valU2CT.getText().toString().matches("") && !cant2CT.getText().toString().matches("")) {
                            try {
                                GT = Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString()) + Integer.parseInt(cant2CT.getText().toString()) * Integer.parseInt(valU2CT.getText().toString()) + Integer.parseInt(cant3CT.getText().toString()) * Integer.parseInt(valU3CT.getText().toString()) + 0;
                                GT_PS = Integer.parseInt(fuentePs1CT.getText().toString()) + Integer.parseInt(fuentePs2CT.getText().toString()) + Integer.parseInt(fuentePs3CT.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1CT.getText().toString()) + Integer.parseInt(fuenteHogar2CT.getText().toString()) + Integer.parseInt(fuenteHogar3CT.getText().toString());
                            } catch (Exception e) {
                            }
                            totalCT.setText(String.valueOf(GT));
                            total_psCT.setText(String.valueOf(GT_PS));
                            total_hogarCT.setText(String.valueOf(GT_HOG));
                        }
                    } else {
                        editor.putString("valT3CT", "");
                        editorRD.putString("valT3CT", "");
                    }
                    editor.commit();
                    editorRD.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });

        ver4CT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver4CT", ver4CT.getSelectedItem().toString());
                editorRD.putString("ver4CT", ver4CT.getSelectedItem().toString());
                if (cant4CT.getText().toString().matches("") || valU4CT.getText().toString().matches("")) {
                    Toast.makeText(CapTrabajo.this, "Complete todos los datos del 4to recuadro.", Toast.LENGTH_LONG).show();
                } else {

                    if (!valU4CT.getText().toString().matches("")) {
                        valT4CT.setText(String.valueOf(Integer.parseInt(cant4CT.getText().toString()) * Integer.parseInt(valU4CT.getText().toString())));

                        editor.putString("valT4CT", valT4CT.getText().toString());
                        editorRD.putString("valT4CT", valT4CT.getText().toString());
                        if (!valU2CT.getText().toString().matches("") && !valU3CT.getText().toString().matches("") && !cant2CT.getText().toString().matches("") && !cant3CT.getText().toString().matches("")) {

                            try {
                                GT = Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString()) + Integer.parseInt(cant2CT.getText().toString()) * Integer.parseInt(valU2CT.getText().toString()) + Integer.parseInt(cant3CT.getText().toString()) * Integer.parseInt(valU3CT.getText().toString()) + Integer.parseInt(cant4CT.getText().toString()) * Integer.parseInt(valU4CT.getText().toString());
                                GT_PS = Integer.parseInt(fuentePs1CT.getText().toString()) + Integer.parseInt(fuentePs2CT.getText().toString()) + Integer.parseInt(fuentePs3CT.getText().toString()) + Integer.parseInt(fuentePs4CT.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1CT.getText().toString()) + Integer.parseInt(fuenteHogar2CT.getText().toString()) + Integer.parseInt(fuenteHogar3CT.getText().toString()) + Integer.parseInt(fuenteHogar4CT.getText().toString());
                            } catch (Exception e) {
                            }
                            totalCT.setText(String.valueOf(GT));
                            total_psCT.setText(String.valueOf(GT_PS));
                            total_hogarCT.setText(String.valueOf(GT_HOG));

                        }
                    } else {
                        editor.putString("valT4CT", "");
                        editorRD.putString("valT4CT", "");
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
        ver5CT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CapTrabajo.this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                editor.putString("ver5CT", ver5CT.getSelectedItem().toString());
                editorRD.putString("ver5CT", ver5CT.getSelectedItem().toString());
                if (cant5CT.getText().toString().matches("")) {
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0;
                    if (!valU5CT.getText().toString().matches("")) {
                        valT5CT.setText(String.valueOf(Integer.parseInt(cant5CT.getText().toString()) * Integer.parseInt(valU5CT.getText().toString())));

                        editor.putString("valT5CT", valT5CT.getText().toString());
                        editorRD.putString("valT5CT", valT5CT.getText().toString());

                        if (valU1CT.getText().toString().matches("") && cant1CT.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString());
                        }
                        if (valU2CT.getText().toString().matches("") && cant2CT.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2CT.getText().toString()) * Integer.parseInt(valU2CT.getText().toString());
                        }
                        if (valU3CT.getText().toString().matches("") && cant3CT.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3CT.getText().toString()) * Integer.parseInt(valU3CT.getText().toString());
                        }
                        if (valU4CT.getText().toString().matches("") && cant4CT.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4CT.getText().toString()) * Integer.parseInt(valU4CT.getText().toString());
                        }

                        if (fuentePs1CT.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1CT.getText().toString());
                        }
                        if (fuentePs2CT.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2CT.getText().toString());
                        }
                        if (fuentePs3CT.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3CT.getText().toString());
                        }
                        if (fuentePs4CT.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4CT.getText().toString());
                        }

                        if (fuenteHogar1CT.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1CT.getText().toString());
                        }
                        if (fuenteHogar2CT.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2CT.getText().toString());
                        }
                        if (fuenteHogar3CT.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3CT.getText().toString());
                        }
                        if (fuenteHogar4CT.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4CT.getText().toString());
                        }

                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + Integer.parseInt(cant5CT.getText().toString()) * Integer.parseInt(valU5CT.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + Integer.parseInt(fuentePs5CT.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + Integer.parseInt(fuenteHogar5CT.getText().toString());
                        } catch (Exception e) {
                        }
                        totalCT.setText(String.valueOf(GT));
                        total_psCT.setText(String.valueOf(GT_PS));
                        total_hogarCT.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5CT", "");
                        editorRD.putString("valT5CT", "");
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
        ver5_1CT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();

                if (cant5_1CT.getText().toString().matches("") || valU5_1CT.getText().toString().matches("")) {
                    Toast.makeText(CapTrabajo.this, "Revise que este todo completo", Toast.LENGTH_LONG).show();
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorT5 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorPS5 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0, valorHogar5 = 0;
                    if (!valU5_1CT.getText().toString().matches("")) {
                        valT5_1CT.setText(String.valueOf(Integer.parseInt(cant5_1CT.getText().toString()) * Integer.parseInt(valU5_1CT.getText().toString())));

                        editor.putString("valT5_1CT", valT5_1CT.getText().toString());
                        editorRD.putString("valT5_1CT", valT5_1CT.getText().toString());

                        if (valU1CT.getText().toString().matches("") && cant1CT.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString());
                        }
                        if (valU2CT.getText().toString().matches("") && cant2CT.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2CT.getText().toString()) * Integer.parseInt(valU2CT.getText().toString());
                        }
                        if (valU3CT.getText().toString().matches("") && cant3CT.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3CT.getText().toString()) * Integer.parseInt(valU3CT.getText().toString());
                        }
                        if (valU4CT.getText().toString().matches("") && cant4CT.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4CT.getText().toString()) * Integer.parseInt(valU4CT.getText().toString());
                        }
                        if (valU5CT.getText().toString().matches("") && cant5CT.getText().toString().matches("")) {
                            valorT5 = 0;
                        } else {
                            valorT5 = Integer.parseInt(cant5CT.getText().toString()) * Integer.parseInt(valU5CT.getText().toString());
                        }

                        if (fuentePs1CT.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1CT.getText().toString());
                        }
                        if (fuentePs2CT.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2CT.getText().toString());
                        }
                        if (fuentePs3CT.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3CT.getText().toString());
                        }
                        if (fuentePs4CT.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4CT.getText().toString());
                        }
                        if (fuentePs5CT.getText().toString().matches("")) {
                            valorPS5 = 0;
                        } else {
                            valorPS5 = Integer.parseInt(fuentePs5CT.getText().toString());
                        }

                        if (fuenteHogar1CT.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1CT.getText().toString());
                        }
                        if (fuenteHogar2CT.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2CT.getText().toString());
                        }
                        if (fuenteHogar3CT.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3CT.getText().toString());
                        }
                        if (fuenteHogar4CT.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4CT.getText().toString());
                        }
                        if (fuenteHogar5CT.getText().toString().matches("")) {
                            valorHogar5 = 0;
                        } else {
                            valorHogar5 = Integer.parseInt(fuenteHogar5CT.getText().toString());
                        }


                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + valorT5 + Integer.parseInt(cant5_1CT.getText().toString()) * Integer.parseInt(valU5_1CT.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + valorPS5 + Integer.parseInt(fuentePs5_1CT.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + valorHogar5 + Integer.parseInt(fuenteHogar5_1CT.getText().toString());
                        } catch (Exception e) {
                        }
                        totalCT.setText(String.valueOf(GT));
                        total_psCT.setText(String.valueOf(GT_PS));
                        total_hogarCT.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5_1CT", "");
                        editorRD.putString("valT5_1CT", "");
                    }
                    editor.putString("ver5_1CT", ver5_1CT.getSelectedItem().toString());
                    editorRD.putString("ver5_1CT", ver5_1CT.getSelectedItem().toString());
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
                        // CapTrabajo.super.onBackPressed();
                        Intent intent = new Intent(CapTrabajo.this, Inversion.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        // revisar             intent.putExtra("encuestas",sharedPreferences.getString("datosver", ""));
                        startActivity(intent);
                    }
                    break;
                    case R.id.next: {
                        //  SharedPreferences.Editor editor = sharedPreferences.edit();
                        //       editor.clear();editor.commit();

                        if (con1CT.getSelectedItem().toString().matches("Seleccione......") || cant1CT.getText().toString().matches("")
                                || valT1CT.getText().toString().matches("") || fuentePs1CT.getText().toString().matches("")
                                || fuenteHogar1CT.getText().toString().matches("") || totalCT.getText().toString().matches("")) {
                            Toast.makeText(CapTrabajo.this, "Llene todos los campos, la seccion de Totales (abajo)", Toast.LENGTH_LONG).show();
                        } else {
                            // revisar               editor.putString("CC", editTextCC.getText().toString());
                            //       Toast.makeText(MainActivity.this, ""+nombre.getText().toString(), Toast.LENGTH_SHORT).show();
             /*               if(tipoProyec.getText()!=null) {

                                editor.putString("tipoP", tipoProyec.getText().toString());

                                //Toast.makeText(MainActivity.this, "no tiene segundo nombre", Toast.LENGTH_SHORT).show();
                            }
 */
                            editor.putString("con1CT", con1CT.getSelectedItem().toString());
                            if (con2CT.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con2CT", "");
                            } else {
                                editor.putString("con2CT", con2CT.getSelectedItem().toString());
                            }
                            if (con3CT.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con3CT", "");
                            } else {
                                editor.putString("con3CT", con3CT.getSelectedItem().toString());
                            }
                            if (con4CT.getSelectedItem().toString().matches("Seleccione......")) {
                                editor.putString("con4CT", "");
                            } else {
                                editor.putString("con4CT", con4CT.getSelectedItem().toString());
                            }
                            if (con5CT.getText().toString().matches("")) {
                                editor.putString("con5CT", "");
                            } else {
                                editor.putString("con5CT", con5CT.getText().toString());
                            }
                            if (con5_1CT.getText().toString().matches("")) {
                                editor.putString("con5_1CT", "");
                            } else {
                                editor.putString("con5_1CT", con5_1CT.getText().toString());
                            }
                            if (cant1CT.getText().toString().matches("")) {
                                editor.putString("cant1CT", "");
                            } else {
                                editor.putString("cant1CT", cant1CT.getText().toString());
                            }
                            if (cant2CT.getText().toString().matches("")) {
                                editor.putString("cant2CT", "");
                            } else {
                                editor.putString("cant2CT", cant2CT.getText().toString());
                            }
                            if (cant3CT.getText().toString().matches("")) {
                                editor.putString("cant3CT", "");
                            } else {
                                editor.putString("cant3CT", cant3CT.getText().toString());
                            }
                            if (cant4CT.getText().toString().matches("")) {
                                editor.putString("cant4CT", "");
                            } else {
                                editor.putString("cant4CT", cant4CT.getText().toString());
                            }
                            if (cant5CT.getText().toString().matches("")) {
                                editor.putString("cant5CT", "");
                            } else {
                                editor.putString("cant5CT", cant5CT.getText().toString());
                            }
                            if (cant5_1CT.getText().toString().matches("")) {
                                editor.putString("cant5_1CT", "");
                            } else {
                                editor.putString("cant5_1CT", cant5_1CT.getText().toString());
                            }

                            if (valU1CT.getText().toString().matches("")) {
                                editor.putString("valU1CT", "");
                            } else {
                                editor.putString("valU1CT", valU1CT.getText().toString());
                            }
                            if (valU2CT.getText().toString().matches("")) {
                                editor.putString("valU2CT", "");
                            } else {
                                editor.putString("valU2CT", valU2CT.getText().toString());
                            }
                            if (valU3CT.getText().toString().matches("")) {
                                editor.putString("valU3CT", "");
                            } else {
                                editor.putString("valU3CT", valU3CT.getText().toString());
                            }
                            if (valU4CT.getText().toString().matches("")) {
                                editor.putString("valU4CT", "");
                            } else {
                                editor.putString("valU4CT", valU4CT.getText().toString());
                            }
                            if (valU5CT.getText().toString().matches("")) {
                                editor.putString("valU5CT", "");
                            } else {
                                editor.putString("valU5CT", valU5CT.getText().toString());
                            }
                            if (valU5_1CT.getText().toString().matches("")) {
                                editor.putString("valU5_1CT", "");
                            } else {
                                editor.putString("valU5_1CT", valU5_1CT.getText().toString());
                            }
                            /*if (ver1CT.getSelectedItem().toString().matches("")) {
                                editor.putString("ver1CT", "");
                            } else {
                                editor.putString("ver1CT",ver1CT.getSelectedItem().toString());
                            }
                            if (ver2CT.getSelectedItem().toString().matches("")) {
                                editor.putString("ver2CT", "");
                            } else {
                                editor.putString("ver2CT", ver2CT.getSelectedItem().toString());
                            }
                            if (ver3CT.getSelectedItem().toString().matches("")) {
                                editor.putString("ver3CT", "");
                            } else {
                                editor.putString("ver3CT", ver3CT.getSelectedItem().toString());
                            }
                            if (ver4CT.getSelectedItem().toString().matches("")) {
                                editor.putString("ver4CT", "");
                            } else {
                                editor.putString("ver4CT", ver4CT.getSelectedItem().toString());
                            }
                            if (ver5CT.getSelectedItem().toString().matches("")) {
                                editor.putString("ver5CT", "");
                            } else {
                                editor.putString("ver5CT", ver5CT.getSelectedItem().toString());
                            }*/
                            if (fuentePs1CT.getText().toString().matches("")) {
                                editor.putString("fuentePs1CT", "");
                            } else {
                                editor.putString("fuentePs1CT", fuentePs1CT.getText().toString());
                            }
                            if (fuentePs2CT.getText().toString().matches("")) {
                                editor.putString("fuentePs2CT", "");
                            } else {
                                editor.putString("fuentePs2CT", fuentePs2CT.getText().toString());
                            }
                            if (fuentePs3CT.getText().toString().matches("")) {
                                editor.putString("fuentePs3CT", "");
                            } else {
                                editor.putString("fuentePs3CT", fuentePs3CT.getText().toString());
                            }
                            if (fuentePs4CT.getText().toString().matches("")) {
                                editor.putString("fuentePs4CT", "");
                            } else {
                                editor.putString("fuentePs4CT", fuentePs4CT.getText().toString());
                            }
                            if (fuentePs5CT.getText().toString().matches("")) {
                                editor.putString("fuentePs5CT", "");
                            } else {
                                editor.putString("fuentePs5CT", fuentePs5CT.getText().toString());
                            }
                            if (fuentePs5_1CT.getText().toString().matches("")) {
                                editor.putString("fuentePs5_1CT", "");
                            } else {
                                editor.putString("fuentePs5_1CT", fuentePs5_1CT.getText().toString());
                            }
                            if (fuenteHogar1CT.getText().toString().matches("")) {
                                editor.putString("fuenteHogar1CT", "");
                            } else {
                                editor.putString("fuenteHogar1CT", fuenteHogar1CT.getText().toString());
                            }
                            if (fuenteHogar2CT.getText().toString().matches("")) {
                                editor.putString("fuenteHogar2CT", "");
                            } else {
                                editor.putString("fuenteHogar2CT", fuenteHogar2CT.getText().toString());
                            }
                            if (fuenteHogar3CT.getText().toString().matches("")) {
                                editor.putString("fuenteHogar3CT", "");
                            } else {
                                editor.putString("fuenteHogar3CT", fuenteHogar3CT.getText().toString());
                            }
                            if (fuenteHogar4CT.getText().toString().matches("")) {
                                editor.putString("fuenteHogar4CT", "");
                            } else {
                                editor.putString("fuenteHogar4CT", fuenteHogar4CT.getText().toString());
                            }
                            if (fuenteHogar5CT.getText().toString().matches("")) {
                                editor.putString("fuenteHogar5CT", "");
                            } else {
                                editor.putString("fuenteHogar5CT", fuenteHogar5CT.getText().toString());
                            }
                            if (fuenteHogar5_1CT.getText().toString().matches("")) {
                                editor.putString("fuenteHogar5_1CT", "");
                            } else {
                                editor.putString("fuenteHogar5_1CT", fuenteHogar5_1CT.getText().toString());
                            }
                            if (totalCT.getText().toString().matches("")) {
                                editor.putString("totalCT", "");
                            } else {
                                editor.putString("totalCT", totalCT.getText().toString());
                            }
                            if (total_psCT.getText().toString().matches("")) {
                                editor.putString("total_psCT", "");
                            } else {
                                editor.putString("total_psCT", total_psCT.getText().toString());
                            }
                            if (total_hogarCT.getText().toString().matches("")) {
                                editor.putString("total_hogarCT", "");
                            } else {
                                editor.putString("total_hogarCT", total_hogarCT.getText().toString());
                            }
                     /*       if (total_verifCT.getText().toString().matches("")) {
                                editor.putString("total_verifCT", "");
                            } else {
                                editor.putString("total_verifCT", total_verifCT.getText().toString());
                            }*/
                            editor.commit();

                            editorRD.putInt("con1CT", con1CT.getSelectedItemPosition());     //14 marzo
                            editorRD.putInt("con2CT", con2CT.getSelectedItemPosition());
                            editorRD.putInt("con3CT", con3CT.getSelectedItemPosition());
                            editorRD.putInt("con4CT", con4CT.getSelectedItemPosition());

                            if (con5CT.getText().toString().matches("")) {
                                editorRD.putString("con5CT", "");
                            } else {
                                editorRD.putString("con5CT", con5CT.getText().toString());
                            }
                            if (con5_1CT.getText().toString().matches("")) {
                                editorRD.putString("con5_1CT", "");
                            } else {
                                editorRD.putString("con5_1CT", con5_1CT.getText().toString());
                            }
                            if (cant1CT.getText().toString().matches("")) {
                                editorRD.putString("cant1CT", "");
                            } else {
                                editorRD.putString("cant1CT", cant1CT.getText().toString());
                            }
                            if (cant2CT.getText().toString().matches("")) {
                                editorRD.putString("cant2CT", "");
                            } else {
                                editorRD.putString("cant2CT", cant2CT.getText().toString());
                            }
                            if (cant3CT.getText().toString().matches("")) {
                                editorRD.putString("cant3CT", "");
                            } else {
                                editorRD.putString("cant3CT", cant3CT.getText().toString());
                            }
                            if (cant4CT.getText().toString().matches("")) {
                                editorRD.putString("cant4CT", "");
                            } else {
                                editorRD.putString("cant4CT", cant4CT.getText().toString());
                            }
                            if (cant5CT.getText().toString().matches("")) {
                                editorRD.putString("cant5CT", "");
                            } else {
                                editorRD.putString("cant5CT", cant5CT.getText().toString());
                            }
                            if (cant5_1CT.getText().toString().matches("")) {
                                editorRD.putString("cant5_1CT", "");
                            } else {
                                editorRD.putString("cant5_1CT", cant5_1CT.getText().toString());
                            }
                            if (valU1CT.getText().toString().matches("")) {
                                editorRD.putString("valU1CT", "");
                            } else {
                                editorRD.putString("valU1CT", valU1CT.getText().toString());
                            }
                            if (valU2CT.getText().toString().matches("")) {
                                editorRD.putString("valU2CT", "");
                            } else {
                                editorRD.putString("valU2CT", valU2CT.getText().toString());
                            }
                            if (valU3CT.getText().toString().matches("")) {
                                editorRD.putString("valU3CT", "");
                            } else {
                                editorRD.putString("valU3CT", valU3CT.getText().toString());
                            }
                            if (valU4CT.getText().toString().matches("")) {
                                editorRD.putString("valU4CT", "");
                            } else {
                                editorRD.putString("valU4CT", valU4CT.getText().toString());
                            }
                            if (valU5CT.getText().toString().matches("")) {
                                editorRD.putString("valU5CT", "");
                            } else {
                                editorRD.putString("valU5CT", valU5CT.getText().toString());
                            }
                            if (valU5_1CT.getText().toString().matches("")) {
                                editorRD.putString("valU5_1CT", "");
                            } else {
                                editorRD.putString("valU5_1CT", valU5_1CT.getText().toString());
                            }
                            /*if (ver1CT.getSelectedItem().toString().matches("")) {
                                editorRD.putString("ver1CT", "");
                            } else {
                                editorRD.putString("ver1CT",ver1CT.getSelectedItem().toString());
                            }
                            if (ver2CT.getSelectedItem().toString().matches("")) {
                                editorRD.putString("ver2CT", "");
                            } else {
                                editorRD.putString("ver2CT", ver2CT.getSelectedItem().toString());
                            }
                            if (ver3CT.getSelectedItem().toString().matches("")) {
                                editorRD.putString("ver3CT", "");
                            } else {
                                editorRD.putString("ver3CT", ver3CT.getSelectedItem().toString());
                            }
                            if (ver4CT.getSelectedItem().toString().matches("")) {
                                editorRD.putString("ver4CT", "");
                            } else {
                                editorRD.putString("ver4CT", ver4CT.getSelectedItem().toString());
                            }
                            if (ver5CT.getSelectedItem().toString().matches("")) {
                                editorRD.putString("ver5CT", "");
                            } else {
                                editorRD.putString("ver5CT", ver5CT.getSelectedItem().toString());
                            }*/
                            if (fuentePs1CT.getText().toString().matches("")) {
                                editorRD.putString("fuentePs1CT", "");
                            } else {
                                editorRD.putString("fuentePs1CT", fuentePs1CT.getText().toString());
                            }
                            if (fuentePs2CT.getText().toString().matches("")) {
                                editorRD.putString("fuentePs2CT", "");
                            } else {
                                editorRD.putString("fuentePs2CT", fuentePs2CT.getText().toString());
                            }
                            if (fuentePs3CT.getText().toString().matches("")) {
                                editorRD.putString("fuentePs3CT", "");
                            } else {
                                editorRD.putString("fuentePs3CT", fuentePs3CT.getText().toString());
                            }
                            if (fuentePs4CT.getText().toString().matches("")) {
                                editorRD.putString("fuentePs4CT", "");
                            } else {
                                editorRD.putString("fuentePs4CT", fuentePs4CT.getText().toString());
                            }
                            if (fuentePs5CT.getText().toString().matches("")) {
                                editorRD.putString("fuentePs5CT", "");
                            } else {
                                editorRD.putString("fuentePs5CT", fuentePs5CT.getText().toString());
                            }
                            if (fuentePs5_1CT.getText().toString().matches("")) {
                                editorRD.putString("fuentePs5_1CT", "");
                            } else {
                                editorRD.putString("fuentePs5_1CT", fuentePs5_1CT.getText().toString());
                            }
                            if (fuenteHogar1CT.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar1CT", "");
                            } else {
                                editorRD.putString("fuenteHogar1CT", fuenteHogar1CT.getText().toString());
                            }
                            if (fuenteHogar2CT.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar2CT", "");
                            } else {
                                editorRD.putString("fuenteHogar2CT", fuenteHogar2CT.getText().toString());
                            }
                            if (fuenteHogar3CT.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar3CT", "");
                            } else {
                                editorRD.putString("fuenteHogar3CT", fuenteHogar3CT.getText().toString());
                            }
                            if (fuenteHogar4CT.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar4CT", "");
                            } else {
                                editorRD.putString("fuenteHogar4CT", fuenteHogar4CT.getText().toString());
                            }
                            if (fuenteHogar5CT.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar5CT", "");
                            } else {
                                editorRD.putString("fuenteHogar5CT", fuenteHogar5CT.getText().toString());
                            }
                            if (fuenteHogar5_1CT.getText().toString().matches("")) {
                                editorRD.putString("fuenteHogar5_1CT", "");
                            } else {
                                editorRD.putString("fuenteHogar5_1CT", fuenteHogar5_1CT.getText().toString());
                            }
                            if (totalCT.getText().toString().matches("")) {
                                editorRD.putString("totalCT", "");
                            } else {
                                editorRD.putString("totalCT", totalCT.getText().toString());
                            }
                            if (total_psCT.getText().toString().matches("")) {
                                editorRD.putString("total_psCT", "");
                            } else {
                                editorRD.putString("total_psCT", total_psCT.getText().toString());
                            }
                            if (total_hogarCT.getText().toString().matches("")) {
                                editorRD.putString("total_hogarCT", "");
                            } else {
                                editorRD.putString("total_hogarCT", total_hogarCT.getText().toString());
                            }
                      /*      if (total_verifCT.getText().toString().matches("")) {
                                editorRD.putString("total_verifCT", "");
                            } else {
                                editorRD.putString("total_verifCT", total_verifCT.getText().toString());
                            }*/
                            editorRD.commit();
                            if (sharedPreferences.getString("undM1CT", "").equals("U.medida..........") && !sharedPreferences.getString("con1CT", "").equals("SELECCIONE.......")) {
                                editor.putString("undM1CT", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM2CT", "").equals("U.medida..........") && !sharedPreferences.getString("con2CT", "").equals("SELECCIONE.......")) {
                                editor.putString("undM2CT", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM3CT", "").equals("U.medida..........") && !sharedPreferences.getString("con3CT", "").equals("SELECCIONE.......")) {
                                editor.putString("undM3CT", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM4CT", "").equals("U.medida..........") && !sharedPreferences.getString("con4CT", "").equals("SELECCIONE.......")) {
                                editor.putString("undM4CT", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM5CT", "").equals("U.medida..........") && !sharedPreferences.getString("con5CT", "").equals("")) {
                                editor.putString("undM5CT", "Unidad");
                                editor.commit();
                            }
                            if (sharedPreferences.getString("undM5_1CT", "").equals("U.medida..........") && !sharedPreferences.getString("con5_1CT", "").equals("")) {
                                editor.putString("undM5_1CT", "Unidad");
                                editor.commit();
                            }
                            Intent intent = new Intent(CapTrabajo.this, Inversion.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            Toast.makeText(CapTrabajo.this, "Datos Guardados!", Toast.LENGTH_LONG).show();
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
        int tipop = sharedPreferencesRD.getInt("con1CT", 0);    //14 marzo
        con1CT.setSelection(tipop);                                         //14 marzo
        int tipop2 = sharedPreferencesRD.getInt("con2CT", 0);
        con2CT.setSelection(tipop2);
        int tipop3 = sharedPreferencesRD.getInt("con3CT", 0);    //14 marzo
        con3CT.setSelection(tipop3);
        int tipop4 = sharedPreferencesRD.getInt("con4CT", 0);
        con4CT.setSelection(tipop4);
        con5CT.setText(sharedPreferencesRD.getString("con5CT", ""));
        con5_1CT.setText(sharedPreferencesRD.getString("con5_1CT", ""));
        String tipop5 = sharedPreferencesRD.getString("cant1CT", "");
        cant1CT.setText(tipop5);
        String tipop6 = sharedPreferencesRD.getString("cant2CT", "");
        cant2CT.setText(tipop6);
        String tipop7 = sharedPreferencesRD.getString("cant3CT", "");
        cant3CT.setText(tipop7);
        String tipop8 = sharedPreferencesRD.getString("cant4CT", "");
        cant4CT.setText(tipop8);
        cant5CT.setText(sharedPreferencesRD.getString("cant5CT", ""));
        cant5_1CT.setText(sharedPreferencesRD.getString("cant5_1CT", ""));
        int tipop9 = sharedPreferencesRD.getInt("undM1CT", 0);
        undM1CT.setSelection(tipop9);
        int tipop10 = sharedPreferencesRD.getInt("undM2CT", 0);
        undM2CT.setSelection(tipop10);
        int tipop11 = sharedPreferencesRD.getInt("undM3CT", 0);
        undM3CT.setSelection(tipop11);
        int tipop12 = sharedPreferencesRD.getInt("undM4CT", 0);
        undM4CT.setSelection(tipop12);
        int tipop12_1 = sharedPreferencesRD.getInt("undM5CT", 0);
        undM5CT.setSelection(tipop12_1);
        int tipop12_2 = sharedPreferencesRD.getInt("undM5_1CT", 0);
        undM5CT.setSelection(tipop12_2);

        String tipop13 = sharedPreferencesRD.getString("valU1CT", "");
        valU1CT.setText(tipop13);
        String tipop14 = sharedPreferencesRD.getString("valU2CT", "");
        valU2CT.setText(tipop14);
        String tipop15 = sharedPreferencesRD.getString("valU3CT", "");
        valU3CT.setText(tipop15);
        String tipop16 = sharedPreferencesRD.getString("valU4CT", "");
        valU4CT.setText(tipop16);
        valU5CT.setText(sharedPreferencesRD.getString("valU5CT", ""));
        valU5_1CT.setText(sharedPreferencesRD.getString("valU5_1CT", ""));
        String tipop17 = sharedPreferencesRD.getString("ver1CT", "");
        if (tipop17.equals("Cumple")) {
            ver1CT.setSelection(0);
        } else {
            ver1CT.setSelection(1);
        }
        String tipop18 = sharedPreferencesRD.getString("ver2CT", "");
        if (tipop18.equals("Cumple")) {
            ver2CT.setSelection(0);
        } else {
            ver2CT.setSelection(1);
        }
        String tipop19 = sharedPreferencesRD.getString("ver3CT", "");
        if (tipop19.equals("Cumple")) {
            ver3CT.setSelection(0);
        } else {
            ver3CT.setSelection(1);
        }
        String tipop20 = sharedPreferencesRD.getString("ver4CT", "");
        if (tipop20.equals("Cumple")) {
            ver4CT.setSelection(0);
        } else {
            ver4CT.setSelection(1);
        }
        String tipop20_1 = sharedPreferencesRD.getString("ver5CT", "");
        if (tipop20_1.equals("Cumple")) {
            ver5CT.setSelection(0);
        } else {
            ver5CT.setSelection(1);
        }
        String tipop20_2 = sharedPreferencesRD.getString("ver5_1CT", "");
        if (tipop20_2.equals("Cumple")) {
            ver5_1CT.setSelection(0);
        } else {
            ver5_1CT.setSelection(1);
        }

        String tipop21 = sharedPreferencesRD.getString("valT1CT", "");
        valT1CT.setText(tipop21);
        String tipop22 = sharedPreferencesRD.getString("valT2CT", "");
        valT2CT.setText(tipop22);
        String tipop23 = sharedPreferencesRD.getString("valT3CT", "");
        valT3CT.setText(tipop23);
        String tipop24 = sharedPreferencesRD.getString("valT4CT", "");
        valT4CT.setText(tipop24);
        String tipop25 = sharedPreferencesRD.getString("valT5CT", "");
        valT5CT.setText(tipop25);
        valT5_1CT.setText(sharedPreferencesRD.getString("valT5_1CT", ""));

        String titulop26 = sharedPreferencesRD.getString("fuentePs1CT", "");
        fuentePs1CT.setText(titulop26);
        String titulop27 = sharedPreferencesRD.getString("fuentePs2CT", "");
        fuentePs2CT.setText(titulop27);
        String titulop28 = sharedPreferencesRD.getString("fuentePs3CT", "");
        fuentePs3CT.setText(titulop28);
        String titulop29 = sharedPreferencesRD.getString("fuentePs4CT", "");
        fuentePs4CT.setText(titulop29);
        fuentePs5CT.setText(sharedPreferencesRD.getString("fuentePs5CT", ""));
        fuentePs5_1CT.setText(sharedPreferencesRD.getString("fuentePs5_1CT", ""));
        String titulop30 = sharedPreferencesRD.getString("fuenteHogar1CT", "");
        fuenteHogar1CT.setText(titulop30);
        String titulop31 = sharedPreferencesRD.getString("fuenteHogar2CT", "");
        fuenteHogar2CT.setText(titulop31);
        String titulop32 = sharedPreferencesRD.getString("fuenteHogar3CT", "");
        fuenteHogar3CT.setText(titulop32);
        String titulop33 = sharedPreferencesRD.getString("fuenteHogar4CT", "");
        fuenteHogar4CT.setText(titulop33);
        fuenteHogar5CT.setText(sharedPreferencesRD.getString("fuenteHogar5CT", ""));
        fuenteHogar5_1CT.setText(sharedPreferencesRD.getString("fuenteHogar5_1CT", ""));
        String titulop34 = sharedPreferencesRD.getString("totalCT", "");
        totalCT.setText(titulop34);
        String titulop35 = sharedPreferencesRD.getString("total_psCT", "");
        total_psCT.setText(titulop35);
        String titulop36 = sharedPreferencesRD.getString("total_hogarCT", "");
        total_hogarCT.setText(titulop36);
        //     String titulop37 = sharedPreferencesRD.getString("total_verifCT", "");
        //     total_verifCT.setText(titulop37);


    }

    public void ir(View view) {
        totalCT.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(totalCT, InputMethodManager.SHOW_IMPLICIT);
    }

    public void calcular(View view) {
        switch (view.getId()) {
            case R.id.C1:
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant1CT.getText().toString().matches("")) {
                } else {

                    if (!valU1CT.getText().toString().matches("")) {
                        valT1CT.setText(String.valueOf(Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString())));
                        try {
                            GT = Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString()) + 0 + 0 + 0;
                            GT_PS = Integer.parseInt(fuentePs1CT.getText().toString());
                            GT_HOG = Integer.parseInt(fuenteHogar1CT.getText().toString());
                        } catch (Exception e) {
                        }
                        totalCT.setText(String.valueOf(GT));
                        total_psCT.setText(String.valueOf(GT_PS));
                        total_hogarCT.setText(String.valueOf(GT_HOG));
                        editor.putString("valT1CT", valT1CT.getText().toString());
                        editorRD.putString("valT1CT", valT1CT.getText().toString());
                    } else {
                        editor.putString("valT1CT", "");
                        editorRD.putString("valT1CT", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1CT", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C2:

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (!cant2CT.getText().toString().matches("") && !cant1CT.getText().toString().matches("") && !valU2CT.getText().toString().matches("") && !valU1CT.getText().toString().matches("")) {
                    valT2CT.setText(String.valueOf(Integer.parseInt(cant2CT.getText().toString()) * Integer.parseInt(valU2CT.getText().toString())));
                    try {
                        GT = Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString()) + Integer.parseInt(cant2CT.getText().toString()) * Integer.parseInt(valU2CT.getText().toString()) + 0 + 0;
                        GT_PS = Integer.parseInt(fuentePs1CT.getText().toString()) + Integer.parseInt(fuentePs2CT.getText().toString());
                        GT_HOG = Integer.parseInt(fuenteHogar1CT.getText().toString()) + Integer.parseInt(fuenteHogar2CT.getText().toString());
                    } catch (Exception e) {
                    }
                    totalCT.setText(String.valueOf(GT));
                    total_psCT.setText(String.valueOf(GT_PS));
                    total_hogarCT.setText(String.valueOf(GT_HOG));
                    editor.putString("valT2CT", valT2CT.getText().toString());
                    editorRD.putString("valT2CT", valT2CT.getText().toString());
                } else {
                    Toast.makeText(this, "Complete todo los datos de arriba.", Toast.LENGTH_SHORT).show();
                    editor.putString("valT2CT", "");
                    editorRD.putString("valT2CT", "");
                }
                editor.commit();
                editorRD.commit();
                //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1CT", ""), Toast.LENGTH_LONG).show();

                break;
            case R.id.C3:
                Toast.makeText(this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant3CT.getText().toString().matches("")) {
                } else {

                    if (!valU3CT.getText().toString().matches("")) {
                        valT3CT.setText(String.valueOf(Integer.parseInt(cant3CT.getText().toString()) * Integer.parseInt(valU3CT.getText().toString())));
                        editor.putString("valT3CT", valT3CT.getText().toString());
                        editorRD.putString("valT3CT", valT3CT.getText().toString());
                        if (!valU2CT.getText().toString().matches("") && !cant2CT.getText().toString().matches("")) {
                            try {
                                GT = Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString()) + Integer.parseInt(cant2CT.getText().toString()) * Integer.parseInt(valU2CT.getText().toString()) + Integer.parseInt(cant3CT.getText().toString()) * Integer.parseInt(valU3CT.getText().toString()) + 0;
                                GT_PS = Integer.parseInt(fuentePs1CT.getText().toString()) + Integer.parseInt(fuentePs2CT.getText().toString()) + Integer.parseInt(fuentePs3CT.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1CT.getText().toString()) + Integer.parseInt(fuenteHogar2CT.getText().toString()) + Integer.parseInt(fuenteHogar3CT.getText().toString());
                            } catch (Exception e) {
                            }
                            totalCT.setText(String.valueOf(GT));
                            total_psCT.setText(String.valueOf(GT_PS));
                            total_hogarCT.setText(String.valueOf(GT_HOG));
                        }
                    } else {
                        editor.putString("valT3CT", "");
                        editorRD.putString("valT3CT", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1CT", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C4:

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant4CT.getText().toString().matches("")) {
                } else {

                    if (!valU4CT.getText().toString().matches("")) {
                        valT4CT.setText(String.valueOf(Integer.parseInt(cant4CT.getText().toString()) * Integer.parseInt(valU4CT.getText().toString())));
                        editor.putString("valT4CT", valT4CT.getText().toString());
                        editorRD.putString("valT4CT", valT4CT.getText().toString());
                        if (!valU2CT.getText().toString().matches("") && !valU3CT.getText().toString().matches("") && !cant2CT.getText().toString().matches("") && !cant3CT.getText().toString().matches("")) {
                            try {
                                GT = Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString()) + Integer.parseInt(cant2CT.getText().toString()) * Integer.parseInt(valU2CT.getText().toString()) + Integer.parseInt(cant3CT.getText().toString()) * Integer.parseInt(valU3CT.getText().toString()) + Integer.parseInt(cant4CT.getText().toString()) * Integer.parseInt(valU4CT.getText().toString());
                                GT_PS = Integer.parseInt(fuentePs1CT.getText().toString()) + Integer.parseInt(fuentePs2CT.getText().toString()) + Integer.parseInt(fuentePs3CT.getText().toString()) + Integer.parseInt(fuentePs4CT.getText().toString());
                                GT_HOG = Integer.parseInt(fuenteHogar1CT.getText().toString()) + Integer.parseInt(fuenteHogar2CT.getText().toString()) + Integer.parseInt(fuenteHogar3CT.getText().toString()) + Integer.parseInt(fuenteHogar4CT.getText().toString());
                            } catch (Exception e) {
                            }
                            totalCT.setText(String.valueOf(GT));
                        }
                    } else {
                        editor.putString("valT4CT", "");
                        editorRD.putString("valT4CT", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1CT", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C5:
                Toast.makeText(CapTrabajo.this, "Todo esta lleno?", Toast.LENGTH_LONG).show();
                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();
                if (cant5CT.getText().toString().matches("")) {
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0;
                    if (!valU5CT.getText().toString().matches("")) {
                        valT5CT.setText(String.valueOf(Integer.parseInt(cant5CT.getText().toString()) * Integer.parseInt(valU5CT.getText().toString())));

                        editor.putString("valT5CT", valT5CT.getText().toString());
                        editorRD.putString("valT5CT", valT5CT.getText().toString());

                        if (valU1CT.getText().toString().matches("") && cant1CT.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString());
                        }
                        if (valU2CT.getText().toString().matches("") && cant2CT.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2CT.getText().toString()) * Integer.parseInt(valU2CT.getText().toString());
                        }
                        if (valU3CT.getText().toString().matches("") && cant3CT.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3CT.getText().toString()) * Integer.parseInt(valU3CT.getText().toString());
                        }
                        if (valU4CT.getText().toString().matches("") && cant4CT.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4CT.getText().toString()) * Integer.parseInt(valU4CT.getText().toString());
                        }

                        if (fuentePs1CT.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1CT.getText().toString());
                        }
                        if (fuentePs2CT.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2CT.getText().toString());
                        }
                        if (fuentePs3CT.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3CT.getText().toString());
                        }
                        if (fuentePs4CT.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4CT.getText().toString());
                        }

                        if (fuenteHogar1CT.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1CT.getText().toString());
                        }
                        if (fuenteHogar2CT.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2CT.getText().toString());
                        }
                        if (fuenteHogar3CT.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3CT.getText().toString());
                        }
                        if (fuenteHogar4CT.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4CT.getText().toString());
                        }

                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + Integer.parseInt(cant5CT.getText().toString()) * Integer.parseInt(valU5CT.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + Integer.parseInt(fuentePs5CT.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + Integer.parseInt(fuenteHogar5CT.getText().toString());
                        } catch (Exception e) {
                        }
                        totalCT.setText(String.valueOf(GT));
                        total_psCT.setText(String.valueOf(GT_PS));
                        total_hogarCT.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5CT", "");
                        editorRD.putString("valT5CT", "");
                    }
                    editor.commit();
                    editorRD.commit();
                    //        Toast.makeText(ActFijos.this, sharedPreferencesRD.getString("valT1AF", ""), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.C5_1:

                editor = sharedPreferences.edit();
                editorRD = sharedPreferencesRD.edit();

                if (cant5_1CT.getText().toString().matches("") || valU5_1CT.getText().toString().matches("")) {
                    Toast.makeText(CapTrabajo.this, "Revise que este todo completo", Toast.LENGTH_LONG).show();
                } else {
                    int valorT1 = 0, valorT2 = 0, valorT3 = 0, valorT4 = 0, valorT5 = 0, valorPS1 = 0, valorPS2 = 0, valorPS3 = 0, valorPS4 = 0, valorPS5 = 0, valorHogar1 = 0, valorHogar2 = 0, valorHogar3 = 0, valorHogar4 = 0, valorHogar5 = 0;
                    if (!valU5_1CT.getText().toString().matches("")) {
                        valT5_1CT.setText(String.valueOf(Integer.parseInt(cant5_1CT.getText().toString()) * Integer.parseInt(valU5_1CT.getText().toString())));

                        editor.putString("valT5_1CT", valT5_1CT.getText().toString());
                        editorRD.putString("valT5_1CT", valT5_1CT.getText().toString());

                        if (valU1CT.getText().toString().matches("") && cant1CT.getText().toString().matches("")) {
                            valorT1 = 0;
                        } else {
                            valorT1 = Integer.parseInt(cant1CT.getText().toString()) * Integer.parseInt(valU1CT.getText().toString());
                        }
                        if (valU2CT.getText().toString().matches("") && cant2CT.getText().toString().matches("")) {
                            valorT2 = 0;
                        } else {
                            valorT2 = Integer.parseInt(cant2CT.getText().toString()) * Integer.parseInt(valU2CT.getText().toString());
                        }
                        if (valU3CT.getText().toString().matches("") && cant3CT.getText().toString().matches("")) {
                            valorT3 = 0;
                        } else {
                            valorT3 = Integer.parseInt(cant3CT.getText().toString()) * Integer.parseInt(valU3CT.getText().toString());
                        }
                        if (valU4CT.getText().toString().matches("") && cant4CT.getText().toString().matches("")) {
                            valorT4 = 0;
                        } else {
                            valorT4 = Integer.parseInt(cant4CT.getText().toString()) * Integer.parseInt(valU4CT.getText().toString());
                        }
                        if (valU5CT.getText().toString().matches("") && cant5CT.getText().toString().matches("")) {
                            valorT5 = 0;
                        } else {
                            valorT5 = Integer.parseInt(cant5CT.getText().toString()) * Integer.parseInt(valU5CT.getText().toString());
                        }

                        if (fuentePs1CT.getText().toString().matches("")) {
                            valorPS1 = 0;
                        } else {
                            valorPS1 = Integer.parseInt(fuentePs1CT.getText().toString());
                        }
                        if (fuentePs2CT.getText().toString().matches("")) {
                            valorPS2 = 0;
                        } else {
                            valorPS2 = Integer.parseInt(fuentePs2CT.getText().toString());
                        }
                        if (fuentePs3CT.getText().toString().matches("")) {
                            valorPS3 = 0;
                        } else {
                            valorPS3 = Integer.parseInt(fuentePs3CT.getText().toString());
                        }
                        if (fuentePs4CT.getText().toString().matches("")) {
                            valorPS4 = 0;
                        } else {
                            valorPS4 = Integer.parseInt(fuentePs4CT.getText().toString());
                        }
                        if (fuentePs5CT.getText().toString().matches("")) {
                            valorPS5 = 0;
                        } else {
                            valorPS5 = Integer.parseInt(fuentePs5CT.getText().toString());
                        }

                        if (fuenteHogar1CT.getText().toString().matches("")) {
                            valorHogar1 = 0;
                        } else {
                            valorHogar1 = Integer.parseInt(fuenteHogar1CT.getText().toString());
                        }
                        if (fuenteHogar2CT.getText().toString().matches("")) {
                            valorHogar2 = 0;
                        } else {
                            valorHogar2 = Integer.parseInt(fuenteHogar2CT.getText().toString());
                        }
                        if (fuenteHogar3CT.getText().toString().matches("")) {
                            valorHogar3 = 0;
                        } else {
                            valorHogar3 = Integer.parseInt(fuenteHogar3CT.getText().toString());
                        }
                        if (fuenteHogar4CT.getText().toString().matches("")) {
                            valorHogar4 = 0;
                        } else {
                            valorHogar4 = Integer.parseInt(fuenteHogar4CT.getText().toString());
                        }
                        if (fuenteHogar5CT.getText().toString().matches("")) {
                            valorHogar5 = 0;
                        } else {
                            valorHogar5 = Integer.parseInt(fuenteHogar5CT.getText().toString());
                        }


                        try {
                            GT = valorT1 + valorT2 + valorT3 + valorT4 + valorT5 + Integer.parseInt(cant5_1CT.getText().toString()) * Integer.parseInt(valU5_1CT.getText().toString());
                            GT_PS = valorPS1 + valorPS2 + valorPS3 + valorPS4 + valorPS5 + Integer.parseInt(fuentePs5_1CT.getText().toString());
                            GT_HOG = valorHogar1 + valorHogar2 + valorHogar3 + valorHogar4 + valorHogar5 + Integer.parseInt(fuenteHogar5_1CT.getText().toString());
                        } catch (Exception e) {
                        }
                        totalCT.setText(String.valueOf(GT));
                        total_psCT.setText(String.valueOf(GT_PS));
                        total_hogarCT.setText(String.valueOf(GT_HOG));


                    } else {
                        editor.putString("valT5_1CT", "");
                        editorRD.putString("valT5_1CT", "");
                    }
                    editor.putString("ver5_1CT", ver5_1CT.getSelectedItem().toString());
                    editorRD.putString("ver5_1CT", ver5_1CT.getSelectedItem().toString());
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
