package com.jobportal.model;

import java.io.Serializable;

public class SkillDataPKCID implements Serializable{

	private int user_id;
	
	private String SkillId;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getSkillId() {
		return SkillId;
	}

	public void setSkillId(String skillId) {
		SkillId = skillId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SkillId == null) ? 0 : SkillId.hashCode());
		result = prime * result + user_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillDataPKCID other = (SkillDataPKCID) obj;
		if (SkillId == null) {
			if (other.SkillId != null)
				return false;
		} else if (!SkillId.equals(other.SkillId))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	
	
	
}
