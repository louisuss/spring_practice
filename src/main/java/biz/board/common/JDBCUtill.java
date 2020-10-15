package biz.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // statement 클래스(sql 구문 실행) 클래스 기능 향상. 텍스트 sql 호출
import java.sql.ResultSet; // select 결과를 저장하는 객체

public class JDBCUtill {
    public static Connection getConnection() {
        try {
            // 클래스 이름 지정
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(PreparedStatement stmt, Connection conn) {
        if (stmt != null) {
            try {
                if (!stmt.isClosed()) stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                stmt = null;
            }
        }

        if (conn != null) {
            try {
                if (!conn.isClosed()) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }

    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
        if (rs != null) {
            try {
                if (!rs.isClosed()) rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rs = null;
            }
        }

        if (stmt != null) {
            try {
                if (!stmt.isClosed()) stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                stmt = null;
            }
        }

        if (conn != null) {
            try {
                if (!conn.isClosed()) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }
}
