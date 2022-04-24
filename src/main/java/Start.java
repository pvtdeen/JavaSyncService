import java.io.IOException;

//class with main function
public class Start {
    public static void main(String[] args){

               new WriteData(); //Object of WriteDATA class
                try {
                    WriteData.main();  //calling main function of write data class
                } catch (IOException e) {
                    e.printStackTrace();
                }


                new JavaSyncService();
                try {
                    JavaSyncService.main(); //sync service
                } catch (Exception exception) {
                    exception.printStackTrace();

                }

    }
}
