package org.bruwave.redline.portal.web

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = ["org.bruwave.redline.portal.web"])
class WebContentConfiguration
