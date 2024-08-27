.data
  .globl main

board:
  .byte 'O', 'O', 'X',
        ' ', 'X', ' ',
        'X', ' ', ' '
        
        

.text

main:
  la      $a0 board
  addiu   $a1 $0 'X'
  jal     testWin

  move    $a0 $v0
  li      $v0 1
  syscall

  li      $v0 10
  syscall
