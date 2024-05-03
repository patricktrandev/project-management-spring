package com.blackcoffee.pma.utils;

import java.util.HashMap;
import java.util.Map;

public class ProjectStages {
    public Map<String, String> stages;

    public ProjectStages(){
        this.stages=new HashMap<>();
        this.stages.put("NOTSTARTED","NOT STARTED");
        this.stages.put("COMPLETED","COMPLETED");
        this.stages.put("INPROGRESS","IN PROGRESS");
    }

    public Map<String, String> getStages() {
        return stages;
    }

    public void setStages(Map<String, String> stages) {
        this.stages = stages;
    }
}
