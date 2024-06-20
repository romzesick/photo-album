# PhotoAlbum

PhotoAlbum to aplikacja na Androida zorganizowana w architekturze MVVM (Model-View-ViewModel), która pozwala użytkownikom tworzyć, przechowywać i zarządzać swoimi zdjęciami. Aplikacja korzysta z bazy danych Room do przechowywania danych i zapewnia wygodny interfejs do interakcji z nimi.

## Architektura

Architektura aplikacji opiera się na wzorcu MVVM, który rozdziela odpowiedzialność pomiędzy różne komponenty aplikacji, co upraszcza jej utrzymanie i testowanie:

1. **Model**:
    - Zawiera logikę biznesową i dane.
    - Obejmuje klasy i interfejsy opisujące encje bazy danych oraz metody dostępu do nich (`MyImages`, `MyImagesDao`, `MyImagesDatabase`).

2. **View**:
    - Odpowiada za wyświetlanie danych i interakcję z użytkownikiem.
    - Obejmuje aktywności i fragmenty, które wyświetlają obrazy.

3. **ViewModel**:
    - Zarządza danymi dla UI i współpracuje z modelem.
    - Obejmuje `MyImagesViewModel`, który przetwarza dane i udostępnia je View, a także zapewnia logikę biznesową.

## Uczestniki
Raman Harbatski 41380, Alexandr Godlevskiy 40251,Danilo Sadovy 41262