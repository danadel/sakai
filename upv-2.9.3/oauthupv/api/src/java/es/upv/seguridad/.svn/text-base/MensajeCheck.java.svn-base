package es.upv.seguridad;



/**
 * Mensaje recibido del servidor de autenticacion cuando se hace 'ckeck' de un token.
 * @since 15/9/2015
 *
 */
public final class MensajeCheck {

	private String app_id;
	private String scope;
	private Integer expires_in;	
	/**
	 * Este dato SOLAMENTE llegara si es una aplicacion privada. Si es una aplicacion publica sera nulo.
	 */
	private String id_user;
	
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	/*public MensajeCheck(String app_id) {
	   this.app_id = app_id;
	}*/
	/**
	 * Devuelve la lista de scopes separados por coma(tal y como lo devuelve el servidor de autenticacion)
	 * @return Lista scopes
	 */
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public Integer getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
    
	/**
	 * Devuelve la lista de scopes en formato array de cadenas
	 * @return
	 */
	public String[] getScopes(){
		if(this.scope!=null){
			return this.scope.split(",");//Los scopes van separados por comas
		}else{
			return null;
		}
	}

	public String toString() {
		return "MensajeCheck [app_id=" + app_id + ", scope=" + scope+ ", expires_in=" + expires_in + ", id_user=" + id_user +"]";
	}

	
	
}
