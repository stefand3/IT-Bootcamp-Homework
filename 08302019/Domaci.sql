-- 1. Zadatak -1. Ispisuje sve informacije koje postoje u bazi o drzavnim fakultetima
SELECT * 
FROM Fakultet
WHERE "Drzavni/Privatni" = 'D'

-- 2. Zadatak -2. Ispisuje samo imena svih privatnih fakulteta
SELECT Naziv
FROM Fakultet
WHERE "Drzavni/Privatni" = 'P'

-- 3. Zadatak -3. Ispisuje broj drzavnih fakulteta
SELECT COUNT(*)
FROM Fakultet
WHERE "Drzavni/Privatni" = 'D'

-- 4. Zadatak -4. Ispisuje prosecan broj studenata(AVG) 
SELECT AVG(BrojStudenata)
FROM Fakultet

-- 5. Zadatak -5. Ispisuje prosecan broj studenata(AVG) na drzavnim fakultetima
SELECT AVG(BrojStudenata)
FROM Fakultet
WHERE "Drzavni/Privatni" = 'D'

-- 6. Zadatak -6. Ispisuje sve gradove u kojima se nalaze fakulteti(ako se u nekom gradu nalazi vise fakulteta, ispisati taj grad samo jednom)
SELECT DISTINCT(Grad)
FROM Fakultet

-- 7. Zadatak -7. Ispisati ukupan broj studenata 
SELECT SUM(BrojStudenata)
FROM Fakultet

-- 8. Zadatak -8. Ispisati imana i prezimena svih studenata
SELECT Ime, Prezime
FROM Student

-- 9. Zadatak -9. Ispisati sve informacije o studentima 3. godine 
SELECT *
FROM Student
WHERE GodinaStudija = 3

-- 10. Zadatak -10. Ispisati studenta sa najvecim prosekom
SELECT   *, MAX(Prosek)
FROM Student

-- 11. Zadatak -11.  Ispisati studenta 3. godine sa najvecim prosekom
SELECT *, MAX(Prosek)
FROM Student
WHERE GodinaStudija = 3

-- 12. Zadatak -12. Ispisati srednju vrednost proseka studenata 4. godine
SELECT AVG(Prosek)
FROM Student
WHERE GodinaStudija = 4

-- 13. Zadatak -13. Ipisati srednju vrednost proseka muskih studenata
SELECT AVG(Prosek)
FROM Student
WHERE POL = 'M'

-- 14. Zadatak -14. Ispisati sve studente koji jos nisu polozili ni jedan predmet(oni koji nisu polozili ni jedan predmet imaju vrednost NULL za prosek)
SELECT *
FROM Student
WHERE Prosek IS NULL

-- 15. Zadatak -15. Ispisati sve studente koji su polozili bar jedan predmet(nemaju NULL za prosek)
SELECT *
FROM Student
WHERE Prosek IS NOT NULL

-- 15. Zadatak -15. Ispisati sve studente ciji prosek ocena je veci od srednje vrednosti proseka svih studenata
SELECT *, Prosek > AVG(Prosek)
FROM Student
