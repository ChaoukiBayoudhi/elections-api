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
    public Activity addActivity(Activity A){
        log.debug("Request to create Activity : {}", A);
        return activityRepos.save(A);
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
        //...
        activityRepos.save(A1);
        return new ResponseEntity<Activity>(A1,HttpStatus.OK);
    }
}
