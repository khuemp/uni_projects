.data
  .globl main

board:
  .byte 'O', 'O', 'X',
        ' ', 'O', ' ',
        'X', 'O', ' '
        
        

.text

main:
  li      $v0 42
  la      $a0 board
  addiu   $a1 $0 'X'
  jal     testWin

  move    $a0 $v0
  li      $v0 1
  syscall

  li      $v0 10
  syscall
