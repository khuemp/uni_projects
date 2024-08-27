.data
  .globl main

board:
  .byte 'X', 'X', 'X'
        'X', ' ', 'X'
        'X', 'X', ' '
redzone:
  .byte 0, 0, 0, 0
        
        

.text

main:
  li      $v0 1
  la      $a0 board
  addiu   $a1 $0 'O' 
  li      $a2 '2'
  li      $a3 '2'
  jal     takeTurn

  # test redzone
  # print 1 on exit
  li      $a0 1

  la      $t0 redzone
  lb      $t1 0($t0)
  bne     $t1 0 exit
  lb      $t1 1($t0)
  bne     $t1 0 exit
  lb      $t1 2($t0)
  bne     $t1 0 exit
  lb      $t1 3($t0)
  bne     $t1 0 exit

  # print 0 on exit
  li      $a0 0

exit:
  li      $v0 1
  syscall
  li      $v0 10
  syscall
