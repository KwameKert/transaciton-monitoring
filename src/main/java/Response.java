import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.time.Instant;

@Measurement(name = "financial")
public class Response {

    @Column(name = "time")
    private Instant time;
    @Column(name = "ACCOUNT_ID_2")
    String account;
    @Column(name = "BIN_tag")
    String bin;
    @Column(name = "AMOUNT_APP")
    String amount;
    @Column(name = "PAN")
    String pan;
    @Column(name = "SRC_NODE")
    String sourceNode;
    @Column(name = "SINK_NODE")
    String sinNode;
    @Column(name = "RSP_CODE_REQ")
    String responseCode;


    public Response() {
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(String sourceNode) {
        this.sourceNode = sourceNode;
    }

    public String getSinNode() {
        return sinNode;
    }

    public void setSinNode(String sinNode) {
        this.sinNode = sinNode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String toString() {
        return "Response{" +
                "time=" + time +
                ", account='" + account + '\'' +
                ", bin='" + bin + '\'' +
                ", amount='" + amount + '\'' +
                ", pan='" + pan + '\'' +
                ", sourceNode='" + sourceNode + '\'' +
                ", sinNode='" + sinNode + '\'' +
                '}';
    }


}
