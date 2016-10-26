package project3.util;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;

public class JoinColumn {

	/**
	 * A private method to join the table together
	 * 
	 * @param column the column to join
	 * @param criteria where it joining to
	 */
	public static void addColumnByJoin(String column, Criteria criteria) {
		criteria.setFetchMode(column, FetchMode.JOIN);
	}
}
