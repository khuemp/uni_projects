.data
  .globl main

board:
  .byte 'X', 'X', 'X'
        'X', ' ', 'X'
        'X', 'X', 'X'
        
        

.text

main:
  li      $v0 1
  la      $a0 board
  addiu   $a1 $0 'O' 
  li      $a2 '1'
  li      $a3 '1'
  jal     takeTurn

  move    $a0 $v0
  li      $v0 1
  syscall

  li      $v0 10
  syscall
