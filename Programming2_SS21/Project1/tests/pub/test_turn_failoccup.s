.data
  .globl main

board:
  .byte ' ', ' ', ' ',
        ' ', 'O', ' ',
        ' ', ' ', ' '
        
        

.text

main:
  la      $a0 board
  li      $a1 'X' 
  li      $a2 '1'
  li      $a3 '1'
  jal     takeTurn

  move    $a0 $v0
  li      $v0 1
  syscall

  li      $v0 10
  syscall
