package com.mindtree.doa.doaimplemenatation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.doa.WatchDoa;
import com.mindtree.entity.Watch;
import com.mindtree.exceptionhandling.ConnectionUtilityException;
import com.mindtree.exceptionhandling.DoaException;

import com.mindtree.exceptionhandling.TypeNotFoundException;
import com.mindtree.utility.ConnectionUtility;

public class WatchDoaImplementation implements WatchDoa {
	ConnectionUtility utility = new ConnectionUtility();

	public boolean addWatch(Watch watch) throws DoaException, TypeNotFoundException {
		// TODO Auto-generated method stub
		boolean added=false;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = utility.getConnection();

			String query = "insert into watch values(?,?,?,?)";

			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, watch.getId());
			preparedStatement.setString(2, watch.getModelName());
			preparedStatement.setFloat(3, watch.getPrice());
			preparedStatement.setInt(4, watch.getTypeID());

			preparedStatement.execute();
			added=true;

		} catch (ConnectionUtilityException e) {
			throw new DoaException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		} finally {
			try {
				utility.closeConnection(preparedStatement);
				utility.closeConnection(conn);
			} catch (ConnectionUtilityException e) {
				// TODO Auto-generated catch block
				throw new DoaException(e);
			}
		}
		return added;

	}

	public List<Watch> getWatchList() throws DoaException {
		// TODO Auto-generated method stub
		List<Watch> watches = new ArrayList<Watch>();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rst = null;
		try {

			conn = utility.getConnection();
			String query = "select * from watch";
			preparedStatement = conn.prepareStatement(query);
			rst = preparedStatement.executeQuery();
			while (rst.next()) {
				Watch watch = new Watch(rst.getInt(1), rst.getString(2), rst.getFloat(3), rst.getInt(4));
				watches.add(watch);

			}

		} catch (ConnectionUtilityException e) {
			throw new DoaException(e);
		} catch (SQLException e) {
			System.out.println(e);
			throw new DoaException("error in inserting values");
		}
		{
			try {
				utility.closeConnection(preparedStatement);

				utility.closeConnection(conn);
			} catch (ConnectionUtilityException e) {
				// TODO Auto-generated catch block
				throw new DoaException(e);
			}
			return watches;
		}

	}

}
