package CoronavirusTracker;

public class Data {

    private String Province_State;
    private String Country_Region;
    private int Confirmed;
    private int Deaths;
    private String Recovered;

    public String getRecovered() { return Recovered; }

    public void setRecovered(String recovered) {
        Recovered = recovered;
    }

    public String getProvince_State() {
        return Province_State;
    }

    public void setProvince_State(String province_State) {
        Province_State = province_State;
    }

    public String getCountry_Region() {
        return Country_Region;
    }

    public void setCountry_Region(String country_Region) {
        Country_Region = country_Region;
    }

    public int getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(int confirmed) {
        Confirmed = confirmed;
    }

    public int getDeaths() {
        return Deaths;
    }

    public void setDeaths(int deaths) {
        Deaths = deaths;
    }



    @Override
    public String toString() {
        return "Data{" +
                "Country_Region='" + Country_Region + '\'' +
                '}';
    }
}
