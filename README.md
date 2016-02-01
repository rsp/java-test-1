java-test-1
===========
**Przedstawię tu jak testować programy w Javie, naprawiać w nich błędy, proponować i omawiać zmiany oraz współpracować z innymi nad wspólnym projektem używając serwisów takich jak GitHub, Gitter i Travis.**

To co pokażę jest bardzo proste, wymaga jedynie przeglądarki - nie trzeba mieć nawet Javy ani edytora tekstu - jednak każdy kto wykona poniższe czynności będzie miał wstępne pojęcie o systemach kontroli wersji, systemach ciągłej integracji oraz techniki test-driven development.

Wszystko to brzmi może trudno ale w rzeczywistości jest dość łatwe - w każdym razie jeśli ktoś umie obsługiwać Facebooka to i z tym sobie poradzi. A jeśli umie obsługiwać Worda i Excela to ma nawet zbyt wysokie kwalifikacje.

Przede wszystkim warto pamiętać, że niczego w ten sposób nie da się zepsuć. Pracujemy zawsze nad własną wersją i jeśli ktoś nie będzie chciał naszych zmian to w najgorszym wypadku ich nie przyjmie.

W tym projekcie chętnie przyjmę nawet szkodliwe zmiany, ponieważ dzięki temu będzie co naprawiać. :)

Wymagania
=========
Jedyne wymagania aby przejść poniższe kroki to:

1. dowolna przeglądarka
2. mgliste pojęcie o Javie

(Jeśli ktoś nie ma nawet mglistego pojęcia o Javie to zamiast programu niech w podobny sposób zmieni plik tekstowy [AUTHORS.md](AUTHORS.md) i dopisze tam siebie.)

Poza tym wystarczy wykonywać poniższe kroki.

Nie będzie nam potrzebne:

1. Git
2. Java
3. edytor tekstu
4. IDE

Konta i serwisy
===============
Potrzebne nam będą konta w następujących serwisach, wszystkie bezpłatne:

1. **GitHub** to miejsce, w którym będą wszystkie kody źródłowe, wersje, informacje o problemach itp.
2. **Gitter** to czat dotyczący tego projektu, na którym będą się pojawiać najważniejsze informacje.
3. **Travis** to system ciągłej integracji, który będzie za nas testował nasz kod.

Żeby zarejestrować się na GitHubie wystarczy podać email oraz wybrać login i hasło. Rejestracja w Gitterze i Travisie nie wymaga nawet tego - wystarczy kilka kliknięć a logowanie odbywa się automatycznie przez GitHub.

Na razie wystarczy nam rejestracja, nic więcej nie trzeba robić. Jeśli posiadasz już te konta to przejdź poniżej do części [**Projekt**](#projekt).

Rejestracja w GitHubie
----------------------
Jeśli nie masz konta na GitHubie to załóż je bezpłatnie na:

* https://github.com/join

Podaj email, wybierz login i hasło a nastepnie kliknij potwierdzający link w mailu, który dostaniesz.

Na stronie ustawień profilu można wgrać zdjęcie i podać imię ale nie jest to konieczne:

* https://github.com/settings/profile

Rejestracja w Gitterze
----------------------
Rejestracja na Gitterze wymaga trzech kliknięć:

1. wejdź na https://gitter.im/
2. kliknij "Sign up free with GitHub"
3. kliknij "Authorize application"

I to wszystko. Nie trzeba niczego wpisywać.

Rejestracja w Travisie
----------------------
Podobnie jak z Gitterem, wystarczą trzy kliknięcia:

1. wejdź na https://travis-ci.org/
2. kliknij "Sign Up"
3. kliknij "Authorize application"

Również niczego nie trzeba wpisywać.

Projekt
=======

Działanie programu
------------------
Nasz projekt to prosty program, który sumuje liczby:

* [Sumator.java](Sumator.java)

Metoda `sumuj()` bierze tablicę liczb całkowitych i zwraca ich sumę.

W metodzie `main()` sumowane są w ten sposbób liczby {0, 1, 2, 3} i wyświetlany jest wynik.

Uruchamianie programu
---------------------
Program kompilujemy za pomocą: `javac Sumator.java`
Uruchamiamy za pomocą: `java Sumator`

Wyświetla się 6 więc wygląda na to, że wszystko działa.

Jeśli ktoś nie ma Javy albo nie chce tego uruchamiać to musi uwierzyć na słowo. Jeśli ktoś chce sam to sprawdzić (potrzebna jest Java) to najnowszą wersję pliku Sumator.java można ściągnąć z:

* https://raw.githubusercontent.com/rsp/java-test-1/master/Sumator.java

a cały projekt jako ZIP można ściągnąć z:

* https://github.com/rsp/java-test-1/archive/master.zip

Działanie programu
------------------
Program wygląda jakby działał dobrze ale warto byłoby przetestować go na większej liczbie danych. Na razie prawidłowo sumuje nasze liczby od 0 do 3 i podaje 6 ale chcemy go przetestwoać na jeszcze jakichś innych liczbach, żeby mieć pewność, że jeśli w przyszłości zmienią nam się liczby do sumowania, to nadal będzie wszystko działać.

Testowanie
----------
Mamy więc dodatkową klasę Test w pliku [Test.java](Test.java), która sprawdza czy nasz sumator działa również dla innych danych.

(Celowo nie użyłem żadnego frameworka do testów, żeby pokazać, że w testach nie ma niczego magicznego. Wystarczy program, który zwróci błąd do systemu jeśli coś jest nie tak. Narzędzia takie jak JUnit czy TestNG mogą ułatwić nam testy ale nie są wcale konieczne.)

Możemy te testy uruchomić sami za pomocą komend:
```
javac Test.java
java Test
```
ale po co się męczyć. Może to za nas zrobić Travis i robić to przy każdej zmianie jakiej dokonamy w naszym projekcie. Najlepiej na czterech różnych wersjach Javy, co nam szkodzi. W tym celu mamy plik [.travis.yml](.travis.yml), w którym tłumaczymy Travisowi co ma uruchamiać i na jakich wersjach Javy.

Travis dzielnie odwala za nas całą robotę i wyniki najnowszych testów dostępne są zawsze na stronie:

* https://travis-ci.org/rsp/java-test-1

Ale niestety widać tam, że testy się nie powiodły.

Sprawdzając jeden z wyników:

* https://travis-ci.org/rsp/java-test-1/jobs/106233690

widzimy:
```
1 OK
2 ERROR!!!
3 OK
Niektore testy nie powiodly sie!
```

Wygląda na to, że drugi test się nie powiódł. Ale pierwszy i trzeci przebiegł dobrze. Dziwne. Co może być nie tak?

Naprawianie błędów
------------------
Wejdź na stronę pliku [Sumator.java](Sumator.java) i jeśli widzisz błąd to kliknij przycisk **Fork** w prawym górnym rogu strony. Utworzy to Twoją własną wersję tego projektu, którą możesz edytować przez stronę internetową. Jednak zanim dokonasz edycji to wejdź na swój profil w Travisie:

* https://travis-ci.org/profile

i kliknij przycisk **Sync account**. Na dole pojawi się Twoja wersja projektu java-test-1 na GitHubie. Włącz jej testowanie przełącznikiem z lewej strony nazwy i wróć na swoją stronę projektu na GitHubie. Otwórz swoją wersję pliku Sumator.java i kliknij ikonę ołówka nad kodem źródłowym. Zmień to co uważasz za stosowne i wciśnij przycisk **Commit changes** aby zapisać zmiany.

Koniecznie również w podobny sposób dopisz się do pliku AUTHORS.md jako współautor projektu.

Testowanie zmian
----------------
Nastepnie wejdź na stronę https://travis-ci.org/ i po chwili pasek obok testów zmieni się na żółty i wystartują od nowa testy dla najnowszych zmian. Gdy się zakończą to zobaczysz tam wyniki testów dla Twojej wersji projektu. Jeśli zobaczysz zielony pasek obok swoich testów to znaczy, że problem jest rozwiązany i można zaproponować zmianę w głównej wersji projektu. Jeśli pasek będzie czerwony to też możesz zaproponować zmiany - najwyżej inni to potem poprawią.

Proponowanie zmian
------------------
Wróć na stronę swojej wersji projektu na GitHubie i wciśnij przycisk **New pull request** aby zaproponować włączenie swoich zmian do głównej wersji. Wyświetli się podsumowanie dokonanych zmian i różne opcje, których nie trzeba zmieniać. Wciśnięcie przycisku **Create pull request** wyświetli miejsce na podanie tytułu i opisu proponowanych zmian i po wciśnięciu zielonego **Create pull request** poniżej opisu, propozycja zostanie wysłana. Travis ponownie wykona wszystkie testy i na stronie głównego projektu pod adresem:

* https://github.com/rsp/java-test-1/pulls

pojawi się informacja o nowej propozycji zmian a jego wlaściciel (czyli ja) będzie mógł je zatwierdzić lub odrzucić, przeglądając zmiany, komentarze do nich, wyniki testów itp. Każdy tam może obejrzeć proponowane zmiany i dodać swój komentarz.

Wszystkie istotne wydarzenia plus ewentualna dyskusja na czacie dostępne będą na Gitterze dla wszystkich zainteresowanych:

* https://gitter.im/rsp/java-test-1

Tak mniej więcej wygląda typowa współpraca na GitHubie.

Teraz czekam na Wasze pull requesty. :) Gdy ktoś mi naprawi ten błąd to postaram się dodać kolejny. ;)

Słowniczek pojęć
----------------
* **fork** - własna wersja cudzego projektu do dokonywania swoich zmian
* **pull request** - prośba o dodanie swoich zmian do głównej wersji projektu
* **issue** - jakiś problem lub propozycja dotycząca projektu zgłoszona na GitHubie

Zgłaszanie błędów
-----------------
Wszelkie błędy i propozycje nowych funkcjonalności zgłaszajcie na stronie:

* https://github.com/rsp/java-test-1/issues

Autor
-----
Rafał Pocztarski - [https://github.com/rsp](https://github.com/rsp)

Współautorzy
------------
Patrz: [AUTHORS](AUTHORS.md)

Licencja
--------
MIT License (Expat). Szczegóły w [LICENSE.md](LICENSE.md)
