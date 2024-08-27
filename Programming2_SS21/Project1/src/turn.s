.data
  	.globl takeTurn

.text
# - Argumente -
# a0: erste Spielfeldadresse
# a1: ASCII Zeichen des aktuellen Spielers
# a2: ASCII Zeichen der Zeile
# a3: ASCII Zeichen der Spalte
# - Verhalten -
# Setzt das Zeichen des Spielers in $a1 auf die Position Zeile $a2, Spalte $a3, falls dies ein gueltiger Zug ist
# - Rueckgabe -
# Ist der eingegebene Zug ungueltig, wird 1 zurueckgegeben. Das Spielfeld bleibt unveraendert.
# Ist der Zug gueltig, wird 0 zurueckgegeben
#
takeTurn:
#to be able to compare a1,a2 and check if the square is empty or not
	li	$t5 '0'
	li	$t1 '1'
	li	$t2 '2'
	li	$t3 ' '
row0:
  	bne	$a2 $t5 row1
square1:
  	bne	$a3 $t5 square2
  	lb	$t4 0($a0)
  	bne	$t3 $t4 ungultig
  	sb	$a1 0($a0)
  	b	gultig
square2:
  	bne	$a3 $t1 square3
  	lb	$t4 1($a0)
  	bne	$t3 $t4 ungultig
  	sb	$a1 1($a0)
  	b	gultig
square3: 	
  	bne	$a3 $t2 ungultig
  	lb	$t4 2($a0)
  	bne	$t3 $t4 ungultig
  	sb	$a1 2($a0)
  	b	gultig
row1:	
  	bne	$a2 $t1 row2
square4:  	
  	bne	$a3 $t5 square5
  	lb	$t4 3($a0)
  	bne	$t3 $t4 ungultig
  	sb	$a1 3($a0)
  	b	gultig
square5:  	
  	bne	$a3 $t1 square6
    	lb	$t4 4($a0)
  	bne	$t3 $t4 ungultig
  	sb	$a1 4($a0)
  	b	gultig
square6:	
  	bne	$a3 $t2 ungultig
   	lb	$t4 5($a0)
  	bne	$t3 $t4 ungultig
  	sb	$a1 5($a0)
  	b	gultig
row2:  	
  	bne	$a2 $t2 ungultig
square7: 	
  	bne	$a3 $t5 square8
  	lb	$t4 6($a0)
  	bne	$t3 $t4 ungultig
   	sb	$a1 6($a0)
  	b	gultig
square8: 	
  	bne	$a3 $t1 square9
   	lb	$t4 7($a0)
  	bne	$t3 $t4 ungultig
  	sb	$a1 7($a0)
  	b	gultig
square9:	
  	bne	$a3 $t2 ungultig
   	lb	$t4 8($a0)
  	bne	$t3 $t4 ungultig
  	sb	$a1 8($a0)
  	b	gultig
  	
 ungultig:
 	li	$v0 1	
 	jr	$ra
 gultig:
 	li	$v0 0
  	jr 	$ra
