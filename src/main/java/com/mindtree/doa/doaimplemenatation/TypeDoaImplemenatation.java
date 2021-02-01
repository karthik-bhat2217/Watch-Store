package com.mindtree.doa.doaimplemenatation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.mindtree.doa.TypeDoa;
import com.mindtree.entity.Type;
import com.mindtree.exceptionhandling.ConnectionUtilityException;
import com.mindtree.exceptionhandling.DoaException;
import com.mindtree.utility.ConnectionUtility;

public class TypeDoaImplemenatation implements TypeDoa {
	ConnectionUtility utility = new ConnectionUtility();

	public boolean  addType(Type type) throws DoaException {
		boolean added=false;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = utility.getConnection();

			String query = "insert into type values(?,?)";

			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, type.getId());
			preparedStatement.setString(2, type.getName());

			preparedStatement.execute();
			added=true;

		} catch (ConnectionUtilityException e) {
			throw new DoaException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DoaException(e);// "error in inserting type"

		} finally {
			try {
				utility.closeConnection(preparedStatement);

				utility.closeConnection(conn);
			} catch (ConnectionUtilityException e) {
				// TODO Auto-generated catch block
				throw new DoaException(e);// "error in closing connection"
			}
			
		}
		return added;

	}

	public Map<Integer, Type> getType() throws DoaException {
		// TODO Auto-generated method stub
		Map<Integer, Type> types = new HashMap<Integer, Type>();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rst = null;
		try {

			conn = utility.getConnection();
			String query = "select * from type";
			preparedStatement = conn.prepareStatement(query);
			rst = preparedStatement.executeQuery();
			while (rst.next()) {
				Type type = new Type(rst.getInt(1), rst.getString(2));
				types.put(type.getId(), type);

			}

		} catch (ConnectionUtilityException e) {
			throw new DoaException(e);
		} catch (SQLException e) {
			System.out.println(e);
			throw new DoaException("error in inserting values");
		} finally {
			try {
				utility.closeConnection(rst);
				utility.closeConnection(preparedStatement);

				utility.closeConnection(conn);
			} catch (ConnectionUtilityException e) {
				// TODO Auto-generated catch block
				throw new DoaException(e);// "error in closing connection"
			}
		}

		return types;
	}

}
