package org.sakaiproject.upv2.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Set;

import org.sakaiproject.util.ResourceLoader;
public class Sitio implements Serializable, Comparable {

	private Long codigo;
	private Long asi_codigo;
	private String edicion_caca;
	private String nombre;
	private String nombrev;
	private String nombrei;
	private String nombrecorto;
	private Set telsitios;
	private Long comp_codigo;
	private String publicado;
	private String idioma;
	private String biblio;
	private boolean seleccion;	
	private boolean preseleccion;
	private String sak_codigo;
	private String melete;
	private String microweb;	
	private Asignatura asignatura;
	private ResourceLoader rl;
	private String userid;	
	private String nomusu;			
	private String aluficticio;			
	private Date fechaconfig;	
	private String aluficticiopwd;
	private String aluficticioid;

	public Asignatura getAsignatura() 
	{
           return asignatura;
    }

    public void setAsignatura(Asignatura asi) 
	{
           this.asignatura = asi;
    }
	
	  public int compareTo(Object obj)
	  {
	    return this.nombre.compareTo(((Sitio) obj).getNombre());  
	  }
	  
	public Long getAsi_codigo() {
		return asignatura.getCodigo();
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getI18nNombre(){
          if (rl==null) {rl=new ResourceLoader();};
          if (rl.getLocale().toString().toLowerCase().startsWith("es")) {return nombre;}
	  if (rl.getLocale().toString().toLowerCase().startsWith("ca")) {return nombrev;}
	  else {return nombrei;}
							        }
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombrei() {
		return nombrei;
	}
	public void setNombrei(String nombrei) {
		this.nombrei = nombrei;
	}
	public String getNombrev() {
		return nombrev;
	}
	public void setNombrev(String nombrev) {
		this.nombrev = nombrev;
	}

	public String getEdicion_caca() {
		return edicion_caca;
	}

	public void setEdicion_caca(String edicion_caca) {
		this.edicion_caca = edicion_caca;
	}

	public Set getTelsitios() {
		return telsitios;
	}

	public void setTelsitios(Set telsitios) {
		this.telsitios = telsitios;
	}

	public boolean isSeleccion() {
		return seleccion;
	}

	public void setSeleccion(boolean seleccion) {
		this.seleccion = seleccion;
	}

	public boolean isPreseleccion() {
		return preseleccion;
	}

	public void setPreseleccion(boolean preseleccion) {
		this.preseleccion = preseleccion;
	}

	public Long getComp_codigo() {
		return comp_codigo;
	}

	public void setComp_codigo(Long comp_codigo) {
		this.comp_codigo = comp_codigo;
	}

	public String getPublicado() {
		return publicado;
	}

	public void setPublicado(String publicado) {
		this.publicado = publicado;
	}

	public String getIdioma() {
		return idioma;
	}	

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getNombrecorto() {
		return nombrecorto;
	}

	public void setNombrecorto(String nombrecorto) {
		this.nombrecorto = nombrecorto;
	}

	public String getBiblio() {
		return biblio;
	}

	public void setBiblio(String biblio) {
		this.biblio = biblio;
	}	
	
	public void setSakCodigo(String cod) {
		this.sak_codigo = cod;
	}
	
	public String getSakCodigo() {
		return sak_codigo;
	}

	public String getMelete() {
		return melete;
	}

	public void setMelete(String melete) {
		this.melete = melete;
	}

	public String getMicroweb() {
		return microweb;
	}

	public void setMicroweb(String microweb) {
		this.microweb = microweb;
	}

	public String getAluficticio() {
		return aluficticio;
	}

	public void setAluficticio(String aluficticio) {
		this.aluficticio = aluficticio;
	}

	public Date getFechaconfig() {
		return fechaconfig;
	}

	public void setFechaconfig(Date fechaconfig) {
		this.fechaconfig = fechaconfig;
	}

	public String getNomusu() {
		return nomusu;
	}

	public void setNomusu(String nomusu) {
		this.nomusu = nomusu;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String geti18nFechaconfig() {
		if (fechaconfig==null) {return "../../....";};
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return df.format(fechaconfig);
	}

	public String getAluficticiopwd() {
		if (aluficticiopwd==null) {aluficticiopwd=generaAluficticiopwd();};
		return aluficticiopwd;
	}

	public void setAluficticiopwd(String aluficticiopwd) {
		this.aluficticiopwd = aluficticiopwd;
	}

	public String getAluficticioid() {
		if (aluficticioid==null) {aluficticioid=generaAluficticioid();};
		return aluficticioid;
	}

	public void setAluficticioid(String aluficticioid) {
		this.aluficticioid = aluficticioid;
	}
	

	private String generaAluficticioid() {
		String id = "";
		try {			 
		     if (sak_codigo.startsWith("CFP")) 
	            { id = "alu"+codigo;}
	            { id = "alu"+asignatura.getOrigen();};
		} catch (Exception e) {};        
		return id;
	}
	private String generaAluficticiopwd() {
		String pwd = "";
		try {			 			
		     pwd = genPassword();
		} catch (Exception e) {};        
		return pwd;
	}	
	
    static String genPassword() {
        final	String[]    SILAB	= {"ca","ba","ce","da","te","fu","ga","hi","ti","ja","ko","la","me","ni","to","pa","qa","ra","se","ti","mu","vi","wa","xe","ya","zo"};
        final	String[]    DIGIT	= {"0","1","2","3","4","5","6","7","8","9"};
        String pass	= "";
        for (int i=0; i<4; i++){                       
             String resa = SILAB[genNum(26)];
             pass = pass + resa;                                          
        }
        for (int i=0; i<2; i++){                   
            String resa = DIGIT[genNum(9)];
            pass = pass + resa;            
       }               

        return pass;

       }

       static int genNum(int arrTam) {
	    int         iGeRaNu ;
        String      sTam ;
        String      sChar;        
        Double d = new Double(Math.random()*10000);         
        iGeRaNu = d.intValue() % arrTam;
        sTam = new Integer(iGeRaNu).toString();
        sChar = new String(String.valueOf(sTam.charAt(0)));
        //Converting the possible negative number to positive
        if ( sChar.equals("-")){iGeRaNu = iGeRaNu * -1;}
        return iGeRaNu;
        }
	
}
