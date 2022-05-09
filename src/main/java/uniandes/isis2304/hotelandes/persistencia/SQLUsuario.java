package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.hotelandes.negocio.Usuario;
import uniandes.isis2304.parranderos.negocio.Bebedor;
import uniandes.isis2304.parranderos.persistencia.PersistenciaParranderos;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

public class SQLUsuario {
	private final static String SQL = PersistenciaHotelAndes.SQL;

	/* ****************************************************************
		* Atributos
		*****************************************************************/
	/**
		* El manejador de persistencia general de la aplicación
		*/
	private PersistenciaHotelAndes pp;

	/* ****************************************************************
		* Métodos
		*****************************************************************/
	/**
		* Constructor
		* @param pp - El Manejador de persistencia de la aplicación
		*/
	public SQLUsuario (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}

	public List<Usuario> darUsuarioPorLogin(PersistenceManager pm, String login) {

		System.out.println("llego a SQLUSUARIO");
		String select= "SELECT " + pp.darTablaUsuario()+ ".id ,"+ pp.darTablaUsuario()+ ".nombre, "+ pp.darTablaUsuario()+ ".documento, "+ pp.darTablaUsuario()+ ".tipoPlan, "+ pp.darTablaUsuario()+ ".tipoUsuario, "+ pp.darTablaUsuario()+ ".tipoDocumento, "+ pp.darTablaUsuario()+ ".login, "+ pp.darTablaUsuario()+ ".contrasena, "+ pp.darTablaUsuario()+ ".email, "+ pp.darTablaTipoUsuario()+ ".tipo as nombreTipoUsuario ";
		String from = "FROM " + pp.darTablaUsuario() +" INNER JOIN "+pp.darTablaTipoUsuario()+" ON " + pp.darTablaUsuario() +"."+pp.darTablaTipoUsuario()+" = "+pp.darTablaTipoUsuario()+".ID ";
		String where = "WHERE USUARIO.LOGIN= ?";
		System.out.println(select+from+where);
		Query q = pm.newQuery(SQL, select+from+where);

		q.setResultClass(Usuario.class);
		q.setParameters(login);
		return (List<Usuario>) q.executeList();
	}

	public long adicionarUsuario(PersistenceManager pm, String nombre, String documento, int tipoPlan, int tipoUsuario,
		int tipoDocumento, String login, String contrasena, String email) {
			Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaUsuario() + "(nombre, documento, tipoplan, tipodocumento, tipousuario, login, contrasena, email) values (?, ?, ?, ?, ?, ?, ?, ?)");
			q.setParameters(nombre, documento, tipoPlan, tipoUsuario, tipoDocumento, login, contrasena, email);
			return (long) q.executeUnique();
	}

	public List<Usuario> getUsersWConvenciones(PersistenceManager persistenceManager) {
		List usuariosWConvenciones=null;
		try{
			String theStringQuery = "SELECT USUARIO.ID, USUARIO.NOMBRE, USUARIO.DOCUMENTO, USUARIO.TIPOPLAN, USUARIO.TIPODOCUMENTO, USUARIO.TIPOUSUARIO, USUARIO.LOGIN, USUARIO.CONTRASENA, USUARIO.EMAIL FROM USUARIO INNER JOIN RESERVASERVICIO ON USUARIO.ID = IDUSUARIO WHERE (SELECT COUNT(RS.HORAINICIO) FROM RESERVASERVICIO RS WHERE RS.IDUSUARIO = IDUSUARIO AND RS.ACTIVO=1 GROUP BY RS.HORAINICIO OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY)>1 AND RESERVASERVICIO.ACTIVO=1 OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY";
			Query q = persistenceManager.newQuery(SQL, theStringQuery);
			q.setResultClass(Usuario.class);
			usuariosWConvenciones = (List) q.executeList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return usuariosWConvenciones;
	}

}

