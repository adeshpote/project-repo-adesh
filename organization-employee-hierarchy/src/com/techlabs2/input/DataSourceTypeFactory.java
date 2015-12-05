package com.techlabs2.input;


public class DataSourceTypeFactory {
	public static IEmployeeDataReader createFactory(DataSourceType type){
		if(type==DataSourceType.DBREADER){
			return new DBReader();
		}else if(type==DataSourceType.FILEREADER){
			return new FilesReader();
		}else 
			return null;
	}
}
