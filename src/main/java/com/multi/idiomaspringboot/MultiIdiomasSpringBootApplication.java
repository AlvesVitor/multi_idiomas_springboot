package com.multi.idiomaspringboot;

import com.transferwise.icu.ICUMessageSource;
import com.transferwise.icu.ICUReloadableResourceBundleMessageSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@SpringBootApplication
public class MultiIdiomasSpringBootApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(MultiIdiomasSpringBootApplication.class, args);

	}

	public static void testResourceBundleMessageSourceFunctionality() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("lang/res");

		System.out.println(messageSource.getMessage("template", null, Locale.US));
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(null);

		return localeResolver;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();

		localeChangeInterceptor.setParamName("localeData");
		return localeChangeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public ICUMessageSource messageSource() {
		ICUReloadableResourceBundleMessageSource messageSource = new ICUReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:lang/res");

		return messageSource;
	}
}
