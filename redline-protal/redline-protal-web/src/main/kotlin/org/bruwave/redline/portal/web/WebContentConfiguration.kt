package org.bruwave.redline.portal.web

import org.bruwave.redline.commons.YamlPropertySourceFactory
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@Configuration
@EnableAutoConfiguration(exclude = [])
@ComponentScan(basePackages = ["org.bruwave.redline.portal.web"])
@PropertySource("classpath:application-web.yml", factory = YamlPropertySourceFactory::class)
class WebContentConfiguration
