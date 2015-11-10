package es.upv.autenticacion;

import es.upv.metodo.utils.UpvCookieUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpvSSO extends Object 
{
	public static String getCheckSSO (HttpServletRequest request,
                                    HttpServletResponse response,
                                    String p_cua)
 		  throws Exception {
    //Inicio del control
    //System.out.println("Entra en UpvSSO.GetCheckSSO");
    
    //Miramos el cookie UPV
    String TDP=UpvCookieUtil.getTDPTDp(request);
    //System.out.println("Cookie-UPV:"+TDP); 
    //System.out.println("El valor de TDP es:"+TDP+" su longitud:"+TDP.length());
    System.out.println("AUTT: =========Variables Obtenidas===========");
    System.out.println("AUTT: TDP:"+TDP+" CLIENTIP:"+request.getHeader("CLIENTIP")+" RemoteAddr:"+request.getRemoteAddr());
   

    String linea="";
    String ipRemota="";
    String ipRemota2="";

    //Obtenemos la direccion Remota del cliente
       if (request.getHeader("CLIENTIP")!=null) 
       {
        ipRemota=request.getHeader("CLIENTIP");
        ipRemota2=request.getRemoteAddr();
       }
       else 
       {
        ipRemota=request.getRemoteAddr(); 
        ipRemota2=request.getRemoteAddr();
       };

    //Si tiene la cookie es porque esta autenticado en UPV
    if (TDP.length()!=0) 
    {
    //Llamamos a la cua para que nos devuelva si esta o no autenticado    
    try {   
       String location = "http://alumnat.upv.es/dir/autt/"+p_cua+"/"+ipRemota;
       location=location+"?"+TDP;
       System.out.println("AUTT: Peticion SSO-UPV:"+linea);           
       URL url = new URL(location);        
       //System.out.println("url:"+location);
       BufferedReader respuesta = new BufferedReader(new InputStreamReader((InputStream)url.openStream()));          
       linea = new String(respuesta.readLine());
       //while (linea!=null) {      
       System.out.println("AUTT: Respuesta SSO-UPV:"+linea);           
       //   linea = new String(respuesta.readLine());
       //  }
       
       //Si la autenticacion UPV ha sido nula buscamos en autenticacion CFP
       if (linea!=null) {
          //Ahora comprobamos si es que ha dado error de autenticación
          if (linea.startsWith("ERROR")) { return null;} else {return linea;}
       };
    }
    catch (Exception e) 
    {
     e.printStackTrace();
     return null;  
    };
    };
    //AQUI SE LLEGA CUANDO NO ES POSIBLE AUTENTICAR CON UPV
    //Miramos la cookie del CFP 
    TDP=UpvCookieUtil.getCookie(request,"CFPSAKAI");
    //System.out.println("Cookie-CFP:"+TDP); 
    if (TDP.length()!=0) 
    {
    //Llamamos a la cua para que nos devuelva si esta o no autenticado    
    try {   
         String location2 = "http://www.cfp.upv.es/formacion-permanente/sakai/index.jsp?p_cua="+TDP+"&ipRemota="+ipRemota+"&ipRemota2="+ipRemota2;
         System.out.println("AUTT: Peticion SSO-CFP:"+location2); 
         URL url2 = new URL(location2);        
         BufferedReader respuesta2 = new BufferedReader(new InputStreamReader((InputStream)url2.openStream()));          
         linea = new String(respuesta2.readLine());
         System.out.println("AUTT: Respuesta SSO-CFP:"+linea); 
         if (linea!=null) {
            return linea;
         };          
    }
    catch (Exception e) 
    {
     e.printStackTrace();
     return null;  
    };
    };
    //Ha llegado aqui porque no se ha comprobado la autenticacion en UPV ni en CFP
    return null;          
    }
}
