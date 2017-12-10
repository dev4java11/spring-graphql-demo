package com.spring.graphql.demo1.transformer;

import java.util.List;

import com.spring.graphql.demo1.util.ApplicationUtil;
import com.spring.graphql.demo1.util.ValidationUtil;

public abstract class AbstractTransformer <Source, Target> implements Transformer<Source, Target> {
	
	protected abstract Target transformSource(Source source);
	
	protected abstract Source transformTarget(Target target);

	@Override
	public Target transformToTarget(Source source){
		if(ValidationUtil.isNull(source)){
			return null;
		}
		Target target = transformSource(source);
		return target;
	}
	
	@Override
	public Source transformToSource(Target target){
		if(ValidationUtil.isNull(target)){
			return null;
		}
		Source source = transformTarget(target);
		return source;
	}
	

	@Override
	public List<Target> transformToTarget(List<Source> sources) {
		List<Target> targets = ApplicationUtil.getNewArrayList();
		if(ValidationUtil.isNotEmpty(sources)){
			for(Source source : sources){
				Target target = transformToTarget(source);
				if(ValidationUtil.isNotNull(target)){
					targets.add(target);
				}
			}
		}
		return targets;
	}
	
	@Override
	public List<Source> transformToSource(List<Target> targets) {
		List<Source> sources = ApplicationUtil.getNewArrayList();
		if(ValidationUtil.isNotEmpty(targets)){
			for(Target target : targets){
				Source source = transformToSource(target);
				if(ValidationUtil.isNotNull(target)){
					sources.add(source);
				}
			}
		}
		return sources;
	}

}
