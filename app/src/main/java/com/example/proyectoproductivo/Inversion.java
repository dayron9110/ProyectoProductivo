package com.example.proyectoproductivo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Inversion extends AppCompatActivity {

    BottomNavigationView btnNV;
    Button gp, cp, af, me, st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inversion);
        gp = findViewById(R.id.GaPr);
        cp = findViewById(R.id.CaTr);
        af = findViewById(R.id.AcFi);
        me = findViewById(R.id.Mer);
        st = findViewById(R.id.SeTr);

        gp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GP = new Intent(Inversion.this, GastosPreo.class);
                startActivity(GP);
            }
        });

        cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CT = new Intent(Inversion.this, CapTrabajo.class);
                startActivity(CT);
            }
        });

        af.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AF = new Intent(Inversion.this, ActFijos.class);
                startActivity(AF);
            }
        });

        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(Inversion.this, Mercadeo.class);
                startActivity(m);
            }
        });

        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ST = new Intent(Inversion.this, SegTrabajo.class);
                startActivity(ST);
            }
        });
        btnNV = findViewById(R.id.navigationView);
        //  btnNV.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);
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
                        Intent intent = new Intent(Inversion.this, Formulario.class);
                        //intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        //   intent.putExtra("encuestas",sharedPreferences.getString("datosver", ""));
                        startActivity(intent);

                    }
                    break;
                    case R.id.nextACT: {
                        //  editorRD = sharedPreferencesRD.edit();
                        //       editorRD.clear();editorRD.commit();                   chequear esto
//hacer sharedpreference con todos los datos, y hacer el archivo CSV
                        Intent intent = new Intent(Inversion.this, ConcepTecnico.class);
                        startActivity(intent);


                    }
                    break;

                }
                return true;

            }
        });
    }
}
