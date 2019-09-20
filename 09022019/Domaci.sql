--  1.

SELECT Odsek.Naziv, Count(*) as "Broj kurseva"
FROM Odsek, Kurs
WHERE Odsek.SifO = Kurs.SifO
GROUP BY Kurs.SifO
 
-- 2 
SELECT DISTINCT Kurs.Naziv, Count(*) as "Broj studenata" 
FROM Student, Pohadja, Raspored, Kurs
WHERE Student.SifS = Pohadja.SifS AND Pohadja.SifR = Raspored.SifR AND Raspored.sifk = Kurs.SifK 
GROUP BY Raspored.SifK
HAVING Raspored.SifK = 4 AND Count(*) > 2

-- 3. Ispisati srednji broj studenata na kursevima.
SELECT AVG(Raspored.BrPrijaveljenih)
FROM Raspored

-- 4. 
SELECT DISTINCT Kurs.Naziv
FROM Student, Pohadja, Kurs, Raspored
WHERE Student.SifS = Pohadja.SifS AND Pohadja.SifR = Raspored.SifR AND Raspored.sifk = Kurs.SifK AND Pohadja.SifS = 1

-- 5. 
SELECT DISTINCT Student.Ime, Count(*) as "Broj predmeta koje pohadja"
FROM Student, Pohadja, Kurs, Raspored
WHERE Student.SifS = Pohadja.SifS AND Pohadja.SifR = Raspored.SifR AND Raspored.Sifk = Kurs.SifK
GROUP BY Pohadja.SifS
HAVING Count(Pohadja.SifS) > 2

-- 6.
SELECT DISTINCT Student.Ime
FROM Student, Pohadja, Raspored, Ucionica
WHERE Student.SifS = Pohadja.SifS AND Pohadja.SifR = Raspored.SifR AND Raspored.SifR = Pohadja.SifR AND Raspored.SifU = 111 AND Raspored.Dan = 'Pon'

-- 7.
SELECT Kurs.Naziv, MAX(Raspored.BrPrijaveljenih)
FROM Kurs, Raspored, Profesor
WHERE Kurs.SifK = Raspored.SifK AND Raspored.SifP = Profesor.SifP AND Profesor.SifP = 7

-- 8.
SELECT Kurs.Naziv
FROM Kurs, Preduslov
WHERE Kurs.SifK = Preduslov.SifKP AND Preduslov.SifK = 4

-- 9. 
SELECT Kurs.Naziv, Count(*) as "Broj preduslov kurseva"
FROM Kurs, Preduslov
WHERE Kurs.SifK = Preduslov.SifK
GROUP BY Preduslov.SifK

-- 10.
SELECT DISTINCT Profesor.Ime, Raspored.BrPrijaveljenih as "Broj studenata"
FROM Student, Pohadja, Raspored, Profesor
WHERE Student.SifS = Pohadja.SifS AND Pohadja.SifR = Raspored.SifR AND Raspored.SifP = Profesor.SifP
GROUP BY Raspored.SifP
HAVING Raspored.Dan = 'Pon'