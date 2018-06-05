package org.csource.autoconfig;

import org.apache.log4j.Logger;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.StructGroupStat;
import org.csource.fastdfs.StructStorageStat;
import org.csource.fastdfs.TrackerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yichen
 * @description
 * @date 2018/6/4
 **/
@Configuration
@EnableConfigurationProperties(FastDFSProperties.class)
@ConditionalOnClass({TrackerClient.class})
public class FastDFSAutoConfiguration {

    private static final Logger logger = Logger.getLogger(FastDFSAutoConfiguration.class);

    @Autowired
    private FastDFSProperties fastDFSProperties;

    @Bean
    @ConditionalOnMissingBean({TrackerClient.class})
    public TrackerClient trackerClient(){
        logger.info("start connect fastdfs server!");
        ProtoCommon.properties = fastDFSProperties;
        StructGroupStat.setProperties(fastDFSProperties);
        StructStorageStat.setProperties(fastDFSProperties);
        return new TrackerClient(fastDFSProperties);
    }

}
