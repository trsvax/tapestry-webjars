Core Tapestry Webjars Module

Webjars are Javascript modules packages as jar files so they can easily be added as dependencies to Java projects. A large set of them are also usable with require.js making them perfect for inclusion in Tapestry projects when Javascript is needed. All that need to access them is one and only one contribution to the ClasspathAssetAliasManager.

To make that happen this module does one thing and one thing only it makes that contribution. This allows multiple modules to use webjars but only add the alias to the Tapestry IOC configuration once. If every module that uses webjars tries to add the alias then difficult to fix startup errors will happen.

The following steps are needed to create a module that uses webjars:

Step one is to add the following to the pom file.

<dependency>
    <groupId>com.trsvax</groupId>
    <artifactId>tapestry-webjars-core</artifactId>
    <version>1.0.0</version>
</dependency> 

and one for the webjar

<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>bootstrap-datetimepicker</artifactId>
    <version>2.3.5</version>
</dependency>

Next is the configuration need to make the Javascript a module

    @Contribute(ModuleManager.class)
public static void setupBaseModules(MappedConfiguration<String, Object> configuration,
	@Path("/META-INF/resourses/webjars/bootstrap-datetimepicker/2.3.5/js/bootstrap-datetimepicker.js")
	Resource datetimepicker) {
		configuration.add("webjars/datetimepicker", new JavaScriptModuleConfiguration(datetimepicker));
	
	}
	
Many newer modules support configuration/initialization thru data- attributes. If that's the case then nothing else is required.

