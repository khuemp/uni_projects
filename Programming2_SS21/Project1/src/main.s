.data
 
board:
  # das Spielfeld (board) im Initialzustand
  .byte ' ', ' ', ' ',
        ' ', ' ', ' ',
        ' ', ' ', ' '

msgPrompt:
  # Text, der vor der Zugeingabe ausgegeben wird
  .asciiz ">"

msgInvalidMove:
  # Text, der als Reaktion auf einen ungueltigen Zug ausgegebwn wird
  .asciiz "Ungueltige Eingabe!\n"
  
greeterstr:
  # Willkommenstext
  .asciiz "--- Tic Tac Toe ---\n"

msgVictory:
  # Text, der bei einem Sieg ausgegeben wird
  .asciiz "  hat gewonnen!\n"

msgDraw:
  # Text, der bei einem Untenschieden ausgegeben wird
  .asciiz "Unentschieden -.-"


.text
  .globl main

# main markiert den Einstiegspunkt in das Programm
main:
  # Willkommenstext anzeigen
  la    $a0 greeterstr
  li    $v0 4
  syscall
  
  # Initialialen Spielzustand herstellen
  li    $s0 'X'   # aktiver Spieler
  li    $s1 'O'   # passiver Spieler
  li    $s2  9    # Anzahl an Zuegen bis unentschieden abgebrochen wird

  # Initiales Board ausgeben
  la  $a0 board
  jal drawBoard


gameloop: # Ruecksprungmarke fuer die Zugschleife


inputLoop: # Ruecksprungsmarks fuer die Eingabeschleife
  # Wir springen zu inputLoop zurueck, wenn der Spieler einen ungueltigen Zug eingegeben hat
  
  # Prompttext ausgeben
  la     $a0 msgPrompt
  li     $v0 4
  syscall

  # lese den Zug
  # Zeile (t0)
  li     $v0 12
  syscall
  move   $s3 $v0

  # Spalte (t1)
  li     $v0 12
  syscall
  move   $s4 $v0

  # Einen gueltigen Spielzug abfragen
  la     $a0 board
  move   $a1 $s0
  move   $a2 $s3
  move   $a3 $s4
  jal    takeTurn
  
  # Zeilenumbruch nach der Eingabe
  move   $t0 $v0
  li     $a0 '\n'
  li     $v0 11
  syscall
  
  # War der Spielzug erfolgreich?
  beq    $t0 0 move_ok
  # Wenn nicht, Text fuer ungueltigen Zug ausgeben
  la     $a0 msgInvalidMove
  li     $v0 4
  syscall
  
  # Erneut versuchen einen Zug abzufragen
  b      inputLoop


# Der Spieler mit dem Zeichen s0 hat einen gueltigen Zug durchgefuehrt
# Wir geben das Feld nach dem Zug aus und testen auf Sieg
move_ok:
  # Zeige das aktuelle Spielfeld
  la     $a0 board
  jal    drawBoard

  # Siegbedingung pruefen
  la     $a0 board
  move   $a1 $s0
  jal    testWin
  beq    $v0 1 end_victory

  # Gehe zum naechsten Spieler ueber
  # Wir tauschen $s0 mit $s1: der passive Spieler wird der aktive Spieler und umgekehrt
  move   $t0 $s1
  move   $s1 $s0
  move   $s0 $t0

  # Test auf untentschieden: 9 Zuege ohne Sieg
  addiu  $s2 $s2 -1
  bne    $s2 0 gameloop # zurueck zum Anfang der Zugschleife 

  b      end_draw


end_draw:
  # Das Spiel endet unentschieden
  li     $v0 4
  la     $a0 msgDraw
  syscall
  b exit

end_victory:
  # Das Spiel endet mit dem Sieg von Spieler s0
  la     $a0 msgVictory
  sb     $s0 0($a0)
  li     $v0 4
  syscall
  b exit

exit:
  # Beende das Programm
  li     $v0 10
  syscall