package io.github.xyz.boot.core.mysql.config;


import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhaoyunxing
 * @date: 2018-11-30 20:53
 * @des:
 */
public class AppDubboCoreConfig implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{AppDataSourceConfig.class.getName(), AppMyBatisConfig.class.getName()};
    }
}
