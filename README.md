# Secure Android WebView

[![Android CI](https://github.com/hampicorp/secure-android-webview/actions/workflows/ci.yml/badge.svg)](https://github.com/hampicorp/secure-android-webview/actions/workflows/ci.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

Минимальная Android-оболочка для готового адаптивного сайта. Проект показывает безопасную базовую конфигурацию WebView и может использоваться как техническая демонстрация перед разработкой конкретного приложения.

## Реализовано

- загрузка только по HTTPS;
- allow-list доверенного домена и его поддоменов;
- внешние ссылки открываются системным браузером;
- запрещены file/content access и mixed content;
- SSL-ошибки никогда не игнорируются;
- есть экран ошибки соединения и навигация кнопкой «Назад»;
- политика навигации покрыта unit-тестами;
- GitHub Actions собирает debug APK и запускает тесты.

## Настройка

В `app/build.gradle.kts` замените:

```kotlin
buildConfigField("String", "START_URL", "\"https://example.com/\"")
buildConfigField("String", "TRUSTED_HOST", "\"example.com\"")
```

Также измените `applicationId`, название приложения, цвета и иконки.

## Сборка

Откройте проект в актуальной Android Studio или выполните:

```bash
gradle testDebugUnitTest assembleDebug
```

## Границы решения

WebView не превращает сайт в полностью нативное приложение. Качество интерфейса зависит от мобильной версии сайта. Push-уведомления, загрузка файлов, камера, платежи и публикация в магазинах требуют отдельной реализации и проверки требований площадки.

Это демонстрационный проект без клиентского кода и закрытых данных.

## License

MIT
