package com.example.proyectoproductivo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuardarTodo extends AppCompatActivity {
    SharedPreferences preferences, sharedPreferences, sharedPreferencesCC, dataEncuesta;
    String mapTypeString;
    TextView todos;
    SharedPreferences.Editor editor, editorRD, editorEncuesta;
    BottomNavigationView btnNVR;
    FloatingActionButton volver;
    Handler handler;
    TextView textView;
    Runnable ru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_todo);
        textView = findViewById(R.id.tv);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String currentDateandTime = sdf.format(new Date());
        textView.setText("Fecha de diligenciamiento:" + currentDateandTime);

        todos = findViewById(R.id.datosguardados);
        sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        dataEncuesta = getSharedPreferences("encuesta", Context.MODE_PRIVATE);
        editorEncuesta = sharedPreferences.edit();
        String todosDatos = dataEncuesta.getString("datosver", "");
        todos.setText(todosDatos);


        preferences = getSharedPreferences("recuperadatos", Context.MODE_PRIVATE);
        sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

        /*
        handler = new Handler();
        ru = new Runnable() {
            public void run() {
                Intent intent=new Intent(GuardarTodo.this,MainActivity.class);
                startActivity(intent);
            }
        };
*/
        btnNVR = findViewById(R.id.navigationViewACT_rev);
        btnNVR.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                for (int i = 0; i < btnNVR.getMenu().size(); i++) {
                    MenuItem menuItem = btnNVR.getMenu().getItem(i);
                    boolean isChecked = menuItem.getItemId() == item.getItemId();
                    menuItem.setChecked(isChecked);
                }

                switch (item.getItemId()) {
                    case R.id.navegacion: {
                        GuardarTodo.super.onBackPressed();


                    }
                    break;
                }
                return true;
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(GuardarTodo.this);
        builder.setTitle("Archivo :Download/datosPP.csv)");
        builder.setMessage("Archivo creado (csv): datosPP  ");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!generateAllCSV())
                    return;
                alertMensaje("Información", "Archivo :Download/datosPP.csv)");

                editor = preferences.edit();
                editor.clear();
                editor.commit();
                SharedPreferences.Editor editCC = sharedPreferences.edit();
                editCC.putString("CC", "");
                editCC.clear();              //ojo
                editCC.commit();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                //edit.putString("encuesta","");
                edit.putString("valT1GP", "");
                edit.putString("valT2GP", "");
                edit.putString("valT3GP", "");
                edit.putString("valT4GP", "");
                edit.putString("valT1CT", "");
                edit.putString("valT2CT", "");
                edit.putString("valT3CT", "");
                edit.putString("valT4CT", "");
                edit.putString("valT1AF", "");
                edit.putString("valT2AF", "");
                edit.putString("valT3AF", "");
                edit.putString("valT4AF", "");
                edit.putString("valT1MER", "");
                edit.putString("valT2MER", "");
                edit.putString("valT3MER", "");
                edit.putString("valT4MER", "");
                edit.putString("valT1ST", "");
                edit.putString("valT2ST", "");
                edit.putString("valT3ST", "");
                edit.putString("valT4ST", "");

                edit.commit();
                //Intent intent1= new Intent(GuardarTodo.this, MainActivity.class);startActivity(intent1);
                //dialog.dismiss();

                //    handler.postDelayed(ru, 13000);
            }
        });
        builder.setNegativeButton("Enviar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //LO COMENTAMOS PARA PROVAR DIRECTAMENTE
                if (!generateAllCSV())
                    return;

                editor = preferences.edit();
                editor.clear();
                editor.commit();
                SharedPreferences.Editor editCC = sharedPreferences.edit();
                editCC.putString("CC", "");
                editCC.clear();
                editCC.commit();
                SharedPreferences.Editor edit = sharedPreferences.edit();   //revisar
                // edit.putString("encuesta","");
                edit.putString("valT1GP", "");
                edit.putString("valT2GP", "");
                edit.putString("valT3GP", "");
                edit.putString("valT4GP", "");
                edit.putString("valT1CT", "");
                edit.putString("valT2CT", "");
                edit.putString("valT3CT", "");
                edit.putString("valT4CT", "");
                edit.putString("valT1AF", "");
                edit.putString("valT2AF", "");
                edit.putString("valT3AF", "");
                edit.putString("valT4AF", "");
                edit.putString("valT1MER", "");
                edit.putString("valT2MER", "");
                edit.putString("valT3MER", "");
                edit.putString("valT4MER", "");
                edit.putString("valT1ST", "");
                edit.putString("valT2ST", "");
                edit.putString("valT3ST", "");
                edit.putString("valT4ST", "");

                edit.commit();


                // editor =preferences.edit();
                editorRD = sharedPreferences.edit();               //revisar despues
                // editor.clear();
                // editorRD.clear();         //esta mal
                //  editor.commit();
                editorRD.commit();

                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.setType("text/csv");


                ///crear CSV
                String nPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "";
                //deleteRecursive(new File(nPath,"datosVMC.csv"));
                Uri uri = FileProvider.getUriForFile(GuardarTodo.this, "com.example.proyectoproductivo", new File(nPath, "datosPP.csv"));
                mailIntent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                mailIntent.putExtra(Intent.EXTRA_STREAM, uri);
                startActivity(Intent.createChooser(mailIntent, "Enviando Archivo."));
                Log.d("nPath", nPath);


            }
        });
        builder.create();
        builder.show();
    }

    private void alertMensaje(String title, String body) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(GuardarTodo.this);
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

    public boolean generateAllCSV() {
        String baseFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "";
        deleteRecursive(new File(baseFolder, "datosPP.csv"));

        try {
            FileWriter writer = new FileWriter(new File(baseFolder, "datosPP.csv"), true);

            writer.write(dataEncuesta.getString("registros", ""));
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            alertMensaje("Error", "Error al crear el archivo CSV");
            return false;
        }
    }

    public static void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);
        fileOrDirectory.delete();
    }
}
