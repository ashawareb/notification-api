import java.sql.*;
import java.util.Scanner;

public class ConsoleApp {
    static Scanner in = new Scanner(System.in);

    static Connection connectToDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Notification_System";
        String user = "root";
        String password = "01032329426";
        Connection connection = null;
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    static void dequeAllSMS(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "DELETE FROM sms WHERE status=" + true; /// query to delete all successful SMS
        statement.executeUpdate(sql);
        System.out.println("Deque all SMS Successfully");
    }

    void dequeAllMail(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "DELETE FROM mail WHERE status=" + true; /// query to delete all successful SMS
        statement.executeUpdate(sql);
        System.out.println("Deque all mail Successfully");
    }

    static void dequeOneByOneSMS(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "select* FROM sms where status=" + true; /// query to delete all successful SMS
        ResultSet res = statement.executeQuery(sql);
        if (res.next()) {
            sql = "DELETE FROM SMS WHERE id=" + res.getString("id");
            statement.executeUpdate(sql);
            System.out.println("Deque SMS Successfully");
        }
        System.out.println("Do you want deque sms again?(Y/N)");
        in.nextLine();
        String option = in.nextLine();
        if (option.equalsIgnoreCase("Y")) {
            dequeOneByOneSMS(connection);
        }
    }

    static void dequeOneByOneMail(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "select* FROM mail where status=" + true; /// query to delete all successful SMS
        ResultSet res = statement.executeQuery(sql);
        if (res.next()) {
            sql = "DELETE FROM mail WHERE id=" + res.getString("id");
            statement.executeUpdate(sql);
            System.out.println("Deque mail Successfully");
        }
        System.out.println("Do you want deque mail again?(Y/N)");
        in.nextLine();
        String option = in.nextLine();
        if (option.equalsIgnoreCase("Y")) {
            dequeOneByOneMail(connection);
        }
    }

    static void SmsDisplay(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM sms WHERE status=" + true; /// query to get all successful SMS
        ResultSet res = statement.executeQuery(sql);
        System.out.println();
        while (res.next()) {
            System.out.println("Body: " + res.getString("body"));
            System.out.println("Subject: " + res.getString("subject"));
            System.out.println("ID: " + res.getString("ID"));
            System.out.println("Language: " + res.getString("Language"));
            System.out.println("Sender: " + res.getString("Sender"));
            System.out.println("Receiver: " + res.getString("Receiver"));
            System.out.println("Status: " + res.getString("Status"));
            System.out.println("----------------------------------------------------->");
        }
        System.out.println("1- Deque All");
        System.out.println("2- Dequeue one by one");
        System.out.println("3- Display Again");
        System.out.println("4- Back");
        int option = in.nextInt();
        if (option == 1) {
            dequeAllSMS(connection);
            SmsDisplay(connection);

        } else if (option == 2) {
            dequeOneByOneSMS(connection);
            SmsDisplay(connection);

        } else if (option == 3) {
            SmsDisplay(connection);
        }

    }

    static void mailDisplay(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM MAIL WHERE status=" + true; /// query to get all successful mail
        ResultSet res = statement.executeQuery(sql);
        System.out.println();
        while (res.next()) {
            System.out.println("Body: " + res.getString("body"));
            System.out.println("Subject: " + res.getString("subject"));
            System.out.println("ID: " + res.getString("ID"));
            System.out.println("Language: " + res.getString("Language"));
            System.out.println("Sender: " + res.getString("Sender"));
            System.out.println("Receiver: " + res.getString("Receiver"));
            System.out.println("Status: " + res.getString("Status"));
            System.out.println("----------------------------------------------------->");
        }
        System.out.println("1- Deque All");
        System.out.println("2- Dequeue one by one");
        System.out.println("3- Display Again");
        System.out.println("4- Back");

        int option = in.nextInt();
        if (option == 1) {
            dequeAllSMS(connection);
            mailDisplay(connection);

        } else if (option == 2) {
            dequeOneByOneMail(connection);
            mailDisplay(connection);

        } else if (option == 3) {
            mailDisplay(connection);
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = connectToDatabase();
        System.out.println();
        System.out.println();
        if (connection == null) {
            System.out.println("NULL");
        } else {
            System.out.println("CONNECTED");
        }
        start(connection);
    }

    static void start(Connection connection) throws SQLException {
        System.out.println("1- SMS operations");
        System.out.println("2- MAIL operations");
        System.out.println("3- Exit");
        int option = in.nextInt();
        if (option == 1) {
            SmsDisplay(connection);
        } else if (option == 2) {
            mailDisplay(connection);
        } else if (option == 3) {
            return;
        }
        start(connection);
    }

}
