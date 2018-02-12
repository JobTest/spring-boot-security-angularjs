
address-book-spring-boot-security-angularjs >> AddressBookSpringBootSecurityAngularjsApplication [port=8181]
```bash
netstat -na | find "81"
```
>> Login: admin | Password: admin
>> Login: user | Password: user


###address-book-spring-boot-security-angularjs

Пример веб-приложения адресной книги со Spring-Boot: безопасностью: JPA, H2 и AngularJS.
Обычная проверка подлинности, интегрированная с интерфейсом пользователя.

Учебники:
http://techforumist.com/address-book-application-spring-boot-basic-authentication-1/
http://techforumist.com/address-book-application-spring-boot-basic-authentication-2/

Демо-версия приложения: 
https://www.youtube.com/watch?v=HvtBKO_LIg0&t=25s

||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

[Конвертация Java объектов в JSON](https://devcolibri.com/конвертация-java-объектов-в-json) **(** [Как сделать так, чтобы Jackson игнорировал @JsonIgnore в некоторых случаях](https://ru.stackoverflow.com/questions/723899/Как-сделать-так-чтобы-jackson-игнорировал-jsonignore-в-некоторых-случаях) **)**
[Latest Jackson integration improvements in Spring](https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in-spring)
[Какая разница между @Secured и @PreAuthorize в spring безопасности](http://qaru.site/questions/54475/whats-the-difference-between-secured-and-preauthorize-in-spring-security-3) **(** [+](https://stackoverflow.com/questions/11841156/preauthorize-annotation-not-working-spring-security) **)**

1. База данных используется, по умолчанию, - H2
2. Доменный-слой AppUser.java расширяет Spring-ый (дефолтный-dao) 'UserDetails' для получения информации об пользователе (в контексте это 'Principial') из базы данных
3. DAO-слой: это Spring-ый 'JpaRepository' (по умолчанию)
4. Вся конфигурация секюрности описана в config/WebConfig.java (с помощью 'HttpSecurity')
5. Service-слой: расширяет Spring-ый (дефолтный-service) 'UserDetailsService' (для получения информации об пользователе, только используется наш Spring-ый 'JpaRepository'...)
6. Spring-ые 'RestController': доступ на каждый рест-метод (RequestMapping) здесь ограничивается через 'PreAuthorize'
```javascript
    @PreAuthorize("hasRole('ROLE_ADMIN')")
```

@PreAuthorize новее чем @Secured

    Более старые аннотации @Secured не позволяли использовать выражения. Начиная с Spring Security 3, предпочтительнее использовать более гибкие аннотации @PreAuthorize и @PostAuthorize (а также @PreFilter и @PostFilter)
    
    Аннотация @Secured ( "ROLE_ADMIN" ) такая же, как @PreAuthorize ( "hasRole ('ROLE_ADMIN')" ). @Secured ({ "ROLE_USER", "ROLE_ADMIN" ) считается ROLE_USER ИЛИ ROLE_ADMIN. поэтому вы не можете выразить условие И, используя @Secured. Вы можете определить то же самое с помощью @PreAuthorize ( "hasRole ('ADMIN OR hasRole (' USER ')" ), что проще Понимаю. Вы также можете выразить AND, OR или NOT (!).
    
```javascript
    @PreAuthorize ( "! isAnonymous() AND hasRole ('ADMIN')" )
```
