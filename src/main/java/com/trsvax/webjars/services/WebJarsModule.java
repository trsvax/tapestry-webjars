package com.trsvax.webjars.services;

import org.apache.tapestry5.ioc.MappedConfiguration;

public class WebJarsModule {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void contributeClasspathAssetAliasManager( MappedConfiguration configuration) {
        configuration.add("webjars", "META-INF/resources/webjars");
    }

}
