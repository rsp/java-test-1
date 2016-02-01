java-test-1
===========

Przedstawię tu jak testować programy w Javie, naprawiać w nich błędy, proponować i omawiać zmiany oraz współpracować z innymi nad wspólnym projektem używając serwisów takich jak GitHub, Gitter i Travis.

To co pokażę jest bardzo proste, wymaga jedynie przeglądarki - nie trzeba mieć nawet Javy - jednak każdy kto wykona poniższe czynności będzie miał wstępne pojęcie o systemach kontroli wersji, systemach ciągłej integracji oraz techniki test-driven development.

Wszystko to brzmi może trudno ale w rzeczywistości jest bardzo proste.

Wymagania
=========
Jedyne wymagania aby przejść poniższe kroki to:

1. dowolna przeglądarka
2. mgliste pojęcie o Javie

Poza tym wystarczy wykonywac poniższe kroki:

Konta i serwisy
===============
Potrzebne nam będą konta w następujących serwisach, wszystkie bezpłatne:

1. **GitHub** to miejsce, w którym będą wszystkie kody źródłowe, wersje, informacje o problemach itp.
2. **Gitter** to czat dotyczący tego projektu, na którym będą się pojawiać najważniejsze informacje.
3. **Travis** to system ciągłej integracji, który będzie za nas testował nasz kod.

Żeby zarejestrować się na GitHubie wystarczy podać email oraz wybrać login i hasło. Rejestracja w Gitterze i Travisie nie wymaga nawet tego - wystarczy kilka kliknięć a logowanie odbywa się automatycznie przez GitHub.

Na razie wystarczy nam rejestracja, nic więcej nie trzeba robić. Jeśli posiadasz już te konta to przejdź poniżej do części [Projekt](#projekt).

Rejestracja w GitHubie
----------------------
Jeśli nie masz konta na GitHubie to załóż je bezpłatnie na:

* https://github.com/join

Podaj email, wybierz login i hasło a nastepnie kliknij potwierdzający link w mailu, który dostaniesz.

Na stronie ustawień profilu można wgrać zdjęcie i podać imię i nazwisko ale nie jest to konieczne:

* https://github.com/settings/profile

Rejestracja w Gitterze
----------------------
Rejestracja na Gitterze wymaga trzech kliknięć:

1. wejdź na https://gitter.im/
2. kliknij "Sign up free with GitHub"
3. kliknij "Authorize application"

Nie trzeba niczego wpisywać.

Rejestracja w Travisie
----------------------
Podobnie jak z Gitterem, wystarczą trzy kliknięcia:

1. wejdź na https://travis-ci.org/
2. kliknij "Sign Up"
3. kliknij "Authorize application"

Również niczego nie trzeba wpisywać.

Projekt
=======
Nasz projekt to prosty program, który sumuje liczby:

* [Sumator.java](Sumator.java)

Metoda `sumuj()` bierze tablicę liczb cąłkowitych i zwraca ich sumę.

W metodzie `main()` sumowane w ten sposbób liczby {0, 1, 2, 3} i wyświetlany jest wynik.

Program kompilujemy za pomocą: `javac Sumator.java`

Uruchamiamy za pomocą: `java Sumator`

Wyświetla 6 więc wygląda na to, że wszystko działa.

Jeśli ktoś nie ma Javy albo nie chce tego uruchamiać to musi uwierzyć na słowo.

Jeśli ktoś chce sam to sprawdzić (potrzebna jest Java) to najnowszą wersję pliku z klasą można ściągnąć z:

https://raw.githubusercontent.com/rsp/java-test-1/master/Sumator.java

a cały projekt jako ZIP można ściągnąć z:

https://github.com/rsp/java-test-1/archive/master.zip

Program wygląda jakby działał dobrze ale warto byłoby przetestować go na większej liczbie danych. Na razie prawidłowo sumuje nasze liczby od 0 do 3 i podaje 6 ale chcemy go przetestwoać na jeszcze jakichś innych liczbach, żeby mieć pewność, że jeśli w przyszłości zmienia nam się liczby do sumowania, to nadal będzie wszystko działać.

Mamy więc dodatkową klasę Test w pliku [Test.java](Test.java), która sprawdza nasz sumator działa również dla innych danych.

(Celowo nie użyłem żadnego frameworka do testów, żeby pokazać, że w testach nie ma niczego magicznego. Wystarczy program, który zwróci błąd do systemu jeśli coś jest nie tak. Narzędzia takie jak JUnit czy TestNG mogą ułatwić nam testy ale nie są wcale konieczne.)

Możemy te testy uruchomić sami za pomocą komend:
```
javac Test.java
java Test
```
ale po co się męczyć. Może to za nas zrobić Travis i robić to przy każdej zmianie jakiej dokonamy w naszym projekcie.


... (praca w toku...)




Issues
------
For any bug reports or feature requests please
[post an issue on GitHub](https://github.com/rsp/node-hapi-helpers/issues).

Author
------
Rafał Pocztarski - [https://github.com/rsp](https://github.com/rsp)

License
-------
MIT License (Expat). See [LICENSE.md](LICENSE.md) for details.
