package org.demo.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

public class DemoUtil {
	private static final Logger LOG = Logger.getLogger(DemoUtil.class);
	public static String getHostname() {
        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
        	LOG.error("Cannot get host info", e);
        }
        return hostname;
    }
}
