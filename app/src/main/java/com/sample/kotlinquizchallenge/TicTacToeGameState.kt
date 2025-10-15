package com.sample.kotlinquizchallenge

/*
* Model a Tic Tac Toe game with board state and game status.
*
* // Input
* // X _ _
* // O X _
* // O _ X
* // Expected Output
* gameState.status → GameStatus.X_WINS
* gameState.currentPlayer → null (game ended)
* */

enum class Player {
    X, O
}

enum class GameStatus {
    IN_PROGRESS,
    X_WINS,
    O_WINS,
    DRAW
}

data class TicTacToeGameState(
    val board: Array<Array<Player?>>,
    val status: GameStatus,
    val currentPlayer: Player?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TicTacToeGameState

        if (!board.contentDeepEquals(other.board)) return false
        if (status != other.status) return false
        if (currentPlayer != other.currentPlayer) return false

        return true
    }

    override fun hashCode(): Int {
        var result = board.contentDeepHashCode()
        result = 31 * result + status.hashCode()
        result = 31 * result + (currentPlayer?.hashCode() ?: 0)
        return result
    }
}

class TicTacToeGame {
    fun createGameState(boardInput: List<String>): TicTacToeGameState? {
        // Validate input
        if (boardInput.size != 3) return null
        
        val board = Array(3) { arrayOfNulls<Player>(3) }
        var xCount = 0
        var oCount = 0
        
        // Parse board
        for (i in 0..2) {
            val row = boardInput[i].trim().split("\\s+".toRegex())
            if (row.size != 3) return null
            
            for (j in 0..2) {
                when (row[j]) {
                    "X" -> {
                        board[i][j] = Player.X
                        xCount++
                    }
                    "O" -> {
                        board[i][j] = Player.O
                        oCount++
                    }
                    "_" -> board[i][j] = null
                    else -> return null // Invalid character
                }
            }
        }
        
        // Validate move count (X goes first, so X count should be equal or +1)
        if (xCount < oCount || xCount > oCount + 1) return null
        
        // Check for winner
        val xWins = checkWinner(board, Player.X)
        val oWins = checkWinner(board, Player.O)
        
        // Validate game state (both can't win)
        if (xWins && oWins) return null
        
        // Determine game status and current player
        val status: GameStatus
        val currentPlayer: Player?
        
        when {
            xWins -> {
                status = GameStatus.X_WINS
                currentPlayer = null
            }
            oWins -> {
                status = GameStatus.O_WINS
                currentPlayer = null
            }
            isBoardFull(board) -> {
                status = GameStatus.DRAW
                currentPlayer = null
            }
            else -> {
                status = GameStatus.IN_PROGRESS
                currentPlayer = if (xCount == oCount) Player.X else Player.O
            }
        }
        
        return TicTacToeGameState(board, status, currentPlayer)
    }
    
    private fun checkWinner(board: Array<Array<Player?>>, player: Player): Boolean {
        // Check rows
        for (i in 0..2) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true
            }
        }
        
        // Check columns
        for (j in 0..2) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true
            }
        }
        
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true
        }
        
        return false
    }
    
    private fun isBoardFull(board: Array<Array<Player?>>): Boolean {
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] == null) return false
            }
        }
        return true
    }
}

fun main() {
    val game = TicTacToeGame()
    
    // Example from the comment
    val boardInput = listOf(
        "X _ _",
        "O X _",
        "O _ X"
    )
    
    val gameState = game.createGameState(boardInput)
    
    if (gameState != null) {
        println("gameState.status → ${gameState.status}")
        println("gameState.currentPlayer → ${gameState.currentPlayer}")
    } else {
        println("Invalid board input")
    }
}
