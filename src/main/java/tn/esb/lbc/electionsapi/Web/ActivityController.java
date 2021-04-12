package tn.esb.lbc.electionsapi.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.esb.lbc.electionsapi.Services.ActivityService;

@Controller
public class ActivityController {

    private ActivityService activityServ;
    @Autowired
    public ActivityController(ActivityService activityServ) {
        this.activityServ = activityServ;
    }
}
