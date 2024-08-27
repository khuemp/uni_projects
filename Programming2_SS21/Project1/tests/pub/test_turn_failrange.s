.data
  .globl main

board:
  .byte ' ', ' ', ' ',
        ' ', ' ', ' ',
        ' ', ' ', ' '
        ' ', ' ', ' '
        

.text

main:
  li      $v0 0

  la      $a0 board
  addiu   $a1 $0 'X' 
  li      $a2 '2'
  li      $a3 '3'
  jal     takeTurn

  move    $a0 $v0
  li      $v0 1
  syscall

  li      $v0 10
  syscall
