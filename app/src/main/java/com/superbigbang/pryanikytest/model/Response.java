package com.superbigbang.pryanikytest.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private List<Data> data;
    private List<String> view;
}