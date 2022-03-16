# Filmopedia

<h1>Примерно накидал что-кого</h1>

<h3>Стек технологий который будем юзать:</h3>
<ul>
  <li>Spring boot</li>
  <li>Spring MVC</li>
  <li>Spring Security</li>
  <li>Hibernate</li>
  <li>HTML/CSS</li>
  <li>JavaScript</li>
  <li>Maven</li>
  <li>Git</li>
  <li>MySQL</li>
  <li>Thymeleaf</li>
  <li>JUnit5</li>
</ul>

<h3>Модели которые нам нужны(+-)</h3>
<table>
  <tr>
    <th>User</th>
    <th>Role</th>
    <th>Movie</th>
    <th>Serial</th>
    <th>Actor</th>
    <th>Producer</th>
    <th>Page</th>
    <th>Review</th>
  </tr>
  <tr>
     <th>id_user</th>
     <th>id_user</th>
     <th>id_movie</th>
     <th>id_serial</th>
     <th>id_actor</th>
     <th>id_producer</th>
     <th>title_page</th>
     <th>title_review</th>
  </tr>
  <tr>
     <th>name_user</th>
     <th>user</th>
     <th>title_movie</th>
     <th>title_serial</th>
     <th>name_actor</th>
     <th>name_producer</th>
     <th>body_page</th>
     <th>text_review</th>
  </tr>
  <tr>
     <th>lastName_user</th>
     <th>admin</th>
     <th>description_movie</th>
     <th>description_serial</th>
     <th>lastName_actor</th>
     <th>lastName_producer</th>
     <th>footer_page</th>
     <th>rating_review</th>
  </tr>
  <tr>
     <th>login</th>
     <th>-</th>
     <th>id_actor</th>
     <th>id_actor</th>
     <th>id_movie</th>
     <th>id_movie</th>
     <th>-</th>
     <th>-</th>
  </tr>
  <tr>
     <th>password</th>
     <th>-</th>
     <th>id_producer</th>
     <th>id_producer</th>
     <th>id_serial</th>
     <th>-</th>
     <th>-</th>
     <th>-</th>
  </tr>
</table>

<h3>Список связей</h3>
<ul>
<li>user - OneToOne - role</li>
<li>user - OneToMany - reviews</li>
<li>user - OneToOne - movie</li>
<li>user - OneToOne - serial</li>
<li>actor - ManyToMany - movie</li>
<li>actor - ManyToMany - serial</li>
<li>producer - OneToMany - movie</li>
<li>producer - OneToMany - serial</li>
<li>page - OneToOne - movie</li>
<li>page - OneToOne - serial</li>
<li>page - OneToOne - actor</li>
<li>page - OneToOne - producer</li>
</ul>  

<h2>Первый минимум</h2>
<ul>
  <li>Авторизация -> Model User (Hibernate connection + Валидирование формы + controller)</li>
  <li>Главная страница -> Model movie, review (1 фильм пример + mainPage.html + controller)</li>
  <li>Страница фильма -> Model movie, review (1 фильм пример + pageOfMovie.html + controller + ютуб)</li>
</ul>

![image](https://user-images.githubusercontent.com/49284213/156993714-307616fe-d974-495c-b6f4-2038acdc8668.png)


<h1>Примерные шаблоны страниц</h1>

<h2>1. страница - Форма авторизации</h2>

![1_Форма-авторизации](https://user-images.githubusercontent.com/49284213/156520744-52a2b9f7-8b1b-43cd-bc14-fa968943af2b.png)


<h2>2. страница - Форма регистрации</h2>

![2_Форма-регистрации](https://user-images.githubusercontent.com/49284213/156520860-b837b628-5b73-48d0-b705-32233bf4e15c.png)


<h2>3. страница - Личный кабинет</h2>

![3_Личный_кабинет](https://user-images.githubusercontent.com/49284213/156520940-e9f421d4-f326-412b-86b2-95ef1e1eaefb.png)


<h2>4. Страница - Главная страница</h2>
https://p.w3layouts.com/demos/pinball/web/#

![4_Главная_страница](https://user-images.githubusercontent.com/49284213/156520996-ab7c9c90-d484-44ab-b1db-d991a9ea8ded.png)


<h2>Блоки 4 страницы - <em>Блок рекомендации - Блок меню фильмы(в шапке) - Блок поиска</em></h2>

![4_1_Блок_рекомендации](https://user-images.githubusercontent.com/49284213/156521051-e6486091-c042-43f6-9f2c-97276f5bbaf3.png)


![4_2_Блок_меню_фильмы](https://user-images.githubusercontent.com/49284213/156521124-273ac20e-fc59-4494-82e1-6925933bf5b1.png)


![4_3_Блок_поиска](https://user-images.githubusercontent.com/49284213/156521134-04e5fef7-c1f3-4417-82b0-df924d49c678.png)


<h2>5. Страница актера/режиссера - Страница фильма/сериала</h2>

![5_1_Страница_актера_и_режиссера](https://user-images.githubusercontent.com/49284213/156521294-02516cf9-5403-41e3-aaee-5b072f2caa8c.png)


![5_Страница_фильма_сериала](https://user-images.githubusercontent.com/49284213/156521307-b727ac29-0cbb-4ada-b704-34d2ac8093b0.png)


<h2>6. Страница топ 100 фильмов/сериалов</h2>

![6_Страница_топ_100_фильмов_сериалов](https://user-images.githubusercontent.com/49284213/156521349-a31d8898-7308-4663-9a38-8bc5f4b05638.png)
