package de.exentra.codeimpact.engine;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.flowable.cmmn.engine.CmmnEngine;
import org.flowable.cmmn.engine.CmmnEngineConfiguration;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.Startup;

@Singleton
public class CustomFlowableEngineConfiguration
{
	private static final Logger log = LoggerFactory.getLogger(CustomFlowableEngineConfiguration.class);

	@ConfigProperty(name = "app.engine.postgres.user")
	String postgresUser;

	@ConfigProperty(name = "app.engine.postgres.password")
	String postgresPassword;

	@ConfigProperty(name = "app.engine.postgres.url")
	String postgresUrl;

	@Produces
	@Startup
	@ApplicationScoped
	public ProcessEngine configureProcessEngine()
	{
		log.info("Setting up flowable process engine...");

		ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
			.setJdbcUrl(postgresUrl)
			.setJdbcUsername(postgresUser)
			.setJdbcPassword(postgresPassword)
			.setJdbcDriver("org.postgresql.Driver")
				.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

		return cfg.buildProcessEngine();
	}

	@Produces
	@Startup
	@ApplicationScoped
	public CmmnEngine configureCmmnEngine()
	{
		log.info("Setting up flowable cmmn engine");

		CmmnEngineConfiguration cfg = (CmmnEngineConfiguration)CmmnEngineConfiguration.createStandaloneInMemCmmnEngineConfiguration()
			.setJdbcUrl(postgresUrl)
			.setJdbcUsername(postgresUser)
			.setJdbcPassword(postgresPassword)
			.setJdbcDriver("org.postgresql.Driver")
			.setDatabaseSchemaUpdate(CmmnEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

		return cfg.buildCmmnEngine();
	}
}
