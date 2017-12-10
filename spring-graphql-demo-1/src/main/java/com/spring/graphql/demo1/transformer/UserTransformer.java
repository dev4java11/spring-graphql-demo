package com.spring.graphql.demo1.transformer;

import org.springframework.stereotype.Component;

import com.spring.graphql.demo1.domain.User;
import com.spring.graphql.demo1.model.MUser;
import com.spring.graphql.demo1.util.ApplicationUtil;

@Component
public class UserTransformer extends AbstractTransformer<User, MUser> {

	@Override
	protected MUser transformSource(User source) {
		MUser target = new MUser();
		target.setUuid(source.getUuid());
		target.setFullName(source.getFullName());
		target.setBirthday(ApplicationUtil.buildMDateWithFormatDate(source.getBirthday()));
		target.setNumberCard(source.getNumberCard());
		return target;
	}

	@Override
	protected User transformTarget(MUser target) {
		User source = new User();
		source.setUuid(target.getUuid());
		source.setFullName(target.getFullName());
		source.setBirthday(ApplicationUtil.buildDateFromMDate(target.getBirthday()));
		source.setNumberCard(target.getNumberCard());
		return source;
	}

	

}
