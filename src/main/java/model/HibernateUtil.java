package model;

import com.model.StudentGrades;
import com.model.StudentInfo;
import com.model.StudentPay;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Properties;

public class HibernateUtil {

      private static SessionFactory sessionFactory;

      private final static String username = "system";
      private final static String password = "Manager@123";
      private final static String database = "dit";
//	private final static String filePath = "E:/Daisy/";

      public static void init() {
            try {
                  final Properties property = new Properties();
                  property.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
                  property.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/" + database + "?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false");
                  property.setProperty("hibernate.connection.username", username);
                  property.setProperty("hibernate.connection.password", password);
                  property.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                  property.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
                  property.setProperty("hibernate.hbm2ddl.auto", "update");
                  property.setProperty("hibernate.show_sql", "true");
                  sessionFactory = new Configuration()
                        .addAnnotatedClass(StudentGrades.class)
                        .addProperties(property)
                        .buildSessionFactory();
            } catch (Throwable ex) {
                  throw new ExceptionInInitializerError(ex);
            }
      }

      public static SessionFactory getSessionFactory() {
            try {
                  if ((sessionFactory.isClosed()) || sessionFactory == null) {
                        init();
                  }
            } catch (Exception e) {
                  init();
            }
            return sessionFactory;
      }

      public static Session getSession() {
            return getSessionFactory().openSession();
      }
}
