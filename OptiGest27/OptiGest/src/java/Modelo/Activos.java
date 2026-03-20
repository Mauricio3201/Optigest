/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Activos {

    private int id_activos;
    private String codigo_act;
    private String nombre_activos;
    private String valor;
    private String fecha_adquma;
    private String fecha_devolucion;
    private String vida_util;
    private String Estado_Activo_idEstado_Activo;
    private String Categorias_idCategorias;
    private String Proveedores_idProveedores;

    public int getId_activos() {
        return id_activos;
    }

    public void setId_activos(int id_activos) {
        this.id_activos = id_activos;
    }

    public String getCodigo_act() {
        return codigo_act;
    }

    public void setCodigo_act(String codigo_act) {
        this.codigo_act = codigo_act;
    }

    public String getNombre_activos() {
        return nombre_activos;
    }

    public void setNombre_activos(String nombre_activos) {
        this.nombre_activos = nombre_activos;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFecha_adquma() {
        return fecha_adquma;
    }

    public void setFecha_adquma(String fecha_adquma) {
        this.fecha_adquma = fecha_adquma;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getVida_util() {
        return vida_util;
    }

    public void setVida_util(String vida_util) {
        this.vida_util = vida_util;
    }

    public String getEstado_Activo_idEstado_Activo() {
        return Estado_Activo_idEstado_Activo;
    }

    public void setEstado_Activo_idEstado_Activo(String Estado_Activo_idEstado_Activo) {
        this.Estado_Activo_idEstado_Activo = Estado_Activo_idEstado_Activo;
    }

    public String getCategorias_idCategorias() {
        return Categorias_idCategorias;
    }

    public void setCategorias_idCategorias(String Categorias_idCategorias) {
        this.Categorias_idCategorias = Categorias_idCategorias;
    }

    public String getProveedores_idProveedores() {
        return Proveedores_idProveedores;
    }

    public void setProveedores_idProveedores(String Proveedores_idProveedores) {
        this.Proveedores_idProveedores = Proveedores_idProveedores;
    }

}