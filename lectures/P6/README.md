# Predavanje 6 – Izračun napojnice (Tip Calculator)

Ovo predavanje obrađuje koncept **stanja (state)** i **rekompozicije** u Jetpack Compose-u  
kroz primjer aplikacije koja izračunava **napojnicu (tip)** na osnovu unesenog iznosa računa.

---

## Struktura

U ovom folderu se nalaze dva projekta:

- **P6starter/** – početna verzija aplikacije, bez dodatnih proširenja.
- **P6solution/** – kompletno riješen primjer sa svim funkcionalnostima sa predavanja.

---

## Ciljevi predavanja

Studenti će nakon ovog primjera znati:

- Kreirati i upravljati **state varijablama** pomoću `remember` i `mutableStateOf`
- Koristiti **TextField**, **Button** i **Text** komponente u Jetpack Compose-u
- Razumjeti proces **rekompozicije** u Compose-u

---

## Dodatni zadatak (proširenje primjera)

Proširite aplikaciju tako da korisnik može unijeti **koliko osoba dijeli račun**.  
Na osnovu toga aplikacija treba izračunati **koliko svaka osoba treba da plati**,  
uključujući napojnicu.

### Nove komponente
- Dodajte **još jedan `TextField`** za unos broja osoba (npr. "Broj osoba")
- Validirajte unos (ako je prazno, to znači da je default vrijednost 1)


### Prikaz rezultata
Na ekranu ispišite nešto poput:
Ukupna napojnica: 3,50 KM
Ukupan račun: 23,50 KM
Po osobi: 7,83 KM