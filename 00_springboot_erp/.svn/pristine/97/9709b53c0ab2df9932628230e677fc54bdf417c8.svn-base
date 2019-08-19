package com.gxz.sys.utils;

import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Utils {

	public static String createRandomStr() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	public static String md5(String resources,Object salt,Integer hashIterations) {
		return new Md5Hash(resources, salt, hashIterations).toString();
	}
}
