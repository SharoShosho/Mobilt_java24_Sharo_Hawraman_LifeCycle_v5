# LifeCycle v.5 App - Användarguide

## Appbeskrivning
LifeCycle v.5 är en Android-app som demonstrerar en enkel inloggning med autentisering och en profilsida där användaren kan fylla i och spara personuppgifter. Appen sparar data mellan sessioner och har en användarvänlig design.

## Komma igång

### Inloggning
1. Öppna appen från appmenyn
2. Använd följande inloggningsuppgifter:
   - **Användarnamn:** `user123`
   - **Lösenord:** `password123`
3. Tryck på "Login"-knappen

### Använda profilsidan
1. Efter inloggning kommer du till profilsidan
2. Fyll i formuläret med dina uppgifter:
   - Fullständigt namn (textfält)
   - Ålder (siffror)
   - E-postadress (e-validering)
   - Telefonnummer
   - Kön (välj med radioknappar)
   - Körkort (kryssa i om du har det)
3. Tryck på "Spara profil" för att spara dina uppgifter

### Datasparande
- Din data sparas automatiskt när du:
  - Trycker på "Spara profil"
  - Lämnar appen (pausar)
  - Stänger appen
- När du öppnar appen nästa gång kommer din sparade data att finnas kvar

### Logga ut
1. Tryck på menyn (tre prickar) uppe till höger
2. Välj "Logga ut"
3. Du kommer åter till inloggningssidan

## Teknisk information

### Byggd med
- **Kotlin** - Programspråk
- **Android Studio** - Utvecklingsmiljö
- **SharedPreferences** - Datalagring
- **Material Design** - Användargränssnitt

### Appens funktioner
- ✅ Inloggning med hårdkodade uppgifter
- ✅ Formulär med 5 olika input-typer
- ✅ Automatisk datalagring
- ✅ Menynavigering
- ✅ Custom app-ikon
- ✅ Persistering mellan sessioner

##  Krav
- Android 8.0 (Oreo) eller högre
- Internetåtkomst krävs ej

##  Felsökning

### Glömt inloggningsuppgifter
- Användarnamn: `user123`
- Lösenord: `password123`

### Appen startar direkt på profilsidan
- Tryck på menyn och välj "Logga ut"
- Stäng appen helt och starta om den

### Data visas inte
- Kontrollera att du har tryckt på "Spara profil"
- Starta om appen för att ladda om sparad data

