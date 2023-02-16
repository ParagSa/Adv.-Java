package com.jobportal.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity
@Table(name = "skill_Data")
public class SkillData {

	/* @EmbeddedId */
	private SkillDataPKCID skillPrimKey;
	
	public SkillDataPKCID getSkillPrimKey() {
		return skillPrimKey;
	}

	public void setSkillPrimKey(SkillDataPKCID skillPrimKey) {
		this.skillPrimKey = skillPrimKey;
	}

	private int totalJobsDone;
	
	private float ratings;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
		
}
