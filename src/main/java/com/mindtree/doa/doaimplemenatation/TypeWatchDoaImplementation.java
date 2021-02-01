package com.mindtree.doa.doaimplemenatation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mindtree.doa.TypeWatchDoa;
import com.mindtree.exceptionhandling.ConnectionUtilityException;
import com.mindtree.exceptionhandling.DoaException;
import com.mindtree.utility.ConnectionUtility;

public class TypeWatchDoaImplementation implements TypeWatchDoa {
	ConnectionUtility utility = new ConnectionUtility();

	
	public boolean deleteType(int id) throws DoaException {
		// TODO Auto-generated method stub
		boolean deleted=false;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {

			conn = utility.getConnection();
			;// For MySQL only

			String query = "delete from watch where watch.typeid=" + id;
			preparedStatement = conn.prepareStatement(query);
			 preparedStatement.executeUpdate();

			query = "delete from type where type.id=" + id;
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.executeUpdate();
			deleted=true;

		} catch (ConnectionUtilityException e) {
			throw new DoaException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DoaException(e);

		} finally {
			try {
				utility.closeConnection(preparedStatement);

				utility.closeConnection(conn);
			} catch (ConnectionUtilityException e) {
				// TODO Auto-generated catch block
				throw new DoaException(e);
			}
		}
		return deleted;

	}

}
