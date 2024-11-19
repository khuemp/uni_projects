# Project Description
Encode the a following generalized Sudoku puzzle as CSP using the Z3 language fragment. ![alt text](image.png)The goal of this puzzle is to fill the empty cells in the board with numbers from 1 to 9 complying with the constraints listed below. We use ⟨i, j⟩ to denote the value of the cell with x = i and y = j.
1. Typical Sudoku constraints:

- Numbers cannot be repeated in any row, column, or 3x3 square.

- Cells whose values are already specified must be assigned to the respective values.

2. Top left 3 × 3 square: The numbers must comply with the arithmetic expressions
drawn in the figure:
- ⟨0, 0⟩ + ⟨1, 0⟩ = 8
- ⟨0, 1⟩ − ⟨1, 1⟩ = 6
- ⟨2, 2⟩/⟨2,1⟩ = 2

3. Top middle 3 × 3 square: The values of the green cells must be either all odd or all even. Moreover, if the green cells contain odd numbers, then the orange cell must contain an even number. If the green cells contain even numbers, then the orange cell must contain an odd number.

4. Top right 3 × 3 square: For every corner cell of this square, one of the horizontally or vertically adjacent cells must equal the value plus 1. When for example the cell ⟨6, 0⟩ = 4, then either ⟨7, 0⟩ = 5 or ⟨6, 1⟩ = 5.

5. Middle left 3 × 3 square: The sum of all rows in this square must be equal, i.e., ⟨0, 3⟩ + ⟨1, 3⟩ + ⟨2, 3⟩ = ⟨0, 4⟩ + ⟨1, 4⟩ + ⟨2, 4⟩ = ⟨0, 5⟩ + ⟨1, 5⟩ + ⟨2, 5⟩.

6. Center 3 × 3 square: Numbers must comply with the inequalities. More specifically:
- ⟨3, 3⟩ ⟨ ⟨3, 4⟩ ⟨ ⟨3, 5⟩
- ⟨4, 3⟩ ⟨ ⟨4, 4⟩ ⟨ ⟨4, 5⟩
- ⟨5, 3⟩ ⟨ ⟨5, 4⟩ ⟨ ⟨5, 5⟩

7. Bottom left 3 × 3 square: Multiplying the sums of the two indicated columns gives an odd number: (⟨0, 6⟩ + ⟨0, 7⟩+ ⟨0, 8⟩) × (⟨2, 6⟩ + ⟨2, 7⟩ + ⟨2, 8⟩) must be odd.

8. Bottom middle 3 × 3 square: The sum of the indicated cells must be equal to three times the value of the center cell. In other words: ⟨4, 6⟩ + ⟨3, 7⟩ + ⟨4, 8⟩ + ⟨5, 7⟩ = 3 × ⟨4, 7⟩.

9. Bottom right 3 × 3 square: at most one of the yellow cells may contain a value larger than 4.