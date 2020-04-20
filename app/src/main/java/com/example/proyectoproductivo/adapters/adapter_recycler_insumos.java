package com.example.proyectoproductivo.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.proyectoproductivo.R;
import com.example.proyectoproductivo.entities.categoria;

import java.util.List;

public class adapter_recycler_insumos extends RecyclerView.Adapter<adapter_recycler_insumos.viewHolderInsumo> {

    Context context;
    int posicion;
    List<categoria> categoriaList, categoriaListSelected;
    onCheckItemSelected onCheckItemSelected;

    public adapter_recycler_insumos(Context context, List<categoria> categoriaList, List<categoria> categoriaListSelected, int pos) {
        this.context = context;
        this.categoriaList = categoriaList;
        this.categoriaListSelected = categoriaListSelected;
        this.posicion = pos;
    }

    @Override
    public viewHolderInsumo onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_inversiones_list, parent, false);
        return new viewHolderInsumo(view);
    }

    @Override
    public void onBindViewHolder(final viewHolderInsumo holder, final int position) {
        //limpiar events
        holder.layout.setBackgroundColor(Color.argb(1, 255, 255, 255));
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.concep.setOnKeyListener(null);


        //  holder.UM.setText("$"+String.valueOf(categoriaList.get(position).getValor()));

        //validation
        if (categoriaListSelected.contains(categoriaList.get(position))) {
            holder.concep.setEnabled(true);
            holder.concep.setText(categoriaListSelected.get(categoriaListSelected.indexOf(categoriaList.get(position))).getCantidad() + "");
            holder.checkBox.setChecked(true);
        } else {
            holder.concep.setEnabled(false);
            holder.concep.setText(categoriaList.get(position).getCantidad() + "");
            holder.checkBox.setChecked(false);
        }

        //   holder.text.setText(categoriaList.get(position).getNombre());

        //asignar events


        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    holder.concep.setEnabled(true);
                    holder.concep.requestFocus();


                } else {
                    holder.concep.setEnabled(false);
                    //   onCheckItemSelected.onSelectedSubcategoriaListener(categoriaList.get(position),2);
                    if (categoriaListSelected.contains(categoriaList.get(position))) {
                        categoriaListSelected.remove(categoriaList.get(position));
                        holder.layout.setBackgroundColor(Color.argb(1, 231, 74, 59));
                    }
                }
            }
        });

        /*
        holder.editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(!holder.checkBox.isChecked())
                    return false;
                categoria newSub = categoriaList.get(position);


                newSub.setCantidad(Integer.parseInt(holder.editText.getText().toString().equals("") ? "0" : holder.editText.getText().toString()));
                onCheckItemSelected.onSelectedSubcategoriaListener(newSub,1);
                if(!categoriaListSelected.contains(newSub)) {
                    categoriaListSelected.add(newSub);
                    holder.layout.setBackgroundResource(R.color.colorAprobado);
                    //Toast.makeText(Inicial.this,"Add sub",Toast.LENGTH_SHORT).show();
                }
                else{
                    categoriaListSelected.remove(newSub);
                    categoriaListSelected.add(newSub);
                    holder.layout.setBackgroundResource(R.color.colorAprobado);
                    //Toast.makeText(Inicial.this,"Change sub",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        //holder.editText.addTextChangedListener(new TextWatcher() {
*/
    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }

    public class viewHolderInsumo extends RecyclerView.ViewHolder {
        AppCompatCheckBox checkBox;
        // TextView concep,UM;
        EditText concep, cant, UnMe, VU, VT;
        LinearLayout layout;

        public viewHolderInsumo(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.chkInsumoList);
            concep = itemView.findViewById(R.id.CON1);
            cant = itemView.findViewById(R.id.CAN1);
            UnMe = itemView.findViewById(R.id.UM1);
            VU = itemView.findViewById(R.id.VU1);
            VT = itemView.findViewById(R.id.VT1);

            layout = itemView.findViewById(R.id.linearViewInsumos);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        onCheckItemSelected = (onCheckItemSelected) context;
        super.onAttachedToRecyclerView(recyclerView);
    }

    public interface onCheckItemSelected {
        void onSelectedSubcategoriaListener(categoria subcategoria, int type);
    }
}
