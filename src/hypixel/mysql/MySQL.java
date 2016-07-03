package hypixel.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Niels on 03-07-16.
 */
public class MySQL {

    private static Connection connection;

    public static void connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String str1 = "37.187.134.19";
            String str2 = "mc20070";
            String str3 = "mc20070";
            String str4 = "2cf5b7aa72";
            connection = DriverManager.getConnection("jdbc:mysql://" + str1 + "/" + str2 + "?user=" + str3 + "&password=" + str4 + "");

            checkTables();
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
    }

    public static boolean columnExists(String paramString1, String paramString2)
    {
        try
        {
            ResultSet localResultSet = query("SELECT " + paramString2 + " FROM " + paramString1 + ";");
            return localResultSet != null;
        }
        catch (Exception localException) {}
        return false;
    }

    public static void checkTables() {}

    public static void update(String paramString)
    {
        try
        {
            PreparedStatement localPreparedStatement = connection.prepareStatement(paramString);
            localPreparedStatement.execute();
            localPreparedStatement.close();
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
    }

    public static ResultSet query(String paramString)
    {
        try
        {
            PreparedStatement localPreparedStatement = connection.prepareStatement(paramString);
            return localPreparedStatement.executeQuery();
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return null;
    }
}
