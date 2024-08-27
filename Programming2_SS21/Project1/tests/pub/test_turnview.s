.data
  .globl main

board:
  .byte ' ', 'X', ' ',
        'X', ' ', 'O',
        'O', ' ', 'X'

.text

main:
  # place 
  la      $a0 board
  li      $a1 'X'
  li      $a2 '2'
  li      $a3 '1'
  jal takeTurn

  # draw board
  la      $a0 board
  jal drawBoard

  # exit
  li $v0 10
  syscall
