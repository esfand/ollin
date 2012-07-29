package org.es4j.persistence.sql.ollin.examples;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.apache.derby.jdbc.ClientDataSource;
import org.es4j.persistence.sql.ollin.DBSession;
import org.es4j.persistence.sql.ollin.ResultSetRow;
import org.es4j.persistence.sql.ollin.RowPrinter;
import org.es4j.persistence.sql.ollin.ValuedRowVisitor;

/**
 *
 * @author Victor
 */
public class Main2 {
    
    public static void main(String[] args) throws SQLException {
        ClientDataSource dataSource=new ClientDataSource();
        dataSource.setDatabaseName("sample");
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(1527);
        dataSource.setUser("app");
        dataSource.setPassword("app");

        DBSession dbSession = new DBSession(dataSource);
        
        ValuedRowVisitor<Integer> rowCounter=dbSession.createQuery("select * from app.employee")
                                                      .forEachRow(new ValuedRowVisitor<Integer>() {
            private int counter;

            public Integer getValue() {
                return counter;
            }

            public void visit(ResultSetRow row) throws SQLException {
                counter++;
            }
        });
        System.out.println("Count of rows: "+rowCounter.getValue());
        
        try{
            System.out.println("from resource");
            dbSession.createQueryFromResource(Main2.class.getResource("example.sql"))
                     .forEachRow(new RowPrinter());
            System.out.println("after resource");
        } catch(IOException ex){
            ex.printStackTrace();
        }
        
        ValuedRowVisitor<List<Employee>> rowVisitor=new ValuedRowVisitor<List<Employee>>(){
            private List<Employee> employees=new LinkedList<Employee>();

            @Override
            public List<Employee> getValue() {
                return employees;
            }

            @Override
            public void visit(ResultSetRow row) throws SQLException {
                employees.add(new Employee(row.getString(1), row.getString(2)));
            }
        };
        dbSession.createQuery("select employee_id, name from app.employee")
                 .forEachRow(rowVisitor);
        List<Employee> employees=rowVisitor.getValue(); 
        
        //or using chainability
        employees=dbSession.createQuery("select employee_id, name from app.employee")
                           .forEachRow(rowVisitor)
                           .getValue(); 
    }
    
    
    public static class Employee{
        private String id;
        private String name;

        public Employee(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
