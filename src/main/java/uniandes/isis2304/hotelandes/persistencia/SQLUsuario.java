package uniandes.isis2304.hotelandes.persistencia;

import uniandes.isis2304.hotelandes.negocio.Usuario;
import uniandes.isis2304.parranderos.negocio.Bebedor;
import uniandes.isis2304.parranderos.negocio.Gustan;
import uniandes.isis2304.parranderos.persistencia.PersistenciaParranderos;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


	static Timestamp convertStringToTimestamp(String strDate) {
        return Optional.ofNullable(strDate) // wrap the String into an Optional
                       .map(str -> LocalDate.parse(str).atStartOfDay()) // convert into a LocalDate and fix the hour:minute:sec to 00:00:00
                       .map(Timestamp::valueOf) // convert to Timestamp
                       .orElse(null); // if no value is present, return null
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
	public List<Usuario> darUsuarioPorConsumoEnRangoYOtrasCaracteristicas(PersistenceManager pm, ArrayList<String> newQueries) {
		String query =" SELECT USUARIO.* "+
				" FROM USUARIO INNER JOIN REGISTROSERVICIO ON USUARIO.NOMBRE = REGISTROSERVICIO.NOMBREcliente ";
		int i = 0;
		for (String e:newQueries){
			if (i==0) {
				query += " " + e;
			}
			else{
				query +=" and "+e;
			}
			i+=1;
		}
		System.out.println(query);
		Query q = pm.newQuery(SQL, query);
		q.setResultClass(Usuario.class);
		return (List<Usuario>) q.executeList();
	}
	public List<Usuario> darUsuarioPorConsumoEnRangoYOtrasCaracteristicasConNumeroDeVeces(PersistenceManager pm, ArrayList<String> newQueries) {
		String query ="USUARIO.id, USUARIO.nombre, USUARIO.documento, USUARIO.TIPOPLAN, USUARIO.TIPODOCUMENTO,USUARIO.TIPOUSUARIO, USUARIO.LOGIN,  usuario.CONTRASENA ,usuario.email, COUNT(*)"+
				"FROM USUARIO INNER JOIN REGISTROSERVICIO ON USUARIO.NOMBRE = REGISTROSERVICIO.NOMBREcliente";
		int i = 0;
		for (String e:newQueries){
			if (i==0) {
				query = " " + e;
			}
			else{
				query =" and "+e;
			}
			i+=1;
		}
		query = query + " USUARIO.id, USUARIO.nombre, USUARIO.documento, USUARIO.TIPOPLAN, USUARIO.TIPODOCUMENTO,USUARIO.TIPOUSUARIO, USUARIO.LOGIN,  usuario.CONTRASENA ,usuario.email ";
		String newq="SELECT id, nombre, documento, TIPOPLAN,TIPODOCUMENTO,TIPOUSUARIO, LOGIN,  CONTRASENA , email " + " FROM( " + query + " )";
		Query q = pm.newQuery(SQL, newq);
		q.setResultClass(Usuario.class);
		return (List<Usuario>) q.executeList();
	}

	public long adicionarUsuario(PersistenceManager pm, String nombre, String documento, int tipoPlan, int tipoUsuario,
		int tipoDocumento, String login, String contrasena, String email) {
			Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaUsuario() + "(nombre, documento, tipoplan, tipodocumento, tipousuario, login, contrasena, email) values (?, ?, ?, ?, ?, ?, ?, ?)");
			q.setParameters(nombre, documento, tipoPlan, tipoUsuario, tipoDocumento, login, contrasena, email);
			return (long) q.executeUnique();
	}
	public List<Usuario> RFC7(PersistenceManager pm) {
		String a =" WITH PRIMERO AS (SELECT USUARIO.* "+
											" FROM ( "+
														" SELECT NOMBRECLIENTE AS BB, SUM(costototal) as a "+
																" FROM REGISTROSERVICIO WHERE TRUNC(fecha) > TRUNC(sysdate - INTERVAL '1' YEAR) "+
																" group by NOMBRECLIENTE) INNER JOIN USUARIO ON USUARIO.NOMBRE = BB "+
																" WHERE a>15000), "+
				" SEGUNDO AS (SELECT * "+
											" FROM ( "+
														" SELECT idUsuario, SUM (CAST(HORAFIN AS DATE)-CAST(HORAINICIO AS DATE)) AS DATEDIF "+
														" FROM RESERVA "+
														" GROUP BY idUsuario) "+
														" WHERE DATEDIF>14) "+
				" select PRIMERO.ID AS ID,  PRIMERO.NOMBRE AS NOMBRE, PRIMERO.DOCUMENTO AS DOCUMENTO, PRIMERO.TIPODOCUMENTO AS TIPODOCUMENTO, PRIMERO.TIPOPLAN AS  TIPOPLAN, PRIMERO.TIPOUSUARIO AS TIPOUSUARIO, PRIMERO.LOGIN AS LOGIN, PRIMERO.CONTRASENA AS CONTRASENA, PRIMERO.EMAIL AS EMAIL "+
				" from PRIMERO INNER JOIN SEGUNDO ON primero.id= segundo.idusuario ";

		System.out.println(a);
		String c= " SELECT x.* "+
				" FROM (SELECT * "+
								" FROM ( "+
										" SELECT idUsuario, SUM (CAST(HORAFIN AS DATE)-CAST(HORAINICIO AS DATE)) AS DATEDIF "+
										" FROM RESERVA "+
										" GROUP BY idUsuario) "+
						" WHERE DATEDIF>14) W "+
		" INNER JOIN "+
		" (SELECT USUARIO.* "+
				" FROM ( "+
						" SELECT NOMBRECLIENTE AS BB, SUM(costototal) as a "+
						" FROM REGISTROSERVICIO "+
						" WHERE sysdate >fecha and add_months(trunc(sysdate), -12*1) < fecha "+
						" group by NOMBRECLIENTE) INNER JOIN USUARIO ON USUARIO.NOMBRE = BB "+
		" WHERE a>15000)x "+
		" ON W.idUsuario=x.id ";
		String b ="select * from usuario WHERE ROWNUM<10";
		Query q = pm.newQuery(SQL, c);
		q.setResultClass(Usuario.class);
		List<Usuario> resp = (List<Usuario>) q.execute();

		return resp;
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
	

	public List<Usuario> getUsersWRegistroServicio(PersistenceManager persistenceManager, String fechaInicio, String fechaFin, boolean asc, String orderby){
		List usuariosWRegistroServicio=null;
		try{
			String theStringQuery = "SELECT USUARIO.ID, USUARIO.NOMBRE, USUARIO.DOCUMENTO, USUARIO.TIPOPLAN, USUARIO.TIPODOCUMENTO, USUARIO.TIPOUSUARIO, USUARIO.LOGIN, USUARIO.CONTRASENA, USUARIO.EMAIL FROM USUARIO INNER JOIN REGISTROSERVICIO ON USUARIO.NOMBRE = REGISTROSERVICIO.NOMBRECLIENTE WHERE (SELECT COUNT(RS.HORAINICIO) FROM REGISTROSERVICIO RS WHERE RS.IDUSUARIO = IDUSUARIO AND RS.ACTIVO=1 GROUP BY RS.HORAINICIO OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY)>1 AND REGISTROSERVICIO.ACTIVO=1 AND REGISTROSERVICIO.FECHA BETWEEN ? AND ? ORDER BY ? ASC";
			Query q = persistenceManager.newQuery(SQL, theStringQuery);
			q.setResultClass(Usuario.class);
			q.setParameters(fechaInicio, fechaFin, orderby);
			usuariosWRegistroServicio = (List) q.executeList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return usuariosWRegistroServicio;
	}

	public List<Usuario> getAllUsers(PersistenceManager pm){
		List<Usuario> usuarios = null;
		try{
			String theStringQuery = "SELECT * FROM USUARIO";
			Query q = pm.newQuery(SQL, theStringQuery);
			q.setResultClass(Usuario.class);
			usuarios = (List<Usuario>) q.executeList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return usuarios;
	}

}

