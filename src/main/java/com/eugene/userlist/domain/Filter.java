package com.eugene.userlist.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Filter {
	String email;
	LocalDate dateFrom;
	LocalDate dateTo;
	
	public Filter(){
		dateFrom = LocalDate.MIN;
		dateTo = LocalDate.MAX;
	}
}
