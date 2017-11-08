# Schritte zum eigenen Repository

## eigenes Repository erstellen
Erzeugen Sie auf HTWDD-RN ein eigenes **privates** Repository mit einem Namen entsprechend Ihrer S-Nummer in der Form `sXXXX-it2-beleg`. Fügen Sie als Kommentar Ihren **Namen** hinzu, um die Zuordnung zu erleichtern.

## eigenes Repository verknüpfen
Repository lokal klonen  
`git clone https://github.com/HTWDD-RN/RTSP-Streaming`

Wechsel in das angelegte lokale Repository  
`cd RTSP-Streaming`

Umbenennen des Alias des originalen Repositories     
`git remote rename origin htw-upstream`

Anlegen der Verknüpfung (origin) mit dem eigenen entfernten Repository  
`git remote add [alias] [url]`
`git remote add origin https://github.com/HTWDD-RN/sxxxxx-it2-beleg`

Aktualisierung des eigenen entfernten Repositories  
`git push origin master`

## Dateien für die Versionierung auswählen
Dateien im Arbeitsverzeichnis mit lokalem Repr. verknüpfen  
`git add [file]`
nur Java-Dateien im Arbeitsverzeichnis mit lokalem Repr. verknüpfen  
`git add *.java`

## Dateihandling
Es ist günstiger das Dateihandling mittels Git-Befehlen vorzunehmen, dann werden Änderungen im Dateisystem gleich erkannt.
* Datei löschen `git rm [file]`
* Datei nur im Index löschen `git rm --cached [file]`
* Datei verschieben `git mv [file-orig] [file-renamed]`

## lokalen Commit erzeugen
alle Änderungen an den versionierten Dateien ins lokale Repr. übergeben  
`git commit -a`  oder  `git commit -a -m "kurze Angabe der Änderungen"`

## lokales Repro mit entferntem Repro abgleichen
Änderungen des entfernten Repros ins lokale Repro übernehmen    
`git fetch [alias]`  z.B. `git fetch orign` 
Änderungen in lokalen Branch zusammenführen  `git merge [alias] [branch]`  
lokale Änderungen des Repros ins entfernte Repro übernehmen    
`git push [alias][branch]`  z.B. `git push orign master`


## Status
* Anzeige aller neuen oder geänderten Dateien `git status`
* Anzeige der Änderungen `git diff`
* Anzeige der verknüpften entfernten Repros  `git remote -v`
* Anzeige der Branches  `git branch -vv`
* Anzeige der Versionshistorie des aktuellen Branches `git log`
* Anzeige der Versionshistorie einer Datei `git log --follow [file]`
* Anzeige der Metadaten eines Commits `git show [commit]`

## Branches
Für neue Features einer Software eignen sich am Besten ein neuer Branch.
* Neuen Branch erstellen `git branch [branch-name]`
* Branch auschecken `git checkout [branch-name]`
* Branch mit aktuellen Branch zusammenführen `git merge [branch]`
* Branch löschen `git branch -d [branch-name]`

## Rücknahme von Änderungen
* Datei im Arbeitsbereich auf Zustand im Repro zurücketzen `git checkout -- [file]`
* Rücknahme aller commits nach [commit] (Arbeitsbereich bleibt unverändert) `git reset [commit]`
* Rücknahme aller Änderungen und Wechsel zu ang. Commit `git reset --hard [commit]`

## Zwischenspeicher
Manchmal will man schnell an einem anderen Branch arbeiten aber die geänderten Dateien noch nicht commiten.
Dazu eignet sich der Zwischenspeicher.
* Temoräre Speicherung `git stash`
* Holen der letzen Speicherung `git stash pop`
* Anzeigen des Speichers `git stash list`

## Arbeitserleichterung
Die globale Konfigurationsdatei der ignorierten Dateien befindet sich in `~/.gitignore`.
Hier können alle unerwünschten Dateiendungen wie z.B. `*.class *.*~ *.out *.log bin/  tmp*` aufgelistet werden.

Die globale Konfiguration befindet sich in ~/.gitconfig  
* Konfiguration auflisten  `git config -l`
* Git-Usernamen  `git config --global url."https://yourusername@github.com".insteadOf "https://github.com"`
* Git-Passwort cachen  `git config --global credential.helper 'cache –timeout=5400'`

## GUI
Manchmal ist es sinnvoll, eventuelle Verzweigungen grafisch darzustellen. Hierfür werden zwei Tools bereitgestellt: `gitk` und `smartgit`.

## Hilfe
`git help`  
`git help befehl`

* Git-Übersicht (https://jan-krueger.net/wordpress/wp-content/uploads/2007/09/git-cheat-sheet.pdf)
* Das Git-Buch (kostenlos)  (http://gitbu.ch/)

Cheat Sheet
