package org.crazyit.app.bidirectional.oneN.joinTable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Description: <br/>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> <br/>
 * Copyright (C), 2001-2016, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@Entity
@Table(name = "person_inf")
@Getter@Setter
public class Person {
	// 标识属性
	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int age;
	// 定义该Person实体所有关联的Address实体
	 @OneToMany(targetEntity=Address.class ,mappedBy="person")
	/*@OneToMany(targetEntity = Address.class)
	// 映射连接表，指定连接表为person_address
	@JoinTable(name = "person_address",
			// 指定连接表中person_id列参照当前实体对应数据表的person_id主键列
			joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"),
			// 指定连接表中address_id列参照当前实体的关联实体对应数据表的address_id主键列
			inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "address_id", unique = true))*/
	private Set<Address> addresses = new HashSet<>();

}