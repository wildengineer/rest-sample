package com.hoopladigital.test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.hoopladigital.derby.DerbyHelper;
import com.hoopladigital.guice.GuiceModule;
import com.hoopladigital.guice.SampleMyBatisModule;
import org.apache.derby.drda.NetworkServerControl;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.After;
import org.junit.Before;

public abstract class AbstractMapperTest extends AbstractTest {

	private static final Injector injector = Guice.createInjector(
			new GuiceModule(),
			new SampleMyBatisModule()
	);

	@Inject
	private DerbyHelper derbyHelper;
	@Inject
	private NetworkServerControl networkServerControl;

	@Inject
	private SqlSessionManager sqlSessionManager;

	@Before
	public void beforeAbstractMapperTest() throws Exception {
		injector.injectMembers(this);
		sqlSessionManager.startManagedSession();
		derbyHelper.init(true);
	}

	@After
	public void afterAbstractMapperTest() throws Exception {
		sqlSessionManager.rollback(true);
		sqlSessionManager.close();
		derbyHelper.destroy(networkServerControl);
	}

}
