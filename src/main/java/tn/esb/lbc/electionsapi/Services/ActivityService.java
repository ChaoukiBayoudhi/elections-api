package tn.esb.lbc.electionsapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.esb.lbc.electionsapi.Domain.Activity;
import tn.esb.lbc.electionsapi.Repository.ActivityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    private ActivityRepository activityRepos;

    @Autowired
    public ActivityService(ActivityRepository activityRepos) {
        this.activityRepos = activityRepos;
    }

    public List<Activity> getAllActivities()
    {
        return activityRepos.findAll();
    }
}
