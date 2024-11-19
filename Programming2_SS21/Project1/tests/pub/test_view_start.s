.data
  .globl main

board:
  .byte ' ', ' ', ' ',
        ' ', ' ', ' ',
        ' ', ' ', ' '

.text

main:
  la      $a0 board
  jal     drawBoard
  li      $v0 10
  syscall
