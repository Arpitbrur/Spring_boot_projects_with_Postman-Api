package com.qsp.springbootonetoonebi3pm.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Record {
	
	@Column(name="recordId")
	@Id
	private int recordId;
	@Column(name="recordRuns")
    private long recordRun;
	@Column(name="recordMatches")
    private int recordMatch;
	@Column(name="recordHundreds")
    private int recordHundred;
	
	@OneToOne(mappedBy = "record", cascade = CascadeType.ALL)
	@JsonBackReference
	private Cricketers cricketers;

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public long getRecordRun() {
		return recordRun;
	}

	public void setRecordRun(long recordRun) {
		this.recordRun = recordRun;
	}

	public int getRecordMatch() {
		return recordMatch;
	}

	public void setRecordMatch(int recordMatch) {
		this.recordMatch = recordMatch;
	}

	public int getRecordHundred() {
		return recordHundred;
	}

	public void setRecordHundred(int recordHundred) {
		this.recordHundred = recordHundred;
	}

	public Cricketers getCricketers() {
		return cricketers;
	}

	public void setCricketers(Cricketers cricketers) {
		this.cricketers = cricketers;
	}
	
}
