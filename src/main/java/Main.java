
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Pong;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
     static Instant lastTime =  Instant.now();
    static String dbName = "fin_monitoring";
    static InfluxDB influxDB = InfluxDBFactory.connect("http://10.65.36.25:8086");

    public  static void main(String[] args){


        Pong pong = influxDB.ping();
        if (pong.getVersion().equalsIgnoreCase("unknown")) {
           CustomLogger.formatText("Error pinging server.", CustomLogger.ANSI_RED);
            return;
        }
        influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
        influxDB.setDatabase(dbName);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(queryFinancial, 0, 1, TimeUnit.SECONDS);
    }

    static Runnable queryFinancial = () -> {
        final Query query = new Query(" SELECT * FROM series1 ORDER BY desc LIMIT 1 ", dbName);
        final QueryResult queryResult = influxDB.query(query);
        InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
        Response response = resultMapper
                .toPOJO(queryResult, Response.class).get(0);
        CustomLogger.formatText("Last time is :  --> "+lastTime, CustomLogger.ANSI_BLUE);
        CustomLogger.formatText("current time is :  --> "+response.getTime(), CustomLogger.ANSI_YELLOW);

        if(lastTime.isBefore(response.getTime())  ){
            myLogger(response);
            lastTime = response.getTime();
        }
    };

    static void myLogger( Response response){

            switch(response.getResponseCode()){
                case "00":
                    CustomLogger.format(response, CustomLogger.ANSI_GREEN);
                    break;
                case "55":
                    CustomLogger.format(response, CustomLogger.ANSI_PURPLE);
                    break;
                case "91":
                    CustomLogger.format(response, CustomLogger.ANSI_RED);
                    break;
                case "96":
                    CustomLogger.format(response, CustomLogger.ANSI_CYAN);
                    break;
                default:
                    CustomLogger.format(response, CustomLogger.ANSI_YELLOW);
                    break;
            }

    }
}
