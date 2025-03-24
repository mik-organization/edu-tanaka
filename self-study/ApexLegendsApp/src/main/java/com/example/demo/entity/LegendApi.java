package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LegendApi {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String name;
  private String realName;
  private Integer age;
  private String ageNote;
  private String gender;
  private String legendClass;
  private String abilities;
  private String abiDescription;
  private String passive;
  private String pasDescripition;
  private String ult;
  private String ultDescripition;
  private String words;
  private String picturePath;
  private Integer sortIndex;
}
