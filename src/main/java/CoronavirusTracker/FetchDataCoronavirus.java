package CoronavirusTracker;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Service
public class FetchDataCoronavirus {


    private String PATH="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/b3262a11b6915e4ed2cd7b9563324fcb8a0d6a85/csse_covid_19_data/csse_covid_19_daily_reports_us/07-22-2020.csv";
    private List<Data> oldData = new ArrayList<>();

    public List<Data> getOldData() {
        return oldData;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void FetchData() throws Exception {

        List<Data> newData = new ArrayList<>();
        URI uri = new URI(PATH);
        URL url = uri.toURL();
        System.out.println(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
          Data Data = new Data();
          Data.setProvince_State(record.get("Province_State"));
            Data.setCountry_Region(record.get("Country_Region"));
            Data.setConfirmed(Integer.parseInt(record.get("Confirmed")));
            Data.setDeaths(Integer.parseInt(record.get("Deaths")));
            Data.setRecovered(record.get("Recovered"));
           //System.out.println(Data);
            newData.add(Data);
        }

        this.oldData=newData;

    }

}