package Winter2022.h;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * java program to sort millions of data from database in batches.
 * This class demonstrates reading data from a MySQL database and sorting it alphabetically by name.
 * The sorted data is then updated in the database using batch updates.
 */
public class ReadDBDataSort {

    private static final Logger log = LoggerFactory.getLogger(ReadDBDataSort.class);

    /**
     * Entry point of the program. Calls the sortData() method.
     */
    public static void main(String[] args) {

        sortData();
    }

    private static final int BATCH_SIZE = 100; //You can experiment with different batch sizes to find the optimal value for your specific case

    private static void sortData() {
        try {
            // Connect to the database
            Connection conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/soc", "root", "Zee@1995");
            createIndex(conn);
            String query = "Select * from employee order by name";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            List<String> data = new ArrayList<>();
            while (rs.next()) {
                String row = rs.getString("name");
                data.add(row);
            }
            mergeSort(data, 0, data.size() - 1);

            PreparedStatement updateStmt =
                    conn.prepareStatement("update employee set name = ? where id= ?");
            int count = 0;
            int id = 0;
            for (String row : data) {
                updateStmt.setString(1, row);
                updateStmt.setInt(2, id);
                updateStmt.addBatch();
                count++;
                id++;
                if (count % BATCH_SIZE == 0) {
                    updateStmt.executeBatch();
                }
            }
            updateStmt.executeBatch();

            //close db conn
            rs.close();
            stmt.close();
            updateStmt.close();
            conn.close();
        } catch (SQLException e) {
            log.error("unable to connect to db: " + e.getMessage());
        }
    }

    /**
     * Implements the merge sort algorithm on a list of Strings.
     *
     * @param data  The list of Strings to be sorted
     * @param left  The starting index of the sub-list
     * @param right The ending index of the sub-list
     */
    private static void mergeSort(List<String> data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }

    /**
     * Merges two sorted sub-lists of Strings.
     *
     * @param data  The list of Strings containing both sub-lists
     * @param left  The starting index of the first sub-list
     * @param mid   The ending index of the first sub-list
     * @param right The ending index of the second sub-list
     */
    private static void merge(List<String> data, int left, int mid, int right) {

        List<String> leftList = new ArrayList<>(data.subList(left, mid + 1));
        List<String> rightList = new ArrayList<>(data.subList(mid + 1, right + 1));
        int i = 0, j = 0, k = left;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i).compareTo(rightList.get(j)) <= 0) {
                data.set(k, leftList.get(i));
                i++;
            } else {
                data.set(k, rightList.get(j));
                j++;
            }
            k++;
        }
        while (i < leftList.size()) {
            data.set(k, leftList.get(i));
            i++;
            k++;
        }
        while (i < rightList.size()) {
            data.set(k, rightList.get(j));
            j++;
            k++;
        }
    }

    /**
     * This method creates an index for the 'name' column of the 'employee' table in the database, if it doesn't already exist.
     *
     * @param conn a Connection object representing a connection to the database
     * @throws SQLException if an error occurs while executing the SQL statements
     */
    private static void createIndex(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("show index from employee where Column_name = 'name'");
        if (!rs.next()) {
            stmt.execute("create index idx_name on employee (name)");
        }
        rs.close();
        stmt.close();
    }
}
