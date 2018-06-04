package org.csource.autoconfig;

import org.csource.fastdfs.TrackerGroup;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author yichen
 * @description
 * @date 2018/6/4
 **/
@ConfigurationProperties(prefix = FastDFSProperties.FASTDFS_PREFIX)
public class FastDFSProperties {

    public static final String FASTDFS_PREFIX = "fdfs";

    private static final int DEFAULT_CONNECT_TIMEOUT = 5; //second
    private static final int DEFAULT_NETWORK_TIMEOUT = 30; //second
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final boolean DEFAULT_HTTP_ANTI_STEAL_TOKEN = false;
    private static final String DEFAULT_HTTP_SECRET_KEY = "FastDFS1234567890";
    private static final int DEFAULT_HTTP_TRACKER_HTTP_PORT = 80;

    private int connectTimeout = DEFAULT_CONNECT_TIMEOUT * 1000; //millisecond
    private int networkTimeout = DEFAULT_NETWORK_TIMEOUT * 1000; //millisecond
    private String charset = DEFAULT_CHARSET;
    private boolean antiStealToken = DEFAULT_HTTP_ANTI_STEAL_TOKEN; //if anti-steal token
    private String secretKey = DEFAULT_HTTP_SECRET_KEY; //generage token secret key
    private int trackerHttpPort = DEFAULT_HTTP_TRACKER_HTTP_PORT;
    @NestedConfigurationProperty
    private TrackerGroup trackerGroup;

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getNetworkTimeout() {
        return networkTimeout;
    }

    public void setNetworkTimeout(int networkTimeout) {
        this.networkTimeout = networkTimeout;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public boolean isAntiStealToken() {
        return antiStealToken;
    }

    public void setAntiStealToken(boolean antiStealToken) {
        this.antiStealToken = antiStealToken;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public int getTrackerHttpPort() {
        return trackerHttpPort;
    }

    public void setTrackerHttpPort(int trackerHttpPort) {
        this.trackerHttpPort = trackerHttpPort;
    }

    public TrackerGroup getTrackerGroup() {
        return trackerGroup;
    }

    public void setTrackerGroup(TrackerGroup trackerGroup) {
        this.trackerGroup = trackerGroup;
    }
}
