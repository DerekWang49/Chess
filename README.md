Project Author: Derek Wang, wan00923@umn.edu
Ensure that Bishop.java, Board.java, King.java, Knight.java, Pawn.Java, Piece.Java, Rook.java and Queen.Java
are all in the same directory as Game.java.
Navigate to the directory containing Game.java and type the command: "javac Game.java" if in Terminal
and then "java Game.java"
In IntelliJ, simply run the file. A chess board will appear and prompt the user
to make a move, depending on whose turn it is. The user needs to type the corresponding starting row, starting column,
ending row, and ending column for the starting and ending squares to make a move. The user plays both black and white,
and a prompt will show whose turn it is. If the move is illegal, the board
will be redisplayed and the user will again be prompted to make a legal move. The game ends when one of the kings
are captured. Currently, en passant and castling are not supported. An explanation of chess rules can be read here:
https://www.chess.com/learn-how-to-play-chess


- For implementing the toggling of boolean values: https://www.baeldung.com/java-toggle-boolean


“I certify that the information contained in this README
file is complete and accurate. I have both read and followed the course policies
in the ‘Academic Integrity - Course Policy’ section of the course syllabus.”
Derek Wang

UPDATE:
En Passant, Castling, and Checkmate are now supported
