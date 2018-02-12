[Spring REST API + OAuth2 + AngularJS](http://www.baeldung.com/rest-api-spring-oauth2-angularjs)

---

1. spring-security-oauth-server >> AuthorizationServerApplication [port=8081]
2. spring-security-oauth-resource >> ResourceServerApplication [port=8082]
3. (angularjs) spring-security-oauth-ui-password >> UiApplication [port=8084] 
```bash
netstat -na | find "808"
```
>> Login: user1 | Password: pass
>> Login: admin | Password: nimda
>> Login: john | Password: 123
>> Login: tom | Password: 111

?. spring-security-oauth-ui-implicit >> UiApplication [port=8083]


---


## Spring Security OAuth

Если вы уже участвовали в 'Learn Spring Security' тогда вы можете начать погружение глубже в 'OAuth2' с помощью модуля 10, а затем модулей 12, 13 и модуля 17.
Если вы еще не студент тогда вы можете получить доступ к курсу здесь: http://bit.ly/github-lss



## Build the Project

```bash
mvn clean install
```



## Projects/Modules

Этот проект содержит несколько модулей но здесь основные из них следует сосредоточить и запустить:
- `spring-security-oauth-server` - сервер авторизации (port = 8081)
- `spring-security-oauth-resource` - сервер ресурсов (port = 8082)

И в зависимости от типа гранта который вы хотите попробовать вы будете работать с одним из этих пользовательских интерфейсов / клиентов:  
- `angularjs/spring-security-oauth-ui-implicit` (port = 8083)
- `angularjs/spring-security-oauth-ui-password` (port = 8084)

Другие модули: 
- `spring-security-5-oauth-resource` - другая версия ресурсов сервера
- `spring-security-oauth-ui-implicit-angular4` - другая версия модуля пользовательского интерфейса Implicit Grant - используется Angular.4
- `spring-security-oauth-ui-password-angular4` - еще одна версия модуля пользовательского интерфейса Password Grant - используется Angular.4

Наконец вы можете игнорировать все остальные модули.



## Run the Modules

Вы можете запустить любой подмодуль с помощью командной строки:
```bash
mvn spring-boot:run
```

Если вы используете Spring STS вы также можете импортировать их и запускать их напрямую используя панель инструментов загрузки
Затем вы можете получить доступ к приложению пользовательского интерфейса - например к модулю с помощью Password Grant: `http://localhost:8084/`



## Run the Angular 4 Modules

Чтобы запустить любой из интерфейсных модулей Angular.4 (_spring-security-oauth-ui-implicit-angular4_ и _spring-security-oauth-ui-password-angular4_) нам нужно сначала создать приложение:
```bash
mvn clean install
```

Затем нам нужно перейти к нашему каталогу с Angular-приложением:
```bash
cd src/main/resources
```

Наконец, мы начнем наше приложение:
```bash
npm start
```
Примечание: модули Angular.4 закомментированы, потому что они не основываются на Jenkins поскольку они нуждаются в `npm` но локально они правильно собираются



## Relevant Articles:

- [Spring REST API + OAuth2 + AngularJS](http://www.baeldung.com/rest-api-spring-oauth2-angularjs)
- [Using JWT with Spring Security OAuth](http://www.baeldung.com/spring-security-oauth-jwt)
- [OAuth2 for a Spring REST API – Handle the Refresh Token in AngularJS](http://www.baeldung.com/spring-security-oauth2-refresh-token-angular-js)
- [Spring Security OAuth2 – Simple Token Revocation](http://www.baeldung.com/spring-security-oauth-revoke-tokens)
- [OAuth2.0 and Dynamic Client Registration](http://www.baeldung.com/spring-security-oauth-dynamic-client-registration)
- [Testing an OAuth Secured API with the Spring MVC Test Support](http://www.baeldung.com/oauth-api-testing-with-spring-mvc)
- [Logout in a OAuth Secured Application](http://www.baeldung.com/logout-spring-security-oauth)
- [OAuth2 Remember Me with Refresh Token](http://www.baeldung.com/spring-security-oauth2-remember-me)
- [Angular 4 Upgrade for Spring Security OAuth](http://www.baeldung.com/angular-4-upgrade-for-spring-security-oauth)

* ['ng' не распознается как внутренняя или внешняя команда](http://qaru.site/questions/177147/ng-is-not-recognized-as-an-internal-or-external-command)
```bash
npm uninstall -g @angular/cli
npm cache clean
npm install -g @angular/cli@latest
```
* [Angular 2: angular-cli](https://javahero.ru/angular-2-angular-cli)
* [Первое Angular 2 веб приложение: начало работы](https://javahero.ru/первое-angular-2-веб-приложение-начало-работ-2)
* [Angular. JavaHero.roadmap()](https://javahero.ru/angular-javahero-roadmap)

* [Пишем API на NodeJS - #4 - Подключение базы данных к express](https://www.youtube.com/watch?v=BmPUqg8A4PM)
* [Быстрый старт за 5 минут с Angular 2 beta](https://habrahabr.ru/post/273545)
