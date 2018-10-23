package com.xiaochuan.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/21 15:10
 */
@ConfigurationProperties("trace.static")
@Validated
@Data
public class QualityReportProperties {
    @NotNull
    private String upload;
}
