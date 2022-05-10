package com.example.dynamictabexample;

import java.util.List;

public class Model {

    private String name;
    private List<Model> child;

    public Model(String name, List<Model> child) {
        this.name = name;
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public List<Model> getChild() {
        return child;
    }
}
