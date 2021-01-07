package com.mayfarm.vo;

import lombok.Data;

@Data
public class SearchCriteria extends Criteria{
	
	private String searchType = "";
	private String keyword = "";

	@Override
	public String toString() {
		return "searchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
}
