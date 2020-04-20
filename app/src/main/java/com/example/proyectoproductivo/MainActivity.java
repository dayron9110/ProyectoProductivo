package com.example.proyectoproductivo;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int ACCESS_FINE_LOCATION_REQUEST_CODE = 150;
    TextView gps, lat, lon, alt, lati, longi, alti, titunom, titulat, titulong, titualt, titulodepa, titulomun, tituruta, titulocorreg, titulotel, titulocambtitu;
    EditText id, name, PrApellido, SeApellido;
    private RadioGroup radioGroupNuevoTitular;
    private RadioButton radioButtonNuevoTitular;
    private RadioButton radioButtonTitularAntiguo;
    private boolean isTitularNuevo;
    BottomNavigationView btnNV;
    private Spinner spinnerDepartamento, spinnerMunicipio, spinnerRuta;
    RelativeLayout RL;
    private EditText editTextCC;
    TextView nombre;
    private EditText editTextCorregimiento, editTextTelefono;
    List<String> listaDepartamentos, listMuniVal, listMuniCac, listMuniNar, listRutasBuenosAires, listRutasCaloto, listRutasElTambo, listRutasTimbio, listRutasTimbiqui, listRutasElCharco, listRutasLaLlanada, listRutasBuenaventura, listRutasDagua, listRutasTulua;
    Intent intent;
    private Button buscar, sinGPS, ObtenerGPS;
    private SharedPreferences sharedPreferences, sharedPreferencesRD, dataEncuenta;//
    SharedPreferences.Editor editor, editorRD;
    String latitud, longitud, altitud;
    ArrayAdapter<String> dataAdapterMunic, dataAdapterRuta;
    HashMap<String, String> hm = new HashMap<String, String>();
    ArrayAdapter<String> dataAdapter;
    Handler handler;
    String Pnombre, Snombre, Papellido, Sapellido;
    Runnable r;
    private TemplatePDF templatePDF;
    PdfWriter pdfWriter;
    File pdfFile;
    Document document;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        r = new Runnable() {
            public void run() {
                localizacion1();
            }
        };
        handler.postDelayed(r, 5000);
        lati = findViewById(R.id.lat);
        longi = findViewById(R.id.longitud);
        alti = findViewById(R.id.alt);
        Pnombre = "";
        Snombre = "";
        Papellido = "";
        Sapellido = "";
        sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        sharedPreferencesRD = getSharedPreferences("recuperadatos", Context.MODE_PRIVATE);

        editor = sharedPreferences.edit();
        editorRD = sharedPreferencesRD.edit();
        //   gps=(TextView)findViewById(R.id.GPS);
        editTextCC = findViewById(R.id.in);
        nombre = findViewById(R.id.tvNombre);
        buscar = findViewById(R.id.btn1);
        RL = findViewById(R.id.resultado);
        radioGroupNuevoTitular = findViewById(R.id.mail);
        radioButtonNuevoTitular = findViewById(R.id.radio_nuevo_titular);
        radioButtonTitularAntiguo = findViewById(R.id.radio_titular_antiguo);
        titulocambtitu = findViewById(R.id.tituloMail);
        editTextTelefono = findViewById(R.id.telefono);
        titunom = findViewById(R.id.tituloNombre);
        titulat = findViewById(R.id.tituloLat);
        titulong = findViewById(R.id.tituloLong);
        titualt = findViewById(R.id.tituloAlt);
        titulotel = findViewById(R.id.tituloTele);
        titulodepa = findViewById(R.id.titulodep);
        titulomun = findViewById(R.id.titulomuni);
        titulocorreg = findViewById(R.id.titulocorre);
        tituruta = findViewById(R.id.titulorut);
        RL = findViewById(R.id.resultado);
        //ObtenerGPS=(Button)findViewById(R.id.getGPS);
        // sinGPS = findViewById(R.id.skipGPS);
        spinnerDepartamento = findViewById(R.id.departamento);
        spinnerMunicipio = findViewById(R.id.muni);
        editTextCorregimiento = findViewById(R.id.correg);
        spinnerRuta = findViewById(R.id.ruta);
        poblarListas();
        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaDepartamentos);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDepartamento.setAdapter(dataAdapter);
        radioGroupNuevoTitular.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.findViewById(i).getId()) {
                    case R.id.radio_nuevo_titular:
                        isTitularNuevo = true;
                        break;
                    case R.id.radio_titular_antiguo:
                        isTitularNuevo = false;
                        break;
                }
            }
        });

        spinnerDepartamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                handler.postDelayed(r, 2000);
                switch (position) {
                    case 0:
                        //Toast.makeText(Inicial.this, "posicion:"+position, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        // Toast.makeText(Inicial.this, "posicion:"+position, Toast.LENGTH_SHORT).show();
                        dataAdapterMunic = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_item, listMuniVal);
                        dataAdapterMunic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerMunicipio.setAdapter(dataAdapterMunic);
                        if (!sharedPreferencesRD.getString("Municipio", "").isEmpty()) {
                            spinnerMunicipio.setSelection(listMuniVal.indexOf(sharedPreferencesRD.getString("Municipio", "")));
                        }// 19 marzo
                        break;

                    case 2:
                        // Toast.makeText(Inicial.this, "posicion:"+position, Toast.LENGTH_SHORT).show();
                        dataAdapterMunic = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, listMuniCac);
                        dataAdapterMunic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerMunicipio.setAdapter(dataAdapterMunic);
                        if (!sharedPreferencesRD.getString("Municipio", "").isEmpty()) {
                            spinnerMunicipio.setSelection(listMuniCac.indexOf(sharedPreferencesRD.getString("Municipio", "")));
                        }
                        break;
                    case 3:
                        // Toast.makeText(Inicial.this, "posicion:"+position, Toast.LENGTH_SHORT).show();
                        dataAdapterMunic = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_item, listMuniNar);
                        dataAdapterMunic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerMunicipio.setAdapter(dataAdapterMunic);
                        if (!sharedPreferencesRD.getString("Municipio", "").isEmpty()) {
                            spinnerMunicipio.setSelection(listMuniNar.indexOf(sharedPreferencesRD.getString("Municipio", "")));
                        }
                        break;

                    default:

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String cedula = editTextCC.getText().toString();

                handler.postDelayed(r, 5000);

   /*             InputStream is1 = getResources().openRawResource(R.raw.result);
                Writer writer1 = new StringWriter();
                char[] buffer = new char[1024];
                try {
                    Reader reader = new BufferedReader(new InputStreamReader(is1, "UTF-8"));
                    int n;
                    while ((n = reader.read(buffer)) != -1) {
                        writer1.write(buffer, 0, n);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        is1.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                String jsonString = writer1.toString();
                System.out.println(jsonString);

                JSONObject  jsonObject1 = null;
                try
                {
                    JSONObject jsonObject = new JSONObject(jsonString);

                    jsonObject1 = jsonObject.getJSONObject(cedula);
                    Pnombre = jsonObject1.getString("1nombre");
                    Snombre = jsonObject1.getString("2nombre");
                    Papellido = jsonObject1.getString("1apellido");
                    Sapellido=jsonObject1.getString("2apellido");
                //    Toast.makeText(MainActivity.this, ""+Pnombre , Toast.LENGTH_SHORT).show();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
*/
                InputStream is = getResources().openRawResource(R.raw.ced_nombres);
                BufferedReader reader1 = new BufferedReader(

                        new InputStreamReader(is, Charset.forName("UTF-8"))
                );
                String line = "";
                try {
                    while ((line = reader1.readLine()) != null) {
                        String[] tokens = line.split(";");
                        String id = tokens[0];
                        String nombre = tokens[1];
                        hm.put(id, nombre);
                        //       System.out.println("The Value is: " + hm.get(8328287));
                        //Log.d("hashmap",hm.get("8328287"));
                    }
                    //   System.out.println("The Value is: " + hm.get("8328287"));
                } catch (IOException e) {
                    Log.wtf("mi", "error" + line, e);


                }
                System.out.println("The Value is: " + hm.get("40432310"));


                handler.postDelayed(r, 1000);
                //       Toast.makeText(MainActivity.this, ""+hm.get(cedula), Toast.LENGTH_SHORT).show();
                if (hm.get(cedula) != null) {

                    //   Context context = mapView.getContext();



                   /*         id=(EditText)dialog.findViewById(R.id.id);
                            name=(EditText)dialog.findViewById(R.id.nombre);
                            PrApellido=(EditText)dialog.findViewById(R.id.papellido);
                            SeApellido=(EditText)dialog.findViewById(R.id.sapellido);

                            Pnombre=name.getText().toString();Snombre="";Papellido=PrApellido.getText().toString();
                            Sapellido=SeApellido.getText().toString();

                            editTextCC.setText(String.valueOf(id.getText()));*/

                    //         Toast.makeText(MainActivity.this, ""+sharedPreferences.getString("encuesta",""), Toast.LENGTH_SHORT).show();

                    //               Toast.makeText(MainActivity.this, ""+name.getText()+" "+PrApellido.getText()+" "+SeApellido.getText(), Toast.LENGTH_SHORT).show();
                    nombre.setText(hm.get(cedula));


                    //     name=text;
                    RL.setVisibility(View.VISIBLE);
                    spinnerDepartamento.setVisibility(View.VISIBLE);
                    spinnerMunicipio.setVisibility(View.VISIBLE);
                    spinnerRuta.setVisibility(View.VISIBLE);
                    tituruta.setVisibility(View.VISIBLE);
                    editTextCorregimiento.setVisibility(View.VISIBLE);
                    titunom.setVisibility(View.VISIBLE);
                    titulat.setVisibility(View.VISIBLE);
                    titulong.setVisibility(View.VISIBLE);
                    titualt.setVisibility(View.VISIBLE);
                    titulodepa.setVisibility(View.VISIBLE);
                    titulomun.setVisibility(View.VISIBLE);
                    titulocorreg.setVisibility(View.VISIBLE);
                    titulotel.setVisibility(View.VISIBLE);
                    editTextTelefono.setVisibility(View.VISIBLE);
                    titulocambtitu.setVisibility(View.VISIBLE);
                    radioGroupNuevoTitular.setVisibility(View.VISIBLE);

                    //       dialog.show();

                } else {
                    Toast.makeText(MainActivity.this, "Cedula no encontrada", Toast.LENGTH_SHORT).show();
                    //          nombre.setText(Pnombre+" "+Snombre+" "+Papellido+" "+Sapellido);
                    RL.setVisibility(View.INVISIBLE);
                    spinnerDepartamento.setVisibility(View.INVISIBLE);
                    spinnerMunicipio.setVisibility(View.INVISIBLE);
                    spinnerRuta.setVisibility(View.INVISIBLE);
                    editTextCorregimiento.setVisibility(View.INVISIBLE);
                    titunom.setVisibility(View.INVISIBLE);
                    titulat.setVisibility(View.INVISIBLE);
                    //     tituloruta.setVisibility(View.INVISIBLE);
                    titulong.setVisibility(View.INVISIBLE);
                    titualt.setVisibility(View.INVISIBLE);
                    titulodepa.setVisibility(View.INVISIBLE);
                    titulomun.setVisibility(View.INVISIBLE);
                    titulocorreg.setVisibility(View.INVISIBLE);
                    titulotel.setVisibility(View.INVISIBLE);
                    editTextTelefono.setVisibility(View.INVISIBLE);
                    titulocambtitu.setVisibility(View.INVISIBLE);
                    radioGroupNuevoTitular.setVisibility(View.INVISIBLE);
                }

            }
        });
        spinnerMunicipio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                }
                if (i == 1 && spinnerDepartamento.getSelectedItem().toString().equals("Valle del Cauca")) {
                    dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listRutasBuenaventura);
                    dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerRuta.setAdapter(dataAdapterRuta);
                }
                if (i == 1 && spinnerDepartamento.getSelectedItem().toString().equals("Cauca")) {
                    dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listRutasBuenosAires);
                    dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerRuta.setAdapter(dataAdapterRuta);
                }
                if (i == 1 && spinnerDepartamento.getSelectedItem().toString().equals("Nariño")) {
                    dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listRutasElCharco);
                    dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerRuta.setAdapter(dataAdapterRuta);
                }
                if (i == 2 && spinnerDepartamento.getSelectedItem().toString().equals("Valle del Cauca")) {
                    dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listRutasDagua);
                    dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerRuta.setAdapter(dataAdapterRuta);
                }
                if (i == 2 && spinnerDepartamento.getSelectedItem().toString().equals("Cauca")) {
                    dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listRutasElTambo);
                    dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerRuta.setAdapter(dataAdapterRuta);
                }
                if (i == 2 && spinnerDepartamento.getSelectedItem().toString().equals("Nariño")) {
                    dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listRutasLaLlanada);
                    dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerRuta.setAdapter(dataAdapterRuta);
                }
                if (i == 3 && spinnerDepartamento.getSelectedItem().toString().equals("Valle del Cauca")) {
                    dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listRutasTulua);
                    dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerRuta.setAdapter(dataAdapterRuta);
                }
                if (i == 3 && spinnerDepartamento.getSelectedItem().toString().equals("Cauca")) {
                    dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listRutasTimbio);
                    dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerRuta.setAdapter(dataAdapterRuta);
                }
                if (i == 4) {
                    dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listRutasTimbiqui);
                    dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerRuta.setAdapter(dataAdapterRuta);
                }
                if (i == 5) {
                    dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listRutasCaloto);
                    dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerRuta.setAdapter(dataAdapterRuta);
                }
                spinnerRuta.setSelection(sharedPreferencesRD.getInt("Ruta", 0));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnNV = findViewById(R.id.navigationView);
        //  btnNV.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);
        btnNV.getMenu().findItem(R.id.navegacion).setChecked(true);
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
                    case R.id.navegacion: {
                        //enviar todos los cvs
                        intent = new Intent(MainActivity.this, GuardarTodo.class);
                        //intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.putExtra("encuestas", sharedPreferences.getString("datosver", ""));
                        if (new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/datosPP.csv").exists()) {
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Ingrese primero PI (guardandolo)", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                    case R.id.otro: {
                        //  String file = "resources/data.txt";
                        /*String nPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"";
                        String line;
                        try (BufferedReader br =
                                     new BufferedReader(new FileReader(new File(nPath,"datosPP.csv")))) {
                            while((line = br.readLine()) != null){
                                System.out.println(line);
                            }
                        } catch (Exception e){
                            System.out.println(e);
                        }*/
                        templatePDF = new TemplatePDF(getApplicationContext());
                        String nPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "";

                        File folder = new File(nPath, "PDF");
                        if (!folder.exists())
                            folder.mkdirs();
                        pdfFile = new File(folder, "PP2020.pdf");
                        try {

                            document = new Document(PageSize.LEGAL);
                            document.setMargins(39, 39, 14, 14);
                            pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
                            document.open();
                        } catch (Exception e) {
                            Log.e("openDocument", e.toString());
                        }

                        String line;
                        try (BufferedReader br =
                                     new BufferedReader(new FileReader(new File(nPath, "datosPP.csv")))) {
                            while ((line = br.readLine()) != null) {
                                // System.out.println(line);
                                templatePDF.addMetaData(document);
                                templatePDF.addTitles(document, line);
                                document.newPage();
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                        //    templatePDF.addTitles(document,"yo;8328287;TOLA;Y;MARUJA;-;Valle del Cauca;Buenaventura;u;5;k;24/03/20;7.09603;-73.13858;899.59998;UNIVERSIDAD");
                        document.close();
                        templatePDF.verPDF();
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

        //Permisos
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                //Ya estan permitidos
                handler.postDelayed(r, 500);
            } else {
                final String[] permision = new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
                requestPermissions(permision, ACCESS_FINE_LOCATION_REQUEST_CODE);
            }
        } else {
            //Ya estan permitidos
            handler.postDelayed(r, 500);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {

            case ACCESS_FINE_LOCATION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED && grantResults[3] == PackageManager.PERMISSION_GRANTED) {
                    //Ya esta permitido
                    handler.postDelayed(r, 500);
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Acceder a los datos");
                        builder.setMessage("Debes aceptar para poder utilizar " + getString(R.string.app_name));
                        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                final String[] permision = new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    requestPermissions(permision, ACCESS_FINE_LOCATION_REQUEST_CODE);
                                }
                                //  Intent starterIntent = getIntent();finish(); startActivity(starterIntent);
                            }
                        });
                        builder.show();
                    }
                }
                /*Intent intent = new Intent(this, MainActivity.class);
                startActivityForResult(intent, 0);*/
                break;
        }

    }

    private void alertMensaje(String title, String body) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title);
        builder.setMessage(body);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        final android.support.v7.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void localizacion1() {
        miLocalizacion.LocationResult locationResult = new miLocalizacion.LocationResult() {

            @Override
            public void gotLocation(Location location) {
                if (location == null)
                    //    gps.setText("Latitud:0\nLongitud:0\nAltitud:0");

                    return;
                DecimalFormat lat = new DecimalFormat("#.#####");
                DecimalFormat log = new DecimalFormat("##.#####");
                DecimalFormat alt = new DecimalFormat("####.#####");
//                Toast.makeText(MainActivity.this, ""+location, Toast.LENGTH_SHORT).show();
                latitud = String.valueOf(lat.format(location.getLatitude()));
                longitud = String.valueOf(log.format(location.getLongitude()));
                altitud = String.valueOf(alt.format(location.getAltitude()));


            }
            //

        };


        miLocalizacion myLocation = new miLocalizacion();
        myLocation.getLocation(this, locationResult);
        if (latitud == null || longitud == null || altitud == null) {
            editor.putString("Latitud", "0");
            editor.putString("Longitud", "0");
            editor.putString("Altitud", "0");

        } else {
            //"Latitud    :    " + latitud + "\nLongitud :    " + longitud + "\nAltitud     :    " + altitud
            lati.setText(latitud);
            longi.setText(longitud);
            alti.setText(altitud);
            editor.putString("Latitud", latitud);
            editor.putString("Longitud", longitud);
            editor.putString("Altitud", altitud);
        }

        //  System.out.println(location);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        //dataEncuenta = getSharedPreferences("recuperadatos", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (sharedPreferencesRD.getString("CC", "").equals("")) {
            RL.setVisibility(View.INVISIBLE);
            spinnerDepartamento.setVisibility(View.INVISIBLE);
            spinnerMunicipio.setVisibility(View.INVISIBLE);
            editTextCorregimiento.setVisibility(View.INVISIBLE);
            titunom.setVisibility(View.INVISIBLE);
            titulat.setVisibility(View.INVISIBLE);
            titulong.setVisibility(View.INVISIBLE);
            titualt.setVisibility(View.INVISIBLE);
            titulodepa.setVisibility(View.INVISIBLE);
            titulomun.setVisibility(View.INVISIBLE);
            titulocorreg.setVisibility(View.INVISIBLE);
            titulotel.setVisibility(View.INVISIBLE);
            editTextTelefono.setVisibility(View.INVISIBLE);
            titulocambtitu.setVisibility(View.INVISIBLE);
            radioGroupNuevoTitular.setVisibility(View.INVISIBLE);
            editTextCC.setText("");
            spinnerDepartamento.setAdapter(dataAdapter);
            spinnerMunicipio.setAdapter(null);
            editTextCorregimiento.setText("");
        } else {
            tituruta.setVisibility(View.VISIBLE);
            spinnerRuta.setVisibility(View.VISIBLE);
            RL.setVisibility(View.VISIBLE);
            spinnerDepartamento.setVisibility(View.VISIBLE);
            spinnerMunicipio.setVisibility(View.VISIBLE);
            editTextCorregimiento.setVisibility(View.VISIBLE);
            titunom.setVisibility(View.VISIBLE);
            titulat.setVisibility(View.VISIBLE);
            titulong.setVisibility(View.VISIBLE);
            titualt.setVisibility(View.VISIBLE);
            titulodepa.setVisibility(View.VISIBLE);
            titulomun.setVisibility(View.VISIBLE);
            titulocorreg.setVisibility(View.VISIBLE);
            titulotel.setVisibility(View.VISIBLE);
            editTextTelefono.setVisibility(View.VISIBLE);
            titulocambtitu.setVisibility(View.VISIBLE);
            radioGroupNuevoTitular.setVisibility(View.VISIBLE);
            editTextCC.setText(sharedPreferencesRD.getString("CC", ""));
            nombre.setText(sharedPreferencesRD.getString("nombre", "") + " " + sharedPreferencesRD.getString("nombre2", "") + " " + sharedPreferencesRD.getString("1_apellido", "") + " " + sharedPreferencesRD.getString("2_apellido", ""));
            if (!sharedPreferencesRD.getString("Departamento", "").isEmpty()) {

                spinnerDepartamento.setSelection(listaDepartamentos.indexOf(sharedPreferencesRD.getString("Departamento", "")));
                if (sharedPreferencesRD.getString("Departamento", "").equals("Valle del Cauca")) {
                    dataAdapterMunic = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listMuniVal);
                    dataAdapterMunic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerMunicipio.setAdapter(dataAdapterMunic);
                    //
                    spinnerMunicipio.setSelection(listMuniVal.indexOf(sharedPreferencesRD.getString("Municipio", "")));
                    if (sharedPreferencesRD.getString("Municipio", "").equals("Buenaventura")) {
                        dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_item, listRutasBuenaventura);
                        dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerRuta.setAdapter(dataAdapterRuta);
                        // Ruta.setSelection(listRutasBuenaventura.indexOf(sharedPreferencesRD.getString("Ruta","")));
                    }
                    if (sharedPreferencesRD.getString("Municipio", "").equals("Dagua")) {
                        dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_item, listRutasDagua);
                        dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerRuta.setAdapter(dataAdapterRuta);
                        //   Ruta.setSelection(listRutasDagua.indexOf(sharedPreferencesRD.getString("Ruta","")));
                    }
                    if (sharedPreferencesRD.getString("Municipio", "").equals("Tulua")) {
                        dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_item, listRutasTulua);
                        dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerRuta.setAdapter(dataAdapterRuta);
                        //  Ruta.setSelection(listRutasTulua.indexOf(sharedPreferencesRD.getString("Ruta","")));
                    }
                }
                if (sharedPreferencesRD.getString("Departamento", "").equals("Cauca")) {
                    dataAdapterMunic = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listMuniCac);
                    dataAdapterMunic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerMunicipio.setAdapter(dataAdapterMunic);
                    spinnerMunicipio.setSelection(listMuniCac.indexOf(sharedPreferencesRD.getString("Municipio", "")));
                    if (sharedPreferencesRD.getString("Municipio", "").equals("Buenos Aires")) {
                        dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_item, listRutasBuenosAires);
                        dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerRuta.setAdapter(dataAdapterRuta);
                        // Ruta.setSelection(listRutasBuenosAires.indexOf(sharedPreferencesRD.getString("Ruta","")));
                    }
                    if (sharedPreferencesRD.getString("Municipio", "").equals("El Tambo")) {
                        dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_item, listRutasElTambo);
                        dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerRuta.setAdapter(dataAdapterRuta);
                        // Ruta.setSelection(listRutasElTambo.indexOf(sharedPreferencesRD.getString("Ruta","")));
                    }
                    if (sharedPreferencesRD.getString("Municipio", "").equals("Timbio")) {
                        dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_item, listRutasTimbio);
                        dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerRuta.setAdapter(dataAdapterRuta);
                        // Ruta.setSelection(listRutasTimbio.indexOf(sharedPreferencesRD.getString("Ruta","")));
                    }
                    if (sharedPreferencesRD.getString("Municipio", "").equals("Timbiqui")) {
                        dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_item, listRutasTimbiqui);
                        dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerRuta.setAdapter(dataAdapterRuta);
                        // Ruta.setSelection(listRutasTimbiqui.indexOf(sharedPreferencesRD.getString("Ruta","")));
                    }
                    if (sharedPreferencesRD.getString("Municipio", "").equals("Caloto")) {
                        dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_item, listRutasCaloto);
                        dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerRuta.setAdapter(dataAdapterRuta);
                        // Ruta.setSelection(listRutasCaloto.indexOf(sharedPreferencesRD.getString("Ruta","")));
                    }
                }
                if (sharedPreferencesRD.getString("Departamento", "").equals("Nariño")) {
                    dataAdapterMunic = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listMuniNar);
                    dataAdapterMunic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerMunicipio.setAdapter(dataAdapterMunic);
                    spinnerMunicipio.setSelection(listMuniNar.indexOf(sharedPreferencesRD.getString("Municipio", "")));
                }

                if (sharedPreferencesRD.getString("Municipio", "").equals("El Charco")) {
                    dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listRutasElCharco);
                    dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerRuta.setAdapter(dataAdapterRuta);
                    //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                    //   Ruta.setSelection(listRutasElCharco.indexOf(sharedPreferencesRD.getString("Ruta","")));
                }
                if (sharedPreferencesRD.getString("Municipio", "").equals("La Llanada")) {
                    dataAdapterRuta = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, listRutasLaLlanada);
                    dataAdapterRuta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerRuta.setAdapter(dataAdapterRuta);
                    //  Ruta.setSelection(listRutasLaLlanada.indexOf(sharedPreferencesRD.getString("Ruta","")));
                }
                editTextCorregimiento.setText(sharedPreferencesRD.getString("Corregimiento", ""));
                editTextTelefono.setText(sharedPreferencesRD.getString("Telefono", ""));
                String isNuevoTitular = sharedPreferencesRD.getString("Mail", "");
                if (!isNuevoTitular.isEmpty()) {
                    if (isNuevoTitular.equals("SI")) {
                        setStateRadioGroupNuevoTitular(true);
                    } else {
                        setStateRadioGroupNuevoTitular(false);
                    }

                } else {
                    setStateRadioGroupNuevoTitular(false);
                }
            }
        }
    }

    private void setStateRadioGroupNuevoTitular(boolean isTitularNuevo) {
        this.isTitularNuevo = isTitularNuevo;
        if (isTitularNuevo) {
            radioButtonNuevoTitular.setChecked(true);
            radioButtonTitularAntiguo.setChecked(false);
        } else {
            radioButtonNuevoTitular.setChecked(false);
            radioButtonTitularAntiguo.setChecked(true);
        }
    }

    private void onClickNextButton() {
        if (editTextCC.getText().toString().matches("")) {
            Toast.makeText(MainActivity.this, "Dígite la cédula", Toast.LENGTH_SHORT).show();
        } else if (spinnerDepartamento.getSelectedItem().toString().matches("Seleccione")) {
            Toast.makeText(MainActivity.this, "Seleccione un departamento", Toast.LENGTH_SHORT).show();
        } else if (spinnerMunicipio.getSelectedItem().toString().equals("Seleccione")) {
            Toast.makeText(MainActivity.this, "Seleccione un municipio", Toast.LENGTH_SHORT).show();
        } else if (spinnerRuta.getSelectedItem().toString().equals("Seleccione")) {
            Toast.makeText(MainActivity.this, "Seleccione una ruta", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(editTextCorregimiento.getText().toString().trim())) {
            Toast.makeText(MainActivity.this, "Por favor dígite el corregimiento", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(editTextTelefono.getText().toString().trim())) {
            Toast.makeText(MainActivity.this, "Por favor dígite un teléfono", Toast.LENGTH_SHORT).show();
        } else {
            editor.putString("CC", editTextCC.getText().toString());
            editorRD.putString("CC", editTextCC.getText().toString());
            if (nombre.getText() != null) {
                editor.putString("nombre", nombre.getText().toString().split(" ")[0].trim());
                editor.putString("nombre2", nombre.getText().toString().split(" ")[1].trim());
                editor.putString("1_apellido", nombre.getText().toString().split(" ")[2].trim());
                editor.putString("2_apellido", nombre.getText().toString().split(" ")[3].trim());
                //
                editorRD.putString("nombre", nombre.getText().toString().split(" ")[0].trim());
                editorRD.putString("nombre2", nombre.getText().toString().split(" ")[1].trim());
                editorRD.putString("1_apellido", nombre.getText().toString().split(" ")[2].trim());
                editorRD.putString("2_apellido", nombre.getText().toString().split(" ")[3].trim());
            }
            editor.putString("Departamento", spinnerDepartamento.getSelectedItem().toString());
            editorRD.putString("Departamento", spinnerDepartamento.getSelectedItem().toString());//editorRD.putInt("Departamento",depart.getSelectedItemPosition());
            editor.putString("Municipio", spinnerMunicipio.getSelectedItem().toString());
            editorRD.putString("Municipio", spinnerMunicipio.getSelectedItem().toString());//editorRD.putInt("Municipio",municipio.getSelectedItemPosition());
            editor.putString("Ruta", spinnerMunicipio.getSelectedItem().toString());
            editorRD.putInt("Ruta", spinnerRuta.getSelectedItemPosition());//editorRD.putInt("Municipio",municipio.getSelectedItemPosition());

            if (editTextCorregimiento.getText() != null) {
                editor.putString("Corregimiento", editTextCorregimiento.getText().toString().trim());
                editorRD.putString("Corregimiento", editTextCorregimiento.getText().toString().trim());
            } else {
                editor.putString("Corregimiento", "");
            }

            if (editTextTelefono.getText() != null) {
                editor.putString("Telefono", editTextTelefono.getText().toString().trim());
                editorRD.putString("Telefono", editTextTelefono.getText().toString().trim());
            } else {
                editor.putString("Telefono", "");
            }

            if (isTitularNuevo) {
                editor.putString("Mail", "SI");
                editorRD.putString("Mail", "SI");
            } else {
                editor.putString("Mail", "NO");
                editorRD.putString("Mail", "NO");
            }
            editor.commit();
            editorRD.commit();
            Intent intent = new Intent(MainActivity.this, Formulario.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        }
    }

    private void poblarListas() {
        listaDepartamentos = new ArrayList<>();
        listaDepartamentos.add("Seleccione");
        listaDepartamentos.add("Valle del Cauca");
        listaDepartamentos.add("Cauca");
        listaDepartamentos.add("Nariño");
        listMuniVal = new ArrayList<>();
        listMuniVal.add("Seleccione");
        listMuniVal.add("Buenaventura");
        listMuniVal.add("Dagua");
        listMuniVal.add("Tulua");
        listMuniCac = new ArrayList<>();
        listMuniCac.add("Seleccione");
        listMuniCac.add("Buenos Aires");
        listMuniCac.add("El Tambo");
        listMuniCac.add("Timbio");
        listMuniCac.add("Timbiqui");
        listMuniCac.add("Caloto");
        listMuniNar = new ArrayList<>();
        listMuniNar.add("Seleccione");
        listMuniNar.add("El Charco");
        listMuniNar.add("La Llanada");
        listRutasBuenosAires = new ArrayList<>();
        listRutasBuenosAires.add("Seleccione");
        listRutasBuenosAires.add("CAU01");
        listRutasBuenosAires.add("CAU02");
        listRutasBuenosAires.add("CAU03");
        listRutasBuenosAires.add("CAU04");
        listRutasBuenosAires.add("CAU05");
        listRutasCaloto = new ArrayList<>();
        listRutasCaloto.add("Seleccione");
        listRutasCaloto.add("CAU10");
        listRutasCaloto.add("CAU11");
        listRutasCaloto.add("CAU12");
        listRutasElTambo = new ArrayList<>();
        listRutasElTambo.add("Seleccione");
        listRutasElTambo.add("CAU20");
        listRutasElTambo.add("CAU21");
        listRutasElTambo.add("CAU22");
        listRutasElTambo.add("CAU23");
        listRutasElTambo.add("CAU24");
        listRutasTimbio = new ArrayList<>();
        listRutasTimbio.add("Seleccione");
        listRutasTimbio.add("CAU30");
        listRutasTimbio.add("CAU31");
        listRutasTimbio.add("CAU32");
        listRutasTimbio.add("CAU33");
        listRutasTimbiqui = new ArrayList<>();
        listRutasTimbiqui.add("Seleccione");
        listRutasTimbiqui.add("CAU40");
        listRutasTimbiqui.add("CAU41");
        listRutasTimbiqui.add("CAU42");
        listRutasTimbiqui.add("CAU43");
        listRutasElCharco = new ArrayList<>();
        listRutasElCharco.add("Seleccione");
        listRutasElCharco.add("NAR01");
        listRutasElCharco.add("NAR02");
        listRutasElCharco.add("NAR03");
        listRutasElCharco.add("NAR04");
        listRutasElCharco.add("NAR05");
        listRutasElCharco.add("NAR06");
        listRutasElCharco.add("NAR07");
        listRutasElCharco.add("NAR08");
        listRutasElCharco.add("NAR09");
        listRutasLaLlanada = new ArrayList<>();
        listRutasLaLlanada.add("Seleccione");
        listRutasLaLlanada.add("NAR10");
        listRutasLaLlanada.add("NAR11");
        listRutasBuenaventura = new ArrayList<>();
        listRutasBuenaventura.add("Seleccione");
        listRutasBuenaventura.add("VAL01");
        listRutasBuenaventura.add("VAL02");
        listRutasBuenaventura.add("VAL03");
        listRutasBuenaventura.add("VAL04");
        listRutasDagua = new ArrayList<>();
        listRutasDagua.add("Seleccione");
        listRutasDagua.add("VAL10");
        listRutasDagua.add("VAL11");
        listRutasTulua = new ArrayList<>();
        listRutasTulua.add("Seleccione");
        listRutasTulua.add("VAL20");
        listRutasTulua.add("VAL21");
        listRutasTulua.add("VAL22");
    }

}
