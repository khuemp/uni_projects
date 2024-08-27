.data
  	 .globl testWin
.text

# a0: die Spielfeldadresse
# a1: welcher Spieler auf Sieg geprueft werden soll 'X' oder 'O'
# return: 0, falls kein Sief, 1: falls Sieg
testWin:
row1:
	lb	$t1 0($a0)
	lb	$t2 1($a0)
	lb	$t3 2($a0)
	bne	$a1 $t1 row2
	bne	$a1 $t2 row2
	bne	$a1 $t3 row2
	b	win
row2:
	lb	$t1 3($a0)
	lb	$t2 4($a0)
	lb	$t3 5($a0)
	bne	$a1 $t1 row3
	bne	$a1 $t2 row3
	bne	$a1 $t3 row3
	b	win
row3:
	lb	$t1 6($a0)
	lb	$t2 7($a0)
	lb	$t3 8($a0)
	bne	$a1 $t1 column2
	bne	$a1 $t2 column1
	bne	$a1 $t3 column1
	b	win
column1:
	lb	$t1 0($a0)
	lb	$t2 3($a0)
	lb	$t3 6($a0)
	bne	$a1 $t1 column2
	bne	$a1 $t2 column2
	bne	$a1 $t3 column2
	b	win
column2:
	lb	$t1 1($a0)
	lb	$t2 4($a0)
	lb	$t3 7($a0)
	bne	$a1 $t1 column3
	bne	$a1 $t2 column3
	bne	$a1 $t3 column3
	b	win
column3:
	lb	$t1 2($a0)
	lb	$t2 5($a0)
	lb	$t3 8($a0)
	bne	$a1 $t1 square159
	bne	$a1 $t2 square159
	bne	$a1 $t3 square357
	b	win
square159:
	lb	$t1 0($a0)
	lb	$t2 4($a0)
	lb	$t3 8($a0)
	bne	$a1 $t1 square357
	bne	$a1 $t2 notwin
	bne	$a1 $t3 square357
	b	win
square357:
	lb	$t1 2($a0)
	lb	$t2 4($a0)
	lb	$t3 6($a0)
	bne	$a1 $t1 notwin
	bne	$a1 $t2 notwin
	bne	$a1 $t3 notwin
	b	win
win:
	li	$v0 1
	jr	$ra
notwin:
	li	$v0 0
  	jr      $ra