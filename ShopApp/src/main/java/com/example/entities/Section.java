package com.example.entities;

import java.util.List;

import com.example.model.SectionMaster;

public class Section {
	private String section;
	
	
	private List<SectionMaster> sectionByClass;
	
	

	public List<SectionMaster> getSectionByClass() {
		return sectionByClass;
	}

	public void setSectionByClass(List<SectionMaster> sectionByClass) {
		this.sectionByClass = sectionByClass;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	
	

}
