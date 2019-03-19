/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.core.web.config;

import io.github.xyz.boot.core.web.config.adapter.AppGlobalWebMvcConfigurerAdapter;
import io.github.xyz.boot.core.web.config.handler.AppGlobalExceptionHandler;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhaoyunxing
 * @date: 2019-03-19 20:37
 * @des:
 */
public class ApiCoreConfig implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{AppGlobalWebMvcConfigurerAdapter.class.getName(), AppGlobalExceptionHandler.class.getName()};
    }
}
