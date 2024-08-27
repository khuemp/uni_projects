.data
  .globl main

board:
  .byte ' ', 'X', ' ',
        'X', 'O', 'O',
        'O', ' ', 'X'

.text

main:
  # place 
  la      $a0 board
  li      $a1 'O'
  li      $a2 '0'
  li      $a3 '2'
  jal takeTurn

  # test for win
  la      $a0 board
  li      $a1 'O'
  jal testWin

  # pring testWin ret
  move    $a0 $v0
  li      $v0 1
  syscall

  # exit
  li $v0 10
  syscall
