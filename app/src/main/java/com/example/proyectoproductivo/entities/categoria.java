package com.example.proyectoproductivo.entities;

import java.util.ArrayList;
import java.util.List;

public class categoria {

    private String Concepto;
    private int Cantidad;
    private String UndMedida;
    private double ValorUnit;
    private double ValorTotal;
    private String fuentePs;
    private String fuenteHogar;

    private List<categoria> categoriaList;

    public List<categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public String getConcepto() {
        return Concepto;
    }

    public void setConcepto(String concepto) {
        Concepto = concepto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public String getUndMedida() {
        return UndMedida;
    }

    public void setUndMedida(String undMedida) {
        UndMedida = undMedida;
    }

    public double getValorUnit() {
        return ValorUnit;
    }

    public void setValorUnit(double valorUnit) {
        ValorUnit = valorUnit;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double valorTotal) {
        ValorTotal = valorTotal;
    }

    public String getFuentePs() {
        return fuentePs;
    }

    public void setFuentePs(String fuentePs) {
        this.fuentePs = fuentePs;
    }

    public String getFuenteHogar() {
        return fuenteHogar;
    }

    public void setFuenteHogar(String fuenteHogar) {
        this.fuenteHogar = fuenteHogar;
    }


    public static List<categoria> getList() {
        List<categoria> categoriaList = new ArrayList<>();
        //    List<subcategoria> subcategoriaList = new ArrayList<>();
        //Hortalizas 0

        categoria cat = new categoria(categoriaList);
        categoriaList.add(cat);

        return categoriaList;
    }

    public static List<categoria> getList(List<categoria> categoriaList) {
        List<categoria> data = new ArrayList<>();
        for (int a = 0; a < categoriaList.size(); a++) {
            //    data.add(new ArrayList<categoria>());
        }
        return data;
    }

    public static String[] getArrayString(List<categoria> categorias) {
        String[] data = new String[categorias.size()];
        for (int a = 0; a < categorias.size(); a++) {
            //   data[a] = categorias.get(a).getCategoriaList();
        }
        return data;
    }

    public static boolean[] getCheck(List<categoria> categorias, List<categoria> selectedSubcategorias) {
        boolean[] data = new boolean[categorias.size()];
        if (selectedSubcategorias == null) {
            for (int a = 0; a < categorias.size(); a++) {
                data[a] = false;
            }
            return data;
        }

        for (int a = 0; a < categorias.size(); a++) {
            data[a] = selectedSubcategorias.contains(categorias.get(a));
        }
        return data;
    }

    //TODO: devuelve el valor total de todo
    public static int getTotal(List<categoria> seletedCategorias) {
        int total = 0;
        for (int a = 0; a < seletedCategorias.size(); a++) {
            List<categoria> sub = seletedCategorias.get(a).getCategoriaList();
            for (int i = 0; i < sub.size(); i++) {
                total += sub.get(i).getValorTotal() * sub.get(i).getCantidad();
                //    total+= sub.get(i).getValor();
            }
        }
        return total;
    }

    //TODO: devuelve el valor total de la categoria
    public static int getTotal(categoria Categorias) {
        int total = 0;
        String items = "";
        if (Categorias == null)
            return 0;
        List<categoria> sub = Categorias.getCategoriaList();
        for (int i = 0; i < sub.size(); i++) {
            items += String.valueOf(sub.get(i).getValorTotal());
            total += sub.get(i).getValorTotal();
        }
        return total;
    }

    /*
    public static String getItems(categoria Categorias){
        int total =0 ;String items="";
        if(Categorias == null)
            return  "";
        List<subcategoria> sub = Categorias.getSubcategoriaList();
        for(int i=0;i<sub.size();i++){
            items+=String.valueOf(sub.get(i).getValor())+"+";

        }
        return items;
    }
*/
    public static int getCount(List<categoria> seletedCategorias) {
        int count = 0;
        for (int a = 0; a < seletedCategorias.size(); a++) {
            count += seletedCategorias.get(a).getCategoriaList().size();
        }
        return count;
    }

    public static String getCsvDetallada(List<categoria> seletedCategorias, String cedula, String nombre, String nombre2, String p_apellido, String s_apellido, String depart, String munic, String correg, String areahuerta, String areacria, String tanque, String filtro, String latitud, String longitud, String altitud, String fecha) {
        String data = "";
        String elementosHort = "";
        String elementosAro = "";
        String elementosTub = "";
        String elementosMusa = "";
        String elementosFruta = "";
        String elementosCer = "";
        String elementosLeg = "";
        String elementosEsp = "";
        String elementosCFP = "";
        String elementosRiego = "";
        String elementosEncierro = "";
        String elementosPoli = "";
        String elementosBio = "";
        String elementosAbono = "";
        String elementosHuertas = "";

        String cantHort = "";
        String cantAro = "";
        String cantTub = "";
        String cantMusa = "";
        String cantFruta = "";
        String cantCer = "";
        String cantLeg = "";
        String cantEsp = "";
        String cantCFP = "";
        String cantRiego = "";
        String cantEncierro = "";
        String cantPoli = "";
        String cantBio = "";
        String cantAbono = "";
        String cantHuertas = "";

        int Total = 0, Residual = 0;
        for (int a = 0; a < seletedCategorias.size(); a++) {
            List<categoria> sub = seletedCategorias.get(a).getCategoriaList();
            for (int i = 0; i < sub.size(); i++) {
                //    valorTotal+=sub.get(i).getValor()+",";
                Total += sub.get(i).getValorUnit() * sub.get(i).getCantidad();
                //
            }
            //    data= cedula+";"+depart+";"+munic+";"+correg+";"+areahuerta+";"+areacria+";"+tanque+";"+filtro+";"+elementosHort+";"+elementosAro+";"+elementosTub+";"+elementosMusa+";"+elementosFruta+";"+elementosCer+";"+elementosLeg+";"+elementosEsp+";"+elementosCFP+";"+elementosHuertas+";"+Total+";"+latitud.toString()+";"+longitud.toString()+";"+altitud.toString()+"\n";
        }
        //   Residual=Total-433000;

        data = cedula + ";" + nombre + ";" + nombre2 + ";" + p_apellido + ";" + s_apellido + ";" + depart + ";" + munic + ";" + correg + ";" + areahuerta + ";" + tanque + ";" + filtro + ";" + elementosHort + ";" + elementosAro + ";" + elementosTub + ";" + elementosMusa + ";" + elementosFruta + ";" + elementosCer + ";" + elementosLeg + ";" + elementosCFP + ";" + elementosRiego + ";" + elementosEncierro + ";" + elementosPoli + ";" + elementosBio + ";" + elementosAbono + ";" + elementosHuertas + ";" + cantHort + ";" + cantAro + ";" + cantTub + ";" + cantMusa + ";" + cantFruta + ";" + cantCer + ";" + cantLeg + ";" + cantCFP + ";" + cantRiego + ";" + cantEncierro + ";" + cantPoli + ";" + cantBio + ";" + cantAbono + ";" + cantHuertas + ";" + Total + ";" + Residual + ";" + latitud + ";" + longitud + ";" + altitud + ";" + fecha + "\n";

        return data;
    }

    public static String getCsvTotal(List<categoria> seletedCategorias) { //, String cedula
        String data = "";
        int Total = 0;
        for (int a = 0; a < seletedCategorias.size(); a++) {
            List<categoria> sub = seletedCategorias.get(a).getCategoriaList();
            Total = 0;
            for (int i = 0; i < sub.size(); i++) {
                Total += sub.get(i).getValorTotal();
            }
            //  data+= cedula+";"+seletedCategorias.get(a).getNombre()+";"+Total+"\n";
        }
        return data;
    }


    public categoria() {
    }

    public categoria(List<categoria> categoriaList) {

        this.categoriaList = categoriaList;
    }

  /*
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result +((Nombre == null ? 0:Nombre.hashCode()));
        return result; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        categoria other = (categoria) obj;
        if (Nombre == null) {
            if (other.Nombre != null)
                return false;
        } else if (!Nombre.equals(other.Nombre))
            return false;
        return true;
    }*/
}
