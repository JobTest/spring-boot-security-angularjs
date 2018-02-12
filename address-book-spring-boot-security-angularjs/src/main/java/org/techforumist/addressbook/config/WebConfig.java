package org.techforumist.addressbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.techforumist.addressbook.service.AppUserDetailsService;

@Configurable
@EnableWebSecurity
// Изменение или переопределение по умолчанию для 'spring boot security'
public class WebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    AppUserDetailsService appUserDetailsService;

	// Этот метод предназначен для переопределения по умолчанию для 'AuthenticationManagerBuilder'
	// Здесь можна указать, как хранить данные 'user details' в приложении (это может быть в: 'database', 'LDAP', 'in memory')
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService);
	}

	// Этот метод предназначен для переопределения конфигурации 'WebSecurity'
	// Если вы хотите игнорировать шаблоны запросов - это можно указать внутри этого метода
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	// Этот метод используется для переопределения HttpSecurity в веб-приложении.
	// Здесь можно указать критерии для авторизации
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests() // (начинаем конфигурацию авторизации) игнорируем "/", "/index.html", "/app/**", "/register", "/favicon.ico"
				.antMatchers("/", "/index.html", "/app/**", "/register", "/favicon.ico").permitAll()
				.anyRequest().fullyAuthenticated().and() // аутентифицировать все остальные URL-адреса
				.httpBasic().and() // включение базовой аутентификации
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // настройка минимального состояния сесии (это означает что на сервере отсутствуют сессии)
				.csrf().disable(); // отключение CSRF (для межсайтовый запросов)
	}

}
