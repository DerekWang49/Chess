# Chess Game

**Author**: Derek Wang  
**Email**: wan00923@umn.edu

## About This Project

This project started as a school assignment, where the task was to implement a basic chess game in Java. The core functionality includes basic chess piece movement and turn-based play.

However, I took the initiative to extend the project beyond the scope of the assignment by adding **additional features** that were not part of the original school requirements. These additions include:

- **En Passant**: A special chess move that allows a pawn to capture another pawn that has moved two squares forward from its starting position.
- **Castling**: A special move involving the king and rook to improve the king’s safety.
- **Checkmate Detection**: The game now detects when one king is checkmated, automatically ending the game.

These features were my own idea and were implemented to enhance the game's functionality, showcasing my ability to add complex logic to an existing project.


---

## Features

- **Full Chess Rules**: Supports all standard chess rules, including movement of pieces, check and checkmate.
- **Turn-based Play**: The game alternates between black and white players.
- **Illegal Move Handling**: If an illegal move is made, the board will be redisplayed and the player will be prompted again.
- **Support for Special Moves**: Includes support for **En Passant**, **Castling**, and **Checkmate**.
- **Console-based**: Simple text-based interaction for playing the game.

---


### Prerequisites

Ensure you have Java installed on your system.

- [Download and install Java](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html) (if not already installed).

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/chess-game.git
   ```
2. Navigate into the project directory:
   ```bash
   cd chess-game
   ```
3. Compile the Java files:
   ```bash
   javac Game.java
   ```
4. Run the game:
   ```bash
   java Game
   ```

## Acknowledgements

- The base functionality of this chess game was implemented as part of a school project.
- The **En Passant**, **Castling**, and **Checkmate** features were developed independently to enhance the game’s functionality and demonstrate my ability to extend projects with new logic.

