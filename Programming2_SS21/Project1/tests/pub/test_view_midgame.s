.data
  .globl main

board:
  .byte 'O', ' ', ' ',
        ' ', 'X', 'O',
        'O', ' ', 'X'

.text

main:
  la      $a0 board
  jal     drawBoard
  li      $v0 10
  syscall
