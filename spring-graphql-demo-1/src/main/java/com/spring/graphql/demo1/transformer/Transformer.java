package com.spring.graphql.demo1.transformer;

import java.util.List;

public interface Transformer <Source, Target> {

	public Target transformToTarget(Source source);
	
	public Source transformToSource(Target target);
	
	public List<Target> transformToTarget(List<Source> sources);
	
	public List<Source> transformToSource(List<Target> targets);
}
