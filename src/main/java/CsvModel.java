import com.opencsv.bean.CsvBindByName;

public class CsvModel {
        //Data Colums till line 34
    @CsvBindByName(column = "timestamp")
    private String timestamp;

    @CsvBindByName(column ="ver",required = true)
    private String ver;

    @CsvBindByName(column = "product_family",required = true)
    private String product_family;

    @CsvBindByName(column = "country" ,required = true)
    private String country;

    @CsvBindByName(column = "device_type"  ,required = true)
    private String device_type;

    @CsvBindByName(column="os"  ,required = true)
    private String os;

    @CsvBindByName(column = "checkout_failure_count"  ,required = true)
    private String checkout_failure_count;

    @CsvBindByName(column = "payment_api_failure_count"  ,required = true)
    private String payment_api_failure_count;

    @CsvBindByName(column="purchase_count"  ,required = true)
    private String purchase_count;

    @CsvBindByName(column = "revenue"  ,required = true)
    private String revenue;


    //Setters And Getters till line 115
    public  String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getProduct_family() {
        return product_family;
    }

    public void setProduct_family(String product_family) {
        this.product_family = product_family;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCheckout_failure_count() {
        return checkout_failure_count;
    }

    public void setCheckout_failure_count(String checkout_failure_count) {
        this.checkout_failure_count = checkout_failure_count;
    }

    public String getPayment_api_failure_count() {
        return payment_api_failure_count;
    }

    public void setPayment_api_failure_count(String payment_api_failure_count) {
        this.payment_api_failure_count = payment_api_failure_count;
    }

    public String getPurchase_count() {
        return purchase_count;
    }

    public void setPurchase_count(String purchase_count) {
        this.purchase_count = purchase_count;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }



    // to string method
    @Override
    public String toString() {
        return "Csv{" +
                "timestamp='" + timestamp + '\'' +
                ", ver='" + ver + '\'' +
                ", product_family='" + product_family + '\'' +
                ", country='" + country + '\'' +
                ", device_type='" + device_type + '\'' +
                ", os='" + os + '\'' +
                ", checkout_failure_count='" + checkout_failure_count + '\'' +
                ", payment_api_failure_count='" + payment_api_failure_count + '\'' +
                ", purchase_count='" + purchase_count + '\'' +
                ", revenue='" + revenue + '\'' +
                '}';
    }
    public CsvModel(){}
}
