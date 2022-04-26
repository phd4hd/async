# Übungen

### Bitte zuerst ausprobieren, selbst auf die Lösung zu kommen, bevor Sie Hilfe im Lösungsordner suchen!

---

Bei allen Übungen soll ein synchronen Aufruf in einen asynchronen Aufruf umgewandelt werden. Der Lösungsansatz ist in den Demoprogrammen zu finden, aber es wurde eine zusätzliche Schwierigkeit mit eingebaut. Etwas Ausprobieren oder Recherchieren hilft. Notfalls kann man auch in der Lösung nachschauen...

## Übung 1

Die asynchrone Methode soll ein Array mit aufsteigenden Zahlen füllen. Die aufsteigenden Werte erhält es vom Hauptprogramm.

Es soll dem asynchronen Aufruf eine Variable übergeben werden. Das stellt normalerweise kein Problem dar. Diesmal jedoch ändert sich Variable innerhalb des Kontexts.

## Übung 2

Die asynchrone Methode erstellt das Array selbst, sortiert es und gibt es wieder zurück.
Das geschieht diesmal vor der Hauptschleife.
Es kann aber passieren, dass die Methode nicht so schnell arbeitet wie das Hauptprogamm.
Ist die Liste dann schon fertig?

## Übung 3

Die Erzeugung der ArrayListe wird wieder vom Hauptprogramm übernommen, ist jetzt lokal. Die Methode generiert Zufallszahlen, die dann vom Hauptprogramm in die Liste eingetragen werden sollen. Auch hier kann es zu merkwürdigen Nebeneffekten kommen, da jede Menge Threads Zahlen in die Liste eintragen können. Wie kann hier die Lösung lauten?
