import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class JavaSyncService {

    public static  String filepath=".\\Assignment Sheet.csv";
    public static  String jdbcurl = "jdbc:mysql://localhost:3306/csvdb";
    public static String user = "root";
    public static String password = "1234";
    public static Connection connection;


    public static void main() throws Exception{

       try{
           //reading csv file
           Reader reader=new FileReader(filepath) ;
           CsvToBean bean = new CsvToBeanBuilder(reader).withType(CsvModel.class).withIgnoreLeadingWhiteSpace(true).build();
           Iterator<CsvModel> csvrow = bean.iterator();

           connection = DriverManager.getConnection(jdbcurl, user, password);

           Statement stmt = connection.createStatement();
           ResultSet rs = stmt.executeQuery("select count(*) from csv");  rs.next();
           int count=rs.getInt(1);
           // checking that database table is  empty or not
           if(count!=0){

            sync();  //calling scheduler function if table is not empty
           }else{

               System.out.println("dataBase is empty ");
               System.out.println("Inserting data");
               saveToDatabase(csvrow);}//inserting data into database if table is empty

         }catch(Exception exception ){
            //if file was not found on the location;
           System.out.println(exception);
        }

    }

// function for saving data to database
    public static void saveToDatabase(Iterator<CsvModel> csvrow) throws Exception{


        String sql="insert into csv(s_no,timestamp,ver,product_family,country,device_type,os,checkout_failure_count,payment_api_failure_count,purchase_count,revenue) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        int count = 0;
        try{int id=0;
        while(csvrow.hasNext()){


            id++; //id column in database
            CsvModel csvDataModel = csvrow.next();
            pstmt.setInt(1,id);
            pstmt.setString(2, csvDataModel.getTimestamp());
            pstmt.setString(3, csvDataModel.getVer());
            pstmt.setString(4, csvDataModel.getProduct_family());
            pstmt.setString(5, csvDataModel.getCountry());
            pstmt.setString(6, csvDataModel.getDevice_type());
            pstmt.setString(7, csvDataModel.getOs());
            pstmt.setString(8, csvDataModel.getCheckout_failure_count());
            pstmt.setString(9,csvDataModel.getPayment_api_failure_count());
            pstmt.setString(10, csvDataModel.getPurchase_count());
            pstmt.setString(11,csvDataModel.getRevenue());
            pstmt.executeUpdate(); //inserting data into database
            count++;
        }

            System.out.println("Initialization: " +count+" row is inserted into database");
        sync();
    }catch(Exception e){
            System.out.println("Data from csv is already inserted to database running sync Service wait :"+e);
        }}


    //Scheduler function
    public static void sync(){
        try {
            int MINUTES = 2; // The delay in minutes
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() { // Function runs every MINUTES minutes.
                    // Run the code you want here
                    try {
                        System.out.println("Sync Started : ");

                            syncdata();

                        System.out.println("Synced");

                    } catch (Exception ex) {
                        System.out.println("hello there"+ex);
                    }
//                           CLASSB.funcb(); // If the function you wanted was static
                }
            }, 0, 1000 * 60 * MINUTES);

        } catch (Exception exception) {
            System.out.println(exception);
        }



    }


//compare data of database with CSV data
        public static void syncdata() throws Exception {
            try {
                Reader reader = new FileReader(filepath);
                CsvToBean bean = new CsvToBeanBuilder(reader).withType(CsvModel.class).withIgnoreLeadingWhiteSpace(true).build();
                Iterator<CsvModel> table = bean.iterator();
                connection = DriverManager.getConnection(jdbcurl, user, password);

                Statement stmt = connection.createStatement();
                ResultSet ResultCount = stmt.executeQuery("SELECT count(*) FROM csv");
                ResultCount.next();
                int counts;
                counts = ResultCount.getInt(1);
                int temp=counts;
                ResultSet rs = stmt.executeQuery("SELECT * FROM csv");


                while(table.hasNext()){

                    CsvModel row = table.next();
                    if(row==null){
                        //this is the case where Database has more row than csvfile.
                    }
                    if(counts==0){//this is the case where tha data is added at the end of CSV FILE
                        String sql="insert into csv(s_no,timestamp,ver,product_family,country,device_type,os,checkout_failure_count,payment_api_failure_count,purchase_count,revenue) values(?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement pstmt = connection.prepareStatement(sql,
                                Statement.RETURN_GENERATED_KEYS);
                        System.out.println("new row found at"+temp+" of CSV inserting");
                        pstmt.setInt(1,++temp);
                        assert row != null;
                        pstmt.setString(2, row.getTimestamp());
                        pstmt.setString(3, row.getVer());
                        pstmt.setString(4, row.getProduct_family());
                        pstmt.setString(5, row.getCountry());
                        pstmt.setString(6, row.getDevice_type());
                        pstmt.setString(7, row.getOs());
                        pstmt.setString(8, row.getCheckout_failure_count());
                        pstmt.setString(9, row.getPayment_api_failure_count());
                        pstmt.setString(10,row.getPurchase_count());
                        pstmt.setString(11,row.getRevenue());
                        pstmt.executeUpdate();
                        System.out.println("inserted");
                    }

                    if(counts>0){ counts--;}


                    }reader.close();




            }

           catch (Exception e){
                System.out.println(e);
            }






        }

    }

