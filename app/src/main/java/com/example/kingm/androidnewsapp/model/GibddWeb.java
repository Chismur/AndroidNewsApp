package com.example.kingm.androidnewsapp.model;

import java.util.List;

/**
 * Created by kingm on 07.02.2018.
 */

public class GibddWeb {
    private Long id;
    private List<GibddSource> gibddSources;

    public GibddWeb(Long id, List<GibddSource> gibddSources) {
        this.id = id;
        this.gibddSources = gibddSources;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GibddSource> getGibddSources() {
        return gibddSources;
    }

    public void setGibddSources(List<GibddSource> gibddSources) {
        this.gibddSources = gibddSources;
    }
}
