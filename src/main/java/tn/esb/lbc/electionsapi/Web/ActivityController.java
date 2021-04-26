package tn.esb.lbc.electionsapi.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tn.esb.lbc.electionsapi.Domain.Activity;
import tn.esb.lbc.electionsapi.Services.ActivityService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static tn.esb.lbc.electionsapi.Commun.Web.API;


//@Controller c'est génerique et il est principalement utilisé avec le modèle MVC
//MVC  : Model View Controller
@RestController //specifique pour des données REST
@RequestMapping(API+"/activities")

public class ActivityController {

    private ActivityService activityServ;
    @Autowired
    public ActivityController(ActivityService activityServ) {
        this.activityServ = activityServ;
    }
    @GetMapping("/all")
    public List<Activity> getAll()
    {
        return activityServ.getAllActivities();
    }
    @PostMapping("/add")
    //or
    //@RequestMapping(value="/add", method = RequestMethod.POST)
    //RequestMapping peut jouer le role de GetMapping, PostMapping,...
    //La méthode par default de RequestMapping est GET
    public Activity addAnActivity(@RequestBody Activity A){
        return activityServ.addActivity(A);
    }
    @GetMapping("/{id}")
    public Optional<Activity> ActivityById(@PathVariable Long id)
    {
        return activityServ.getActivityById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteActivity(@PathVariable Long id)
    {
        activityServ.deleteActivity(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id, @RequestBody Activity A)
    {
        return activityServ.modifyActivity(id,A);
    }
}
