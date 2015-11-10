package es.upv.metodo.utils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class UpvCookieUtil 
{
  public static final String getTDPTDp(HttpServletRequest request)
  {
    String nombre;
    String valor = "";
    Cookie[] cookies = request.getCookies();
    if (cookies==null) 
    {
      System.out.println("No se encuentran cookies");      
      return "";
    };
    for(int i=0; i<cookies.length; i++) {
        Cookie thisCookie = cookies[i];
        //System.out.println("Cookie:Nombre:"+thisCookie.getName()+" Valor:"+thisCookie.getValue());         
        if (thisCookie.getName().equals("TDP") || thisCookie.getName().equals("TDp") || thisCookie.getName().equals("TDX")) {
           nombre  = thisCookie.getName();
           valor   = thisCookie.getValue();            
           return valor;
        }
    };  
    return "";
  }
  public static final String getCookie(HttpServletRequest request,String p_cookie)
  {
    String nombre;
    String valor = "";
    Cookie[] cookies = request.getCookies();
    if (cookies==null) 
    {
      System.out.println("No se encuentran cookies");      
      return "";
    };
    for(int i=0; i<cookies.length; i++) {
        Cookie thisCookie = cookies[i];
        //System.out.println("Cookie:Nombre:"+thisCookie.getName()+" Valor:"+thisCookie.getValue());         
        if (thisCookie.getName().equals(p_cookie)) {
           nombre  = thisCookie.getName();
           valor   = thisCookie.getValue();            
           return valor;
        }
    };  
    return "";
  }
}