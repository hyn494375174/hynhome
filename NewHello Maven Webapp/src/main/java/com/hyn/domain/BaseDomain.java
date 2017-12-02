package com.hyn.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * @author hyn
 *
 */

public class BaseDomain implements Serializable{
	/**
	 * 重新toString方法，使用StringBuilder代替String构建字符串变量
	 */
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
		
	}
}
