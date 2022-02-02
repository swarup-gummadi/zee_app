package com.zee.zee5app.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomNamingStrategy extends PhysicalNamingStrategyStandardImpl {

	private final static String POSTFIX = "_table";
	//by default all the tables should end with name _table
	@Override
	public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment context) {
		// TODO Auto-generated method stub
		if(identifier==null) {
			return null;
		}
		final String newName = identifier.getText()+POSTFIX;
				//1. if @table annotation is available then it uses that name
				//2. if @table annotation is not there then it uses entity name, if that also not there then default
				// takes class name as entity name
		return identifier.toIdentifier(newName);
	}
}
