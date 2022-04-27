# Demos

## Demo 1
Synchroner Methodenaufruf. Das Hauptprogramm führt eine Zählschleife mit 100 Durchgängen durch und nach der Hälfte der Durchgänge wird die Methode aufgerufen, die etwas ähnliches macht. Dabei wird die Abarbeitung des Hauptprogramms angehalten und dann die Methode ausgeführt. Nach Beendigung der Methode wird das Hauptprogramm an der Stelle fortgesetzt, wo es für den Aufruf in die Methode angehalten worden ist.

## Demo 2
Asynchroner Methodenaufruf. Dazu muss ein zusätzlicher Thread gestartet werden. Hauptprogramm und Methode führen eine Zählschleife mit 100 Durchgängen durch, jedoch kann das Hauptprogramm weiterarbeiten, nachdem nach der Hälfte der Durchgänge die Methode asynchron gestartet worden ist, d.h. das Ergebnis der Methode wurde diesmal nicht abgewartet. Das Programm ist dadurch schneller fertig als Demo 1.

## Demo 3
Ein synchroner Methodenaufruf, obwohl ein zusätzlicher Thread gestartet worden ist. Nach dem Aufruf der Methode wartet das Hauptprogramm, bis der neue Thread die Methode vollständig abgearbeitet hat und setzt erst dann wieder seine Schleife fort. Das Programm ist genauso langsam wie Demo 1.

## Demo 4
Asynchroner Methodenaufruf. Jetzt hat jedoch die Methode einen Rückgabewert. Es wird versucht, über einen gemeinsamen Speicher (sharedString) das Ergebnis vom Thread ins Hauptprogramm zu transferieren. Dabei kommt es jedoch zu einer Wettlaufsituation (Race Condition) und man erhält entweder "Erfolg" oder "null" als Ergebnis.

## Demo 5
Asynchroner Methodenaufruf mit einem Future. Der Thread wird über einen Executor gestartet, welcher z.B. auch Thread Pools unterstützt. Das Future enthält das Ergebnis, liefert aber vor allem den Status des Threads. So lässt sich warten (aktives Warten = Polling), bis das Ergebnis wirklich vorliegt (isDone) und kann dann das Ergebnis ohne Probleme abfragen.

## Demo 6
Asynchroner Methodenaufruf mit einem CompletableFuture. Das ist eine Erweiterung eines normalen Future (siehe Demo 5), weil nach Beendigung der Methode und des Threads eine Verkettung stattfinden kann, eine sogenannte Callback Methode wird automatisch aufgerufen. 
