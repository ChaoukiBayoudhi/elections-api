package tn.esb.lbc.electionsapi.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esb.lbc.electionsapi.Domain.Activity;
import tn.esb.lbc.electionsapi.Repository.ActivityRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional //les méthodes de ce services fonctionnront sous le principe de transaction
//pour un SGBD : une transaction est une suite de requetes qui peut être soit validées (commit)
//ou annulées (rolback)
//une transaction verifie la propriété ACID

public class ActivityService {
    //une instance coté serveur est equivalente à un bean

    private final ActivityRepository activityRepos;
    private final Logger log = LoggerFactory.getLogger(ActivityService.class);

    @Autowired
    public ActivityService(ActivityRepository activityRepos) {
        this.activityRepos = activityRepos;
    }

    public List<Activity> getAllActivities()
    {
        return activityRepos.findAll();
    }
    public ResponseEntity<Activity> addActivity(Activity A){
        //prints activities titles on Activity repository that are like the activity A
//        activityRepos.findAll().stream() //conversion from List to Stream
//                .filter(x->x.getTitle().equalsIgnoreCase(A.getTitle())&&x.getActivityDate().isEqual(A.getActivityDate())&&x.getPlace().equalsIgnoreCase(A.getPlace()))
//                //for localdate comparation we have ld1.isBefore(ld2) and ld1.isAffter(ld2)
//                .map(x->x.getTitle())
//                .forEach(System.out::println);// this example shows title activities having the same title, activity date and place as the activity A


        List<Activity> lst=activityRepos.findAll().stream()
                .filter(x->x.getTitle().equalsIgnoreCase(A.getTitle())&&x.getActivityDate().isEqual(A.getActivityDate())&&x.getPlace().equalsIgnoreCase(A.getPlace()))
                .collect(Collectors.toList());//conversion from Stream to List
        if (!lst.isEmpty())
            return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
        log.debug("Request to create Activity : {}", A);
        return new ResponseEntity(activityRepos.save(A),HttpStatus.CREATED);
    }
    @Transactional(readOnly = true)
    public Optional<Activity> getActivityById(Long id)
    {
        return activityRepos.findById(id);
    }

    public void deleteActivity(Long id){
        activityRepos.deleteById(id);
    }
    public ResponseEntity<Activity> modifyActivity(Long id, Activity newActivity)
    {
        Optional<Activity> res=activityRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Activity A1=res.get();
        A1.setId(newActivity.getId());
        A1.setTitle(newActivity.getTitle());
        A1.setPlace(newActivity.getPlace());
        A1.setActivityDate(newActivity.getActivityDate());
        A1.setDuration(newActivity.getDuration());

        activityRepos.save(A1);
        return new ResponseEntity<Activity>(A1,HttpStatus.OK);
    }
}
