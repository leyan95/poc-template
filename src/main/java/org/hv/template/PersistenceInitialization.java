package org.hv.template;

import org.hv.pocket.exception.MapperException;
import org.hv.pocket.lunch.PocketConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author wujianchuan 2020/7/15 14:17
 */
@Component
public class PersistenceInitialization {
    @Resource
    private PocketConfig pocketConfig;

    @PostConstruct
    public void init() throws MapperException {
        pocketConfig.init();
    }
}
