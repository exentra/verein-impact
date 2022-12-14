package de.exentra.codeimpact.engine;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.ws.rs.Produces;

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

	@Produces
	@Startup
	@ApplicationScoped
	public ProcessEngine configureProcessEngine()
	{
		log.info("Setting up flowable process engine...");

		ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
				.setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
				.setJdbcUsername("sa")
				.setJdbcPassword("")
				.setJdbcDriver("org.h2.Driver")
				.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

		return cfg.buildProcessEngine();
	}
}
