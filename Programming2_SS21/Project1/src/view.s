.data
  	.globl drawBoard
console_board:
	.byte 32,32,32,124,32,32,32,124,32,32,32 	#1st row
	.ascii "\n" 	#newline
	.byte 32,32,32,124,32,32,32,124,32,32,32 	#2nd row
	.ascii "\n" 	#newline
	.byte 45,45,45,124,45,45,45,124,45,45,45	#3rd row
	.ascii "\n" 	#newline
	.byte 32,32,32,124,32,32,32,124,32,32,32 	#4th row
	.ascii "\n" 	#newline
	.byte 45,45,45,124,45,45,45,124,45,45,45	#5th row
	.ascii "\n" 	#newline
	.byte 32,32,32,124,32,32,32,124,32,32,32 	#6th row
	.ascii "\n" 	#newline
	.byte 32,32,32,124,32,32,32,124,32,32,32 	#7th row
	#11 bytes each row
	#83 bytes in total
	 
.text
 # $a0  Spielfeldadresse
drawBoard:
	la	$a1 console_board
	
	lb	$t1 0($a0)
	lb	$t2 1($a0)
	lb	$t3 2($a0)
	lb	$t4 3($a0)
	lb	$t5 4($a0)
	lb	$t6 5($a0)
	lb	$t7 6($a0)
	lb	$t8 7($a0)
	lb	$t9 8($a0)
	
	sb	$t1 13($a1)
	sb	$t2 17($a1)
	sb	$t3 21($a1)
	sb	$t4 37($a1)
	sb	$t5 41($a1)
	sb	$t6 45($a1)
	sb	$t7 61($a1)
	sb	$t8 65($a1)
	sb	$t9 69($a1)
	
	move	$a0 $a1
	li	$v0 4
	syscall
  	jr 	$ra