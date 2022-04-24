import java.io.*;
import java.util.Scanner;

//this class is created to insert data into CSV file.


public class WriteData {

    public static void insertData(String p, Scanner s) throws IOException {
        if (p.charAt(0) == 'Y' || p.charAt(0) == 'y') {


            System.out.println("enter the new data");
            System.out.print("timestamp :");
            String timestamp = s.nextLine();
            System.out.print("ver : ");
            String ver = s.nextLine();
            System.out.print("Product Family : ");
            String product_family = s.nextLine();
            System.out.print("County : ");
            String country = s.nextLine();
            System.out.print("Device Type : ");
            String device_type = s.nextLine();
            System.out.print("Os : ");
            String os = s.nextLine();
            System.out.print("Check Out Failure Count : ");
            String checkout_failure_count = s.nextLine();
            System.out.print("Payment Api Failure Count : ");
            String payment_api_failure_count = s.nextLine();
            System.out.print("Purchase Count : ");
            String purchase_count = s.nextLine();
            System.out.print("Revenue : ");
            String revenue = s.nextLine();

            String[] newline = {};

            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println(timestamp + "," + ver + "," + product_family + "," + country + "," + device_type + "," + os + "," + checkout_failure_count + "," + payment_api_failure_count + "," + purchase_count + "," + revenue);
            printWriter.flush();
            printWriter.close();


            System.out.println("do you want to enter More");
            System.out.println("Y/N");
            String c = s.nextLine();


            if (c.charAt(0) == 'Y' || c.charAt(0) == 'y') {
                insertData(p, s);
            } else {
                System.out.println("Exit");
            }
        }

    }



    public static String filepath=".\\Assignment Sheet.csv";
    public static void main() throws IOException {
       try {
           System.out.println("do you want to update CSV");
           System.out.println("Y/N");
           Scanner s = new Scanner(System.in);
           String p=s.nextLine();
           insertData(p,s);

       }catch (Exception e){
           System.out.println(e);
       }
        }






}
