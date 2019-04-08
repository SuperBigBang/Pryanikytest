package com.superbigbang.pryanikytest.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InSightData{
   private String text;
   private String url;
 private int selectedId;
 private List<Variants> variants;
}
