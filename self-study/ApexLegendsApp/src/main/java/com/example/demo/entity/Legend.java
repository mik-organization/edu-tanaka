package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * レジェンドマスタの情報を表すエンティティ
 */
@Entity
@Table(name = "m_legend")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Legend {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

@Column(name="name", nullable=false)
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
  
  @Column(name="sort_index", nullable=false)
  private Integer sortIndex;
  
}
