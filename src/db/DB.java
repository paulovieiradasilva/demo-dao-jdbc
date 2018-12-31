package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	/**
	 * Gera um conexão com banco de dados.
	 * 
	 * @return
	 */
	public static Connection getConnetion() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");

				conn = DriverManager.getConnection(url, props);

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	/* Fecha conexão com banco de dados. */
	public static void closeConnetion() {
		if (conn != null) {
			try {
				conn.close();

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	/**
	 * Carrega as propriedades setadas no arquivo db.properties
	 * 
	 * @return
	 */
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;

		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
