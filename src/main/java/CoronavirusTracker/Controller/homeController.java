package CoronavirusTracker.Controller;

import CoronavirusTracker.Data;
import CoronavirusTracker.FetchDataCoronavirus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class homeController {

    @Autowired
    FetchDataCoronavirus FetchDataCoronavirus;

    @RequestMapping("/")
    public String Home(Model model){
    model.addAttribute("Data",FetchDataCoronavirus.getOldData());
        //System.out.println("YOU ARE IN CONTROLLER CLASS");
        List<Data> oldData = FetchDataCoronavirus.getOldData();
        int totalReportedCases = oldData.stream().mapToInt(stat -> stat.getConfirmed()).sum();
        int totalReportedDeaths = oldData.stream().mapToInt(stat -> stat.getDeaths()).sum();
        model.addAttribute("Data", oldData);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalReportedDeaths", totalReportedDeaths);
        return "Home";
    }

}


