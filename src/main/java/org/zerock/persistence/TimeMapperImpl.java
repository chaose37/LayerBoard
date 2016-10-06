package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.log4j.spi.LoggerFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TimeMapperImpl implements TimeMapper {

	@Inject
	private SqlSessionTemplate session;
	
	private final static String NAMESPACE ="org.zerock.persistence.TimeMapper";
	
	@Override
	public String getTime() throws RuntimeException {
		return session.selectOne(NAMESPACE+".getTime");
	}

}
