package com.hoopladigital.guice;

import com.google.inject.name.Names;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

public class SampleMyBatisModule extends MyBatisModule {

	@Override
	protected void initialize() {
		bindTransactionFactoryType(JdbcTransactionFactory.class);
		bindDataSourceProviderType(PooledDataSourceProvider.class);
		addMapperClasses("com.hoopladigital.mapper");
		addSimpleAliases("com.hoopladigital.bean");
		final String environment = System.getProperty("environment", "LOCAL");
		bindConstant().annotatedWith(Names.named("mybatis.environment.id")).to(environment);
		//I set this here to avoid having to declare types in my mappings. I don't like that it's varchar
		//but OTHER and NULL both failed without the type declarations.
		bindConfigurationSetting(configuration -> configuration.setJdbcTypeForNull(JdbcType.VARCHAR));
	}

}
