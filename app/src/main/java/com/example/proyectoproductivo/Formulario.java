package com.example.proyectoproductivo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Formulario extends AppCompatActivity {
    TextView cod_sec;
    Intent intent;
    private EditText ediTextTituloProyecto, ediTextProdPrincipal, codAct, descAct;
    private Spinner spinnerTipoProyecto, descPP, oport;
    private Spinner spinnerSectorProductivo;
    private Spinner spinnerCodigoActividad;
    String text, SECT, ACT;
    String[] tokens1, tokens2;
    BottomNavigationView btnNV;
    private SharedPreferences sharedPreferences, sharedPreferencesRD;
    SharedPreferences.Editor editor, editorRD;
    ArrayAdapter<String> dataAdapter, dataAdapter2;
    private List<String> list, list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        SECT = "";
        ACT = "";
        cod_sec = findViewById(R.id.exp_actEcono);
        btnNV = findViewById(R.id.navigationView);
        final HashMap<String, String> hm = new HashMap<>();
        spinnerSectorProductivo = findViewById(R.id.sectorP);
        spinnerCodigoActividad = findViewById(R.id.codigo_actividad);
        spinnerTipoProyecto = findViewById(R.id.tipo_proyecto);
        ediTextTituloProyecto = findViewById(R.id.titulo_proyecto);
        ediTextProdPrincipal = findViewById(R.id.producto_principal);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSectorProductivo.setAdapter(adapter);
        descPP = findViewById(R.id.descripcion_proyecto);
        oport = findViewById(R.id.oportunidades);
        sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        sharedPreferencesRD = getSharedPreferences("recuperadatos", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editorRD = sharedPreferencesRD.edit();
        poblarListas();
        dataAdapter = new ArrayAdapter<>(this, R.layout.textview1, list);
        dataAdapter.setDropDownViewResource(R.layout.textview1);
        descPP.setAdapter(dataAdapter);
        dataAdapter2 = new ArrayAdapter<String>(this, R.layout.textview1, list2);
        dataAdapter2.setDropDownViewResource(R.layout.textview1);
        oport.setAdapter(dataAdapter2);
        spinnerSectorProductivo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        SECT = String.valueOf(spinnerSectorProductivo.getSelectedItem());
                        tokens1 = SECT.split(Pattern.quote("."));
                        text = "SECCION A";
                        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Formulario.this, R.array.actividad_agricultura, R.layout.textview);
                        adapter.setDropDownViewResource(R.layout.textview);
                        spinnerCodigoActividad.setAdapter(adapter);
                        break;
                    case 2:
                        SECT = String.valueOf(spinnerSectorProductivo.getSelectedItem());
                        tokens1 = SECT.split(Pattern.quote("."));
                        text = "SECCION C";
                        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(Formulario.this, R.array.manufactureras, R.layout.textview);
                        adapter2.setDropDownViewResource(R.layout.textview);
                        spinnerCodigoActividad.setAdapter(adapter2);
                        break;
                    case 3:
                        SECT = String.valueOf(spinnerSectorProductivo.getSelectedItem());
                        tokens1 = SECT.split(Pattern.quote("."));
                        text = "SECCION E";
                        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(Formulario.this, R.array.trata_aguas_sane_amb, R.layout.textview);
                        adapter3.setDropDownViewResource(R.layout.textview);
                        spinnerCodigoActividad.setAdapter(adapter3);
                        break;
                    case 4:
                        SECT = String.valueOf(spinnerSectorProductivo.getSelectedItem());
                        tokens1 = SECT.split(Pattern.quote("."));
                        text = "SECCION F";
                        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(Formulario.this, R.array.construccion, R.layout.textview);
                        adapter4.setDropDownViewResource(R.layout.textview);
                        spinnerCodigoActividad.setAdapter(adapter4);
                        break;
                    case 5:
                        SECT = String.valueOf(spinnerSectorProductivo.getSelectedItem());
                        tokens1 = SECT.split(Pattern.quote("."));
                        text = "SECCION G";
                        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(Formulario.this, R.array.comer_auto_moto, R.layout.textview);
                        adapter5.setDropDownViewResource(R.layout.textview);
                        spinnerCodigoActividad.setAdapter(adapter5);
                        break;
                    case 6:
                        SECT = String.valueOf(spinnerSectorProductivo.getSelectedItem());
                        tokens1 = SECT.split(Pattern.quote("."));
                        text = "SECCION H";
                        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(Formulario.this, R.array.trans_almacena, R.layout.textview);
                        adapter6.setDropDownViewResource(R.layout.textview);
                        spinnerCodigoActividad.setAdapter(adapter6);
                        break;
                    case 7:
                        SECT = String.valueOf(spinnerSectorProductivo.getSelectedItem());
                        tokens1 = SECT.split(Pattern.quote("."));
                        text = "SECCION I";
                        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(Formulario.this, R.array.alojamiento_comida, R.layout.textview);
                        adapter7.setDropDownViewResource(R.layout.textview);
                        spinnerCodigoActividad.setAdapter(adapter7);
                        break;
                    case 8:
                        SECT = String.valueOf(spinnerSectorProductivo.getSelectedItem());
                        tokens1 = SECT.split(Pattern.quote("."));
                        text = "SECCION J";
                        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(Formulario.this, R.array.info_comunicacion, R.layout.textview);
                        adapter8.setDropDownViewResource(R.layout.textview);
                        spinnerCodigoActividad.setAdapter(adapter8);
                        break;
                    case 9:
                        SECT = String.valueOf(spinnerSectorProductivo.getSelectedItem());
                        tokens1 = SECT.split(Pattern.quote("."));
                        text = "SECCION Q";
                        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(Formulario.this, R.array.salud_asis_social, R.layout.textview);
                        adapter9.setDropDownViewResource(R.layout.textview);
                        spinnerCodigoActividad.setAdapter(adapter9);
                        break;
                    case 10:
                        SECT = String.valueOf(spinnerSectorProductivo.getSelectedItem());
                        tokens1 = SECT.split(Pattern.quote("."));
                        text = "SECCION R";
                        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(Formulario.this, R.array.entretenimiento, R.layout.textview);
                        adapter10.setDropDownViewResource(R.layout.textview);
                        spinnerCodigoActividad.setAdapter(adapter10);
                        break;
                    case 11:
                        SECT = String.valueOf(spinnerSectorProductivo.getSelectedItem());
                        tokens1 = SECT.split(Pattern.quote("."));
                        text = "SECCION S";
                        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(Formulario.this, R.array.otras_act_serv, R.layout.textview);
                        adapter11.setDropDownViewResource(R.layout.textview);
                        spinnerCodigoActividad.setAdapter(adapter11);
                        break;
                    case 12:
                        SECT = String.valueOf(spinnerSectorProductivo.getSelectedItem());
                        tokens1 = SECT.split(Pattern.quote("."));
                        text = "SECCION T";
                        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(Formulario.this, R.array.perso_domestico, R.layout.textview);
                        adapter12.setDropDownViewResource(R.layout.textview);
                        spinnerCodigoActividad.setAdapter(adapter12);
                        break;
                }
                int SP_act = sharedPreferencesRD.getInt("spinnerAct", -1);
                if (SP_act != -1) {
                    spinnerCodigoActividad.setSelection(SP_act);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //       ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.actividad,R.layout.textview);
        //       actividad.setAdapter(adapter2);
        spinnerCodigoActividad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> newList = new HashMap<>();

                ACT = String.valueOf(spinnerCodigoActividad.getSelectedItem());

                tokens2 = ACT.split(Pattern.quote("."));
                //       String part1 = String.valueOf(tokens2[0]); // 004
                //       String part2 = String.valueOf(tokens2[1]);   //part1+":"+part2
                //       Toast.makeText(Formulario.this, ""+part1+":"+part2, Toast.LENGTH_LONG).show();
                //cod_sec.setText("Codigo actividad:"+tokens[0]+"XX");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //   loadData();    REVISAR
            }
        });

        btnNV.getMenu().findItem(R.id.back).setChecked(true);
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
                    case R.id.back: {
                        //enviar todos los cvs
                        //    Formulario.super.onBackPressed();    24 marzo


                        //   intent= new Intent(Formulario.this, MainActivity.class);
                        //intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                        // revisar             intent.putExtra("encuestas",sharedPreferences.getString("datosver", ""));
                        intent = new Intent(Formulario.this, MainActivity.class);

                        startActivity(intent);


                    }
                    break;
                    case R.id.next: {
                        onClickNextButton();
                    }
                    break;

                }
                return true;

            }
        });
        loadData();

    }

    private void poblarListas() {
        list = new ArrayList<>();
        list.add("Seleccione");
        list.add("EL Titular en compañía de sus familiares va a iniciar con el cultivo ,  cada uno tiene claras sus actividades a realizar  en cuanto al proceso de siembra ,aplicación de fertilizantes , etapa de recolección entre otras tareas satisfaciendo la demanda de alimentos a nivel local y regional.");
        list.add("El titular va a fortalecer su cultivo , gracias a su experiencia rural  conoce los diferentes procesos de siembra  buscando satisfacer  la demanda de alimentos a nivel local(restaurantes , tiendas , entro otros)  y regional (abastos , fruvers , tiendas de barrio de las principales ciudades).");
        list.add("El titular teniendo en cuenta la vocación productiva del municipio  va a emprender la siembra de su cultivo buscando satisfacer necesidades individuales y locales , mediante practicas tradicionales agrícolas.");
        list.add("El titular del hogar invertirá en una unidad productiva agrícola este proceso  consiste en plantar semillas para que éstas germinen y desarrollen plantas; una vez completado este proceso se procede a la venta del fruto , satisfaciendo la demanda de alimentos de establecimientos comerciales , a nivel local y regional.");
        list.add("El titular del hogar invertirá en una unidad productiva agrícola , en primera medida  prepara el terreno para posteriormente realizar la siembra , teniendo como finalidad impactar de forma positiva la demanda de alimentos básicos de la región donde habita .\n");
        list2 = new ArrayList<>();
        list2.add("Seleccione");
        list2.add("El titular del hogar va a comercializar  sus productos a corto y mediano plazo a nivel local en plazas de mercado , mercados campesinos , tiendas, restaurantes y a largo plazo a nivel nacional e internacional.");
        list2.add("El titular del hogar va a comercializar  sus productos a corto y mediano plazo a nivel local y nacional ; a nivel local en ferias agrícolas , mercados campesinos , tiendas , restaurantes , entre otros ; y a nivel nacional en abastos , fruvers , tiendas de barrio.");
        list2.add("El titular del hogar esta aliado a pequeños productores agrícolas , lo que potencializa su impacto comercial , a nivel local , regional y nacional. ");
    }

    private void loadData() {
        if (!(sharedPreferencesRD.getString("tituloP", "").isEmpty() && sharedPreferencesRD.getString("prodPrinc", "").isEmpty() && sharedPreferencesRD.getString("descrPP", "").isEmpty() && sharedPreferencesRD.getString("oportunidades", "").isEmpty())) {
            int tipop = sharedPreferencesRD.getInt("tipoP", 0);
            spinnerTipoProyecto.setSelection(tipop);
            String titulop = sharedPreferencesRD.getString("tituloP", "");
            ediTextTituloProyecto.setText(titulop);
            String prodprinc = sharedPreferencesRD.getString("prodPrinc", "");
            ediTextProdPrincipal.setText(prodprinc);
            int descrpp = sharedPreferencesRD.getInt("descrPP", 0);
            descPP.setSelection(descrpp);
            int opor = sharedPreferencesRD.getInt("oportunidades", 0);
            oport.setSelection(opor);
            int SP_sect = sharedPreferencesRD.getInt("spinnerSect", -1);
            if (SP_sect != -1) {
                spinnerSectorProductivo.setSelection(SP_sect);
            }
            //  sector.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getApplicationContext());
            //  sector.setSelection(SP);
        }
    }

    private void onClickNextButton() {
        if (spinnerTipoProyecto.getSelectedItem().toString().matches("Seleccione")) {
            Toast.makeText(this, "Seleccione el tipo de proyecto", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(ediTextTituloProyecto.getText().toString().trim())) {
            Toast.makeText(this, "Dígite el título de proyecto", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(ediTextProdPrincipal.getText().toString().trim())) {
            Toast.makeText(this, "Dígite el producto principal", Toast.LENGTH_SHORT).show();
        } else if (spinnerSectorProductivo.getSelectedItem().toString().matches("Seleccione")) {
            Toast.makeText(this, "Seleccione el sector productivo", Toast.LENGTH_SHORT).show();
        } else if (spinnerCodigoActividad.getSelectedItem().toString().matches("Seleccione")) {
            Toast.makeText(this, "Seleccione la actividad", Toast.LENGTH_SHORT).show();
        } else {
            editor.putString("tipoP", spinnerTipoProyecto.getSelectedItem().toString().trim());
            editor.putString("tituloP", ediTextTituloProyecto.getText().toString().trim());
            editor.putString("prodPrinc", ediTextProdPrincipal.getText().toString().trim());
            editor.putString("codSector", text);
            editor.putString("descrSector", tokens1[1]);
            editor.putString("codAct", tokens2[0]);
            editor.putString("descrAct", tokens2[1]);
            editor.putString("descrPP", descPP.getSelectedItem().toString().trim());
            editor.putString("oportunidades", oport.getSelectedItem().toString());
            editor.commit();
            editorRD.putInt("tipoP", spinnerTipoProyecto.getSelectedItemPosition());
            editorRD.putString("tituloP", ediTextTituloProyecto.getText().toString().trim());
            editorRD.putString("prodPrinc", ediTextProdPrincipal.getText().toString().trim());
            editorRD.putInt("spinnerSect", spinnerSectorProductivo.getSelectedItemPosition());
            editorRD.putInt("spinnerAct", spinnerCodigoActividad.getSelectedItemPosition());
            editorRD.putInt("descrPP", descPP.getSelectedItemPosition());
            editorRD.putInt("oportunidades", oport.getSelectedItemPosition());
            editorRD.commit();
            Intent intent = new Intent(Formulario.this, Inversion.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        }
    }
}
