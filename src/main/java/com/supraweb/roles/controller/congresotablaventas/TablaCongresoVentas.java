package com.supraweb.roles.controller.congresotablaventas;


 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 



@Entity
@Table(name = "tabla_congreso_ventas", schema = "public")
public class TablaCongresoVentas  {
	//public class TablaCongresoVentas implements Serializable {


   // private static final long serialVersionUID = 1L;

   
    
    @Column(name = "cantidad_de_productos")
    private int cantidadDeProductos;
    
    @Column(name = "fechadeventas")
   // @Temporal(TemporalType.TIMESTAMP)
   // private Date fechadeventas;
    private String fechadeventas;

    
    @Column(name = "id_codigo_de_barra")
    private String idCodigoDeBarra;

    @Column(name = "nombre_del_producto")
    private String nombreDelProducto;

  

    @Column(name = "remarcacion_resultado_final")
    private float remarcacionResultadoFinal;

   
   
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
    @Column(name = "id")
    private Integer id;
    
    
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "mail")
    private String mail;
    public TablaCongresoVentas() {
    }

    public TablaCongresoVentas(Integer id) {
        this.id = id;
    }

    public TablaCongresoVentas(Integer id, String idCodigoDeBarra, String nombreDelProducto, 
    		int cantidadDeProductos, float remarcacionResultadoFinal
    		, String fechadeventas,String usuario,String mail) 
    /*
    public TablaCongresoVentas(Integer id, String idCodigoDeBarra, String nombreDelProducto, 
    		int cantidadDeProductos, float remarcacionResultadoFinal
    		, Date fechadeventas,String usuario) 
    */
    {
        this.id = id;
        this.idCodigoDeBarra = idCodigoDeBarra;
        this.nombreDelProducto = nombreDelProducto;
        this.cantidadDeProductos = cantidadDeProductos;
        this.remarcacionResultadoFinal = remarcacionResultadoFinal;
        this.fechadeventas = fechadeventas;
        this.usuario = usuario;
        this.mail = mail;

    }

    public String getIdCodigoDeBarra() {
        return idCodigoDeBarra;
    }

    public void setIdCodigoDeBarra(String idCodigoDeBarra) {
        this.idCodigoDeBarra = idCodigoDeBarra;
    }

    public String getNombreDelProducto() {
        return nombreDelProducto;
    }

    public void setNombreDelProducto(String nombreDelProducto) {
        this.nombreDelProducto = nombreDelProducto;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public void setCantidadDeProductos(int cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    public float getRemarcacionResultadoFinal() {
        return remarcacionResultadoFinal;
    }

    public void setRemarcacionResultadoFinal(float remarcacionResultadoFinal) {
        this.remarcacionResultadoFinal = remarcacionResultadoFinal;
    }
/*
    public Date getFechadeventas() {
        return fechadeventas;
    }*/
    public String getFechadeventas() {
        return fechadeventas;
    }
/*
    public void setFechadeventas(Date fechadeventas) {
        this.fechadeventas = fechadeventas;
    }
*/
    public void setFechadeventas(String fechadeventas) {
        this.fechadeventas = fechadeventas;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

    
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
    
    /*
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TablaCongresoVentas)) {
            return false;
        }
        TablaCongresoVentas other = (TablaCongresoVentas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "supraweb.com.ar.TablaCongresoVentas[ id=" + id + " ]";
    }
    */
}
